package hello.servlet;

import hello.servlet.web.springmvc.v1.SpringMemberFormControllerV1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ServletComponentScan //서블릿 자동 등록
@SpringBootApplication
public class ServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletApplication.class, args);
	}
//뷰 리졸버
//	@Bean
//	ViewResolver internalResourceViewResolver(){
//		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
//	}

/*
	이렇게 빈으로 등록해도됨
	@Bean
	springmemberFormControllerV1 springmemberFormControllerV1(){
		return  new SpringMemberFormControllerV1();
	}
*/

}
