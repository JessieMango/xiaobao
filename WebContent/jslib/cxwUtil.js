/* 本月第一天 */
function firstOfMouth() {
	var curr_time = new Date();
	var y = curr_time.getFullYear();
	var m = curr_time.getMonth() + 1;
	return y + '-' + (m < 10 ? ('0' + m) : m) + "-01 " + "00:00:00";
}
/* 当前日期 */
function getCurrentTime() {
	var curr_time = new Date();
	var y = curr_time.getFullYear();
	var m = curr_time.getMonth() + 1;
	var d = curr_time.getDate();
	var hh = curr_time.getHours();
	var mm = curr_time.getMinutes();
	var ss = curr_time.getSeconds();
	return y + '-' + (m < 10 ? ('0' + m) : m) + '-' + (d < 10 ? ('0' + d) : d)
			+ ' ' + (hh < 10 ? ('0' + hh) : hh) + ':'
			+ (mm < 10 ? ('0' + mm) : mm) + ':' + (ss < 10 ? ('0' + ss) : ss);
}

/* 当前日期 */
function getCurrentDate() {
	var curr_time = new Date();
	var y = curr_time.getFullYear();
	var m = curr_time.getMonth() + 1;
	var d = curr_time.getDate();
	return y + '-' + (m < 10 ? ('0' + m) : m) + '-' + (d < 10 ? ('0' + d) : d);
}

/* 下一天日期 */
function getNextDate() {
	var curr_time = new Date();
	var y = curr_time.getFullYear();
	var m = curr_time.getMonth() + 1;
	var d = curr_time.getDate();
	d = d + 1;
	return y + '-' + (m < 10 ? ('0' + m) : m) + '-' + (d < 10 ? ('0' + d) : d);
}
