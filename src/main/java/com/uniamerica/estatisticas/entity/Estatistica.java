package com.uniamerica.estatisticas.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
@Data
public class Estatistica {
    private List<Double> valores;
    private Double media;
    private Double desvio_padrao;
    private Double mediana;
    private Double quantidade_dados_fornecidos;
}
