package notebook.java;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Notebook {
    private ArrayList<String> notes;
    private Random rand; 
    
    public Notebook(){
        notes = new ArrayList<String>();
        rand = new Random();
    }
    public void storeNote(){
		try{
			BufferedReader br = new BufferedReader(new FileReader("notas.txt"));
			while(br.ready()){
				String linha = br.readLine();
				System.out.println(linha);
                                notes.add(linha);
			}
			br.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
    }
    public int numberOfNotes(){
        return notes.size();
    }
    public void showNote(int noteNumber){
        if(noteNumber < 0) {
            // Este não é um número de nota válido.
            System.out.println("Numero de nota invalido!");
        }
        else if(noteNumber < numberOfNotes()) {
            System.out.println(notes.get(noteNumber));
        }
        else {
            // Este não é um número de nota válido.
            System.out.println("Numero de nota invalido!");
        }
    }
    public void removeNote(int noteNumber){
        if(noteNumber < 0) {
            // Este não é um número de nota válido.
            System.out.println("Numero de nota invalido!");
        }
        else if(noteNumber < numberOfNotes()) {
               notes.remove(noteNumber);
        }
        else {
            // Este não é um número de nota válido.
            System.out.println("Numero de nota invalido!");
        }
    }
    public void hasNotes(){
        if(notes.isEmpty()) System.out.println("No notes!");
    }
    public void compareNote(String nota){
        if (notes.contains(nota)) System.out.println("Nota existente!");
        else System.out.println("Nota inexistente");
    }
    public void showNoteRandom(){
        showNote(rand.nextInt(notes.size()));
    }


}
