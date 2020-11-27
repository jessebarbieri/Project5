package museumGo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class secondScreen extends AppCompatActivity {

    String selectedMuseum;
    ImageView museumPic;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
        Intent getdata = getIntent();
        selectedMuseum = getdata.getStringExtra("selectedMuseum");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Just testing to see that data was passed correctly
        Toast.makeText(secondScreen.this, selectedMuseum, Toast.LENGTH_LONG).show();


        //
        museumPic = (ImageView) findViewById(R.id.museumPic);

        if(selectedMuseum.equals("The Metropolitan Museum of Art")){
            museumPic.setImageResource(R.drawable.metpic);
            museum MMA = new museum(10, 20, 15);
        }
        else if(selectedMuseum.equals("Museum of Modern Art (MoMA)")){
            museumPic.setImageResource(R.drawable.momapic);
            museum MOMA = new museum(11, 23, 17);

        }
        else if(selectedMuseum.equals("American Museum of Natural History")){
            museumPic.setImageResource(R.drawable.historypic);
            museum AMNH = new museum(12, 23, 16);
        }
        else if(selectedMuseum.equals("Intrepid Sea, Air & Space Museum")){
            museumPic.setImageResource(R.drawable.intrepid);
            museum Intrepid = new museum(8, 17, 12);
        }


        // Showing the image
        if(museumPic.isShown()){
            System.out.println("It is on screen");
        }
    }

}