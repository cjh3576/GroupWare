package com.web.group.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.web.group.auth.AuthProvider;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	AuthProvider authProvider;
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
    @Override
	public void configure(WebSecurity web) throws Exception
	{
		// static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 )
		web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception{
		http.csrf().disable(); //개발할때만
		
		http.authorizeRequests()
		.antMatchers("/admin/**").authenticated() //인증된 사람만
		.antMatchers("/member/memberJoin").permitAll()
		.antMatchers("/member/login").permitAll() //모두 가능
		.antMatchers("/**").authenticated();
		
		http.formLogin()
		.loginPage("/member/login")
		.defaultSuccessUrl("/")
		.loginProcessingUrl("/member/auth")
		.failureUrl("/member/login")
		.usernameParameter("id")
		.passwordParameter("pw");
		
		http.logout()
		.logoutUrl("/member/logout")
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/")
		.invalidateHttpSession(true); //세션 무효화
		
		http.authenticationProvider(authProvider);
		//이 클래스로 인증함
	}
	

}
