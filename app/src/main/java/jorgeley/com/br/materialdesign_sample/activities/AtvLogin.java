package jorgeley.com.br.materialdesign_sample.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.transition.Explode;
import android.view.View;
import android.view.Window;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ProgressBar;
import jorgeley.com.br.materialdesign_sample.R;

/**
 * COMENTÁRIOS EM INGLÊS PARA DAR MAIOR ABRANGÊNCIA
 * Initial Activity: Login Screen
 */
public class AtvLogin extends Activity{
    private AutoCompleteTextView TxtEmail;
    private EditText EdtSenha;
    private LoginTask AtaskLogin = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // enable transitions (for app be more gay)
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.atv_login);
        //Widgets
        this.TxtEmail = (AutoCompleteTextView) findViewById(R.id.email);
        this.EdtSenha = (EditText) findViewById(R.id.password);
        this.PrgLogin = (ProgressBar) findViewById(R.id.PRGlogin);
        //Floating labels (to be much more gay)
        final TextInputLayout textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        textInputLayoutEmail.setHint("User (can be blank)");
        final TextInputLayout textInputLayoutSenha = (TextInputLayout) findViewById(R.id.textInputLayoutSenha);
        textInputLayoutSenha.setHint("Password (can be blank)");
        //floating button for informations
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.info);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "contact-me: jorgeley@gmail.com", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /**
     * setted directly at OnClick of BTNlogin property
     * @param v
     */
    public void onClickLogin(View v) {
        getWindow().setExitTransition(new Explode());
        String email = this.TxtEmail.getText().toString();
        String password = this.EdtSenha.getText().toString();
        this.AtaskLogin = new LoginTask(email, password);
        this.AtaskLogin.execute((Void) null); //here we go!
    }

    /**
     * Simulate a background login
     */
    private ProgressBar PrgLogin;
    public class LoginTask extends AsyncTask<Void, Void, Boolean> {
        private final String email;
        private final String password;

        //constructor
        LoginTask(String email, String password) {
            this.email = email;
            this.password = password;
        }

        @Override
        //before to try do the login
        protected void onPreExecute() {
            PrgLogin.setVisibility(View.VISIBLE);
        }

        @Override
        //doing the login stuff
        protected Boolean doInBackground(Void... params) {
            try { //here we had to do a real login, but my balls are scratching...
                Thread.sleep(500);
                return true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return false;
        }

        @Override
        //after login done (or not)
        protected void onPostExecute(final Boolean successo) {
            PrgLogin.setVisibility(View.GONE);
            if (successo) {
                Snackbar.make(findViewById(R.id.coordinatorLayout), "Welcome " + this.email, Snackbar.LENGTH_LONG).show();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(AtvLogin.this, AtvPrincipal.class));
            } else {
                Snackbar.make(findViewById(R.id.coordinatorLayout), "User and/or passwords invalids", Snackbar.LENGTH_LONG).show();
            }
            AtaskLogin = null;
        }
    }

}