<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
</head>
<body>
<!------------------------------head------------------------------>
<%@ include file="header.jsp" %>

<!------------------------------people------------------------------>
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
<!------------------------------footer------------------------------>
<%@ include file="footer.jsp" %>

<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>

</body>
</html>