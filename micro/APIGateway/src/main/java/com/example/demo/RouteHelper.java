package com.example.demo;

import java.util.Arrays;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class RouteHelper {
	
	@Bean
	CorsWebFilter corsWebFilter() {
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    CorsConfiguration config = new CorsConfiguration();
	    
	    config.setAllowCredentials(true);
	    config.setAllowedOrigins(Arrays.asList("http://localhost:3000")); // Ensure it matches your frontend URL
	    config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "PATCH","OPTIONS"));
	    config.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
	    config.setExposedHeaders(Arrays.asList("Authorization")); // Expose headers if needed
	    
	    source.registerCorsConfiguration("/**", config);

	    return new CorsWebFilter(source);
	}

	
	
	
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("SocialIssueManagementSystem",r->r.path("/api/areas/**")
					//.uri("http://localhost:8081"))
					  .uri("lb://SocialIssueManagementSystem"))
				.route("SocialIssueManagementSystem",r->r.path("/api/complaints/**")
					//.uri("http://localhost:8082"))
				    .uri("lb://SocialIssueManagementSystem"))
				.route("SocialIssueManagementSystem",r->r.path("/api/citizens/**")
						//.uri("http://localhost:8082"))
					    .uri("lb://SocialIssueManagementSystem"))
				.route("SocialIssueManagementSystem",r->r.path("/api/statuses/**")
						//.uri("http://localhost:8082"))
					    .uri("lb://SocialIssueManagementSystem"))
				.route("SocialIssueManagementSystem",r->r.path("/api/issues/**")
						//.uri("http://localhost:8082"))
					    .uri("lb://SocialIssueManagementSystem"))
				.route("SocialIssueManagementSystem",r->r.path("/api/roles/**")
						//.uri("http://localhost:8082"))
					    .uri("lb://SocialIssueManagementSystem"))
				.route("SocialIssueManagementSystem",r->r.path("/api/users/**")
						//.uri("http://localhost:8082"))
					    .uri("lb://SocialIssueManagementSystem"))
				.route("SocialIssueManagementSystem",r->r.path("/api/operators/**")
						//.uri("http://localhost:8082"))
					    .uri("lb://SocialIssueManagementSystem"))
				.route("SecondService",r->r.path("/api/user/**")
						//.uri("http://localhost:8082"))
					    .uri("lb://SecondService"))
				
				.route("OperatorService",r->r.path("/api/complaint/**")
						//.uri("http://localhost:8082"))
					    .uri("lb://OperatorService"))
				.route("OperatorService",r->r.path("/api/status/**")
						//.uri("http://localhost:8082"))
					    .uri("lb://OperatorService"))
				.route("OperatorService",r->r.path("/api/userz/**")
						//.uri("http://localhost:8082"))
					    .uri("lb://OperatorService"))
				.route("OperatorService",r->r.path("/api/operator/**")
						//.uri("http://localhost:8082"))
					    .uri("lb://OperatorService"))
				.route("dotservice2",r->r.path("/api/area/**")
						//.uri("http://localhost:8082"))
					    .uri("lb://dotservice2"))
				.route("dotservice2",r->r.path("/api/citizen/**")
						//.uri("http://localhost:8082"))
					    .uri("lb://dotservice2"))
				.route("dotservice2",r->r.path("/api/catagory/**")
						//.uri("http://localhost:8082"))
					    .uri("lb://dotservice2"))
				.route("dotservice2",r->r.path("/api/usser/**")
						//.uri("http://localhost:8082"))
					    .uri("lb://dotservice2"))
				.build();
		
	}

}
