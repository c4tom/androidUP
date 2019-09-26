package up.edu.br.contatocomsqlite.model;

import android.content.ContentValues;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;

import java.util.Date;

public class ContatoDao {
    public  boolean salvar(Contato contato) {
        ContentValues values = new ContentValues();
        values.put("data_cadastro", new Date().toString());
        values.put("nome", contato.getNome());
        values.put("sexo", contato.getSexo());
        values.put("endereco", contato.getEndereco());
        values.put("data_nascimento", contato.getDataNascimento());
        values.put("cpf", contato.getCpf());
        values.put("telefone", contato.getTelefone());
        values.put("empresa", contato.getEmpresa());
        values.put("email", contato.getEmail());

        SQLiteDatabase conn = Conexao.getConexao();
        try {
            conn.insertOrThrow("contato", null, values);
            return true;
        } catch (SQLiteConstraintException e) {
            return false;
        }

    }

}
