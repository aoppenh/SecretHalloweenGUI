import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by Andrew Oppenheimer on 12/25/2016.
 * Version 4/19/2018
 */
public class RandomizedGUI extends JFrame {
    private Container cPane;
    private JPanel formPanel;
    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel bottomPanel;
    private JLabel secretSantaLabel;
    private JTextArea santaAssignments;
    private JTextArea santaAssigned;
    private JButton reDoButton;
    private JButton exitButton;
    private JLabel imgLabel1;
    private JLabel imgLabel2;
    private JButton saveButton;
    private JScrollPane assignmentScroll;
    private JScrollPane assignedScroll;
    private StringBuilder randomList1;
    private StringBuilder randomList2;
    private StringBuilder listStringP;
    private StringBuilder listStringC;
    private String randomDisplayString1;
    private String randomDisplayString2;

    public RandomizedGUI(String title) throws IndexOutOfBoundsException {
        try {
            cPane = this.getContentPane();
            this.setTitle(title);
            this.setResizable(false);
            this.setSize(600, 600);
            this.setVisible(true);
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            cPane.add(formPanel);
            reDoButton.setPreferredSize(new Dimension(140, 70));
            exitButton.setPreferredSize(new Dimension(140, 70));
            saveButton.setPreferredSize(new Dimension(140, 70));
            imgLabel1.setIcon(new ImageIcon("src\\Jackolantern.png"));
            imgLabel2.setIcon(new ImageIcon("src\\Jackolantern.png"));
            randomList1 = new StringBuilder();
            randomList2 = new StringBuilder();
            randomDisplayString1 = "";
            randomDisplayString2 = "";
            for (Map.Entry<Candy, Person> p : Model.peopleAndAssignments.entrySet()) {
                String person = p.getKey().getName();
                String assignment = p.getValue().getName();
                randomList1.append(assignment);
                randomList1.append("\n");
                randomList2.append(person);
                randomList2.append("\n");
            }
            santaAssignments.setText(randomList1.toString());
            santaAssigned.setText(randomList2.toString());
            exitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            reDoButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    listStringP = new StringBuilder();
                    listStringC = new StringBuilder();
                    for (Person p : Model.people) {
                        listStringP.append(p.getName());
                        listStringP.append("\n");
                    }
                    for (Candy c : Model.candy) {
                        listStringC.append(c.getName());
                        listStringC.append("\n");
                    }
                    Model.listP = listStringP.toString();
                    Model.listC = listStringC.toString();
                    randomList1 = new StringBuilder();
                    randomList2 = new StringBuilder();
                    randomDisplayString1 = "";
                    randomDisplayString2 = "";
                    santaAssignments.setText("");
                    santaAssigned.setText("");
                    Model.people = new ArrayList<>();
                    Model.candy = new ArrayList<>();
                    dispose();
                    new AddPeopleGUI("Secret Halloween", Model.listP, Model.listC);
                }
            });
            saveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        new FileNameGUI("Secret Halloween");
                    } catch (Exception e1) {
                        e1.printStackTrace();
                        new ErrorGUI("Secret Halloween Error", "An Error Occurred");
                    }
                }
            });
        } catch(Exception e) {
            Model.peopleAndAssignments = new Hashtable<>();
            Model.counterAssign = 0;
            Model.i = 0;
            new AddPeopleGUI("Secret Halloween", Model.listP, Model.listC);
            new ErrorGUI("Secret Halloween", "Mismatched number of entries.");
        }
    }
}
