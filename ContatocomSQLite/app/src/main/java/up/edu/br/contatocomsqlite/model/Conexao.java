package up.edu.br.contatocomsqlite.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexao extends SQLiteOpenHelper {
    private static SQLiteDatabase conn;

    public static SQLiteDatabase getConexao() {
        return conn;
    }

    public Conexao(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        conn = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE CONTATO (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NOME VARCHAR(80) NOT NULL, " +
                "ENDERECO VARCHAR(120), " +
                "CPF VARCHAR(15), " +
                "DATA_NASCIMENTO TIMESTAMP, " +
                "DATA_CADASTRO TIMESTAMP NOT NULL, " +
                "TELEFONE VARCHAR(13), " +
                "EMAIL VARCHAR(50), " +
                "EMPRESA VARCHAR(70), " +
                "SEXO VARCHAR(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
