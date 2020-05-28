package tjdev.mathquiz.com.br.model;

public class AnalisadorQuestao {

    public boolean isRespostaCorreta(Questao questao, double resposta){
        return questao.getRespostaCorreta() == resposta;
    }
}
