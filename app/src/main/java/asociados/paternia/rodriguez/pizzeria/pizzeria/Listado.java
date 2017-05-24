package asociados.paternia.rodriguez.pizzeria.pizzeria;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class Listado extends AppCompatActivity {
    private ListView lstPersonalizado;
    private ArrayList<Pizza> pizzas;
    private AdaptadorPizza adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        lstPersonalizado = (ListView)findViewById(R.id.lstListado);
        pizzas = Datos.traerPizzas(getApplicationContext());
        adapter = new AdaptadorPizza(getApplicationContext(),pizzas);
        lstPersonalizado.setAdapter(adapter);

    }
}
