<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <%--<meta http-equiv="Content-Type" content="text/html; charset=utf-8">--%>
    <script type="text/javascript" src="jquery/jquery-3.4.1.min.js"></script>
</head>
<body>
<h2>Hello World!</h2>

<form action="<%=application.getContextPath()%>/login.action">
    用户名:<input type='text' name="username">
    <br/>
    密码:<input type="password" name="password">
    <input type="submit" value="提交">
    <input id="testAjax" type="button" value="测试">
</form>
<script type="text/javascript">
    $(function() {
        console.log(22);
    })
</script>
</body>
</html>