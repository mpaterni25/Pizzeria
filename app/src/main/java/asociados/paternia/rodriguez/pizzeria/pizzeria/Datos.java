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
        PizzeriaSQLiteOpenHelper aux = new PizzeriaSQLiteOpenHelper(contexto,"DBPizzas",null,2);
        db = aux.getReadableDatabase();

        //Cursor
        sql ="select * from Pizzas";
        Cursor c = db.rawQuery(sql,null);

        //Recorrido del cursor
        if(c.moveToFirst()){
            do{
                foto = c.getString(0);
                pedido = c.getString(1);
                precio = Integer.parseInt(c.getString(2));
                tamaño =c.getString(3);
                ingredientes = c.getString(4);
                bordedequeso = c.getString(5);


                p = new Pizza(foto,pedido,precio,tamaño,ingredientes,bordedequeso);
                pizzas.add(p);

            }while (c.moveToNext());
        }

        db.close();

        return pizzas;

    }

    public static Pizza buscarPizza(Context contexto, String ped){


        //Declarar variables
        SQLiteDatabase db;
        String sql, foto, pedido, tamaño, ingredientes, bordedequeso;
        int precio;
        Pizza p=null;
        //Abrir conexión de lectura
        PizzeriaSQLiteOpenHelper aux = new PizzeriaSQLiteOpenHelper(contexto,"DBPizzas",null,2);
        db = aux.getReadableDatabase();

        //Cursor
        sql ="select * from Pizzas where pedido ='"+ped+"'";
        Cursor c = db.rawQuery(sql,null);

        //Recorrido del cursor
        if(c.moveToFirst()){
            foto = c.getString(0);
            pedido = c.getString(1);
            precio = Integer.parseInt(c.getString(2));
            tamaño =c.getString(3);
            ingredientes = c.getString(4);
            bordedequeso = c.getString(5);

            p = new Pizza(foto,pedido,precio,tamaño,ingredientes,bordedequeso);
        }

        db.close();
        return p;
    }

}
