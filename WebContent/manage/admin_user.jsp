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
            <span class="crumb-name">用户管理</span>
            </div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="/MonkeyShop/manage/admin_DoUserSelect" method="get">
                    <table class="search-tab">
                        <tr>
                           
                            <th width="70">关键字:</th>
                            <td><input class="common-text" placeholder="关键字" name="keywords" value="${param.keywords }" id="" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form action="admin_DoUserDel?cpage=${cpage }" name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="admin_useradd.jsp"><i class="icon-font">&#xe026;</i>新增用户</a>
                        <a id="batchDel" href="javascript:delmore('你确定删除这些用户吗？','myform')"><i class="icon-font">&#xe019;</i>批量删除</a>
                        
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" onclick="selectall(this)" type="checkbox"></th>
                            <th>ID</th>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>email</th>
                            <th>手机</th>
                            <th>操作</th>
                        </tr>
                        
                        <c:forEach var="u" items="${userlist }">
                        <tr>
                            <td class="tc"><input name="id[]" value="${u.USER_ID }" type="checkbox"></td>
                            <td>${u.USER_ID }</td>
                            <td>${u.USER_NAME }</td>
                            <td>${u.USER_SEX=='M'? '男' : '女'}</td>
                            <td>${u.USER_EMAIL }</td>
                            <td>${u.USER_MOBILE }</td>
                            
                            <td>
                                <a class="link-update" href="admin_ToUserUpdate?id=${u.USER_ID }&cpage=${cpage }">修改</a>
                                
                                <c:if test="${u.USER_STATUS==1 }">
                                <a class="link-del" href="javascript:Delete('你确定要删除用户【${u.USER_NAME }】吗？','admin_DoUserDel?id=${u.USER_ID}&cpage=${cpage }')">删除</a>
                                </c:if>
                                
                            </td>
                        </tr>
                        </c:forEach>
                        
                        <script>
                        	function Delete(mess,url){
                        		if(confirm(mess)){
                        			location.href=url;
                        		}
                        	}
                        	
                        	function selectall(o){
                      
                        		var a=document.getElementsByName('id[]');
                        		for(var i=0;i<a.length;i++){
                        			a[i].checked=o.checked;
                        		}
                        	}
                        	
                        	function delmore(mess,formname){
                        		if(confirm(mess)){
                        			var form=document.getElementById(formname);
                        			form.submit();
                        		}
                        	}
                        </script>
                        
                    </table>
                    <div class="list-page"> 
                     	共${tsum }条记录，当前 ${cpage }/${tpage } 页
                   		<a href="admin_DoUserSelect?cp=1${searchParams }">首页</a>
                   		<a href="admin_DoUserSelect?cp=${cpage-1<=0?1:cpage-1 }${searchParams }">上一页</a>
                   		<a href="admin_DoUserSelect?cp=${cpage+1>tpage?tpage:cpage+1 }${searchParams }">下一页</a>
                   		<a href="admin_DoUserSelect?cp=${tpage }${searchParams }">尾页</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>