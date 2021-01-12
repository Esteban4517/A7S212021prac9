package mx.edu.tesoem.isc.rjae.a7s212021prac9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Adaptadorbase extends BaseAdapter {

    List<Datos> =new ArrayList<>();
    Context context;

    public Adaptadorbase(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return datos.size();
    }

    @Override
    public Object getItem(int position) {
        return datos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.activity_elemento, null);

        }
        TextView txtnombre = convertView.findViewById(R.id.elblNombre);
        Datos dato = datos.get(position);
        lblnombre.setText(dato.getNombre());
        return convertView;
    }
}

