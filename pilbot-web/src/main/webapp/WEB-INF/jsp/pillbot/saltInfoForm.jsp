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
	document.forms[0].action="submitSaltInfo";
	document.forms[0].submit(); 
};
</script>
<body>
	<table border="0" align="left" cellpadding="0" cellspacing="0"
		class="Table2" width="1000px">
		<tr>
			<td class="tableheadertd1" align="left">Salt Info Form</td>
		</tr>
		<tr>
			<td>
				<table border="0" cellpadding="2" cellspacing="0" class="Table2"
					width="1000px">
					<form:form action="" id="employeeLeaveForm" commandName="saltDO"
						name="saltForm">
						<table border="1" align="left" cellpadding="0" cellspacing="0"
							width="900px">


							<tr>
								<td class="table_forms_td1_1">Salt Name :<font color="red">*</font></td>
								<td colspan="2"><form:input path="saltName" id="saltName" />	
								</td>
								<td class="table_forms_td1_1">Schedule Type :<font
									color="red">*</font></td>
								<td colspan="2">
								<select id="schType" name="schType">
										<option value="-1">--Select--</option>
										<option value="H">Schedule H</option>
										<option value="L">Schedule L</option>
										<option value="X">Schedule X</option>
										<option value="C">Schedule C</option>
										<option value="C1">Schedule C1</option>
								</select>
								<%-- <form:input path="schType" id="schType" /> --%>

								</td>


								<td class="table_forms_td1_1">Prescription Required :<font
									color="red">*</font></td>
								<td colspan="2">
								<select id="prescptnReq" name="prescptnReq">
										<option value="-1">--Select--</option>
										<option value="Y">Yes</option>
										<option value="N">No</option>
								</select></td>
								
								<td class="table_forms_td1_1">Is Active :<font
									color="red">*</font></td>
								<td colspan="2"><select id="isActive" name="isActive">
										<option value="-1">--Select--</option>
										<option value="Y">Yes</option>
										<option value="N">No</option>
								</select></td>
							</tr>
							<tr>
							<td colspan="2">
							Ailment Description
							<form:textarea path="saltInfoDO[0].ailmentDesc"/>
							</td>
							
							<td colspan="2">
							Ailment Sub type Description
							<form:textarea path="saltInfoDO[0].ailmentSubTypeDesc"/>
							</td>
							
							<td colspan="2">
							How It Works
							<form:textarea path="saltInfoDO[0].howItWorks"/>
							</td>
							
							<td colspan="2">
							Side Effects
							<form:textarea path="saltInfoDO[0].sideEffect"/>
							</td>
							</tr>
							<tr>
							<td colspan="2">
							Intake Advise
							<form:textarea path="saltInfoDO[0].intakeAdvise"/>
							</td>
							
							<td colspan="2">
							FAQ
							<form:textarea path="saltInfoDO[0].faq"/>
							</td>
							
							<td colspan="2">
							Food Advice
							<form:textarea path="saltInfoDO[0].foodAdvise"/>
							</td>
							
							<td colspan="2">
							Source
							<form:textarea path="saltInfoDO[0].source"/>
							</td>
							</tr>
							
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
				<br>
				<br>
				<br>
				<br>
			
				
			
				<form:form action="" id="saltForm1" commandName="saltDO"
						name="saltForm1">
				<TABLE border="1" align="center" cellpadding="1" cellspacing="1" class="Table2" width="1000px" id="results">
			        <tr>
			            <th align="center" >Sr.No</th>       
			            <th align="center" >Salt Name</th>       
						<th align="center"  >Schedule Type</th>
						<th align="center" >Prescription Required</th>
						<th align="center" >Is Active</th>
						<th align="center" >Delete</th>
					</tr>
					<c:forEach  items="${salts}" var="m" varStatus="i">
					<tr>
						<td align="center">${i.count}</td>
						<td align="left">${m.saltName}</td>
						<td align="left">${m.schType}</td>
						<td align="left">
						<c:if test="${m.prescptnReq == 'Y'}">Yes</c:if>  
						<c:if test="${m.prescptnReq == 'N'}">No</c:if>  
						
						</td>
						<td align="left">
						<c:if test="${m.isActive == 'Y'}">Yes</c:if>  
						<c:if test="${m.isActive == 'N'}">No</c:if>  
						</td>
						<td>
						<a href="./deleteSalt?selectedId=${m.saltId}">Delete</a>
						<form:hidden id="selectedId" path="selectedId"/>
						&nbsp;&nbsp;
						<a href="./editSalt?selectedId=${m.saltId}">Edit</a>
						
						</td>
					</tr>											
					</c:forEach>
				</table>
				</form:form>
			</td>
		</tr>
	</table>
</body>
</html>