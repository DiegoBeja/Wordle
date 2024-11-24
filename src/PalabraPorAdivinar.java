import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PalabraPorAdivinar implements Palabra{
    private static String palabraAdivinar;

    public PalabraPorAdivinar(){
        escogerPalabraAdivinar();
    }

    public String escogerPalabraAdivinar(){
        try {
            int c = 0;
            BufferedReader leer = new BufferedReader(new FileReader("C:\\Users\\bombo\\IdeaProjects\\Wordle\\src\\palabras_5_letras.txt"));
            Random rd = new Random();
            String linea;
            List<String> palabras = new ArrayList<>();

            while((linea = leer.readLine()) != null){
                palabras.add(linea.trim());
                c++;
            }

            leer.close();

            if(palabras.size() > 0){
                palabraAdivinar = palabras.get(rd.nextInt(palabras.size()));
                return palabraAdivinar;
            } else{
                System.out.println("Error al escoger la palabra a adivinar");
            }

        } catch(FileNotFoundException ex){
            System.out.println("El archivo no fue encontrado");
        } catch(IOException ex){
            System.out.println("No se pudo leer el archivo");
        }
        return null;
    }

    public String[] splitPalabra(String palabra){
        String [] palabraSplit = new String[4];
        palabraSplit = palabraAdivinar.split("");

        return palabraSplit;
    }

    public String getPalabraAdivinar(){
        return palabraAdivinar;
    }
}
