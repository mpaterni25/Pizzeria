package asociados.paternia.rodriguez.pizzeria.pizzeria;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;


public class Datos {

    public static ArrayList<Pizza> traerPizzas(Context contexto){
        ArrayList<Pizza> pizzas = new ArrayList<>();

        //Declarar variables
        SQLiteDatabase db;
        String sql, foto, pedido, tamaño, ingredientes, bordedequeso;
        int precio;
        Pizza p;
        //Abrir conexión de lectura
        PizzeriaSQLiteOpenHelper aux = new PizzeriaSQLiteOpenHelper(contexto,"DBPizzas",null,1);
        db = aux.getReadableDatabase();

        //Cursor
        sql ="select * from Pizzas";
        Cursor c = db.rawQuery(sql,null);

        //Recorrido del cursor
        if(c.moveToFirst()){
            do{
                foto = c.getString(0);
                pedido = c.getString(1);
                tamaño =c.getString(2);
                ingredientes = c.getString(3);
                bordedequeso = c.getString(4);
                precio = Integer.parseInt(c.getString(5));


                p = new Pizza(foto,pedido,tamaño,ingredientes,bordedequeso,precio);
                pizzas.add(p);

            }while (c.moveToNext());
        }

        db.close();

        return pizzas;

    }

    public static Pizza buscarPizza(Context contexto, String ced){


        //Declarar variables
        SQLiteDatabase db;
        String sql, foto, pedido, tamaño, ingredientes, bordedequeso;
        int precio;
        Pizza p=null;
        //Abrir conexión de lectura
        PizzeriaSQLiteOpenHelper aux = new PizzeriaSQLiteOpenHelper(contexto,"DBPizzas",null,1);
        db = aux.getReadableDatabase();

        //Cursor
        sql ="select * from Pizzas where pedido ='"+ced+"'";
        Cursor c = db.rawQuery(sql,null);

        //Recorrido del cursor
        if(c.moveToFirst()){
                foto = c.getString(0);
                pedido = c.getString(1);
                tamaño =c.getString(2);
                ingredientes = c.getString(3);
                bordedequeso = c.getString(4);
                precio = Integer.parseInt(c.getString(5));

            p = new Pizza(foto,pedido,tamaño,ingredientes,bordedequeso,precio);
        }

        db.close();
        return p;
    }

}
