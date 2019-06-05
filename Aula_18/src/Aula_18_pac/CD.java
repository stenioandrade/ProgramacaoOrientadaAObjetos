package Aula_18_pac;

public class CD {
    private String titulo;
    private int tempoReproduc;
    private String artista;
    private int numeroTrilhas;
    private boolean possuo;
    private String comentario;
    
    public CD(String theTitle,int time,String theArtist,int trilhas){
        titulo = theTitle;
        tempoReproduc = time;
        artista = theArtist;
        numeroTrilhas = trilhas;
        possuo = false;
        comentario = "";
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTempoReproduc() {
        return tempoReproduc;
    }

    public void setTempoReproduc(int tempoReproduc) {
        this.tempoReproduc = tempoReproduc;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getNumeroTrilhas() {
        return numeroTrilhas;
    }

    public void setNumeroTrilhas(int numeroTrilhas) {
        this.numeroTrilhas = numeroTrilhas;
    }

    public boolean isPossuo() {
        return possuo;
    }

    public void setPossuo(boolean possuo) {
        this.possuo = possuo;
    }

    public String getComentario() {
        return comentario;
    }
    
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
}
