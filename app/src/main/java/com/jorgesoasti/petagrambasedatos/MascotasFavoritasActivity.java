package com.jorgesoasti.petagrambasedatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.jorgesoasti.petagrambasedatos.Adapter.MascotaAdaptador;
import com.jorgesoasti.petagrambasedatos.BD.ConstructorMascota;
import com.jorgesoasti.petagrambasedatos.Pojo.Mascota;

import java.util.ArrayList;

public class MascotasFavoritasActivity extends AppCompatActivity {

    private Toolbar toolbar;

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    public MascotaAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        rvMascotas = findViewById(R.id.rvMascotasFav);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(llm);
        obtenerRankingMascotas();
        inicializarAdaptador();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones_fav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.mAbout:
                Intent intent = new Intent(this, ActivityBioDesarrollador.class);
                startActivity(intent);
                break;

            case R.id.mContacto:
                Intent i = new Intent(this, ActivityContactos.class);
                startActivity(i);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas, this);
        rvMascotas.setAdapter(adaptador);
    }

    public void obtenerRankingMascotas() {
        ConstructorMascota constructorMascotas = new ConstructorMascota(this);
        mascotas = constructorMascotas.obtenerRankingMacotas();
    }
}
