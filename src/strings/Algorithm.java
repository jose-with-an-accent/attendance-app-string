package strings;

public class Algorithm {
    public static String[] sort(String[] a) {
        sort(a, 0, a.length - 1, 0);
        return a;

    }

    public static void sort(String[] a, int lo, int hi, int d)
    {
    	if (hi <= lo) 
    	{
    		return;
    	}
    	int lt = lo, gt = hi;
    	int v = Utils.charAt(a[lo], d);
    	int i = lo + 1;
    	while (i <= gt)
    {
    	int t = Utils.charAt(a[i], d);
    	if (t < v) 
    	{
    		Utils.exch(a, lt++, i++);
    	}
    	else if (t > v) 
    	{
    		Utils.exch(a, i, gt--);
    	}
    	else i++;
    }
    // a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]
    	sort(a, lo, lt-1, d);
    	if (v >= 0) {
    		sort(a, lt, gt, d+1);
    	}
    	sort(a, gt+1, hi, d);
    } 
    
}
