
package examenes;

import java.util.Scanner;
public class Examen1 {

   
    public static void main(String[] args) {
       //Creacion del Scanner para la entrada de datos por el teclado
       Scanner entrada = new Scanner(System.in);
       //Declaracion de variables
        float a, b, fa, fb, xr, eInicial = 0, eP = 0, m = 0, erroAcu = 0;
        Double fxr;
        int i = 1, k = 1, in;
       int opc;
       String cont ;
       //Comparacion para realisar otra funcion
        do{
       //Imprecion de instrucciones 
        System.out.println("\t\tPrograma que calcula la raiz solucion de la funcion en un\n \t\t\tintervalo [a,b]"
                +          "por el metodo de biseccion.");
        System.out.println("\t\t\tElavorado por: Raul Velasco Arcos");
        System.out.println("\t\t\tDe la carrera de:Ingenieria en Sistemas Computacionales");
        System.out.println("\t\t\t\t\tMENU");
        System.out.println("1.f(x)=e ^-x3 -0.5+30");
        System.out.println("2.g(x)=cos(-0.5x2+2x)+1.125x-6.14");
        System.out.println("Elige una funcion");
        opc=entrada.nextInt();
        
            //comparaciones para elegir la funcion a realizar
            if(opc ==1){
                System.out.println("1.f(x)=e ^-x3 -0.5+30");
                System.out.println("\tMENU\n1)Por bloques\n2)Por iteracciones");
                System.out.println("Opcion :");
                int opcv = entrada.nextInt();
                if (opcv == 1) {
                    //Inicia el codigo por bloques 
                    System.out.println("Por bloques");
                    do {

                        System.out.println("Valor de a");
                        a = entrada.nextFloat();
                        System.out.println("Valor de b");
                        b = entrada.nextFloat();
                        //Sustitucion de a y b para la funcion 
                        fa = (float) (2 * a * Math.exp(-0.5 * a) + 3 * a - 20);
                        fb = (float) (2 * b * Math.exp(-0.5 * b) + 3 * b - 20);
                        //Condicion que este en el intervalo 
                        if (fa * fb < 0) {

                            System.out.println("Ingrese el error permitido");
                            eInicial = entrada.nextFloat();
                            do {
                                //Por bloques
                                System.out.println("Iteracion=" + i);

                                System.out.println("f(" + a + "= " + fa);
                                System.out.println("f(" + b + "= " + fb);

                                xr = (a + b) / 2;

                                fxr = (2 * xr * Math.exp(-0.5 * xr) + 3 * xr - 20);
                                System.out.println("f(" + fxr + ") =" + fxr);

                                //Cambio de intervalos
                                if (fa * fxr < 0) {
                                    a = a;
                                    b = xr;
                                } else {
                                    a = xr;
                                    b = b;
                                }
                                //Calculo del error
                                eP = 100 * (Math.abs((xr - erroAcu) / xr));
                                erroAcu = xr;
                                i++;

                            } while (eP >= eInicial);
                        } else {
                            //Condicion del contador de vecees
                            System.out.println("Valores de a y b no tienen una raiz solucion");
                            k++;

                            if (k == 4) {
                                System.out.println("Sugerencia a=-5,b=10");
                            }

                        }
                    } while ((k < 0) || (eP >= eInicial));
                }//Terminal el codigo por bloques
                else if(opcv==2){//Inicio por iteraciones
                    //Inicia Por iteracsiones

                    System.out.println("Por iteracsiones ");
                    do {

                        System.out.println("Valor de a");
                        a = entrada.nextFloat();
                        System.out.println("Valor de b");
                        b = entrada.nextFloat();
                        System.out.println("Numero de iteraciones");
                        in = entrada.nextInt();
                        //Sustitucion de a y b para la funcion 
                        fa = (float) (2 * a * Math.exp(-0.5 * a) + 3 * a - 20);
                        fb = (float) (2 * b * Math.exp(-0.5 * b) + 3 * b - 20);
                        //Condicion que este en el intervalo 
                        if (fa * fb < 0) {

                            System.out.println("Ingrese el error permitido");
                            eInicial = entrada.nextFloat();
                            System.out.println("i\ta\tb\txm\tf(xm)\terror");
                            do {
                                //Por bloques

                                xr = (a + b) / 2;

                                fxr = (2 * xr * Math.exp(-0.5 * xr) + 3 * xr - 20);

                                //Cambio de intervalos
                                if (fa * fxr < 0) {
                                    a = a;
                                    b = xr;
                                } else {
                                    a = xr;
                                    b = b;
                                }
                                //Calculo del error
                                eP = 100 * (Math.abs((xr - erroAcu) / xr));
                                erroAcu = xr;
                                i++;
                                System.out.println(i + "\t" + String.format("%.3f", a) + "\t" + String.format("%.3f", b) + "\t" + String.format("%.3f", xr) + "\t" + String.format("%.3f", fxr) + "\t" + String.format("%.3f", eP));
                                
                                //System.out.println(i+"----"+in);
                                 
                            } while (eP >= eInicial);
                        } else {
                            //Condicion del contador de vecees
                            System.out.println("Valores de a y b no tienen una raiz solucion");
                            k++;
                            //Comparacion logica para el numero de intentos
                            if (k == 4) {
                                System.out.println("Sugerencia a=-5,b=10");
                            }
                            
                        }
                        System.out.println(i+"----"+in);
                    } while ((k < 0) || (eP >= eInicial));
                    
                }else{
                    System.out.println("Opcion invalida");
                }
                 
            }else if(opc==2){
                System.out.println("2.g(x)=cos(-0.5x2+2x)+1.125x-6.14");
            }else{
                System.out.println("Opcion invalida intente de nuevo ");
            }
            System.out.println("Quieres hacer otra funcion Si(s)o No(n)");
            cont = entrada.next();
        }while((cont.equalsIgnoreCase("s")));
            
    }
    
}
