<%@ page import="java.util.List" %>
<%@ page import="com.score.api.model.Search" %>
<%@ page language="java"
         contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    List<Search> list = (List<Search>) request.getAttribute("data");
%>
<!DOCTYPE html>
<html lang="en">
<%@include file="header.jsp" %>
<link href="../static/css/jquery.dialogbox.css" rel="stylesheet">

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
                        <a href="#">分析配置</a>
                    </li>
                </ul>
            </div>

            <div class="row">
                <div class="box col-md-12">
                    <div class="box-inner">
                        <div class="box-header well" data-original-title="">
                            <h2><i class="glyphicon glyphicon-edit "></i>分析维度设置</h2>
                            <%--<a href="#myModal" data-toggle="modal" class="glyphicon glyphicon-plus pull-right">新增维度</a>--%>
                        </div>

                        <div class="box-content" style="padding-top: 50px;">
                            <table class="table  table-bordered  ">
                                <thead>
                                <tr>
                                    <th>维度ID</th>
                                    <th>维度名称</th>
                                    <th>是否显示</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%
                                    for(Search search : list){
                                %>
                                <tr>
                                    <td><%=search.getId()%></td>
                                    <td class="center"><%=search.getName()%></td>
                                    <td class="center">
                                        <input class="is_view" type="checkbox" onclick="update(this,<%=search.getId()%>)"  <%if(search.getIs_view().equals("1")){%>checked<%}%>>
                                    </td>
                                </tr>
                                <%}%>
                                </tbody>
                            </table>
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
                            <h4 class="modal-title">新增维度</h4>
                        </div>
                        <div class="modal-body">
                            <form class="form-horizontal" action="/user/doSet" method="post">
                                <fieldset>
                                    <div class="input-group input-group-sm">
                                        <span class="input-group-addon"><i
                                                class="glyphicon glyphicon-user red"></i></span>
                                        <input type="text" class="form-control" name="email" placeholder="邮箱">
                                    </div>
                                    <div class="clearfix"></div>
                                    <br>

                                    <div class="input-group input-group-sm">
                                        <span class="input-group-addon"><i
                                                class="glyphicon glyphicon-lock red"></i></span>
                                        <input type="password" class="form-control" name="passWord" placeholder="密码">
                                    </div>
                                    <div class="clearfix"></div>

                                    <div class="input-prepend">
                                        <label class="remember" for="remember"><input type="checkbox" id="remember">是否启用</label>
                                    </div>
                                    <div class="clearfix"></div>

                                </fieldset>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            <button type="button" class="btn btn-primary">保存</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->

            <!--弹窗-->
        </div>
    </div>
</div>
<div id="btn-dialogBox"></div>

<!-- external javascript -->
<!-- library for cookie management -->

<script src="../static/js/jquery-1.11.1.min.js"></script>

<script src="../static/js/jquery.cookie.js"></script>
<!-- data table plugin -->
<script src='../static/js/jquery.dataTables.min.js'></script>

<!-- notification plugin -->
<script src="../static/js/jquery.noty.js"></script>

<script src="../static/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>


<!-- select or dropdown enhancer -->
<script src="../static/bower_components/chosen/chosen.jquery.min.js"></script>
<!-- plugin for gallery image view -->
<script src="../static/bower_components/colorbox/jquery.colorbox-min.js"></script>

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

<!-- calender plugin -->
<script src='../static/bower_components/moment/min/moment.min.js'></script>
<script src='../static/bower_components/fullcalendar/dist/fullcalendar.min.js'></script>


<!-- library for making tables responsive -->
<script src="../static/bower_components/responsive-tables/responsive-tables.js"></script>
<!-- tour plugin -->
<script src="../static/bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>

<!-- application script for Charisma demo -->
<script src="../static/js/charisma.js"></script>
<script src="../static/js/echarts.min.js"></script>
<script src="../static/js/bootstrap-modal.js"></script>
<script type="text/javascript" src="../static/js/jquery.dialogBox.js"></script>

<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/china.js"></script>

<script type="text/javascript">
//    $('.is_view').click(function(){
//        var self = $(this);
//        if(self[0].checked){
//            alert(1);
//            var id = self[0].parent().parent().first();
//            alert(id);
//        }else{
//            alert(0);
//        }
//    });

    function update(that,id) {
        var self = $(that);
        var is_view = 1;
        if(self[0].checked){
            is_view = 1;
        }else{
            is_view = 0;
        }
        $.ajax({
            url: '/user/update',
            type:'get',
            data:'id='+id+'&is_view='+is_view,
            success:function (data) {
                $('#btn-dialogBox').dialogBox({
                    width: 200,
                    height: 80,
                    autoHide: true,
                    time: 2000,
                    effect: 'flip-horizontal',
                    title: '提示',
                    content: '操作成功!'
                });
            }
        })
    }

</script>
</body>
</html>
