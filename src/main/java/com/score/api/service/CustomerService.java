package com.score.api.service;

import com.score.api.dto.CustomerDto;
import com.score.api.mapper.AuthMapper;
import com.score.api.mapper.CustomerMapper;
import com.score.api.model.Auth;
import com.score.api.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * Created by cheng on 16/12/13.
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerMapper customerMapper;



    public List<CustomerDto> getCustomerList(String age,String degree,Double year_income_from,
                                            Double year_income_to ,String score_field,Double score_from,Double score_to,List areas){
        Map map = new HashMap<>();
        map.put("age",age);
        map.put("degree",degree);
        map.put("year_income_from",year_income_from);
        map.put("year_income_to",year_income_to);
        map.put("score_from",score_from);
        map.put("score_field",score_field);
        map.put("score_to",score_to);
        map.put("areas",areas);
        return customerMapper.getCustomerList(map);
    }


    public HSSFWorkbook export(String age,String degree,Double year_income_from,
                                             Double year_income_to ,String score_field,Double score_from,Double score_to,List area){

        Map map = new HashMap<>();
        map.put("age",age);
        map.put("degree",degree);
        map.put("year_income_from",year_income_from);
        map.put("year_income_to",year_income_to);
        map.put("score_field",score_field);
        map.put("score_from",score_from);
        map.put("score_to",score_to);
        if("null".equals(age)){
            age = null;
        }
        if("null".equals(degree)){
            degree = null;
        }
        if("null".equals(year_income_from)){
            year_income_from = null;
            year_income_to = null;
        }
        if("null".equals(score_field)){
            score_field = null;
        }
        List<CustomerDto> result = customerMapper.getCustomerList(map);
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("统计表");
        /**
         * 设置表头
         */

        HSSFRow row = sheet.createRow(0);
        //设置列宽，setColumnWidth的第二个参数要乘以256，这个参数的单位是1/256个字符宽度
        sheet.setColumnWidth(2, 12*256);
        sheet.setColumnWidth(3, 17*256);
        //设置为居中加粗
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setFont(font);
        HSSFCell cell;
        cell = row.createCell(0);
        cell.setCellValue("用户ID");
        cell.setCellStyle(style);
        cell = row.createCell(1);
        cell.setCellValue("用户名");
        cell.setCellStyle(style);
        cell = row.createCell(2);
        cell.setCellValue("性别");
        cell.setCellStyle(style);
        cell = row.createCell(3);
        cell.setCellValue("学位");
        cell.setCellStyle(style);
        cell = row.createCell(4);
        cell.setCellValue("年收入");
        cell.setCellStyle(style);

        cell = row.createCell(5);
        cell.setCellValue("促活分");
        cell.setCellStyle(style);
        cell = row.createCell(6);
        cell.setCellValue("产品1分");
        cell.setCellStyle(style);
        cell = row.createCell(7);
        cell.setCellValue("产品2分");
        cell.setCellStyle(style);
        cell = row.createCell(8);
        cell.setCellValue("产品3分");
        cell.setCellStyle(style);
        cell = row.createCell(9);
        cell.setCellValue("流失分");
        cell.setCellStyle(style);
        HSSFCellStyle vstyle = workbook.createCellStyle();
        vstyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
        int rowNum = 1;
        for(CustomerDto dto : result){
            row = sheet.createRow(rowNum);
            HSSFCell cell_0 = row.createCell(0);
            cell_0.setCellStyle(vstyle);
            cell_0.setCellValue(dto.getId());

            HSSFCell cell_1 = row.createCell(1);
            cell_1.setCellStyle(vstyle);
            cell_1.setCellValue(dto.getName());

            HSSFCell cell_2 = row.createCell(2);
            cell_2.setCellStyle(vstyle);
            cell_2.setCellValue(dto.getGender().equals(0)?"女":"男");

            String degreeStr = "";
            switch (dto.getDegree()){
                case 5:
                    degreeStr = "博士及以上";
                    break;
                case 4:
                    degreeStr = "硕士";
                    break;
                case 3:
                    degreeStr = "本科";
                    break;
                case 2:
                    degreeStr = "本科以下";
                    break;
            }
            HSSFCell cell_3 = row.createCell(3);
            cell_3.setCellStyle(vstyle);
            cell_3.setCellValue(degreeStr);

            HSSFCell cell_4 = row.createCell(4);
            cell_4.setCellValue(dto.getYear_income()+"万");
            cell_4.setCellStyle(style);

            HSSFCell cell_5 = row.createCell(5);
            cell_5.setCellValue(dto.getActivate_score());
            cell_5.setCellStyle(style);

            HSSFCell cell_6 = row.createCell(6);
            cell_6.setCellValue(dto.getProduct1_score());
            cell_6.setCellStyle(style);
            HSSFCell cell_7 = row.createCell(7);
            cell_7.setCellValue(dto.getProduct2_score());
            cell_7.setCellStyle(style);
            HSSFCell cell_8 = row.createCell(8);
            cell_8.setCellValue(dto.getProduct3_score());
            cell_8.setCellStyle(style);
            HSSFCell cell_9 = row.createCell(9);
            cell_9.setCellValue(dto.getChurn_score());
            cell_9.setCellStyle(style);

            rowNum++;
        }

        if(workbook !=null){
            try
            {
//                String fileName = "Excel-" + String.valueOf(System.currentTimeMillis()).substring(4, 13) + ".xls";
//                String headStr = "attachment; filename=\"" + fileName + "\"";
//                response = getResponse();
//                response.setContentType("APPLICATION/OCTET-STREAM");
//                response.setHeader("Content-Disposition", headStr);
//                OutputStream out = response.getOutputStream();
//                workbook.write(out);
//                OutputStream out = new FileOutputStream("/Users/cheng/1111.xls");
//                workbook.write(out);
//                out.flush();
//                out.close();
//                workbook.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return workbook;
    }

    public List<Customer> getAllList(){
        return customerMapper.selectAll();
    }


}
