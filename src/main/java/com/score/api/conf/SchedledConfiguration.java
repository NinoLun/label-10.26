package com.score.api.conf;

import com.score.api.scheduled.MyJobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.*;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by cheng on 2017/2/16.
 */
@SuppressWarnings("ALL")
@Configuration
@EnableScheduling
public class SchedledConfiguration {
    @Autowired
    private MyJobFactory myJobFactory;
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean( ){
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setOverwriteExistingJobs(true);
        // 延时启动
        schedulerFactoryBean.setStartupDelay(600*10);
        // 加载quartz数据源配置
//        schedulerFactoryBean.setQuartzProperties(quartzProperties());
        // 自定义Job Factory，用于Spring注入
        schedulerFactoryBean.setJobFactory(myJobFactory);
        return schedulerFactoryBean;
    }
    /**
     * 加载quartz数据源配置
     *
     * @return
     * @throws IOException
     */
//    @Bean
//    public Properties quartzProperties() throws IOException {
//        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
//        propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
//        propertiesFactoryBean.afterPropertiesSet();
//        return propertiesFactoryBean.getObject();
//    }
}
