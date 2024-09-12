import java.util.Scanner; 
public class IsiProgram { 
  public static void main(String args[]) { 
    Scanner _key = new Scanner(System.in); 
    int a;
    int b;
    int c;
    int d;
    a = _key.nextInt();
    b = _key.nextInt();
	c = a+b*2;
	d = (a+b)*2;
    System.out.println(c);
    System.out.println(d);
  } 
}