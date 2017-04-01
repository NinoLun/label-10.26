package com.score.api.service;

import com.score.api.mapper.CustomerScoreMapper;
import com.score.api.mapper.CustomerSearchMapper;
import com.score.api.model.CustomerSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by cheng on 16/12/13.
 */
@Service
public class CustomerSearchService {

    @Autowired
    private CustomerSearchMapper customerSearchMapper;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public boolean save(Integer gender, Integer degree, double year_income,
                        String score_field, String pscore){
        CustomerSearch customerSearch = new CustomerSearch();
        customerSearch.setCreate_time(sdf.format(new Date()));
        customerSearch.setGender(gender);
        customerSearch.setDegree(degree);
        customerSearch.setYear_income(year_income);
        customerSearch.setScore_field(score_field);
        customerSearch.setScore_sector(pscore);
        customerSearchMapper.insert(customerSearch);
        return true;
    }

    public List<CustomerSearch> list(){
        return  customerSearchMapper.selectAll();
    }

    public boolean delete(Integer id){
        CustomerSearch customerSearch = new CustomerSearch();
        customerSearch.setId(id);
        customerSearchMapper.delete(customerSearch);
        return true;
    }

    public CustomerSearch getById(Integer id){
        CustomerSearch customerSearch = new CustomerSearch();
        customerSearch.setId(id);
        return customerSearchMapper.selectOne(customerSearch);
    }

}
