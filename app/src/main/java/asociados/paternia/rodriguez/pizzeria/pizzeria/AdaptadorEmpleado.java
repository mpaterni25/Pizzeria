package asociados.paternia.rodriguez.pizzeria.pizzeria;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorEmpleado extends BaseAdapter {
    private Context contexto;
    private ArrayList<Empleado> empleados;

    public AdaptadorEmpleado(Context contexto, ArrayList<Empleado> empleados){
        this.contexto = contexto;
        this.empleados = empleados;
    }

    @Override
    public int getCount() {
        return empleados.size();
    }

    @Override
    public Object getItem(int position) {
        return empleados.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Long.parseLong(empleados.get(position).getCedula());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Declarar Variable
        TextView cajaCedula,cajaNombre,cajaApellido;
        ImageView foto;
        LayoutInflater inflater;
        View itemView;

        //Uso del Inflater
        inflater = (LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        itemView = inflater.inflate(R.layout.item_personalizado_empleado,null);

        //Capturar los objetos
        cajaCedula= (TextView)itemView.findViewById(R.id.txtCedulaE);
        cajaNombre=(TextView)itemView.findViewById(R.id.txtNombreE);
        cajaApellido=(TextView)itemView.findViewById(R.id.txtApellidoE);
        foto = (ImageView)itemView.findViewById(R.id.imgFoto);

        //Pasar la información

        foto.setImageResource(Integer.parseInt(empleados.get(position).getFoto()));
        cajaCedula.setText(empleados.get(position).getCedula());
        cajaNombre.setText(empleados.get(position).getNombre());
        cajaApellido.setText(empleados.get(position).getApellido());

        //Retornar el itemview

        return itemView;
    }
}
