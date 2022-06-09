

function  validate(frm){
	
	// Empty the error messages
	document.getElementById("pnameErr").innerHTML="";
	document.getElementById("pageErr").innerHTML="";
	
	//read form data
	let name=frm.pname.value;
	let age=frm.page.value;
	// write client side form validation logic
	let vflag=true;
	if(name==""){  // required rule
		vflag=false;
		document.getElementById("pnameErr").innerHTML="<b>Person name is required</b>";
	}
	else if(name.length<5 ||name.length>10){   // minlength and  max length
		vflag=false;
		document.getElementById("pnameErr").innerHTML="<b>Person name must have min of 5 chars and max of 10 characters</b>";
	}
	
	alert("1");
	
	if(age==""){  //required rule
		vflag=false;
		document.getElementById("pageErr").innerHTML="<b>Person age is required</b>";
	}
	else if(isNaN(age)){ //  numeric rule
		vflag=false;
		document.getElementById("pageErr").innerHTML="<b>Person age must be given as the numeric value</b>";
	}
	else if(age<0  || age>100){ //range rule
		vflag=false;
		document.getElementById("pageErr").innerHTML="<b>Person age must be there in the range of 1 through  100</b>";
	}
	alert("2");
	//change the hiddex box  value "yes"  indication javascript code is executed
	 frm.vstatus.value="yes";
	 alert(frm.vstatus.value);
	 
	 alert("3");
	
	
	 
	return vflag;
}