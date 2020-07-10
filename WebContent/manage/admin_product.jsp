<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp"%>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font">&#xe000;</i>
            <a href="admin_index.jsp">首页</a>
            <span class="crumb-step">&gt;</span>
            <span class="crumb-name">图书管理</span>
            </div>
        </div>
        
        <div class="result-wrap">
            <form action="admin_DoUserDel?cpage=${cpage }" name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="admin_ToProductAdd"><i class="icon-font">&#xe026;</i>新增图书</a>
                  
                        
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="60%">
                        <tr>
                            <th>ID</th>
                            <th>分类名称</th>
                            <th>操作</th>
                        </tr>
                        
                        <c:forEach var="p" items="${plist }">
	                        <tr>
	                        	<td>${p.PRODUCT_ID }</td>
	                        	
	                        	<td>
	                        		<img src="../images/product/${p.PRODUCT_FILENAME }" width="80" height="100">
	                        	</td>
	                        	
	                        	<td>
	                        		<a href="">修改</a>
	                        		<a href="">删除</a>
	                        	</td>
	                        </tr>
                        </c:forEach>
                        
                        <script>
                        	function catedel(id){
                        		if(confirm("你确定要删除这个分类吗？")){
                        			location.href="admin_DoCateDel?id="+id;
                        		}
                        	}
                        	
                        </script>
                        
                    </table>
                 </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>