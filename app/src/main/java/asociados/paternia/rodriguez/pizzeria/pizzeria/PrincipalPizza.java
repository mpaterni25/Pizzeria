package asociados.paternia.rodriguez.pizzeria.pizzeria;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PrincipalPizza extends AppCompatActivity {


    private ListView ls;
    private Resources res;
    private String[] opc;
    private Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        ls=(ListView)findViewById(R.id.lstOpciones);
        res=this.getResources();
        opc=res.getStringArray(R.array.lstOpcion);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,opc);
        ls.setAdapter(adapter);

        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        i=new Intent(PrincipalPizza.this,Pedido.class);
                        startActivity(i);
                        break;
                    case 1:
                        i=new Intent(PrincipalPizza.this,ListadoPizza.class);
                        startActivity(i);
                        break;
                    case 2:
                        i=new Intent(PrincipalPizza.this,RegistarEmplados.class);
                        startActivity(i);
                        break;
                    case 3:
                        i=new Intent(PrincipalPizza.this,ListadoEmpleados.class);
                        startActivity(i);
                        break;
                    case 4:
                        i=new Intent(PrincipalPizza.this,LoginActivity.class);
                        finish();
                        startActivity(i);
                        break;
                }
            }
        });
    }

    @Override
    public void onBackPressed() {

    }

}
