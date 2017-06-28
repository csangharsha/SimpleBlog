package org.sangharsha.simpleblog.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author Sangharsha
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from user where username = ?")
                .authoritiesByUsernameQuery("select u.username, u.password, r.user_role from user_roles ur\n"
                        + "inner join user u on ur.user_id = u.id\n"
                        + "inner join roles r on ur.role_id = r.id where u.enabled = 1 and u.username=?");
//                .inMemoryAuthentication()
//                .withUser("testadmin").password("password").roles("USER", "ADMIN").and()
//                .withUser("testuser").password("password").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/test/**").hasAnyAuthority("USER","ADMIN")
                .and()
                .formLogin().loginPage("/login").failureUrl("/login?error")
                .usernameParameter("username")
                .passwordParameter("password");
//        http
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin();
    }
}