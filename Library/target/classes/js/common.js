

function confirm_delete(){
	return confirm("确定要删除数据吗？");
}

function short_content(length) {
	(function($){
		$('.short_content').each(function(){
			var obj = $(this);
			var source_str = obj.html().trim();
			var new_str = source_str.substr(0,length);
			if(source_str.length >length)
				new_str += "...";
			obj.html(new_str);
		});
	})(jQuery);
}

function isNum(str) {
	var reg = new RegExp("^[0-9]*$");
	return reg.test(str);
}

function isPhoneNum(str) {
	return /^1[3|4|5|8][0-9]\d{8}$/.test(str);
}

function isEmail(str) {
	var reg = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");
	return reg.test(str);
}

function isChinese(str) {
	var reg = new RegExp("^[\u4e00-\u9fa5]+$");
	return reg.test(str);
}
