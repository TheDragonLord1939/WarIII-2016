package com.dragon.warIII.controller.student;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dragon.warIII.service.student.service.StudentService;

@Controller
@RequestMapping("student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@RequestMapping("/list")
	public String studentList(Model model) {
		List<Map<String, Object>> students = studentService.findAllToMap();
		model.addAttribute("students", students);
		System.out.println("students="+students);
		return "student_list";
	}
}
