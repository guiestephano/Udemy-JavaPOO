package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("------------Teste 01: department insert() -------------------");
        Department dep = new Department(null, "Agricultural");
        departmentDao.insert(dep);

        System.out.println("Insert completed! new Id: " + dep.getId());
        System.out.println("\n------------Teste 02: department findById() -------------------");
        Department department = departmentDao.findById(5);
        System.out.println(department);

        System.out.println("\n------------Teste 03: department update() -------------------");
        department.setName("Design");
        departmentDao.update(department);
        System.out.println("Update completed!");

        System.out.println("\n------------Teste 04: department findAll() -------------------");
        List<Department> list = new ArrayList<>();
        list = departmentDao.findAll();
        list.forEach(System.out::println);

        System.out.println("\n--------- Test 06: department deleteById(): ------------");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");
        sc.close();
    }
}
