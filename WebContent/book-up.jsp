<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="BookUpdateServlet"method="post">
<div >
<label for="move" >图书编号</label>
<input type="text" name="book_id"
            placeholder="请输入图书编号">
            <label for="on" >图书名称</label>
<input type="text" name="book_name"
            placeholder="请输入图书名称">
            <label for="goon" >图书价格</label>
<input type="text" name="book_price"
            placeholder="请输入图书价格">
</div>
 <input type="submit" value="提交">
        <input type="reset" value="重置">
</body>
</html>