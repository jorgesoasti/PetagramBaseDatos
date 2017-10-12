package com.jorgesoasti.petagrambasedatos.Presenter;

import android.content.Context;

import com.jorgesoasti.petagrambasedatos.BD.ConstructorMascota;
import com.jorgesoasti.petagrambasedatos.Fragment.IMascotasFragmentView;
import com.jorgesoasti.petagrambasedatos.Pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by jorge.soasti on 12/10/2017.
 */

public class MascotaFragmentPresenter implements IMascotasFragmentPresenter {

    private IMascotasFragmentView iMascotasFragmentView;
    private Context context;
    private ConstructorMascota constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public MascotaFragmentPresenter(IMascotasFragmentView iMascotasFragmentView, Context context) {
        this.iMascotasFragmentView = iMascotasFragmentView;
        this.context = context;
        //eliminarDatos();
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascota(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iMascotasFragmentView.inicializarAdaptadorRV(iMascotasFragmentView.crearAdaptador(mascotas));
        iMascotasFragmentView.generarLinearLayoutVertical();
    }

    @Override
    public void eliminarDatos() {
      constructorMascotas.eliminarTablasDB();
    }
}
