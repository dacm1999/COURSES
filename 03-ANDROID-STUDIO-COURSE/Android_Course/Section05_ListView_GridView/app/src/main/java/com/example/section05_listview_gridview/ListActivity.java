package com.example.section05_listview_gridview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private List<String> names;
    private ListView listView;
    private MyAdapter myAdapter;
    private Toolbar toolbar;
    private int counter = 0;
    private ImageButton img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //Setting a listView to show to GUI
        listView = findViewById(R.id.listView1);

        //Information to show
        names = new ArrayList<>();
        names.add("Daniel");
        names.add("Luis");
        names.add("Nicole");
        names.add("Mery");
        names.add("Alejandro");
        names.add("Sandra");
        names.add("Miriam");
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(ListActivity.this, "Clicked " + names.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí inicias la actividad MainActivity
                Intent intent = new Intent(ListActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });



        //Enlazamos con nuestro adaptador personalizado:
        myAdapter = new MyAdapter(this, R.layout.activity_list_item, names);
        listView.setAdapter(myAdapter);

        registerForContextMenu(listView);

    }

    /**
     * Infla el menú de opciones en la barra de herramientas.
     * @param menu El menú en el que se inflarán los elementos.
     * @return Devuelve verdadero para mostrar el menú, falso de lo contrario.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater(); // Obtiene un objeto MenuInflater.
        inflater.inflate(R.menu.action_bar_menu, menu); // Infla el menú de opciones desde XML.
        return true; // Devuelve verdadero para mostrar el menú.
    }


    /**
     * Maneja eventos de clic en los elementos del menú de opciones.
     * @param item El elemento de menú de opciones seleccionado.
     * @return Devuelve verdadero si el evento ha sido manejado, falso de lo contrario.
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId(); // Obtiene el ID del elemento de menú seleccionado.
        if (id == R.id.add_item) { // Verifica si el elemento seleccionado es 'add_item'.
            // Añade un nuevo nombre a la lista.
            this.names.add("Added nº" + (++counter));
            // Notifica al adaptador sobre el cambio en los datos.
            this.myAdapter.notifyDataSetChanged();
            // Muestra un mensaje de confirmación.
            Toast.makeText(ListActivity.this, "Nuevo item agregado a la lista", Toast.LENGTH_SHORT).show();

            return true; // Indica que el evento ha sido manejado.
        } else if (id == R.id.settings_item) { // Verifica si el elemento seleccionado es 'settings_item'.
            // Aquí puedes agregar lógica correspondiente al botón de configuración.
            Toast.makeText(this, "Probando", Toast.LENGTH_SHORT).show();
            return true; // Indica que el evento ha sido manejado.
        } else {
            return super.onOptionsItemSelected(item); // Permite que la superclase maneje el evento si no se reconoce el elemento seleccionado.
        }
    }

    /**
     * Crea el menú contextual para elementos específicos en la vista.
     * @param menu El menú contextual que se va a crear.
     * @param view La vista que muestra el menú contextual.
     * @param menuInfo Información específica del menú contextual.
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo); // Llama al método de la superclase para crear el menú contextual.

        MenuInflater inflater = getMenuInflater(); // Obtiene un objeto MenuInflater.

        // Obtén información específica del elemento seleccionado en el menú contextual.
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;

        // Establece el título del menú contextual con el nombre del elemento seleccionado.
        menu.setHeaderTitle(this.names.get(info.position));

        inflater.inflate(R.menu.context_menu, menu); // Infla el menú contextual desde XML.
    }



    /**
     * Este método maneja eventos de selección de elementos en el menú contextual.
     * @param item El elemento del menú contextual seleccionado.
     * @return Devuelve verdadero si el evento ha sido manejado, falso de lo contrario.
     */
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId(); // Obtiene el ID del elemento de menú contextual seleccionado.
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo(); // Obtiene información específica del adaptador del menú contextual.

        if (id == R.id.delete_item) { // Verifica si el elemento seleccionado es el de eliminar.
            // Obtiene el nombre del elemento eliminado.
            String deletedName = names.get(info.position);
            // Elimina el elemento de la lista.
            this.names.remove(info.position);
            // Notifica al adaptador del cambio en los datos.
            this.myAdapter.notifyDataSetChanged();

            // Muestra un mensaje de eliminación con el nombre del elemento eliminado.
            Toast.makeText(this, "Item " + deletedName + " ha sido eliminado", Toast.LENGTH_SHORT).show();
            return true; // Indica que el evento ha sido manejado.
        } else {
            return super.onContextItemSelected(item); // Si no es el elemento de eliminar, permite que la superclase maneje el evento.
        }
    }


}
