/**
 * @author Arya Kulkarni and Jesse Barbieri
 */
package museumGo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * MainActivity class sets the first screen of the app
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Override onCreate sets what is displayed on the screen and functionality
     * @param savedInstanceState saved Instance State
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView list = findViewById(R.id.list);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(getString(R.string.metName));
        arrayList.add(getString(R.string.moma));
        arrayList.add(getString(R.string.americanHistory));
        arrayList.add(getString(R.string.intrepid));
        setTitle(R.string.mainTitle);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        list.setAdapter(arrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             * When a listView item is selected we pass the selection to the second screen
             * @param parent adapter view
             * @param view view
             * @param position position
             * @param id id
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedItem =(String) list.getItemAtPosition(position);

                // Creates the intent for the second activity to open and opens it when option clicked
                Intent intent = new Intent(MainActivity.this, secondScreen.class);
                intent.putExtra("selectedMuseum", clickedItem);
                startActivity(intent);

            }
        });
    }
}