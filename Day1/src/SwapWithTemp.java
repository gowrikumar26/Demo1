import java.util.Scanner;

public class SwapWithTemp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a value");
		int a = sc.nextInt();
		System.out.println("Enter b value");
		int b = sc.nextInt();
		int temp;
		temp=a;
		a=b;
		b=temp;
		System.out.println("a value is : "+a+ "  "  +"b value is : "+b);
		
	}

}
