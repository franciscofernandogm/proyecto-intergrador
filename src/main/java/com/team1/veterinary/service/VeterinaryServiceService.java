package com.team1.veterinary.service;

import com.team1.veterinary.model.VeterinaryService;
import com.team1.veterinary.repository.VeterinaryServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeterinaryServiceService {
    @Autowired
    private VeterinaryServiceRepository veterinaryServiceRepository;
    
    public List<VeterinaryService> getAllVeterinaryServices(){
        return veterinaryServiceRepository.findAll();
    }

    public VeterinaryService getVeterinaryServiceById(Long id) {
        return veterinaryServiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veterinary Service not found"));
    }

    public VeterinaryService createVeterinaryService(VeterinaryService veterinaryService) {
        return veterinaryServiceRepository.save(veterinaryService);
    }

    public VeterinaryService putVeterinaryServiceById(Long id, VeterinaryService updatedService) {
        VeterinaryService existingService = veterinaryServiceRepository.findById(id).orElseThrow(() -> new RuntimeException("Service not found"));

        existingService.setName(updatedService.getName());
        existingService.setDescription(updatedService.getDescription());
        existingService.setPrice(updatedService.getPrice());
        existingService.setImageUrl(updatedService.getImageUrl());

        return veterinaryServiceRepository.save(existingService);
    }

    public VeterinaryService patchVeterinaryServiceById(Long id, VeterinaryService partialUpdate) {
        VeterinaryService existingService = veterinaryServiceRepository.findById(id).orElseThrow(() -> new RuntimeException("Service not found"));

        if (partialUpdate.getName() != null) {
            existingService.setName(partialUpdate.getName());
        }
        if (partialUpdate.getDescription() != null) {
            existingService.setDescription(partialUpdate.getDescription());
        }
        if (partialUpdate.getPrice() != null) {
            existingService.setPrice(partialUpdate.getPrice());
        }
        if (partialUpdate.getImageUrl() != null) {
            existingService.setImageUrl(partialUpdate.getImageUrl());
        }

        return veterinaryServiceRepository.save(existingService);
    }

    public void deleteVeterinaryServiceById(Long id) {
        veterinaryServiceRepository.deleteById(id);
    }

    public void deleteVeterinaryServicesByIds(List<Long> ids) {
        veterinaryServiceRepository.deleteAllById(ids);
    }
}
