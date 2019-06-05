public class MainCandidato {
    public static void main(String[] args) {
        Candidato x = new Candidato("Honesto");
        System.out.println("Nome: " + x.getNome());
        System.out.println("Votos: " + x.getVotos());
        x.addVoto();
        System.out.println("Votos: " + x.getVotos());
        x.setNome("Duvidoso");
        System.out.println("Nome: " + x.getNome());
        System.out.println("Votos: " + x.getVotos());
    }
}
