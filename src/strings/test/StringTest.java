package strings.test;
import strings.Utils;
import strings.App;
class StringTest {
public static void main(String[] args) {
	
	//String test[] = {"aamir","luis","aman","callie","jose"};
	System.out.println("SHORT TEST:");
	String test[] = {"aamir","luis","aman","callie","jose"};

	int size = test.length;
	Utils.printarr(test,size);
	App.sort(test,0,size-1, 0);
	System.out.println("----------------");
	Utils.printarr(test,size);

	System.out.println("***************************");
	System.out.println("***************************");
	System.out.println("***************************");
	
	System.out.println("LONG TEST:");

	
	String test1[] = Utils.filler();

	int size1 = test1.length;
	Utils.printarr(test1,size1);
	App.sort(test1,0,size1-1, 0);
	System.out.println("----------------");
	Utils.printarr(test1,size1);
	// TODO Auto-generated method stub
}
}