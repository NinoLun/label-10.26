package com.score.api.service;

import com.google.common.collect.Lists;
import com.score.api.dto.FieldDescDto;
import com.score.api.dto.TableDescDto;
import org.mockito.internal.util.collections.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * Created by cheng on 16/12/13.
 */
@Service
public class TableService {

//    @Autowired
//    private DataSource dataSource;
//
//
//    public TableDescDto getTableDesc(String table){
//        Connection conn = null;
//        ResultSet resultSet = null;
//        try {
//            conn = dataSource.getConnection();
//            DatabaseMetaData dbmd = conn.getMetaData();
//            resultSet = dbmd.getTables(null, "%", "%", new String[]{"TABLE"});
//            TableDescDto tableDescDto = new TableDescDto();
//            List<FieldDescDto> fieldDescDtos = Lists.newArrayList();
//            while (resultSet.next()) {
//                String tableName = resultSet.getString("TABLE_NAME");
//                //System.out.println(tableName);
//                if (tableName.equals(table)) {
//                    //ResultSet rs =getConnection.getMetaData().getColumns(null, getXMLConfig.getSchema(),tableName.toUpperCase(), "%");//其他数据库不需要这个方法的，直接传null，这个是oracle和db2这么用
//                    ResultSet rs = dbmd.getColumns(null, "%", tableName, "%");
//                    System.out.println("表名：" + tableName + "\t\n表字段信息：");
//                    while (rs.next()) {
//                        System.out.println("字段名：" + rs.getString("COLUMN_NAME") + "\t字段注释：" + rs.getString("REMARKS") + "\t字段数据类型：" + rs.getString("TYPE_NAME"));
//                        FieldDescDto dto = new FieldDescDto();
//                        dto.setFieldName(rs.getString("COLUMN_NAME"));
//                        dto.setFieldRemark(rs.getString("REMARKS"));
//                        dto.setFieldType(rs.getString("TYPE_NAME"));
//                        fieldDescDtos.add(dto);
//                    }
//                }
//            }
//            tableDescDto.setFields(fieldDescDtos);
//            return tableDescDto;
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }

}
