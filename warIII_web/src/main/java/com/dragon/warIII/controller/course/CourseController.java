package com.dragon.warIII.controller.course;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.dragon.warIII.service.course.entity.Course;
import com.dragon.warIII.service.course.service.CourseService;

@Controller
@RequestMapping("course")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@RequestMapping("list")
	public ModelAndView courseList(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Map<String, Object>> courses = courseService.findAllToMap();
		map.put("courses", courses);
		
		System.out.println("执行目标组件方法-->查找课程列表开始......");
//		Integer.valueOf("abc");
		
		return new ModelAndView("course_list", map);
	}
	
	
	
	
	
	/**
	 * <p>测试返回单个值</p>
	 * @return  
	 */
	@RequestMapping("test1")
	@ResponseBody
	public boolean test1() {
		return true;
	}
	
	/**
	 * <p>测试返回多个值</p>
	 * @return  
	 */
	@RequestMapping("test2")
	@ResponseBody
	public Map<String, Object> test2() {
		return courseService.findByNoToMap("c001");
	}
	
	/**
	 * <p>测试返回List</p>
	 * @return  
	 */
	@RequestMapping("test3")
	@ResponseBody
	public List<Map<String, Object>> test3() {
		return courseService.findAllToMap();
	}
	
	/**
	 * <p>测试返回对象</p>
	 * @return  
	 */
	@RequestMapping("test4")//{"cNo":"c001","cName":"J2SE","tNo":"t002"}
	@ResponseBody
	public Course test4() {
		return courseService.findByNo("c001");
	}
	
	@RequestMapping("test5")//{"cName":"J2SE","cNo":"c001","tNo":"t002"}
	@ResponseBody
	public String test5() {
		return JSON.toJSONString(courseService.findByNo("c001"));
	}
	
}
