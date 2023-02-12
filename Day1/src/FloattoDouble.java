
public class FloattoDouble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float value = 20.4f;
		Float obj=new Float(value);
		double obj1=obj.doubleValue();
		System.out.println("The double value is:"+obj1);
		
		double value1 = 20.39999999;
		Double obj2=new Double(value1);
		float floatobj=obj2.floatValue();
		
		System.out.println("The float value is:"+floatobj);
	}

}
