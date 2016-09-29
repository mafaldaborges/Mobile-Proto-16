package mafalda.lesson3hw;

/**
 * Created by mafaldaborges on 9/16/16.
 */
public class ToDoItem {
    /**Creates class of to do items which take in a string and an int
     * The id reflects the position of the item within a list*/
    public String name;
    public int complete;
    private long id;

    public ToDoItem(String name, int complete){
        this.name = name;
        this.complete = complete;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }
}
