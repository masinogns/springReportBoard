package kr.ac.jejun.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

import javax.sql.DataSource;

/**
 * Created by masinogns on 2017. 6. 7..
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    public static final String REMEBER_ME_KEY = "rlgnsqorKey";

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    DataSource dataSource;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/post/list").permitAll()
                .antMatchers("/post/detail").permitAll()
                .antMatchers("/post/**").hasRole("USER")
                .antMatchers("/**").permitAll();
        http.formLogin()
                .loginPage("/login").permitAll();

        http.rememberMe().key(REMEBER_ME_KEY).rememberMeServices(persistentTokenBasedRememberMeServices());

        // 403 페이지 핸들링
        http.exceptionHandling().accessDeniedPage("/403");
    }

    // 여기가 사용자를 기억하게 한 뒤 다시 접속했을 때 로그인 되있게
    @Bean
    public PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices(){
        PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices
                = new PersistentTokenBasedRememberMeServices(REMEBER_ME_KEY, userDetailsService, jdbcTokenRepository());
        return persistentTokenBasedRememberMeServices;
    }

    @Bean
    public JdbcTokenRepositoryImpl jdbcTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setCreateTableOnStartup(false);
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }

    @Bean
    public TokenBasedRememberMeServices tokenBasedRememberMeServices(){
        TokenBasedRememberMeServices tokenBasedRememberMeServices
                = new TokenBasedRememberMeServices(REMEBER_ME_KEY, userDetailsService);
        tokenBasedRememberMeServices.setCookieName("rlgnsqorCookie");
        return tokenBasedRememberMeServices;
    }

    // 여기부터가 패스워드 암호화랑 404 페이지 접근
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityEvaluationContextExtension securityEvaluationContextExtension(){
        return new SecurityEvaluationContextExtension();
    }
}
