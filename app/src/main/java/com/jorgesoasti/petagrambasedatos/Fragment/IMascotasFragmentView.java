package com.jorgesoasti.petagrambasedatos.Fragment;

import com.jorgesoasti.petagrambasedatos.Adapter.MascotaAdaptador;
import com.jorgesoasti.petagrambasedatos.Pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by jorge.soasti on 12/10/2017.
 */

public interface IMascotasFragmentView {
    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
