package com.score.api.controller;

import com.score.api.model.Task;
import com.score.api.model.TaskLog;
import com.score.api.service.TaskLogService;
import com.score.api.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by cheng on 16/12/13.
 */
@Controller
@RequestMapping("task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskLogService taskLogService;

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String add(String jobName, String hour,String minute,String score_field,Model model){
        taskService.createTask(jobName,hour,minute,score_field);
        return "redirect:/task/list";
    }

    @RequestMapping(value = "delete",method = RequestMethod.GET)
    public String delete(Integer id){
        taskService.delete(id);
        return "redirect:/task/list";
    }
    @RequestMapping(value = "list")
    public String list(Model model){
        List<Task> tasks = taskService.getList();
        List<TaskLog> taskLogs = taskLogService.list();
        model.addAttribute("tasks",tasks);
        model.addAttribute("taskLogs",taskLogs);
        return "work";
    }

    @RequestMapping(value = "deleteLog",method = RequestMethod.GET)
    public String deleteLog(){
        taskLogService.deleteAll();
        return "redirect:/task/list";
    }

}
