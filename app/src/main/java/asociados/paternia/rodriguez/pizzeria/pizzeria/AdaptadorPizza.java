package asociados.paternia.rodriguez.pizzeria.pizzeria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class AdaptadorPizza extends BaseAdapter {
    private Context contexto;
    private ArrayList<Pizza> pizzas;

    public AdaptadorPizza(Context contexto, ArrayList<Pizza> pizzas){
        this.contexto = contexto;
        this.pizzas = pizzas;
    }

    @Override
    public int getCount() {
        return pizzas.size();
    }

    @Override
    public Object getItem(int position) {
        return pizzas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Long.parseLong(pizzas.get(position).getPedido());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Declarar Variable
        TextView cajaTamaño,cajaPrecio,cajaIngredientes;
        ImageView foto;
        LayoutInflater inflater;
        View itemView;

        //Uso del Inflater
        inflater = (LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        itemView = inflater.inflate(R.layout.item_personalizado,null);

        //Capturar los objetos
        cajaTamaño= (TextView)itemView.findViewById(R.id.txtTamañoP);
        cajaPrecio=(TextView)itemView.findViewById(R.id.txtPrecioP);
        cajaIngredientes=(TextView)itemView.findViewById(R.id.txtIngredientesP);
        foto = (ImageView)itemView.findViewById(R.id.imgFoto);

        //Pasar la información

        foto.setImageResource(Integer.parseInt(pizzas.get(position).getFoto()));
        cajaTamaño.setText(pizzas.get(position).getTamaño());
        cajaPrecio.setText(pizzas.get(position).getTamaño());
        cajaIngredientes.setText(pizzas.get(position).getIngredientes());

        //Retornar el itemview

        return itemView;
    }
}
