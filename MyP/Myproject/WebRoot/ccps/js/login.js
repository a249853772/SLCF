
$(function (){
	$("#sub").click(function (){
		sub();
	})
})


/**
 * button 提交点击事件
 */
function sub(){
	
	var loginName = $("#loginName").val();
	var passWord = $("#passWord").val();
	
	Login.submit(loginName,passWord);
}

var Login = {
	
	"submit":function(loginName ,passWord){
		$.post(
				"index",
				{"loginName":loginName,
				 "passWord":passWord
				},
				function(data) {
				console.log(data);
				if(data.msg){
					if(data.msg=='success'){
						 GLOBAL.setToken(data.token);
						 window.location.href = 'toindex?token='+data.token;
					}else{
						layer.msg(data.msg);
					}
				}
			});
	}

}