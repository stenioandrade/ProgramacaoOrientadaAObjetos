package provaCD3;

public class MainCD {
    public static void main(String[] args) {
        CD cd = new CD("Titulo","Artista",12/*trilhas*/);
        cd.imprime();
        cd.setTitulo("Titulo_Modificado");
        cd.setArtista("Artista_Modificado");
        cd.setTrilhas(21/*Numero_De_Trilhas_Modificado*/);
        cd.imprime();    }
    
}