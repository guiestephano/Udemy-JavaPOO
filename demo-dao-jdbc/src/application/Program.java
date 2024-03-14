package application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Program {
    public static void main(String[] args){
        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("--------- Test 01: seller findById(): ------------");
        Seller  seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n--------- Test 02: seller findByDepartment(): ------------");
        List<Seller> list = new ArrayList<>();
        Department dep = new Department(2,null);
        list = sellerDao.findByDepartment(dep);
        list.forEach(System.out::println);

        System.out.println("\n--------- Test 03: seller findAll(): ------------");
        list = sellerDao.findAll();
        list.forEach(System.out::println);

    }
}
