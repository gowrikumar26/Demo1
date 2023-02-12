
public class FunctionOverloading {
	static int total;
	public static void add(int a , int b) {
		total=a+b;
		System.out.println("Total of 2 numbers is :"+total);
	}
	public static void add(int a, int b, int c) {
		total=a+b+c;
		System.out.println("Total of 3 numbers is :"+total);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		add(24,61);
		add(2,4,6);
		
	}

}
