package com.team1.veterinary.controller;

import com.team1.veterinary.model.VeterinaryService;
import com.team1.veterinary.service.VeterinaryServiceService;
import org.hibernate.type.OrderedMapType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/veterinaryServices")
//@Api(tags = "Veterinary Services")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5173"})
public class VeterinaryServiceController {
    @Autowired
    private VeterinaryServiceService veterinaryServiceService;
    
    @GetMapping
    public List<VeterinaryService> getAllVeterinaryServices(){
        return veterinaryServiceService.getAllVeterinaryServices();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<VeterinaryService> getVeterinaryServiceById(@PathVariable Long id) {
        VeterinaryService veterinaryService = veterinaryServiceService.getVeterinaryServiceById(id);
        return ResponseEntity.ok(veterinaryService);
    }

    @PostMapping
    public ResponseEntity<VeterinaryService> createVeterinaryService(@RequestBody VeterinaryService veterinaryService) {
        VeterinaryService createdService = veterinaryServiceService.createVeterinaryService(veterinaryService);
        return new ResponseEntity<>(createdService, HttpStatus.CREATED);
    }
    
    @PostMapping("/group")
    public ResponseEntity<List<VeterinaryService>> createVeterinaryServiceGroup(@RequestBody List<VeterinaryService> veterinaryServices){
        List<VeterinaryService> temp=new ArrayList<VeterinaryService>();

        veterinaryServices.forEach(veterinaryService->temp.add(veterinaryServiceService.createVeterinaryService(veterinaryService)));
        
        return new ResponseEntity<>(temp, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeterinaryService> putVeterinaryServiceById(@PathVariable Long id, @RequestBody VeterinaryService updatedService) {
        VeterinaryService result = veterinaryServiceService.putVeterinaryServiceById(id, updatedService);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<VeterinaryService> patchVeterinaryServiceById(@PathVariable Long id, @RequestBody VeterinaryService partialUpdate) {
        VeterinaryService result = veterinaryServiceService.patchVeterinaryServiceById(id, partialUpdate);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteVeterinaryServiceById(@PathVariable Long id) {
        try {
            VeterinaryService veterinaryServiceSearched = veterinaryServiceService.getVeterinaryServiceById(id);
            veterinaryServiceService.deleteVeterinaryServiceById(id);
            return ResponseEntity.ok("Servicio eliminado");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Servicio no encontrado");
        }
    }

    @DeleteMapping("/delete/group")
    public ResponseEntity<String> deleteVeterinaryServicesByIds(@RequestBody List<Long> ids) {
        if (ids == null || ids.isEmpty()) {
            return ResponseEntity.badRequest().body("Lista de IDs vacía");
        }

        veterinaryServiceService.deleteVeterinaryServicesByIds(ids);
        return ResponseEntity.ok("Servicios eliminados");
    }
}
