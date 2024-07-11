package com.kalanso.gevent.Service;

import com.kalanso.gevent.Model.AvoirLieu;
import com.kalanso.gevent.Repository.AvoirLieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvoirLieuService {

    @Autowired
    private AvoirLieuRepository avoirLieuRepository;

    public AvoirLieu saveAvoirLieu(AvoirLieu avoirLieu) {
        return avoirLieuRepository.save(avoirLieu);
    }

    public AvoirLieu getAvoirLieuById(Long id) {
        return avoirLieuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Relation AvoirLieu non trouvée avec l'ID : " + id));
    }

    public List<AvoirLieu> getAllAvoirLieux() {
        return avoirLieuRepository.findAll();
    }

    public AvoirLieu updateAvoirLieu(Long id, AvoirLieu avoirLieuDetails) {
        AvoirLieu avoirLieu = getAvoirLieuById(id);
        avoirLieu.setEvenement(avoirLieuDetails.getEvenement());
        avoirLieu.setLieu(avoirLieuDetails.getLieu());
        return avoirLieuRepository.save(avoirLieu);
    }

    public void deleteAvoirLieu(Long id) {
        AvoirLieu avoirLieu = getAvoirLieuById(id);
        avoirLieuRepository.delete(avoirLieu);
    }
}

