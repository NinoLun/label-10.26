package com.score.api.service;

import com.alibaba.fastjson.JSON;
import com.score.api.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


/**
 * Unit test for simple App.
 */
@SuppressWarnings("ALL")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(App.class)
public class TableServiceTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TableService tableService;

//    @Test
//    public void test() throws Exception {
//        logger.info(JSON.toJSONString(tableService.getTableDesc("user")));
//    }

}
