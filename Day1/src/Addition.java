import java.util.Scanner;

public class Addition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first number: ");
		int num1 = sc.nextInt();
		System.out.println("Enter the second number: ");
		int num2 = sc.nextInt();
		System.out.println("Enter the third number: ");
		int num3 = sc.nextInt();
		int total = num1+num2+num3;
		System.out.println("The total of 3 numbers :"+total);
	}

}
