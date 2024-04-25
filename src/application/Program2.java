package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println(" === Teste 1 - Department findById ===");
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		Department dep = departmentDao.findById(1);
		System.out.println(dep);
		
		System.out.println("\n === Teste 2 - Department findAll ===");
		List<Department> list = new ArrayList<>();
		list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		/*
		System.out.println("\n === Teste 3 - Department insert ===");
		Department newDep = new Department(null,"Grocery");
		departmentDao.insert(newDep);
		System.out.println("Done! New Department ID = " + newDep.getId());
		*/

		System.out.println("\n === Teste 4 - Department update ===");
		dep = departmentDao.findById(5);
		dep.setName("Financial");
		departmentDao.update(dep);
		System.out.println("Update Completed!");
		
		System.out.println("\n === Teste 5 - Department delete ===");
		System.out.println("Enter ID for Delete Test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete Completed!");
		sc.close();
		
	}

}
