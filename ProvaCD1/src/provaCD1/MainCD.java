package provaCD1;
import java.util.Scanner;

public class MainCD{

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String titulo = reader.nextLine();
        String artista = reader.nextLine();
        int trilhas = reader.nextInt();
        CD cd1 = new CD(titulo,artista,trilhas);
        cd1.imprime();
    }
    
}