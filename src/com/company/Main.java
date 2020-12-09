package com.company;
import javax.swing.*;


public class Main {

    //*The method is checking if the finch in on level*
   protected static void finchLevelCheck(){
        while(!FinchConfiguration.lightFinch.isFinchLevel()) {
            JOptionPane.showMessageDialog(null,
                    "Please place the finch on the floor.",
                    "ERROR",
                    JOptionPane.WARNING_MESSAGE);
        }
        UserInterface.home();
    }


    public static void main(String[] args) {
        finchLevelCheck();
    }

}
