package com.example.dicionario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    ListView lstPalavras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstPalavras = (ListView) findViewById(R.id.lstPalavras);
        carregaPalavras();
    }

    public void carregaPalavras() {
        DictDbController ctrl = new DictDbController(getBaseContext());
        Cursor c = ctrl.carregar();

        String[] campos = new String[] {DictDbContract.DictEntry.COLUNA_PALAVRA,
                DictDbContract.DictEntry.COLUNA_SINONIMO};
        int[] ids = new int[] {R.id.txtPalavra, R.id.txtSinonimo};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getBaseContext(),
                R.layout.lista_layout, c, campos, ids, 0);

        lstPalavras.setAdapter(adapter);
    }

    public void onAddClick(View v) {
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);
    }
}
