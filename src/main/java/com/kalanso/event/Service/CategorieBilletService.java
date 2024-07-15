package com.kalanso.event.Service;

import com.kalanso.event.Model.CategorieBillet;
import com.kalanso.event.Repository.CategorieBilletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieBilletService {

    @Autowired
    private CategorieBilletRepository categorieBilletRepository;

    public List<CategorieBillet> getAllCategories() {
        return categorieBilletRepository.findAll();
    }

    public Optional<CategorieBillet> getCategorieById(Long id) {
        return categorieBilletRepository.findById(id);
    }

    public CategorieBillet createCategorie(CategorieBillet categorieBillet) {
        return categorieBilletRepository.save(categorieBillet);
    }

    public CategorieBillet updateCategorie(Long id, CategorieBillet categorieBillet) {
        return categorieBilletRepository.findById(id)
                .map(existingCategorie -> {
                    existingCategorie.setNom(categorieBillet.getNom());
                    existingCategorie.setDescription(categorieBillet.getDescription());
                    // Ne pas modifier dateCreation lors de la mise à jour
                    return categorieBilletRepository.save(existingCategorie);
                })
                .orElseThrow(() -> new RuntimeException("Catégorie non trouvée"));
    }

    public void deleteCategorie(Long id) {
        categorieBilletRepository.deleteById(id);
    }

}
