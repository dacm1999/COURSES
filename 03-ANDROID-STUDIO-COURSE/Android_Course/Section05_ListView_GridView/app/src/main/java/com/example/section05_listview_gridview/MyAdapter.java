package com.example.section05_listview_gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<String> names;

    public MyAdapter(Context context, int layout, List<String> names) {
        this.context = context;
        this.layout = layout;
        this.names = names;
    }


    /**
     * Devuelve la cantidad total de elementos en la lista que se va a mostrar en la vista.
     * @return El número total de elementos en la lista.
     */
    @Override
    public int getCount() {
        return names.size(); // Debes devolver el número de elementos en la lista de datos que se está utilizando en el adaptador.
    }

    /**
     * Devuelve el objeto de datos en la posición especificada en la lista de elementos.
     * @param position La posición del elemento que se va a recuperar.
     * @return El objeto de datos en la posición especificada.
     */
    @Override
    public Object getItem(int position) {
        return names.get(position); // Debes devolver el objeto de datos en la posición 'i' de la lista de datos que se está utilizando en el adaptador.
    }

    /**
     * Devuelve un identificador único para el elemento en la posición especificada.
     * @param id La posición del elemento para la cual se necesita el identificador.
     * @return Un identificador único para el elemento en la posición especificada.
     */
    @Override
    public long getItemId(int id) {
        return 0; // En general, este método se utiliza para proporcionar un identificador único para el elemento en la posición 'i' en la lista de datos.
    }

    /**
     * Devuelve la vista que representa un elemento en la posición especificada en la lista.
     * @param position La posición del elemento que se va a representar.
     * @param convertView La vista que se está reutilizando o nula si no hay una vista disponible para reutilizar.
     * @param viewGroup El grupo de vistas al que pertenece la vista.
     * @return La vista que representa el elemento en la posición especificada.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        //View Holder Pattern
        ViewHolder holder;

        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(this.context); //Inflamos la vista que nos ha llegado con nuestro layout
            convertView = layoutInflater.inflate(this.layout,null);

            holder = new ViewHolder();
            //Referenciamos el objeto a modificar y lo rellenamos
            holder.nameTextView = convertView.findViewById(R.id.txv1);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        String currentName = names.get(position); //Nos traemos el valor actual dependiente de la posicion
//        currentName = (String) getItem(position);

        //Referenciamos el elemento a modificar
        holder.nameTextView.setText(currentName);

        //Devolvemos la vista inflada y modificada
        return convertView; // Aquí es donde debes inflar y personalizar la vista para representar los datos en la posición 'i' de la lista de datos. Debes devolver la vista que se utilizará para mostrar el elemento en la posición especificada.
    }

    static class ViewHolder{
        private TextView nameTextView;

    }

}
