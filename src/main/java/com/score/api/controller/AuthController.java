package com.score.api.controller;

import com.google.common.collect.Sets;
import com.score.api.model.Auth;
import com.score.api.model.Customer;
import com.score.api.model.CustomerSearch;
import com.score.api.model.Search;
import com.score.api.service.AuthService;
import com.score.api.service.CustomerSearchService;
import com.score.api.service.CustomerService;
import com.score.api.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

/**
 * Created by cheng on 16/12/13.
 */
@Controller
@RequestMapping("user")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private SearchService searchService;

    @Autowired
    private CustomerService customerService;


    @Autowired
    private CustomerSearchService customerSearchService;

    /**
     * 登录
     * @param email
     * @param passWord
     * @param request
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(String email, String passWord, HttpServletRequest request){
        Auth result = authService.login(email,passWord);
        if(result != null){
            request.getSession().setAttribute("user",result);
            return "redirect:/user/index";
        }else {
            return "redirect:/";
        }
    }


    @RequestMapping(value = "list")
    public String list(Model model){
        List<Auth> result = authService.getAll();
        model.addAttribute("data",result);
        return "list";
    }

    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(String userName,String email, String pwd){
        Boolean result = authService.save(userName,email,pwd);
        return "redirect:/user/list";
    }



    @RequestMapping(value = "out",method = RequestMethod.GET)
    public String out(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "redirect:/";
    }

    @RequestMapping("index")
    public String index(Model model){
        List<Search> searchList = searchService.list();
        List<Customer> cusList = customerService.getAllList();
        Set<String> areas = Sets.newHashSet();
        areas.add("  ");
        cusList.forEach(customer -> {
            areas.add(customer.getArea());
        });
        model.addAttribute("searchList",searchList);
        model.addAttribute("areas",areas);
        return "home";
    }
    @RequestMapping(value = "set")
    public String set(Model model){
        List<Search> list = searchService.list();
        model.addAttribute("data",list);
        return "set";
    }

    @RequestMapping(value = "update")
    @ResponseBody
    public Boolean update(Integer id,String is_view){
        searchService.update(id,is_view);
        return true;
    }



}
