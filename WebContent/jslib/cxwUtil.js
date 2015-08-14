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

/* 前三天日期 */
function getPreThreeDate() {
	var curr_time = new Date();
	var y = curr_time.getFullYear();
	var m = curr_time.getMonth() + 1;
	var d = curr_time.getDate();
	d = d - 3;
	return y + '-' + (m < 10 ? ('0' + m) : m) + '-' + (d < 10 ? ('0' + d) : d);
}

/* 上课时间 */
var ChangeTimigWeekday = function(dom, num) {
	var value = $(dom).val();

	for (var i = 0; i < num; i++) {
		if (value == "" || value == "0") {
			if (!$('#Timing' + num).hasClass("none")) {
				$('#Timing' + num).addClass("none")
			}
		} else {
			if ($('#Timing' + num).hasClass("none")) {
				$('#Timing' + num).removeClass("none");
			}
			if (num != 7) {
				if ($("#TimingWeekday" + (num + 1)).hasClass("none")) {
					$("#TimingWeekday" + (num + 1)).removeClass("none");
				}
			}
		}
	}

	// --如果选择“不定”，则所有周X都不显示
	if ($("#TimingWeekday1").val() == "0") {
		if (!$("#TimingWeekday2").hasClass("none")) {
			$("#TimingWeekday2").addClass("none");
		}
		if (!$("#TimingWeekday3").hasClass("none")) {
			$("#TimingWeekday3").addClass("none");
		}
		if (!$("#TimingWeekday4").hasClass("none")) {
			$("#TimingWeekday4").addClass("none");
		}
		if (!$("#TimingWeekday5").hasClass("none")) {
			$("#TimingWeekday5").addClass("none");
		}
		if (!$("#TimingWeekday6").hasClass("none")) {
			$("#TimingWeekday6").addClass("none");
		}
		if (!$("#TimingWeekday7").hasClass("none")) {
			$("#TimingWeekday7").addClass("none");
		}
		if (!$("#Timing1").hasClass("none")) {
			$("#Timing1").addClass("none");
		}
		if (!$("#Timing2").hasClass("none")) {
			$("#Timing2").addClass("none");
		}
		if (!$("#Timing3").hasClass("none")) {
			$("#Timing3").addClass("none");
		}
		if (!$("#Timing4").hasClass("none")) {
			$("#Timing4").addClass("none");
		}
		if (!$("#Timing5").hasClass("none")) {
			$("#Timing5").addClass("none");
		}
		if (!$("#Timing6").hasClass("none")) {
			$("#Timing6").addClass("none");
		}
		if (!$("#Timing7").hasClass("none")) {
			$("#Timing7").addClass("none");
		}
	}
}

var tuitionChange = function(target) {
	if ($(target).val() == 1) {
		if ($("#tuitionSpanTerm").hasClass("none")) {
			$("#tuitionSpanTerm").removeClass("none");
		}

		if ($("#classTimesDiv").hasClass("none")) {
			$("#classTimesDiv").removeClass("none");
		}
		if ($("#termDiv").hasClass("none")) {
			$("#termDiv").removeClass("none");
		}
		if (!$("#timeMonthDiv").hasClass("none")) {
			$("#timeMonthDiv").addClass("none");
		}
		if (!$("#tuitionSpanTimes").hasClass("none")) {
			$("#tuitionSpanTimes").addClass("none");
		}

	}
	if ($(target).val() == 2) {
		if (!$("#classTimesDiv").hasClass("none")) {
			$("#classTimesDiv").addClass("none");
		}
		if ($("#tuitionSpanTimes").hasClass("none")) {
			$("#tuitionSpanTimes").removeClass("none");
		}
		if (!$("#termDiv").hasClass("none")) {
			$("#termDiv").addClass("none");
		}
		if (!$("#tuitionSpanTerm").hasClass("none")) {
			$("#tuitionSpanTerm").addClass("none");
		}
		if ($("#timeMonthDiv").hasClass("none")) {
			$("#timeMonthDiv").removeClass("none");
		}
		if (!$("#tuitionSpanMonth").hasClass("none")) {
			$("#tuitionSpanMonth").addClass("none");
		}
	}
	if ($(target).val() == 3) {
		if (!$("#classTimesDiv").hasClass("none")) {
			$("#classTimesDiv").addClass("none");
		}
		if ($("#tuitionSpanMonth").hasClass("none")) {
			$("#tuitionSpanMonth").removeClass("none");
		}
		if (!$("#termDiv").hasClass("none")) {
			$("#termDiv").addClass("none");
		}
		if (!$("#tuitionSpanTimes").hasClass("none")) {
			$("#tuitionSpanTimes").addClass("none");
		}
		if (!$("#tuitionSpanTerm").hasClass("none")) {
			$("#tuitionSpanTerm").addClass("none");
		}
		if ($("#timeMonthDiv").hasClass("none")) {
			$("#timeMonthDiv").removeClass("none");
		}
	}

}
