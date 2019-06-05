public class MainC {
    public static void main(String[] args){
    
        Cadastro person = new Cadastro();

        Estudante aluno = new Estudante("Jose","Silva",0,"2000",999999,"fundamental");

            person.addPessoa(aluno);
            Estudante aluno1;
            Pessoa p = person.buscaPessoa("Jose");
            if(p instanceof Estudante){
                aluno1 = new Estudante();
                aluno1 = (Estudante) p;
                System.out.println(aluno1.getGrau());
            }
            else {
                System.out.println("Nao estudante!");
            }
            person.removePessoa(0);

    }
}