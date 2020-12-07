package ua.realestate.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//@EnableCaching
public class RealEstateApplication{

    public static void main(String[] args) {

        SpringApplication.run(RealEstateApplication.class, args);
    }

}
