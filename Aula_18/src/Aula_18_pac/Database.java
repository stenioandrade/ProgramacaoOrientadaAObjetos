package Aula_18_pac;
import java.io.PrintStream;
import java.util.ArrayList;

public class Database {
    private ArrayList<CD> cds;
    private ArrayList<DVD> dvds;
    //private ArrayList<Item> its;
    
    public Database(){
        cds = new ArrayList<CD>();
        dvds = new ArrayList<DVD>();
        //its = new ArrayList<Item>();
    }
    public void addCd(CD cd){
        getCds().add(cd);
    }
    public void addDVD(DVD dvd){
        getDvds().add(dvd);
    }
    //public void addItem(Item it){
    //}

    public ArrayList<CD> getCds() {
        return cds;
    }

    public void setCds(ArrayList<CD> cds) {
        this.cds = cds;
    }

    public ArrayList<DVD> getDvds() {
        return dvds;
    }

    public void setDvds(ArrayList<DVD> dvds) {
        this.dvds = dvds;
    }
    public int numOfcds(){
        return cds.size();
    }
    public boolean verificaCD(String titulo){
        int i = 0;
        boolean cont = true;
        if (numOfcds()==0) return false;
        while(cont && i != numOfcds()){
            if(cds.get(i).getTitulo().equals(titulo)){
                cont = false;
                return true;
            }
            i++;
        }
        return false;
    }
    public void removeCD(String titulo){
        if (numOfcds()==0) return;
       // if (position < 0) return;
       if(verificaCD(titulo)){
           int i;
            for(i=0;i<numOfcds();i++){
                if(cds.get(i).getTitulo().equals(titulo)){
                    cds.remove(i);
                }
            }
       }
    }
    public void imprimeCD(String titulo){
        if (verificaCD(titulo)){
            int i;
            for(i=0;i<numOfcds();i++){
                if(cds.get(i).getTitulo().equals(titulo)){
                    System.out.printf("%s\n",cds.get(i).getTitulo());
                    System.out.printf("%s\n",cds.get(i).getComentario());
                }
            }
        }
    }
    public void listaCD(){
        int i;
        for (i=0;i<numOfcds();i++){
            System.out.printf("%s\n",cds.get(i).getTitulo());
        }
    }
    public void listaDVD(){
        int i;
        for (i=0;i<numOfcds();i++){
            System.out.printf("%s\n",dvds.get(i).getTitulo());
        }
    }
    public CD buscaItem(String titulo){
        int i = 0;
        boolean cont = true;
        if (numOfcds() == 0){
            System.out.printf("CD nao existente!\n");
            return null;
        }
        while(cont && i != numOfcds()){
            if(cds.get(i).getTitulo().equals(titulo)){
                cont = false;
                return cds.get(i);
            }
            i++;
        }
        System.out.printf("CD nao existente!\n");
    return null;
    }
}
