package provaCD2;

public class MainCDcollection {
    public static void main(String[] args) {
        
        //primeiro elemento
        
        CD cd0 = new CD("Titulo","Artista",12/*trilhas*/);
        CDcollection cds = new CDcollection();
        cds.insereCD(cd0);
        if(cds.verificaCD("Titulo")) System.out.println("CD EXISTENTE!");
        else System.out.println("CD NAO EXISTENTE!");
        cds.removeCD("Titulo");
        if(cds.verificaCD("Titulo")) System.out.println("CD EXISTENTE!");
        else System.out.println("CD NAO EXISTENTE!");
        
        //segundo elemento
        
        CD cd1 = new CD("Titulo2","Artista2",21/*trilhas*/);
        cds.insereCD(cd1);
        if(cds.verificaCD("Titulo2")) System.out.println("CD EXISTENTE!");
        else System.out.println("CD NAO EXISTENTE!");
        cds.removeCD("Titulo2");
        if(cds.verificaCD("Titulo2")) System.out.println("CD EXISTENTE!");
        else System.out.println("CD NAO EXISTENTE!");
    
    }
}