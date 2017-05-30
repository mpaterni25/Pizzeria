package asociados.paternia.rodriguez.pizzeria.pizzeria;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class RegistarEmplados extends AppCompatActivity {

    private EditText cajaCedula;
    private EditText cajaNombre;
    private EditText cajaApellido;
    private RadioButton rdMasculino;
    private RadioButton rdFemenino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registar_emplados);
        cajaCedula = (EditText) findViewById(R.id.txtcedula);
        cajaNombre = (EditText) findViewById(R.id.txtNombre);
        cajaApellido = (EditText) findViewById(R.id.txtApellido);
        rdMasculino = (RadioButton) findViewById(R.id.r1e);
        rdFemenino = (RadioButton) findViewById(R.id.r2e);
    }

    public boolean validarTodo() {
        if (cajaCedula.getText().toString().isEmpty()) {
            cajaCedula.setError(getResources().getString(R.string.error5));
            cajaCedula.requestFocus();
            return false;
        }
        if (cajaNombre.getText().toString().isEmpty()) {
            cajaNombre.setError(getResources().getString(R.string.error6));
            cajaNombre.requestFocus();
            return false;
        }
        if (cajaApellido.getText().toString().isEmpty()) {
            cajaApellido.setError(getResources().getString(R.string.error7));
            cajaApellido.requestFocus();
            return false;
        }

        return true;
    }

    public void guardar(View v) {
        String foto, cedula, nombre, apellido, sexo;
        Empleado p;

        if (validarTodo()) {
            cedula = cajaCedula.getText().toString();
            foto = String.valueOf(fotoAleatoria());
            nombre = cajaNombre.getText().toString();
            apellido = cajaApellido.getText().toString();
            if (rdMasculino.isChecked()) sexo = getResources().getString(R.string.masculino);
            else sexo = getResources().getString(R.string.femenino);


            p = new Empleado(foto, cedula, nombre, apellido, sexo);
            p.guardar(getApplicationContext());

            Toast.makeText(getApplicationContext(), getResources().getString(R.string.success2),
                    Toast.LENGTH_SHORT).show();


            limpiar();

        }
    }

    public int fotoAleatoria() {
        int fotos[] = {R.drawable.empleado1, R.drawable.empleado2, R.drawable.empleado3, R.drawable.empleado4};
        int numero = (int) (Math.random() * 4);
        return fotos[numero];
    }

    public boolean validarCedula() {
        if (cajaCedula.getText().toString().isEmpty()) {
            cajaCedula.setError(getResources().getString(R.string.error5));
            cajaCedula.requestFocus();
            return false;
        }
        return true;
    }

    public void limpiar() {
        cajaCedula.setText("");
        cajaNombre.setText("");
        cajaApellido.setText("");
        rdMasculino.setChecked(true);
        cajaCedula.requestFocus();

    }

    public void limpiar(View v) {
        limpiar();
    }

    public void buscar(View v) {
        Empleado p;
        if (validarCedula()) {
            p = DatosEmpleados.buscarEmpleado(getApplicationContext(), cajaCedula.getText().toString());
            if (p != null) {
                cajaNombre.setText(p.getNombre());
                cajaApellido.setText(p.getApellido());
                if (p.getSexo().equals(getResources().getString(R.string.masculino)))
                    rdMasculino.setChecked(true);
                else rdFemenino.setChecked(true);

            }
        }
    }

    public void modificar(View v) {
        Empleado p, p2;
        String nombre, apellido, sexo;
        if (validarCedula()) {
            p = DatosEmpleados.buscarEmpleado(getApplicationContext(), cajaCedula.getText().toString());
            if (p != null) {

                nombre = cajaNombre.getText().toString();
                apellido = cajaApellido.getText().toString();
                if (rdMasculino.isChecked()) sexo = getResources().getString(R.string.masculino);
                else sexo = getResources().getString(R.string.femenino);


                p2 = new Empleado(p.getFoto(), p.getCedula(), nombre, apellido, sexo);
                p2.modificar(getApplicationContext());

                Toast.makeText(getApplicationContext(), getResources().getString(R.string.modif1),
                        Toast.LENGTH_SHORT).show();


                limpiar();


            }
        }
    }

    public void eliminar(View v) {
        Empleado p;
        if (validarCedula()) {
            p = DatosEmpleados.buscarEmpleado(getApplicationContext(), cajaCedula.getText().toString());
            if (p != null) {
                AlertDialog.Builder ventana = new AlertDialog.Builder(this);
                ventana.setTitle(getResources().getString(R.string.confirmacion));
                ventana.setMessage(getResources().getString(R.string.pregunta2));
                ventana.setPositiveButton(getResources().getString(R.string.confirmar), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Empleado p;
                        p = DatosEmpleados.buscarEmpleado(getApplicationContext(), cajaCedula.getText().toString());

                        p.eliminar(getApplicationContext());
                        limpiar();
                        Toast.makeText(getApplicationContext(), getResources().getString(R.string.eliminarE),
                                Toast.LENGTH_SHORT).show();

                    }
                });


                ventana.setNegativeButton(getResources().getString(R.string.cancelar), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        cajaCedula.requestFocus();
                    }
                });

                ventana.show();
            }
        }

    }
}

