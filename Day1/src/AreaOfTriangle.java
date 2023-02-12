import java.util.Scanner;

public class AreaOfTriangle {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		
//		System.out.println("Enter the side of 'A' :");
//		int a=sc.nextInt();
//		System.out.println("Enter the side of 'B' :");
//		int b=sc.nextInt();
//		System.out.println("Enter the side of 'C' :");
//		int c=sc.nextInt();
		
		//int area;
		//area=(a+b+c)/2;
		
		System.out.println("Enter the side of 'Base' :");
		int b=sc.nextInt();
		System.out.println("Enter the side of 'Height' :");
		int h=sc.nextInt();
		int area;
		area=b*h/2;
		//calculateArea();
		System.out.println("The area of triangle with 3 sides is : "+area);
	}
}