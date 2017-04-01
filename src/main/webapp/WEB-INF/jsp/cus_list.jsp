<%@ page import="com.score.api.model.CustomerSearch" %>
<%@ page import="java.util.List" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ page language="java"
         contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    List<CustomerSearch> data = (List<CustomerSearch>)request.getAttribute("data");
%>

<!DOCTYPE html>
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
                        <a href="#">客群管理</a>
                    </li>
                </ul>
            </div>

            <!--搜索框-->
            <div class="row">
                <div class="box col-md-12">
                    <div class="box-inner">
                        <div class="box-header well" data-original-title="">
                            <h2><i class="glyphicon glyphicon-edit"></i>客群集合</h2>
                        </div>

                        <div class="box-content" style="padding-top: 50px;">
                            <table class="table  table-bordered  ">
                                <thead>
                                <tr>
                                    <th>选取</th>
                                    <th>集合ID</th>
                                    <th>集合名称</th>
                                    <th>创建时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%
                                    for(CustomerSearch customerSearch : data){
                                %>
                                <tr>
                                    <td>
                                        <input type="checkbox" id="remember">
                                    </td>
                                    <td><%=customerSearch.getId()%></td>
                                    <%
                                        StringBuffer sb = new StringBuffer();
                                        if(customerSearch.getGender() != null) {
                                            if (customerSearch.getGender() == 0) {
                                                sb.append("女+");
                                            } else {
                                                sb.append("男+");
                                            }
                                        }

                                        if (customerSearch.getDegree() !=null) {
                                            if (customerSearch.getDegree() == 5) {
                                                sb.append("博士以上+");
                                            } else if (customerSearch.getDegree() == 4) {
                                                sb.append("硕士+");
                                            } else if (customerSearch.getDegree() == 3) {
                                                sb.append("本科+");
                                            } else {
                                                sb.append("本科以下+");
                                            }
                                        }

                                        if(customerSearch.getYear_income() != null) {
                                            if (customerSearch.getYear_income() == 20) {
                                                sb.append("年收入20万以下+");
                                            } else if (customerSearch.getYear_income() == 50) {
                                                sb.append("年收入20万-50万+");
                                            } else if (customerSearch.getYear_income() == 100) {
                                                sb.append("年收入50万-100万+");
                                            } else if (customerSearch.getYear_income() == 10000) {
                                                sb.append("年收入100万以上+");
                                            }
                                        }

                                        if(StringUtils.isNotBlank(customerSearch.getScore_field())) {
                                            if (customerSearch.getScore_field().equals("activate_score")) {
                                                sb.append("促活分" + customerSearch.getScore_sector());
                                            } else if (customerSearch.getScore_field().equals("product1_score")) {
                                                sb.append("产品1分" + customerSearch.getScore_sector());
                                            } else if (customerSearch.getScore_field().equals("product2_score")) {
                                                sb.append("产品2分" + customerSearch.getScore_sector());
                                            } else if (customerSearch.getScore_field().equals("product3_score")) {
                                                sb.append("产品3分" + customerSearch.getScore_sector());
                                            } else if (customerSearch.getScore_field().equals("churn_score")) {
                                                sb.append("流失分" + customerSearch.getScore_sector());
                                            }
                                        }

                                    %>
                                    <td class="center">
                                        <%=sb.toString()%>
                                    </td>

                                    <td class="center"><%=customerSearch.getCreate_time()%></td>
                                    <td class="center">
                                        <%--<a class="btn btn-info" href="#" >--%>
                                            <%--<i class="glyphicon glyphicon-save icon-white"></i>--%>
                                            <%--更新--%>
                                        <%--</a>--%>
                                        <a class="btn btn-info" href="#" onclick="exportData(<%=customerSearch.getId()%>)">
                                            <i class="glyphicon glyphicon-search icon-white"></i>
                                            导出
                                        </a>
                                        <%--<a class="btn btn-info" href="#">--%>
                                            <%--<i class="glyphicon glyphicon-edit icon-white"></i>--%>
                                            <%--查看--%>
                                        <%--</a>--%>
                                        <a class="btn btn-danger" href="#" onclick="del(<%=customerSearch.getId()%>);">
                                            <i class="glyphicon glyphicon-trash icon-white"></i>
                                            删除
                                        </a>
                                    </td>
                                </tr>
                                <%}%>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>

    <form id="form" action="/customer/export" method="get">
        <input  id="input_id" name="id">
    </form>
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
    <%--<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/china.js"></script>--%>

    <script type="text/javascript">

       function del(id) {
            $.ajax({
                url: '/customer/searchDelete',
                type: "get",
                data: "id="+id,
                success: function(data) {
                    window.location.reload();
                }
            })
       }

       function exportData(id) {
           var my_input = $('#input_id');
           my_input.attr('value', id);
           var form = $('#form');
           // 设置属性
           form.attr('action', "/customer/export");
           form.attr('method', 'get');
           form.submit();

//           $.ajax({
//               url: '/customer/export',
//               type: "get",
//               contentType: "application/x-www-form-urlencoded",
//               data: "id="+id,
//               async:false,
//               success: function(data) {
//               }
//           })
       }
    </script>


</div>
</body>
</html>
