<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web1画面</title>
</head>
<body>
ハロー
<%=request.getAttribute("name") %>

<form method="post" action="example-tx">
    <input type="submit" value="送信">
</form>

</body>
</html>
