<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
    <meta charset="UTF-8"/>
    <title>系统后台管理</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
</head>
<body>
<div class="topbar-wrap white">
     <div class="topbar-logo-wrap clearfix">
         <ul class="navbar-list clearfix">
             <li><a class="on" href="admin_index.jsp">首页</a></li>
             <li><a href="/MonkeyShop/IndexSelect" target="_blank">网站首页</a></li>
             <li><a href="AdminLogout">退出</a></li>
         </ul>
     </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>常用操作</a>
                    <ul class="sub-menu">
                        <li><a href="admin_DoUserSelect"><i class="icon-font">&#xe008;</i>用户管理</a></li>
                        <li><a href="admin_CateSelect"><i class="icon-font">&#xe005;</i>分类管理</a></li>
                        <li><a href="admin_ProductSelect"><i class="icon-font">&#xe006;</i>图书管理</a></li>
                        <li><a href="admin_order.jsp"><i class="icon-font">&#xe004;</i>订单管理</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
