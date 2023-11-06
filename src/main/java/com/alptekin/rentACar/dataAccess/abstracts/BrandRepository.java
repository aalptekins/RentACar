package com.alptekin.rentACar.dataAccess.abstracts;
import com.alptekin.rentACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface BrandRepository extends JpaRepository<Brand,Integer> {

   //this is created while working with inmemory class.
//   List<Brand> getAll();

    boolean existsByName(String name);

}
