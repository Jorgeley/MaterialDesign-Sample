package jorgeley.com.br.materialdesign_sample.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
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
import jorgeley.com.br.materialdesign_sample.beans.Produto;
import jorgeley.com.br.materialdesign_sample.classes.ProdutoAdapter;

/**
 * COMENTÁRIOS EM INGLÊS PARA DAR MAIOR ABRANGÊNCIA
 * Activity to show a list of products
 * most of the code is repeated, but this project is just a sample of Material Design, not commertial
 */
public class AtvProdutos extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // enable transitions (for app to be more gay)
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.atv_produtos);
        //floating button just simulating adding to the kart
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "show the kart", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //actionbar with toolbar. I know, i know, the code is repeated on activity AtvPrincipal, is because my balls...
        this.drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarProduto);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, this.drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        this.drawer.setDrawerListener(toggle);
        toggle.syncState();
        //navigation view with some common options
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //recycler view with products
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerviewProdutos);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        //adding some static products to recycler view
        List<Produto> produtos = new ArrayList<>();
        Produto produto1 = new Produto();
        produto1.setId(1);
        produto1.setNome("colar");
        produto1.setPreco(10.99);
        produto1.setImg(R.drawable.colar_144x144);
        produtos.add(produto1);
        Produto produto2 = new Produto();
        produto2.setId(2);
        produto2.setNome("tapeware");
        produto2.setPreco(9.99);
        produto2.setImg(R.drawable.tapeware_144x144);
        produtos.add(produto2);
        Produto produto3 = new Produto();
        produto3.setId(3);
        produto3.setNome("perfume");
        produto3.setPreco(1.99);
        produto3.setImg(R.drawable.perfume_144x144);
        produtos.add(produto3);
        Produto produto4 = new Produto();
        produto4.setId(4);
        produto4.setNome("dvd");
        produto4.setPreco(199.99);
        produto4.setImg(R.drawable.dvd_144x144);
        produtos.add(produto4);
        mAdapter = new ProdutoAdapter(produtos);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            //getting the gesture, because i want to scroll the recycler view and open another activity when tapped, i know the code is repeated
            final GestureDetector mGestureDetector = new GestureDetector(AtvProdutos.this, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

            });

            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                if (mGestureDetector.onTouchEvent(e)) {
                    startActivity(new Intent(AtvProdutos.this, AtvProduto.class));
                    return true;
                } else
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
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    //the code is repeated, i know
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