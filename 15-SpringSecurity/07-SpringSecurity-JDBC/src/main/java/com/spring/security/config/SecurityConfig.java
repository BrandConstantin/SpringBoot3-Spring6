package com.spring.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	// add a reference to our security data source
	@Autowired
	private DataSource securityDataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// ADD users in memory authentication
		/*UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
		.withUser(users.username("John").password("test123").roles("EMPLOYEE"))
		.withUser(users.username("Mary").password("test123").roles("EMPLOYEE","MANAGER"))
		.withUser(users.username("Susan").password("test123").roles("EMPLOYEE","ADMIN"));*/
		
		// use jdbc
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/").permitAll()			
			.antMatchers("/home/**").hasRole("EMPLOYEE")
			.antMatchers("/leaders/**").hasRole("MANAGER")
			.antMatchers("/systems/**").hasRole("ADMIN")
			.antMatchers("/resources/**").permitAll()
	        .anyRequest().authenticated()
			.and()
				.formLogin()
					.loginPage("/showLoginPage")
					.loginProcessingUrl("/authTheUser")
					.permitAll()
			.and()
				.exceptionHandling().accessDeniedPage("/access-denied")
			.and()
				.logout()
					.logoutSuccessUrl("/")  // after logout redirect to landing page (root)
					.permitAll();
	}
	
}
