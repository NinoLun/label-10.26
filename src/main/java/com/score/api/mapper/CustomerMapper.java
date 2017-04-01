package com.score.api.mapper;

import com.score.api.dto.CustomerDto;
import com.score.api.model.Customer;
import com.score.api.util.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by cheng on 16/12/13.
 */
public interface CustomerMapper extends MyMapper<Customer> {

    public List<CustomerDto> getCustomerList(Map map);
}
