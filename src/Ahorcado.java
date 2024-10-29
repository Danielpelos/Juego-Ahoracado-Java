import java.util.Scanner;
public class Ahorcado {
    public static void main(String[] args) throws Exception {
        //Clase escanner para que el usuario escriba
        Scanner scanner = new Scanner(System.in);

        //Declaraciones y Asignaciones
        String palabraSecreta = "inteligencia";
        int intentosMaximos = 10;
        int intentos = 0; 
        boolean palabraAdivinada = false;

        //Arreglos(Array)
        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        //Estructura de Control: Iterativa, para mostrar la cantidad cantidad de las letras de la palabra en guiones
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_'; //Aqui digo por cada letra que hay un guion
        }

        //Estructura de Control: Iterativa,
        while (!palabraAdivinada && intentos < intentosMaximos) {
                                                            //Esto se usa cuando tengamos una palabra de chars
            System.out.println("Palabra a adivinar " + String.valueOf(letrasAdivinadas) + " (" + (palabraSecreta.length() + " letras)"));
            System.out.println("Introduce una letra, por favor: ");

            //Usamos la clase escanner para pedir una letra
            // char letra = scanner.next().charAt(0); Asi lo tenía pero hay un caso donde el usuario utilice MAYUSCULAS y la palabra no tiene 
            char letra = Character.toLowerCase(scanner.next().charAt(0));//Aqui ya está convertida las palabra a minusculas

            boolean letraCorrecta = false;

            //Estructura de Control: Iterativa,
            for (int i = 0; i < palabraSecreta.length(); i++) { 
                //Estrutura de control condicional 
                if (palabraSecreta.charAt(i) == letra) {
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
            }

            if (!letraCorrecta) {
                intentos++;
                System.out.println("Letra incorrecta. Te quedan " + (intentosMaximos - intentos) + " intentos." );
            }
                                                //Equals sirve para comparar
            if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                palabraAdivinada = true;
                System.out.println("Felicidades has adivinado la palabra: " + palabraSecreta);
            }
        }

        if (!palabraAdivinada) {
            System.out.println("Que pena te has quedado sin intentos. GAME OVER");
        }

        scanner.close();
    }
}
