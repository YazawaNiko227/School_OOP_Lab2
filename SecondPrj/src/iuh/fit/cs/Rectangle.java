
package iuh.fit.cs;

import java.text.DecimalFormat;

/**
 * @description Iuh_Fit_Cs_Stt36_24741631
 * @author Phan Đức Toàn
 * @version 1.0
 * @created date25 thg 8, 2025 time14:11:40
 */
public class Rectangle {
	private double length;
	private double width;
	/**
	 * Property set
	 */
	public void setLenght(double newLength) throws IllegalArgumentException{
		if(newLength < 0) {
			throw new IllegalArgumentException("Length must be greater than 0");
		}
		this.length = newLength;
	}
	public void setWidth(double newWidth) throws IllegalArgumentException{
		if(newWidth < 0) {
			throw new IllegalArgumentException("Width must be greater than 0");
		}
		this.width = newWidth;
	}
	/**
	 * Property get
	 */
	public double getLenght() {
		return length;
	}
	public double getWidth() {
		return width;
	}
	/**
	 * Method
	 */
	public double getArea() {
		return width * length;
	}
	public double getPerimeter() {
		return 2 * (width + length);
	}
	/**
	 * Constructer
	 */
	public Rectangle(double length, double width) throws IllegalArgumentException {
        if (length < 0 || width < 0) {
            throw new IllegalArgumentException("Length and width must be greater than 0");
        }
        this.length = length;
        this.width = width;
    }

	public Rectangle() {
		this(1.0,1.0);
	}
	@Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return "Rectangle: Length = " + df.format(length) + ", Width = " + df.format(width) +
               ", Perimeter = " + df.format(getPerimeter()) + ", Area = " + df.format(getArea());
    }
}
