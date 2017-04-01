package com.score.api.service;

import com.score.api.mapper.CustomerScoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cheng on 16/12/13.
 */
@Service
public class CustomerScoreService {

    @Autowired
    private CustomerScoreMapper customerScoreMapper;

}
