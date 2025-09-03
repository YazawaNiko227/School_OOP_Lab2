/**
 * 
 */
package iuh.fit.cs;

import java.util.Scanner;

/**
 * @description Iuh_Fit_Cs_Stt36_24741631
 * @author Phan Đức Toàn
 * @version 1.0
 * @created date25 thg 8, 2025 time14:12:26
 */
public class TestRectangle {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		  Scanner scanner = new Scanner(System.in);
	        try {
	            System.out.print("Enter the length of the rectangle: ");
	            double length = scanner.nextDouble();

	            System.out.print("Enter the width of the rectangle: ");
	            double width = scanner.nextDouble();

	            Rectangle rect = new Rectangle(length, width);

	            System.out.println("\n--- Rectangle Details ---");
	            System.out.println("Perimeter: " + rect.getPerimeter());
	            System.out.println("Area: " + rect.getArea());
	            System.out.println(rect.toString());

	        } catch (IllegalArgumentException e) {
	            System.out.println("Error: " + e.getMessage());
	        } finally {
	            scanner.close();
	        }
	    }
}
