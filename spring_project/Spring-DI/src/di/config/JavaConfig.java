package di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import di.dao.MemberDao;
import di.service.ChangePasswordService;
import di.service.MemberRegisterService;

@Configuration
public class JavaConfig {

	//@Bean(name = "dao")
	//@Bean("dao")
	@Bean(name = "dao")
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean("regSvc")
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}
	
	@Bean //없으면 메서드 이름이 들어간다.  changePwSvc 
	public ChangePasswordService changePwSvc() {
		return new ChangePasswordService(memberDao());
	}
	
}
