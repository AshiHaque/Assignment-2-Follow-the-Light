package com.company;
import java.awt.*;

public class AvoidLight extends FinchConfiguration {

    protected static void searchForLightA(){
         timer=System.currentTimeMillis(); //Setting the timer
         startRightLightValue= lightFinch.getRightLightSensor(); //Assigning the starting value of the light
         startLeftLightValue= lightFinch.getLeftLightSensor(); //Assigning the starting value of the light
         lightFinch.showLightSensorGraph(); //Showing the graph

        //*While beak is not up*
        while(!lightFinch.isBeakUp()){

            lightFinch.updateLightSensorGraph(lightFinch.getLeftLightSensor(), lightFinch.getRightLightSensor()); //Updating the graph

            lightSensorValues = lightFinch.getLightSensors(); //Storing the light values in the array
            for(int i = 0; i< lightSensorValues.length; i++){ //Storing the light values in the arrayList
                lightSensorValuesFinal.add(lightSensorValues[i]); //Storing the light values in the arrayList
            }

            lightFinch.setLED(Color.yellow);
            lightFinch.setWheelVelocities(70, 70, 4000);

            //*If the the finch detects light in the right sensor*
            while ((lightFinch.getRightLightSensor() > 20)&&(lightFinch.getLeftLightSensor() < 20)){

                lightSensorValues = lightFinch.getLightSensors(); //Storing the light values in the array
                highRightLightValue= lightFinch.getRightLightSensor(); //Storing the highest light value

                if (lightFinch.getRightLightSensor() >highRightLightValue) { //Storing the highest light value
                    highRightLightValue= lightFinch.getRightLightSensor(); //Storing the highest light value
                }

                lowRightLightValue=startRightLightValue; //Storing the lowest light value

                if (lightFinch.getRightLightSensor() <lowRightLightValue) { //Storing the lowest light value
                    lowRightLightValue= lightFinch.getRightLightSensor(); //Storing the lowest light value
                }

                lightFinch.updateLightSensorGraph(lightFinch.getLeftLightSensor(), lightFinch.getRightLightSensor()); //Updating the graph
                lightCounter++; //Increasing the light counter
                finchLeftA(); //Calling the method to go Left
                UserInterface.avoidLightMessage(); //Displaying message
            }

            //*If the the finch detects light in the left sensor*
            while ((lightFinch.getLeftLightSensor() > 20)&&(lightFinch.getRightLightSensor() < 20)){
                lightSensorValues = lightFinch.getLightSensors(); //Storing the light values in the array
                highLeftLightValue= lightFinch.getLeftLightSensor(); //Storing the highest light value

                if (lightFinch.getLeftLightSensor() >highLeftLightValue) { //Storing the highest light value
                    highLeftLightValue= lightFinch.getLeftLightSensor(); //Storing the highest light value
                }

                lowLeftLightValue=startLeftLightValue; //Storing the lowest light value

                if (lightFinch.getLeftLightSensor() <lowLeftLightValue) { //Storing the lowest light value
                    lowLeftLightValue= lightFinch.getLeftLightSensor(); //Storing the lowest light value
                }

                lightFinch.updateLightSensorGraph(lightFinch.getLeftLightSensor(), lightFinch.getRightLightSensor()); //Updating the graph
                lightCounter++; //Increasing the light counter
                finchRightA(); //Calling the method to go Right
                UserInterface.avoidLightMessage(); //Displaying message
            }

            //*If the the finch doesn't detect any light source*
            if(((lightFinch.getLeftLightSensor() <= 20)&&(lightFinch.getRightLightSensor() <= 20))){
                lightFinch.updateLightSensorGraph(lightFinch.getLeftLightSensor(), lightFinch.getRightLightSensor()); //Updating the graph
                UserInterface.searchingForLightMessage(); //Displaying message
                randomDirection();} //Calling the method to go to a random direction

        }


        System.out.println("The beak is up");
        timerEnd=((System.currentTimeMillis() - timer)/1000); //End of timer
        Log.showAvoid(); //Show the log
        lightFinch.quit(); //The finch will quit
        Log.saveAvoidLog(); //The program will ask to the user if they want to save the log
        System.exit(-1) ; //The program will end

    }
}
