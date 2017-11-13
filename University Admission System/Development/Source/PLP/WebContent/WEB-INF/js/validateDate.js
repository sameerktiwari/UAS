function isBefore(){
	var date=new Date(document.getElementById("dateOfBirth").value);
	var date2=new Date();
	if(date>=date2){
		alert("Date of birth should be a past value");
		return false;
	}
}

function isAfter(){
	var date=new Date(document.getElementById("dateOfInterview").value);
	var date2=new Date();
	if(date<date2){
		alert("Date of Interview should be a future value");
		return false;
	}
}