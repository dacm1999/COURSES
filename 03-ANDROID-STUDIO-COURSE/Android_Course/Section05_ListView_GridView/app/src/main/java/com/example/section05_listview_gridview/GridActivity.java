package com.example.section05_listview_gridview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity {

    private List<String> names;
    private GridView gridView;

    private MyAdapter myAdapter;
    private int counter =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        gridView = findViewById(R.id.gridView1);


        //Information to show
        names = new ArrayList<String>();
        names.add("Daniel");
        names.add("Luis");
        names.add("Nicole");
        names.add("Mery");
        names.add("Alejandro");
        names.add("Fernando");
        names.add("Leni");
        names.add("Sandra");
        names.add("Miriam");
        names.add("Jorge");
        names.add("Isaac");
        names.add("Antonella");
        names.add("José");
        names.add("Marianela");

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(GridActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        //Enlazamos con nuestor adaptador personalizado:
        myAdapter = new MyAdapter(this, R.layout.activity_list_item, names);
        gridView.setAdapter(myAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu,menu);
        return true;
    }

/*    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                // Añadimos nuevo nombre
                this.names.add("Added nº" + (++counter));
                // Notificamos al adaptador del cambio producido
                this.myAdapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/
}