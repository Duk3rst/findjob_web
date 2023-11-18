package com.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.entity.User;
import com.service.CustomUserDetailService;
import com.service.userService;


@Configuration
@EnableWebSecurity
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private CustomUserDetailService userDetailService;
	
	@Autowired
	private userService userservice;

	@Override
	protected void configure(HttpSecurity http) throws Exception {	
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/login", "/dangnhap","/register").permitAll()
            .antMatchers("/assets/**").permitAll()
			.anyRequest().authenticated()
			.and()
				.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/dangnhap")
				.successHandler(new AuthenticationSuccessHandler() {
					
					@Override
					public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
						Authentication authentication) throws IOException, ServletException {
						UserDetails userDetails = (UserDetails) authentication.getPrincipal();
						String username = userDetails.getUsername();
						System.out.println("The user " + username + " has logged in.");
						
						User logedInUser = userservice.findByEmail2(username);
						request.getSession(true).setAttribute("user", logedInUser);
						System.out.println("The user " + logedInUser);
										
						response.sendRedirect(request.getContextPath());
					}
				})
				.failureUrl("/login?error")
				.usernameParameter("email").passwordParameter("password")				
				.and()
				.logout().logoutSuccessUrl("/login?logout")       
				.and()
		        .sessionManagement().maximumSessions(1);			
					
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider());
	}

	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
    
    

}
