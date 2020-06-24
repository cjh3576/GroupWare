package com.web.group;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@EnableAutoConfiguration, @ComponentScan, @Configuration을 하나로 묶어 놓은 어노테이션
//해당 어노테이션을 설정한 클래스가 있는 package를 최상위 패키지로 인식하기 때문에 클래스 파일의 위치가 중요함.
@SpringBootApplication
//@MapperScan(basePackages = "com.web.group")
public class GroupWareApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroupWareApplication.class, args);
	}

}
