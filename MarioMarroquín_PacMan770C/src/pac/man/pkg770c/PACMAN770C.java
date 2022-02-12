package pac.man.pkg770c;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicBorders.MarginBorder;

import java.util.Random;

/**
 *
 * @author mariomarroquin-202110509
 */
public class PACMAN770C {

    String pared = "X", pacman = "<",fantasma = "@";
    int MenuI,premioS = 0;
    String u = " ", premioE = "$";
    int Especial = 15,Simple = 10;
    static int punteo=0, vidas = 3, a = 0;

       
    Scanner leer = new Scanner(System.in);
    
    static void MenuInicio(){
    Scanner leer = new Scanner(System.in);  
    System.out.println("===MENÚ DE INICIO===");
    System.out.println("1. Iniciar Juego");
    System.out.println("2. Historial de partidas");
    System.out.println("3. Salir");
    System.out.print("Elige una opción:"+" ");
    }   
    
       
    static void EspecificarTablero(String u){
    Scanner leer = new Scanner(System.in);
    System.out.println("===ESPECIFICAR TABLERO===");
    System.out.println("===POR FAVOR, INGRESE LOS SIGUIENTES VALORES===");
    System.out.print("TABLERO(P o G):"+" "); String Tablero = leer.nextLine();
    while (!Tablero.equals("P") && !Tablero.equals("G") ){
        System.out.println("POR FAVOR INGRESE UNA OPCION VALIDA");
        System.out.print("TABLERO(P o G):"+" "); Tablero = leer.nextLine();
    }
      
    
    if (Tablero.equals("P")){
        System.out.print("PREMIOS [1-12]:"+" "); int Premios = leer.nextInt();
        while (Premios < 1 || Premios > 12){
            System.out.println("POR FAVOR INGRESE UN NUMERO DEL RANGO ESTABLECIDO"); 
            System.out.print("PREMIOS [1-12]:"+" "); Premios = leer.nextInt();
        }


        System.out.print("PAREDES [1-6]:"+" ");  int Paredes = leer.nextInt();
        while (Paredes < 1 || Paredes > 6){
            System.out.println("POR FAVOR INGRESE UN NUMERO DEL RANGO ESTABLECIDO"); 
            System.out.print("PAREDES [1-6]:"+" ");  Paredes = leer.nextInt();
        }


        System.out.print("TRAMPAS [1-6]:"+" ");  int Trampas = leer.nextInt();
        while (Trampas < 1 ||Trampas > 6){
            System.out.println("POR FAVOR INGRESE UN NUMERO DEL RANGO ESTABLECIDO"); 
            System.out.print("TRAMPAS [1-6]:"+" ");  Trampas = leer.nextInt();
        }


        System.out.println("---INICIANDO EL JUEGO---");
        int v = 3;
        int punt =0;
        datosU(u, v, punt);
        TableroP(Premios, Paredes, Trampas,u);
        }

    if (Tablero.equals("G")){
        System.out.print("PREMIOS [1-40]:"+" "); int Premios = leer.nextInt();
        while (Premios < 1 || Premios > 40){
            System.out.println("POR FAVOR INGRESE UN NUMERO DEL RANGO ESTABLECIDO"); 
            System.out.print("PREMIOS [1-40]:"+" "); Premios = leer.nextInt();
        }

        System.out.print("PAREDES [1-20]:"+" ");  int Paredes = leer.nextInt();
        while (Paredes < 1 || Paredes > 20){
            System.out.println("POR FAVOR INGRESE UN NUMERO DEL RANGO ESTABLECIDO"); 
            System.out.print("PAREDES [1-20]:"+" ");  Paredes = leer.nextInt();
        }

        System.out.print("TRAMPAS [1-20]:"+" ");  int Trampas = leer.nextInt();
        while (Trampas < 1 ||Trampas > 20){
            System.out.println("POR FAVOR INGRESE UN NUMERO DEL RANGO ESTABLECIDO"); 
            System.out.print("TRAMPAS [1-20]:"+" ");  Trampas = leer.nextInt();
        }

        System.out.println("---INICIANDO EL JUEGO---");
        int v=3;
        int punt=0;
        datosU(u, v,punt);
        TableroG(Premios, Paredes, Trampas,u);
    }

}
 

    static void TableroP(int p, int pa, int tr, String u){
        String usuario;
        usuario=u;
        int uno = 0, dos =0, tres = 0, cuatro=0, ds =0, ts=0;
        int pre =0;
        int pad = 0;
        int i=0;
        System.out.println("-------------");       
        
        char item []= new char[6];
        
        item [1]='@';
        item [2]='0';
        item [3]='$';
        item [4]='X';
        item [5] = ' ';

        
             
        int matriz[][] = new int[5][6];
        int nume [] = new int [30];
        int x=0;
        int y = 0;

        char pasar [][] = new char [5][6];

         for ( x=0; x < matriz.length; x++) {
             System.out.print("|");
         for (y=0; y < matriz[x].length; y++) {
         int num = (int) (Math.random()*5+1); 

         if (num==1){
             uno +=1;

         } 
        
         if (num==2 ){
            dos +=1;
            if (dos != p+1){
                ds+=1;
            }
        } 

        if (num==3){
           dos +=1;
           if (dos != p+1){
            ts+=1;
        }
        } 

        if (num==4){
            cuatro +=1;
        } 


        while (uno == tr+1){
              while (num == 1){
               num = (int) (Math.random()*5+1);    
               if(cuatro == pa || uno == tr+1 || dos == p+1 || tres == p+1 ){
                num =5;
                }
         }
         uno -= 1;
        }

        if (dos == p+1){
            while (num == 2 || num ==3){
             num = (int) (Math.random()*5+1);    
            if(cuatro == pa+1 || uno == tr+1 || dos == p+1 || tres == p+1 ){
             num =5;
         }
        }
        dos -=1 ;
    
       }


       if (cuatro == pa+1){
        while (num == 4){
            num = (int) (Math.random()*5+1);
            if(cuatro == pa+1 || uno == tr+1 || dos == p+1 || tres == p+1 ){
            num =5;
            }
        }
        cuatro -=1 ;
        }

        while (uno == tr+1 && dos == p+1 && tres == p+1  && cuatro == pa+1 ){
          
          num = 5;
        }

        
         if ( i< 30){
            nume[i]=num;
            i++;
         }

        matriz[x][y]= item[num]; 
         pasar [x][y] = (char)matriz[x][y];
         System.out.print (pasar [x][y]);
         if (y!=matriz[x].length-1) System.out.print(" ");
      
         
       }
      
       System.out.println("|");
     } 
        System.out.println("-------------");
        //System.out.println(pasar[1][1]);
        //System.out.println(uno);
        //for (i=0; i< 30; i++){      
            
            FilayColumna("P", nume, usuario,p,ts,ds);
    }
        
     
    static void TableroG(int p,int pa, int tr, String u){
        String usuario;
        usuario=u;
        int uno = 0, dos =0, tres = 0, cuatro=0,ds =0, ts=0;;
        int pre =0;
        int pad = 0;
        int i=0;
        System.out.println("---------------------");       
        
        char item []= new char[6];
        
        item [1]='@';
        item [2]='0';
        item [3]='$';
        item [4]='X';
        item [5] = ' ';

        
             
        int matriz[][] = new int[10][10];
        int nume [] = new int [100];
        int x=0;
        int y = 0;

        char pasar [][] = new char [10][10];

         for ( x=0; x < matriz.length; x++) {
             System.out.print("|");
         for (y=0; y < matriz[x].length; y++) {
         int num = (int) (Math.random()*5+1); 

         if (num==1){
             uno +=1;

         } 
        
         if (num==2 ){
            dos +=1;
            if (dos != p+1){
                ds+=1;
            }
        } 

        if (num==3){
            dos +=1;
            if (dos != p+1){
             ts+=1;
            }
         }

        if (num==4){
            cuatro +=1;
        } 


        while (uno == tr+1){
              while (num == 1){
               num = (int) (Math.random()*5+1);    
               if(cuatro == pa || uno == tr+1 || dos == p+1 || tres == p+1 ){
                num =5;
                }
         }
         uno -= 1;
        }

        if (dos == p+1  ){
            while (num == 2 || num ==3){
                num = (int) (Math.random()*5+1);    
            if(cuatro == pa+1 || uno == tr+1 || dos == p+1 || tres == p+1 ){
             num =5;
         }
        }
        dos -=1 ;
    
       }


       if (cuatro == pa+1){
        while (num == 4){
            num = (int) (Math.random()*5+1);
            if(cuatro == pa+1 || uno == tr+1 || dos == p+1 || tres == p+1 ){
            num =5;
            }
        }
        cuatro -=1 ;
        }

        while (uno == tr+1 && dos == p+1 && tres == p+1  && cuatro == pa+1 ){
          
          num = 5;
        }

        
         if ( i< 100){
            nume[i]=num;
            i++;
         }

        matriz[x][y]= item[num]; 
         pasar [x][y] = (char)matriz[x][y];
         System.out.print (pasar [x][y]);
         if (y!=matriz[x].length-1) System.out.print(" ");
      
         
       }
      
       System.out.println("|");
     } 
        System.out.println("---------------------");

            FilayColumna("G", nume,usuario,p,ts,ds);
         
        
      
    }


    static void datosU(String a, int v, int punt){
        System.out.println("- - - - - - - - - - ");
        String usuario = " ";
        usuario=a;
        System.out.println("USUARIO: " + usuario);
        System.out.println("PUNTEO: " + punt);
        System.out.println("VIDAS: " + v);
    }


    static void FilayColumna(String T,int pas[],String u, int p, int ts, int ds){
        Scanner leer = new Scanner(System.in);
        System.out.println();
        System.out.print("POR FAVOR, INGRESE LA POSICIÓN INICIAL DEL JUEGO, ");
        if (T.equals("P")){
            System.out.println("TABLERO 5x6");
        }
        if (T.equals("G")){
            System.out.println("TABLERO 10x10");
        }

        
        if (T.equals("P")){
            System.out.print("FILA:"); int fila = leer.nextInt();
            while (fila <1 || fila > 5){
                System.out.println("INGRESE UN VALOR DE FILA VALIDO");
                System.out.print("FILA: "); fila = leer.nextInt();
            }
            System.out.print("COLUMNA:"); int columna = leer.nextInt();
            while (columna <1 || columna > 6){
                System.out.println("INGRESE UN VALOR DE COLUMNA VALIDO");
                System.out.print("COLUMNA: "); columna = leer.nextInt();
            }
            escribirpacman(pas, fila,columna,u,p,ts,ds);
        }

        if (T.equals("G")){
            System.out.print("FILA:"); int fila = leer.nextInt();
            while (fila <1 || fila > 10){
                System.out.println("INGRESE UN VALOR DE FILA VALIDO");
                System.out.print("FILA: "); fila = leer.nextInt();
            }
            System.out.print("COLUMNA:"); int columna = leer.nextInt();
            while (columna <1 || columna > 10){
                System.out.println("INGRESE UN VALOR DE COLUMNA VALIDO");
                System.out.print("COLUMNA: "); columna = leer.nextInt();
            }
            escribirpacmanG(pas, fila,columna,u,p,ts,ds);
        }
        
    }
    

    static void escribirpacman(int pas[],int fila, int columna,String u,int p, int ts, int ds){
        int v=3;
        int punt =0;
        datosU(u,v,punt);
        int uno = 0;
        int pre =0;
        int pad = 0;
        int i=0;
        int num =0;
       System.out.println("-------------");       
        
        char item []= new char[6];
        
        item [1]='@';
        item [2]='0';
        item [3]='$';
        item [4]='X';
        item [5] = ' ';

                     
        int matriz[][] = new int[5][6];

        int x=0;
        int y = 0;

        int fil=fila-1;
        int col=columna-1;

        char pasar [][] = new char [5][6];
        

         for ( x=0; x < matriz.length; x++) {
             System.out.print("|");
         for (y=0; y < matriz[x].length; y++) {
                  
         if (i<30){    
            num = pas[i]; 
              i++;
           }

        matriz[x][y]= item[num]; 
         pasar [x][y] = (char)matriz[x][y];
        

         pasar [fil][col]=60;
         System.out.print (pasar [x][y]);
         if (y!=matriz[x].length-1) System.out.print(" ");
      
         
       }
      
       System.out.println("|");
     } 
        System.out.println("-------------");
        System.out.println(" ");
        
        int limite = (ts*15)+(ds*10);
        int pausa = 0;
         //a = a + 1;

        while (v > 0 && pausa != 3 && punt<limite){
            
        Scanner leer = new Scanner(System.in);
        System.out.print("Ingrese movimiento(8,5,6,4):"+" ");
        char mov = leer.next().charAt(0);
        datosU(u, v, punt);
        i=0;
        


        if (mov == 70){//letra F en ascii
            System.out.println("=======PAUSA=======");
            System.out.println("1. REGRESAR");
            System.out.println("2. MENÚ PRINCIPAL");
            System.out.println("3. TERMINAR PARTIDA");
            System.out.println("¿Qué desea hacer?");
            pausa = leer.nextInt(); 
            
            if (pausa == 2){
                regreso(u, punt,a);
                pausa=3;
            }
   
        }


        if (mov == 56){//arriba | numero 8

            int filaa = fil-1;
            if (filaa<0){
                filaa=4;
            }

            switch(pasar [filaa][col]){
                case 64:
                    v -=1;
                    datosU(u, v, punt);
                    //pasar[filaa][col]=item[5];
                break;
                
                case 88:
                    fil+=1;
                    datosU(u, v, punt);
                break;

                case 36:
                    punt +=15;
                    datosU(u, v, punt);
                break;

                case 48:
                    punt +=10;
                    datosU(u, v, punt);
                break;

            }
            
            
            fil -=1; 
            if (fil<0){
                fil=4;
            }

            if (fil ==0){
                int conv = 6+col;
                pas[conv]=0;
            }
            if (fil ==1){
                int conv =12+col;
                pas[conv]=0;
            }
            if (fil ==2){
                int conv = 18+col;
                pas[conv]=0;
            }
            if (fil ==3){
                int conv =24+ col;
                pas[conv]=0;
            }
            if (fil ==4){
                int conv = col;
                pas[conv]=0;
            }

            System.out.println("-------------");       
            
             for ( x=0; x < matriz.length; x++) {
                 System.out.print("|");
             for (y=0; y < matriz[x].length; y++) {
                      
             if (i<30){    
                num = pas[i]; 
                  i++;
               }
    
            matriz[x][y]= item[num]; 
             pasar [x][y] = (char)matriz[x][y];
            
    
             pasar [fil][col]=60;
             System.out.print (pasar [x][y]);
             if (y!=matriz[x].length-1) System.out.print(" ");
          
             
           }
          
           System.out.println("|");
         } 
            System.out.println("-------------");


           
        }

        if (mov ==53){ //abajo  | numero 5
            
            int filaa = fil+1;
            if (filaa>=5){
                filaa=0;
            }


            switch(pasar [filaa][col]){
                case 64:
                    v -=1;
                    datosU(u, v, punt);
                break;
                
                case 88:
                    fil-=1;
                    datosU(u, v, punt);
                break;

                case 36:
                    punt +=15;
                    datosU(u, v, punt);
                break;

                case 48:
                    punt +=10;
                    datosU(u, v, punt);
                break;

            }

            if (fil ==0){
                int conv = col;
                pas[conv]=0;
            }
            if (fil ==1){
                int conv =col+6;
                pas[conv]=0;
            }
            if (fil ==2){
                int conv = col+12;
                pas[conv]=0;
            }
            if (fil ==3){
                int conv =col+18;
                pas[conv]=0;
            }
            if (fil ==4){
                int conv = col+24;
                pas[conv]=0;
            }


            fil +=1; 

            if (fil>=5){
                fil=0;
            }


            System.out.println("-------------");       
            
             for ( x=0; x < matriz.length; x++) {
                 System.out.print("|");
             for (y=0; y < matriz[x].length; y++) {
                      
             if (i<30){    
                num = pas[i]; 
                  i++;
               }
    
            matriz[x][y]= item[num]; 
             pasar [x][y] = (char)matriz[x][y];
            
    
             pasar [fil][col]=60;
             System.out.print (pasar [x][y]);
             if (y!=matriz[x].length-1) System.out.print(" ");
          
             
           }
          
           System.out.println("|");
         } 
            System.out.println("-------------");



        }

        if(mov == 54){ //derecha | numero 6

            int colu = col+1;
            if (colu>=6){
                colu=0;
            }

            switch(pasar [fil][colu]){
                case 64:
                    v -=1;
                    datosU(u, v, punt);
                break;
                
                case 88:
                    col-=1;
                    datosU(u, v, punt);
                break;

                case 36:
                    punt +=15;
                    datosU(u, v, punt);
                break;

                case 48:
                    punt +=10;
                    datosU(u, v, punt);
                break;

            }


            if (fil ==0){
                int conv =col;
                pas[conv]=0;
            }
            if (fil ==1){
                int conv =col+6;
                pas[conv]=0;
            }
            if (fil ==2){
                int conv = col+12;
                pas[conv]=0;
            }
            if (fil ==3){
                int conv =col+18;
                pas[conv]=0;
            }
            if (fil ==4){
                int conv = col+24;
                pas[conv]=0;
            }



            col +=1; 

            if (col>=6){
                col=0;
            }


            System.out.println("-------------");       
            
             for ( x=0; x < matriz.length; x++) {
                 System.out.print("|");
             for (y=0; y < matriz[x].length; y++) {
                      
             if (i<30){    
                num = pas[i]; 
                  i++;
               }
    
            matriz[x][y]= item[num]; 
             pasar [x][y] = (char)matriz[x][y];
            
    
             pasar [fil][col]=60;
             System.out.print (pasar [x][y]);
             if (y!=matriz[x].length-1) System.out.print(" ");
          
             
           }
          
           System.out.println("|");
         } 
            System.out.println("-------------");





        }

        if (mov == 52){//izquierda | numero 4

            
            int colu = col-1;
            if (colu<0){
                colu=5;
            }

            switch(pasar [fil][colu]){
                
                case 64:
                    v -=1;
                    datosU(u, v, punt);
                break;
                
                case 88:
                    col+=1;
                    datosU(u, v, punt);
                break;

                case 36:
                    punt +=15;
                    datosU(u, v, punt);
                break;

                case 48:
                    punt +=10;
                    datosU(u, v, punt);
                break;

            }

            if (fil ==0){
                int conv =col;
                pas[conv]=0;
            }
            if (fil ==1){
                int conv =col+6;
                pas[conv]=0;
            }
            if (fil ==2){
                int conv = col+12;
                pas[conv]=0;
            }
            if (fil ==3){
                int conv =col+18;
                pas[conv]=0;
            }
            if (fil ==4){
                int conv = col+24;
                pas[conv]=0;
            }

            col -=1; 

            if (col<0){
                col=5;
            }

            System.out.println("-------------");       
            
             for ( x=0; x < matriz.length; x++) {
                 System.out.print("|");
             for (y=0; y < matriz[x].length; y++) {
                      
             if (i<30){    
                num = pas[i]; 
                  i++;
               }
    
            matriz[x][y]= item[num]; 
             pasar [x][y] = (char)matriz[x][y];
            
    
             pasar [fil][col]=60;
             
             System.out.print (pasar [x][y]);
             if (y!=matriz[x].length-1) System.out.print(" ");
          
             
           }
          
           System.out.println("|");
         } 
            System.out.println("-------------");
        }

        

    }
    if (v==0){
        System.out.println("¡HAS PERDIDO TODAS TUS VIDAS!");
    }

    if(punt >= limite){
        System.out.println("¡FELICIDADES, GANASTE!");
    }
}


    static void escribirpacmanG(int pas[], int fila, int columna,String u, int p, int ts, int ds){
        int v=3;
        int punt =0;
        datosU(u,v,punt);
        int uno = 0;
        int pre =0;
        int pad = 0;
        int i=0;
        int num =0;
        System.out.println("---------------------");       
        
        char item []= new char[6];
        
        item [1]='@';
        item [2]='0';
        item [3]='$';
        item [4]='X';
        item [5] = ' ';

                     
        int matriz[][] = new int[10][10];

        int x=0;
        int y = 0;

        int fil=fila-1;
        int col=columna-1;

        char pasar [][] = new char [10][10];

         for ( x=0; x < matriz.length; x++) {
             System.out.print("|");
         for (y=0; y < matriz[x].length; y++) {
                  
         if (i<100){    
            num = pas[i]; 
              i++;
           }

        matriz[x][y]= item[num]; 
         pasar [x][y] = (char)matriz[x][y];
         pasar [fila-1][columna-1]=60;
         System.out.print (pasar [x][y]);
         if (y!=matriz[x].length-1) System.out.print(" ");
      
         
       }
      
       System.out.println("|");
     } 
        System.out.println("---------------------");

        System.out.println(" ");
        
        int limite = (ts*15)+(ds*10);
        int pausa = 0;


        while (v > 0 && pausa != 3 && punt<limite){
            Scanner leer = new Scanner(System.in);
            System.out.print("Ingrese movimiento(8,5,6,4):"+" ");
            char mov = leer.next().charAt(0);
            datosU(u, v, punt);
            i=0;

            if (mov == 70){//letra F en ascii
                System.out.println("=======PAUSA=======");
                System.out.println("1. REGRESAR");
                System.out.println("2. MENÚ PRINCIPAL");
                System.out.println("3. TERMINAR PARTIDA");
                System.out.println("¿Qué desea hacer?");
                pausa = leer.nextInt(); 

                if (pausa == 2){
                    regreso(u,punt,a);
                    pausa=3;
                }
       
            }



            if (mov == 56){//arriba | numero 8 en ascii
    
                int filaa = fil-1;
                if (filaa<0){
                    filaa=9;
                }
    
                switch(pasar [filaa][col]){
                    case 64:
                        v -=1;
                        datosU(u, v, punt);
                    break;
                    
                    case 88:
                        fil+=1;
                        datosU(u, v, punt);
                    break;
    
                    case 36:
                        punt +=15;
                        datosU(u, v, punt);
                    break;
    
                    case 48:
                        punt +=10;
                        datosU(u, v, punt);
                    break;
    
                }
    
    
                fil -=1; 
                if (fil<0){
                    fil=9;
                }

                if (fil ==0){
                    int conv = 10+col;
                    pas[conv]=0;
                }
                if (fil ==1){
                    int conv =20+col;
                    pas[conv]=0;
                }
                if (fil ==2){
                    int conv = 30+col;
                    pas[conv]=0;
                }
                if (fil ==3){
                    int conv =40+ col;
                    pas[conv]=0;
                }
                if (fil ==4){
                    int conv =50+ col;
                    pas[conv]=0;
                }
    
                if (fil ==5){
                    int conv = 60+col;
                    pas[conv]=0;
                }
                if (fil ==6){
                    int conv =70+col;
                    pas[conv]=0;
                }
                if (fil ==7){
                    int conv = 80+col;
                    pas[conv]=0;
                }
                if (fil ==8){
                    int conv =90+ col;
                    pas[conv]=0;
                }
                if (fil ==9){
                    int conv = col;
                    pas[conv]=0;
                }
    
                System.out.println("---------------------");       
                
                 for ( x=0; x < matriz.length; x++) {
                     System.out.print("|");
                 for (y=0; y < matriz[x].length; y++) {
                          
                 if (i<100){    
                    num = pas[i]; 
                      i++;
                   }
        
                matriz[x][y]= item[num]; 
                 pasar [x][y] = (char)matriz[x][y];
                
        
                 pasar [fil][col]=60;
                 System.out.print (pasar [x][y]);
                 if (y!=matriz[x].length-1) System.out.print(" ");
              
                 
               }
              
               System.out.println("|");
             } 
             System.out.println("---------------------");
    
    
               
            }
    
            if (mov ==53){ //abajo | numero 5 en ascii
                
                int filaa = fil+1;
                if (filaa>=10){
                    filaa=0;
                }
    
    
                switch(pasar [filaa][col]){
                    case 64:
                        v -=1;
                        datosU(u, v, punt);
                    break;
                    
                    case 88:
                        fil-=1;
                        datosU(u, v, punt);
                    break;
    
                    case 36:
                        punt +=15;
                        datosU(u, v, punt);
                    break;
    
                    case 48:
                        punt +=10;
                        datosU(u, v, punt);
                    break;
    
                }
    
    
                if (fil ==0){
                    int conv = col;
                    pas[conv]=0;
                }
                if (fil ==1){
                    int conv =col+10;
                    pas[conv]=0;
                }
                if (fil ==2){
                    int conv = col+20;
                    pas[conv]=0;
                }
                if (fil ==3){
                    int conv =col+30;
                    pas[conv]=0;
                }
                if (fil ==4){
                    int conv = col+40;
                    pas[conv]=0;
                }
                
                if (fil ==5){
                    int conv = col+50;
                    pas[conv]=0;
                }
                if (fil ==6){
                    int conv =col+60;
                    pas[conv]=0;
                }
                if (fil ==7){
                    int conv = col+70;
                    pas[conv]=0;
                }
                if (fil ==8){
                    int conv =col+80;
                    pas[conv]=0;
                }
                if (fil ==9){
                    int conv = col+90;
                    pas[conv]=0;
                }


    
    
                fil +=1; 
    
                if (fil>=10){
                    fil=0;
                }
    
    
                System.out.println("---------------------");       
                
                 for ( x=0; x < matriz.length; x++) {
                     System.out.print("|");
                 for (y=0; y < matriz[x].length; y++) {
                          
                 if (i<100){    
                    num = pas[i]; 
                      i++;
                   }
        
                matriz[x][y]= item[num]; 
                 pasar [x][y] = (char)matriz[x][y];
                
        
                 pasar [fil][col]=60;
                 System.out.print (pasar [x][y]);
                 if (y!=matriz[x].length-1) System.out.print(" ");
              
                 
               }
              
               System.out.println("|");
             } 
             System.out.println("---------------------");
    
    
    
            }
    
            if(mov == 54){ //derecha | numero 6 en ascii
    
                int colu = col+1;
                if (colu>=10){
                    colu=0;
                }
    
                switch(pasar [fil][colu]){
                    case 64:
                        v -=1;
                        datosU(u, v, punt);
                    break;
                    
                    case 88:
                        col-=1;
                        datosU(u, v, punt);
                    break;
    
                    case 36:
                        punt +=15;
                        datosU(u, v, punt);
                    break;
    
                    case 48:
                        punt +=10;
                        datosU(u, v, punt);
                    break;
    
                }
    
            if (fil ==0){
                int conv =col;
                pas[conv]=0;
            }
            if (fil ==1){
                int conv =col+10;
                pas[conv]=0;
            }
            if (fil ==2){
                int conv = col+20;
                pas[conv]=0;
            }
            if (fil ==3){
                int conv =col+30;
                pas[conv]=0;
            }
            if (fil ==4){
                int conv = col+40;
                pas[conv]=0;
            }

            if (fil ==5){
                int conv =col+50;
                pas[conv]=0;
            }
            if (fil ==6){
                int conv =col+60;
                pas[conv]=0;
            }
            if (fil ==7){
                int conv = col+70;
                pas[conv]=0;
            }
            if (fil ==8){
                int conv =col+80;
                pas[conv]=0;
            }
            if (fil ==9){
                int conv = col+90;
                pas[conv]=0;
            }

                col +=1; 
    
                if (col>=10){
                    col=0;
                }
    
    
                System.out.println("---------------------");       
                
                 for ( x=0; x < matriz.length; x++) {
                     System.out.print("|");
                 for (y=0; y < matriz[x].length; y++) {
                          
                 if (i<100){    
                    num = pas[i]; 
                      i++;
                   }
        
                matriz[x][y]= item[num]; 
                 pasar [x][y] = (char)matriz[x][y];
                
        
                 pasar [fil][col]=60;
                 System.out.print (pasar [x][y]);
                 if (y!=matriz[x].length-1) System.out.print(" ");
              
                 
               }
              
               System.out.println("|");
             } 
             System.out.println("---------------------");

            }
    
            if (mov == 52){//izquierda | numero 4 en ascii
    
                
                int colu = col-1;
                if (colu<0){
                    colu=9;
                }
    
                switch(pasar [fil][colu]){
                    
                    case 64:
                        v -=1;
                        datosU(u, v, punt);
                    break;
                    
                    case 88:
                        col+=1;
                        datosU(u, v, punt);
                    break;
    
                    case 36:
                        punt +=15;
                        datosU(u, v, punt);
                    break;
    
                    case 48:
                        punt +=10;
                        datosU(u, v, punt);
                    break;
    
                }
    
                if (fil ==0){
                    int conv =col;
                    pas[conv]=0;
                }
                if (fil ==1){
                    int conv =col+10;
                    pas[conv]=0;
                }
                if (fil ==2){
                    int conv = col+20;
                    pas[conv]=0;
                }
                if (fil ==3){
                    int conv =col+30;
                    pas[conv]=0;
                }
                if (fil ==4){
                    int conv = col+40;
                    pas[conv]=0;
                }
    
                if (fil ==5){
                    int conv =col+50;
                    pas[conv]=0;
                }
                if (fil ==6){
                    int conv =col+60;
                    pas[conv]=0;
                }
                if (fil ==7){
                    int conv = col+70;
                    pas[conv]=0;
                }
                if (fil ==8){
                    int conv =col+80;
                    pas[conv]=0;
                }
                if (fil ==9){
                    int conv = col+90;
                    pas[conv]=0;
                }

                col -=1; 
    
                if (col<0){
                    col=9;
                }
    
                System.out.println("---------------------");       
                
                 for ( x=0; x < matriz.length; x++) {
                     System.out.print("|");
                 for (y=0; y < matriz[x].length; y++) {
                          
                 if (i<100){    
                    num = pas[i]; 
                      i++;
                   }
        
                matriz[x][y]= item[num]; 
                 pasar [x][y] = (char)matriz[x][y];
                
        
                 pasar [fil][col]=60;
                 
                 System.out.print (pasar [x][y]);
                 if (y!=matriz[x].length-1) System.out.print(" ");
              
                 
               }
              
               System.out.println("|");
             } 
             System.out.println("---------------------");
            }
        }
            if (v==0){
        System.out.println("¡HAS PERDIDO TODAS TUS VIDAS!");
    }

    if(punt >= limite){
        System.out.println("¡FELICIDADES, GANASTE!");
    }

}


    static void historial(String nomb, int pts, int i){
        Scanner t = new Scanner(System.in);
        String [] nombres = new String [i+1];
        int [] puntos = new int [i+1];
        //do{
        nombres[i] = nomb;
        puntos [i]=pts;
        //i++;
        //}while(i==0);
        System.out.println("Usuario:            Punteo:");

        for (int j=0; j<nombres.length; j++){
        String nombre = nombres[j];
        int punto = puntos[j];
        String PUntos = Integer.toString(punto);
        
        //if (nombre.equals("null") && PUntos.equals("0") ){
            //nombre=" ";
            //PUntos = " ";
        //}
        System.out.println("   " + nombre + "              "+ PUntos);
        
    }
        System.out.print("Preciona ENTER para regresar al MENÚ");
        String enterkey = t.nextLine();
             if (enterkey.isEmpty()) {
                regreso(nomb, pts, i);          
             }
  
    }

static String usuario = " ";   

static void regreso(String u, int punt, int a){
      
   Scanner leer = new Scanner(System.in);
   
   MenuInicio();  
   int MenuI = leer.nextInt();
     
   while ( MenuI < 1 || MenuI > 3){
        System.out.println("=POR FAVOR INGRESE UNA OPCIÓN VALIDA=");
        MenuInicio();  
        MenuI = leer.nextInt();
   }

   switch (MenuI){
       case 1 ->{
        System.out.print("Ingrese nombre de usuario:"+" ");
        usuario = leer.next();
        //a+=1;
        // guardarNombre(usuario);
        //historial(usuario);
        
        EspecificarTablero(usuario);
               
       }
       
       case 2 ->{
        System.out.println("===HISTORIAL DE PARTIDAS===");
        historial(u, punt,a);
       }  
       
       case 3 ->{
        

       }
    }
    
  }


    public static void main(String[] args) {
    
  
   Scanner leer = new Scanner(System.in);
   
   MenuInicio();  
   int MenuI = leer.nextInt();
    //do{ 
   while ( MenuI < 1 || MenuI > 3){
        System.out.println("=POR FAVOR INGRESE UNA OPCIÓN VALIDA=");
        MenuInicio();  
        MenuI = leer.nextInt();
   }

   switch (MenuI){
       case 1 ->{
        System.out.print("Ingrese nombre de usuario:"+" ");
        usuario = leer.next();
        //a+=1;
        // guardarNombre(usuario);
        //historial(usuario,a,a);
        
        EspecificarTablero(usuario);

        
                
       }
       
       case 2 ->{
        System.out.println("===HISTORIAL DE PARTIDAS===");
        System.out.println("AÚN NO HAY PARTIDAS");
        System.out.print("Preciona ENTER para regresar al MENÚ");
        leer.nextLine();
        String enterkey = leer.nextLine();
        if (enterkey.isEmpty()) {
            MenuInicio();
            MenuI = leer.nextInt(); 
            while ( MenuI < 1 || MenuI > 3){
                System.out.println("=POR FAVOR INGRESE UNA OPCIÓN VALIDA=");
                MenuInicio();  
                MenuI = leer.nextInt();
           }
        
           switch (MenuI){
               case 1 ->{
                System.out.print("Ingrese nombre de usuario:"+" ");
                usuario = leer.next();
                //a+=1;
                // guardarNombre(usuario);
                //historial(usuario,a,a);
                
                EspecificarTablero(usuario);
        
                
                        
               }
               
               case 2 ->{
                System.out.println("===HISTORIAL DE PARTIDAS===");
                System.out.println("AÚN NO HAY PARTIDAS");
                System.out.print("Preciona ENTER para regresar al MENÚ");
                leer.nextLine();
                enterkey = leer.nextLine();
                if (enterkey.isEmpty()) {
                    MenuInicio();
                    MenuI = leer.nextInt();       
                    }
               }  
               
               case 3 ->{
                
        
                    }
            



            }
       } } 
       
       case 3 ->{
        

            }
        }

    }
    
}
