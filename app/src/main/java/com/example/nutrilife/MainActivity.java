package com.example.nutrilife;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edit_txtNome, edit_txtPeso, edit_txtAltura;
    private Button btnCalcular;
    private RadioGroup rdGrupo;
    private RadioButton rdMale, rdFemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_txtNome = findViewById(R.id.edit_txtNome);
        edit_txtPeso = findViewById(R.id.edit_txtPeso);
        edit_txtAltura = findViewById(R.id.edit_txtAltura);

        rdGrupo = findViewById(R.id.rdGrupo);
        rdMale = findViewById(R.id.rdMale);
        rdFemale = findViewById(R.id.rdFemale);

        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edit_txtNome.getText().toString().isEmpty() || edit_txtPeso.getText().toString().isEmpty() || edit_txtAltura.getText().toString().isEmpty() ||
                        rdGrupo.getCheckedRadioButtonId() == -1){
                    AlertDialog.Builder jan = new AlertDialog.Builder(MainActivity.this);
                    jan.setTitle("Erro!");
                    jan.setMessage("Por favor, preencha todos os campos antes de continuar.");
                    jan.setNeutralButton("Ok", null);
                    jan.show();
                }
                else{
                    AlertDialog.Builder jan2 = new AlertDialog.Builder(MainActivity.this);
                    jan2.setTitle("Atenção!");
                    jan2.setMessage("Você preencheu todos os dados corretamente?");

                    jan2.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            String nome = edit_txtNome.getText().toString();
                            Double peso = Double.parseDouble(edit_txtPeso.getText().toString());
                            Double altura = Double.parseDouble(edit_txtAltura.getText().toString());
                            int opcao = rdGrupo.getCheckedRadioButtonId();
                            if(opcao == R.id.rdMale){
                                opcao = 1;
                            }else opcao = 2;

                            Intent intent = new Intent(getApplicationContext(), ResultadoActivity.class);
                            intent.putExtra("nome", nome);
                            intent.putExtra("peso", peso);
                            intent.putExtra("altura", altura);
                            intent.putExtra("opcao", opcao);

                            startActivity(intent);


                            edit_txtNome.setText("");
                            edit_txtAltura.setText("");
                            edit_txtPeso.setText("");
                            rdGrupo.clearCheck();
                        }
                    });
                    jan2.setNegativeButton("Nao", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    jan2.show();
                }
            }
        });
    }
}