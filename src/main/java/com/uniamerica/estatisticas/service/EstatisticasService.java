package com.uniamerica.estatisticas.service;

import com.uniamerica.estatisticas.entity.Estatistica;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;

@Service
public class EstatisticasService {
    public Estatistica calculaTodos(Estatistica estatistica) {
        final List<Double> valores =estatistica.getValores() ;
        Double qntd = (double) valores.size();
        Double soma = calculaSoma(valores);
        Double media = calculaMedia(valores, soma);
        Double mediana = calculaMediana(valores);
        Double desvio = calculaDesvio(valores, media);

        estatistica.setMediana(mediana);
        estatistica.setMedia(media);
        estatistica.setQuantidade_dados_fornecidos(qntd);
        estatistica.setDesvio_padrao(desvio);

        return estatistica;
    }

    public Double calculaDesvio(List<Double> valores, Double media) {
        double desvio;
        double somatoria =  0;
        for (Double valor:
             valores) {
            Double distancia = Math.abs(valor - media);
            somatoria += distancia * distancia;
        }
        desvio = somatoria / valores.size();
        MathContext mc
                = new MathContext(10);

        return Math.sqrt(desvio);
    }

    public Double calculaMediana(List<Double> valores) {
        Collections.sort(valores);
        double qntd = valores.size();
        double mediana;
        int meio = (int) Math.floor(qntd/2);
        if(qntd%2!=0){
            mediana = valores.get(meio);
        }else{
            mediana = valores.get(meio-1) + (valores.get(meio) / 2);
        }
        return (double) Math.round(mediana);
    }

    public Double calculaSoma(List<Double> valores) {
        Double soma = (double) 0;
        for (Double valor:
                valores) {
            soma += valor;
        }
        return soma;
    }

    public Double calculaMedia(List<Double> valores, Double soma){

        return soma / valores.size();
    }
}
