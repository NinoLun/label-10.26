package com.score.api.service;

import com.score.api.mapper.CustomerSearchMapper;
import com.score.api.mapper.SearchMapper;
import com.score.api.model.CustomerSearch;
import com.score.api.model.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by cheng on 16/12/13.
 */
@Service
public class SearchService {

    @Autowired
    private SearchMapper searchMapper;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public List<Search> list(){
        return  searchMapper.selectAll();
    }

    public boolean update(Integer id,String is_view){
        searchMapper.updateById(id+"",is_view);
        return true;
    }

}
