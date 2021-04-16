package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UserProduct;

public class MainProgram {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Enter the number of products: ");
		int num = sc.nextInt();
		
		List<Product> list = new ArrayList<>();

		for (int i = 1; i <= num; i++) {
			System.out.println("Product #" + i + " data: ");
			System.out.print("Common, used or imported (c/u/i)? ");
			char c = sc.next().toLowerCase().charAt(0);

			sc.nextLine();

			System.out.print("Name: ");
			String Pname = sc.nextLine();
			System.out.print("Price: ");
			double Pprice = sc.nextDouble();
			if(c == 'c') {
				list.add(new Product(Pname, Pprice));
			}
			
			else if(c == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date date = sdf.parse(sc.next());
				list.add(new UserProduct(Pname, Pprice, date));
			}
			else if(c == 'i') {
				System.out.print("Customs fee: ");
				double Pcustomsfee = sc.nextDouble();
				list.add(new ImportedProduct(Pname, Pprice, Pcustomsfee));
			}
		}
		
		System.out.println("PRICE TAGS: ");
		for (Product p : list) {
			System.out.println(p.priceTag());
		}

	}

}
