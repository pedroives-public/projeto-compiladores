import java.util.Scanner; 
public class IsiProgram { 
  public static void main(String args[]) { 
    Scanner _key = new Scanner(System.in); 
    int a;
    boolean b;
    char c;
    String t;
    int i;
    int j;
    t = "ola";
    b = true;
    c = 'w';
    for (i = 0; i<10 && i!=5 || i>20; i++) {
        System.out.println(i);
        j = 0;
    }
    while (i<15) {
        System.out.println("foi 1");
        i++;
    }
    do {
        System.out.println("foi 2");
        i++;
    } while (i<20);
    a = 10;
    System.out.println(a);
  } 
}