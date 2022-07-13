package com.sergio.eduardo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Autowired
	private Environment env;
	
	@Autowired
	private JwtTokenStore tokenStore;

	private static final String[] PUBLIC = { "/oauth/token", "/h2-console/**"};
	
	private static final String[] OPERATOR_OR_ADMIN = { };
	private static final String[] OPERATOR = { };	
	private static final String[] ADMIN = { "/users/**", "/encaminhamentoHospitalar/**", "/hospital/**", "/paciente/**" };		
		
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {

	if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
		http.headers().frameOptions().disable();
	}		
		
		http.authorizeRequests()
		
		.antMatchers(PUBLIC).permitAll()		
		.antMatchers(HttpMethod.POST, "/paciente/**").hasRole("OPERATOR")
		.antMatchers(HttpMethod.GET, "/paciente/**").hasRole("OPERATOR")
		.antMatchers(HttpMethod.PUT, "/paciente/**").hasRole("OPERATOR")		
				
		.antMatchers(OPERATOR_OR_ADMIN).hasAnyRole("OPERATOR", "ADMIN")
		.antMatchers(ADMIN).hasRole("ADMIN")
		.antMatchers(OPERATOR).hasRole("OPERATOR")				
		.anyRequest().authenticated();
	}	
}

