import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("""
                -- Numeritos 3000 --
                Escribe el número al que quieres colocar los caracteres
                
                -->\s""");
        long num = in.nextLong(); //input
        dots(num);
    }

    public static void dots(long num){
        String numString = String.valueOf(num), caracter1, caracter2, numFinal;
        int acumulador = 0, acumuladorDivisible = 0;
        if (numString.length() > 3){
            int cantidadCaracteres = cantidadCaracteres(num);
            if (cantidadCaracteres % 2 == 1){
                caracter1 = ".";
                caracter2 = "'";
            }else {
                caracter1 = "'";
                caracter2 = ".";
            }
            int cantidadInicial = cantidadInicial(num, cantidadCaracteres);
            if (cantidadInicial == 0){
                cantidadInicial = 3;
            }
            numFinal = numString.substring(0,cantidadInicial) + caracter1;
            for (int i = cantidadInicial; i <= (numString.length() - 1); i++){
                numFinal += numString.charAt(i);
                acumulador += 1;
                if (acumulador % 3 == 0 && i != (numString.length() - 1)){
                    acumuladorDivisible += 1;
                    if (acumuladorDivisible % 2 == 1){
                        numFinal += caracter2;
                    }else {
                        numFinal += caracter1;
                    }
                }
            }
            System.out.println("""
                    El número con los caracteres es:
                    """ + numFinal);
        }else { //Si el número no contiene puntos
            System.out.println(num);
        }
    }

    /*
    Esta función lo que hace es decir cuantos caracteres de dots tiene el input
     */
    public static int cantidadCaracteres(long num){
        String numString = String.valueOf(num);
        int acumulador = 0, caracterOption = 0;
        for (int i = numString.length(); i > 0; i--) {
            acumulador += 1;
            //Cada que posen 3 números (cuando va un punto) se sumará 1 indicando cuantos caracteres tiene
            if (acumulador % 3 == 0 && i != 1){
                caracterOption += 1;
            }
        }
        //Retronará la cantidad de caracteres que tiene el input
        return caracterOption;
    }

    /*
    Esta función sirve para saber cuántos números iniciales tiene el input
     */
    public static int cantidadInicial(long num, int cantidadCaracteres){
        String numString = String.valueOf(num);
        int acumulador = 0, acumuladorDivisible = 0, cantidadInicial= 0;
        for (int i = numString.length(); i > 0; i--){
            acumulador += 1;
            //Para que no se coloque un número inicial de mas esta condición se debe de cumplir antes que
            //la que le prosigue
            if (acumuladorDivisible == cantidadCaracteres){
                cantidadInicial += 1;
            }
            //Cuando llegue al momento de los números iniciales se dejara de ejecutar esta condición
            if(acumulador % 3 == 0 && acumuladorDivisible != cantidadCaracteres){
                acumuladorDivisible += 1;
            }
        }
        //Retornará la cantidad de números iniciales
        return cantidadInicial;
    }
}