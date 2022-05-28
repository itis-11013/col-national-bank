package ru.itis.sem_col.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.sem_col.security.OrganizationDetail;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    @Qualifier("myOrganizationDetailService")
    private OrganizationDetail myOrganizationDetail;

    @Autowired
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(myOrganizationDetail).passwordEncoder(passwordEncoder());
        auth.userDetailsService(myOrganizationDetail);

    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/list").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/").authenticated()
                //.antMatchers("/org").hasAnyAuthority("ADMIN")
                .anyRequest().authenticated();
        http.logout().logoutSuccessUrl("/");


        http.formLogin(/*withDefaults()*/)
                .loginPage("/login")
                .usernameParameter("name")
                .passwordParameter("password")
                .defaultSuccessUrl("/usercheck")
                .failureUrl("/login?error")
                .permitAll();

        //        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    }
}
