package com.hqgj.xb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqgj.xb.bean.ClassS;
import com.hqgj.xb.service.ClassRoomService;

/**
 * @author 崔兴伟
 * @datetime 2015年8月14日 上午10:08:44
 */
@Controller
@RequestMapping(value = "/securityJsp/page")
public class ClassRoomController {
	@Autowired
	private ClassRoomService classRoomService;

	@RequestMapping(value = "/jiaowu/getClassRooms", method = RequestMethod.POST)
	public @ResponseBody List<ClassS> getClassRooms() {
		return classRoomService.getClassRooms();
	}
}
