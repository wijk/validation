package Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame {
    Frame(){
        JFrame frame=new JFrame("Validation Checker");
        JButton b=new JButton("Submit");
        b.setBounds(100,100,140, 40);
        JLabel label = new JLabel();
        label.setText("Text to validate :");
        label.setBounds(10, 10, 100, 100);
        JLabel label1 = new JLabel();
        label1.setBounds(10, 110, 200, 100);
        JTextField textfield= new JTextField();
        textfield.setBounds(110, 50, 130, 30);
        frame.add(label1);
        frame.add(textfield);
        frame.add(label);
        frame.add(b);
        frame.setSize(600,600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                label1.setText("Name has been submitted.");
            }
        });
    }

    private void initFrame(){

    }


    public static void main(String[] args) {
        new Frame();
    }
}
