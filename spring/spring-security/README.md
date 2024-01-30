# Spring Security

Spring Security is a powerful and customizable authentication and access control framework for Java applications. It
provides a comprehensive set of security services for enterprise software applications, helping developers secure their
applications against various threats.

## Overview

### Basic Features

- **Authentication:** Spring Security supports various authentication mechanisms, including form-based, LDAP, and more.
  It facilitates user authentication against different providers, such as databases or external systems.

- **Authorization:** The framework enables developers to define fine-grained access control policies based on roles and
  permissions. This ensures that only authorized users can access specific resources and perform certain actions.

- **Customizable Security Configurations:** Spring Security allows developers to configure security settings through
  Java or XML configurations. This flexibility ensures that security configurations can be tailored to the specific
  requirements of the application.

- **Method-Level Security:** Developers can secure individual methods or classes by applying annotations, ensuring that
  only users with the required roles or permissions can execute specific operations.

### Core Knowledge

Understanding the core concepts of Spring Security is crucial for effective implementation:

- **SecurityContextHolder:** Holds the details of the present security context.

- **AuthenticationManager:** Manages the authentication process, typically by using authentication providers.

- **UserDetailsService:** Retrieves user details from a data store for authentication.

- **GrantedAuthority:** Represents a granted authority or privilege.

### Annotations

Spring Security leverages annotations to simplify the integration of security features:

- **@Secured:** Applied to methods or classes to enforce method-level security.

- **@PreAuthorize and @PostAuthorize:** Used to specify pre- or post-conditions for method execution, enhancing security
  at the method level.

- **@Secured, @RolesAllowed, and @PreAuthorize:** Enable developers to secure endpoints in Spring MVC applications
  easily.

Spring Security is configured using Java configuration or XML configuration.

Example Java configuration:

```java

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailService userDetailService)
            throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder)
                .and()
                .build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->
                        authorizationManagerRequestMatcherRegistry.requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")
                                .requestMatchers("/admin/panel/**").hasAnyRole("ADMIN")
                                .requestMatchers("/app/**").hasAnyRole("USER", "ADMIN")
                                .requestMatchers("/login/**").permitAll()
                                .anyRequest()
                                .authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }
}
```