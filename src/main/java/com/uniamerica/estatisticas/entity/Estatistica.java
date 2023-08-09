package com.uniamerica.estatisticas.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
@Data
public class Estatistica {
    private List<BigDecimal> valores;
    private BigDecimal media;
    private BigDecimal desvio_padrao;
    private BigDecimal mediana;
    private BigDecimal quantidade_dados_fornecidos;
}
