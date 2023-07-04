package com.manytomany.manytomanylab;

import com.manytomany.manytomanylab.models.Assignment;
import com.manytomany.manytomanylab.models.Department;
import com.manytomany.manytomanylab.models.Employee;
import com.manytomany.manytomanylab.models.Project;
import com.manytomany.manytomanylab.repositories.AssignmentRepository;
import com.manytomany.manytomanylab.repositories.DepartmentRepository;
import com.manytomany.manytomanylab.repositories.EmployeeRepository;
import com.manytomany.manytomanylab.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ManytomanylabApplicationTests {

	@Autowired
	AssignmentRepository assignmentRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	ProjectRepository projectRepository;

	@Test
	void contextLoads() {
	}

//	@Test
//	public void createAllOfIt(){
//		Department salesDpt = new Department("Sales");
//		departmentRepository.save(salesDpt);
//		Project project = new Project("OurProject",2);
//		projectRepository.save(project);
//		Employee employee1 = new Employee("Bala","Jones",123L,salesDpt);
//		employeeRepository.save(employee1);
//		Assignment assignment = new Assignment(employee1,project);
//		assignmentRepository.save(assignment);
//	}

	@Test
	public void canAssignEmployeeToProject(){
		Department salesDpt = new Department("Sales");
		departmentRepository.save(salesDpt);
		Project project = new Project("OurProject",2);
		projectRepository.save(project);
		Employee employee1 = new Employee("Bala","Jones",123L,salesDpt);
		employeeRepository.save(employee1);
		Assignment assignment = new Assignment(employee1,project);
		assignmentRepository.save(assignment);
		project.addAssignment(assignment);
		projectRepository.save(project);

	}

}
