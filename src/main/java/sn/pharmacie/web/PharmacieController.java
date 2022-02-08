package sn.pharmacie.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import sn.pharmacie.dao.IPharmacie;
import sn.pharmacie.domaine.Pharmacie;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/")
public class PharmacieController {

    @Autowired
    private IPharmacie pharmacieRepository;

    @GetMapping("/pharmacies")
    public List<Pharmacie> listAll(){
        return pharmacieRepository.findAll();
    }

    @GetMapping("/pharmacies/{id}")
    public Pharmacie getPharmacie(@PathVariable int id) {
        Optional<Pharmacie> pharmacieOptional = pharmacieRepository.findById(id);

        if (!pharmacieOptional.isPresent())
            return null;
        return pharmacieOptional.get();
    }

    @PostMapping("/pharmacies")
    public ResponseEntity<Object> createPharmacie(@RequestBody Pharmacie pharmacie) {
        Pharmacie savedPharmacie = pharmacieRepository.save(pharmacie);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedPharmacie.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/pharmacies/{id}")
    public ResponseEntity<Object> updatePharmacie(@RequestBody Pharmacie pharmacie, @PathVariable int id) {

        Optional<Pharmacie> pharmacieOptional = pharmacieRepository.findById(id);

        if (!pharmacieOptional.isPresent())
            return ResponseEntity.notFound().build();

        pharmacie.setNom(pharmacie.getNom());
        pharmacie.setQuartier(pharmacie.getQuartier());
        pharmacie.setVille(pharmacie.getVille());
        pharmacie.setEtat(pharmacie.getEtat());

        pharmacieRepository.save(pharmacie);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/pharmacies/{id}")
    public void deletePharmacie(@PathVariable int id) {
       pharmacieRepository.deleteById(id);
    }
}
