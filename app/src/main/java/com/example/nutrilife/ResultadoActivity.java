package com.example.nutrilife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    private TextView txtResultado;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);


        txtResultado = findViewById(R.id.txtResultado);

        btnVoltar = findViewById(R.id.btnVoltar);

        Intent intent = getIntent();

        String nome = intent.getStringExtra("nome");
        Double peso = intent.getDoubleExtra("peso", 0);
        Double altura = intent.getDoubleExtra("altura", 0);
        int opcao = intent.getIntExtra("opcao", 0);

        Double imc = peso / Math.pow(altura, 2);

        String saida = String.format(" Olá, %s.\n Seu IMC é: %.1f", nome, imc);
        if(opcao == 1){
            if(imc > 40){
                saida+= "\n Classificação: Obesidade Grau 3" + "\n Abaixo estão os riscos associados ao seu resultado:\n - Refluxo; \n - Dificuldade para se mover;\n - Escaras;\n - Diabetes;\n - Infarto;\n - AVC;";
            }
            else if(imc >=35 && imc <=40){
                saida+= "\n Classificação: Obesidade Grau 2" + "\n Abaixo estão os riscos associados ao seu resultado:\n - Apneia do sono;\n - Falta de ar;";
            }
            else if(imc >=30 && imc <=34.9) {
                saida += "\n Classificação: Obesidade Grau 1" + "\n Abaixo estão os riscos associados ao seu resultado:\n - Diabetes;\n - Angina;\n - Infarto;\n - Aterosclerose;";
            }
            else if(imc >=25 && imc <=29.9){
                saida+= "\n Classificação: Acima do Peso" + "\n Abaixo estão os riscos associados ao seu resultado:\n - Fadiga;\n - Má circulação;\n - Varizes;";
            }
            else if(imc >=18.5 && imc <=24.9){
                saida += "\n Classificação: Peso Normal" + "\n Abaixo estão os riscos associados ao seu resultado:\n - Menor risco de doenças cardíacas e vasculares;";
            }
            else if(imc >=17 && imc <=18.4){
                saida += "\n Classificação: Abaixo do Peso" + "\n Abaixo estão os riscos associados ao seu resultado: \n - Fadiga;\n - Estresse;\n - Ansiedade;";
            }
            else if(imc <= 16.9){
                saida += "\n Classificação: Muito Abaixo do Peso" + "\n Abaixo estão os riscos associados ao seu resultado: \n - Queda de cabelo;\n - Infertilidade;\n - Ausência menstrual;";
            }
        }else{
            if(imc<19){
                saida += "\nClassificação: Abaixo do peso";
            }else if((imc>=19) && (imc<=23.9)){
                saida += "\nClassificação: Peso Normal";
            }else if((imc>23.9) && (imc<=28.9)){
                saida += "\nClassificação: Obesidade leve";
            }else if((imc>28.9) && (imc<=39)){
                saida += "\nClassificação: Obesidade moderada";
            }else saida += "\nClassificação: Obesidade mórbida";
        }
        txtResultado.setText(saida);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });
    }

}