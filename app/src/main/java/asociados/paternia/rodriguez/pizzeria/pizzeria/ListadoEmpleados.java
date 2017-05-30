package asociados.paternia.rodriguez.pizzeria.pizzeria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListadoEmpleados extends AppCompatActivity {
    private ListView lstPersonalizado;
    private ArrayList<Empleado> Empleados;
    private AdaptadorEmpleado adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_empleados);
        lstPersonalizado = (ListView)findViewById(R.id.lstListadoEmpleados);
        Empleados = DatosEmpleados.traerEmpleados(getApplicationContext());
        adapter = new AdaptadorEmpleado(getApplicationContext(),Empleados);
        lstPersonalizado.setAdapter(adapter);

    }
}
