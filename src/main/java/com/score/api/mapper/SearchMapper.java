package com.score.api.mapper;

import com.score.api.model.CustomerScore;
import com.score.api.model.Search;
import com.score.api.util.MyMapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by cheng on 16/12/13.
 */
public interface SearchMapper extends MyMapper<Search> {

    public void updateById(@Param("id") String id, @Param("is_view") String is_view);

}
