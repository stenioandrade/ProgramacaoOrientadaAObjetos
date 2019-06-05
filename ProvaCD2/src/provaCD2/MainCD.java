package provaCD2;
import java.util.Scanner;

public class MainCD {
    public static void main(String[] args) {
        
        //primeiro elemento
        
        Scanner reader = new Scanner(System.in);
        String titulo = reader.nextLine();
        String artista = reader.nextLine();
        int trilhas = reader.nextInt();
        CD cd = new CD(titulo,artista,trilhas);
        cd.imprime();
        
        //modificando primeiro elemento
        
        Scanner read = new Scanner(System.in);
        String titulo2 = read.nextLine();
        cd.setTitulo(titulo2);
        String artista2 = read.nextLine();
        cd.setArtista(artista2);
        int trilhas2 = read.nextInt();
        cd.setTrilhas(trilhas2);
        cd.setFlag(true);
        cd.imprime();
    }
    
}