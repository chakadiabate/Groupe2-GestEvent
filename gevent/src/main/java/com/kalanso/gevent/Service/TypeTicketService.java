package com.kalanso.gevent.Service;

import com.kalanso.gevent.Model.TypeTicket;
import com.kalanso.gevent.Repository.TypeTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeTicketService {

    @Autowired
    private TypeTicketRepository typeTicketRepository;

    public TypeTicket saveTypeTicket(TypeTicket typeTicket) {
        return typeTicketRepository.save(typeTicket);
    }

    public TypeTicket getTypeTicketById(Long id) {
        return typeTicketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Type de ticket non trouvé avec l'ID : " + id));
    }

    public List<TypeTicket> getAllTypeTickets() {
        return typeTicketRepository.findAll();
    }

    public TypeTicket updateTypeTicket(Long id, TypeTicket typeTicketDetails) {
        TypeTicket typeTicket = getTypeTicketById(id);
        typeTicket.setNom(typeTicketDetails.getNom());
        return typeTicketRepository.save(typeTicket);
    }

    public void deleteTypeTicket(Long id) {
        TypeTicket typeTicket = getTypeTicketById(id);
        typeTicketRepository.delete(typeTicket);
    }
}

