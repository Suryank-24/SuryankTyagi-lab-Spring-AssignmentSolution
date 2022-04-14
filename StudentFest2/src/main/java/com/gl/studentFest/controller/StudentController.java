package com.gl.studentFest.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gl.studentFest.entity.Student;
import com.gl.studentFest.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/list")
	public String listStudents(Model theModel) {
		//get student from DB
		List<Student> students = studentService.findAll();
		//add to the spring model
		theModel.addAttribute("Students",students);
		return "list-students";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		//create model attribute to bind form data
		Student student = new Student();
		theModel.addAttribute("Student", student);
		return "student-form";
	}
	
	@RequestMapping("showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {
		//get the student from service
		Student student = studentService.findById(theId);
		//set student as a model attribute to pre-populate the form
		theModel.addAttribute("Student",student);
		return "student-form";
	}
	
	@PostMapping("/save")
	public String saveBook(@RequestParam("id") int id, 
							@RequestParam("name") String name,
							@RequestParam("department") String department,
							@RequestParam("country") String country) {
		
		System.out.println(id);
		Student student;
		if(id!=0)
		{
			student = studentService.findById(id);
			student.setName(name);
			student.setDepartment(department);
			student.setCountry(country);
		}
		else
			student = new Student(name,department,country);
		//save the student
		studentService.save(student);
		//use a redirect to prevent duplicate submissions
		return "redirect:/students/list";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {
		//delete the book
		studentService.deleteById(theId);
		//redirect to /students/list
		return"redirect:/students/list";
	}
	
	@RequestMapping("/search")
	public String search(@RequestParam("name") String name,
						@RequestParam("department") String department,
						Model theModel) {
		
	//check names, if both are empty then 	jzt give list of all books
		if(name.trim().isEmpty() && department.trim().isEmpty()) {
			return "redirect:/students/list";
		}
		else {
			//else, search by first name and last name
			List<Student> students = studentService.searchBy(name, department);
			
			//add to the spring model
			theModel.addAttribute("Students", students);
			//send to the list-book
			return "list-students";
		}	
	}
	
	@RequestMapping(value = "/403")
	public ModelAndView accessDenied(Principal user) {
		ModelAndView modelAndView = new ModelAndView();
		if(user != null)  {
			modelAndView.addObject("msg", "Hi " + user.getName()
			+ " , You don't have the permission to access this page!");
		}
		else {
			modelAndView.addObject("msg", "You don't have the permission to access this page!");
		}
		modelAndView.setViewName("403");
		return modelAndView; 
	}
}