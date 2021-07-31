package br.utfpr.spinner1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerLinguagens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerLinguagens = findViewById(R.id.spinnerOpcoes);
        popularSpinner();
    }

    private void popularSpinner(){
        List<String> lista = new ArrayList<>();

        //conteudo do Spinner
        lista.add(getString(R.string.java));
        lista.add(getString(R.string.cobol));
        lista.add(getString(R.string.pascal));

        //Adapter(contexto, layout opção da SDK, array conteúdo)
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);

        //Relacionar spinner com adapter
        spinnerLinguagens.setAdapter(adapter);
    }

    public void mostrarSelecionado(View view){

        String linguagemSelecionada = (String) spinnerLinguagens.getSelectedItem();
        String mensagem = "";
        if(linguagemSelecionada != null){
            mensagem = linguagemSelecionada + getString(R.string.foi_selecionado);
        }else{
            mensagem = getString(R.string.nenhuma_linguagem_selecionado);
        }
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }
}