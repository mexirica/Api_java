package com.api.service;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Service
public class DateTimeService {

    public static String ConverterData(Object args) {
        SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat formatoSaida = new SimpleDateFormat("dd/MM/yyyy");

        try {
            if (args instanceof String) {
                // Se for uma string, converte apenas essa string
                String dataString = (String) args;
                if (dataString != null && !dataString.isEmpty()) {
                    Date data = formatoEntrada.parse(dataString);
                    return formatoSaida.format(data);
                } else {
                    return "";
                }
            } else if (args instanceof String[]) {
                // Se for um array de strings, converte cada elemento do array
                String[] datasString = (String[]) args;
                String[] datasFormatadas = new String[datasString.length];

                for (int i = 0; i < datasString.length; i++) {
                    String dataString = datasString[i];
                    if (dataString != null && !dataString.isEmpty()) {
                        Date data = formatoEntrada.parse(dataString);
                        datasFormatadas[i] = formatoSaida.format(data);
                    } else {
                        datasFormatadas[i] = "";
                    }
                }

                return Arrays.toString(datasFormatadas);
            } else {
                throw new IllegalArgumentException("Argumento inválido. Esperava-se uma string ou um array de strings.");
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return null; // Ou uma outra ação adequada, caso ocorra uma exceção
        }
    }

}