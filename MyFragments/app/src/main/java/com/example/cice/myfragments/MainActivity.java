package com.example.cice.myfragments;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm=getSupportFragmentManager();
        FragmentListado fmListado=(FragmentListado)fm.findFragmentById(R.id.fragmentListado);
        fmListado.setLibrosListener(this);

    }

    public void libroSeleccionado(Libro libro){
          //Llevar el detalle del libro al FragmentDetalle.
        FragmentManager fm=getSupportFragmentManager();
        FragmentDetalle fmDetalle=(FragmentDetalle)fm.findFragmentById(R.id.fragmentDetalle);
        fmDetalle.mostrarDetalle(libro.getResumen());

    }

}
