package com.example.section06_cardview_reciclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

// Declaración de la clase MainActivity que extiende AppCompatActivity
public class MainActivity extends AppCompatActivity {

    // Declaración de variables miembro
    private List<String> names; // Lista para almacenar nombres
    private RecyclerView mRecyclerView; // RecyclerView para mostrar la lista
    private RecyclerView.Adapter mAdapter; // Adaptador para el RecyclerView
    private RecyclerView.LayoutManager mLayoutManager; // Administrador de diseño para el RecyclerView
    private int count = 0; // Contador para realizar un seguimiento de los nombres agregados
    private Toolbar toolbar; // Barra de herramientas para la actividad

    /**
     * Método que se llama cuando se crea la actividad.
     *
     * @param savedInstanceState La instancia anteriormente guardada si la hubiera.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicialización de la lista de nombres
        names = this.getAllNames(); // Inicializa la lista de nombres llamando al método getAllNames.

        // Configuración de la barra de herramientas
        toolbar = findViewById(R.id.toolbar1); // Encuentra la barra de herramientas en el diseño y la inicializa.
        setSupportActionBar(toolbar); // Configura la barra de herramientas como la barra de la aplicación.

        // Configuración de la acción de clic en la barra de herramientas
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Muestra un mensaje Toast al hacer clic en la barra de herramientas
                Toast.makeText(MainActivity.this, "Probando cosas", Toast.LENGTH_SHORT).show(); // Muestra un mensaje Toast al hacer clic en la barra de herramientas.
            }
        });

        // Configuración del RecyclerView, el adaptador y el administrador de diseño
        mRecyclerView = findViewById(R.id.recyclerView); // Encuentra el RecyclerView en el diseño y lo inicializa.
//        mLayoutManager = new LinearLayoutManager(this); // Inicializa el administrador de diseño como LinearLayoutManager.
//        mLayoutManager = new GridLayoutManager(this,2); // Inicializa el administrador de diseño como GridLayoutManayer, agrego las columnas.
        mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL); // Crea un diseño de cuadrícula escalonada con 2 columnas en orientación vertical.

        mAdapter = new MyAdapter(names, R.layout.recycler_view_item, new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String name, int position) {
                // Elimina el nombre de la lista cuando se hace clic en un elemento del RecyclerView
                deleteName(position); // Llama al método deleteName para eliminar un nombre de la lista en la posición especificada.
            }
        });

        // Configuración del RecyclerView
        // mRecyclerView.setHasFixedSize(true); // Establece que el tamaño del RecyclerView no cambiará durante el ciclo de vida.
        mRecyclerView.setItemAnimator(new DefaultItemAnimator()); // Agrega una animación al RecyclerView.

        // Añadir decoración al RecyclerView
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL); // Crea una decoración de línea divisoria para el RecyclerView.
        mRecyclerView.addItemDecoration(itemDecoration); // Añade la decoración al RecyclerView.

        // Configuración del administrador de diseño y adaptador para el RecyclerView
        mRecyclerView.setLayoutManager(mLayoutManager); // Establece el administrador de diseño para el RecyclerView.
        mRecyclerView.setAdapter(mAdapter); // Establece el adaptador para el RecyclerView.
    }

    /**
     * Método para crear el menú de opciones en la barra de aplicaciones.
     *
     * @param menu El menú en el que se inflarán las opciones del menú.
     * @return Devuelve verdadero para mostrar el menú en la barra de aplicaciones.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater(); // Obtiene un objeto MenuInflater.
        inflater.inflate(R.menu.menu, menu); // Infla el menú de opciones desde XML.
        return true;
    }

    /**
     * Método para manejar eventos de elementos de menú seleccionados.
     *
     * @param item El elemento de menú seleccionado.
     * @return Devuelve verdadero si el evento ha sido manejado, de lo contrario, devuelve el valor devuelto por la superclase.
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.add_item) { // Verifica si el elemento seleccionado es 'add_item'.
            // Agrega un nuevo nombre a la lista y muestra un mensaje Toast
            this.addName(0);
            Toast.makeText(MainActivity.this, "Nuevo item agregado a la lista", Toast.LENGTH_SHORT).show();
            return true; // Indica que el evento ha sido manejado.
        } else if (id == R.id.settings_item) { // Verifica si el elemento seleccionado es 'settings_item'.
            // Muestra un mensaje Toast al hacer clic en el elemento de configuración
            Toast.makeText(this, "Probando", Toast.LENGTH_SHORT).show();
            return true; // Indica que el evento ha sido manejado.
        } else {
            return super.onOptionsItemSelected(item); // Permite que la superclase maneje el evento si no se reconoce el elemento seleccionado.
        }
    }

    /**
     * Método para obtener todos los nombres y agregarlos a una lista
     */
    private List<String> getAllNames() {
        // Crea una lista de nombres y la devuelve
        return new ArrayList<String>() {{
            add("Daniel");
            add("Alejandro");
            add("Luis");
            add("Fernando");
            add("Nicole");
        }};
    }

    /**
     * Método para agregar un nombre a la lista.
     *
     * @param position La posición en la que se agregará el nuevo nombre.
     */
    private void addName(int position) {
        names.add(position, "New name" + (++count)); // Agrega un nuevo nombre a la lista en la posición especificada
        mAdapter.notifyItemInserted(position); // Notifica al adaptador que se ha insertado un elemento en la posición especificada
        mLayoutManager.scrollToPosition(position); // Desplaza el RecyclerView hasta la posición especificada
    }

    /**
     * Método para eliminar un nombre de la lista.
     *
     * @param position La posición del nombre que se eliminará de la lista.
     */
    private void deleteName(int position) {
        names.remove(position); // Elimina un nombre de la lista en la posición especificada
        mAdapter.notifyItemRemoved(position); // Notifica al adaptador que se ha eliminado un elemento de la posición especificada
    }
}
