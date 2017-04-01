<%@ page import="java.util.List" %>
<%@ page import="com.score.api.dto.CustomerDto" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.score.api.model.Search" %>
<%@ page import="com.score.api.model.Customer" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.*,java.io.*" %>

<%@ page import="com.google.common.collect.Sets" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ page language="java" import="java.util.*,java.io.*"
         contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String gender = (String) request.getAttribute("gender");
    String degree = (String) request.getAttribute("degree");
    String score_field = (String) request.getAttribute("score_field");
    String year_income = (String) request.getAttribute("year_income");
    String pscore = (String) request.getAttribute("pscore");
    List zhuy = (List) request.getAttribute("zhuy");
    List zhux = (List) request.getAttribute("zhux");
    List bing = (List) request.getAttribute("bing");
    List<Integer> sexBing = (List) request.getAttribute("sexBing");
    List<Integer> degreeBing = (List) request.getAttribute("degreeBing");
    List<Integer> year_incomeBing = (List) request.getAttribute("year_incomeBing");

    List<CustomerDto> result = (List<CustomerDto>) request.getAttribute("result");
    int size = 0;
    if(result!=null && result.size()>0){
        size = result.size();
    }
    Map<String, Integer> diMap = (Map<String, Integer>) request.getAttribute("diMap");
    List<Search> searchList = (List<Search>) request.getAttribute("searchList");
    String gender_ = "0";
    String degree_ = "0";
    String year_income_ = "0";
    String _area_ = "0";
    String area = (String) request.getAttribute("area");
    for (Search search : searchList) {
        if (search.getVal().equals("gender")) {
            gender_ = search.getIs_view();
        }
        if (search.getVal().equals("degree")) {
            degree_ = search.getIs_view();
        }
        if (search.getVal().equals("year_income")) {
            year_income_ = search.getIs_view();
        }
        if (search.getVal().equals("area")) {
            _area_ = search.getIs_view();
        }
    }
    Set<String> areas =(Set) request.getAttribute("areas");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="../static/css/jquery.range.css" rel="stylesheet">
    <link href="../static/css/jquery.dialogbox.css" rel="stylesheet">
    <%@include file="header.jsp" %>

<body>
<%@include file="topbar.jsp" %>

<div class="ch-container">
    <div class="row">
        <%@include file="left.jsp" %>

        <div id="content" class="col-lg-10 col-sm-10 col-md-10 col-xs-10">
            <!-- content starts -->
            <div>
                <ul class="breadcrumb">
                    <li>
                        <a href="#">导航</a>
                    </li>
                    <li>
                        <a href="#">客群分析</a>
                    </li>
                </ul>
            </div>

            <!--搜索框-->
            <div class="row">
                <div class="box col-md-12">
                    <div class="box-inner">
                        <div class="box-header well" data-original-title="">
                            <h2><i class="glyphicon glyphicon-edit"></i>客户筛选</h2>
                        </div>
                        <div class="box-content">
                            <form id="form" role="form" action="/customer/search" method="POST">
                                <div class="row">
                                    <%
                                        if ("1".equals(gender_)) {
                                    %>
                                    <div class="form-group col-md-3">
                                        <label class="control-label">性别：</label>
                                        <span>
                                            <select class="selectpicker" name="gender" data-live-search="true">
                                                <option data-tokens="1"
                                                        value="2" <% if (gender != null && gender.equals("2")) {%>
                                                        selected<%}%>>无</option>
                                                <option data-tokens="1"
                                                        value="1" <% if (gender != null && gender.equals("1")) {%>
                                                        selected<%}%>>男</option>

                                                <option data-tokens="0"
                                                        value="0" <% if (gender != null && gender.equals("0")) {%>
                                                        selected<%}%>>女</option>
                                            </select>
                                        </span>
                                    </div>
                                    <%}%>


                                    <%
                                        if ("1".equals(degree_)) {
                                    %>
                                    <div class="form-group col-md-3">
                                        <label class="control-label">学历：</label>
                                        <span>
                                            <select class="selectpicker" name="degree" data-live-search="true">
                                                <option data-tokens="6"
                                                        value="6" <% if (degree != null && degree.equals("6")) {%>
                                                        selected<%}%>>无</option>
                                                <option data-tokens="5"
                                                        value="5" <% if (degree != null && degree.equals("5")) {%>
                                                        selected<%}%>>博士及以上</option>
                                                <option data-tokens="4"
                                                        value="4" <% if (degree != null && degree.equals("4")) {%>
                                                        selected<%}%>>硕士</option>
                                                <option data-tokens="3"
                                                        value="3" <% if (degree != null && degree.equals("3")) {%>
                                                        selected<%}%>>本科</option>
                                                <option data-tokens="2"
                                                        value="2" <% if (degree != null && degree.equals("2")) {%>
                                                        selected<%}%>>本科以下</option>
                                            </select>
                                        </span>
                                    </div>

                                    <% }%>

                                    <%
                                        if ("1".equals(year_income_)) {
                                    %>
                                    <div class="form-group col-md-3">
                                        <label class="control-label">年收入：</label>
                                        <span>
                                            <select class="selectpicker" name="year_income" data-live-search="true">
                                               <option data-tokens="5"
                                                       value="0" <% if (year_income != null && year_income.equals("20")) {%>
                                                       selected<%}%>>无</option>

                                                <option data-tokens="5"
                                                        value="20" <% if (year_income != null && year_income.equals("20")) {%>
                                                        selected<%}%>>20万以下</option>
                                                <option data-tokens="10"
                                                        value="50" <% if (year_income != null && year_income.equals("50")) {%>
                                                        selected<%}%>>20万-50万</option>
                                                <option data-tokens="15"
                                                        value="100" <% if (year_income != null && year_income.equals("100")) {%>
                                                        selected<%}%>>50万-100万</option>
                                                <option data-tokens="20"
                                                        value="10000" <% if (year_income != null && year_income.equals("10000")) {%>
                                                        selected<%}%>>100万以上</option>
                                            </select>
                                        </span>
                                    </div>
                                    <%}%>

                                </div>

                                <div class="row">
                                    <div class="form-group col-md-3">
                                        <label class="control-label">评分引擎：</label>
                                        <span>
                                            <select class="selectpicker" name="score_field" data-live-search="true">
                                                <option data-tokens="activate_score"
                                                        value="activate_score" <% if (score_field != null && score_field.equals("activate_score")) {%>
                                                        selected<%}%>>促活分</option>
                                                <option data-tokens="product1_score"
                                                        value="product1_score" <% if (score_field != null && score_field.equals("product1_score")) {%>
                                                        selected<%}%>>产品1分</option>
                                                <option data-tokens="product2_score"
                                                        value="product2_score" <% if (score_field != null && score_field.equals("product2_score")) {%>
                                                        selected<%}%>>产品2分</option>
                                                <option data-tokens="product3_score"
                                                        value="product3_score" <% if (score_field != null && score_field.equals("product3_score")) {%>
                                                        selected<%}%>>产品3分</option>
                                                <option data-tokens="churn_score" value="churn_score"
                                                        <% if (score_field != null && score_field.equals("churn_score")) {%>
                                                        selected<%}%>
                                                >流失分</option>

                                            </select>
                                        </span>
                                    </div>

                                    <%
                                        if("1".equals(_area_)){
                                    %>
                                    <div class="form-group col-md-3">
                                        <label class="control-label">省份：</label>
                                        <select id="area_select" class="selectpicker show-tick form-control"  data-live-search="false" name="area" multiple >

                                            <%
                                                for(String area_ : areas){
                                             %>
                                            <%
                                                if(StringUtils.isNotEmpty(area) && area.contains(area_)){
                                            %>
                                                <option data-tokens="area" value="<%=area_%>" selected>
                                                    <%=area_%>
                                                </option>
                                            <%
                                                }else{
                                            %>
                                                <option data-tokens="area" value="<%=area_%>" >
                                                    <%=area_%>
                                                </option>

                                            <%
                                                        }
                                                }
                                            %>
                                        </select>
                                        </span>
                                    </div>
                                </div>
                                <%}%>
                        </div>


                        <div class="row" style="margin-left: 20px;">
                            <div class="form-group col-md-9 col-sm-9 col-xs-9 col-lg-9">
                                <input class="range-slider" name="pscore" type="hidden"
                                        <% if (pscore != null) {%> value="<%=pscore%>"<%} else {%>
                                       value="0,100"
                                        <%}%>
                                />
                            </div>
                        </div>

                        <div class="row" style="margin-left: 20px;margin-top: 10px;margin-bottom: 10px">
                            <button type="submit" class="btn btn-info col-md-1 ">查询客群</button>
                            <a href="#" onclick="save();" class="btn btn-danger col-md-1 col-md-offset-1">保存客群</a>
                        </div>

                        </form>


                    </div>

                    <hr style="height:1px;border:none;border-top:1px solid #555555;"/>

                    <!--柱状图-->
                    <%--<div class="box-content">--%>
                        <%--<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->--%>
                        <%--<div id="zhu" style="width: 100%;height:400px;"></div>--%>
                    <%--</div>--%>


                    <div class="box-content clearfix">
                        <div class="col-md-6">
                            <!--饼状图-->
                            <div id="bing" style="width: 100%;height:300px;"></div>
                        </div>
                        <div class="col-md-6">
                            <!--年收入饼图-->
                            <div id="year_incomeBing" style="width: 100%;height:300px;"></div>
                        </div>

                    </div>


                    <div class="box-content clearfix">
                        <div class="col-md-6">
                            <!--性别饼状图-->
                            <div id="sexBing" style="width: 100%;height:300px;"></div>
                        </div>
                        <div class="col-md-6">
                            <!--学历饼图-->
                            <div id="degreeBing" style="width: 100%;height: 300px"></div>
                        </div>

                    </div>

                    <!--地图-->
                    <div class="box-content clearfix">
                    <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
                        <div id="di" style="width: 100%;height: 300px"></div>
                    </div>

                    <div class="box-content" style="margin-top: 50px;">
                        <h4 class="center" style="text-align:center">
                            客群详细列表样例
                        </h4>
                        <%--datatable responsive--%>
                        <table class="table table-bordered bootstrap-datatable ">
                            <thead>
                            <tr>
                                <th class="col-md-1 col-xs-1 col-sm-1">ID</th>
                                <th class="col-md-2 col-xs-2 col-sm-2">用户名</th>
                                <th class="col-md-1 col-xs-1 col-sm-1">性别</th>
                                <th class="col-md-2 col-xs-2 col-sm-2">学位</th>
                                <th class="col-md-2 col-xs-2 col-sm-2">年收入</th>
                                <%--<th class="col-md-4 col-xs-4 col-sm-4">操作</th>--%>
                            </tr>
                            </thead>
                            <tbody>
                            <%
                                if (result != null && result.size() > 0) {

                                    for (int i = 0; i < result.size(); i++) {
                            %>
                            <tr>
                                <td class="col-md-1 col-xs-1 col-sm-1"><%=result.get(i).getId()%>
                                </td>
                                <td class="col-md-2 col-xs-2 col-sm-2"><%=result.get(i).getName()%>
                                </td>
                                <td class="col-md-1 col-xs-1 col-sm-1"><% if (result.get(i).getGender() == 1) {%>
                                    男<%} else {%>女<%}%></td>
                                <td class="col-md-2 col-xs-2 col-sm-2">
                                    <% if (result.get(i).getDegree() == 5) {%>
                                    博士及博士以上
                                    <%} else if (result.get(i).getDegree() == 4) {%>
                                    硕士
                                    <%} else if (result.get(i).getDegree() == 3) {%>
                                    本科
                                    <%} else if (result.get(i).getDegree() == 2) {%>
                                    本科以下
                                    <%}%>
                                </td>
                                <td class="col-md-2 col-xs-2 col-sm-2"><%=result.get(i).getYear_income()%>
                                </td>
                                <%--<td class="col-md-4 col-xs-4 col-sm-4">--%>
                                <%--<a class="btn btn-success" href="#">--%>
                                <%--<i class="glyphicon glyphicon-zoom-in icon-white"></i>--%>
                                <%--查看--%>
                                <%--</a>--%>
                                <%--<a class="btn btn-info" href="#">--%>
                                <%--<i class="glyphicon glyphicon-edit icon-white"></i>--%>
                                <%--编辑--%>
                                <%--</a>--%>
                                <%--<a class="btn btn-danger" href="#">--%>
                                <%--<i class="glyphicon glyphicon-trash icon-white"></i>--%>
                                <%--删除--%>
                                <%--</a>--%>
                                <%--</td>--%>
                            </tr>
                            <%
                                    }
                                }
                            %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
<div id="btn-dialogBox"></div>
<!-- external javascript -->

<script src="${request.contextPath}/static/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- library for cookie management -->
<script src="../static/js/jquery.cookie.js"></script>
<!-- calender plugin -->
<script src='../static/bower_components/moment/min/moment.min.js'></script>
<script src='../static/bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
<!-- data table plugin -->
<script src='../static/js/jquery.dataTables.min.js'></script>

<!-- select or dropdown enhancer -->
<script src="../static/bower_components/chosen/chosen.jquery.min.js"></script>
<!-- plugin for gallery image view -->
<script src="../static/bower_components/colorbox/jquery.colorbox-min.js"></script>
<!-- notification plugin -->
<script src="../static/js/jquery.noty.js"></script>
<!-- library for making tables responsive -->
<script src="../static/bower_components/responsive-tables/responsive-tables.js"></script>
<!-- tour plugin -->
<script src="../static/bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
<!-- star rating plugin -->
<script src="../static/js/jquery.raty.min.js"></script>
<!-- for iOS style toggle switch -->
<script src="../static/js/jquery.iphone.toggle.js"></script>
<!-- autogrowing textarea plugin -->
<script src="../static/js/jquery.autogrow-textarea.js"></script>
<!-- multiple file upload plugin -->
<script src="../static/js/jquery.uploadify-3.1.min.js"></script>
<!-- history.js for cross-browser state change on ajax -->
<script src="../static/js/jquery.history.js"></script>
<!-- application script for Charisma demo -->
<script src="../static/js/charisma.js"></script>
<script src="../static/js/echarts.min.js"></script>
<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/china.js"></script>
<script type="text/javascript" src="../static/js/jquery.range.js"></script>
<script type="text/javascript" src="../static/js/jquery.dialogBox.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/css/bootstrap-select.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/bootstrap-select.min.js"></script>

<!-- (Optional) Latest compiled and minified JavaScript translation files -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/i18n/defaults-*.min.js"></script>

<script type="text/javascript">

    $(window).on('load', function () {
        $('#area_select').selectpicker({
            'selectedText': 'cat'
        });
    });

    //柱状图
    // 基于准备好的dom，初始化echarts实例
    <%--var zhu = echarts.init(document.getElementById('zhu'));--%>

    <%--// 指定图表的配置项和数据--%>
    <%--var optionZhu = {--%>
        <%--title: {--%>
            <%--text: '分数客群分布 总人群数：<% if(result==null){%>0<%}else{%> <%=result.size()%> <%}%>人'--%>
        <%--},--%>
        <%--tooltip: {},--%>
        <%--legend: {--%>
            <%--data: ['人数']--%>
        <%--},--%>
        <%--xAxis: {--%>
            <%--data: <%=zhux%>--%>
        <%--},--%>
        <%--yAxis: {},--%>
        <%--series: [{--%>
            <%--name: '人数',--%>
            <%--type: 'bar',--%>
            <%--data: <%=zhuy%>--%>
        <%--}]--%>
    <%--};--%>
    <%--// 使用刚指定的配置项和数据显示图表。--%>
    <%--zhu.setOption(optionZhu);--%>


    var bing = echarts.init(document.getElementById('bing'));
    //饼状图
    optionBing = {
        title: {
            text: '分数分布',
//                subtext: '纯属虚构',
            x: 'center'
        },
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['30以下', '30-50', '50-60', '60-70', '70以上']
        },
        series: [
            {
                name: '分数分布',
                type: 'pie',
                radius: '55%',
                center: ['50%', '60%'],
                data: [
                    <%
                        if(bing!=null&&bing.size()>0){
                    %>
                    {value: <%=bing.get(0)%>, name: '30以下'},
                    {value: <%=bing.get(1)%>, name: '30-50'},
                    {value: <%=bing.get(2)%>, name: '50-60'},
                    {value: <%=bing.get(3)%>, name: '60-70'},
                    {value: <%=bing.get(4)%>, name: '70以上'}
                    <%
                        }else{
                    %>
                    {value: 0, name: '30以下'},
                    {value: 0, name: '30-50'},
                    {value: 0, name: '50-60'},
                    {value: 0, name: '60-70'},
                    {value: 0, name: '70以上'}
                    <%}%>
                ],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };
    bing.setOption(optionBing);



    var sexBing = echarts.init(document.getElementById('sexBing'));
    //饼状图
    sexOptionBing = {
        title: {
            text: '性别分布',
//                subtext: '纯属虚构',
            x: 'center'
        },
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['女', '男']
        },
        series: [
            {
                name: '分布',
                type: 'pie',
                radius: '55%',
                center: ['50%', '60%'],
                data: [
                    <%
                        if(sexBing!=null&&sexBing.size()>0){
                    %>
                    {value: <%=sexBing.get(0)%>, name: '女'},
                    {value: <%=sexBing.get(1)%>, name: '男'}
                    <%
                        }else{
                    %>
                        {value: 0, name: '女'},
                        {value: 0, name: '男'}
                    <%}%>
                ],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };
    sexBing.setOption(sexOptionBing);




    var degreeBing = echarts.init(document.getElementById('degreeBing'));
    //饼状图
    degreeOptionBing = {
        title: {
            text: '学历分布',
//                subtext: '纯属虚构',
            x: 'center'
        },
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['博士及以上', '硕士','本科','本科以下']
        },
        series: [
            {
                name: '分布',
                type: 'pie',
                radius: '55%',
                center: ['50%', '60%'],
                data: [
                    <%
                        if(degreeBing!=null&&degreeBing.size()>0){
                    %>
                    {value: <%=degreeBing.get(0)%>, name: '博士及以上'},
                    {value: <%=degreeBing.get(1)%>, name: '硕士'},
                    {value: <%=degreeBing.get(2)%>, name: '本科'},
                    {value: <%=degreeBing.get(3)%>, name: '本科以下'}
                    <%
                        }else{
                    %>
                    {value: 0, name: '博士及以上'},
                    {value: 0, name: '硕士'},
                    {value: 0, name: '本科'},
                    {value: 0, name: '本科以下'}
                    <%}%>
                ],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };
    degreeBing.setOption(degreeOptionBing);


    var year_incomeBing = echarts.init(document.getElementById('year_incomeBing'));
    //饼状图
    year_incomeOptionBing = {
        title: {
            text: '年收入分布',
//                subtext: '纯属虚构',
            x: 'center'
        },
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['20万以下', '20-50万','50-100万','100万以上']
        },
        series: [
            {
                name: '分布',
                type: 'pie',
                radius: '55%',
                center: ['50%', '60%'],
                data: [
                    <%
                        if(year_incomeBing!=null&&year_incomeBing.size()>0){
                    %>
                    {value: <%=year_incomeBing.get(0)%>, name: '20万以下'},
                    {value: <%=year_incomeBing.get(1)%>, name: '20-50万'},
                    {value: <%=year_incomeBing.get(2)%>, name: '50-100万'},
                    {value: <%=year_incomeBing.get(3)%>, name: '100万以上'}
                    <%
                        }else{
                    %>
                    {value: 0, name: '20万以下'},
                    {value: 0, name: '20-50万'},
                    {value: 0, name: '50-100万'},
                    {value: 0, name: '100万以上'}
                    <%}%>
                ],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };
    year_incomeBing.setOption(year_incomeOptionBing);

    /***
     * 地图
     */
    var di = echarts.init(document.getElementById('di'));
    var app = {};
    optionDi = null;
    var size = '<%=size%>'
    optionDi = {
        title: {
            text: '客群地域分布',
//                subtext: '纯属虚构',
            left: 'center'
        },
        tooltip: {
            trigger: 'item'
        },
        legend: {
            orient: 'vertical',
            left: 'left',
//                data: ['iphone3', 'iphone4', 'iphone5']
            data: ['']
        },
        visualMap: {
            min: 0,
            max: size,
            left: 'left',
            top: 'bottom',
            text: ['高', '低'],           // 文本，默认为数值文本
            calculable: true
        },
        toolbox: {
            show: true,
            orient: 'vertical',
            left: 'right',
            top: 'center',
            feature: {
                mark: {show: true},
                dataView: {show: true, readOnly: false},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        series: [
            {
//                    name: 'iphone3',
                type: 'map',
                mapType: 'china',
                roam: false,
                label: {
                    normal: {
                        show: false
                    },
                    emphasis: {
                        show: true
                    }
                },
                data: [
                    <%
                       if(diMap!=null && diMap.size()>0){
                       for(String key : diMap.keySet()){
                    %>
                    {name: '<%=key%>', value: <%=diMap.get(key)%>},
                    <%}}%>
                ]
//                    data: [
//                        {name: '北京', value: Math.round(Math.random() * 1000)},
//                        {name: '天津', value: Math.round(Math.random() * 1000)},
//                        {name: '上海', value: Math.round(Math.random() * 1000)},
//                        {name: '重庆', value: Math.round(Math.random() * 1000)},
//                        {name: '河北', value: Math.round(Math.random() * 1000)},
//                        {name: '河南', value: Math.round(Math.random() * 1000)},
//                        {name: '云南', value: Math.round(Math.random() * 1000)},
//                        {name: '辽宁', value: Math.round(Math.random() * 1000)},
//                        {name: '黑龙江', value: Math.round(Math.random() * 1000)},
//                        {name: '湖南', value: Math.round(Math.random() * 1000)},
//                        {name: '安徽', value: Math.round(Math.random() * 1000)},
//                        {name: '山东', value: Math.round(Math.random() * 1000)},
//                        {name: '新疆', value: Math.round(Math.random() * 1000)},
//                        {name: '江苏', value: Math.round(Math.random() * 1000)},
//                        {name: '浙江', value: Math.round(Math.random() * 1000)},
//                        {name: '江西', value: Math.round(Math.random() * 1000)},
//                        {name: '湖北', value: Math.round(Math.random() * 1000)},
//                        {name: '广西', value: Math.round(Math.random() * 1000)},
//                        {name: '甘肃', value: Math.round(Math.random() * 1000)},
//                        {name: '山西', value: Math.round(Math.random() * 1000)},
//                        {name: '内蒙古', value: Math.round(Math.random() * 1000)},
//                        {name: '陕西', value: Math.round(Math.random() * 1000)},
//                        {name: '吉林', value: Math.round(Math.random() * 1000)},
//                        {name: '福建', value: Math.round(Math.random() * 1000)},
//                        {name: '贵州', value: Math.round(Math.random() * 1000)},
//                        {name: '广东', value: Math.round(Math.random() * 1000)},
//                        {name: '青海', value: Math.round(Math.random() * 1000)},
//                        {name: '西藏', value: Math.round(Math.random() * 1000)},
//                        {name: '四川', value: Math.round(Math.random() * 1000)},
//                        {name: '宁夏', value: Math.round(Math.random() * 1000)},
//                        {name: '海南', value: Math.round(Math.random() * 1000)},
//                        {name: '台湾', value: Math.round(Math.random() * 1000)},
//                        {name: '香港', value: Math.round(Math.random() * 1000)},
//                        {name: '澳门', value: Math.round(Math.random() * 1000)}
//                    ]
            }
//                ,
//                {
//                    name: 'iphone4',
//                    type: 'map',
//                    mapType: 'china',
//                    label: {
//                        normal: {
//                            show: false
//                        },
//                        emphasis: {
//                            show: true
//                        }
//                    },
//                    data: [
//                        {name: '北京', value: Math.round(Math.random() * 1000)},
//                        {name: '天津', value: Math.round(Math.random() * 1000)},
//                        {name: '上海', value: Math.round(Math.random() * 1000)},
//                        {name: '重庆', value: Math.round(Math.random() * 1000)},
//                        {name: '河北', value: Math.round(Math.random() * 1000)},
//                        {name: '安徽', value: Math.round(Math.random() * 1000)},
//                        {name: '新疆', value: Math.round(Math.random() * 1000)},
//                        {name: '浙江', value: Math.round(Math.random() * 1000)},
//                        {name: '江西', value: Math.round(Math.random() * 1000)},
//                        {name: '山西', value: Math.round(Math.random() * 1000)},
//                        {name: '内蒙古', value: Math.round(Math.random() * 1000)},
//                        {name: '吉林', value: Math.round(Math.random() * 1000)},
//                        {name: '福建', value: Math.round(Math.random() * 1000)},
//                        {name: '广东', value: Math.round(Math.random() * 1000)},
//                        {name: '西藏', value: Math.round(Math.random() * 1000)},
//                        {name: '四川', value: Math.round(Math.random() * 1000)},
//                        {name: '宁夏', value: Math.round(Math.random() * 1000)},
//                        {name: '香港', value: Math.round(Math.random() * 1000)},
//                        {name: '澳门', value: Math.round(Math.random() * 1000)}
//                    ]
//                },
//                {
//                    name: 'iphone5',
//                    type: 'map',
//                    mapType: 'china',
//                    label: {
//                        normal: {
//                            show: false
//                        },
//                        emphasis: {
//                            show: true
//                        }
//                    },
//                    data: [
//                        {name: '北京', value: Math.round(Math.random() * 1000)},
//                        {name: '天津', value: Math.round(Math.random() * 1000)},
//                        {name: '上海', value: Math.round(Math.random() * 1000)},
//                        {name: '广东', value: Math.round(Math.random() * 1000)},
//                        {name: '台湾', value: Math.round(Math.random() * 1000)},
//                        {name: '香港', value: Math.round(Math.random() * 1000)},
//                        {name: '澳门', value: Math.round(Math.random() * 1000)}
//                    ]
//                }
        ]
    };

    di.setOption(optionDi);


    //区间选择控件
    $(function () {
        $('.single-slider').jRange({
            from: 0,
            to: 100,
            step: 1,
            scale: [0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100],
            format: '%s',
            width: 300,
            showLabels: true,
            showScale: true
        });
        $('.range-slider').jRange({
            from: 0,
            to: 100,
            step: 1,
            scale: [0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100],
            format: '%s',
            width: '90%',
            showLabels: true,
            isRange: true
        });

        $("#g1").click(function () {
            var aa = $(".single-slider").val();
            alert(aa);
        });
        $("#g2").click(function () {
            var aa = $(".range-slider").val();
            alert(aa);
        });
    });

    function save() {
        var obj = $("#form").serialize();
        $.ajax({
            url: '/customer/searchSave',
            type: "get",
            data: obj,
            success: function (data) {
                $('#btn-dialogBox').dialogBox({
                    width: 300,
                    height: 80,
                    autoHide: true,
                    time: 3000,
                    effect: 'flip-horizontal',
                    title: '提示',
                    content: '保存成功!'
                });
            }
        })
    }
</script>

</div>
</body>
</html>