package com.jorgesoasti.petagrambasedatos.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jorgesoasti.petagrambasedatos.Adapter.PerfilAdaptador;
import com.jorgesoasti.petagrambasedatos.Pojo.Mascota;
import com.jorgesoasti.petagrambasedatos.R;

import java.util.ArrayList;

public class PerfilFragment extends Fragment {
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    public PerfilAdaptador adaptador;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        listaMascotas = v.findViewById(R.id.rvFotosPerfil);

        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);

        //LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        //llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(glm);

        inicializarFotosPerfilMascotas();

        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador(){
        adaptador = new PerfilAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarFotosPerfilMascotas(){

        mascotas = new ArrayList<>();

        mascotas.add(new Mascota(R.drawable.beagle1,"Aisha", 40));
        mascotas.add(new Mascota(R.drawable.beagle2,"Amy", 27));
        mascotas.add(new Mascota(R.drawable.beagle3,"Bernard", 5));
        mascotas.add(new Mascota(R.drawable.beagle4,"Bernie", 20));
        mascotas.add(new Mascota(R.drawable.beagle5,"Clara", 15));
        mascotas.add(new Mascota(R.drawable.beagle6,"Coty", 22));
        mascotas.add(new Mascota(R.drawable.beagle1,"Keyla", 35));
        mascotas.add(new Mascota(R.drawable.beagle2,"Tom", 29));
        mascotas.add(new Mascota(R.drawable.beagle3,"Clara", 15));
    }
}
