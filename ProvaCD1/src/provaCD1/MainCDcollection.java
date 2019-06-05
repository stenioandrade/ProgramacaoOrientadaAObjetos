package provaCD1;
import java.util.Scanner;

public class MainCDcollection {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String titulo = reader.nextLine();
        String artista = reader.nextLine();
        int trilhas = reader.nextInt();
        CD cd1 = new CD(titulo,artista,trilhas);
        CDcollection cds = new CDcollection();
        String str = reader.nextLine();
        if(cds.verificaCD(str)) System.out.println("CD EXISTENTE!");
        else System.out.println("CD NAO EXISTENTE!");
        cds.insereCD(cd1);
        if(cds.verificaCD(str)) System.out.println("CD EXISTENTE!");
        else System.out.println("CD NAO EXISTENTE!");
        cds.removeCD(reader.nextLine());
        if(cds.verificaCD(str)) System.out.println("CD EXISTENTE!");
        else System.out.println("CD NAO EXISTENTE!");
        
        String titulo2 = reader.nextLine();
        String artista2 = reader.nextLine();
        int trilhas2 = reader.nextInt();
        CD cd2 = new CD(titulo2,artista2,trilhas2);
        if(cds.verificaCD(reader.nextLine())) System.out.println("CD EXISTENTE!");
        else System.out.println("CD NAO EXISTENTE!");
        cds.insereCD(cd2);
        if(cds.verificaCD(reader.nextLine())) System.out.println("CD EXISTENTE!");
        else System.out.println("CD NAO EXISTENTE!");
        cds.removeCD(reader.nextLine());
        if(cds.verificaCD(reader.nextLine())) System.out.println("CD EXISTENTE!");
        else System.out.println("CD NAO EXISTENTE!");
    }
    
}