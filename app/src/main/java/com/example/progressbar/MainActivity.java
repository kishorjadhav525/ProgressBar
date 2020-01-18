package com.example.progressbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RatingBar r1;
    EditText et1;
    TextView t1;
    Button b1;
    float rating1;
    ProgressBar pb1;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r1=findViewById(R.id.ratingBar);
        et1=findViewById(R.id.editText);
        t1=findViewById(R.id.textView2);
        b1=findViewById(R.id.button);
        pb1=findViewById(R.id.progressBar3);



        r1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                rating1=rating;

               // Toast.makeText(MainActivity.this, "Thank You For Rating "+rating, Toast.LENGTH_SHORT).show();

            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pb1.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "Processing Done !!! ", Toast.LENGTH_SHORT).show();
                        pb1.setVisibility(View.INVISIBLE);

                    }
                },4000);


                if(rating1!=0)
                {

                showmsg("Thanks For giving feedback to us.., "+et1.getText().toString(), "  Your rating is =  "+ rating1);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Please Enter Your Feedback,Thank You ", Toast.LENGTH_SHORT).show();
                }
        }

            private void showmsg(String s, String s1) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle(t1.getText().toString());
                builder.setMessage(s+s1);
                builder.show();
            }


        });

    }
}
