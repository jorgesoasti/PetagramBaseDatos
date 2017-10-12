package com.jorgesoasti.petagrambasedatos.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jorgesoasti.petagrambasedatos.Pojo.Mascota;
import com.jorgesoasti.petagrambasedatos.R;

import java.util.ArrayList;

/**
 * Created by jorge.soasti on 12/10/2017.
 */

public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.PerfilViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public PerfilAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public PerfilAdaptador.PerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil_mascota, parent, false); //Indica cual es el Layout que estará reciclando el RecyclerView
        return new PerfilViewHolder(v); //Pasar el View al constructor
    }

    @Override
    public void onBindViewHolder(PerfilAdaptador.PerfilViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);

        holder.imgMascota.setImageResource(mascota.getFoto());
        holder.tvLikes.setText(String.valueOf(mascota.getLikes()));
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class PerfilViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgMascota;
        private TextView tvLikes;

        public PerfilViewHolder(View itemView) {
            super(itemView);
            imgMascota = itemView.findViewById(R.id.imgFotoMacota);
            tvLikes = itemView.findViewById(R.id.tvLikes);
        }
    }
}
