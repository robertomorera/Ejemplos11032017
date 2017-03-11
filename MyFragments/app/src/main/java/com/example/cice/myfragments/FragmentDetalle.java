package com.example.cice.myfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by cice on 11/3/17.
 */

public class FragmentDetalle extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Inflamos el layout del fragment de detalle.
        return inflater.inflate(R.layout.fragment_detale,container,false);
    }

    public void mostrarDetalle(String resumen){
        TextView tvDetalle=(TextView)getView().findViewById(R.id.TxtDetalle);
        tvDetalle.setText(resumen);
    }


}
