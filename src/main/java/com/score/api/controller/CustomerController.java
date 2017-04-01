package com.score.api.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.score.api.dto.CustomerDto;
import com.score.api.model.Customer;
import com.score.api.model.CustomerSearch;
import com.score.api.model.Search;
import com.score.api.service.CustomerSearchService;
import com.score.api.service.CustomerService;
import com.score.api.service.SearchService;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

/**
 * Created by cheng on 16/12/13.
 */
@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    public CustomerService customerService;

    @Autowired
    public CustomerSearchService customerSearchService;

    @Autowired
    public SearchService searchService;

    @RequestMapping(value = "search",method = RequestMethod.POST)
    public String login(String gender, String degree, String year_income,
                        String score_field, String pscore,String area, Model model) throws ClassNotFoundException {

        List<String> areaList = Lists.newArrayList();
        if(StringUtils.isBlank(area)){
            area = null;
        }else{
           String[] areaStr =  area.split(",");
            areaList = Arrays.asList(areaStr);
        }
        model.addAttribute("gender",gender);
        model.addAttribute("degree",degree);
        model.addAttribute("year_income",year_income);
        model.addAttribute("score_field",score_field);
        model.addAttribute("pscore",pscore);
        model.addAttribute("area",area);
        Double year_income_from = null;
        Double year_income_to = null;

        if (StringUtils.isNotBlank(year_income)){
            switch (year_income){
                case "0":
                    year_income_from = null;
                    year_income_to = null;
                    break;
                case "20":
                    year_income_from = 0d;
                    year_income_to = 20d;
                    break;
                case "50":
                    year_income_from = 20d;
                    year_income_to = 50d;
                    break;
                case "100":
                    year_income_from = 50d;
                    year_income_to = 100d;
                    break;
                case "10000":
                    year_income_from = 100d;
                    year_income_to = 10000d;
                    break;
            }
        }
        List<CustomerDto> result = customerService.getCustomerList(gender,degree,year_income_from,year_income_to,score_field,Double.parseDouble(pscore.split(",")[0]),Double.parseDouble(pscore.split(",")[1]),areaList);
        model.addAttribute("data",result);
        Class c = Class.forName("com.score.api.dto.CustomerDto");
        Method[] methods = c.getDeclaredMethods();
        List<Double> scoreList = Lists.newArrayList();
        result.forEach(dto -> {
            Stream.of(methods).forEach(args -> {
                if(args.getName().equals("get"+score_field.substring(0,1).toUpperCase()+score_field.substring(1,score_field.length()))){
                    try {
                        Double score_ = (Double) args.invoke(dto);
                        scoreList.add(score_);
                    } catch (Exception e) {
                    }
                }
            });
        });
        //柱状图
        Integer[] init = new Integer[]{0,0,0,0,0,0,0,0,0,0};

        Integer[] binglInit = new Integer[]{0,0,0,0,0};

        scoreList.forEach(score ->{
            if (score <=10d){
                init[0] ++;
                binglInit[0]++;
            }else if(score <=20d && score > 10d){
                init[1] ++;
                binglInit[0]++;
            }else if(score <=30d && score > 20d){
                init[2] ++;
                binglInit[0]++;
            }else if(score <=40d && score > 30d){
                init[3] ++;
                binglInit[1]++;
            }else if(score <=50d && score > 40d){
                init[4] ++;
                binglInit[1]++;
            }else if(score <=60d && score > 50d){
                init[5] ++;
                binglInit[2]++;
            }else if(score <=70d && score > 60d){
                init[6] ++;
                binglInit[3]++;
            }else if(score <=80d && score > 70d){
                init[7] ++;
                binglInit[4]++;
            }else if(score <=90d && score > 80d){
                init[8] ++;
                binglInit[4]++;
            }else if(score <=100d && score > 90d){
                init[9] ++;
                binglInit[4]++;
            }
        });
        List<Integer> zhuy = Arrays.asList(init);
        String[] str = new String[]{"'0-10'", "'10-20'", "'20-30'", "'30-40'", "'40-50'", "'50-60'", "'60-70'", "'70-80'", "'80-90'","'90-100'"};
        List<String> zhux = Arrays.asList(str);
        List<Integer> bing = Arrays.asList(binglInit);

        /**
         * 地图
         */
        Map<String, List<CustomerDto>> map =
                result.stream().collect(groupingBy(CustomerDto::getArea));
        System.out.print(JSON.toJSON(map));
        Map<String,Integer> diMap = Maps.newHashMap();
        for(String key : map.keySet()){
            diMap.put(key,map.get(key).size());
        }
        model.addAttribute("zhuy",zhuy);
        model.addAttribute("zhux",zhux);
        model.addAttribute("result",result);
        model.addAttribute("bing",bing);
        model.addAttribute("diMap",diMap);
        List<Search> searchList = searchService.list();
        model.addAttribute("searchList",searchList);
        List<Customer> cusList = customerService.getAllList();
        Set<String> areas = Sets.newHashSet();
        cusList.forEach(customer -> {
            areas.add(customer.getArea());
        });
        model.addAttribute("areas",areas);

        //性别饼图 性别 0女,1男
        Map<Integer, List<CustomerDto>> sexMap =
                result.stream().collect(groupingBy(CustomerDto::getGender));
        List<Integer> sexBing = Lists.newArrayList();
        if(sexMap !=null && sexMap.size()>0){
            sexBing.add(sexMap.get(0) == null ? 0 : sexMap.get(0).size());
            sexBing.add(sexMap.get(1) == null ? 0 : sexMap.get(1).size());
        }
        model.addAttribute("sexBing",sexBing);


        //学历饼图
        Map<Integer, List<CustomerDto>> degreeMap =
            result.stream().collect(groupingBy(CustomerDto::getDegree));
        List<Integer> degreeBing = Lists.newArrayList();
        if(degreeMap !=null && degreeMap.size()>0){
            degreeBing.add(degreeMap.get(5) == null ? 0 : degreeMap.get(5).size());
            degreeBing.add(degreeMap.get(4) == null ? 0 : degreeMap.get(4).size());
            degreeBing.add(degreeMap.get(3) == null ? 0 : degreeMap.get(3).size());
            degreeBing.add(degreeMap.get(2) == null ? 0 : degreeMap.get(2).size());
        }
        model.addAttribute("degreeBing",degreeBing);


        //年收入 year_income
        Map<Double, List<CustomerDto>> year_incomeMap =
                result.stream().collect(groupingBy(CustomerDto::getYear_income));
        List<Integer> year_incomeBing = Lists.newArrayList();
        int one = 0;
        int two =0;
        int three = 0;
        int four = 0;
        for(CustomerDto customer : result){
            if(customer.getYear_income() <= 20){
                one ++;
            }else if(customer.getYear_income() >20 && customer.getYear_income() <=50){
                two ++;
            }else if(customer.getYear_income()>50 && customer.getYear_income() <=100 ){
                three ++;
            }else{
                four ++;
            }
        }
            year_incomeBing.add(one);
            year_incomeBing.add(two);
            year_incomeBing.add(three);
            year_incomeBing.add(four);
        model.addAttribute("year_incomeBing",year_incomeBing);


        return "home";
    }

    @RequestMapping(value = "export",method = RequestMethod.GET)
    public void export(Integer id,HttpServletResponse response) throws ClassNotFoundException {

        CustomerSearch cs = customerSearchService.getById(id);

        Double year_income_from = null;
        Double year_income_to = null;

        if (StringUtils.isNotBlank(cs.getYear_income()+"")){
            if (cs.getYear_income().equals(20d)) {
                year_income_from = 0d;
                year_income_to = 20d;

            } else if (cs.getYear_income().equals(50d)) {
                year_income_from = 20d;
                year_income_to = 50d;

            } else if (cs.getYear_income().equals(100d)) {
                year_income_from = 50d;
                year_income_to = 100d;

            } else if (cs.getYear_income().equals(10000d)) {
                year_income_from = 100d;
                year_income_to = 10000d;

            }
        }
        HSSFWorkbook result = customerService.export(cs.getGender()+"",cs.getDegree()+"",year_income_from,year_income_to,cs.getScore_field(),Double.parseDouble(cs.getScore_sector().split(",")[0]),Double.parseDouble(cs.getScore_sector().split(",")[1]),null);
        if(result != null){
            String fileName = "Excel-" + String.valueOf(System.currentTimeMillis()).substring(4, 13) + ".xls";
            String headStr = "attachment; filename=\"" + fileName + "\"";
            response.setContentType("APPLICATION/OCTET-STREAM");
            response.setHeader("Content-Disposition", headStr);
            OutputStream out = null;
            try {
                out = response.getOutputStream();
                out.flush();
                result.write(out);
                out.close();
                result.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @RequestMapping(value = "list")
    public String list(){
        return "list";
    }

    @RequestMapping(value = "searchSave")
    @ResponseBody
    public Object searchSave(Integer gender, Integer degree, Double year_income,
                             String score_field, String pscore){
        boolean result  = customerSearchService.save(gender,degree,year_income,score_field,pscore);
        return result;
    }

    @RequestMapping(value = "searchDelete")
    @ResponseBody
    public Object searchDelete(Integer id){
        boolean result  = customerSearchService.delete(id);
        return result;
    }

    @RequestMapping(value = "cusList")
    public String cusList(Model model){
        List<CustomerSearch> list = customerSearchService.list();
        model.addAttribute("data",list);
        return "cus_list";
    }


}
