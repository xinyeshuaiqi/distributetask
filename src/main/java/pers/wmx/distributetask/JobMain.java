package pers.wmx.distributetask;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author wangmingxin03
 * Created on 2021-12-21
 */
public class JobMain {
    public static void main(String[] args) throws Exception {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        JobDetail job = JobBuilder.newJob(SimpleJob.class)
                .withIdentity("simpleJob", "wmx")
                .build();

        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(1)
                .repeatForever();

        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("simpleJobTrigger")
                .withSchedule(scheduleBuilder)
                .startNow()
                .build();

        scheduler.scheduleJob(job, trigger);
        scheduler.start();

        Thread.sleep(5000);
    }
}
