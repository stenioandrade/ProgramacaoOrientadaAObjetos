package Aula_18_pac;

public class MainDatabase {

    public static void main(String[] args) {
        CD cd = new CD("californication",60,"RHCP",12);
        CD cd1 = new CD("turma da xuxa",50,"xuxa",10);
        cd.setComentario("Muito bom");
        Database db = new Database();
        db.addCd(cd);
        db.imprimeCD("californication");
        db.imprimeCD("xuxa");
        db.verificaCD("californication");
        db.removeCD("californication");
        db.imprimeCD("californication");
        db.listaCD();
    }
    
}
