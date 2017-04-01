package com.score.api.scheduled;

import com.score.api.service.TaskLogService;
import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.utils.Key;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cheng on 2017/2/16.
 */
@Service
public class QuartzJob implements Job {


    @Autowired
    private TaskLogService taskLogService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDetail jobDetail = context.getJobDetail();
//        JobDataMap jobDataMap = jobDetail.getJobDataMap();
        String jobName = jobDetail.getName();
//        String jobFullName = jobDetail.getFullName();
//        Key key = jobDetail.getKey();
//        System.out.println("jobname:"+ jobName);
//        System.out.println("keyName:"+ key.getName());
        try {
            Thread.sleep(Long.valueOf(1000*60*2));
            taskLogService.save(jobName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
