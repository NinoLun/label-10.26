<%@ page import="java.util.List" %>
<%@ page import="com.score.api.model.TaskLog" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ page import="com.score.api.model.Task" %>
<%@ page language="java"
         contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    List<TaskLog> taskLogs =(List<TaskLog>) request.getAttribute("taskLogs");
    List<Task> tasks =(List<Task>) request.getAttribute("tasks");


%>
<!DOCTYPE html>
 <link rel="stylesheet" type="text/css" href="../static/css/jquery-ui.css" />

<html lang="en">
<head>
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
                        <a href="#">任务列表</a>
                    </li>
                </ul>
            </div>


            <!--搜索任务列表-->
            <div class="row">
                <div class="box col-md-12">
                    <div class="box-inner">
                        <div class="box-header well" data-original-title="">
                            <h2>
                                <i class="glyphicon glyphicon-edit"></i>
                                任务列表
                            </h2>
                            <a href="#myModal" data-toggle="modal" class="glyphicon glyphicon-plus pull-right">新增任务</a>
                            <%--<a href="#myModal" data-toggle="modal" class="glyphicon glyphicon-plus pull-right">删除任务</a>--%>
                        </div>
                        <div class="box-content" style="padding-top: 50px;">
                            <table class="table  table-bordered  ">
                                <thead>
                                <tr>
                                    <th>任务名称</th>
                                    <th>执行时间</th>
                                    <th>评分引擎</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%
                                    if(tasks!=null && tasks.size()>0){
                                        for(Task model : tasks){
                                %>
                                <tr>
                                    <td><%=model.getName()%></td>
                                    <td><%=model.getWork_time()%></td>
                                    <td><%=model.getScore_field()%></td>
                                    <td>
                                        <a class="btn btn-danger" href="/task/delete?id=<%=model.getId()%>">
                                            <i class="glyphicon glyphicon-trash icon-white"></i>
                                            删除
                                        </a>
                                    </td>
                                </tr>
                                <%}

                                }%>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

            </div>


            <!--搜索框 任务明细-->
            <div class="row">
                <div class="box col-md-12">
                    <div class="box-inner">
                        <div class="box-header well" data-original-title="">
                            <h2>
                                <i class="glyphicon glyphicon-edit"></i>
                                任务执行结果列表
                            </h2>
                            <a href="/task/deleteLog" class="glyphicon glyphicon-remove pull-right">删除所有</a>
                        </div>
                        <div class="box-content" style="padding-top: 50px;">
                            <table class="table  table-bordered  ">
                                <thead>
                                <tr>
                                    <th>任务名称</th>
                                    <th>执行完成时间</th>
                                    <th>执行结果</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%
                                    if(taskLogs!=null && taskLogs.size()>0){
                                     for(TaskLog model : taskLogs){
                                %>
                                <tr>
                                    <td><%=model.getTitle()%></td>
                                    <td><%=model.getCreatedTime()%></td>
                                    <td><%=model.getResult()%></td>
                                </tr>
                                <%}
                                }%>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

            </div>
        </div>
            <!--弹窗-->
            <!-- Modal -->
            <div class="modal fade" id="myModal">
                <div class="modal-dialog" style="width: 300px;">
                    <div class="modal-content" >
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal"><span
                                    aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                            <h4 class="modal-title">新增任务</h4>
                        </div>
                        <div class="modal-body">
                            <form  id = "form" class="form-horizontal" action="/task/add" method="post">
                                <fieldset>

                                    <div class="input-group input-group-sm">
                                        <span class="input-group-addon">
                                            <%--<i class="glyphicon glyphicon-user red"></i>--%>
                                            任务名称
                                        </span>
                                        <input type="text" class="form-control" name="jobName" >
                                    </div>

                                    <div class="clearfix"></div>
                                    <br>


                                    <div class="input-group input-group-sm">
                                        <span class="input-group-addon">
                                            <%--<i class="glyphicon glyphicon-hand-right red"></i>--%>
                                            评分引擎
                                        </span>
                                            <select name="score_field" class="form-control">
                                                <option data-tokens="activate_score"
                                                        value="促活分" >促活分</option>
                                                <option data-tokens="product1_score"
                                                        value="产品1分" >产品1分</option>
                                                <option data-tokens="product2_score"
                                                        value="产品2分" >产品2分</option>
                                                <option data-tokens="product3_score"
                                                        value="产品3分" >产品3分</option>
                                                <option data-tokens="churn_score"
                                                        value="流失分">流失分</option>

                                            </select>
                                        </span>
                                    </div>

                                    <div class="clearfix"></div>
                                    <br>
                                    <div class="input-group input-group-sm">
                                        <span class="input-group-addon">
                                            <%--<i class="glyphicon glyphicon-hand-right red"></i>--%>
                                            小时
                                        </span>
                                        <select name="hour" class="form-control" placeholder="小时">
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <option value="5">5</option>
                                            <option value="6">6</option>
                                            <option value="7">7</option>
                                            <option value="8">8</option>
                                            <option value="9">9</option>
                                            <option value="10">10</option>
                                            <option value="11">11</option>
                                            <option value="12">12</option>
                                            <option value="13">13</option>
                                            <option value="14">14</option>
                                            <option value="15">15</option>
                                            <option value="16">16</option>
                                            <option value="17">17</option>
                                            <option value="18">18</option>
                                            <option value="19">19</option>
                                            <option value="20">20</option>
                                            <option value="21">21</option>
                                            <option value="22">22</option>
                                            <option value="23">23</option>
                                            <option value="00">00</option>
                                        </select>
                                    </div>
                                    <div class="clearfix"></div>
                                    <br>
                                    <div class="input-group input-group-sm">
                                        <span class="input-group-addon">
                                            <%--<i class="glyphicon glyphicon-hand-right red"></i>--%>
                                            分钟
                                        </span>
                                        <select name="minute" class="form-control" placeholder="分钟">
                                            <option value="00">00</option>
                                            <option value="05">05</option>
                                            <option value="10">10</option>
                                            <option value="15">15</option>
                                            <option value="20">20</option>
                                            <option value="25">25</option>
                                            <option value="30">30</option>
                                            <option value="35">35</option>
                                            <option value="40">40</option>
                                            <option value="45">45</option>
                                            <option value="50">50</option>
                                            <option value="55">55</option>
                                        </select>
                                    </div>
                                    <div class="clearfix"></div>

                                </fieldset>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            <button type="button" class="btn btn-primary" onclick="save();">保存</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->

            <!--弹窗-->




        <!-- external javascript -->

        <script src="../static/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

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
        <script src="../static/js/bootstrap-modal.js"></script>

        <script src="../static/js/jquery-1.11.1.min.js"></script>
        <script src="../static/js/jquery-ui.js"></script>
        <script src="../static/js/jquery-ui-timepicker-addon.js"></script>

        <script type="text/javascript"
                src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/china.js"></script>

        <script type="text/javascript">
            function save() {
                $('#form').submit();
            }

        </script>


</body>
</html>
