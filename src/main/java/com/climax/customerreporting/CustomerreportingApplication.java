package com.climax.customerreporting;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.climax.customerreporting.ServiceImpl.FileManagerServiceImpl;

@SpringBootApplication
public class CustomerreportingApplication implements Runnable {

	public static void main(String[] args) {
		SpringApplication.run(CustomerreportingApplication.class, args);
	}

	@Override
	public void run() {
		FileManagerServiceImpl filename=new FileManagerServiceImpl();
	     System.out.print("salut");
		
	}

}
