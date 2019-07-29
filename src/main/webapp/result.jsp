<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/10
  Time: 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome</title>
</head>
<body>
total: <s:property value="governmentInfo.total"/>
<br/>
<table border="1px solider #000">
    <thead align="center">
    <tr>
        <td></td>
        <td>所在市县</td>
        <td>所在乡镇</td>
        <td>单位名称</td>
        <td>详细地址</td>
        <td>联系人</td>
        <td>联系电话</td>
        <td>操作</td>
    </tr>
    </thead>
    <tbody align="center">
    <s:iterator value="governmentInfo.list" var="gov" status="st">
        <s:set name="flag" value="governmentInfo.startRow + #st.index"/>
        <tr>
            <td><s:property value="#flag"/></td>
            <td><s:property value="cityId"/></td>
            <td><s:property value="townId"/></td>
            <td><s:property value="orgName"/></td>
            <td><s:property value="orgAddress"/></td>
            <td><s:property value="linkPerson"/></td>
            <td><s:property value="linkPhone"/></td>
            <td>
                <button>查看</button>
                <button>修改</button>
                <button>删除</button>
            </td>
        </tr>
    </s:iterator>
    </tbody>
</table>
<s:iterator value="governmentInfo.navigatepageNums" var="pgn">
    <s:if test="#pgn==governmentInfo.pageNum">
        <a><s:property/></a>
    </s:if>
    <s:else>
        <s:a href="%{#request.get('javax.servlet.forward.context_path')+'/getGovPage.action?pageNum='+#pgn}"><s:property/></s:a>
    </s:else>

</s:iterator>

</body>
</html>
