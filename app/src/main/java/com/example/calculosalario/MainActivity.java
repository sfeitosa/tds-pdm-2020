package com.example.calculosalario;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText edtSalario;
    RadioGroup rgPercentual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtSalario = (EditText) findViewById(R.id.edtSalario);
        rgPercentual = (RadioGroup) findViewById(R.id.rgPercentual);
    }

    public void btnCalcularClick(View v) {

        double salario;
        int opcao;
        double novoSalario = 0.0;

        if (edtSalario.getText().length() > 0) {

            salario = Double.parseDouble(edtSalario.getText().toString());
            opcao = rgPercentual.getCheckedRadioButtonId();

            if (opcao == R.id.rb40) {
                novoSalario = salario * 1.40;
            }
            else if (opcao == R.id.rb45) {
                novoSalario = salario * 1.45;
            }
            else {
                novoSalario = salario * 1.50;
            }

            AlertDialog.Builder diag = new AlertDialog.Builder(MainActivity.this);
            diag.setTitle("Novo Salário");
            diag.setMessage("Seu novo salário é: R$ " + novoSalario);
            diag.setNeutralButton("Voltar", null);
            diag.show();

        }
        else {
            AlertDialog.Builder diag = new AlertDialog.Builder(MainActivity.this);
            diag.setTitle("Atenção");
            diag.setMessage("Você deve informar um salário.");
            diag.show();
        }


    }
}
