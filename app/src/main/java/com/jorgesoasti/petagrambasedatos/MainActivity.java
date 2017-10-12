package com.jorgesoasti.petagrambasedatos;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.jorgesoasti.petagrambasedatos.Adapter.PageAdapter;
import com.jorgesoasti.petagrambasedatos.Fragment.*;
import com.jorgesoasti.petagrambasedatos.Fragment.MascotasFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Variables para Fragments
        toolbar = findViewById(R.id.tlbToolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.vpViewPager);

        setUpViewPager();

        if (toolbar != null){
            toolbar.setTitle("");
            setSupportActionBar(toolbar);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
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

            case R.id.actFavoritos:
                startActivity(new Intent(this, MascotasFavoritasActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new MascotasFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.icon_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.icon_pet);
    }
}
