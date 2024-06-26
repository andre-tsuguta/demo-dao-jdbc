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
		
		System.out.println("=== Test 1 - Seller findByid ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n === Test 2 - Seller findByDepartment ===");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n === Test 3 - Seller findAll ===");
        list = sellerDao.findAll();
		
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		/*System.out.println("\n === Test 4 - Seller insert ===");
		Seller newSeller = new Seller(null,"Jack Orange", "jack@gmail.com", new Date(), 4000.00, dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New Id = " + newSeller.getId());*/
		
		
		System.out.println("\n === Test 5 - Seller Update ===");
		seller = sellerDao.findById(1);
		seller.setEmail("bobbrown@gmail.com");
		sellerDao.update(seller);		
		System.out.println("Update Completed!");
		
		
		System.out.println("\n === Test 6 - Seller Delete ===");
		System.out.println("Enter ID for Delete Test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete Completed!");
		
		sc.close();
	}

}
