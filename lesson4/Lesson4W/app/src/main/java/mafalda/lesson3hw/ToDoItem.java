package mafalda.lesson3hw;

/**
 * Created by mafaldaborges on 9/16/16.
 */
/*
Something you could consider doing here is to also keep track of whether the task is completed
 */
public class ToDoItem {
    /**Creates class of to do items which take in a string*/
    /*
     In general, favor creating a public String getName() function over making name public - that's generally
     the convention that's good to follow. These are called 'getters' and 'setters'
      */
    public String name;

    public ToDoItem(String name){
        this.name = name;
    }
}
