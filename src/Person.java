/**
 * Created by Andrew Oppenheimer on 12/25/2016.
 */
public class Person {
    private String name;
    private boolean assigned;
    private boolean candy;

    public Person(String name, boolean assigned, boolean santa) {
        this.name = name;
        this.assigned = assigned;
        this.candy = santa;
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

    public void set(String name, boolean assigned, boolean santa) {
        this.name = name;
        this.assigned = assigned;
        this.candy = santa;
    }
}
