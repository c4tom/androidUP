package up.edu.br.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.Script;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private double valorUm = 0d;
    private ArrayList<String> digitacao = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtResultado = findViewById(R.id.textResultado);
        txtResultado.setText(mostraValoresDigitados());
    }

    public void clicar(View view) {
        TextView txtResultado = findViewById(R.id.textResultado);

        CharSequence valorBotao = ((Button) view).getText();
        digitacao.add(valorBotao.toString());

        txtResultado.setText(mostraValoresDigitados());
    }

    public void limpaUltimo() {
        TextView txtResultado = findViewById(R.id.textResultado);
        int size = digitacao.size();

        if(size == 0) {
            return;
        }

        String remove = digitacao.remove(size - 1);
        txtResultado.setText(mostraValoresDigitados());
    }

    public void limpar(View view) {
        TextView txtResultado = findViewById(R.id.textResultado);
        digitacao.clear();
        txtResultado.setText(mostraValoresDigitados());
    }

    public String mostraValoresDigitados() {
        String retorno = "";
        for (String s: digitacao) {
            retorno += s;
        }
        return retorno;
    }

    public void calculaTudo() {

    }

    public boolean isOperador(String valor) {
        switch (valor) {
            case "+":
                return true;
            case "-":
                return true;
            case "*":
                return true;
            case "/":
                return true;
            default:
                return false;
        }
    }

    public double soma(double a, double b) {
        return a + b;
    }

    public double subtracao(double a, double b) {
        return a - b;
    }

    public double multiplicacao(double a, double b) {
        return a * b;
    }

    public double divisao(double a, double b) {
        return a / b;
    }
 }
