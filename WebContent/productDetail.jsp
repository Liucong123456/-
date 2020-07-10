<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>详情页</title>
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
    	<a href="SelectProductList?cid=${cate.CATE_ID }">${cate.CATE_NAME }</a><span>/</span>
    	<a href="#" class="on">${p.PRODUCT_NAME }</a>
    </div>
</div><!-----------------------Detail------------------------------>
<div class="detCon">
    <div class="proDet wrapper">
        <div class="proCon clearfix">
            <div class="proImg fl"><img class="det" src="images/product/${p.PRODUCT_FILENAME }"/>
                <div class="smallImg clearfix">
                <img src="images/product/${p.PRODUCT_FILENAME }" data-src="images/product/${p.PRODUCT_FILENAME }">
                </div>
            </div>
            <div class="fr intro">
                <div class="title"><h4>${p.PRODUCT_NAME }</h4>
                    <p>【${p.PRODUCT_DESCRIPTION }】【破损补寄】【7天无理由退换货】【包邮】</p><span>￥${p.PRODUCT_PRICE }</span>
                </div>
                <div class="proIntro"><p>选择系列</p>
                    <div class="smallImg clearfix categ">
                    	<p class="fl">
                    		<img src="images/product/${p.PRODUCT_FILENAME }" alt="${p.PRODUCT_NAME }" data-src="images/product/${p.PRODUCT_FILENAME }">
                    	</p>
                    </div>
                    <p>数量&nbsp;&nbsp;库存<span>${p.PRODUCT_STOCK }</span>件</p>
                    <div class="num clearfix">
                    	<img class="fl sub" src="img/temp/sub.jpg">
                    	<span id="count" class="fl" contentEditable="true">1</span>
                    	<img class="fl add" src="img/temp/add.jpg">
                        
                    </div>
                </div>
                
                <div class="btns clearfix">
	                <a href="javascript:shopAdd(${p.PRODUCT_ID },'z')"><p class="buy fl">立即购买</p></a>
	                <a href="javascript:shopAdd(${p.PRODUCT_ID },'s')"><p class="cart fr">加入购物车</p></a>
                </div>
                
            </div>
        </div>
    </div>
</div>

<script>
	function shopAdd(id,url){
		var count=document.getElementById("count").innerHTML;
		location.href='CartAdd?id='+id+'&count='+count+'&url='+url;
		
	}
</script>

<div class="introMsg wrapper clearfix">
    <div class="msgL fl">
        <div class="msgTit clearfix"><a class="on">商品详情</a></div>
	        
	            <div class="msgImgs">
	            	<img src="images/product/${p.PRODUCT_FILENAME }" height="600px">
	            	
	         	</div>
        	
    </div>
    <div class="msgR fr" style="width:210px"><h4>为你推荐</h4>
        <div class="seeList">
        	<c:forEach var="cp" items="${classlist }">
		        <a href="SelectProductDetail?id=${cp.PRODUCT_ID }">
		            <dl>
		                <dt><img src="images/product/${cp.PRODUCT_FILENAME }" width="180px" ></dt>
		                <dd>${cp.PRODUCT_NAME }</dd>
		                <dd>￥${cp.PRODUCT_PRICE }</dd>
		            </dl>
		        </a>
	        </c:forEach>
        </div>
    </div>
</div>
<div class="like"><h4>最近访问</h4>
    <div class="bottom">
        
        <div class="imgCon bd">
            <div class="likeList clearfix">
                <div>
                	
                	<c:forEach var="lp" items="${lastlylist }">
		                <a href="SelectProductDetail?id=${lp.PRODUCT_ID }">
		                    <dl>
		                        <dt><img src="images/product/${lp.PRODUCT_FILENAME }"></dt>
		                        <dd>${lp.PRODUCT_NAME }</dd>
		                        <dd>￥${lp.PRODUCT_PRICE }</dd>
		                    </dl>
		                </a>
	                </c:forEach>
                
                </div>
                
                
            </div>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>

<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">jQuery(".bottom").slide({
    titCell: ".hd ul",
    mainCell: ".bd .likeList",
    autoPage: true,
    autoPlay: false,
    effect: "leftLoop",
    autoPlay: true,
    vis: 1
});</script>
</body>
</html>