package com.score.api.service;

import com.score.api.mapper.TaskLogMapper;
import com.score.api.model.TaskLog;
import com.score.api.scheduled.QuartzJob;
import com.score.api.scheduled.ScheduledTasks;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by cheng on 16/12/13.
 */
@Service
public class TaskLogService  {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TaskLogMapper taskLogMapper;

    @Autowired
    private ScheduledTasks scheduledTasks;

    public void work(String job_name,String hour,String minute,String score_field){
        if(StringUtils.isNotBlank(job_name)){
            scheduledTasks.removeJob(job_name);
            String s = String.format("%s %s %s * * ?","00",minute,hour);
            scheduledTasks.addJob(job_name, QuartzJob.class,s);
        }
    }

    public void save(String jobName){
        TaskLog taskLog = new TaskLog();
        taskLog.setCreatedTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        taskLog.setResult("任务执行成功!");
        taskLog.setTitle(jobName);
        taskLogMapper.insert(taskLog);
    }

    public List<TaskLog> list(){
       List<TaskLog> lists =  taskLogMapper.selectAll();
       return lists;
    }

    public void deleteAll(){
         taskLogMapper.deleteAll();
    }
}
