import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Andrew Oppenheimer on 12/25/2016.
 * Version 10/09/2018
 */
public class AddPeopleGUI extends JFrame {
    private JPanel formPanel;
    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel bottomPanel;
    private JTextArea addedPeople;
    private JScrollPane addScroll;
    private JButton addPersonButton;
    private JTextField addPersonBox;
    private JButton exitButton;
    private JButton randomizeButton;
    private JLabel imgLabel2;
    private JLabel imgLabel1;
    private JLabel imgLabel3;
    private JLabel imgLabel4;
    private JScrollPane candyScroll;
    private JTextArea addedCandy;
    private JTextField addCandyBox;
    private JButton addCandyButton;
    private Container cPane;
    private Color customColor = new Color(72,187,47);

    public AddPeopleGUI(String title, String list) {
        Model.counterAdded = 0;
        cPane = this.getContentPane();
        this.setTitle(title);
        this.setResizable(false);
        this.setSize(600, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        cPane.add(formPanel);
        addPersonBox.setText("Enter Name ...");
        addedPeople.setEnabled(true);
        addedCandy.setEnabled(true);
        addScroll.setPreferredSize(new Dimension(1326, 800));
        candyScroll.setPreferredSize(new Dimension(1326, 800));
        addedPeople.setText(list);
        addedPeople.setDisabledTextColor(customColor);
        exitButton.setPreferredSize(new Dimension(140, 70));
        randomizeButton.setPreferredSize(new Dimension(140, 70));
        addPersonButton.setPreferredSize(new Dimension(140, 70));
        addCandyButton.setPreferredSize(new Dimension(140, 70));
        imgLabel3.setIcon(new ImageIcon("src\\Jackolantern.png"));
        imgLabel4.setIcon(new ImageIcon("src\\Jackolantern.png"));
        addPersonBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPersonBox.setText("");
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        addPersonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Model.tempDisplayString = "";
                String[] temp = addedPeople.getText().split("\n");
                if (Model.counterAdded != temp.length) {
                    Model.counterAdded = temp.length;
                } else if (temp.length == 0) {
                    Model.counter = 0;
                }
                String strTemp = addedPeople.getText() + addPersonBox.getText() + "\n";
                String[] strLines = strTemp.split("\n");
                Model.counter = strLines.length;
//                if (Model.counter == 0 && Model.counterAdded == 0) {
//                    addedPeople.setText(addedPeople.getText() + addPersonBox.getText());
//                } else {
//                    addedPeople.setText(addedPeople.getText() + "\n" + addPersonBox.getText());
//                }
                addedPeople.setText(addedPeople.getText() + addPersonBox.getText() + "\n");
                Model.counter++;
                Model.counterAdded++;
                addPersonBox.setText("Enter Name ...");
            }
        });
        addCandyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Model.tempCandyString = "";
                String[] temp = addedCandy.getText().split("\n");
                if (Model.counterAdded != temp.length) {
                    Model.counterAdded = temp.length;
                } else if (temp.length == 0) {
                    Model.counter = 0;
                }
                String strTemp = addedCandy.getText() + addCandyBox.getText() + "\n";
                String[] strLines = strTemp.split("\n");
                Model.counter = strLines.length;
                addedCandy.setText(addedCandy.getText() + addCandyBox.getText() + "\n");
                Model.counter++;
                Model.counterAdded++;
                addCandyBox.setText("Enter Candy ...");
            }
        });
        randomizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] temp = addedPeople.getText().split("\n");
                for (String str : temp) {
                    Model.people.add(new Person(str, false, false));
                }
                Model.setPeopleAndAssignments();
                dispose();
                new RandomizedGUI("Secret Halloween");
            }
        });
    }

//    public static void main(String[] args) {
//        new AddPeopleGUI("Secret Santa");
//    }
}
