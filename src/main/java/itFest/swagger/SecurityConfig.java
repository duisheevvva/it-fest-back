package itFest.swagger;


//@EnableWebSecurity
public class SecurityConfig {
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
}