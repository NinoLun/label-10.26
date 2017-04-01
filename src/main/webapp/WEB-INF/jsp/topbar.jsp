<%@ page import="com.score.api.model.Auth" %>
<%@ page language="java"
         contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    Auth auth = (Auth) request.getSession().getAttribute("user");
%>
<div class="navbar navbar-default" role="navigation">
    <div class="navbar-inner">
        <a class="navbar-brand" href="/user/index" style="width:190px;">
            <img alt="趋享智能●云策" src="../static/img/logo-new.png" class="hidden-xs"/>
            <span>趋享智能●云策</span></a>

        <!-- user dropdown starts -->
        <div class="btn-group pull-right animated">
            <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                <i class="glyphicon glyphicon-user"></i><span class="hidden-sm hidden-xs"><%=auth.getUserName()%></span>
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu">
                <li><a href="/user/index">首页</a></li>
                <li class="divider"></li>
                <li><a href="/user/out">退出</a></li>
            </ul>
        </div>
    </div>
</div>