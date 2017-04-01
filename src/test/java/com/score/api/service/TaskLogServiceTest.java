package com.score.api.service;

import com.alibaba.fastjson.JSON;
import com.score.api.App;
import com.score.api.model.Auth;
import com.score.api.scheduled.QuartzJob;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;


/**
 * Unit test for simple App.
 */
@SuppressWarnings("ALL")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(App.class)
public class TaskLogServiceTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TaskLogService taskLogService;


    @Test
    public void test() throws Exception {
        String job_name = "动态任务调度";
        System.out.println("【系统启动】开始(每5秒输出一次)...");
        Thread.sleep(5000);
    }
//


}
