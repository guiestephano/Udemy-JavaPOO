package application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.sql.Date;
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

        System.out.println("\n--------- Test 04: seller insert(): ------------");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", Date.valueOf(LocalDate.now()), 4000.0, dep);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! new id: " + newSeller.getId());

        System.out.println("\n--------- Test 05: seller update(): ------------");
         seller = sellerDao.findById(1);
         seller.setName("Martha Waine");
         sellerDao.update(seller);
        System.out.println("Update completed");

    }
}
