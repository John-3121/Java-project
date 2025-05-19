import java.util.*;
import java.io.*;
import java.io.FileReader;
public class Main {
   private ArrayList<String> notes = new ArrayList<String>();
    private ArrayList<String> titles = new ArrayList<String>();
   // private ArrayList<String> printn = new ArrayList<String>();
    
    public static void main(String[] args) {
        Main m = new Main();
        m.loadNotes();
        m.loadTitles();
     //   m.printing();
        
          System.out.println("Welcome to my simple note_system");
          m.run();
        }
        
    
 public  void EnterNote(int exit){
     Scanner usernote = new Scanner(System.in);
     System.out.println("Enter title");
     String title = usernote.nextLine();
     System.out.println("Enter your Note");
     String note = usernote.nextLine();
     String combined = "Title:"+ title +"_"+ "note:"+ note;
     notes.add(combined);
     titles.add(title);
  //   printn.add(combined);
     saveNotes();
     saveTitles();
    // printing();
     run();
    
        
    
}
  /*  public void printing(){
        
        for(int i= 0; i<notes.size(); i++){//we are gonna add the values of notes to printn
         printn.add(notes.get(i));      //this printn is just notes list theyre just the same 
                                        //we use printn(printnotes) cause where gonna get into alot of errors
                                        //if we use notes arrayList 
        
     }
    }*/
    
    public void run(){
        
        System.out.println("1.Enter a note\n2.View notes\n3.Remove note");
        Scanner input = new Scanner(System.in);
        Main main = new Main();
        try{
       int exit = input.nextInt();
            System.out.println("----------------");
        if(exit == 1){
            EnterNote(exit);
            
        }else if(exit == 2){
            viewNote();
            run();
            
        }else if(exit == 3){
            removeNote();
            run();
        }
        else{
            System.out.println("Invalid input");
            run();
        }
        }catch(InputMismatchException e){
            System.out.println("Invalid input:" + e);
            run();
        }
        
        
    }
    
    public void viewNote(){
        for(int i = 0; i<notes.size(); i++){
          //  printn.add(notes.get(i));
            String rep = notes.get(i).replace("_","\n");
            System.out.println(rep);
           System.out.println("--------");
          //  String[] a=  printn.get(i).split(" ");
         //   for(String b: a){
        //        System.out.println(b);
          //  }
            
        }
    }
    
    
    public void loadNotes(){
        try{
            String text = "";
            BufferedReader br = new BufferedReader(new FileReader("note.txt"));
            String line;
            while((line = br.readLine()) != null){
                notes.add(line);
                
            }
            br.close();
            
        }catch(IOException e){
            e.printStackTrace();
        }
        
        
    }
    public void saveNotes(){
        try{
           BufferedWriter bw = new BufferedWriter(new FileWriter("note.txt"));
            for(String n:notes) {
                bw.write(n);
                bw.newLine();
                
                
            } 
            bw.close();
            
        }catch(IOException e){
            e.printStackTrace();
        }
        
        
    }
    public void loadTitles(){
        try{
        BufferedReader note_title = new BufferedReader(new FileReader("title.txt"));
            String title;
            while((title = note_title.readLine()) != null){
                titles.add(title);
            }
            note_title.close();
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void saveTitles(){
        try{
           BufferedWriter bw = new BufferedWriter(new FileWriter("title.txt"));
            for(String t:titles) {
                bw.write(t);
                bw.newLine();
                
                
            } 
            bw.close();
            
        }catch(IOException e){
            e.printStackTrace();
        }
        
        
    }/*
    public void removeNote(){
        Scanner sr =  new Scanner(System.in);
        System.out.println("Enter the title you want to remove");
        String remove = sr.nextLine();
        for(String t:titles){
            if(remove.equalsIgnoreCase(t)){
                notes.remove(t);
                titles.remove(t);
                saveNotes();
                saveTitles();
            }
        }
    }
    */
    public void removeNote() {//removeNote method is help by Ai 
        //and the one ul there is my method 
    Scanner sr = new Scanner(System.in);
    System.out.println("Enter the title you want to remove:");
    String remove = sr.nextLine();

    boolean found = false;

    for (int i = 0; i < notes.size(); i++) {
        String note = notes.get(i);
        if (note.startsWith("Title:" + remove)) {
            notes.remove(i);

            // only remove from titles if index is valid
            if (i < titles.size()) {
                titles.remove(i);
           }

            found = true;
            break;
        }
    }

    if (found) {
        saveNotes();
        saveTitles();
        System.out.println("Note removed successfully.");
    } else {
        System.out.println("No note found with that title.");
    }
}
    
    
}
//after exit where gonna store the notes to array