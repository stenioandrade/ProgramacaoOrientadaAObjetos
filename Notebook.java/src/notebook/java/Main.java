package notebook.java;
//import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
            //Scanner reader;
            Notebook n1 = new Notebook();
            //reader = new Scanner(System.in);
            System.out.println("Insira uma nota");
            n1.storeNote();
           // n1.storeNote(reader.nextLine());
            n1.hasNotes();
           // reader = new Scanner(System.in);
            System.out.println("Insira uma nota");
            //n1.storeNote(reader.nextLine());
            n1.hasNotes();
            //reader = new Scanner(System.in);
            System.out.println("Insira uma nota");
            //n1.storeNote(reader.nextLine());
            n1.hasNotes();
            n1.showNote(0);
            n1.showNote(1);
            n1.showNote(2);
            n1.showNote(3);
            n1.showNote(4);
            n1.showNote(5);
            n1.removeNote(0);
           // reader = new Scanner(System.in);
            System.out.println("compare uma nota");
            //reader = new Scanner(System.in);
           // n1.compareNote(reader.nextLine());
            System.out.print("Nota aleatoria: ");
            n1.showNoteRandom();
    }  
}