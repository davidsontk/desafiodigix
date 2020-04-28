package com.digix.desafio.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

/**
 *
 * @author david
 */
public class UtilitariosHelper {

    public static Integer calcularIdade(Date dataNascimento) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dataNascimentoFormatada = format.format(dataNascimento);
        LocalDate hoje = LocalDate.now();
        LocalDate dataNasc = LocalDate.parse(dataNascimentoFormatada);

        Period periodo = Period.between(dataNasc, hoje);
        Integer diferenca = periodo.getYears();
        
        return diferenca;
    }

    public static String formatarData(Date data) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String dataFormatada = format.format(data);
        
        return dataFormatada;
    }
}
