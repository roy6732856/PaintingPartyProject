<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>您尚未登入，三秒後自動跳轉</h1>

 <script type="text/javascript">  
 
     setTimeout("redirect()",3000);
     function redirect(){
         window.location.href = "<%=request.getContextPath() %>/login" ;
     }

   
 </script> 

</body>
</html>