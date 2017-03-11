package com.example.cice.myfragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by cice on 11/3/17.
 */

public class FragmentListado extends Fragment {

    private Libro[] datos= new Libro[]{
        new Libro("Libro 1","Autor 1","Aquí va el resumen del libro 1"),
        new Libro("Libro 2","Autor 2","Aquí va el resumen  del libro 2"),
        new Libro("Libro 3","Autor 3","Aquí va el resumen del libro 3"),
        new Libro("Libro 4","Autor 4","Aquí va el resumen del libro4")
    };

    private ListView listado;

    private MainActivity mainActivity;


    public void setLibrosListener(MainActivity mainActivity){
        this.mainActivity=mainActivity;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listado,container,false);

    }
    //Este método es invocado al crearse la actividad contenedora.
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listado=(ListView)getView().findViewById(R.id.Listado);
        listado.setAdapter(new AdapterLibros(this));
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mainActivity.libroSeleccionado(datos[i]);
            }
        });

    }

    class AdapterLibros extends ArrayAdapter<Libro>{

        Activity context;

        AdapterLibros(Fragment context){
            super(context.getActivity(),R.layout.list_item_libro,datos);
            this.context=context.getActivity();
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View item= null;
            LayoutInflater inflater=context.getLayoutInflater();
            item=inflater.inflate(R.layout.list_item_libro,null);
            TextView tvTitulo=(TextView)item.findViewById(R.id.TxtTitulo);
            TextView tvAutor=(TextView)item.findViewById(R.id.TxtAutor);
            tvTitulo.setText(datos[position].getTitulo());
            tvAutor.setText(datos[position].getAutor());
            return item;
        }




    }



}
