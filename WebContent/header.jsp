<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<div class="head">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top">
        	<h1 class="fl"><a href="index.jsp"><img src="img/logo.png"/></a></h1>
            <div class="fr clearfix" id="top1">
            <p class="fl">
            
            <c:if test="${ isLogin !=1 }">
            <a href="login.jsp" id="login">登录</a><a href="regist.jsp" id="reg">注册</a>
            </c:if>
            
            <c:if test="${ isLogin ==1 }">
            	<b>你好：</b><a href="login.jsp" id="login">${user.USER_NAME }</a>
            </c:if>
            
            <c:if test=" ${ isAdminLogin ==1 }">
            	<a href="/MonkeyShop/manage/admin_index.jsp" id="login1">进入后台</a>
            </c:if>
            
            </p>
                <form action="#" method="get" class="fl"><input type="text" placeholder="热门搜索：python"/>
                <input type="button"/></form>
                <div class="btn fl clearfix">
                	<a href="mygxin.jsp"><img src="img/grzx.png"/></a>
                	
                	<c:if test="${isLogin==1 }">
                    <a href="ShowCart"><img src="img/gwc.png"/></a>
                    </c:if>
                    
                    <p><a href="#"><img src="img/smewm.png"/></a></p></div>
            </div>
        </div>
        <ul class="clearfix" id="bott">
            <li><a href="IndexSelect">首页</a></li>
            
            <c:forEach var="f" items="${flist }">
      
	            <li><a href="SelectProductList?fid=${f.CATE_ID }">${f.CATE_NAME }</a>
	                <div class="sList2">
	                    <div class="clearfix">
	                    	<c:forEach var="c" items="${clist }">
	                    		<c:if test="${f.CATE_ID==c.CATE_PARENT_ID }">
	                    			<a href="SelectProductList?cid=${c.CATE_ID }">${c.CATE_NAME }</a>
	                    		</c:if>
	                    	</c:forEach>
	                    </div>
	                </div>
	            </li>
            </c:forEach>
        </ul>
    </div>
</div>