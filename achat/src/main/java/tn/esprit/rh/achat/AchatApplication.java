package tn.esprit.rh.achat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class AchatApplication {

    public static void main(String[] args) {
        SpringApplication.run(AchatApplication.class, args);
    }

}


while ($true) {
    $endpoints = @(
        "http://localhost:8089/SpringMVC/categorieProduit/retrieve-all-categorieProduit",
        "http://localhost:8089/SpringMVC/produit/retrieve-all-produits",
        "http://localhost:8089/SpringMVC/fournisseur/retrieve-all-fournisseurs",
        "http://localhost:8089/SpringMVC/stock/retrieve-all-stocks",
        "http://localhost:8089/SpringMVC/secteurActivite/retrieve-all-secteurActivite",
        "http://localhost:8089/SpringMVC/operateur/retrieve-all-operateurs",
        "http://localhost:8089/SpringMVC/facture/retrieve-all-factures",
        "http://localhost:8089/SpringMVC/reglement/retrieve-all-reglements",
        "http://localhost:8089/SpringMVC/actuator/health"
    )
    $url = $endpoints | Get-Random
    try {
        Invoke-WebRequest -Uri $url -UseBasicParsing -TimeoutSec 5 | Out-Null
        Write-Host "OK  - $url"
    } catch {
        Write-Host "ERR - $url"
    }
    Start-Sleep -Milliseconds 500
}
