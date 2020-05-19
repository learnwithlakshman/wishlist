package com.lwl.wishlist;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("rajesh").password("{noop}rajesh").roles("USER")
		.and().withUser("lakshman").password("{noop}lakshman").roles("USER")
		.and()
		.withUser("admin").password("{noop}admin").roles("ADMIN");
	}
	
	

}
