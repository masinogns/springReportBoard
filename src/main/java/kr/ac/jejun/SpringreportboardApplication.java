package kr.ac.jejun;

import kr.ac.jejun.model.User;
import kr.ac.jejun.repository.UserDao;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringreportboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringreportboardApplication.class, args);
	}

	@Autowired
	UserDao accountRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	// 초기 시작시 데이터 초기화 (JPA : CREATE-DROP )
	// InitializingBean 참고 : 토비의 봄 - (1.5) 커맨드 라인 스프링 앱 만들기
	// https://www.youtube.com/watch?v=dnCf2-XYXL8
	@Bean
	InitializingBean insertFixtureUsers(){
		return ()->{
			User admin = new User();
			admin.setUserid("admin");
			admin.setPassword(passwordEncoder.encode("1234"));
			admin.setRole("ROLE_ADMIN");
			admin.setNick("관리자한사");
			accountRepository.save(admin);

			User user = new User();
			user.setUserid("rlgnsqor");
			user.setPassword(passwordEncoder.encode("rl1004"));
			user.setRole("ROLE_USER");
			user.setNick("백기훈");
			accountRepository.save(user);
		};
	}
}
