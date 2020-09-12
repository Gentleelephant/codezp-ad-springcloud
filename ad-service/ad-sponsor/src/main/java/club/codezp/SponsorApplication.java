package club.codezp;

import club.dao.AdPlanRepository;
import club.entity.AdPlan;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/**
 * @Author:Zpg
 * @Date:2020/8/1 21:18
 * @Version:1.0
 * @Description: 广告投放
 */
@SpringBootApplication
@ComponentScan(basePackages = "club")
@EnableHystrix
@EntityScan(basePackages = "club.entity")
@EnableJpaRepositories(basePackages = "club.dao")
@EnableEurekaClient
@EnableFeignClients  // 加上该注解就可以调用其他微服务")
public class SponsorApplication {

    @Autowired(required = true)
    AdPlanRepository adPlanRepository;

    public static void main(String[] args) {

        SpringApplication.run(SponsorApplication.class, args);

    }
}
