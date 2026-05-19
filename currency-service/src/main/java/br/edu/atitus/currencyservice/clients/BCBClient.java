package br.edu.atitus.currencyservice.clients;

import br.edu.atitus.currencyservice.dtos.BCBCurrencyDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Cliente Feign para integração com a API do Banco Central do Brasil (PTAX).
 * Endpoint oficial: https://olinda.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata
 *
 * Exemplo de consulta de cotação USD->BRL:
 * /CotacaoMoedaDia(moeda=@moeda,dataCotacao=@dataCotacao)?@moeda='USD'&@dataCotacao='05-16-2025'&$format=json
 */
@FeignClient(
        name = "bcb-client",
        url = "${bcb.api.url}",
        fallback = BCBClientFallback.class
)
public interface BCBClient {

    @GetMapping("/CotacaoMoedaDia(moeda=@moeda,dataCotacao=@dataCotacao)")
    BCBCurrencyDTO getCotacaoMoedaDia(
            @RequestParam("@moeda") String moeda,
            @RequestParam("@dataCotacao") String dataCotacao,
            @RequestParam("$format") String format
    );
}
