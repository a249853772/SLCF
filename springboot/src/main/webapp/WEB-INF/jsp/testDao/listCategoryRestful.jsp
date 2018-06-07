<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'listCategoryRestful.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="JQUERY/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
	 /*将post method 改变为delete*/
      $(function(){                    
           $(".delete").click(function(){
               var href=$(this).attr("href");
               $("#formdelete").attr("action",href).submit();
               return false;
           })
       })
	
	</script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div style="width:500px;margin:20px auto;text-align: center">
    <table align='center' border='1' cellspacing='0'>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>编辑</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${page.content}" var="c" varStatus="st">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td><a href="category/${c.id}">编辑</a></td>
                <td><a class="delete" href="category/${c.id}">删除</a></td>
            </tr>
        </c:forEach>
         
    </table>
    <br>
    <div>
                <a href="<%=basePath%>category?start=0">[首  页]</a>
            <a href="<%=basePath%>category?start=${page.number-1}">[上一页]</a>
            <a href="<%=basePath%>category?start=${page.number+1}">[下一页]</a>
            <a href="<%=basePath%>category?start=${page.totalPages-1}">[末  页]</a>
    </div>
    <br>
    <form action="category" method="post">
        <input type="hidden" name="_method" value="PUT">
    name: <input name="name"> <br>
    <button type="submit">提交</button>
     
    </form>
     
    <form id="formdelete" action="" method="POST" >
       <input type="hidden" name="_method" value="DELETE">
   </form>
</div>
  </body>
</html>
