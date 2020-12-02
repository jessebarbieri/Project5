package museumGo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This class represents our second activity, where the user can get the price estimate of a visit
 */
public class secondScreen extends AppCompatActivity {

    String selectedMuseum;
    ImageView museumPic;
    Button minusStudent;
    Button minusAdult;
    Button minusSenior;
    TextView textViewStudent;


    museum M;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
        Intent getdata = getIntent();
        selectedMuseum = getdata.getStringExtra("selectedMuseum");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.activity_second_screen);



        Toast.makeText(secondScreen.this, selectedMuseum, Toast.LENGTH_LONG).show();
        museumPic = (ImageView) findViewById(R.id.museumPic);

        if(selectedMuseum.equals("The Metropolitan Museum of Art")){
            museumPic.setImageResource(R.drawable.metpic);
            museum MMA = new museum(10, 20, 15);
            museumPic.setOnClickListener(new View.OnClickListener() {
                /**
                 * Is called when the image is clicked on, opens the website of the selected museum
                 * @param v, the ImageView
                 */
                @Override
                public void onClick(View v) {
                    Uri website = Uri.parse("https://www.metmuseum.org");
                    Intent intent = new Intent(Intent.ACTION_VIEW, website);
                    startActivity(intent);
                }
            });

            textViewStudent = (TextView)findViewById(R.id.textViewStudent);
            if(textViewStudent!=null){
                textViewStudent.setText("0");
            }           }
        else if(selectedMuseum.equals("Museum of Modern Art (MoMA)")){
            museumPic.setImageResource(R.drawable.momapic);
            M = new museum(11, 23, 17);
            museumPic.setOnClickListener(new View.OnClickListener() {
                /**
                 * Is called when the image is clicked on, opens the website of the selected museum
                 * @param v, the ImageView
                 */
                @Override
                public void onClick(View v) {
                    Uri website = Uri.parse("https://www.moma.org");
                    Intent intent = new Intent(Intent.ACTION_VIEW, website);
                    startActivity(intent);
                }
            });

            textViewStudent = (TextView)findViewById(R.id.textViewStudent);
            if(textViewStudent!=null){
                textViewStudent.setText("0");
            }           }
        else if(selectedMuseum.equals("American Museum of Natural History")){
            museumPic.setImageResource(R.drawable.historypic);
            M = new museum(12, 23, 16);
            museumPic.setOnClickListener(new View.OnClickListener() {
                /**
                 * Is called when the image is clicked on, opens the website of the selected museum
                 * @param v, the ImageView
                 */
                @Override
                public void onClick(View v) {
                        Uri website = Uri.parse("https://www.amnh.org");
                        Intent intent = new Intent(Intent.ACTION_VIEW, website);
                        startActivity(intent);
                }
            });

            textViewStudent = (TextView)findViewById(R.id.textViewStudent);
            if(textViewStudent!=null){
                textViewStudent.setText("0");
            }
        }
        else if(selectedMuseum.equals("Intrepid Sea, Air & Space Museum")){
            museumPic.setImageResource(R.drawable.intrepid);
            M = new museum(8, 17, 12);
            museumPic.setOnClickListener(new View.OnClickListener() {
                /**
                 * Is called when the image is clicked on, opens the website of the selected museum
                 * @param v, the ImageView
                 */
                @Override
                public void onClick(View v) {
                    Uri website = Uri.parse("https://m.intrepidmuseum.org");
                    Intent intent = new Intent(Intent.ACTION_VIEW, website);
                    startActivity(intent);
                }
            });

            textViewStudent = (TextView)findViewById(R.id.textViewStudent);
            if(textViewStudent!=null){
                textViewStudent.setText("0");
            }
        }

    }


    public void onClickMinusStudent(View v)
    {

        try {
            textViewStudent.setText(String.valueOf(M.students));
            int val = M.removeTicket(Integer.parseInt(textViewStudent.getText().toString()), "Student");
            textViewStudent.setText(String.valueOf(val));
            Toast.makeText(this, "Subtracted, Total now is " + val, Toast.LENGTH_LONG).show();
        }catch (NullPointerException e){
            Toast.makeText(this, "Null", Toast.LENGTH_LONG).show();
        }

    }

}