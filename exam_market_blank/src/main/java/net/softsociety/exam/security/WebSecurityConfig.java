package net.softsociety.exam.security;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security 설정
 */
@EnableWebSecurity
public class WebSecurityConfig {
    
    //설정
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
        .authorizeRequests()
        .antMatchers(
        		"/",
                "/image/**",
                "/css/**",
                "/js/**").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin()					
        .loginPage("/member/login")	
        .loginProcessingUrl("/member/login").permitAll()
        .usernameParameter("memberid")
        .passwordParameter("memberpw")
        .and()
        .logout()
        .logoutUrl("/member/logout")
        .logoutSuccessUrl("/").permitAll()
        .and()
        .cors();

        return http.build();
    }

    // 단방향 비밀번호 암호화
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
