<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Forms</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/styles/cssverticalmenu.css" />

<script src="../jquery/js/jquery-ui-1.8.11.custom.min.js"></script></head>
<body>
	<table>
		<tr>
			<td width="200">
				
			</td>
			
		</tr>
		<tr>
			<td align="left">
				<tiles:insertAttribute name="menu" />
			</td>
			<td><tiles:insertAttribute name="body" /></td>
		</tr>
	</table>
</body>
</html>