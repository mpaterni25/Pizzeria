package asociados.paternia.rodriguez.pizzeria.pizzeria;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Empleado {

    private String foto;
    private String cedula;
    private String nombre;
    private String apellido;
    private String sexo;

    public Empleado(String foto, String cedula, String nombre, String apellido, String sexo) {
        this.foto = foto;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }


    public void guardar(Context contexto){
        //declarar las variables
        SQLiteDatabase db;
        String sql;

        //Abrir la conexion de base datos en modo escritura
        EmpleadosSQLiteOpenHelper  aux = new EmpleadosSQLiteOpenHelper(contexto,"DBEmpleados",null,2);
        db = aux.getWritableDatabase();

        //insertar forma 1
        sql = "INSERT INTO Empleados values('"
                +this.getFoto()+"','"
                +this.getCedula()+"','"
                +this.getNombre()+"','"
                +this.getApellido()+"','"
                +this.getSexo()+"')";

        db.execSQL(sql);

        //insert forma 2

      /*  ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("foto",this.getFoto());
        nuevoRegistro.put("cedula",this.getCedula());
        nuevoRegistro.put("nombre",this.getNombre());
        nuevoRegistro.put("apellido",this.getApellido());
        nuevoRegistro.put("sexo",this.getSexo());
        nuevoRegistro.put("pasatiempo",this.getPasatiempo());

        db.insert("Empleados",null,nuevoRegistro);
*/
        //cerrar conexion
        db.close();

    }

    public void eliminar(Context contexto){
        //declarar las variables
        SQLiteDatabase db;
        String sql;

        //Abrir la conexion de base datos en modo escritura
        EmpleadosSQLiteOpenHelper  aux = new EmpleadosSQLiteOpenHelper(contexto,"DBEmpleados",null,2);
        db = aux.getWritableDatabase();

        sql = "DELETE FROM Empleados where cedula='"+this.getCedula()+"'";
        db.execSQL(sql);
        db.close();

    }

    public void modificar(Context contexto){
        //declarar las variables
        SQLiteDatabase db;
        String sql;

        //Abrir la conexion de base datos en modo escritura
        EmpleadosSQLiteOpenHelper  aux = new EmpleadosSQLiteOpenHelper(contexto,"DBEmpleados",null,2);
        db = aux.getWritableDatabase();

        //insertar forma 1
        sql = "UPDATE Empleados SET nombre='"+this.getNombre()
                +"', apellido='"+this.getApellido()
                +"', sexo='"+this.getSexo()
                +"' " + "where cedula ='"+this.getCedula()+"'";

        db.execSQL(sql);

        //cerrar conexion
        db.close();

    }



}
