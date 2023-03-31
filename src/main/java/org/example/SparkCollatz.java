package org.example;

import java.util.ArrayList;

import static spark.Spark.*;

public class SparkCollatz {

    public static void main(String... args){
        port(getPort());

        staticFiles.location("/public");

        get("/prueba", (req,res) -> "Hello Docker!");

        get("/collatz", (req, res ) -> {
            String nvalue = req.queryParams("value");
            System.out.printf("Param Query " + nvalue);
            return getResponse(Integer.parseInt(nvalue));
        });
    }

    /**
     * metodo para retornar el puerto
     * @return Puerto
     */
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 42000;
    }

    /**
     * Metodo que genera la respuesta que se mostrara en el browser
     * @param n int digitado por el usuario
     * @return String response
     */
    private static String getResponse(int n) {
        return "{ \"operation\" : \"collatzsequence\", \n" +
                " \"input\" : " + n + ", \n" +
                " \"output\" : \"" + convertSequencetoString(n) + "\" \n" +
                "}";
    }

    /**
     * metodo que transforma una lista de numeros en la cadena requerida
     * @param n int digitado por el usuario
     * @return String de la secuencia
     */
    private static String convertSequencetoString(int n) {
        String response = "";
        int size = operationConjeturaCollatz(n).size();
        for (int i=0; i<size; i++) {

            if (i != size - 1) {
                response += operationConjeturaCollatz(n).get(i) + " -> ";
            } else {
                response += operationConjeturaCollatz(n).get(i) + "";
            }
        }
        return response;
    }

    /**
     * Metodo que realiza la operación de la conjetura de collatz
     * @param n int digitado por el usuario
     * @return Lista con los enteros
     */
    private static ArrayList<Integer> operationConjeturaCollatz(int n) {
        ArrayList<Integer> seq = new ArrayList<>();
        seq.add(n);
        while (n > 1) {
            if (n%2 == 0) {
                n = n /2;
            }
            else {
                n = n*3 + 1;
            }
            seq.add(n);
        }
        return seq;
    }

}
