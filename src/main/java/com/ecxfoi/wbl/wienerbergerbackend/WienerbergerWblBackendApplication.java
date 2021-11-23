package com.ecxfoi.wbl.wienerbergerbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class WienerbergerWblBackendApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(WienerbergerWblBackendApplication.class, args);
    }
}
