<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="java.util.*"%>
<HTML>
<HEAD>
<style type="text/css" media="screen">
@import url("../styles/style1.css");

@import url("../styles/style2.css");
</style>
<link href="../jquery/css/jquery-ui.css" rel="stylesheet"
	type="text/css" />
<script src="../jquery/js/jquery.min.js"></script>
<script src="../jquery/js/jquery-ui.min.js"></script>
<script src="../calender/datetimepicker_css.js"></script>
<script src="../jquery/js/jquery-ui-1.8.11.custom.min.js"></script>

</head>
<script type="text/javascript">

function doValidation()
{	
	document.forms[0].action="submitBrandInfo";
	document.forms[0].submit(); 
};

</script>
<body>
	<table border="0" align="left" cellpadding="0" cellspacing="0"
		class="Table2" width="1000px">
		<tr>
			<td class="tableheadertd1" align="left">Brand Master Form</td>
		</tr>
		<tr>
			<td>
				<table border="0" cellpadding="2" cellspacing="0" class="Table2"
					width="1000px">
					<form:form action="" id="brandInfoForm" commandName="brandDO"
						name="saltForm">
						<table border="1" align="left" cellpadding="0" cellspacing="0"
							width="900px">


							<tr>
								<td class="table_forms_td1_1">Brand Name:<font color="red">*</font></td>
								<td colspan="2"><form:input path="brandName" id="brandName" />	
								</td>
								
								<td class="table_forms_td1_1">Manufacture Name:<font color="red">*</font></td>
								<td colspan="2"><form:input path="manufactureName" id="manufactureName" />	
								</td>
								
								<td class="table_forms_td1_1">Dosage Strength:<font color="red">*</font></td>
								<td colspan="2"><form:input path="dosageStrength" id="dosageStrength" />	
								</td>
								<td class="table_forms_td1_1">Price:<font color="red">*</font></td>
								<td colspan="2"><form:input path="price" id="price" />	
								</td>
								
								<td class="table_forms_td1_1">Unit:<font color="red">*</font></td>
								<td colspan="2"><form:input path="unit" id="unit" />	
								</td>
								
								<td class="table_forms_td1_1">Is Generic :<font
									color="red">*</font></td>
								<td colspan="2"><select id="isGeneric" name="isGeneric">
										<option value="-1">--Select--</option>
										<option value="Y">Yes</option>
										<option value="N">No</option>
								</select></td>
								
							
							<tr>
								<td colspan="9" class="button" align="center"><input
									type="button" value="Save" id="proceed"
									style="color: black" onclick="doValidation();" /></td>
							</tr>

						</table>

						
					</form:form>
				</table>	
				
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				
			
				<TABLE border="1" align="center" cellpadding="1" cellspacing="1" class="Table2" width="1000px" id="results">
			        <tr>
			            <th align="center" >Sr.No</th>       
			            <th align="center" >Brand Name</th>       
						<th align="center" >Manufacturer Name</th>
						<th align="center" >Dosage Strength</th>
						<th align="center" >Price</th>
						<th align="center" >Unit</th>
						<th align="center" >Delete</th>
					</tr>
					<c:forEach  items="${brands}" var="m" varStatus="i">
					<tr>
						<td align="center">${i.count}</td>
						<td align="left">${m.brandName}</td>
						<td align="left">${m.manufactureName}</td>
						<td align="left">${m.dosageStrength}</td>
						<td align="left">${m.price}</td>
						<td align="left">${m.unit}</td>
						<td>
						<a href="./deleteBrand?selectedId=${m.brandId}">Delete</a>
						&nbsp;&nbsp;
						<a href="./editBrand?selectedId=${m.brandId}">Edit</a>
						
						</td>
					</tr>											
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>