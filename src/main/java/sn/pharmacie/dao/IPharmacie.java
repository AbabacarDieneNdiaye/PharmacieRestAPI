package sn.pharmacie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.pharmacie.domaine.Pharmacie;

public interface IPharmacie extends JpaRepository<Pharmacie, Integer> {
    //more qeries here

}
