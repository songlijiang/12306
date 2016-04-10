
function changeImg() {
	var imgSrc = $("#imgObj");   
    var src = imgSrc.attr("src");   
    imgSrc.attr("src",chgUrl(src));  
    $("#info").html("");
}

function chgUrl(url) {
	var timestamp = (new Date()).valueOf();
	url = url.substring(0, 17);
	if ((url.indexOf("&") >= 0)) {
		url = url + "脳tamp=" + timestamp;   
	} else {
		url = url + "?timestamp=" + timestamp;   
	}
	return url;
}

function isRightCode(display) {
	var code = $("#veryCode").attr("value");
	//alert(code);
	code = "c=" + code;
	//alert(display);
	if(display=="submit")
	{
		$.ajax( {
			type : "POST",
			url : "ResultServlet.a",
			data : code,
			success : callbacksubmit
		});
	}
	else if(display=="show")
	{
		$.ajax( {
			type : "POST",
			url : "ResultServlet.a",
			data : code,
			success : callbackshow
		});
		
	}
}

function callbacksubmit(data) {
	//alert("callbacksubmit");

	if(data.toString()==1)
	{
		$("#info").html("congratulation from verrify.js");
		$("#form").submit();	
	  return;
	  
	}else
	{
		$("#info").html(data);
		//alert("验证正确后才能提交");
		return;
	}
}  

function callbackshow(data) {
	//alert("callbackshow");

	if(data.toString()==1)
	{
		$("#info").html("congratulation from verrify.js");	
	    return;
	}else
	{
		$("#info").html(data);
		//alert("验证正确后才能提交");	
		return;
	}
}  



