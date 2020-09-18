import java.util.*;

class Main{  
public static void main(String args[]){
  /*
    array de jogadas
    
    X O X
    X X X
    O X O
    
    */
  String[] j = {" ", " ", " ", " ", " ", " "," ", " ", " "}; // X O
  
  /*
    array simulando o teclado numerico (numeric keyboard)
    
    7 8 9
    4 5 6
    1 2 3
    
    */
  Integer [] numKey = {7,8,9,4,5,6,1,2,3};
  
  // capturar a jogada do usuario
  Scanner sc = new Scanner(System.in);
  //posicao escolhida 
  int userChoice, cpuChoice;
  
  //opcoes de escolha sem repeticao
  ArrayList<Integer> cpuOptions = new ArrayList<Integer>();
     for (int i = 0; i < 9; i++) {
     cpuOptions.add(i);
  }
  int c = 0;
  
  // loop ate toda a array j estiver completa
  while (
    j[0].equals(" ") || j[1].equals(" ") || j[2].equals(" ") ||
    j[3].equals(" ") || j[4].equals(" ") || j[5].equals(" ") ||
    j[6].equals(" ") || j[7].equals(" ") || j[8].equals(" ")  ) {
          
    System.out.println (
      "\n ( ͡° ʖ̯ ͡°) Faça sua jogada!!!"
    );
         
    // jogada do usuario - captura digitacao no teclado numerico 
    userChoice = sc.nextInt();
    j[userChoice-1] = "X";
    
    /* jogada do computador 
      gera jogada randomizada, de zero a oito sem repetir numeros
      */
    Random random = new Random();
    
    // double para verificao recursiva de jogada 
    boolean b = false;
    
    // verificar recutsivamente se a jogada ja feita pelo usuario
    while (b == false) {
   
    if(! (cpuOptions.size()==0) ) {
      
      int option = random.nextInt(cpuOptions.size());
      cpuChoice = cpuOptions.get(option);
      cpuOptions.remove(option);
      
      if(j[cpuChoice].equals(" ")){
        j[cpuChoice] = "O";  
        b = true;
      }  // fim if j[cpuChoice]
     
      System.out.println(
        "\n ( ͠° ͟ʖ ͡°) " 
        + (userChoice) +" vs "
        + (cpuChoice+1)
        + " σ( •̀ ω •́ σ) " 
        );
        
     } // fim if cpuOptions.size()
     
     if(c>12){
       b = true;
     }  // fim if j[...]
     c++;
                   
     } // fim while b==false
       
     System.out.println("     ");
                
     //impressão das jogadas 
     for (int i : numKey) {
     switch (i) {
       case 7: System.out.print (j[i-1]);
       break;
       case 8: System.out.print ("|" + j[i-1]);
       break;
       case 9: System.out.print ("|" + j[i-1]);
       break;
       case 4: System.out.print ("\n" + j[i-1]);
       break;
       case 5: System.out.print ("|" + j[i-1]);
       break;
       case 6: System.out.print ("|" + j[i-1]);
       break;
       case 1: System.out.print ("\n" + j[i-1]);
       break;
       case 2: System.out.print ("|" + j[i-1]);
       break;
       case 3: System.out.print ("|" + j[i-1]);
       break;
      } // fim switch
    } // fim if i

   System.out.println("     ");
   
   } // fim while 
   System.out.println (
     "\n \n ( ノ-_-)ノﾞ_□ > GAME OVER □_ヾ(^-^ヽ)");
   }  
}  