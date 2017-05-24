package asociados.paternia.rodriguez.pizzeria.pizzeria;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.*;
import java.security.Principal;

public class LoginActivity extends AppCompatActivity {
    private EditText user, pas;
    private Button ingreso;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = (EditText)findViewById(R.id.txtusuario);
        pas = (EditText)findViewById(R.id.txtpassword);
        ingreso = (Button)findViewById(R.id.btningresar);
    }



    public void ingresar (View v){
        String tusuario, tpassword;
        tusuario = user.getText().toString();
        tpassword = pas.getText().toString();

        if(tusuario.equals("admin") && tpassword.equals("admin") ){
            Intent i = new Intent(LoginActivity.this, vacio.class);
            user.setText("");
            pas.setText("");
            startActivity(i);
            finish();
        }else{
            Toast.makeText(this, getResources().getString(R.string.errorLogin), Toast.LENGTH_SHORT).show();
            user.setText("");
            pas.setText("");
            user.requestFocus();
        }
    }

}
