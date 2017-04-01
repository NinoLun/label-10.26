<%@ page import="java.util.List" %>
<%@ page language="java"
         contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    List<Auth> data =(List<Auth>) request.getAttribute("data");
%>
<!DOCTYPE html>
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
                        <a href="#">用户列表</a>
                    </li>
                </ul>
            </div>

            <!--搜索框-->
            <div class="row">
                <div class="box col-md-12">
                    <div class="box-inner">
                        <div class="box-header well" data-original-title="">
                            <h2><i class="glyphicon glyphicon-edit"></i>用户列表</h2>
                            <a href="#myModal" data-toggle="modal" class="glyphicon glyphicon-plus pull-right">新增用户</a>
                        </div>

                        <div class="box-content" style="padding-top: 50px;">
                            <table class="table  table-bordered  ">
                                <thead>
                                <tr>
                                    <th>用户ID</th>
                                    <th>用户名</th>
                                    <th>邮箱</th>
                                    <th>密码</th>
                                    <%--<th>操作</th>--%>
                                </tr>
                                </thead>
                                <tbody>
                                <%
                                    for(Auth model : data){

                                %>
                                <tr>
                                    <td><%=model.getId()%></td>
                                    <td><%=model.getUserName()%></td>
                                    <td><%=model.getEmail()%></td>
                                    <td>*********</td>
                                    <%--<td class="center">--%>
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
                                <%}%>
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
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal"><span
                                    aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                            <h4 class="modal-title">新增用户</h4>
                        </div>
                        <div class="modal-body">
                            <form  id = "form" class="form-horizontal" action="/user/save" method="post">
                                <fieldset>

                                    <div class="input-group input-group-sm">
                                        <span class="input-group-addon"><i
                                                class="glyphicon glyphicon-user red"></i></span>
                                        <input type="text" class="form-control" name="userName" placeholder="用户名">
                                    </div>

                                    <div class="clearfix"></div>
                                    <br>
                                    <div class="input-group input-group-sm">
                                        <span class="input-group-addon"><i
                                                class="glyphicon glyphicon-hand-right red"></i></span>
                                        <input type="text" class="form-control" name="email" placeholder="邮箱">
                                    </div>
                                    <div class="clearfix"></div>
                                    <br>

                                    <div class="input-group input-group-sm">
                                        <span class="input-group-addon"><i
                                                class="glyphicon glyphicon-lock red"></i></span>
                                        <input type="password" class="form-control" name="pwd" placeholder="密码">
                                    </div>
                                    <div class="clearfix"></div>

                                    <%--<div class="input-prepend">--%>
                                        <%--<label class="remember" for="remember"><input type="checkbox" id="remember">是否启用</label>--%>
                                    <%--</div>--%>
                                    <%--<div class="clearfix"></div>--%>

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

            <script type="text/javascript"
                src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/china.js"></script>

        <script type="text/javascript">
            function save() {
                $('#form').submit();
            }
        </script>


</body>
</html>
