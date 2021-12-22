package pers.wmx.distributetask;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class DistributetaskApplicationTests {

    @Autowired
    private Scheduler scheduler;

    @Test
    public void addJob() throws SchedulerException {
        // 创建 JobDetail
        JobDetail jobDetail = JobBuilder.newJob(SimpleJob.class)
                .withIdentity("demoJob01") // 名字为 demoJob01
                .storeDurably() // 没有 Trigger 关联的时候任务是否被保留。因为创建 JobDetail 时，还没 Trigger 指向它，所以需要设置为 true ，表示保留。
                .build();
        // 创建 Trigger
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(5) // 频率。
                .repeatForever(); // 次数。
        Trigger trigger = TriggerBuilder.newTrigger()
                .forJob(jobDetail) // 对应 Job 为 demoJob01
                .withIdentity("demoJob01Trigger") // 名字为 demoJob01Trigger
                .withSchedule(scheduleBuilder) // 对应 Schedule 为 scheduleBuilder
                .build();
        // 添加调度任务
        scheduler.scheduleJob(jobDetail, trigger);
//        scheduler.scheduleJob(jobDetail, Sets.newSet(trigger), true);
    }

}
