<%--
  Created by IntelliJ IDEA.
  User: 王斐
  Date: 2022/5/12
  Time: 7:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <a href="${pageContext.request.contextPath}/user/simpleParam?id=1&username=杰克">基本类型</a>

    <form action="${pageContext.request.contextPath}/user/pojoParam" method="post">
    id：<input type="text" name="id"><br>
    用户名：<input type="text" name="username"><br>
    <input type="submit" value="提交">
    </form>

    <%--演示获取数组类型参数--%>
    <form action="${pageContext.request.contextPath}/user/arrayParam" method="post">
        <input type="checkbox" value="1" name="ids">1<br>
        <input type="checkbox" value="2" name="ids">2<br>
        <input type="checkbox" value="3" name="ids">3<br>
        <input type="checkbox" value="4" name="ids">4<br>
        <input type="checkbox" value="5" name="ids">5<br>
        <input type="checkbox" value="6" name="ids">6<br>
        <input type="submit" value="提交">
    </form>

    <%--演示获取集合类型参数--%>
    <form action="${pageContext.request.contextPath}/user/queryParam" method="post">
       搜索关键字：<br>
        <input type="text" name="keyword"><br>
        user对象：<br>
        <input type="text" name="user.id" placeholder="编号"><br>
        <input type="text" name="user.username" placeholder="姓名"><br>
        list集合<br>
        第一个元素<br>
        <input type="text" name="userList[0].id" placeholder="编号"><br>
        <input type="text" name="userList[0].username" placeholder="姓名"><br>
        第二个元素<br>
        <input type="text" name="userList[1].id" placeholder="编号"><br>
        <input type="text" name="userList[1].username" placeholder="姓名"><br>
        map集合<br>
        第一个元素<br>
        <input type="text" name="userMap['u1'].id" placeholder="编号"><br>
        <input type="text" name="userMap['u2'].username" placeholder="姓名"><br>
        第二个元素<br>
        <input type="text" name="userMap['u1'].id" placeholder="编号"><br>
        <input type="text" name="userMap['u2'].username" placeholder="姓名"><br>
        <input type="submit" value="提交">
    </form>
    <%--演示自定义类型转换器--%>
    <<form action="${pageContext.request.contextPath}/user/converterParam">
        生日：<input type="text" name="birthday">
        <input type="submit" value="自定义类型转换器">
    </form>

    <%--演示requestParam--%>
    <a href="${pageContext.request.contextPath}/user/findBypage?pageNo=2">分页查询</a>
</html>
