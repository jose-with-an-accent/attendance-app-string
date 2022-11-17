package strings;
import java.util.ArrayList;
import java.util.List;

public class Utils {
	public static void exch(String[] a, int i, int j) {
		
		String temp = a[i];
	    a[i] = a[j];
	    a[j] = temp;
		// TODO Auto-generated method stub
		
	}
	//3WayQuickSort From Textbook
		public static int charAt(String s, int d)
		{
			if (d < s.length()) {
				return s.charAt(d);
			}
			else
			{
				return -1; 
			}
			
		}
		public static String[] filler (int arrLength, int strLength)
		{
			//returns String[] with 50 random entries of length 10
			String potentials = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
			List<String> strings = new ArrayList<String>();
			for (int i=0;i<arrLength;i++)
			{
				StringBuilder randomword = new StringBuilder();
				for (int j=0;j<strLength;j++)
				{
					int picker = (int)(potentials.length()*Math.random());
					randomword.append(potentials.charAt(picker));
				
				}
				String randomword1 = randomword.toString();
				strings.add(randomword1);
			}
			String[] toreturn = new String[strings.size()];
			for (int i = 0; i < strings.size(); i++) 
			{
	            toreturn[i] = strings.get(i);
	        }
			return toreturn;
			
		}
		public static void printarr(String[] test, int n)
		{
		    for (int i = 0; i < n; ++i)
		        System.out.println( test[i]);
		}
}
