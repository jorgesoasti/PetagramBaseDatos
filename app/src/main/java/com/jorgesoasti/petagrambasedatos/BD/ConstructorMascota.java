package com.jorgesoasti.petagrambasedatos.BD;

import android.content.ContentValues;
import android.content.Context;

import com.jorgesoasti.petagrambasedatos.Pojo.Mascota;
import com.jorgesoasti.petagrambasedatos.R;

import java.util.ArrayList;

/**
 * Created by jorge.soasti on 10/10/2017.
 */

public class ConstructorMascota {
    private static final int LIKE = 1;
    private Context context;

    public ConstructorMascota(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){

        BaseDatos db = new BaseDatos(context);
        insertarOchoMascotas(db);
        return db.obtenerTodasMascotas();
    }

    public void insertarOchoMascotas(BaseDatos db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_NOMBRE, "Aisha");
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.aisha);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_NOMBRE, "Amy");
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.amy);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_NOMBRE, "Bernard");
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.bernard);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_NOMBRE, "Bernie");
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.bernie);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_NOMBRE, "Clara");
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.clara);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_NOMBRE, "Coty");
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.coty);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_NOMBRE, "Keyla");
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.keyla);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_NOMBRE, "Tom");
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.tom);

        db.insertarMascota(contentValues);
    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_LIKE_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstanteBaseDatos.TABLE_LIKE_MASCOTA_NO_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }

    public void eliminarTablasDB(){
        BaseDatos db = new BaseDatos(context);
        db.eliminarTablasDB();
    }

    public ArrayList<Mascota> obtenerRankingMacotas(){

        BaseDatos db = new BaseDatos(context);
        return db.obtenerRankingMascotas();
    }
}
