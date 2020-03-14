package com.daniel.palabras;

import java.util.ArrayList;

public class main {

    public static Integer sumaNumerosIsbn(char[] alfanumerico) {

        //Variable
        int sum = 0;
        //Inicializacion del array
        ArrayList<Character> resultado = new ArrayList<>();

        for (int i = 0; i < alfanumerico.length; i++) {
            /**
             * Codigo ASCII*/
            if (alfanumerico[i] >= 65 && alfanumerico[i] <= 90) alfanumerico[i] = '.';
            else if (alfanumerico[i] != '.') resultado.add(alfanumerico[i]);

        }

        sum = resultado.stream().mapToInt(str -> Character.getNumericValue(str.charValue())).sum();

        return sum;

    }


    public static void main(String[] args) {

        String isbn = "AFOGOGOFA";
        //Cambiar frase a minuscula para hacer la comparacion
        char[] cadena = isbn.toCharArray(), alfanumerico = isbn.toCharArray();

        //Variable para la suma de los valores de ISBN
        int sumaValoresIsbn = sumaNumerosIsbn(cadena), palabrasIguales = 0;

        System.out.println(sumaValoresIsbn);


        //Array de letras para logica de palindromas
        ArrayList<Character> letras = new ArrayList<>();
        boolean verificar = true;


        for (int i = 0; i < alfanumerico.length; i++) {
            if (alfanumerico[i] == alfanumerico[alfanumerico.length - (i + 1)])
                palabrasIguales++;
                if (i == (alfanumerico.length / 2)) break;
            else  if (alfanumerico[i] != alfanumerico[alfanumerico.length - (i + 1)]){
                    verificar = false;
                    break;
                }
        }
        System.out.println(verificar+" "+palabrasIguales);
    }
}
/*public class main {

    public static boolean verificarEspacios(String secundaria) {
        boolean verficar = false;
        for (int i = 0; i < secundaria.length(); i++) {
            if (secundaria.charAt(i) == ' ') {
                verficar = true;
            }
        }
        return verficar;
    }
    public static ArrayList<Character> sinEspacios(String cadena, ArrayList<Character> resultado) {

        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) >= 'a' && cadena.charAt(i) <= 'z')
                resultado.add(cadena.charAt(i));
        }
        return resultado;
    }

    public static void main(String[] args) {

         * Ali tomo tila
         * Reconcer
         * Alli ves Sevilla
        int sum = 0;
        String ISBN = "ISBN:Y2U3H4K78",
                palindrome = "Alli ves Sevilla",
                palindromeMinuscula = palindrome.toLowerCase();

        char[] numeros = ISBN.toCharArray(), palindroma = palindromeMinuscula.toCharArray();
        ArrayList<Character> resultado = new ArrayList<>();
        ArrayList<Character> letras = new ArrayList<>();

        System.out.println("Suma de numeros \n");

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] >= 'A' && numeros[i] <= 'Z' || numeros[i] == ':') numeros[i] = '.';
            else if (numeros[i] != '.') resultado.add(numeros[i]);

        }
        sum = resultado.stream().mapToInt(str -> Character.getNumericValue(str.charValue())).sum();

        System.out.println(numeros);
        System.out.println(resultado);
        System.out.println(sum + "\n");

        //Palindroma
        boolean verificar = false;
        System.out.println("Palindroma \n");
        System.out.println("Letra: " + palindromeMinuscula);

        sinEspacios(palindromeMinuscula,letras);
        System.out.println(letras);

        for (int i = 0; i < letras.size(); i++) {
            if (letras.get(i) == letras.get(letras.size() - (i + 1)))
                System.out.println(letras.get(i) + "=" + letras.get(letras.size() - (i + 1)));
                if (i == (letras.size() / 2)) {
                    verificar = true;
                    break;
                }

        }
        System.out.println(verificar);
    }
}*/
