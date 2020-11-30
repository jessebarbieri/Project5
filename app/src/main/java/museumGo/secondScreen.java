package museumGo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
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
            museumPic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(secondScreen.this, thirdScreen.class);
                    intent.putExtra("website", "https://www.metmuseum.org");
                    startActivity(intent);
                }
            });
        }
        else if(selectedMuseum.equals("Museum of Modern Art (MoMA)")){
            museumPic.setImageResource(R.drawable.momapic);
            museum MOMA = new museum(11, 23, 17);
            museumPic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(secondScreen.this, thirdScreen.class);
                    intent.putExtra("website", "https://www.moma.org");
                    startActivity(intent);
                }
            });
        }
        else if(selectedMuseum.equals("American Museum of Natural History")){
            museumPic.setImageResource(R.drawable.historypic);
            museum AMNH = new museum(12, 23, 16);
            museumPic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(secondScreen.this, thirdScreen.class);
                    intent.putExtra("website", "https://www.amnh.org");
                    startActivity(intent);
                }
            });
        }
        else if(selectedMuseum.equals("Intrepid Sea, Air & Space Museum")){
            museumPic.setImageResource(R.drawable.intrepid);
            museum Intrepid = new museum(8, 17, 12);
            museumPic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(secondScreen.this, thirdScreen.class);
                    intent.putExtra("website", "https://m.intrepidmuseum.org");
                    startActivity(intent);
                }
            });
        }


        // Showing the image
        if(museumPic.isShown()){
            System.out.println("It is on screen");
        }
    }

}