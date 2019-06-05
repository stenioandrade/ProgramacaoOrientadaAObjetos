public class MainExc {
    public static void main(String[] args){
        Cadastro person = new Cadastro();
            person.addPessoa("Stenio", "Andrade", 0, "1996");
            person.addPessoa("Maria","Silva", 1, "1992");
            person.addPessoa("Edilena", "Luiza", 1, "1962");
            try{   
                person.numeroPessoas();
                person.removePessoa(0);
                person.numeroPessoas();
                person.removePessoa(0);
                person.numeroPessoas();
                person.removePessoa(1);
                person.numeroPessoas();
            }
            catch(Exception e){
                System.out.println("Nao removeu\n"+e.getMessage());
            }
    }
    
}
