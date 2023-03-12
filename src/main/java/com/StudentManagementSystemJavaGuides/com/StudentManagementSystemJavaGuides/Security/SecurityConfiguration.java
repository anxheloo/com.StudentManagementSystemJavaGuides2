package com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Security;


//import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.JWT.JwtRequestFilter;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.JWT.AuthenticationResponse;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.JWT.JwtRequestFilter;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {



    @Autowired
    JwtRequestFilter jwtRequestFilter;

    @Autowired
    UserRepository userRepository;



//    WAY 1 - We can Also use this way for custom user details
//    @Autowired
//    CustomUserDetailsService customUserDetailsService;

//    WAY - 2
//    @Bean
//    public UserDetailsService userDetailsService()
//    {
//        return new CustomUserDetailsService();
//    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        return username -> userRepository.findByEmail(username)
//                .orElseThrow( () -> new UsernameNotFoundException("User not found "));
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder()
//    {
//        return new BCryptPasswordEncoder();
//    }


//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception
//    {
//        return super.authenticationManagerBean();
//    }


//    @Bean
//    DaoAuthenticationProvider daoAuthenticationProvider()
//    {
//        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
//        return daoAuthenticationProvider;
//    }


//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        WAY 1 - Using UserDetailsService @Bean
//          auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());

//        WAY 2 - Using DaoAuthenticationProvider @Bean
//        auth.authenticationProvider(daoAuthenticationProvider());


//        WAY 3 - Using inMemoryAuthentication just for testing the app
//        String passwordEncodedUser = passwordEncoder().encode("user");
//        auth.inMemoryAuthentication().withUser("user").password(passwordEncoder().encode("user")).roles("User");
//        auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("admin")).roles("Admin");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","/registration/**","/login","/authenticate","/user/**").permitAll()
                .antMatchers("/helloAdmin").hasRole("Admin")
                .antMatchers("/helloUser").hasRole("User")
                .antMatchers("/students/**").hasRole("Admin")
                .antMatchers("/subjects/**").hasAnyRole("User","Admin")
                .and()
                .formLogin()
                .loginPage("/login")
                .and()
                .logout().logoutSuccessUrl("/login").permitAll()
                .and().exceptionHandling().accessDeniedPage("/access-denied");

//                http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//                http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);


//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/authenticate","/registration/**","/login").permitAll()
//                .antMatchers("/helloAdmin").hasRole("Admin")
//                .antMatchers("/helloUser").hasRole("User")
//                .antMatchers("/students/**","/s1/**").hasRole("Admin")
//                .antMatchers("/subjects/**","/s2/**").hasAnyRole("User","Admin")
//                .anyRequest().authenticated()
//                .and().exceptionHandling().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//

    }

//    @Bean
//    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception
//    {
//        authenticationManagerBuilder.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
//    }



}
