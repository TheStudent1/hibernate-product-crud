package com.app.main;

import java.util.ArrayList;
import java.util.List;

import com.app.DAO.IDAO;
import com.app.DAO.ProductDAOImpl;
import com.app.models.Product;

public class Main {

	public static void main(String[] args) {

		IDAO service = new ProductDAOImpl();

		/* Save: */
		// Product p = new Product(null, "Product01", 10.2);
		// service.create(p);

		/* get One */
//		Product p2 = new Product();
//		p2 = (Product) service.getOne(4L);
//		System.out.println(p2.toString());
//
//		/* Update */
//
		Product p3 = new Product(4L, "Product Update", 321.2);
//		service.update(p3);
//
//		p2 = (Product) service.getOne(4L);
//		System.out.println(p2.toString());

		/* Delete */
//		service.delete(p3);

		/* getAll */

		List<Product> products = new ArrayList<Product>();
		products = service.getAll("1");

		for (Product pp : products) {
			System.out.println(pp.toString());
		}

	}
}
