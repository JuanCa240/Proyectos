
package Calculadora;
import java.util.Scanner;

public class Main {
    Scanner teclado;
    Operaciones operaciones;
    
    public Main(){
       teclado = new Scanner(System.in);
       operaciones = new Operaciones();
    }
    
    public void Menu(){
        
       System.out.println("Introduce un número: ");
      
      int numero1 = teclado.nextInt();
                    
      System.out.println("Introduce otro número: ");       
      int numero2 = teclado.nextInt();
      
      boolean iteracion = true;
      while(iteracion){
          System.out.println("Ingrese la operacion que desea realizar: ");       
          System.out.println("1.) Sumar");
          System.out.println("2.) Restar");  
          System.out.println("3.) Multiplicar");  
          System.out.println("4.) Dividir"); 
          
          int opcion = teclado.nextInt();
          
          switch(opcion){
              case 1: System.out.println("La suma es de " + operaciones.calulcarSuma(numero1, numero2)+ "\n");
              break;
              
              case 2: System.out.println("La resta es de: " + operaciones.calcularResta(numero1, numero2)+ "\n");
              break;
              
              case 3: System.out.println("La multiplicacion es de: " + operaciones.calcularMultiplicacion(numero1, numero2)+ "\n");
              break;
              
              case 4: System.out.println("La división es de " + operaciones.caluclarDivision(numero1, numero2)+ "\n");
              break;
              
              case 5: System.out.println("Error ingrese un valor correcto");
              default:
              
          }             
      }  
    }
    
    public static void main(String[] args){
      Main menu = new Main();
      menu.Menu();
      
    }
}
