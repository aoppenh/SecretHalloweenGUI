/**
 * Created by Andrew Oppenheimer on 10/09/2019.
 */
public class Candy {
    private String name;
    private boolean assigned;
    private boolean person;

    public Candy(String name, boolean assigned, boolean person) {
        this.name = name;
        this.assigned = assigned;
        this.person = person;
    }

    public String getName() {
        return name;
    }
    public boolean getAssigned() {
        return assigned;
    }
    public boolean getPerson() {
        return person;
    }

    public void set(String name, boolean assigned, boolean person) {
        this.name = name;
        this.assigned = assigned;
        this.person = person;
    }
}
