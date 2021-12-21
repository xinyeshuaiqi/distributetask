package pers.wmx.distributetask;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangmingxin03
 * Created on 2021-12-21
 */
@Slf4j
@DisallowConcurrentExecution  // 保证相同 JobDetail 在多个 JVM 进程中，有且仅有一个节点在执行
public class DistributeJob1 extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("running:{}", System.currentTimeMillis());
    }
}
