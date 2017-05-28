package asociados.paternia.rodriguez.pizzeria.pizzeria;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Pizza
{
    private String foto;
    private String tamaño;
    private String ingredientes;
    private String bordequeso;
    private String pedido;
    private int precio;

    public Pizza(String foto,String pedido, int precio, String tamaño, String ingredientes, String bordequeso) {
        this.foto = foto;
        this.pedido = pedido;
        this.precio = precio;
        this.tamaño = tamaño;
        this.ingredientes = ingredientes;
        this.bordequeso = bordequeso;


    }

    public int getPrecio() {return precio;}

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getIngredientes() {return ingredientes;}

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getBordequeso() {
        return bordequeso;
    }

    public void setBordequeso(String bordequeso) {
        this.bordequeso = bordequeso;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public void guardar(Context contexto){
        //declarar las variables
        SQLiteDatabase db;
        String sql;

        //Abrir la conexion de base datos en modo escritura
        PizzeriaSQLiteOpenHelper aux = new PizzeriaSQLiteOpenHelper(contexto,"DBPizzas",null,2);
        db = aux.getWritableDatabase();

        //insertar forma 1
        sql = "INSERT INTO Pizzas values('"
                +this.getFoto()+"','"
                +this.getPedido()+"','"
                +this.getPrecio()+"','"
                +this.getTamaño()+"','"
                +this.getIngredientes()+"','"
                +this.getBordequeso()+"')";

        db.execSQL(sql);

        //insert forma 2

      /*  ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("foto",this.getFoto());
        nuevoRegistro.put("cedula",this.getCedula());
        nuevoRegistro.put("nombre",this.getNombre());
        nuevoRegistro.put("apellido",this.getApellido());
        nuevoRegistro.put("sexo",this.getSexo());
        nuevoRegistro.put("pasatiempo",this.getPasatiempo());

        db.insert("Personas",null,nuevoRegistro);
*/
        //cerrar conexion
        db.close();

    }

    public void eliminar(Context contexto){
        //declarar las variables
        SQLiteDatabase db;
        String sql;

        //Abrir la conexion de base datos en modo escritura
        PizzeriaSQLiteOpenHelper aux = new PizzeriaSQLiteOpenHelper(contexto,"DBPizzas",null,2);
        db = aux.getWritableDatabase();

        sql = "DELETE FROM Pizzas where Pedido='"+this.getPedido()+"'";
        db.execSQL(sql);
        db.close();

    }

    public void modificar(Context contexto){
        //declarar las variables
        SQLiteDatabase db;
        String sql;

        //Abrir la conexion de base datos en modo escritura
        PizzeriaSQLiteOpenHelper aux = new PizzeriaSQLiteOpenHelper(contexto,"DBPizzas",null,2);
        db = aux.getWritableDatabase();

        //insertar forma 1
        sql = "UPDATE Personas SET foto='"+this.getFoto()+"', tamaño='"+this.getTamaño()+"', ingredientes='"+this.getIngredientes()+"', "+ "bordedequeso='" +this.getBordequeso()+"'"+ "pedido='" +this.getPedido()+"'"
                + "precio='" +this.getPrecio()+"'";

        db.execSQL(sql);

        //cerrar conexion
        db.close();

    }



}
