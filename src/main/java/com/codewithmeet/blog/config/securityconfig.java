

package com.codewithmeet.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.codewithmeet.blog.security.CustomeUserDetailService;

@Configuration
@EnableWebSecurity
@EnableWebMvc
public class securityconfig {

	@Autowired
	public CustomeUserDetailService customeUserDetailService;

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		.csrf((csrf) -> csrf.disable())
		.authorizeHttpRequests((authz) -> authz.anyRequest().authenticated());
		
		http.authenticationProvider(daoAuthenticationProvider());
		
		
		return http.build();
	}
	
	@Bean
	 AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception 
	{
		return configuration.getAuthenticationManager();
	}


	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider()
	{
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(this.customeUserDetailService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}

	

}
