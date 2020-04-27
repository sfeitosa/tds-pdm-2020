package com.example.dicionario;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DictDbController {

    private SQLiteDatabase db;
    private DictDbHelper dbHelper;

    public DictDbController(Context context) {
        dbHelper = new DictDbHelper(context);
    }

    public long salvar(String palavra, String sinonimo) {
        db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        // { palavra: teste , sinonimo: alguma coisa }
        values.put(DictDbContract.DictEntry.COLUNA_PALAVRA, palavra);
        values.put(DictDbContract.DictEntry.COLUNA_SINONIMO, sinonimo);

        return db.insert(DictDbContract.DictEntry.NOME_TABELA, null, values);
    }

    public Cursor carregar() {
        String campos[] = {DictDbContract.DictEntry._ID,
                DictDbContract.DictEntry.COLUNA_PALAVRA,
                DictDbContract.DictEntry.COLUNA_SINONIMO};

        db = dbHelper.getReadableDatabase();

        Cursor c = db.query(DictDbContract.DictEntry.NOME_TABELA, campos,
                null, null, null, null, null, null);

        if (c != null) {
            c.moveToFirst();
        }

        return c;
    }
}
