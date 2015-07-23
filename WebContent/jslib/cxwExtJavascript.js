var cxw = cxw || {};

/**
 * 去字符串空格
 * 
 */
cxw.trim = function(str) {
	return str.replace(/(^\s*)|(\s*$)/g, '');
};
cxw.ltrim = function(str) {
	return str.replace(/(^\s*)/g, '');
};
cxw.rtrim = function(str) {
	return str.replace(/(\s*$)/g, '');
};

/**
 * 判断开始字符是否是XX
 * 
 */
cxw.startWith = function(source, str) {
	var reg = new RegExp("^" + str);
	return reg.test(source);
};
/**
 * 判断结束字符是否是XX
 * 
 */
cxw.endWith = function(source, str) {
	var reg = new RegExp(str + "$");
	return reg.test(source);
};

/**
 * iframe自适应高度
 * 
 * 
 * @param iframe
 */
cxw.autoIframeHeight = function(iframe) {
	iframe.style.height = iframe.contentWindow.document.body.scrollHeight + "px";
};

/**
 * 设置iframe高度
 * 
 * 
 * @param iframe
 */
cxw.setIframeHeight = function(iframe, height) {
	iframe.height = height;
};