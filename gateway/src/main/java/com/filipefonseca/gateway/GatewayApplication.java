package com.filipefonseca.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@EnableEurekaClient
@EnableConfigurationProperties({UriConfiguration.class})
@SpringBootApplication(scanBasePackages = {"com.filipefonseca"})
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder, UriConfiguration uriConfiguration) {
        String httpUri = uriConfiguration.getHttpbin();

        return builder.routes()
//                // Route 1
//                .route(p -> p
//                        .path("/get")
//                        .filters(f -> f.addRequestHeader("Hello", "World"))
//                        .uri(httpUri))
//
//                // Route 2
//                .route(p -> p
//                        .host("*.circuitbreaker.com")
//                        .filters(f -> f.circuitBreaker(config -> config
//                                .setName("mycmd")
//                                .setFallbackUri("forward:/fallback")))
//                        .uri(httpUri))

                // Product service.
                .route("product-service", predicate -> predicate
                        .path("/product/**")
                        .filters((filterSpec) -> filterSpec
                                .rewritePath("/product/?(?<segment>.*)", "/${segment}")
                        )
                        .uri("lb://product-service")
                )

                // Auth service.
                .route("auth-service", predicate -> predicate
                        .path("/auth/**")
//                        .filters(filter -> filter
//                                .rewritePath("/auth/?(?<segment>.*)", "/${segment}")
//                        )
                        .uri("lb://auth-service")
                )

                // Build routes.
                .build();
    }

    @RequestMapping("/fallback")
    public Mono<String> fallback() {
        return Mono.just("fallback");
    }
}


@ConfigurationProperties(prefix = "uri")
class UriConfiguration {
    private String httpbin = "http://httpbin.org:80";

    public String getHttpbin() {
        return httpbin;
    }

    public void setHttpbin(String httpbin) {
        this.httpbin = httpbin;
    }
}