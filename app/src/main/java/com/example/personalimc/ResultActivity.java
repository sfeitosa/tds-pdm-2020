package com.example.personalimc;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView lblResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        lblResult = (TextView) findViewById(R.id.lblResult);

        showInfo();
    }

    public void showInfo() {
        Bundle dados = getIntent().getExtras();

        Double imc = dados.getDouble("IMC");

        lblResult.setTextColor(Color.RED);

        if (imc < 18.5) {
            lblResult.setText("Você está abaixo do peso ideal");
        }
        else if (imc >= 18.5 && imc < 25) {
            lblResult.setText("Parabéns, você está no seu peso normal");
            lblResult.setTextColor(Color.GREEN);
        }
        else if (imc >= 25 && imc < 30) {
            lblResult.setText("Você está acima do seu peso (sobrepeso)");
        }
        else if (imc >= 30 && imc < 35) {
            lblResult.setText("Obesidade de grau 1");
        }
        else if (imc >= 35 && imc < 40) {
            lblResult.setText("Obesidade de grau 2");
        }
        else {
            lblResult.setText("Obesidade de grau 3");
        }
    }
}
