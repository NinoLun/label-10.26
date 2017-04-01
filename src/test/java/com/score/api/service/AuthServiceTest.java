package com.score.api.service;

import com.alibaba.fastjson.JSON;
import com.score.api.App;
import com.score.api.model.Auth;
import com.sun.org.apache.xpath.internal.operations.Bool;
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
public class AuthServiceTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AuthService authService;


    @Test
    public void test() throws Exception {
        List<Auth> result = authService.getUserList();
        logger.info(JSON.toJSONString(result));
    }
//    @Test
//    public void testTableDesc() throws Exception {
//        String result = authService.getUserTableDesc();
//        logger.info(JSON.toJSONString(result));
//    }

    @Test
    public void loginTest() throws Exception  {
        Auth result = authService.login("bj_ccz@163.com","ccz");
        logger.info(result+"");
    }


}
