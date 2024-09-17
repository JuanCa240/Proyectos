package Calculadora;
import javax.swing. *;


public class CalculadoraGrafica {
    Operaciones operaciones;
    
    public CalculadoraGrafica(){
       operaciones = new Operaciones();
    }
    
    public void Menu(){
       JOptionPane.showMessageDialog(null,"CALCULADORA PARA REALIZAR OPERACIONES");
        
      System.out.println("Introduce un número: ");
      int numero1 = Integer.parseInt(JOptionPane.showInputDialog(null,"INGRESE UN NUMERO"));
                    
      System.out.println("Introduce otro número: ");       
      int numero2 = Integer.parseInt(JOptionPane.showInputDialog(null,"INGRESE OTRO NUMERO"));
      
      JOptionPane.showMessageDialog(null,numero1+numero2+" SUMA");
      JOptionPane.showMessageDialog(null,numero1-numero2+" RESTA");
      JOptionPane.showMessageDialog(null,numero1*numero2+" MULTIPLICACION");
      JOptionPane.showMessageDialog(null, numero1/numero2+" DIVISION");
                  
    }
    
    public static void main(String[] args){
        CalculadoraGrafica menu = new CalculadoraGrafica();
        menu.Menu();
    }  
}
