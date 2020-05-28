package tjdev.mathquiz.com.br.controller;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.text.NumberFormat;
        import java.text.ParseException;
        import java.util.Locale;

        import tjdev.mathquiz.com.br.R;
        import tjdev.mathquiz.com.br.model.AnalisadorQuestao;
        import tjdev.mathquiz.com.br.model.Questao;
        import tjdev.mathquiz.com.br.model.QuestaoRepositorio;

public class MainActivity extends AppCompatActivity {

    public static final String INDICE_QUESTAO = "INDICE_QUESTAO";
    private final Locale locale = new Locale("pt", "BR");
    private QuestaoRepositorio repositorio = new QuestaoRepositorio();
    private int indiceQuestao = 0;
    private TextView textViewTextoPergunta;
    private Button botaoResposta1;
    private Button botaoResposta2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Questao questao = repositorio.getListaQuestoes().get(indiceQuestao);

        textViewTextoPergunta = findViewById(R.id.texto_pergunta_textview);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String resposta = ((Button)v).getText().toString();

                AnalisadorQuestao analisadorQuestao = new AnalisadorQuestao();
                Questao questao = repositorio.getListaQuestoes().get(indiceQuestao);

                String mensagem;

                try {
                    NumberFormat format = NumberFormat.getInstance(locale);
                    Number number = format.parse(resposta);

                    if (analisadorQuestao.isRespostaCorreta(questao, number.doubleValue())) {
                        mensagem = "Parabéns, resposta correta!";
                    } else {
                        mensagem = "Aah, resposta errada :(";
                    }
                } catch(ParseException e) {
                    mensagem = e.getMessage();
                }

                Toast.makeText(MainActivity.this, mensagem, Toast.LENGTH_SHORT).show();
            }
        };

        botaoResposta1 = findViewById(R.id.opcao1_button);
        botaoResposta1.setOnClickListener(listener);

        botaoResposta2 = findViewById(R.id.opcao2_button);
        botaoResposta2.setOnClickListener(listener);

        View.OnClickListener listenerProximaPergunta = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                indiceQuestao++;

                if (indiceQuestao >= repositorio.getListaQuestoes().size()) {
                    indiceQuestao = 0;
                }

                exibirQuestao(indiceQuestao);
            }
        };

        Button botaoProximaPergunta = findViewById(R.id.proxima_pergunta_button);
        botaoProximaPergunta.setOnClickListener(listenerProximaPergunta);

        if(savedInstanceState != null) {
            indiceQuestao = savedInstanceState.getInt(INDICE_QUESTAO);
        }

        exibirQuestao(indiceQuestao);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(INDICE_QUESTAO, indiceQuestao);
    }

    public void exibirQuestao(final int indice_questao) {
        Questao questao = repositorio.getListaQuestoes().get(indice_questao);

        textViewTextoPergunta.setText(questao.getTexto());

        String respostaCorreta = String.format(locale, "%.2f", questao.getRespostaCorreta());
        String respostaIncorreta = String.format(locale, "%.2f", questao.getRespostaIncorreta());

        botaoResposta1.setText(respostaCorreta);
        botaoResposta2.setText(respostaIncorreta);
    }
}
