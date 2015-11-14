 

//<script type='text/javascript'>

//function formValidator(){
//	// Make quick references to our fields
//	var firstname = document.getElementById('firstname');
//	var addr = document.getElementById('addr');
//	var zip = document.getElementById('zip');
//	var state = document.getElementById('state');
//	var username = document.getElementById('username');
//	var email = document.getElementById('email');
//	
//	// Check each input in the order that it appears in the form!
//	if(isAlphabet(firstname, "Please enter only letters for your name")){
//		if(isAlphanumeric(addr, "Numbers and Letters Only for Address")){
//			if(isNumeric(zip, "Please enter a valid zip code")){
//				if(madeSelection(state, "Please Choose a State")){
//					if(lengthRestriction(username, 6, 8)){
//						if(emailValidator(email, "Please enter a valid email address")){
//							return true;
//						}
//					}
//				}
//			}
//		}
//	}
//	
//
//	return false;
//	
//}

function notEmpty(elem){
	
	var isValidValue = true;
	var fieldLength=elem.value.length;
	
	if(fieldLength == 0){
		
		isValidValue = false;
		alert("This field cannot be blank");
		elem.focus(); // set the focus to this input
		return isValidValue;
	}
	else{
	return isValidValue;
	}
}

function isNumeric(elem){
	var numericExpression = /^[0-9]+$/;
	if(elem.value.match(numericExpression)){
		
		return true;
	}else{
		alert("Enter only Numeric value");
		elem.focus();
		return false;
	}
}

function isNameText(obj) 
{
    var isValidValue = true;
    var validChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ.";
    var fieldLength = obj.value.length;
    var charr = "";
    for (i=0; i < fieldLength; i++) 
    { 
    	charr = obj.value.charAt(i); 
    	if (validChars.indexOf(charr)==-1) 
    	{ 
    		isValidValue = false;
		obj.value="";
		alert("enter only text value");
		obj.focus();
    	return isValidateValue;	
    	} 
    	else
    		return isValidValue;    	
    }
   
}

function isValueNumber(obj) 
{
    var isValidValue = true;
    var validChars = "0123456789";
    var fieldLength = obj.value.length;
    var charr = "";
    for (i=0; i < fieldLength; i++) 
    { 
    	charr = obj.value.charAt(i); 
    	if (validChars.indexOf(charr)==-1) 
    	{ 
    		isValidValue = false;
		obj.value="";
		alert("enter only numeric value");
		obj.focus();
    	return isValidateValue;	
    	} 
    	else
    		return isValidValue;
    }
}


function isAlphabet(elem)
{
	var alphaExp = /^[a-zA-Z]+$/;
	if(elem.value.match(alphaExp)){
		
		return true;
	}else
	{	
		elem.value="";
		//elem.focus();
		alert("Please enter only letters");
		elem.focus();
		return false;
	}
}

function isAlphanumeric(elem){
	
	var isValidValue = true;
	//var alphaExp = /^[0-9a-zA-Z]+$/;
	var alphaExp ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    var fieldLength = elem.value.length;
	var charr = "";
	for(i=0; i < fieldLength; i++)
	{
		charr = elem.value.charAt(i);
		if (alphaExp.indexOf(charr)==-1) 
    	{
		isValidValue = false;
		elem.value="";
		alert("enter only alphabetic and numeric value");
		elem.focus();
		return isValidateValue;
//	if(elem.value.match(alphaExp)){
//		return true;
	}else{
		//elem.focus();
//		alert("Please enter only Alphanumeric value");
//		elem.focus();
		return isValidValue;
	}
	}
}

function lengthRestriction(elem, min, max){
	var uInput = elem.value;
	if(uInput.length >= min && uInput.length <= max){
		return true;
	}else{
		alert("Please enter between " +min+ " and " +max+ " characters");
		elem.focus();
		return false;
	}
}

function madeSelection(elem){
	if(elem.value == "Please Choose"){
		alert("please make any one selection");
		elem.focus();
		return false;
	}else{
		return true;
	}
}

function emailValidator(elem){
	var emailExp = /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/;
	if(elem.value.match(emailExp)){
		return true;
	}else{
		alert("please enter proper email address");
		elem.focus();
		return false;
	}
}
