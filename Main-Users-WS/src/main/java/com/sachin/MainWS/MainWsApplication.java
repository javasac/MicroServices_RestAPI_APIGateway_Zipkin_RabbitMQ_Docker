package com.sachin.MainWS;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MainWsApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(MainWsApplication.class, args);
	}
}
