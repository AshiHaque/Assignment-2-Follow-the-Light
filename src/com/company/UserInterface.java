package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import javax.swing.JFrame;


public class UserInterface {

    protected static void home(){
        JFrame f=new JFrame("Search for Light");//Declaring the frame for the GUI
        JRadioButton choiceFollowLight=new JRadioButton("Follow Light");//Declaring radio button for mode
        JRadioButton choiceAvoidLight=new JRadioButton("Avoid Light");//Declaring radio button for mode
        ButtonGroup bg=new ButtonGroup();//Declaring a button group for the radio button
        JButton buttonStart=new JButton("Start");//Declaring the start button
        JLabel mode = new JLabel("Select Mode:");//Declaring label
        JLabel infoFollowLight = new JLabel("The finch will follow the light source.");//Declaring label
        JLabel infoAvoidLight = new JLabel("The finch will avoid the light source.");//Declaring label
        JLabel date =new JLabel(String.valueOf(Date()));//Declaring label for date

        //*Setting the bounds for every components*
        f.setSize(250,300);
        mode.setBounds(90,25,300,30);
        infoFollowLight.setBounds(5,220,300,30);
        infoAvoidLight.setBounds(5,220,300,30);
        date.setBounds(5,-140,300,300);
        choiceFollowLight.setBounds(70,50,300,30);
        choiceAvoidLight.setBounds(70,100,300,30);
        buttonStart.setBounds(75,150,100,30);

        //*Adding components in the frame*
        f.add(date);
        f.add(mode);
        bg.add(choiceFollowLight);
        bg.add(choiceAvoidLight);
        f.add(buttonStart);
        f.add(infoFollowLight);
        infoFollowLight.setVisible(false);
        f.add(infoAvoidLight);
        infoAvoidLight.setVisible(false);
        f.add( choiceFollowLight);
        f.add(choiceAvoidLight);

        //Setting the icon of the main interface
        Image icon = Toolkit.getDefaultToolkit().getImage("Finch.png");
        f.setIconImage(icon);

        f.setLayout(null);
        f.setVisible(true);

        //Action listener
        choiceFollowLight.addItemListener(new ItemListener() { //When the radiobutton "Follow Light" is selected the information label will appear
            public void itemStateChanged(ItemEvent e) {
                infoAvoidLight.setVisible(false); //Info label for avoid light is going to be invisible
                infoFollowLight.setVisible(true); //Info label for follow light is going to be visible
                buttonStart.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING)); //The main interface will close
                        FollowLight.searchForLightF(); //The execution of the mode will start
                    }
                });
            }
        });

        //Action listener
        choiceAvoidLight.addItemListener(new ItemListener() { //When the radiobutton "Avoid Light" is selected the information label will appear
            public void itemStateChanged(ItemEvent e) {
                infoFollowLight.setVisible(false); //Info label for follow light is going to be invisible
                infoAvoidLight.setVisible(true); //Info label for avoid light is going to be visible
                buttonStart.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING)); //The main interface will close
                        AvoidLight.searchForLightA(); //The execution of the mode will start
                    }
                });
            }
        });
    }

    //*The method is going to show a message box for a certain time*
    protected static void searchingForLightMessage(){
        JLabel label = new JLabel("The finch is searching for light.");
        int timerDelay = 1000;
        new Timer(timerDelay, new ActionListener() {
            int timeLeft = 1;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (timeLeft > 0) {

                    timeLeft--;
                } else {
                    ((Timer) e.getSource()).stop();
                    Window win = SwingUtilities.getWindowAncestor(label);
                    win.setVisible(false);
                }
            }
        }) {
            {
                setInitialDelay(0);
            }
        }.start();

        ImageIcon vampire = new ImageIcon("searching.png");
        JOptionPane.showMessageDialog(null,label,"Information",JOptionPane.INFORMATION_MESSAGE,vampire);
    }

    //*The method is going to show a message box for a certain time*
    protected static void encounterLightMessage(){
         JLabel label = new JLabel("The finch is following the light source!");
        int timerDelay = 1000;
        new Timer(timerDelay, new ActionListener() {
            int timeLeft = 1;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (timeLeft > 0) {

                    timeLeft--;
                } else {
                    ((Timer) e.getSource()).stop();
                    Window win = SwingUtilities.getWindowAncestor(label);
                    win.setVisible(false);
                }
            }
        }) {
            {
                setInitialDelay(0);
            }
        }.start();

        ImageIcon vampire = new ImageIcon("light.png");
        JOptionPane.showMessageDialog(null,label,"Information",JOptionPane.INFORMATION_MESSAGE,vampire);
    }

    //*The method is going to show a message box for a certain time*
   protected static void avoidLightMessage(){
         JLabel label = new JLabel("The finch is avoiding the  light source!");
        int timerDelay = 1000;
        new Timer(timerDelay, new ActionListener() {
            int timeLeft = 1;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (timeLeft > 0) {

                    timeLeft--;
                } else {
                    ((Timer) e.getSource()).stop();
                    Window win = SwingUtilities.getWindowAncestor(label);
                    win.setVisible(false);
                }
            }
        }) {
            {
                setInitialDelay(0);
            }
        }.start();

        ImageIcon vampire = new ImageIcon("vampire.png");
        JOptionPane.showMessageDialog(null,label,"Information",JOptionPane.INFORMATION_MESSAGE,vampire);
    }

    //*The method is going to show the current date*
    protected static LocalDate Date(){
        LocalDate date = LocalDate.now();
        return date;
    }

}

