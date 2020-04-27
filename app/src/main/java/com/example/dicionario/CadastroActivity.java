package com.example.dicionario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    private EditText edtPalavra;
    private EditText edtSinonimo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        edtPalavra = (EditText) findViewById(R.id.edtPalavra);
        edtSinonimo = (EditText) findViewById(R.id.edtSinonimo);
    }

    public void onCadastrarClick(View v) {
        String palavra = edtPalavra.getText().toString();
        String sinonimo = edtSinonimo.getText().toString();

        DictDbController c = new DictDbController(getBaseContext());

        // Retorno -1 indica erro na gravação no banco de dados
        if (c.salvar(palavra, sinonimo) != -1) {
            Toast.makeText(getApplicationContext(), "Salvo com sucesso!", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "Erro ao salvar!", Toast.LENGTH_LONG).show();
        }

        // Volta para a tela inicial
        NavUtils.navigateUpFromSameTask(this);
    }
}
