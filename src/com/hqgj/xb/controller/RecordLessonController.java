package com.hqgj.xb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqgj.xb.bean.RecordLesson;
import com.hqgj.xb.bean.easyui.Json;
import com.hqgj.xb.bean.easyui.SessionInfo;
import com.hqgj.xb.service.RecordLessonService;

/**
 * @datetime 2015年10月12日 下午3:26:36
 * @author 崔兴伟
 */
@Controller
@RequestMapping(value = "/securityJsp/page")
public class RecordLessonController {
	@Autowired
	private RecordLessonService recordLessonService;

	@RequestMapping(value = "/jiaowu/addRecordLesson", method = RequestMethod.POST)
	public @ResponseBody Json addRecordLesson(RecordLesson recordLesson,
			HttpServletRequest request) {
		SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute("sessionInfo");
		recordLesson.setHandlerCode(sessionInfo.getUser().getUserId());
		Json json = new Json();
		if (recordLessonService.addRecordLesson(recordLesson) != 0) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("添加上课记录失败");
		}
		return json;
	}
}
