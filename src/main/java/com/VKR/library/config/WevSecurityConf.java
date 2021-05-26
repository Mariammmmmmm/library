package com.VKR.library.config;

import com.VKR.library.models.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class WevSecurityConf extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
       // super.configure(http);
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.GET,"/book/**").hasAnyRole("ADMIN","USER")
                .antMatchers(HttpMethod.POST,"/book/**").hasAnyRole("ADMIN","USER")
                .antMatchers(HttpMethod.GET,"/profile").hasAnyRole("ADMIN","USER")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
       /*         .formLogin()
                .loginPage("/auth/login").permitAll()
                .defaultSuccessUrl("/");
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout", "POST"))
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("auth/login");*/
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.builder()
                .username("admin")
                .password(encoder().encode("admin"))
                .roles(Role.ADMIN.name())
                .build(),

                User.builder()
                .username("user1")
                .password(encoder().encode("user1"))
                .roles(Role.USER.name())
                .build()
        );
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder(12);
    }
}
