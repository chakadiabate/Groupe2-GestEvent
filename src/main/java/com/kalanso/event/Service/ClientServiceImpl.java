package com.kalanso.event.Service;

import com.kalanso.event.Model.Client;
import com.kalanso.event.Repository.ClientRepo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Setter
@AllArgsConstructor
@Getter
@Service

public class ClientServiceImpl implements ClientSercive{

    private final ClientRepo clientRepo;

    @Override
    public Client creerClient(Client client) {
        return clientRepo.save(client);
    }

    @Override
    public List<Client> listerClient() {
        return clientRepo.findAll();
    }

    @Override
    public Client modifierClient(Long id, Client client) {
        return clientRepo.findById(id)
                .map(p->{
                    p.setNom(client.getNom());
                    p.setPrenom(client.getPrenom());
                    p.setEmail(client.getEmail());
                    p.setTelephone(client.getTelephone());
                    p.setMotDePasse(client.getMotDePasse());
                    return clientRepo.save(p);
                }).orElseThrow(()->new RuntimeException("Id non trouvé pour modifier le Client"));
    }

    @Override
    public String supprimerClient(Long id) {
        clientRepo.deleteById(id);
        return "Client supprimer";
    }
}
