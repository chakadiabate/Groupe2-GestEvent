package com.kalanso.event.Service;

import com.kalanso.event.Model.Client;

import java.util.List;

public interface ClientSercive {
    Client creerClient(Client client);
    List<Client> listerClient();
    Client modifierClient(Integer id,Client client);
    String supprimerClient(Integer id);
}
