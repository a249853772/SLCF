<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'testJson.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="JQUERY/jquery-3.2.1.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <form>
       id：<input type="text" id="id" value="123" /><br/>
       名称：<input type="text" id="name" value="category xxx"/><br/>
        <input type="button" value="提交" id="sender"> 
    </form>
    <div id="messageDiv"></div>
    
    <input type="button" value="通过AJAX获取一个Hero对象---" id="sender2"> 
     
    <input type="button" value="通过AJAX获取多个分类对象" id="sender3">      
    
  </body>
  <script type="text/javascript">
    $('#sender').click(function(){
        var id=document.getElementById('id').value;
        var name=document.getElementById('name').value;
        var category={"name":name,"id":id};
        var jsonData = JSON.stringify(category);
        var page="testJSON/category";
          
        $.ajax({
               type:"put",
               url: page,
               data:jsonData,
               dataType:"json",
               contentType : "application/json;charset=UTF-8",
               success: function(result){
               }
            });
           alert("提交成功，请在springboot控制台查看服务端接收到的数据");
  
    });
    
    $('#sender2').click(function(){
        var url="testJSON/category/6";
        $.get(
                url,
                function(data) {
                    console.log(data);
                     var json=data;
                     var name =json.name;
                     var id = json.id;
                     $("#messageDiv").html("分类id："+ id + "<br>分类名称:" +name );
                        
         }); 
    });
    
    $('#sender3').click(function(){
        var url="testJSON/category?start=0&size=100";
        $.get(
                url,
                function(data) {
                    var categorys = data;
                     for(i in categorys){
                         var old = $("#messageDiv").html();
                         var category = categorys[i];
                         $("#messageDiv").html(old + "<br>"+category.id+"   -----   "+category.name);
                     }
         }); 
    });
    </script>
</html>
