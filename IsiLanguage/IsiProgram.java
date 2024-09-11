import java.util.Scanner; 
public class IsiProgram { 
  public static void main(String args[]) { 
    Scanner _key = new Scanner(System.in); 
    int a;
    int b;
    double c;
    int i;
    int l;
    String t1;
	c = 3.14;
	b = 2;
	t1 = "sss";
	a = 1+2*3/b;
    System.out.println(a);
    System.out.println(c);
    System.out.println(t1);
	l = 0;
    for (i = 0;i<3;i++) {
    	l++;
        if (b>a) {
        System.out.println(b);
    }
    else {
        System.out.println(a);
    }
    }
    System.out.println(l);
	i = 0;
    while (i<3) {
        if (b>a) {
        System.out.println(b);
    }
    else {
        System.out.println(a);
    }
    	i++;
    }
  } 
}