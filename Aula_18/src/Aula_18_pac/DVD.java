package Aula_18_pac;

public class DVD {
    private String titulo;
    private int tempoReproduc;
    private String diretor;
    private boolean possuo;
    private String comentario;
    
    public DVD(String theTitle,int time,String theDirector){
        titulo = theTitle;
        tempoReproduc = time;
        diretor = theDirector;
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

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
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
