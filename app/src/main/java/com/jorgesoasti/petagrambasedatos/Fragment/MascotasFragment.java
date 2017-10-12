package com.jorgesoasti.petagrambasedatos.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jorgesoasti.petagrambasedatos.Adapter.MascotaAdaptador;
import com.jorgesoasti.petagrambasedatos.Pojo.Mascota;
import com.jorgesoasti.petagrambasedatos.Presenter.IMascotasFragmentPresenter;
import com.jorgesoasti.petagrambasedatos.Presenter.MascotaFragmentPresenter;
import com.jorgesoasti.petagrambasedatos.R;

import java.util.ArrayList;

public class MascotasFragment extends Fragment implements IMascotasFragmentView {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    private IMascotasFragmentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_mascotas, container, false);
        rvMascotas = v.findViewById(R.id.rvMascotas);
        presenter = new MascotaFragmentPresenter(this, getContext());
        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        rvMascotas.setAdapter(adaptador);
    }
}
