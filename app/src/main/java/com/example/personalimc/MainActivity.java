package com.example.personalimc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtPeso;
    EditText edtAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPeso = (EditText) findViewById(R.id.edtPeso);
        edtAltura = (EditText) findViewById(R.id.edtAltura);
    }

    public void btnCalcularClick(View v) {
        if (edtPeso.getText().length() > 0 && edtAltura.getText().length() > 0) {
            Double peso   = new Double(edtPeso.getText().toString());
            Double altura = new Double(edtAltura.getText().toString());

            if (peso != 0 && altura != 0) {
                Double imc = peso / (altura * altura);

                Bundle dados = new Bundle();
                dados.putDouble("IMC", imc);

                Intent intent = new Intent(this, ResultActivity.class);
                intent.putExtras(dados);
                startActivity(intent);
            }
            else {
                AlertDialog.Builder diag = new AlertDialog.Builder(this);

                diag.setTitle("Atenção");
                diag.setMessage("Campos informados incorretamente!");
                diag.setNeutralButton("OK", null);
                diag.show();
            }

        }
        else {
            AlertDialog.Builder diag = new AlertDialog.Builder(this);

            diag.setTitle("Atenção");
            diag.setMessage("Campos informados incorretamente!");
            diag.setNeutralButton("OK", null);
            diag.show();
        }
    }
}
