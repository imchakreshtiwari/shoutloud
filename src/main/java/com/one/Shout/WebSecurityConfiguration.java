//package com.one.Shout;
//
//import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableOAuth2Sso
//public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
//   protected void configure(HttpSecurity http) throws Exception {
//      http
//         .csrf()
//         .disable()
//         .antMatcher("/**")
//         .authorizeRequests()
//         .antMatchers("/", "/login","/index.html")
//         .permitAll()
//         .anyRequest()
//         .authenticated();
//   }
//}
