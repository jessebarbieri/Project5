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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView list = findViewById(R.id.list);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("The Metropolitan Museum of Art");
        arrayList.add("Museum of Modern Art (MoMA)");
        arrayList.add("American Museum of Natural History");
        arrayList.add("Intrepid Sea, Air & Space Museum");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        list.setAdapter(arrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedItem =(String) list.getItemAtPosition(position);
                //Toast.makeText(MainActivity.this,clickedItem,Toast.LENGTH_LONG).show();

                // Creates the intent for the second activity to open and opens it when option clicked
                Intent intent = new Intent(MainActivity.this, secondScreen.class);
                intent.putExtra("selectedMuseum", clickedItem);
                startActivity(intent);

            }
        });
    }
}