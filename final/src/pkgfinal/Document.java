package pkgfinal;

import java.util.ArrayList;

public class Document<Document extends Comparable<Document>> {
    
    /*  I ran into some issues with this class not being able to see the
    the other two classes.  This class does create the 2 docList ArrayLists.
    Most of the functions were done in the Word class.
    
    Still learning...   
    
    */
    
    public ArrayList<Document> docList = new ArrayList<>();
    public ArrayList<Document> docList2 = new ArrayList<>();
    private int id;
    private String docs;    
    
    public Document(ArrayList<Document> docList) {
        this.docs = null;
        this.id = 0;
        this.docList = docList;
    }

    Document() {
        this.docs = null;
        this.id = 0;
        
    }

    public void addDoc(Document docs){
        docList.add(id, docs);
        id++;
    }
    
    public int getSize(){
        return docList.size();
    }
    
    public void docListPrint(){
        for (int i = 0; i < docList.size(); i++){
            System.out.println("DocList element " +(i+1) +": "+ docList.get(i));
        }
    }
}
