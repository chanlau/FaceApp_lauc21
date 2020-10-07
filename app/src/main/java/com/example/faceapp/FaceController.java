//Author: @Chandler Lau lauc21

package com.example.faceapp;

import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class FaceController implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener, AdapterView.OnItemSelectedListener {
    private Face face;
    SeekBar redSeekBar;
    SeekBar blueSeekBar;
    SeekBar greenSeekBar;

    //constructor
    public FaceController(Face f, SeekBar red, SeekBar green, SeekBar blue){
        this.face = f;
        blueSeekBar = blue;
        redSeekBar = red;
        greenSeekBar = green;
    }

    //onClick for random button to call random method
    //randomizes values of face
    @Override
    public void onClick(View view) {
        face.random();
        face.invalidate();
    }

    //onCheckedChanged for radio group
    //sets radioSelect to 1,2, or 3 based on which radio button is pressed
    //radioSelect = 1 for hair, 2 for eyes, 3 for skin
    //Sets the seekbars to values corresponding with radio buttons
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedID) {
        if(checkedID == R.id.hairButton){
            face.radioSelect = 1;
            updateSeekBar();
        }
        else if(checkedID == R.id.eyeButton){
            face.radioSelect = 2;
            updateSeekBar();
        }
        else if(checkedID ==R.id.skinButton){
            face.radioSelect = 3;
            updateSeekBar();
        }
    }

    //onProgressChanged for Seek bars
    //Changes values of RGB for either hair, eyes, or skin depending on radioSelect
    // as the progress bar changes (Sorry, this method is very long)
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        switch(seekBar.getId()){
            //checks which seek bar is being altered and based on the
            // radio select it chooses which value to update
            case R.id.redSeekBar:
                switch(face.radioSelect){
                    case 1:
                        face.hairRed = seekBar.getProgress();
                        break;
                    case 2:
                        face.eyeRed = seekBar.getProgress();
                        break;
                    case 3:
                        face.skinRed = seekBar.getProgress();
                        break;
                }
                break;

            case R.id.greenSeekBar:
                switch(face.radioSelect){
                    case 1:
                        face.hairGreen = seekBar.getProgress();
                        break;
                    case 2:
                        face.eyeGreen = seekBar.getProgress();
                        break;
                    case 3:
                        face.skinGreen = seekBar.getProgress();
                        break;
                }
                break;

            case R.id.blueSeekBar:
                switch(face.radioSelect){
                    case 1:
                        face.hairBlue = seekBar.getProgress();
                        break;
                    case 2:
                        face.eyeBlue = seekBar.getProgress();
                        break;
                    case 3:
                        face.skinBlue = seekBar.getProgress();
                        break;
                }
                break;
        }
        face.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    //onItemSelected for spinner
    //sets face.hairstyle to 1, 2, or 3 based on which hairstyle is chosen
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch(i){
            case 0:
                face.hairStyle = 1;
                break;
            case 1:
                face.hairStyle = 2;
                break;
            case 2:
                face.hairStyle = 3;
                break;
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void updateSeekBar(){
        if(face.radioSelect == 1){
            redSeekBar.setProgress(face.hairRed);
            greenSeekBar.setProgress(face.hairGreen);
            blueSeekBar.setProgress(face.hairBlue);
        }
        else if(face.radioSelect == 2){
            redSeekBar.setProgress(face.eyeRed);
            greenSeekBar.setProgress(face.eyeGreen);
            blueSeekBar.setProgress(face.eyeBlue);
        }
        else if(face.radioSelect ==3){
            redSeekBar.setProgress(face.skinRed);
            greenSeekBar.setProgress(face.skinGreen);
            blueSeekBar.setProgress(face.skinBlue);
        }
    }
}
