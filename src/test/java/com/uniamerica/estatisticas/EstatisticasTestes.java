package com.uniamerica.estatisticas;

import com.uniamerica.estatisticas.entity.Estatistica;
import com.uniamerica.estatisticas.service.EstatisticasService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class EstatisticasTestes {
    @Test
    public void testSoma(){
        EstatisticasService estatistica = new EstatisticasService();
        List<Double> valores = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            valores.add((double) i);
        }
        Double soma = estatistica.calculaSoma(valores);
            Assertions.assertEquals(210, soma);
    }
    @Test
    public void testCalculoMedia(){
        EstatisticasService service = new EstatisticasService();
        Estatistica estatistica = new Estatistica();
        List<Double> valores = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            valores.add((double) i);
        }
        estatistica.setValores(valores);
        Double media = service.calculaTodos(estatistica).getMedia();
        Assertions.assertEquals(10.5, media);
    }

    @Test
    public void testCalculoMediana(){
        EstatisticasService service = new EstatisticasService();
        Estatistica estatistica = new Estatistica();
        List<Double> valores = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            valores.add((double) i);
        }
        estatistica.setValores(valores);
        Double mediana = service.calculaTodos(estatistica).getMediana();
        Assertions.assertEquals(10.5, mediana);
    }
    @Test
    public void testCalculoDesvio(){
        EstatisticasService service = new EstatisticasService();
        Estatistica estatistica = new Estatistica();
        List<Double> valores = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            valores.add((double) i);
        }
        estatistica.setValores(valores);
        Double mediana = service.calculaTodos(estatistica).getDesvio_padrao();
        Assertions.assertEquals(5.766281297335398, mediana);
    }
    @Test
    public void testCalculoMaximo(){
        EstatisticasService service = new EstatisticasService();
        Estatistica estatistica = new Estatistica();
        List<Double> valores = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            valores.add((double) i);
        }
        estatistica.setValores(valores);
        Double mediana = service.calculaTodos(estatistica).getMaximo();
        Assertions.assertEquals(20, mediana);
    }
    @Test
    public void testCalculoMinimo(){
        EstatisticasService service = new EstatisticasService();
        Estatistica estatistica = new Estatistica();
        List<Double> valores = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            valores.add((double) i);
        }
        estatistica.setValores(valores);
        Double minimo = service.calculaTodos(estatistica).getMinimo();
        Assertions.assertEquals(1, minimo);
    }


}
