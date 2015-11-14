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
	document.forms[0].action="submitEditSalt";
	document.forms[0].submit(); 
};
	$(document).ready(function() {
	  var opt=$('#sType').val();
	  $('#schType').val(opt);
	  var opt1=$('#pres').val();
	  $('#prescptnReq').val(opt1);
	  var opt2=$('#isAct').val();
	  $('#isActive').val(opt2);
	});
</script>
<body>
	<table border="0" align="left" cellpadding="0" cellspacing="0"
		class="Table2" width="900px">
		<tr>
			<td class="tableheadertd1" align="left">Edit Salt Info Form</td>
		</tr>
		<tr>
			<td>
				<table border="0" cellpadding="2" cellspacing="0" class="Table2"
					width="900px">
					<form:form action="" id="employeeLeaveForm" commandName="saltDO"
						name="saltForm">
						<table border="1" align="left" cellpadding="0" cellspacing="0"
							width="900px">
						
							<%-- <input type="hidden" id="salId" value="${saltDO.saltId}"> --%>
							<form:hidden path="saltId"/>
							<tr>
								<td class="table_forms_td1_1">Salt Name :<font color="red">*</font></td>
								<td colspan="2"><form:input path="saltName" id="saltName" />	
								</td>
								<td class="table_forms_td1_1">Schedule Type :<font
									color="red">*</font></td>
								<td colspan="2">
								<input type="hidden" id="sType" value="${saltDO.schType}">
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
								<input type="hidden" id="pres" value="${saltDO.prescptnReq}">
								<select id="prescptnReq" name="prescptnReq">
										<option value="-1">--Select--</option>
										<option value="Y">Yes</option>
										<option value="N">No</option>
								</select></td>
								
								<td class="table_forms_td1_1">Is Active :<font
									color="red">*</font></td>
									
								<td colspan="2">
								
								<input type="hidden" id="isAct" value="${saltDO.isActive}">
								<select id="isActive" name="isActive">
										<option value="-1">--Select--</option>
										<option value="Y">Yes</option>
										<option value="N">No</option>
								</select></td>
							</tr>
							<tr>
								<td colspan="9" class="button" align="center"><input
									type="button" value="Update" id="proceed"
									style="color: black" onclick="doValidation();" /></td>
							</tr>

						</table>

						
					</form:form>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>