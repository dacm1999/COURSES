package com.example.section06_cardview_reciclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// https://developer.android.com/guide/topics/ui/layout/recyclerview?hl=es-419

/**
 * Clase adaptadora para un RecyclerView personalizado que muestra una lista de nombres.
 * Configura vistas individuales y maneja la interacción del usuario.
 * El adaptador usa una interfaz de escucha para reaccionar a eventos de clic.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<String> names; // Lista de nombres a mostrar.
    private int layout; // Diseño de elementos para el RecyclerView.
    private OnItemClickListener itemClickListener; // Escucha de eventos de clic.

    /**
     * Constructor de la clase MyAdapter.
     * @param names Lista de nombres a mostrar en el RecyclerView.
     * @param layout Diseño de elementos para el RecyclerView.
     * @param listener Escucha de eventos de clic en los elementos del RecyclerView.
     */
    public MyAdapter(List<String> names, int layout, OnItemClickListener listener) {
        this.names = names;
        this.layout = layout;
        this.itemClickListener = listener;
    }

    /**
     * Step 1
     * Devuelve el número de elementos en la lista.
     * @return El número de elementos en la lista.
     */
    @Override
    public int getItemCount() {
        return names.size();
    }

    /**
     * Step 2
     * Crea nuevas vistas (invocado por el administrador de diseño del RecyclerView).
     * @param parent El ViewGroup en el que se añadirá la nueva Vista después de que se vincule a una posición de adaptador.
     * @param viewType El tipo de vista de la nueva Vista.
     * @return Una nueva instancia de ViewHolder.
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return  vh;
    }

    /**
     * Reemplaza el contenido de una vista (invocado por el administrador de diseño del RecyclerView).
     * @param holder El ViewHolder que debe actualizarse para representar el contenido del elemento en la posición dada en el conjunto de datos.
     * @param position La posición del elemento dentro del conjunto de datos del adaptador.
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(names.get(position), itemClickListener); // Enlaza el nombre en la posición actual con el ViewHolder y el listener.
    }

    /**
     * Clase ViewHolder que representa cada elemento en el RecyclerView.
     * Administra las vistas individuales y su interacción con el usuario.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewName; // Vista de texto para mostrar el nombre.

        /**
         * Constructor de la clase ViewHolder.
         * @param itemView La vista raíz que representa cada elemento en el RecyclerView.
         */
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.textViewName); // Inicializa la vista de texto.
        }

        /**
         * Método para vincular el nombre con la vista y establecer un listener de clic.
         * @param name Nombre a mostrar en la vista.
         * @param listener Listener de eventos de clic.
         */
        public void bind(final String name, final OnItemClickListener listener){
            this.textViewName.setText(name); // Establece el texto en la vista.
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(name, getBindingAdapterPosition()); // Llama a la interfaz de escucha al hacer clic.
                }
            });
        }
    }

    /**
     * Interfaz para gestionar eventos de clic en los elementos del RecyclerView.
     */
    public interface OnItemClickListener{
        void onItemClick(String name, int position); // Método para manejar eventos de clic en los elementos del RecyclerView.
    }
}
