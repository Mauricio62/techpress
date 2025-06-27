package pe.com.techpress.ProjectTechPress.Config;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(auth -> auth.requestMatchers("/public/**", "/login", "/logout").permitAll()
                        .requestMatchers("/v1/home").authenticated()
                        .requestMatchers("/v1/admin").hasAuthority("ADMIN").anyRequest().authenticated()
                )
                //.httpBasic(Customizer.withDefaults())
                .formLogin(form -> form
                        .loginProcessingUrl("/login") //  URL que usa Angular para enviar credenciales
                        .successHandler((request, response, authentication) -> {
                            response.setStatus(200); // Evita redirección, solo responde 200
                        })
                        .failureHandler((request, response, exception) -> {
                            response.sendError(401, "Credenciales inválidas");
                        }))
                .logout(logout -> logout
                        .logoutUrl("/logout") // URL del logout
                        .logoutSuccessHandler((request, response, authentication) -> response.setStatus(HttpServletResponse.SC_OK))
                        .invalidateHttpSession(true) // Invalida la sesión
                        .clearAuthentication(true) // Limpia la autenticación
                )
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
