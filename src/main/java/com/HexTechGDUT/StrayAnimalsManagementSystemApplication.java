package com.HexTechGDUT;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author HexTechGDUT
 */
@MapperScan("com.HexTechGDUT.dao")
@SpringBootApplication
public class StrayAnimalsManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StrayAnimalsManagementSystemApplication.class, args);
	}

}
