package provaCD3;

public class CD {
    private String titulo;
    private String artista;
    private int trilhas;
    private boolean flag;
    
    public CD(String titulo, String artista, int trilhas){
        this.titulo = titulo;
        this.artista = artista;
        this.trilhas = trilhas;
        flag = false;
    }
    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getArtista(){
        return artista;
    }
    public void setArtista(String artista){
        this.artista = artista;
    }
    public int getTrilhas(){
        return trilhas;
    }
    public void setTrilhas(int trilhas){
        this.trilhas = trilhas;
    }
    public boolean isFlag(){
        return flag;
    }
    public void setFlag(boolean flag){
        this.flag = flag;
    }
    public void imprime(){
        System.out.printf("%s\n",getTitulo());
        System.out.printf("%s\n",getArtista());
        System.out.printf("%d\n",getTrilhas());
        if(isFlag()) System.out.printf("cd possuido\n");
        else System.out.printf("cd nao possuido\n");
    }
}
