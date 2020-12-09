package com.company;
import javax.swing.*;
import java.io.*;


public class Log {

    protected static File log = new File("Log.txt"); //Creating a test file
    protected static FileWriter fw; //Creating a file writer variable
    //*Catching the exception*
    static {
        try {
            fw = new FileWriter(log);
        } catch (IOException e) {
            System.out.println("error");
        }
    }
    protected static PrintWriter pw = new  PrintWriter(fw); //Creating a print writer variable

    //*Displaying the log of the Follow Light mode*
    protected static void showFollow(){

        JOptionPane.showMessageDialog(null, "Mode selected: Follow Light"+
                        "Date of the executuion:  "+ UserInterface.Date()+
                        "\nTime of the execution: "+ FollowLight.timerEnd+" seconds."+
                        "\nNumber of times light was encountered: "+FollowLight.lightCounter+
                        "\nStarting value of the light detected in the Right sensor: "+FollowLight.startRightLightValue+
                        "\nStarting value of the light detected in the Right sensor: "+FollowLight.startLeftLightValue+
                        "\nHighest value of the light detected in the Right sensor: "+FollowLight.highRightLightValue+
                        "\nHighest value of the light detected in the Left sensor: "+FollowLight.highLeftLightValue+
                        "\nLowest value of the light detected in the Right sensor: "+FollowLight.lowRightLightValue+
                        "\nLowest value of the light detected in the Left sensor: "+FollowLight.lowLeftLightValue+
                        "\nAverage light sensor value recorded: "+ followCalculateAverageLight(),
                   "Log",JOptionPane.INFORMATION_MESSAGE);

    }

    //*Displaying the log of the Avoid Light mode*
    protected static void showAvoid(){

        JOptionPane.showMessageDialog(null,"Mode selected: Avoid Light"+
                        "Date of the executuion: "+ UserInterface.Date()+
                        "\nTime of the execution: "+ AvoidLight.timerEnd+" seconds."+
                        "\nNumber of times light was encountered: "+AvoidLight.lightCounter+
                        "\nStarting value of the light detected in the Right sensor: "+AvoidLight.startRightLightValue+
                        "\nStarting value of the light detected in the Right sensor: "+AvoidLight.startLeftLightValue+
                        "\nHighest value of the light detected in the Right sensor: "+AvoidLight.highRightLightValue+
                        "\nHighest value of the light detected in the Left sensor: "+AvoidLight.highLeftLightValue+
                        "\nLowest value of the light detected in the Right sensor: "+AvoidLight.lowRightLightValue+
                        "\nLowest value of the light detected in the Left sensor: "+AvoidLight.lowLeftLightValue+
                        "\nAverage light sensor value recorded: "+ avoidCalculateAverageLight(),
                "Log",JOptionPane.INFORMATION_MESSAGE);

    }

    //*Asking the user if they would like to save the log in a text file*
    protected static void saveAvoidLog(){

        int result =JOptionPane.showConfirmDialog(null,"Do you want to save the log in a text file?", "Save",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION) {
            writeLogAvoid();
        }

    }

    //*Asking the user if they would like to save the log in a text file*
    protected static void saveFollowLog(){

        int result =JOptionPane.showConfirmDialog(null,"Do you want to save the log in a text file?", "Save",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION) {
            writeLogFollow();
        }
        else{
            log.delete();
        }

    }

    //*Writing the log in a text file of the Follow Light mode*
    protected static void writeLogFollow(){
        pw.println("Mode selected: Follow Light");
        pw.println("Date of the executuion: "+ UserInterface.Date());
        pw.println("Time of the execution: "+ FollowLight.timerEnd+" seconds.");
        pw.println("Number of times light was encountered: "+FollowLight.lightCounter);
        pw.println("Starting value of the light detected in the Right sensor: "+FollowLight.startRightLightValue);
        pw.println("Starting value of the light detected in the Right sensor: "+FollowLight.startLeftLightValue);
        pw.println("Highest value of the light detected in the Right sensor: "+FollowLight.highRightLightValue);
        pw.println("Highest value of the light detected in the Left sensor: "+FollowLight.highLeftLightValue);
        pw.println("Lowest value of the light detected in the Right sensor: "+FollowLight.lowRightLightValue);
        pw.println("Lowest value of the light detected in the Left sensor: "+FollowLight.lowLeftLightValue);
        pw.println("Average light sensor value recorded: "+ followCalculateAverageLight());
        pw.close();

    }

    //*Writing the log in a text file of the Avoid Light mode*
    protected static void writeLogAvoid(){
        pw.println("Mode selected: Avoid Light");
        pw.println("Date of the executuion: "+ UserInterface.Date());
        pw.println("Time of the execution: "+ AvoidLight.timerEnd+" seconds.");
        pw.println("Number of times light was encountered: "+AvoidLight.lightCounter);
        pw.println("Starting value of the light detected in the Right sensor: "+AvoidLight.startRightLightValue);
        pw.println("Starting value of the light detected in the Right sensor: "+AvoidLight.startLeftLightValue);
        pw.println("Highest value of the light detected in the Right sensor: "+AvoidLight.highRightLightValue);
        pw.println("Highest value of the light detected in the Left sensor: "+AvoidLight.highLeftLightValue);
        pw.println("Lowest value of the light detected in the Right sensor: "+AvoidLight.lowRightLightValue);
        pw.println("Lowest value of the light detected in the Left sensor: "+AvoidLight.lowLeftLightValue);
        pw.println("Average light sensor value recorded: "+ avoidCalculateAverageLight());
        pw.close();

    }

    //*Calculate the average of all the values of the light source*
    protected static float followCalculateAverageLight(){
        for(int i = 0; i < FollowLight.lightSensorValuesFinal.size(); i++)
        {
            FollowLight.sum += FollowLight.lightSensorValuesFinal.get(i);
            FollowLight.avg = FollowLight.sum / FollowLight.lightSensorValuesFinal.size();

        }
        return FollowLight.avg;
    }

    //*Calculate the average of all the values of the light source*
    protected static double avoidCalculateAverageLight(){
        for(int i = 0; i < AvoidLight.lightSensorValuesFinal.size(); i++)
        {
            AvoidLight.sum += AvoidLight.lightSensorValuesFinal.get(i);
            AvoidLight.avg = AvoidLight.sum / AvoidLight.lightSensorValuesFinal.size();

        }
        return AvoidLight.avg;
    }

}


