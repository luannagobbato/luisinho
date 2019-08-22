package br.com.mallbecky.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edtPeso;
    EditText edtAltura;
    RadioButton edtGeneroFem;

    TextView outputIMC;
    TextView outputCondicao;

    String[] condicoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        condicoes = getResources().getStringArray(R.array.condicoes);
        edtPeso = findViewById(R.id.peso);
        edtAltura = findViewById(R.id.altura);
        edtGeneroFem = findViewById(R.id.generoFem);
        outputIMC = findViewById(R.id.outputIMC);
        outputCondicao = findViewById(R.id.outputCondicao);
    }

    public void calcular(View view){
        Double peso;
        Double altura;
        Boolean generoFem;

        peso = Double.parseDouble(edtPeso.getText().toString());
        altura = Double.parseDouble(edtAltura.getText().toString());
        generoFem = edtGeneroFem.isChecked();

        Double imc = peso / (altura * altura);
        Integer idCondicao;

        if (generoFem){
            if (imc < 19.1){
                idCondicao = 0;
            } else if (imc < 25.8){
                idCondicao = 1;
            } else if (imc < 27.3){
                idCondicao = 2;
            } else if (imc < 32.3){
                idCondicao = 3;
            } else {
                idCondicao = 4;
            }
        } else {
            if (imc < 20.7){
                idCondicao = 0;
            } else if (imc < 26.4){
                idCondicao = 1;
            } else if (imc < 27.8){
                idCondicao = 2;
            } else if (imc < 31.1){
                idCondicao = 3;
            } else {
                idCondicao = 4;
            }
        }

        outputIMC.setText(String.format("Seu imc é %.2f",imc));
        outputCondicao.setText(condicoes[idCondicao]);
    }
}