//package itFest.swagger;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.cors.CorsConfiguration;
//
//@EnableWebSecurity
//public class SecurityConfig {
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .cors(cors -> {
//                    cors.configurationSource(request -> {
//                        var corsConfiguration = new CorsConfiguration();
//                        corsConfiguration.addAllowedOrigin("*");
//                        corsConfiguration.addAllowedMethod("*");
//                        corsConfiguration.addAllowedHeader("*");
//                        return corsConfiguration;
//                    });
//                })
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers(
//                                "/swagger-ui/**",
//                                "/v3/api-docs/**")
//                        .permitAll()
//                        .anyRequest()
//                        .authenticated()
//                )
//                .csrf(AbstractHttpConfigurer::disable);
//        return http.build();
//    }
//}
