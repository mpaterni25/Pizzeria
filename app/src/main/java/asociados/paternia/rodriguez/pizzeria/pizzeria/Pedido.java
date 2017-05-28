package asociados.paternia.rodriguez.pizzeria.pizzeria;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Pedido extends AppCompatActivity {
    private Spinner sptamaño;
    private RadioButton rSi, rNO;
    private CheckBox chkSalami, chkPeperoni, chkPollo, chkChampi, chkPiña, chkJamon, chkChorizo;
    private TextView cajapedido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido__ingredientes);

        Spinner tamañoSp = (Spinner) findViewById(R.id.tamañoSp);
        ArrayAdapter<CharSequence> tamañoAdapter = ArrayAdapter.createFromResource(this,
                R.array.tamaño_spinner, android.R.layout.simple_spinner_item);
        tamañoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tamañoSp.setAdapter(tamañoAdapter);

        rSi = (RadioButton) findViewById(R.id.r1);
        rNO = (RadioButton) findViewById(R.id.r2);
        chkSalami = (CheckBox) findViewById(R.id.chkSalami);
        chkChampi = (CheckBox) findViewById(R.id.chkChampi);
        chkChorizo = (CheckBox) findViewById(R.id.chkChorizo);
        chkPollo = (CheckBox) findViewById(R.id.chkPollo);
        chkPeperoni = (CheckBox) findViewById(R.id.chkPeperoni);
        chkJamon = (CheckBox) findViewById(R.id.chkJamon);
        chkPiña = (CheckBox) findViewById(R.id.chkPiña);
        sptamaño = (Spinner) findViewById(R.id.tamañoSp);
        cajapedido = (TextView) findViewById(R.id.txtPedido);

    }

    public int fotoAleatoria() {
        int fotos[] = {R.drawable.pizza2, R.drawable.pizza3, R.drawable.pizza4};
        int numero = (int) (Math.random() * 3);
        return fotos[numero];
    }

    public boolean validarTodo() {

        if (cajapedido.getText().toString().isEmpty()) {
            cajapedido.setError("Digite la cédula");
            cajapedido.requestFocus();
            return false;
        }
        if ((!rSi.isChecked() && (!rNO.isChecked()))) {
            new AlertDialog.Builder(this).setMessage(getResources().getString(R.string.error1)).setCancelable(true).show();
            return false;
        }

        if ((!chkPiña.isChecked()) && (!chkJamon.isChecked()) && (!chkPeperoni.isChecked()) && (!chkPiña.isChecked())
                && (!chkChampi.isChecked()) && (!chkChorizo.isChecked()) && (!chkPollo.isChecked())) {
            new AlertDialog.Builder(this).setMessage(getResources().getString(R.string.error2)).setCancelable(true).show();
            return false;
        }
        return true;
    }

    public void guardar(View v) {
        String tamaño, pedido, bordequeso, ingredientes = "", foto;
        int precio = 0;
        Pizza p;


        if (validarTodo()) {
            tamaño = sptamaño.getSelectedItem().toString();

            if (tamaño.equals(getResources().getString(R.string.Personal))) {
                precio += 1000;
            } else if (tamaño.equals(getResources().getString(R.string.Pequeña))) {
                precio += 6000;
            } else if (tamaño.equals(getResources().getString(R.string.Mediana))) {
                precio += 8000;
            } else if (tamaño.equals(getResources().getString(R.string.Grande))) {
                precio += 10000;
            } else if (tamaño.equals(getResources().getString(R.string.Jumbo))) {
                precio += 20000;
            }

            foto = String.valueOf(fotoAleatoria());
            pedido = cajapedido.getText().toString();
            if (rSi.isChecked()) {
                bordequeso = getResources().getString(R.string.si);
                precio += 2000;
            } else {
                bordequeso = getResources().getString(R.string.no);
            }

            if (chkJamon.isChecked()) {
                ingredientes = getResources().getString(R.string.Jamon) + ", ";
                precio += 500;
            }
            if (chkPollo.isChecked()) {
                ingredientes = ingredientes + getResources().getString(R.string.Pollo) + ", ";
                precio += 1000;
            }

            if (chkChorizo.isChecked()) {
                ingredientes = ingredientes + getResources().getString(R.string.Chorizo) + ", ";
                precio += 500;

            }
            if (chkChampi.isChecked()) {
                ingredientes = ingredientes + getResources().getString(R.string.Champiñon) + ", ";
                precio += 500;
            }
            if (chkPeperoni.isChecked()) {
                ingredientes = ingredientes + getResources().getString(R.string.Pepperoni) + ", ";
                precio += 500;
            }
            if (chkPiña.isChecked()) {
                ingredientes = ingredientes + getResources().getString(R.string.Piña) + ", ";
                precio += 300;
            }
            if (chkSalami.isChecked()) {
                ingredientes = ingredientes + getResources().getString(R.string.Salami) + ", ";
                precio += 500;
            }

            p = new Pizza(foto, pedido, precio, tamaño, ingredientes, bordequeso);
            p.guardar(getApplicationContext());

            Toast.makeText(getApplicationContext(), getResources().getString(R.string.success),
                    Toast.LENGTH_SHORT).show();

            limpiar();

        }
    }


    public void limpiar() {
        rSi.setChecked(true);
        chkSalami.setChecked(true);
        chkJamon.setChecked(false);
        chkPiña.setChecked(false);
        chkPeperoni.setChecked(false);
        chkChampi.setChecked(false);
        chkChorizo.setChecked(false);
        chkPollo.setChecked(false);
        cajapedido.setText("");

    }

    public void limpiar(View v) {
        limpiar();
    }


    public int tamanopizza(String tamanoPizza) {
        int m = 0;
        if (tamanoPizza.equals(getResources().getString(R.string.Personal))) {
            m = 0;

        } else if (tamanoPizza.equals(getResources().getString(R.string.Pequeña))) {
            m = 1;
        } else if (tamanoPizza.equals(getResources().getString(R.string.Mediana))) {
            m = 3;
        } else if (tamanoPizza.equals(getResources().getString(R.string.Grande))) {
            m = 4;
        } else if (tamanoPizza.equals(getResources().getString(R.string.Jumbo))) {
            m = 5;
        }
        return m;
    }

    public void eliminar(View v) {
        Pizza p;
        p = Datos.buscarPizza(getApplicationContext(), cajapedido.getText().toString());
        if (p != null) {
            AlertDialog.Builder ventana = new AlertDialog.Builder(this);
            ventana.setTitle(getResources().getString(R.string.confirmacion));
            ventana.setMessage(getResources().getString(R.string.pregunta1));
            ventana.setPositiveButton(getResources().getString(R.string.confirmar), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Pizza p;
                    p = Datos.buscarPizza(getApplicationContext(), cajapedido.getText().toString());

                    p.eliminar(getApplicationContext());
                    limpiar();
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.eliminarP),
                            Toast.LENGTH_SHORT).show();

                }
            });

            ventana.setNegativeButton(getResources().getString(R.string.cancelar), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    cajapedido.requestFocus();
                }
            });

            ventana.show();
        }

    }

    public void buscar(View v) {
        Pizza p;
        String ingredientess, tamanoPizza = "";
        int t;
        if (!cajapedido.getText().toString().isEmpty()) {
            p = Datos.buscarPizza(getApplicationContext(), cajapedido.getText().toString());
            if (p != null)
                tamanoPizza = p.getTamaño().toString();
            t = tamanopizza(tamanoPizza);
            sptamaño.setSelection(t);
            
            if (p.getBordequeso().toString().equals(getResources().getString(R.string.si)))
                    rSi.setChecked(true);
            else rNO.setChecked(true);

            ingredientess = p.getIngredientes();
            if (ingredientess.contains(getResources().getString(R.string.Champiñon)))
                chkChampi.setChecked(true);
            if (ingredientess.contains(getResources().getString(R.string.Salami)))
                chkSalami.setChecked(true);
            if (ingredientess.contains(getResources().getString(R.string.Piña)))
                chkPiña.setChecked(true);
            if (ingredientess.contains(getResources().getString(R.string.Chorizo)))
                chkChorizo.setChecked(true);
            if (ingredientess.contains(getResources().getString(R.string.Pepperoni)))
                chkPeperoni.setChecked(true);
            if (ingredientess.contains(getResources().getString(R.string.Jamon)))
                chkJamon.setChecked(true);
            if (ingredientess.contains(getResources().getString(R.string.Pollo)))
                chkPollo.setChecked(true);
        }else {
            new AlertDialog.Builder(this).setMessage(getResources().getString(R.string.error3)).setCancelable(true).show();
        }

    }

    public void modificar(View v) {
        Pizza p, p2;
        String bordequeso, ingredientes = "", tamanoPizza = "";
        int t, precio = 0;



            p = Datos.buscarPizza(getApplicationContext(), cajapedido.getText().toString());
            if (p != null) {
                t = tamanopizza(tamanoPizza);
                sptamaño.setSelection(t);
                tamanoPizza = p.getTamaño().toString();


                if (tamanoPizza.equals(getResources().getString(R.string.Personal))) {
                    precio += 1000;
                } else if (tamanoPizza.equals(getResources().getString(R.string.Pequeña))) {
                    precio += 6000;
                } else if (tamanoPizza.equals(getResources().getString(R.string.Mediana))) {
                    precio += 8000;
                } else if (tamanoPizza.equals(getResources().getString(R.string.Grande))) {
                    precio += 10000;
                } else if (tamanoPizza.equals(getResources().getString(R.string.Jumbo))) {
                    precio += 20000;
                }

                if (rSi.isChecked()) {
                    bordequeso = getResources().getString(R.string.si);
                    precio += 2000;
                } else {
                    bordequeso = getResources().getString(R.string.no);
                }

                if (chkJamon.isChecked()) {
                    ingredientes = getResources().getString(R.string.Jamon) + ", ";
                    precio += 500;
                }
                if (chkPollo.isChecked()) {
                    ingredientes = ingredientes + getResources().getString(R.string.Pollo) + ", ";
                    precio += 1000;
                }

                if (chkChorizo.isChecked()) {
                    ingredientes = ingredientes + getResources().getString(R.string.Chorizo) + ", ";
                    precio += 500;

                }
                if (chkChampi.isChecked()) {
                    ingredientes = ingredientes + getResources().getString(R.string.Champiñon) + ", ";
                    precio += 500;
                }
                if (chkPeperoni.isChecked()) {
                    ingredientes = ingredientes + getResources().getString(R.string.Pepperoni) + ", ";
                    precio += 500;
                }
                if (chkPiña.isChecked()) {
                    ingredientes = ingredientes + getResources().getString(R.string.Piña) + ", ";
                    precio += 300;
                }
                if (chkSalami.isChecked()) {
                    ingredientes = ingredientes + getResources().getString(R.string.Salami) + ", ";
                    precio += 500;
                }

                ingredientes = ingredientes.substring(0, ingredientes.length() - 6);
                p2 = new Pizza(p.getFoto(), p.getPedido(), precio, tamanoPizza, ingredientes, bordequeso);
                p2.modificar(getApplicationContext());

                Toast.makeText(getApplicationContext(), getResources().getString(R.string.modif),
                        Toast.LENGTH_SHORT).show();


                limpiar();

            }
        }
    }




