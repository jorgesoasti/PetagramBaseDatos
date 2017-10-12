package com.jorgesoasti.petagrambasedatos.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jorgesoasti.petagrambasedatos.BD.ConstructorMascota;
import com.jorgesoasti.petagrambasedatos.Pojo.Mascota;
import com.jorgesoasti.petagrambasedatos.R;

import java.util.ArrayList;

/**
 * Created by jorge.soasti on 10/10/2017.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);

        holder.imgMascota.setImageResource(mascota.getFoto());
        holder.tvNombre.setText(mascota.getNombre());
        holder.tvLikes.setText(String.valueOf(mascota.getLikes()));

        holder.btnLikeBlanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Te gustó " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                ConstructorMascota constructorMascotas = new ConstructorMascota(activity);
                constructorMascotas.darLikeMascota(mascota);
                holder.tvLikes.setText(String.valueOf(constructorMascotas.obtenerLikesMascota(mascota)));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgMascota;
        private TextView tvNombre;
        private TextView tvLikes;
        private ImageButton btnLikeBlanco;
        private ImageButton btnLikeAmarillo;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgMascota = itemView.findViewById(R.id.imgFotoMacota);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvLikes = itemView.findViewById(R.id.tvLikes);
            btnLikeBlanco = itemView.findViewById(R.id.btnLikeBlanco);
            btnLikeAmarillo = itemView.findViewById(R.id.btnLikeAmarillo);
        }
    }
}
