package museumGo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
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
    TextView textViewAdult;
    TextView textViewSenior;
    TextView totalBox;
    TextView priceTaxless;
    TextView salesTax;
    Toast warnings;

    museum M;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
        Intent getdata = getIntent();
        selectedMuseum = getdata.getStringExtra("selectedMuseum");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Ticket Price Calculator");

        Toast.makeText(secondScreen.this, R.string.maxWarning, Toast.LENGTH_SHORT).show();
        museumPic = (ImageView) findViewById(R.id.museumPic);

        ((TextView) findViewById(R.id.textViewStudent)).setText("0");
        textViewStudent = ((TextView) findViewById(R.id.textViewStudent));
        textViewStudent.setText("0");

        textViewAdult = ((TextView) findViewById(R.id.textViewAdult));
        textViewAdult.setText("0");

        textViewSenior = ((TextView) findViewById(R.id.textViewSenior));
        textViewSenior.setText("0");

        switch (selectedMuseum) {

            case "Museum of Modern Art (MoMA)":
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


                break;
            case "American Museum of Natural History":
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


                break;
            case "Intrepid Sea, Air & Space Museum":
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


                break;
            case "The Metropolitan Museum of Art":
                museumPic.setImageResource(R.drawable.metpic);
                M = new museum(10, 20, 15);
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

                break;
        }
        TextView selectedShow = (TextView) findViewById(R.id.selectedShow);
        selectedShow.setText(selectedMuseum);
        TextView studentView = (TextView)findViewById(R.id.studentView);
        studentView.setText("$" + M.ticketPriceSt());
        TextView adultView = (TextView)findViewById(R.id.adultView);
        adultView.setText("$" + M.ticketPriceA());
        TextView seniorView = (TextView)findViewById(R.id.seniorView);
        seniorView.setText("$" + M.ticketPriceS());
    }

    /**
     * Subtract 1 from Student ticket total
     *
     * @param v
     */
    public void onClickMinusStudent(View v) {

        try {
            int tic = Integer.parseInt(textViewStudent.getText().toString());

            if (tic == 0) {
                warnings.makeText(this, R.string.minusWarning, Toast.LENGTH_SHORT).show();
            } else {
                int val = M.removeTicket(tic, "Student");
                textViewStudent.setText(String.valueOf(val));
            }
            totalBox = ((TextView) findViewById(R.id.totalBox));
            totalBox.setText("$ " + String.valueOf(M.totalPrice()));
            priceTaxless = ((TextView) findViewById(R.id.priceTaxless));
            priceTaxless.setText("$ " + String.valueOf(M.totalNoTax()));
            salesTax = ((TextView) findViewById(R.id.salesTax));
            salesTax.setText("$ " + String.valueOf(M.getSalesTax()));


        } catch (NullPointerException e) {
            warnings.makeText(this, R.string.nullPointE, Toast.LENGTH_LONG).show();
        }

    }

    /**
     * Increase 1 ticket for student
     *
     * @param v
     */
    public void onClickAddStudent(View v) {
        try {
            int tic = Integer.parseInt(textViewStudent.getText().toString());
            int max = 5;

               if (tic >= 5){
                   warnings.makeText(this, R.string.maxReached, Toast.LENGTH_SHORT).show();
               }else {

                   int val = M.addTicket(tic, "Student");
                   textViewStudent.setText(String.valueOf(val));
               }
            totalBox = ((TextView) findViewById(R.id.totalBox));
            totalBox.setText("$ " + String.valueOf(M.totalPrice()));
            priceTaxless = ((TextView) findViewById(R.id.priceTaxless));
            priceTaxless.setText("$ " + String.valueOf(M.totalNoTax()));
            salesTax = ((TextView) findViewById(R.id.salesTax));
            salesTax.setText("$ " + String.valueOf(M.getSalesTax()));

        } catch (NullPointerException e) {
            warnings.makeText(this, R.string.nullPointE, Toast.LENGTH_LONG).show();
        }
    }


    /**
     * Subtract 1 from Student ticket total
     *
     * @param v
     */
    public void onClickMinusAdult(View v) {

        try {
            int tic = Integer.parseInt(textViewAdult.getText().toString());

            if (tic == 0) {
                warnings.makeText(this, R.string.minusWarning, Toast.LENGTH_SHORT).show();
            }else {
                int val = M.removeTicket(tic, "Adult");
                textViewAdult.setText(String.valueOf(val));
            }
            totalBox = ((TextView) findViewById(R.id.totalBox));
            totalBox.setText("$ " + String.valueOf(M.totalPrice()));
            priceTaxless = ((TextView) findViewById(R.id.priceTaxless));
            priceTaxless.setText("$ " + String.valueOf(M.totalNoTax()));
            salesTax = ((TextView) findViewById(R.id.salesTax));
            salesTax.setText("$ " + String.valueOf(M.getSalesTax()));

        } catch (NullPointerException e) {
            Toast.makeText(this, R.string.nullPointE, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Decrease 1 ticket for student
     *
     * @param v
     */
    public void onClickAddAdult(View v) {
        try {
            int tic = Integer.parseInt(textViewAdult.getText().toString());
            int max = 5;

            if (tic >= 5){
                warnings.makeText(this, R.string.maxReached, Toast.LENGTH_SHORT).show();
            }else {

                int val = M.addTicket(tic, "Adult");
                textViewAdult.setText(String.valueOf(val));
            }
            totalBox = ((TextView) findViewById(R.id.totalBox));
            totalBox.setText("$ " + String.valueOf(M.totalPrice()));
            priceTaxless = ((TextView) findViewById(R.id.priceTaxless));
            priceTaxless.setText("$ " + String.valueOf(M.totalNoTax()));
            salesTax = ((TextView) findViewById(R.id.salesTax));
            salesTax.setText("$ " + String.valueOf(M.getSalesTax()));

        } catch (NullPointerException e) {
            warnings.makeText(this, R.string.nullPointE, Toast.LENGTH_LONG).show();
        }
    }


    /**
     * Subtract 1 from Senior ticket total
     *
     * @param v
     */
    public void onClickMinusSenior(View v) {

        try {
            int tic = Integer.parseInt(textViewSenior.getText().toString());

            if (tic == 0) {
                warnings.makeText(this, R.string.minusWarning, Toast.LENGTH_SHORT).show();
            } else {
                int val = M.removeTicket(tic, "Senior");
                textViewSenior.setText(String.valueOf(val));
            }
            totalBox = ((TextView) findViewById(R.id.totalBox));
            totalBox.setText("$ " + String.valueOf(M.totalPrice()));
            priceTaxless = ((TextView) findViewById(R.id.priceTaxless));
            priceTaxless.setText("$ " + String.valueOf(M.totalNoTax()));
            salesTax = ((TextView) findViewById(R.id.salesTax));
            salesTax.setText("$ " + String.valueOf(M.getSalesTax()));

        } catch (NullPointerException e) {
            warnings.makeText(this, R.string.nullPointE, Toast.LENGTH_LONG).show();
        }

    }

    /**
     * Increase 1 ticket for Senior
     *
     * @param v
     */
    public void onClickAddSenior(View v) {
        try {
            int tic = Integer.parseInt(textViewSenior.getText().toString());
            int zero = 0;
            int max = 5;

            if (tic >= 5){
                warnings.makeText(this, R.string.maxReached, Toast.LENGTH_SHORT).show();
            }else {
                int val = M.addTicket(tic, "Senior");
                textViewSenior.setText(String.valueOf(val));
            }
            totalBox = ((TextView) findViewById(R.id.totalBox));
            totalBox.setText("$ " + String.valueOf(M.totalPrice()));
            priceTaxless = ((TextView) findViewById(R.id.priceTaxless));
            priceTaxless.setText("$ " + String.valueOf(M.totalNoTax()));
            salesTax = ((TextView) findViewById(R.id.salesTax));
            salesTax.setText("$ " + String.valueOf(M.getSalesTax()));

        } catch (NullPointerException e) {
            warnings.makeText(this, R.string.nullPointE, Toast.LENGTH_LONG).show();
        }
    }

}