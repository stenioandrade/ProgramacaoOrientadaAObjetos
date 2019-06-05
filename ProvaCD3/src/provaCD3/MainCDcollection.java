package provaCD3;

public class MainCDcollection {
    public static void main(String[] args) {
        CD cd0 = new CD("Titulo","Artista",12/*trilhas*/);
        CDcollection cds = new CDcollection();
        cds.insereCD(cd0);
        System.out.printf("%b\n",cds.verificaCD("Titulo"));
        cds.removeCD(0);
        System.out.printf("%b\n",cds.verificaCD("Titulo"));
        
        
        CD cd1 = new CD("Titulo2","Artista2",21/*trilhas*/);
        cds.insereCD(cd1);
        System.out.printf("%b\n",cds.verificaCD("Titulo2"));
        cds.removeCD(0);
        System.out.printf("%b\n",cds.verificaCD("Titulo2"));
        
    }
    
}
