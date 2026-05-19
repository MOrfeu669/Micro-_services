package br.edu.atitus.currencyservice.dtos;

import java.util.List;

/**
 * DTO que representa a resposta da API PTAX do Banco Central do Brasil.
 * A API retorna um objeto com campo "value" contendo a lista de cotações.
 *
 * Exemplo de resposta JSON:
 * {
 *   "value": [
 *     {
 *       "cotacaoCompra": 5.12,
 *       "cotacaoVenda": 5.13,
 *       "dataHoraCotacao": "2025-05-16 13:07:27.279"
 *     }
 *   ]
 * }
 */
public record BCBCurrencyDTO(List<BCBCotacaoDTO> value) {

    public record BCBCotacaoDTO(
            Double cotacaoCompra,
            Double cotacaoVenda,
            String dataHoraCotacao
    ) {}
}
