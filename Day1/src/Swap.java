import java.util.Scanner;

public class Swap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a value :");
		int a =sc.nextInt();
		System.out.println("Enter b value :");
		int b=sc.nextInt();
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println("a value is "+a);
		System.out.println("b value is "+b);
		
	}

}
