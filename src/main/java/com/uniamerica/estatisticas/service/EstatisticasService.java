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
        final List<BigDecimal> valores =estatistica.getValores() ;
        BigDecimal qntd = BigDecimal.valueOf(valores.size());
        BigDecimal soma = calculaSoma(valores);
        BigDecimal media = calculaMedia(valores, soma);
        BigDecimal mediana = calculaMediana(valores);
        BigDecimal desvio = calculaDesvio(valores, media);

        estatistica.setMediana(mediana);
        estatistica.setMedia(media);
        estatistica.setQuantidade_dados_fornecidos(qntd);
        estatistica.setDesvio_padrao(desvio);

        return estatistica;
    }

    private BigDecimal calculaDesvio(List<BigDecimal> valores, BigDecimal media) {
        BigDecimal desvio;
        BigDecimal somatoria = BigDecimal.valueOf(0);
        for (BigDecimal valor:
             valores) {
            BigDecimal distancia = valor.subtract(media).abs();
            somatoria = somatoria.add(distancia.pow(2));
        }
        desvio = somatoria.divide(BigDecimal.valueOf(valores.size()), RoundingMode.CEILING).round(new MathContext(10));
        MathContext mc
                = new MathContext(10);

        return desvio.sqrt(mc).round(new MathContext(10));
    }

    private BigDecimal calculaMediana(List<BigDecimal> valores) {
        Collections.sort(valores);
        double qntd = valores.size();
        BigDecimal mediana;
        int meio = (int) Math.floor(qntd/2);
        if(qntd%2!=0){
            mediana = valores.get(meio);
        }else{
            mediana = valores.get(meio-1).add(valores.get(meio)).divide(BigDecimal.valueOf(2));
        }
        return mediana.round(new MathContext(10));
    }

    private BigDecimal calculaSoma(List<BigDecimal> valores) {
        BigDecimal soma = BigDecimal.valueOf(0);
        for (BigDecimal valor:
                valores) {
            soma = soma.add(valor);
        }
        return soma;
    }

    public BigDecimal calculaMedia(List<BigDecimal> valores, BigDecimal soma){

        return soma.divide(BigDecimal.valueOf(valores.size()), RoundingMode.CEILING).round(new MathContext(10));
    }
}
