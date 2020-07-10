<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>购物车</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
</head>
<body>
<!--------------------------------------cart--------------------->
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
<div class="cart mt">
<!-----------------logo------------------->
    <div class="site">
    <p class=" wrapper clearfix">
	    <span class="fl">购物车</span>
	    <img class="top" src="img/temp/cartTop01.png">
	    <a href="IndexSelect" class="fr">继续购物&gt;</a>
    </p>
    </div>
<!-----------------table------------------->
    <div class="table wrapper">
        <div class="tr">
            <div>商品</div>
            <div>单价</div>
            <div>数量</div>
            <div>小计</div>
            <div>操作</div>
        </div>
        
        <c:forEach var="rs" items="${shoplist }">
	        <div class="th">
	            <div class="pro clearfix">
		            <label class="fl">
		            	<input name="ck" type="checkbox" value="${rs.cart_id }"/><span></span>
		            </label>
		            <a class="fl" href="SelectProductDetail?id=${rs.cart_p_id }">
		                <dl class="clearfix">
		                    <dt class="fl"><img src="images/product/${rs.cart_p_filename }" height="120px"></dt>
		                    <dd class="fl">
		                    	<p>书名：</p>
		                    	<p>${rs.cart_p_name }</p>
		                    </dd>
		                </dl>
		            </a>
	            </div>
	            <div class="price">￥${rs.cart_p_price }</div>
	            <div class="number">
		            <p class="num clearfix">
			            <img class="fl sub" src="img/temp/sub.jpg">
			            <span datasrc="${rs.cart_id }" class="fl">${rs.cart_quantity }</span>
			            <img class="fl add" src="img/temp/add.jpg">
		            </p>
	            </div>
	            <div class="price sAll">￥${rs.cart_p_price * rs.cart_quantity}</div>
	            <div class="price">
	            	<a datasrc="${rs.cart_id }" class="del" href="#2">删除</a>
	            </div>
	        </div>
        </c:forEach>
        
        <div class="goOn">空空如也~<a href="IndexSelect">去逛逛</a></div>
        <div class="tr clearfix">
        	<label class="fl"><input class="checkAll" type="checkbox"/><span></span></label>
            <p class="fl">
	            <a href="#">全选</a>
	            <a href="#" class="del">删除</a>
            </p>
            <p class="fr">
	            <span>共<small id="sl">0</small>件商品</span>
	            <span>合计:&nbsp;<small id="all">￥0.00</small></span>
	            <a href="javascript:toOrder()" class="count">结算</a>
            </p>
       </div>
    </div>
</div>

<script>
	function toOrder(){
		var str="";
		$("input[name='ck']:checked").each(function(index,item){
			if($("input[name='ck']:checked").length-1==index){
				str+=$(this).val();
				
			}else{
				str+=$(this).val()+",";
			}
			
		});
		location.href="OrderSelect?eids="+str;
	}
</script>

<div class="mask"></div>
<div class="tipDel">
	<p>确定要删除该商品吗？</p>
    <p class="clearfix"><a class="fl cer" href="#">确定</a><a class="fr cancel" href="#">取消</a></p>
</div>

<%@ include file="footer.jsp" %>



<div class="pleaseC"><p>请选择宝贝</p><img class="off" src="img/temp/off.jpg"/></div>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>