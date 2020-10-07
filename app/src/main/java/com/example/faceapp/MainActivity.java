//Author: @Chandler Lau lauc21

package com.example.faceapp;

import android.content.pm.ActivityInfo;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {
   @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        //find seekbars
       SeekBar red = findViewById(R.id.redSeekBar);
       SeekBar green = findViewById(R.id.greenSeekBar);
       SeekBar blue = findViewById(R.id.blueSeekBar);


       //create Instance of face and face controller
        Face face = findViewById(R.id.faceview);
        FaceController faceController = new FaceController(face, red, green, blue);

        //find radio group and buttons, and set to listeners
       RadioGroup radioGroup = findViewById(R.id.radioGroup);
       radioGroup.setOnCheckedChangeListener(faceController);
       RadioButton hairButton = findViewById(R.id.hairButton);
       RadioButton eyeButton = findViewById(R.id.eyeButton);
       RadioButton skinButton = findViewById(R.id.skinButton);

       //set seekbars to listeners
       red.setOnSeekBarChangeListener(faceController);
       green.setOnSeekBarChangeListener(faceController);
       blue.setOnSeekBarChangeListener(faceController);

       //find button for random and set as a listener
       Button random = findViewById(R.id.randomButton);
       random.setOnClickListener(faceController);

       //find spinner and set as listener
       Spinner spinner = findViewById(R.id.Hair_Spinner);
       spinner.setOnItemSelectedListener(faceController);
   }

}


/* Sources used Citing
External Citation
 Date: 5 October 2020
 Problem: Didn't know formula for set range on Math.random()
 Resource: https://www.baeldung.com/java-generating-random-numbers-in-range
 Solution: Used formula from the document

External Citation
 Date: 5 October 2020
 Problem: Needed review on how to use spinners
 Resource: https://stackoverflow.com/questions/2399086/how-to-use-spinner
           https://abhiandroid.com/ui/spinner
 Solution: Used syntax found in post

External Citation
 Date: 5 October 2020
 Problem: Review how to use onClick Listener for radio button
 Resource:
https://stackoverflow.com/questions/8323778/how-to-set-onclicklistener-on-a-radiobutton-in-android
 Solution: Used info in post to setup onClick listener

External Citation
 Date: 5 October 2020
 Problem: Needed help understanding how paint works
 Resource:
https://developer.android.com/reference/android/graphics/Paint
 Solution: Post info on paint

External Citation
 Date: 5 October 2020
 Problem: Didn't know how to use RGB values to set color
 Resource: https://www.codota.com/code/java/methods/android.graphics.Paint/setARGB
 Solution: Used .setARGB

External Citation
 Date: 6 October 2020
 Problem: Didn't know how to use use radio group with 3 buttons
 Resource: https://stackoverflow.com/questions/6780981/android-radiogroup-how-to-configure-the-event-listener
 Solution: Used .setOnCheckedChangeListener on radio group




 */