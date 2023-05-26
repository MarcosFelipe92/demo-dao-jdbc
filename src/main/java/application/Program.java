package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SellerDao sellerDao = DaoFactory.createSellerDao();	
		
		System.out.println("=== TEST 1: Seller findById ===");		
		Seller seller = sellerDao.findById(3);		
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: Seller findByDepartment ===");		
		Department dep = new Department(2, "Eletronics");
		List<Seller> list = sellerDao.findByDepartment(dep);	
		for(Seller obj : list) {	
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: Seller findAll ===");
		list = sellerDao.findAll();		
		for(Seller obj : list) {	
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 4: Seller insert ===");		
		Seller sellerAdd = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, dep);		
		sellerDao.insert(sellerAdd);		
		System.out.println("Inserted! New id = " + sellerAdd.getId());
		
		System.out.println("\n=== TEST 5: Seller update ===");		
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);		
		System.out.println("Update completed! " + seller);
		
		System.out.println("\n=== TEST 6: Seller delete ===");		
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		sc.close();
	}

}
