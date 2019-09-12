package up.edu.br.contatocomsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

import up.edu.br.contatocomsqlite.model.Conexao;
import up.edu.br.contatocomsqlite.model.Contato;
import up.edu.br.contatocomsqlite.model.ContatoDao;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // conectar ao banco no inicio
        new Conexao(getApplicationContext(), "contato.db", null, 1);
    }

    public void salvarContato(View view) {
        EditText txtNome = findViewById(R.id.txtNome);
        EditText txtEndereco = findViewById(R.id.txtEndereco);
        EditText txtTelefone = findViewById(R.id.txtTelefone);
        EditText txtDataNascimento = findViewById(R.id.txtDataNascimento);
        EditText txtCpf = findViewById(R.id.txtCPF);
        EditText txtEmpresa = findViewById(R.id.txtEmpresa);
        EditText txtEmail = findViewById(R.id.txtEmail);

        Contato contato = new Contato();
        contato.setDataCadastro(new Date().toString());
        contato.setNome(txtNome.getText().toString());
        contato.setEndereco(txtEndereco.getText().toString());
        contato.setTelefone(txtTelefone.getText().toString());
        contato.setDataNascimento(txtDataNascimento.getText().toString());
        contato.setCpf(txtCpf.getText().toString());
        contato.setEmpresa(txtEmpresa.getText().toString());
        contato.setEmail(txtEmail.getText().toString());

        // Salva no BD
        new ContatoDao().salvar(contato);

        // Mensagem global após salvar no banco
        Toast.makeText(getApplicationContext(),"Contato Salvo com Sucesso!!!", Toast.LENGTH_LONG).show();
    }
}
