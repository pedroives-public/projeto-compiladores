import java.util.Scanner; 
public class IsiProgram { 
  public static void main(String args[]) { 
    Scanner _key = new Scanner(System.in); 
    int a;
    int b;
    boolean flag;
    int c;
    int misto;
    int d;
    char ch;
    int soma;
    int divisao;
    String entradaUsuario;
    int i;
    int variavelQueNaoSeraUtilizada;
    boolean falseFlag;
    int variavelSemValorInicial;
    double r;
    String t;
    int subtracao;
    int testeVariavelSemValorInicial;
    int multiplicacao;
    System.out.println("Itens Obrigatórios");
    System.out.println("1. Possui 2 tipos de variáveis");
    i = 5;
    System.out.println("\nInteiro: ");
    System.out.println(i);
    r = 3.14;
    System.out.println("\nReal: ");
    System.out.println(r);
    flag = true;
    System.out.println("\nBooleano: ");
    System.out.println(flag);
    ch = 'O';
    System.out.println("\nCaractere: ");
    System.out.println(ch);
    t = "Olá, Mundo!";
    System.out.println("\nTexto: ");
    System.out.println(t);
    System.out.println("\n2. Possui a estrutura If.. else");
    System.out.println("\n2.1 Apenas If");
    if (i<20) {
        System.out.println("i é menor que 20");
    }
    if (i>=5) {
        System.out.println("\ni é maior ou igual a 5");
    }
    if (i<=5) {
        System.out.println("\ni é menor ou igual a 5");
    }
    if (i==5) {
        System.out.println("\ni é igual a 5");
    }
    if (i!=5) {
        System.out.println("\ni é diferente de 5");
    }
    if (i!=6) {
        System.out.println("\ni é diferente de 6");
    }
    System.out.println("\n2.2 If.. else");
    if (i>10) {
        System.out.println("i é maior que 10");
    }
    else {
        System.out.println("i não é maior que 10");
    }
    System.out.println("\n3. Possui estrutura de controle while/do while");
    System.out.println("\n3.1 while");
    i = 0;
    while (i<5) {
        System.out.println("O valor de i é: ");
        System.out.println(i);
        System.out.println("");
        i++;
    }
    System.out.println("\n3.2 do while");
    i = 0;
    do {
        System.out.println("O valor de i é: ");
        System.out.println(i);
        System.out.println("");
        i++;
    } while (i<5);
    System.out.println("\n3.3 for");
    for (i = 0; i<5; i++) {
        System.out.println("O valor de i é: ");
        System.out.println(i);
        System.out.println("");
    }
    System.out.println("\n4. Operações Aritméticas executadas corretamente");
    a = 1;
    b = 2;
    c = 3;
    d = 4;
    soma = a+b;
    System.out.println("Soma: ");
    System.out.println(soma);
    subtracao = c-a;
    System.out.println("\nSubtração: ");
    System.out.println(subtracao);
    multiplicacao = b*c;
    System.out.println("\nMultiplicação: ");
    System.out.println(multiplicacao);
    divisao = d/b;
    System.out.println("\nDivisão: ");
    System.out.println(divisao);
    misto = a+b*(d-a)+b/c;
    System.out.println("\nMúltiplas operações em uma mesma expressão: ");
    System.out.println(misto);
    System.out.println("\n5. Atribuições realizadas corretamente: já testado nos itens anteriores");
    System.out.println("\n6. Possui operações de Entrada e Saída");
    entradaUsuario = _key.nextLine();
    System.out.println(entradaUsuario);
    System.out.println("\n7. Aceita números decimais: já testado nos itens anteriores");
    System.out.println("\n8. Verificar se a variável já foi previamente declarada");
    System.out.println("\n9. Verificar se a variável foi declarada e não foi usada");
    variavelQueNaoSeraUtilizada = 2;
    System.out.println("\n10. Verificar se uma variável está sendo usada sem ter valor inicial");
    variavelSemValorInicial = 0;
    testeVariavelSemValorInicial = 2+variavelSemValorInicial;
    System.out.println(testeVariavelSemValorInicial);
    System.out.println("\nItens Opcionais");
    System.out.println("\n3. Inserção de Operadores lógicos");
    i = 5;
    if (i>3 && i<6) {
        System.out.println("\ni é maior que 3 e menor que 6");
    }
    if (i<3 || i<5) {
        System.out.println("\ni é menor que 3 e/ou menor que 5");
    }
    else {
        System.out.println("\ni não é menor que 3 e i não é menor que 5");
    }
    falseFlag = false;
    if (!falseFlag) {
        System.out.println("Verdadeiro!");
    }
  } 
}