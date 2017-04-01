package com.score.api.mapper;

import com.score.api.model.TaskLog;
import com.score.api.util.MyMapper;

/**
 * Created by cheng on 16/12/13.
 */
public interface TaskLogMapper extends MyMapper<TaskLog> {

    public void deleteAll();

}
