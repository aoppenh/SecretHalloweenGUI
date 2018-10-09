/**
 * Created by Andrew Oppenheimer on 12/25/2016.
 * Version 10/09/2018
 */
public class Person {
    private String name;
    private boolean assigned;
    private boolean candy;

    public Person(String name, boolean assigned, boolean candy) {
        this.name = name;
        this.assigned = assigned;
        this.candy = candy;
    }

    public String getName() {
        return name;
    }
    public boolean getAssigned() {
        return assigned;
    }
    public boolean getCandy() {
        return candy;
    }

    public void set(String name, boolean assigned, boolean candy) {
        this.name = name;
        this.assigned = assigned;
        this.candy = candy;
    }
}
