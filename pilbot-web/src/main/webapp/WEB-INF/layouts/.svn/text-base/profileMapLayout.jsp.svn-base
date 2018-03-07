<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <meta http-equiv="X-UA-Compatible" content="IE=8" /> -->
<style type="text/css" media="screen">	
	 @import url("<%=request.getContextPath()%>/styles/profileMapStyle.css");
</style>
 <script src="<%=request.getContextPath()%>/jquery/js/jquery.min.js"></script>
 <script src="<%=request.getContextPath()%>/jquery/js/jquery-ui.min.js"></script>
<script src="<%=request.getContextPath()%>/jquery/js/jquery-ui-1.8.11.custom.min.js"></script>	
 
<title>Insert title here</title>

<script type="text/javascript">
function back(){
	history.go(-1);
}

</script>
<script src="../jquery/js/jquery-ui-1.8.11.custom.min.js"></script></head>
<body>
<div align="center">
	
	<c:if test="${action=='OM' }"><div style="font-weight:bold;font-size:20px;">Only Map Process</div></c:if>
	<c:if test="${action=='RM' }"><div style="font-weight:bold;font-size:20px;">Refund and Map Process</div></c:if>
	
	<tiles:insertAttribute name="body" />
</div>
</body>
</html>