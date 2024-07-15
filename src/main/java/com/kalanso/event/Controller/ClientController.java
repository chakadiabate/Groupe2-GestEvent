package com.kalanso.event.Controller;

import com.kalanso.event.Model.Client;
import com.kalanso.event.Service.ClientSercive;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Utilisateur/Client")
@AllArgsConstructor

public class ClientController {

    private final ClientSercive clientSercive;

    @PostMapping("/CreerClient")
    public Client creerClient(@RequestBody Client client){
        return clientSercive.creerClient(client);
    }

    @GetMapping("/ListeClient")
    List<Client> listerClient(){
        return clientSercive.listerClient();
    }

    @PutMapping("/ModifierClient")
    public Client modifierClient(@PathVariable Long id,@RequestBody Client client){
        return clientSercive.modifierClient(id, client);
    }

    @DeleteMapping("/SupprimerClient")
    public String supprimerClient(@PathVariable Long id){
        return clientSercive.supprimerClient(id);
    }

}
