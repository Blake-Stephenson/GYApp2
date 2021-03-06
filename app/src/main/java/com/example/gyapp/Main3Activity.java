package com.example.gyapp;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;


/**
 * This is the game screen
 * @author B. Stephenson, D. Goodman
 */
public class Main3Activity extends AppCompatActivity implements SensorEventListener {

    private static final String TAG = "Main3Activity";

    private SensorManager sensorManager;
    Sensor accelerometer;

    int[][] board = new int[11][20];
    ArrayList<int[]> snake;
    int[] head = {5,10};
    int direction = 1;
    int[] food = {0,0};
    double time = 0;

    /**
     * initializes the activity
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Log.i(TAG, " Starts Sensor");
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(Main3Activity.this,accelerometer,SensorManager.SENSOR_DELAY_GAME);

        snake = new ArrayList<>();
        snake.clear();
        snake.add(head);
        food[0] = randInt(0,10);
        food[1] = randInt(0,16
        );
    }

    /**
     * Is automatically called every 10ms to update the position of accelerometer
     *
     * @param sensorEvent
     */
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        time++;
        Log.i(TAG, "onSensorChanged: X: "+ sensorEvent.values[0]+ "Y: "+ sensorEvent.values[1]+ "Z: "+ sensorEvent.values[2]);

        clrBoard(board);

       if((time%10)==0) {
           if(sensorEvent.values[0]>3){
               direction++;
           }
           if(sensorEvent.values[0]<-3){
               direction--;
           }
           int last = snake.size()-1;

           int[] piece = {1,1};
           piece[0] = snake.get(snake.size()-1)[0];
           piece[1] = snake.get(snake.size()-1)[1];
           if(direction == -1 || direction == 3) {
               direction = 3;
               piece[1]+=1;
               if(piece[1]>19) {
                   piece[1] = 0;
               }
           }else if(direction == 4 || direction == 0) {
               direction = 0;
               piece[0]+=1;
               if(piece[0]>10) {
                   piece[0] = 0;
               }
           }else if(direction == 1) {
               piece[1]-=1;
               if(piece[1]<0) {
                   piece[1] = 19;
               }
           }else{
               piece[0]-=1;
               if(piece[0]<0) {
                   piece[0] = 10;
               }
           }
           snake.add(piece);
           Log.d(TAG, "Snake length: "+snake.size());
           for(int i = 0;i<snake.size();i++) {
               Log.d(TAG, "snake parts" + snake.get(i)[0] + " " + snake.get(i)[1]);
           }
           Log.d(TAG,"snake xy: "+snake.get(0)[0]+" "+snake.get(0)[1]+" foodxy: "+food[0]+" "+food[1]);
           if(snake.get(last)[0] == food[0] && snake.get(last)[1]==food[1]){
               food[0] = randInt(0,10);
               food[1] = randInt(0,16);
           }else{
               snake.remove(0);
           }
           Log.d(TAG,"after food check");
           int[] head_temp = snake.get(snake.size()-1);
           for(int i =0;i<(snake.size()-1);i++){
               if(snake.get(i)[0]==head_temp[0] && snake.get(i)[1]==head_temp[1]){
                   startActivity(new Intent(Main3Activity.this , Main2Activity.class));
               }
           }
       }
        Button b = findViewById(R.id.button00);
        b.setText(String.valueOf(snake.size()));
        board[food[0]][food[1]]=2;

        snake_board(snake,board);
        printBoard(board);

    }

    /**
     * Runs when accuracy is changed
     *
     * @param sensor
     * @param accuracy
     */
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    /**
     * Prints the 2d board array on the display using the printCell method
     *
     * @param b
     */
    public void printBoard(int[][] b){
        for(int i = 0;i <11;i++) {
            for(int j = 0;j<20;j++) {
                if(b[i][j]==1) {
                    printCell(i,j,1);
                }else if(b[i][j]==2) {
                    printCell(i,j,2);
                }else {
                    printCell(i,j,0);
                }
            }

        }
    }

    /**
     * changes the colour of a cell using its x and y position (i,j) and its colour is the c value
     * c = 1 is Green, c = 2 is Red, any other value for c is white
     *
     * @param i
     * @param j
     * @param c
     */
    public void printCell(int i,int j,int c){
        Button button;
        button = findViewById(R.id.button00);
        if(i==0){
            if(j==0) {
                button = findViewById(R.id.button00);
            }
            if(j==1) {
                button = findViewById(R.id.button01);
            }
            if(j==2) {
                button = findViewById(R.id.button02);
            }
            if(j==3) {
                button = findViewById(R.id.button03);
            }
            if(j==4) {
                button = findViewById(R.id.button04);
            }
            if(j==5) {
                button = findViewById(R.id.button05);
            }
            if(j==6) {
                button = findViewById(R.id.button06);
            }
            if(j==7) {
                button = findViewById(R.id.button07);
            }
            if(j==8) {
                button = findViewById(R.id.button08);
            }
            if(j==9) {
                button = findViewById(R.id.button09);
            }
            if(j==10) {
                button = findViewById(R.id.button010);
            }
            if(j==11) {
                button = findViewById(R.id.button011);
            }
            if(j==12) {
                button = findViewById(R.id.button012);
            }
            if(j==13) {
                button = findViewById(R.id.button013);
            }
            if(j==14) {
                button = findViewById(R.id.button014);
            }
            if(j==15) {
                button = findViewById(R.id.button015);
            }
            if(j==16) {
                button = findViewById(R.id.button016);
            }
            if(j==17) {
                button = findViewById(R.id.button017);
            }
            if(j==18) {
                button = findViewById(R.id.button018);
            }
            if(j==19) {
                button = findViewById(R.id.button019);
            }
        }else if(i==1){
            if(j==0) {
                button = findViewById(R.id.button10);
            }
            if(j==1) {
                button = findViewById(R.id.button11);
            }
            if(j==2) {
                button = findViewById(R.id.button12);
            }
            if(j==3) {
                button = findViewById(R.id.button13);
            }
            if(j==4) {
                button = findViewById(R.id.button14);
            }
            if(j==5) {
                button = findViewById(R.id.button15);
            }
            if(j==6) {
                button = findViewById(R.id.button16);
            }
            if(j==7) {
                button = findViewById(R.id.button17);
            }
            if(j==8) {
                button = findViewById(R.id.button18);
            }
            if(j==9) {
                button = findViewById(R.id.button19);
            }
            if(j==10) {
                button = findViewById(R.id.button110);
            }
            if(j==11) {
                button = findViewById(R.id.button111);
            }
            if(j==12) {
                button = findViewById(R.id.button112);
            }
            if(j==13) {
                button = findViewById(R.id.button113);
            }
            if(j==14) {
                button = findViewById(R.id.button114);
            }
            if(j==15) {
                button = findViewById(R.id.button115);
            }
            if(j==16) {
                button = findViewById(R.id.button116);
            }
            if(j==17) {
                button = findViewById(R.id.button117);
            }
            if(j==18) {
                button = findViewById(R.id.button118);
            }
            if(j==19) {
                button = findViewById(R.id.button119);
            }
        }else if(i==2){
            if(j==0) {
                button = findViewById(R.id.button20);
            }
            if(j==1) {
                button = findViewById(R.id.button21);
            }
            if(j==2) {
                button = findViewById(R.id.button22);
            }
            if(j==3) {
                button = findViewById(R.id.button23);
            }
            if(j==4) {
                button = findViewById(R.id.button24);
            }
            if(j==5) {
                button = findViewById(R.id.button25);
            }
            if(j==6) {
                button = findViewById(R.id.button26);
            }
            if(j==7) {
                button = findViewById(R.id.button27);
            }
            if(j==8) {
                button = findViewById(R.id.button28);
            }
            if(j==9) {
                button = findViewById(R.id.button29);
            }
            if(j==10) {
                button = findViewById(R.id.button210);
            }
            if(j==11) {
                button = findViewById(R.id.button211);
            }
            if(j==12) {
                button = findViewById(R.id.button212);
            }
            if(j==13) {
                button = findViewById(R.id.button213);
            }
            if(j==14) {
                button = findViewById(R.id.button214);
            }
            if(j==15) {
                button = findViewById(R.id.button215);
            }
            if(j==16) {
                button = findViewById(R.id.button216);
            }
            if(j==17) {
                button = findViewById(R.id.button217);
            }
            if(j==18) {
                button = findViewById(R.id.button218);
            }
            if(j==19) {
                button = findViewById(R.id.button219);
            }
        }else if(i==3){
            if(j==0) {
                button = findViewById(R.id.button30);
            }
            if(j==1) {
                button = findViewById(R.id.button31);
            }
            if(j==2) {
                button = findViewById(R.id.button32);
            }
            if(j==3) {
                button = findViewById(R.id.button33);
            }
            if(j==4) {
                button = findViewById(R.id.button34);
            }
            if(j==5) {
                button = findViewById(R.id.button35);
            }
            if(j==6) {
                button = findViewById(R.id.button36);
            }
            if(j==7) {
                button = findViewById(R.id.button37);
            }
            if(j==8) {
                button = findViewById(R.id.button38);
            }
            if(j==9) {
                button = findViewById(R.id.button39);
            }
            if(j==10) {
                button = findViewById(R.id.button310);
            }
            if(j==11) {
                button = findViewById(R.id.button311);
            }
            if(j==12) {
                button = findViewById(R.id.button312);
            }
            if(j==13) {
                button = findViewById(R.id.button313);
            }
            if(j==14) {
                button = findViewById(R.id.button314);
            }
            if(j==15) {
                button = findViewById(R.id.button315);
            }
            if(j==16) {
                button = findViewById(R.id.button316);
            }
            if(j==17) {
                button = findViewById(R.id.button317);
            }
            if(j==18) {
                button = findViewById(R.id.button318);
            }
            if(j==19) {
                button = findViewById(R.id.button319);
            }
        }else if(i==4){
            if(j==0) {
                button = findViewById(R.id.button40);
            }
            if(j==1) {
                button = findViewById(R.id.button41);
            }
            if(j==2) {
                button = findViewById(R.id.button42);
            }
            if(j==3) {
                button = findViewById(R.id.button43);
            }
            if(j==4) {
                button = findViewById(R.id.button44);
            }
            if(j==5) {
                button = findViewById(R.id.button45);
            }
            if(j==6) {
                button = findViewById(R.id.button46);
            }
            if(j==7) {
                button = findViewById(R.id.button47);
            }
            if(j==8) {
                button = findViewById(R.id.button48);
            }
            if(j==9) {
                button = findViewById(R.id.button49);
            }
            if(j==10) {
                button = findViewById(R.id.button410);
            }
            if(j==11) {
                button = findViewById(R.id.button411);
            }
            if(j==12) {
                button = findViewById(R.id.button412);
            }
            if(j==13) {
                button = findViewById(R.id.button413);
            }
            if(j==14) {
                button = findViewById(R.id.button414);
            }
            if(j==15) {
                button = findViewById(R.id.button415);
            }
            if(j==16) {
                button = findViewById(R.id.button416);
            }
            if(j==17) {
                button = findViewById(R.id.button417);
            }
            if(j==18) {
                button = findViewById(R.id.button418);
            }
            if(j==19) {
                button = findViewById(R.id.button419);
            }
        }else if(i==5){
            if(j==0) {
                button = findViewById(R.id.button50);
            }
            if(j==1) {
                button = findViewById(R.id.button51);
            }
            if(j==2) {
                button = findViewById(R.id.button52);
            }
            if(j==3) {
                button = findViewById(R.id.button53);
            }
            if(j==4) {
                button = findViewById(R.id.button54);
            }
            if(j==5) {
                button = findViewById(R.id.button55);
            }
            if(j==6) {
                button = findViewById(R.id.button56);
            }
            if(j==7) {
                button = findViewById(R.id.button57);
            }
            if(j==8) {
                button = findViewById(R.id.button58);
            }
            if(j==9) {
                button = findViewById(R.id.button59);
            }
            if(j==10) {
                button = findViewById(R.id.button510);
            }
            if(j==11) {
                button = findViewById(R.id.button511);
            }
            if(j==12) {
                button = findViewById(R.id.button512);
            }
            if(j==13) {
                button = findViewById(R.id.button513);
            }
            if(j==14) {
                button = findViewById(R.id.button514);
            }
            if(j==15) {
                button = findViewById(R.id.button515);
            }
            if(j==16) {
                button = findViewById(R.id.button516);
            }
            if(j==17) {
                button = findViewById(R.id.button517);
            }
            if(j==18) {
                button = findViewById(R.id.button518);
            }
            if(j==19) {
                button = findViewById(R.id.button519);
            }
        }else if(i==6){
            if(j==0) {
                button = findViewById(R.id.button60);
            }
            if(j==1) {
                button = findViewById(R.id.button61);
            }
            if(j==2) {
                button = findViewById(R.id.button62);
            }
            if(j==3) {
                button = findViewById(R.id.button63);
            }
            if(j==4) {
                button = findViewById(R.id.button64);
            }
            if(j==5) {
                button = findViewById(R.id.button65);
            }
            if(j==6) {
                button = findViewById(R.id.button66);
            }
            if(j==7) {
                button = findViewById(R.id.button67);
            }
            if(j==8) {
                button = findViewById(R.id.button68);
            }
            if(j==9) {
                button = findViewById(R.id.button69);
            }
            if(j==10) {
                button = findViewById(R.id.button610);
            }
            if(j==11) {
                button = findViewById(R.id.button611);
            }
            if(j==12) {
                button = findViewById(R.id.button612);
            }
            if(j==13) {
                button = findViewById(R.id.button613);
            }
            if(j==14) {
                button = findViewById(R.id.button614);
            }
            if(j==15) {
                button = findViewById(R.id.button615);
            }
            if(j==16) {
                button = findViewById(R.id.button616);
            }
            if(j==17) {
                button = findViewById(R.id.button617);
            }
            if(j==18) {
                button = findViewById(R.id.button618);
            }
            if(j==19) {
                button = findViewById(R.id.button619);
            }
        }else if(i==7){
            if(j==0) {
                button = findViewById(R.id.button70);
            }
            if(j==1) {
                button = findViewById(R.id.button71);
            }
            if(j==2) {
                button = findViewById(R.id.button72);
            }
            if(j==3) {
                button = findViewById(R.id.button73);
            }
            if(j==4) {
                button = findViewById(R.id.button74);
            }
            if(j==5) {
                button = findViewById(R.id.button75);
            }
            if(j==6) {
                button = findViewById(R.id.button76);
            }
            if(j==7) {
                button = findViewById(R.id.button77);
            }
            if(j==8) {
                button = findViewById(R.id.button78);
            }
            if(j==9) {
                button = findViewById(R.id.button79);
            }
            if(j==10) {
                button = findViewById(R.id.button710);
            }
            if(j==11) {
                button = findViewById(R.id.button711);
            }
            if(j==12) {
                button = findViewById(R.id.button712);
            }
            if(j==13) {
                button = findViewById(R.id.button713);
            }
            if(j==14) {
                button = findViewById(R.id.button714);
            }
            if(j==15) {
                button = findViewById(R.id.button715);
            }
            if(j==16) {
                button = findViewById(R.id.button716);
            }
            if(j==17) {
                button = findViewById(R.id.button717);
            }
            if(j==18) {
                button = findViewById(R.id.button718);
            }
            if(j==19) {
                button = findViewById(R.id.button719);
            }
        }else if(i==8){
            if(j==0) {
                button = findViewById(R.id.button80);
            }
            if(j==1) {
                button = findViewById(R.id.button81);
            }
            if(j==2) {
                button = findViewById(R.id.button82);
            }
            if(j==3) {
                button = findViewById(R.id.button83);
            }
            if(j==4) {
                button = findViewById(R.id.button84);
            }
            if(j==5) {
                button = findViewById(R.id.button85);
            }
            if(j==6) {
                button = findViewById(R.id.button86);
            }
            if(j==7) {
                button = findViewById(R.id.button87);
            }
            if(j==8) {
                button = findViewById(R.id.button88);
            }
            if(j==9) {
                button = findViewById(R.id.button89);
            }
            if(j==10) {
                button = findViewById(R.id.button810);
            }
            if(j==11) {
                button = findViewById(R.id.button811);
            }
            if(j==12) {
                button = findViewById(R.id.button812);
            }
            if(j==13) {
                button = findViewById(R.id.button813);
            }
            if(j==14) {
                button = findViewById(R.id.button814);
            }
            if(j==15) {
                button = findViewById(R.id.button815);
            }
            if(j==16) {
                button = findViewById(R.id.button816);
            }
            if(j==17) {
                button = findViewById(R.id.button817);
            }
            if(j==18) {
                button = findViewById(R.id.button818);
            }
            if(j==19) {
                button = findViewById(R.id.button819);
            }
        }else if(i==9){
            if(j==0) {
                button = findViewById(R.id.button90);
            }
            if(j==1) {
                button = findViewById(R.id.button91);
            }
            if(j==2) {
                button = findViewById(R.id.button92);
            }
            if(j==3) {
                button = findViewById(R.id.button93);
            }
            if(j==4) {
                button = findViewById(R.id.button94);
            }
            if(j==5) {
                button = findViewById(R.id.button95);
            }
            if(j==6) {
                button = findViewById(R.id.button96);
            }
            if(j==7) {
                button = findViewById(R.id.button97);
            }
            if(j==8) {
                button = findViewById(R.id.button98);
            }
            if(j==9) {
                button = findViewById(R.id.button99);
            }
            if(j==10) {
                button = findViewById(R.id.button910);
            }
            if(j==11) {
                button = findViewById(R.id.button911);
            }
            if(j==12) {
                button = findViewById(R.id.button912);
            }
            if(j==13) {
                button = findViewById(R.id.button913);
            }
            if(j==14) {
                button = findViewById(R.id.button914);
            }
            if(j==15) {
                button = findViewById(R.id.button915);
            }
            if(j==16) {
                button = findViewById(R.id.button916);
            }
            if(j==17) {
                button = findViewById(R.id.button917);
            }
            if(j==18) {
                button = findViewById(R.id.button918);
            }
            if(j==19) {
                button = findViewById(R.id.button919);
            }
        }else if(i==10) {
            if (j == 0) {
                button = findViewById(R.id.button100);
            }
            if (j == 1) {
                button = findViewById(R.id.button101);
            }
            if (j == 2) {
                button = findViewById(R.id.button102);
            }
            if (j == 3) {
                button = findViewById(R.id.button103);
            }
            if (j == 4) {
                button = findViewById(R.id.button104);
            }
            if (j == 5) {
                button = findViewById(R.id.button105);
            }
            if (j == 6) {
                button = findViewById(R.id.button106);
            }
            if (j == 7) {
                button = findViewById(R.id.button107);
            }
            if (j == 8) {
                button = findViewById(R.id.button108);
            }
            if (j == 9) {
                button = findViewById(R.id.button109);
            }
            if (j == 10) {
                button = findViewById(R.id.button1010);
            }
            if (j == 11) {
                button = findViewById(R.id.button1011);
            }
            if (j == 12) {
                button = findViewById(R.id.button1012);
            }
            if (j == 13) {
                button = findViewById(R.id.button1013);
            }
            if (j == 14) {
                button = findViewById(R.id.button1014);
            }
            if (j == 15) {
                button = findViewById(R.id.button1015);
            }
            if (j == 16) {
                button = findViewById(R.id.button1016);
            }
            if (j == 17) {
                button = findViewById(R.id.button1017);
            }
            if (j == 18) {
                button = findViewById(R.id.button1018);
            }
            if (j == 19) {
                button = findViewById(R.id.button1019);
            }
        }
        if(c==1) {
            button.setBackgroundColor(0xFF00FF00);
        }else if(c==2) {
            button.setBackgroundColor(0xFFFF0000);
        }else{
            button.setBackgroundColor(0x44000000);
        }

    }

    /**
     * Returns a random int between the min and max
     *
     * @param min
     * @param max
     * @return
     */
    public static int randInt(int min, int max) {
        Random r = new Random();
        int randomNum = r.nextInt((max - min) + 1) + min;
        return randomNum;

    }

    /**
     * Adds the Snakes coordinates (which are stored in an ArrayList) to the 2d board array
     *
     * @param s
     * @param b
     */
    public void snake_board(ArrayList<int[]> s,int[][] b){
        for(int i = 0;i<s.size();i++){
            b[s.get(i)[0]][s.get(i)[1]]=1;
        }
    }

    /**
     * Clears the 2d board array
     *
     * @param b
     */
    public void clrBoard(int[][] b){
        for(int i = 0;i <11;i++) {
            for (int j = 0; j < 20; j++) {
                b[i][j]=0;
            }
        }
    }
}


