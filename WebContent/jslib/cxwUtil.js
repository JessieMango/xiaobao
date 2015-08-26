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
/**
 * 班级编辑时加载上课时间
 */
var loadTimigWeekday = function(timeSpan) {
	var num = timeSpan.length;
	for (var i = 0; i < num; i++) {
		var rowTime = timeSpan[i].split(",");
		if ($('#Timing' + (i + 1)).hasClass("none")) {
			$('#Timing' + (i + 1)).removeClass("none");
		}
		if ($("#TimingWeekday" + (i + 1)).hasClass("none")) {
			$("#TimingWeekday" + (i + 1)).removeClass("none");
		}
		$("#TimingWeekday" + (i + 1)).val(rowTime[0]);
		$("#startTime" + (i + 1)).timespinner('setValue', rowTime[1]);
		$("#endTime" + (i + 1)).timespinner('setValue', rowTime[2]);
		if (i != 7) {
			if ($("#TimingWeekday" + (i + 2)).hasClass("none")) {
				$("#TimingWeekday" + (i + 2)).removeClass("none");
			}
		}
	}
}
/**
 * 新建班级时选择不同收费模式时显示对应div
 */
var tuitionDivChange = function(target) {
	if (target == 1) {
		$("#tuitionSpan2").addClass("none");
		$("#tuitionSpan3").addClass("none");
		$("#tuitionTip").addClass("none");
		$("#tuitionType1").attr("checked", "true");
	}
	if (target == 2) {
		$("#tuitionSpan1").addClass("none");
		$("#tuitionSpan3").addClass("none");
		$("#tuitionTip").addClass("none");
		$("#tuitionType2").attr("checked", "true");
	}
	if (target == 3) {
		$("#tuitionSpan1").addClass("none");
		$("#tuitionSpan2").addClass("none");
		$("#tuitionTip").addClass("none");
		$("#tuitionType3").attr("checked", "true");
	}
}
/**
 * 新建班级时选择不同收费模式时显示对应span
 */
var tuitionChange = function(target) {
	if (target == 1) {
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
		if (!$("#tuitionSpanMonth").hasClass("none")) {
			$("#tuitionSpanMonth").addClass("none");
		}
		if (!$("#tuitionSpanTimes").hasClass("none")) {
			$("#tuitionSpanTimes").addClass("none");
		}

	}
	if (target == 2) {
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
	if (target == 3) {
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

/**
 * 报名时选择不同的优惠方式显示对应信息
 */
var changeDiscountType = function(type, target) {
	var val = $(target).val();
	if (type == 1) {
		if (val == 1) { // 原价
			if (!$("#span12").hasClass("none")) {
				$("#span12").addClass("none");
			}
			if (!$("#span13").hasClass("none")) {
				$("#span13").addClass("none");
			}
			if (!$("#span14").hasClass("none")) {
				$("#span14").addClass("none");
			}
			$("#arrearage1").empty();
			$("#tuition1").html($("#tu1").val());
			$('#realTuition1').val($("#tuition1").html());

		} else if (val == 2) { // 优惠
			if ($("#span12").hasClass("none")) {
				$("#span12").removeClass("none");
			}
			if (!$("#span13").hasClass("none")) {
				$("#span13").addClass("none");
			}
			if (!$("#span14").hasClass("none")) {
				$("#span14").addClass("none");
			}
			$("#arrearage1").empty();
			$("#tuition1").html($("#tu1").val() - $("#preferntial1").val());
			$('#realTuition1').val($("#tuition1").html());

		} else if (val == 3) { // 折扣
			if (!$("#span12").hasClass("none")) {
				$("#span12").addClass("none");
			}
			if ($("#span13").hasClass("none")) {
				$("#span13").removeClass("none");
			}
			if (!$("#span14").hasClass("none")) {
				$("#span14").addClass("none");
			}

			$("#arrearage1").empty();
			if ($("#discount1").numberbox('getValue') == 0.0) {
				$("#tuition1").html($("#tu1").val())
			} else {
				$("#tuition1").html(
						$("#tu1").val() * $("#discount1").numberbox('getValue')
								/ 10);
			}

			$('#realTuition1').val($("#tuition1").html());

		} else if (val == 4) { // 插班
			if (!$("#span12").hasClass("none")) {
				$("#span12").addClass("none");
			}
			if (!$("#span13").hasClass("none")) {
				$("#span13").addClass("none");
			}
			if ($("#span14").hasClass("none")) {
				$("#span14").removeClass("none");
			}

			$("#arrearage1").empty();
			$("#tuition1").html($("#tu1").val() - $("#reduceMoney1").val());
			$('#realTuition1').val($("#tuition1").html());
		}
	}
	if (type == 2) {
		if (val == 1) {
			if (!$("#span22").hasClass("none")) {
				$("#span22").addClass("none");
			}
			if (!$("#span23").hasClass("none")) {
				$("#span23").addClass("none");
			}
			if (!$("#span24").hasClass("none")) {
				$("#span24").addClass("none");
			}
			$("#arrearage2").empty();
			$("#tuition2").html($("#tu2").val());
			$('#realTuition2').val($("#tuition2").html());
		} else if (val == 2) {
			if ($("#span22").hasClass("none")) {
				$("#span22").removeClass("none");
			}
			if (!$("#span23").hasClass("none")) {
				$("#span23").addClass("none");
			}
			if (!$("#span24").hasClass("none")) {
				$("#span24").addClass("none");
				$("#arrearage2").empty();
				$("#tuition2").html($("#tu2").val() - $("#preferntial2").val());
				$('#realTuition2').val($("#tuition2").html());

			}
		} else if (val == 3) {
			if (!$("#span22").hasClass("none")) {
				$("#span22").addClass("none");
			}
			if ($("#span23").hasClass("none")) {
				$("#span23").removeClass("none");
			}
			if (!$("#span24").hasClass("none")) {
				$("#span24").addClass("none");
			}
			$("#arrearage2").empty();

			if ($("#discount2").numberbox('getValue') == 0.0) {
				$("#tuition2").html($("#tu2").val())
			} else {
				$("#tuition2").html(
						$("#tu2").val() * $("#discount2").numberbox('getValue')
								/ 10);
			}
			$('#realTuition2').val($("#tuition2").html());
		} else if (val == 4) {
			if (!$("#span22").hasClass("none")) {
				$("#span22").addClass("none");
			}
			if (!$("#span23").hasClass("none")) {
				$("#span23").addClass("none");
			}
			if ($("#span24").hasClass("none")) {
				$("#span24").removeClass("none");
			}
			$("#arrearage2").empty();
			$("#tuition2").html($("#tu2").val() - $("#reduceMoney2").val());
			$('#realTuition2').val($("#tuition2").html());
		}
	}

	if (type == 3) {
		if (val == 1) {
			if (!$("#span32").hasClass("none")) {
				$("#span32").addClass("none");
			}
			if (!$("#span33").hasClass("none")) {
				$("#span33").addClass("none");
			}
			if (!$("#span34").hasClass("none")) {
				$("#span34").addClass("none");
			}
			$("#arrearage3").empty();
			$("#tuition3").html($("#tu3").val());
			$('#realTuition3').val($("#tuition3").html());
		} else if (val == 2) {
			if ($("#span32").hasClass("none")) {
				$("#span32").removeClass("none");
			}
			if (!$("#span33").hasClass("none")) {
				$("#span33").addClass("none");
			}
			if (!$("#span34").hasClass("none")) {
				$("#span34").addClass("none");
			}
			$("#arrearage3").empty();
			$("#tuition3").html($("#tu3").val() - $("#preferntial3").val());
			$('#realTuition3').val($("#tuition3").html());

		} else if (val == 3) {
			if (!$("#span32").hasClass("none")) {
				$("#span32").addClass("none");
			}
			if ($("#span33").hasClass("none")) {
				$("#span33").removeClass("none");
			}
			if (!$("#span34").hasClass("none")) {
				$("#span34").addClass("none");
			}
			$("#arrearage3").empty();

			if ($("#discount3").numberbox('getValue') == 0.0) {
				$("#tuition3").html($("#tu3").val())
			} else {
				$("#tuition3").html(
						$("#tu3").val() * $("#discount3").numberbox('getValue')
								/ 10);
			}
			$('#realTuition3').val($("#tuition3").html());
		} else if (val == 4) {
			if (!$("#span32").hasClass("none")) {
				$("#span32").addClass("none");
			}
			if (!$("#span33").hasClass("none")) {
				$("#span33").addClass("none");
			}
			if ($("#span34").hasClass("none")) {
				$("#span34").removeClass("none");
			}
			$("#arrearage3").empty();
			$("#tuition3").html($("#tu3").val() - $("#reduceMoney3").val());
			$('#realTuition3').val($("#tuition3").html());
		}
	}
	CalTotalMoney();
}

// ------------验证非负数的数字
var CheckNonNegativeNumber = function CheckNonNegativeNumber(target) {
	var Value = $(target).val();

	if (isNaN(Value) || parseFloat(Value) < 0) {
		alert("【必须输入大于或等于0的数字】");
		$(target).focus();
	}
}

/**
 * type 1表示第一个班级 2第二个班级 3第三个班级 order 1表示优惠金额改变 2插班减免金额 3实收数目改变
 */
var changeTypeMoney = function(type, order, target) {
	if (type == 1) {
		if (order == 1) {
			$("#tuition1").html($("#tu1").val() - $(target).val());
			$('#realTuition1').val($("#tuition1").html());
		}
		if (order == 2) {
			$("#tuition1").html($("#tu1").val() - $(target).val());
			$('#realTuition1').val($("#tuition1").html());
		}
		if (order == 3) {
			va = $(target).val() - $("#tuition1").html();
			if (va > 0) {
				if ($("#arrearage1").hasClass("none")) {
					$("#arrearage1").removeClass("none");
				}
				$("#arrearage1").empty();
				var str = cxw
						.formatString(
								"<span style='color:red;'>预存<input style='width: 70px;' readonly='readonly' type='text' name='arre1' value='{0}'>元</span>",
								va);
				$("#arrearage1").append(str);
			}
			if (va < 0) {
				if ($("#arrearage1").hasClass("none")) {
					$("#arrearage1").removeClass("none");
				}
				$("#arrearage1").empty();
				var str = cxw
						.formatString(
								"<span style='color:red;'>欠费<input style='width: 70px;' readonly='readonly' type='text' name='arre1' value='{0}'>元</span>",
								va);
				$("#arrearage1").append(str);
			}
			if (va == 0) {
				$("#arrearage1").empty();
				if (!$("#arrearage1").hasClass("none")) {
					$("#arrearage1").addClass("none");
				}
			}
		}
	}
	if (type == 2) {
		if (order == 1) {
			$("#tuition2").html($("#tu2").val() - $(target).val());
			$('#realTuition2').val($("#tuition2").html());
		}
		if (order == 2) {
			$("#tuition2").html($("#tu2").val() - $(target).val());
			$('#realTuition2').val($("#tuition2").html());
		}
		if (order == 3) {
			va = $(target).val() - $("#tuition2").html();
			if (va > 0) {
				if ($("#arrearage2").hasClass("none")) {
					$("#arrearage2").removeClass("none");
				}
				$("#arrearage2").empty();
				var str = cxw
						.formatString(
								"<span style='color:red;'>预存<input style='width: 70px;' readonly='readonly' type='text' name='arre2' value='{0}'>元</span>",
								va);
				$("#arrearage2").append(str);
			}
			if (va < 0) {
				if ($("#arrearage2").hasClass("none")) {
					$("#arrearage2").removeClass("none");
				}
				$("#arrearage2").empty();
				var str = cxw
						.formatString(
								"<span style='color:red;'>欠费<input style='width: 70px;' readonly='readonly' type='text' name='arre2' value='{0}'>元</span>",
								va);
				$("#arrearage2").append(str);
			}
			if (va == 0) {
				$("#arrearage2").empty();
				if (!$("#arrearage2").hasClass("none")) {
					$("#arrearage2").addClass("none");
				}
			}
		}
	}
	if (type == 3) {
		if (order == 1) {
			$("#tuition3").html($("#tu3").val() - $(target).val());
			$('#realTuition3').val($("#tuition3").html());
		}
		if (order == 2) {
			$("#tuition3").html($("#tu3").val() - $(target).val());
			$('#realTuition3').val($("#tuition3").html());
		}
		if (order == 3) {
			va = $(target).val() - $("#tuition3").html();
			if (va > 0) {
				if ($("#arrearage3").hasClass("none")) {
					$("#arrearage3").removeClass("none");
				}
				$("#arrearage3").empty();
				var str = cxw
						.formatString(
								"<span style='color:red;'>预存<input style='width: 70px;' readonly='readonly' type='text' name='arre3' value='{0}'>元</span>",
								va);
				$("#arrearage3").append(str);
			}
			if (va < 0) {
				if ($("#arrearage3").hasClass("none")) {
					$("#arrearage3").removeClass("none");
				}
				$("#arrearage3").empty();
				var str = cxw
						.formatString(
								"<span style='color:red;'>欠费<input style='width: 70px;' readonly='readonly' type='text' name='arre3' value='{0}'>元</span>",
								va);
				$("#arrearage3").append(str);
			}
			if (va == 0) {
				$("#arrearage3").empty();
				if (!$("#arrearage3").hasClass("none")) {
					$("#arrearage3").addClass("none");
				}
			}
		}
	}
	CalTotalMoney();
}

/**
 * 报名时选择教材的数量发生变化时 type 1表示选择第一个班级 2表示第二个班级 3表示第三个班级 index 表示第几个
 */
var CalcShouldPay = function(target, type, price, index, length) {
	var sum = 0;
	var num = $(target).val();
	if (type == 1) {
		$("#one" + index).val((num * price));
		for (var i = 0; i < length; i++) {
			sum += parseFloat($("#one" + i).val());
		}
		$("#textBookFeeTotal1").html(sum);
	}
	if (type == 2) {
		$("#two" + index).val((num * price));
		for (var i = 0; i < length; i++) {
			sum += parseFloat($("#two" + i).val());
		}
		$("#textBookFeeTotal2").html(sum);
	}
	if (type == 3) {
		$("#three" + index).val((num * price));
		for (var i = 0; i < length; i++) {
			sum += parseFloat($("#three" + i).val());
		}
		$("#textBookFeeTotal3").html(sum);
	}
	CalTotalMoney();
}

/**
 * 计算报名缴费总金额
 */
var CalTotalMoney = function() {
	var sum = 0;
	if (!$("#otherSpan1").hasClass("none")) {
		sum += parseFloat($('#realTuition1').val());
		sum += parseFloat($('#textBookFeeTotal1').html());
	}
	if (!$("#otherSpan2").hasClass("none")) {
		sum += parseFloat($('#realTuition2').val());
		sum += parseFloat($('#textBookFeeTotal2').html());
	}
	if (!$("#otherSpan3").hasClass("none")) {
		sum += parseFloat($('#realTuition3').val());
		sum += parseFloat($('#textBookFeeTotal3').html());
	}
	$("#money").val(sum);
	$("#points").val(sum);
}