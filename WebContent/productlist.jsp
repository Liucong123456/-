<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>${title }</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
</head>
<body>
<!------------------------------head------------------------------>
<%@ include file="header.jsp" %>

<!-----------------address------------------------------->
<div class="address">
    <div class="wrapper clearfix">
    <a href="IndexSelect">首页</a><span>/</span>
    <a href="#" class="on">${title }</a></div>
</div>
<!-------------------current---------------------->
<div class="current">
    <div class="wrapper clearfix"><h3 class="fl">${title }</h3>
        <div class="fr choice"><p class="default">排序方式</p>
            <ul class="select">
                <li>新品上市</li>
                <li>销量从高到低</li>
                <li>销量从低到高</li>
                <li>价格从高到低</li>
                <li>价格从低到高</li>
            </ul>
        </div>
    </div>
</div>
<!----------------proList------------------------->
<ul class="proList wrapper clearfix">

	<c:forEach var="p" items="${list }">
    <li><a href="SelectProductDetail?id=${p.PRODUCT_ID }">
        <dl>
            <dt><img src="images/product/${p.PRODUCT_FILENAME }"></dt>
            <dd>${p.PRODUCT_NAME }</dd>
            <dd>￥${p.PRODUCT_PRICE }</dd>
        </dl>
    </a></li>
    </c:forEach>
    
</ul>

<%@ include file="footer.jsp" %>

<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>