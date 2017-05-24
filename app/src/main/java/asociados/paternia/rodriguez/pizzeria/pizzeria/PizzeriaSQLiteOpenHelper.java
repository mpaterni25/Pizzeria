package asociados.paternia.rodriguez.pizzeria.pizzeria;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class PizzeriaSQLiteOpenHelper extends SQLiteOpenHelper {
    private String sql = "CREATE TABLE Pizzas(foto text, precio text,pedido text, tamaño text, ingredientes text, bordedequeso text)";

    public PizzeriaSQLiteOpenHelper(Context contexto, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(contexto, name, factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Pizzas");
        db.execSQL(sql);
    }
}
