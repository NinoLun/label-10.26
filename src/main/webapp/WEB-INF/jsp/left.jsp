<%@ page language="java"
         contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<!-- left menu starts -->
<div class="col-sm-2 col-lg-2 col-md-2 col-xs-2">
    <div class="sidebar-nav">
        <div class="nav-canvas">
            <%--<div class="nav-sm nav nav-stacked">--%>
            <%--</div>--%>
            <ul class="nav  nav-pills nav-stacked main-menu">
                <li class="nav-header text-center">导航</li>
                <li><a class="ajax-link" href="/user/index">
                    <i class="glyphicon glyphicon-home"></i><span> 客群分析</span></a>
                </li>
                <li><a class="ajax-link" href="/customer/cusList"><i
                        class="glyphicon glyphicon-book"></i><span> 客群管理</span></a>
                </li>
                <li><a class="ajax-link" href="/user/set">
                    <i class="glyphicon glyphicon-adjust"></i><span> 分析配置</span></a>
                </li>
                <li><a class="ajax-link" href="/task/list"><i
                        class="glyphicon glyphicon-eye-open"></i><span> 任务管理</span></a>
                </li>
                <li><a class="ajax-link" href="/user/list"><i
                        class="glyphicon glyphicon-asterisk"></i><span> 用户管理</span></a>
                </li>

            </ul>
        </div>
    </div>
</div>
<!--/span-->
<!-- left menu ends -->