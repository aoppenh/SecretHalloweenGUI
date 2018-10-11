import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by Andrew Oppenheimer on 12/25/2016.
 * Version 10/11/2018
 */
public class Model {
    static Hashtable<Candy, Person> peopleAndAssignments;
    static ArrayList<Person> people = new ArrayList<>();
    static ArrayList<Candy> candy = new ArrayList<>();
    static int counter = 0;
    static int counterAdded;
    static boolean falseImportCheck = false;
    static int counterAssign;
    static int i;
    static Random r = new Random();
    static String fileName;
    static String importFileName;
    static String listP;
    static String listC;
    static File f;
    static File newFile;
    static File desktop = new File(System.getProperty("user.home") + "\\Desktop");
    static PrintWriter writer;
    static StringBuilder saveBuilder;
    static String tempDisplayString = "";
    static String tempCandyString = "";
    static String saveString;
    static boolean timeCheck = false;

    public static void setPeopleAndAssignments() {
        timeCheck = false;
        peopleAndAssignments = new Hashtable<>();
        counterAssign = 0;
        i = 0;
        long newTime;
        long startTime = System.currentTimeMillis();
        while (counterAssign < people.size()) {
            int ran = r.nextInt(candy.size());
            newTime = System.currentTimeMillis() - startTime;
            if (newTime > 1250) {
                for (Person p : people) {
                    p.set(p.getName(), false, false);
                }
                for (Candy c : candy) {
                    c.set(c.getName(), false, false);
                }
                i = 0;
                counterAssign = 0;
                peopleAndAssignments = new Hashtable<>();
                timeCheck = false;
                break;
            }
            if (!(candy.get(ran).equals(people.get(i))) && !candy.get(ran).getAssigned() && !people.get(i).getCandy()) {
                peopleAndAssignments.put(candy.get(ran), people.get(i));
                candy.get(ran).set(candy.get(ran).getName(), true, candy.get(ran).getPerson());
                people.get(i).set(people.get(i).getName(), people.get(i).getAssigned(), true);
                counterAssign++;
                i++;
            }
//            if (newTime > 5000) {
//                timeCheck = true;
//                i = 0;
//                counterAssign = 0;
//                peopleAndAssignments = new Hashtable<>();
//                break;
//            }
        }
    }

    public static void save() throws FileNotFoundException {
        saveString = saveBuilder.toString();
        writer = new PrintWriter(newFile);
        writer.println(saveString);
        writer.close();
    }
}
