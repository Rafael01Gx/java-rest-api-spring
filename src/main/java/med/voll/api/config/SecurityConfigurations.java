package med.voll.api.config;

import med.voll.api.filters.SecurityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(req-> {
                    req.requestMatchers("/login").permitAll();
                    req.requestMatchers("/v3/api-docs/**","/swagger-ui.html","/swagger-ui/**").permitAll();
                    req.anyRequest().authenticated();
                })
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}


//Ex:
//@Bean
//public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//    return http.csrf().disable()
//            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//            .and().authorizeHttpRequests()
//            .requestMatchers(HttpMethod.POST, "/login").permitAll()
//            .requestMatchers(HttpMethod.DELETE, "/medicos").hasRole("ADMIN")
//            .requestMatchers(HttpMethod.DELETE, "/pacientes").hasRole("ADMIN")
//            .anyRequest().authenticated()
//            .and().addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
//            .build();
//}

// OU

//@GetMapping("/{id}")
//@Secured("ROLE_ADMIN")
//public ResponseEntity detalhar(@PathVariable Long id) {
//    var medico = repository.getReferenceById(id);
//    return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
//}

//Por padrão esse recurso vem desabilitado no spring Security,
//sendo que para o utilizar devemos adicionar a seguinte anotação na classe Securityconfigurations do projeto:
//
//@EnableMethodSecurity(securedEnabled = true)