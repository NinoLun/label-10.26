package com.score.api.service;

import com.score.api.mapper.TaskLogMapper;
import com.score.api.mapper.TaskMapper;
import com.score.api.model.Task;
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
public class TaskService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private ScheduledTasks scheduledTasks;

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public void createTask(String job_name,String hour,String minute,String score_field){
        if(StringUtils.isNotBlank(job_name)){
            Task task = new Task();
            task.setName(job_name);
            task.setWork_time(hour+":"+minute);
            task.setCreate_time(simpleDateFormat.format(new Date()));
            task.setScore_field(score_field);
            String s = String.format("%s %s %s * * ?","00",minute,hour);
            taskMapper.insert(task);
            scheduledTasks.addJob(job_name,QuartzJob.class ,s);
        }
    }

    public void delete(Integer id){
        Task task = new Task();
        task.setId(id);
        Task modle = taskMapper.selectOne(task);
        scheduledTasks.removeJob(modle.getName());
        taskMapper.delete(task);
    }

    public List<Task> getList(){
        return taskMapper.selectAll();
    }

}
