package com.company;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.util.ArrayList;
import java.util.Random;


public class FinchConfiguration {
    
//*Declaration of variables*
    protected static  Finch lightFinch = new Finch(); //Initializing Finch
    protected static int lightCounter=0; //Initializing counter for the light
    protected static long timer ; //Declaration of the timer Start
    protected static long timerEnd; //Declaration of the Timer Actual Value
    protected static int [] lightSensorValues; //Declaration of the array where the values are going to be stored every time the finch detects light
    protected static ArrayList<Integer> lightSensorValuesFinal = new ArrayList<Integer>(); //Creating an ArrrayList where ALL the values of the light will be stored
    protected static float avg=0; //Declaration of the average of all the light values
    protected static int sum =0; //Declaration of the sum of all the light values
    protected static int startRightLightValue; //Declaration of the starting value of Right Sensor
    protected static int startLeftLightValue; ///Declaration of the starting value of Left Sensor
    protected static int highRightLightValue; //Declaration of the highest light values of Right Sensor
    protected static int highLeftLightValue; //Declaration of the highest light values of Left Sensor
    protected static int lowRightLightValue; //Declaration of the lowest light values of Right Sensor
    protected static int lowLeftLightValue; //Declaration of the lowest light values of Left Sensor

    //*The method increases the brightness of the LED according to the intensity of the light source*
    protected static int finchLightBrightness(){
       int lightvalue =0;
       
       if(((lightFinch.getRightLightSensor() > 20)||(lightFinch.getLeftLightSensor() > 20))&&((lightFinch.getRightLightSensor() <= 70)||(lightFinch.getLeftLightSensor() <= 70))) {
           lightvalue=50;
           return lightvalue;
       }

        else if(((lightFinch.getRightLightSensor() > 70)||(lightFinch.getLeftLightSensor() > 70))&&((lightFinch.getRightLightSensor() <= 120)||(lightFinch.getLeftLightSensor() <= 120))) {
            lightvalue=100;
            return lightvalue;
        }

       else  if(((lightFinch.getRightLightSensor() > 120)||(lightFinch.getLeftLightSensor() > 120))&&((lightFinch.getRightLightSensor() <= 170)||(lightFinch.getLeftLightSensor() <= 170))) {
            lightvalue=150;
            return lightvalue;
        }

        else if(((lightFinch.getRightLightSensor() > 170)||(lightFinch.getLeftLightSensor() > 170))&&((lightFinch.getRightLightSensor() <= 220)||(lightFinch.getLeftLightSensor() <= 220))) {
            lightvalue=200;
            return lightvalue;
        }

        else if((lightFinch.getRightLightSensor() > 220)&&(lightFinch.getLeftLightSensor() > 220)) {
            lightvalue=255;
            return lightvalue;
        }
    
        return lightvalue;
    
    }

    //*These methods describes all the movements that the finch will do*

    protected static void finchRight(){
        lightFinch.setLED(finchLightBrightness(),0,0);
        lightFinch.setWheelVelocities(150, -50,250);
        System.out.println("TThe Finch is following the light (R)");
    }


    protected static void finchLeft(){
        lightFinch.setLED(finchLightBrightness(),0,0);
        lightFinch.setWheelVelocities(-50, 150,250);
        System.out.println("TThe Finch is following the light (L)");
    }


    protected static void finchRightA(){
        lightFinch.setLED(0,0, finchLightBrightness());
        lightFinch.buzz(262, 1000);
        lightFinch.setWheelVelocities(150, -50,250);
        System.out.println("The Finch is avoiding the light (R)");
    }


    protected static void finchLeftA(){
        lightFinch.setLED(0,0, finchLightBrightness());
        lightFinch.buzz(262, 1000);
        lightFinch.setWheelVelocities(-50, 150,250);
        System.out.println("The Finch is avoiding the light (L)");
    }

    //*The method will generate a random direction*
    protected static void randomDirection(){
        Random rl = new Random();
        System.out.println("There's no light");
        lightFinch.sleep(500);

        if( rl.nextBoolean()){
            System.out.println("Randomized direction (L)");
            lightFinch.setWheelVelocities(-50,100,1100);

        }

        else{
            System.out.println("Randomized direction (R)");
            lightFinch.setWheelVelocities(100,-50,1100);

        }
    }

}


