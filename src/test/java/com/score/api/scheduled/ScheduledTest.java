package com.score.api.scheduled;

import com.score.api.App;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.junit.Test;

/**
 * Created by cheng on 2017/2/16.
 */
@SuppressWarnings("ALL")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(App.class)
public class ScheduledTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ScheduledTasks scheduledTasks;

    @Test
    public void test() throws InterruptedException {

        String job_name = "动态任务调度";
        System.out.println(job_name);
        scheduledTasks.addJob(job_name, QuartzJob.class, "00 00 04 * * ?");
        Thread.sleep(5000*1000);
//        System.out.println("【修改时间】开始(每2秒输出一次)...");
//        ScheduledTasks.modifyJobTime(job_name, "10/2 * * * * ?");
//        Thread.sleep(6000);
//        System.out.println("【移除定时】开始...");
//        ScheduledTasks.removeJob(job_name);
//        System.out.println("【移除定时】成功");
//
//        System.out.println("【再次添加定时任务】开始(每10秒输出一次)...");
//        ScheduledTasks.addJob(job_name, QuartzJob.class, "*/10 * * * * ?");
//        Thread.sleep(60000);
//        System.out.println("【移除定时】开始...");
//        ScheduledTasks.removeJob(job_name);
//        System.out.println("【移除定时】成功");
    }

}
