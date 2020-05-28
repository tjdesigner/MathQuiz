package tjdev.mathquiz.com.br.model;
import java.util.ArrayList;
import java.util.List;

public class QuestaoRepositorio {
    public List<Questao> getListaQuestoes() {
        return new ArrayList<Questao>() {{
            add(new Questao("Em uma loja de roupas são vendidas 1500 roupas por dia durante 7 dias." +
                    "Em quantos dias serão vendidas 200 roupas?", 1, 3));

            add(new Questao("Numa churrascaria são assados 5 porcos, de um total de 10. Sendo necessário" +
                    "assar 3 porcos para 50 pessoas, quantos porcos precisarão ser assados para 250 pessoas?", 15, 20));

            add(new Questao("Numa gráfica existem 3 impressoras que funcionam ininterruptamente, 10" +
                    "horas por dia, durante 4 dias, imprimindo 240.000 folhas. Tendo-se quebrado umas" +
                    "das impressoras e necessitando-se imprimir 480.000 folhas em 6 dias, quantas horas por" +
                    "dia deverão funcionar ininterruptamente as duas máquinas restantes?", 20, 10));

            add(new Questao("Aplicando R$ 500,00 na poupança o valor dos juros em um mês seria de R$ 2,50." +
                    "Caso seja aplicado R$ 2100,00 no mesmo mês, qual seria o valor dos juros?", 14, 10.5));

            add(new Questao("Uma usina produz 500 litros de álcool com 6000 kg de cana-de-açúcar." +
                    "Determine quantos litros de álcool são produzidos com 15000 kg de cana.", 750, 1250));

            add(new Questao("Com duantos paus se faz uma canoa", 500, 501));
        }};
    }
}
