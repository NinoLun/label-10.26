package com.score.api.scheduled;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cheng on 2017/2/16.
 */
public class TaskLogJob implements Job {

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+ "★★★★★★★★★★★");
    }
}
