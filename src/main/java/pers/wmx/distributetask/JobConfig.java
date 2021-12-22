package pers.wmx.distributetask;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangmingxin03
 * Created on 2021-12-21
 */
@Configuration
public class JobConfig {

    @Bean
    public JobDetail simpleJob() {
        return JobBuilder.newJob(SimpleJob.class)
                .withIdentity("simpleJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger simpleJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(5)
                .repeatForever();

        return TriggerBuilder.newTrigger()
                .forJob(simpleJob())
                .withIdentity("simpleJobTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }

}
