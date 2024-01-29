package com.example.section06_cardview_reciclerview.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.section06_cardview_reciclerview.Adapters.MyAdapter2;
import com.example.section06_cardview_reciclerview.Models.Movie;
import com.example.section06_cardview_reciclerview.R;

import java.util.ArrayList;
import java.util.List;

public class CardView extends AppCompatActivity {

    private List<Movie> movies;

    private RecyclerView mRecyclerView;
    // Puede ser declarado como 'RecyclerView.Adapter' o como nuetra clase adaptador 'MyAdapter'
    private RecyclerView.Adapter myAdapter2;
    private RecyclerView.LayoutManager mLayoutManager;
    private Toolbar toolbar;

    private int counter = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movies = this.getAllMovies();

        toolbar = findViewById(R.id.toolbar1); // Encuentra la barra de herramientas en el diseño y la inicializa.
        setSupportActionBar(toolbar); // Configura la barra de herramientas como la barra de la aplicación.
        mRecyclerView = findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(CardView.this, MainActivity.class);
                startActivity(intent);
            }
        });

        myAdapter2 = new MyAdapter2(movies, R.layout.recycler_view_item2, new MyAdapter2.OnItemClickListener() {
            @Override
            public void onItemClick(Movie movie, int position) {
                removeMovie(position);
            }
        });



        // Lo usamos en caso de que sepamos que el layout no va a cambiar de tamaño, mejorando la performance
        mRecyclerView.setHasFixedSize(true);
        // Añade un efecto por defecto, si le pasamos null lo desactivamos por completo
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        // Enlazamos el layout manager y adaptor directamente al recycler view
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(myAdapter2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.add_item) { // Verifica si el elemento seleccionado es 'add_item'.
            // Agrega un nuevo nombre a la lista y muestra un mensaje Toast
            this.addMovie(0);
            return true; // Indica que el evento ha sido manejado.
        } else {
            return super.onOptionsItemSelected(item); // Permite que la superclase maneje el evento si no se reconoce el elemento seleccionado.
        }
    }

    private List<Movie> getAllMovies() {
        return new ArrayList<Movie>() {{
            add(new Movie("Terminartor", R.drawable.terminator));
            add(new Movie("Dragon Ball Super", R.drawable.dbz_super));
            add(new Movie("Attack on Titans", R.drawable.aot));
            add(new Movie("The lord of the rings", R.drawable.lord_of_rings));
        }};
    }

    private void addMovie(int position) {
        movies.add(position, new Movie("New image " , + R.drawable.empty +(++counter)));
        // Notificamos de un nuevo item insertado en nuestra colección
        myAdapter2.notifyItemInserted(position);
        // Hacemos scroll hacia lo posición donde el nuevo elemento se aloja
        mLayoutManager.scrollToPosition(position);
    }

    private void removeMovie(int position) {
        movies.remove(position);
        // Notificamos de un item borrado en nuestra colección
        myAdapter2.notifyItemRemoved(position);
    }
}