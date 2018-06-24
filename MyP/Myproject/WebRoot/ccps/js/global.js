var GLOBAL = (function (GLOBAL){
	var token = "";
	
	GLOBAL.setToken = function (t){
		token = t;
	}
	
	GLOBAL.getToken = function (){
		return token;
	}
	
	
	return GLOBAL;
})(window.GLOBAL || {})