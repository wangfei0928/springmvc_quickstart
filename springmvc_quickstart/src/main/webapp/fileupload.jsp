<%--
  Created by IntelliJ IDEA.
  User: 王斐
  Date: 2022/5/14
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
编写一个满足文件三要素的表单
1. 表单的提交方式 必须是post
2. 表单的enctype属性必须要修改成multipart/form-data
3. 表单必须要有文件上传项
--%>
<form method="post" action="${pageContext.request.contextPath}/fileupload" enctype="multipart/form-data">
    名称：<input type="text" name="username"><br>
    文件：<input type="file" name=" filePic"><br>
    <input type="submit" value="单文件上传">
</form>

<form method="post" action="${pageContext.request.contextPath}/filesupload" enctype="multipart/form-data">
    名称：<input type="text" name="username"><br>
    文件：<input type="file" name=" filePic"><br>
    文件：<input type="file" name=" filePic"><br>
    <input type="submit" value="多文件上传">
</form>
</body>
</html>
