package asociados.paternia.rodriguez.pizzeria.pizzeria;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText user, pas;
    private Button ingreso ,salir;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = (EditText) findViewById(R.id.txtusuario);
        pas = (EditText) findViewById(R.id.txtpassword);
        ingreso = (Button) findViewById(R.id.btningresar);
        salir = (Button) findViewById(R.id.salir);
    }


    public void ingresar(View v) {
        String tusuario, tpassword;
        tusuario = user.getText().toString();
        tpassword = pas.getText().toString();

        if (tusuario.equals("Admin") && tpassword.equals("admin")) {
            Intent i = new Intent(LoginActivity.this, PrincipalPizza.class);
            user.setText("");
            pas.setText("");
            startActivity(i);
            finish();
            Toast.makeText(this, getResources().getString(R.string.success1), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getResources().getString(R.string.errorLogin), Toast.LENGTH_SHORT).show();
            user.setText("");
            pas.setText("");
            user.requestFocus();



        }if (tusuario.equals("User") && tpassword.equals("12345")) {
            Intent i = new Intent(LoginActivity.this, Pedido.class);
            user.setText("");
            pas.setText("");
            startActivity(i);
            finish();
        } else {
            Toast.makeText(this, getResources().getString(R.string.errorLogin), Toast.LENGTH_SHORT).show();
            user.setText("");
            pas.setText("");
            user.requestFocus();

        }
    }
    @Override
    public void onBackPressed() {

    }

    public void salir(View v){
        finish();
    }

}
