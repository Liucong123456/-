<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>个人信息</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/mygxin.css"/>
</head>
<body><!------------------------------head------------------------------>
<div class="head ding">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top">
        <h1 class="fl"><a href="index.jsp"><img src="img/logo.png"/></a></h1>
        	<div class="fr clearfix" id="top1">
                <form action="#" method="get" class="fl">
	                <input type="text" placeholder="搜索"/>
	                <input type="button"/>
                </form>
            </div>
        </div>
    </div>
</div>
<!------------------------------idea------------------------------>
<div class="address mt" id="add">
    <div class="wrapper clearfix">
    	<a href="IndexSelect" class="fl">首页</a><span>/</span>
    	<a href="mygxin.jsp" class="on">个人中心</a>
    </div>
</div><!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <div class="zuo fl">
            <h3><a href="#"><img src="img/tx.png"/></a>
                <p class="clearfix">
                	<span class="fl">[${user.USER_NAME }]</span>&nbsp;
                	<span class="fl"><a href="Logout">[退出登录]</a></span>
                </p>
            </h3>
            <div>
            	<h4>我的交易</h4>
                <ul>
                    <li><a href="ShowCart">我的购物车</a></li>
                    <li><a href="#">我的订单</a></li>
                    <li><a href="#">评价晒单</a></li>
                </ul>
                <h4>个人中心</h4>
                <ul>
                    <li class="on"><a href="mygxin.jsp">我的中心</a></li>
                    <li><a href="#">地址管理</a></li>
                </ul>
                <h4>账户管理</h4>
                <ul>
                    <li><a href="#">个人信息</a></li>
                    <li><a href="#">修改密码</a></li>
                </ul>
            </div>
        </div>
        <div class="you fl">
            <div class="tx clearfix">
                <div class="fl clearfix">
                	
                    <p class="fl"><span>${user.USER_NAME }</span><a href="#">修改个人信息></a></p></div>
                <div class="fr">绑定邮箱：${user.USER_EMAIL }</div>
            </div>
            <div class="bott">
                <div class="clearfix"><a href="#" class="fl"><img src="img/gxin1.jpg"/></a>
                    <p class="fl"><span>待支付的订单：<strong>0</strong></span><a href="myorderq.html">查看待支付订单></a></p></div>
                <div class="clearfix"><a href="#" class="fl"><img src="img/gxin2.jpg"/></a>
                    <p class="fl"><span>待收货的订单：<strong>0</strong></span><a href="myorderq.html">查看待收货订单></a></p></div>
                <div class="clearfix"><a href="#" class="fl"><img src="img/gxin3.jpg"/></a>
                    <p class="fl"><span>待评价的订单：<strong>0</strong></span><a href="myprod.html">查看待评价订单></a></p></div>
                <div class="clearfix"><a href="#" class="fl"><img src="img/gxin4.jpg"/></a>
                    <p class="fl"><span>喜欢的商品：<strong>0</strong></span><a href="#">查看喜欢的商品></a></p></div>
            </div>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>

<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>