package com.kalanso.gevent.Service;

import com.kalanso.gevent.Model.Posseder;
import com.kalanso.gevent.Repository.PossederRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PossederService {

    @Autowired
    private PossederRepository possederRepository;

    public Posseder savePosseder(Posseder posseder) {
        return possederRepository.save(posseder);
    }

    public Posseder getPossederById(Long id) {
        return possederRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Relation Posseder non trouvée avec l'ID : " + id));
    }

    public List<Posseder> getAllPosseders() {
        return possederRepository.findAll();
    }

    public Posseder updatePosseder(Long id, Posseder possederDetails) {
        Posseder posseder = getPossederById(id);
        posseder.setEvenement(possederDetails.getEvenement());
        posseder.setTypeTicket(possederDetails.getTypeTicket());
        return possederRepository.save(posseder);
    }

    public void deletePosseder(Long id) {
        Posseder posseder = getPossederById(id);
        possederRepository.delete(posseder);
    }
}

