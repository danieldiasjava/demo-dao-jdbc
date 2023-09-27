package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("--- TEST One: seller findById ----");
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println("\n--- TEST Two: seller findByDepartment ----");
		
		
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n--- TEST Tree: seller findAll ----");

		list = sellerDao.findALL();
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n--- TEST four: seller insert ----");
		Seller newSeller = new Seller(null, "Alex", "alex@gmail.com", new Date(), 5000.00, department);
		sellerDao.insert(newSeller);
		System.out.println("New id Inserted! = " + newSeller.getId());
	}
}
