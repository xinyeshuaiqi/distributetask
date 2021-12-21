package pers.wmx.distributetask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 再整个入口
@SpringBootApplication
public class DistributetaskApplication1 {

    public static void main(String[] args) {
        System.setProperty("server.port", "99");
        SpringApplication.run(DistributetaskApplication1.class, args);
    }

}
