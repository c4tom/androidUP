package up.edu.br.jokempo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int contadorJogador=0;
    private int contadorComputador=0;
    private int contadorEmpate=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void jogar(View view) {
        ImageButton btnJogador = findViewById(R.id.btnJogador);
        int j = 0;
        if(view.getId() == R.id.btnPapel){
            btnJogador.setImageResource(R.drawable.papel);
        }
        if(view.getId() == R.id.btnPedra){
            btnJogador.setImageResource(R.drawable.pedra);
            j = 1;
        }
        if(view.getId() == R.id.btnTesoura){
            btnJogador.setImageResource(R.drawable.tesoura);
            j = 2;
        }

        int c = computador(view);
        ganhador(j, c, view);
    }

    public int computador(View view) {
        ImageButton btnComputador = findViewById(R.id.btnComputador);
        int random = new Random().nextInt(3);
        switch (random) {
            case 0: btnComputador.setImageResource(R.drawable.papel); break;
            case 1: btnComputador.setImageResource(R.drawable.pedra); break;
            case 2: btnComputador.setImageResource(R.drawable.tesoura); break;
        }
        return random;
    }

    public void ganhador(int j, int c, View view) {
        TextView txtResultado = findViewById(R.id.txtResultado);

        if(j == c) {
            contadorEmpate++;
        } else if (j == 0 && c == 1) {
            contadorJogador++;
        } else if (j == 1 && c == 2) {
            contadorJogador++;
        } else if (j == 2 && c == 0) {
            contadorJogador++;
        } else if (c == 0 && j == 1) {
            contadorComputador++;
        } else if (c == 1 && j == 2) {
            contadorComputador++;
        } else if (c == 2 && j == 0) {
            contadorComputador++;
        }

        txtResultado.setText("Placar:" + "\nComputador: " + contadorComputador + "\nJogador: " + contadorJogador + "\nEmpates: " + contadorEmpate );
    }

    public void zerarContador(View view) {
        contadorEmpate = 0;
        contadorJogador = 0;
        contadorComputador = 0;

        TextView txtResultado = findViewById(R.id.txtResultado);
        txtResultado.setText("");
    }

}
