package com.demo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.binding.StudentBinding;
import com.demo.entity.Student;
import com.demo.repository.StudentRepository;


@Controller
public class StudentController {
	
	@Autowired
	private StudentRepository repo;

	// method to load student form
	
	@GetMapping("/")
	public String loadForm(Model model) {
		
		loadFormData(model);
		
		return "index";
	}

	private void loadFormData(Model model) {
		List<String> courses = new ArrayList<>();
		courses.add("Java");
		courses.add("Devops");
		courses.add("AWS");
		courses.add("Python");
		
		List<String> timings = new ArrayList<>();
		timings.add("Moring");
		timings.add("AfterNoon");
		timings.add("Night");
		
		model.addAttribute("courses",courses);
		model.addAttribute("timings",timings);
		
		StudentBinding student = new StudentBinding();
		model.addAttribute("student",student);
	}
	
	// method to save student form data
	
	@PostMapping("/save")
	public String handleSubmit(StudentBinding s , Model model) {
		System.out.println(s);
		
		// logic to save
		
		Student entity = new Student();
		
		// copy data from student obj to entity obj
		BeanUtils.copyProperties(s, entity);
		entity.setTimings(Arrays.toString(s.getTimings())); 
		repo.save(entity);
		
		model.addAttribute("msg" , "Student Saved");
		
		loadFormData(model);
		
		 return "index";
	}
	
	//method to display save studdent data
	
	@GetMapping("/viewStudents")
	public String getStudentData(Model model) {
		
//		logic to fetch the data 
		
		List<Student> studentList= repo.findAll();
		
		model.addAttribute("students",studentList);
		
		return "data";
	}
}
