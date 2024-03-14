package application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.time.LocalDate;


public class Program {
    public static void main(String[] args){
        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("--------- Test 01: seller findById(): ------------");
        Seller  seller = sellerDao.findById(3);

        System.out.println(seller);
    }
}
