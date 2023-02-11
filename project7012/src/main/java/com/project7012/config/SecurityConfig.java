/*
 * package com.project7012.config;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder;
 * 
 * import lombok.RequiredArgsConstructor;
 * 
 * @RequiredArgsConstructor
 * 
 * @Configuration public class SecurityConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Bean static PasswordEncoder passwordEncoder() { return new
 * BCryptPasswordEncoder(); }
 * 
 * // @Override // protected void configure(AuthenticationManagerBuilder auth)
 * throws Exception { //
 * auth.userDetailsService(userService).passwordEncoder(passwordEncoder()); // }
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * http.csrf().disable() .authorizeHttpRequests()
 * .antMatchers("/main").authenticated() .anyRequest().permitAll() .and()
 * .formLogin().loginPage("/login") .defaultSuccessUrl("/main")
 * .failureUrl("/login?error") .and() .logout() .logoutUrl("/logout")
 * .logoutSuccessUrl("/")
 * .invalidateHttpSession(true).deleteCookies("JSESSION"); } }
 */