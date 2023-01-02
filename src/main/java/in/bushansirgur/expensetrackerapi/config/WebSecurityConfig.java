package in.bushansirgur.expensetrackerapi.config;


import in.bushansirgur.expensetrackerapi.security.CustomUserDetailsService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws  Exception{
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/login","/register").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }
//    email,pw 인증처리
    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws  Exception{
//        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
//        UserDetails user1 = User.withUsername("bushan").password("12345").authorities("admin").build();
//        UserDetails user2 = User.withUsername("bharath").password("12345").authorities("user").build();
//
//        userDetailsManager.createUser(user1);
//        userDetailsManager.createUser(user2);

//        auth.userDetailsService(userDetailsManager);
        auth.userDetailsService(userDetailsService);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }


}
