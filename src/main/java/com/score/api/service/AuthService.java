package com.score.api.service;

import com.score.api.mapper.AuthMapper;
import com.score.api.model.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by cheng on 16/12/13.
 */
@Service
public class AuthService {

    @Autowired
    private AuthMapper authMapper;

//    @Autowired
//    private DataSource dataSource;

    public List<Auth> getUserList() {
        return authMapper.selectAll();
    }


    public Auth login(String email,String passWord){
        Auth newAuth = new Auth();
        newAuth.setEmail(email);
        newAuth.setPassWord(passWord);
        Auth auth = authMapper.selectOne(newAuth);
        if(auth != null){
            return auth;
        }else{
            return null;
        }
    }

    public Boolean save(String userName,String email,String pwd){
        Auth auth = new Auth();
        auth.setEmail(email);
        auth.setPassWord(pwd);
        auth.setUserName(userName);
        auth.setCreateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        authMapper.insert(auth);
        return true;
    }

    public List<Auth> getAll(){
        return authMapper.selectAll();
    }



//    public String getUserTableDesc() {
//        Connection conn = null;
//        ResultSet resultSet = null;
//        try {
//            conn = dataSource.getConnection();
//            DatabaseMetaData dbmd = conn.getMetaData();
//            resultSet = dbmd.getTables(null, "%", "%", new String[]{"TABLE"});
//            while (resultSet.next()) {
//                String tableName = resultSet.getString("TABLE_NAME");
//                //System.out.println(tableName);
//                if (tableName.equals("user")) {
//                    //ResultSet rs =getConnection.getMetaData().getColumns(null, getXMLConfig.getSchema(),tableName.toUpperCase(), "%");//其他数据库不需要这个方法的，直接传null，这个是oracle和db2这么用
//                    ResultSet rs = dbmd.getColumns(null, "%", tableName, "%");
//                    System.out.println("表名：" + tableName + "\t\n表字段信息：");
//                    while (rs.next()) {
//                        System.out.println("字段名：" + rs.getString("COLUMN_NAME") + "\t字段注释：" + rs.getString("REMARKS") + "\t字段数据类型：" + rs.getString("TYPE_NAME"));
//                    }
//                    System.out.println("生成成功！");
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//        }
//        return null;
//    }
}
