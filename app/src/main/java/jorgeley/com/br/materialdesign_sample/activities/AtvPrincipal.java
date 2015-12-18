package jorgeley.com.br.materialdesign_sample.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import java.util.ArrayList;
import java.util.List;
import jorgeley.com.br.materialdesign_sample.R;
import jorgeley.com.br.materialdesign_sample.beans.Marca;
import jorgeley.com.br.materialdesign_sample.classes.MarcaAdapter;

/**
 * COMENTÁRIOS EM INGLÊS PARA DAR MAIOR ABRANGÊNCIA
 * Main Activity: List the brands
 */

public class AtvPrincipal extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // enable transitions (for app be more gay)
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.atv_principal);
        //actionbar with toolbar. I know, i know, the code is repeated on activity AtvProdutos, is because my balls...
        this.drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, this.drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        this.drawer.setDrawerListener(toggle);
        toggle.syncState();
        //navigation view with some common options
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //recycler view with brands
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerviewProdutos);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        //adding some static brands to recycler view
        List<Marca> marcas = new ArrayList<>();
        Marca marca1 = new Marca();
        marca1.setId(1);
        marca1.setNome("Natura");
        marca1.setLogo(R.drawable.natura_144x144);
        marcas.add(marca1);
        Marca marca2 = new Marca();
        marca2.setId(2);
        marca2.setNome("Jequiti");
        marca2.setLogo(R.drawable.jequiti_144x144);
        marcas.add(marca2);
        Marca marca3 = new Marca();
        marca3.setId(3);
        marca3.setNome("Natura");
        marca3.setLogo(R.drawable.natura_144x144);
        marcas.add(marca3);
        Marca marca4 = new Marca();
        marca4.setId(4);
        marca4.setNome("Jequiti");
        marca4.setLogo(R.drawable.jequiti_144x144);
        marcas.add(marca4);
        //the adapter of brands to be set on recycler view
        mAdapter = new MarcaAdapter(marcas);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            //getting the gesture, because i want to scroll the recycler view and open another activity when tapped
            final GestureDetector mGestureDetector = new GestureDetector(AtvPrincipal.this, new GestureDetector.SimpleOnGestureListener() {
                @Override public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

            });

            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                if (mGestureDetector.onTouchEvent(e)) {
                    startActivity(new Intent(AtvPrincipal.this, AtvProdutos.class));
                    return true;
                }else
                    return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) { }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) { }
        });
    }

    @Override
    public void onBackPressed() {
        if (this.drawer.isDrawerOpen(GravityCompat.START)) {
            this.drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    //here we had to do some actions to the navigation view options, but my balls...
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.nav_camera:
            case R.id.nav_gallery:
            case R.id.nav_slideshow:
            case R.id.nav_manage:
            case R.id.nav_share:
        }
        this.drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}