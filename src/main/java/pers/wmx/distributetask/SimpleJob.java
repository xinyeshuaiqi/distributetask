package pers.wmx.distributetask;

import java.util.concurrent.atomic.AtomicInteger;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangmingxin03
 * Created on 2021-12-21
 */
@Slf4j
public class SimpleJob extends QuartzJobBean {
    private final AtomicInteger counter = new AtomicInteger(); // 并不会 ++ ，每次调度时都是新创建一个Job

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("running counter:{}", counter.incrementAndGet());
    }
}
