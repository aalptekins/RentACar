//package com.alptekin.rentACar.dataAccess.concretes;
//
//import com.alptekin.rentACar.dataAccess.abstracts.BrandRepository;
//import com.alptekin.rentACar.entities.concretes.Brand;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class InMemoryBrandRepository implements BrandRepository {
//
//    List<Brand> brands;
//    public InMemoryBrandRepository(){
//        brands = new ArrayList<>();
//        brands.add(new Brand(1,"Mercedes"));
//        brands.add(new Brand(2,"Fiat"));
//        brands.add(new Brand(3,"BMW"));
//        brands.add(new Brand(4,"Renault"));
//        brands.add(new Brand(5,"Scoda"));
//        brands.add(new Brand(6,"Peugeout"));
//    }
//    @Override
//    public List<Brand> getAll() {
//        return brands;
//    }
//}
