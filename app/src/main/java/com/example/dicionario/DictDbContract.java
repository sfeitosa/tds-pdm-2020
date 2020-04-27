package com.example.dicionario;

import android.provider.BaseColumns;

public class DictDbContract {

    private DictDbContract() { }

    public static class DictEntry implements BaseColumns {
        public static final String NOME_TABELA = "dicionario";
        public static final String COLUNA_PALAVRA = "palavra";
        public static final String COLUNA_SINONIMO = "sinonimo";
    }

}
