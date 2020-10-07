//Author: @Chandler Lau lauc21

package com.example.faceapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class Face extends SurfaceView {
    //Instance Variables for face
    int radioSelect;    //which radio button selected
    int hairRed;
    int hairGreen;
    int hairBlue;
    int eyeRed;
    int eyeGreen;
    int eyeBlue;
    int skinRed;
    int skinGreen;
    int skinBlue;
    int hairStyle; //1 for hair, 1 for eyes, 1 for skin

    //initialize paints
    Paint skinPaint = new Paint();
    Paint eyePaint = new Paint();
    Paint hairPaint = new Paint();
    Paint eyeBallPaint = new Paint();
    Paint mouthPaint = new Paint();

    public Face(Context context, AttributeSet attrs) {
        super(context, attrs);

        //call random to set random values to instance variables
        random();

        //So onDraw wont be called
        setWillNotDraw(false);

        //set palettes for paints that don't change
        eyeBallPaint.setColor(Color.WHITE);
        mouthPaint.setColor(Color.BLACK);
        //set background color
        setBackgroundColor(Color.WHITE);
    }

    //method to set instance variables randomly
    public void random(){
        hairRed = (int)((Math.random()*(255-0))+0);
        hairGreen = (int)((Math.random()*(255-0))+0);
        hairBlue = (int)((Math.random()*(255-0))+0);
        eyeRed = (int)((Math.random()*(255-0))+0);
        eyeGreen = (int)((Math.random()*(255-0))+0);
        eyeBlue = (int)((Math.random()*(255-0))+0);
        skinRed = (int)((Math.random()*(255-0))+0);
        skinGreen = (int)((Math.random()*(255-0))+0);
        skinBlue = (int)((Math.random()*(255-0))+0);
        hairStyle = (int)((Math.random()*(4-1))+1);

    }


    public void onDraw(Canvas canvas){
        //call draw methods to draw different parts of face
        drawHead(canvas);
        drawEyes(canvas);
        drawHair(canvas);
    }

    //draws faces head and mouth
    public void drawHead(Canvas canvas){
        skinPaint.setARGB(255, skinRed, skinGreen, skinBlue);
        skinPaint.setStyle(Paint.Style.FILL);
        //draw head
        canvas.drawOval(300, 500, 900, 1100, skinPaint);

        //draw mouth
        canvas.drawRect(450, 900, 750, 950, mouthPaint);
        canvas.drawRect(450, 875, 475, 950, mouthPaint);
        canvas.drawRect(725, 875, 755, 950, mouthPaint);
    }

    //draws faces pupils and eyeballs
    public void drawEyes(Canvas canvas){
        //draw eyeballs
        canvas.drawOval(400,625, 500, 725, eyeBallPaint);
        canvas.drawOval(700, 625, 800, 725, eyeBallPaint);

        //draw pupils
        eyePaint.setARGB(255, eyeRed, eyeGreen, eyeBlue);
        eyePaint.setStyle(Paint.Style.FILL);
        canvas.drawOval(425, 650, 475, 700, eyePaint);
        canvas.drawOval(725, 650, 775, 700, eyePaint);
    }

    //draws hair based on which hairstyle is selected
    public void drawHair(Canvas canvas){
        hairPaint.setARGB(255, hairRed, hairGreen, hairBlue);
        hairPaint.setStyle(Paint.Style.FILL);
        if(hairStyle == 1){
            canvas.drawRect(400, 400, 800, 575, hairPaint);
        }
        else if(hairStyle == 2){
            canvas.drawOval(400, 400, 600, 575, hairPaint);
            canvas.drawOval(600, 400, 800, 575, hairPaint);
        }
        else if(hairStyle == 3){
            canvas.drawRect(550, 600, 650, 400, hairPaint);
        }
        invalidate();
    }
}
