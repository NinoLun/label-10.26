package com.score.api.service;

import com.alibaba.fastjson.JSON;
import com.score.api.App;
import com.score.api.dto.CustomerDto;
import com.score.api.mapper.CustomerMapper;
import com.score.api.mapper.CustomerScoreMapper;
import com.score.api.model.Auth;
import com.score.api.model.Customer;
import com.score.api.model.CustomerScore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.Random;


/**
 * Unit test for simple App.
 */
@SuppressWarnings("ALL")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(App.class)
public class CustomerServiceTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CustomerScoreMapper customerScoreMapper;


    @Test
    public void test() throws Exception {
        List<CustomerDto> result = customerService.getCustomerList("0", "4", 100d, 900d, "product1_score", 100d, 900d,null);
        logger.info(JSON.toJSONString(result));
    }

    @Test
    public void testExport(){
//        List<CustomerDto> result = customerService.export("0", "4", 100d, 900d, "product1_score", 100d, 900d);
//        logger.info(JSON.toJSONString(result));
    }


    @Test
    public void testInsert() throws Exception {
        for(int i=0;i<5023;i++) {
            Customer customer = new Customer();
            Random rand = new Random();
            customer.setAge(rand.nextInt(60) + 20);
            customer.setArea(getArea());
            customer.setClient_id(1);
            customer.setDegree(rand.nextInt(3) + 2);
            customer.setFund_account("招商银行");
            customer.setFund_open_date("2016121409");
            customer.setFund_bank_account("人民银行");
            customer.setGender(rand.nextInt(2));
            customer.setName("保密");
            customer.setStock_account("浦发银行");
            customer.setStock_open_date("2016121409");
            customer.setTrade_account("建设银行");
            customer.setYear_income(rand.nextInt(120));
            customerMapper.insert(customer);
        }
    }


    @Test
    public void testInsertScore(){
        for(int i=1;i<5024;i++){
            CustomerScore customerScore = new CustomerScore();
            Random rand = new Random();
            customerScore.setCustomer_id(i);
            customerScore.setActivate_score(rand.nextInt(100));
            customerScore.setChurn_score(rand.nextInt(100));
            customerScore.setProduct1_score(rand.nextInt(100));
            customerScore.setProduct2_score(rand.nextInt(100) );
            customerScore.setProduct3_score(rand.nextInt(100));
            customerScoreMapper.insert(customerScore);
        }
    }

    public int getRandom() {
        int b = (int) (Math.random() * 10);
        return b;
    }

    public String getArea() {
        String[] areas = new String[]{"天津", "北京",
                "上海", "重庆", "河北", "河南", "云南",
                "辽宁", "黑龙江", "湖南", "安徽", "山东"
                , "新疆", "江苏", "浙江", "江西", "湖北",
                "广西", "甘肃", "山西", "内蒙古", "陕西",
                "吉林", "福建", "贵州", "广东", "青海",
                "西藏", "四川", "宁夏", "海南", "台湾",
                "香港", "澳门"};

        Random rand = new Random();
        int r = ((rand.nextInt(34)));
        return areas[r];
    }


}
