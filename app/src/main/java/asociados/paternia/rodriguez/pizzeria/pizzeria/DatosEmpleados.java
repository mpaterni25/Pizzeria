package asociados.paternia.rodriguez.pizzeria.pizzeria;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DatosEmpleados {
    public static ArrayList<Empleado> traerEmpleados(Context contexto){
        ArrayList<Empleado> Empleados = new ArrayList<>();

        //Declarar variables
        SQLiteDatabase db;
        String sql, foto, cedula, nombre, apellido, sexo;
        Empleado p;
        //Abrir conexión de lectura
        EmpleadosSQLiteOpenHelper aux = new EmpleadosSQLiteOpenHelper(contexto,"DBEmpleados",null,2);
        db = aux.getReadableDatabase();

        //Cursor
        sql ="select * from Empleados";
        Cursor c = db.rawQuery(sql,null);

        //Recorrido del cursor
        if(c.moveToFirst()){
            do{
                foto = c.getString(0);
                cedula = c.getString(1);
                nombre =c.getString(2);
                apellido = c.getString(3);
                sexo = c.getString(4);
                p = new Empleado(foto,cedula,nombre,apellido,sexo);
                Empleados.add(p);

            }while (c.moveToNext());
        }

        db.close();

        return Empleados;

    }

    public static Empleado buscarEmpleado(Context contexto, String ced){


        //Declarar variables
        SQLiteDatabase db;
        String sql, foto, cedula, nombre, apellido, sexo;
        Empleado p=null;
        //Abrir conexión de lectura
        EmpleadosSQLiteOpenHelper aux = new EmpleadosSQLiteOpenHelper(contexto,"DBEmpleados",null,2);
        db = aux.getReadableDatabase();

        //Cursor
        sql ="select * from Empleados where cedula ='"+ced+"'";
        Cursor c = db.rawQuery(sql,null);

        //Recorrido del cursor
        if(c.moveToFirst()){
            foto = c.getString(0);
            cedula = c.getString(1);
            nombre =c.getString(2);
            apellido = c.getString(3);
            sexo = c.getString(4);
            p = new Empleado(foto,cedula,nombre,apellido,sexo);
        }

        db.close();
        return p;
    }


}
