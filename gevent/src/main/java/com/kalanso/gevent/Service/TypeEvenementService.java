package com.kalanso.gevent.Service;


import com.kalanso.gevent.Model.TypeEvenement;
import com.kalanso.gevent.Repository.TypeEvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeEvenementService {

    @Autowired
    private TypeEvenementRepository typeEvenementRepository;

    public TypeEvenement saveTypeEvenement(TypeEvenement typeEvenement) {
        return typeEvenementRepository.save(typeEvenement);
    }

    public TypeEvenement getTypeEvenementById(Long id) {
        return typeEvenementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Type d'événement non trouvé avec l'ID : " + id));
    }

    public List<TypeEvenement> getAllTypeEvenements() {
        return typeEvenementRepository.findAll();
    }

    public TypeEvenement updateTypeEvenement(Long id, TypeEvenement typeEvenementDetails) {
        TypeEvenement typeEvenement = getTypeEvenementById(id);
        typeEvenement.setNom(typeEvenementDetails.getNom());
        return typeEvenementRepository.save(typeEvenement);
    }

    public void deleteTypeEvenement(Long id) {
        TypeEvenement typeEvenement = getTypeEvenementById(id);
        typeEvenementRepository.delete(typeEvenement);
    }
}

