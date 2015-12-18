package jorgeley.com.br.materialdesign_sample.activities;

import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;

import jorgeley.com.br.materialdesign_sample.R;

/**
 * COMENTÁRIOS EM INGLÊS PARA DAR MAIOR ABRANGÊNCIA
 * Activity to show a specific product
 */
public class AtvProduto extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.atv_produto);
        //floating button just simulating adding to the kart
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "added to the kart", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
