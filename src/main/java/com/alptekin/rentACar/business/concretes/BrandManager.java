package com.alptekin.rentACar.business.concretes;

import com.alptekin.rentACar.business.abstracts.BrandService;
import com.alptekin.rentACar.business.requests.CreateBrandRequest;
import com.alptekin.rentACar.business.requests.UpdateBrandRequest;
import com.alptekin.rentACar.business.responses.GetAllBrandsResponse;
import com.alptekin.rentACar.business.responses.GetByIdBrandResponse;
import com.alptekin.rentACar.business.rules.exceptions.BrandBusinessRules;
import com.alptekin.rentACar.core.utilities.mappers.ModelMapperService;
import com.alptekin.rentACar.dataAccess.abstracts.BrandRepository;
import com.alptekin.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {
    private final BrandRepository brandRepository;
    private final ModelMapperService modelMapperService;
    private final BrandBusinessRules brandBusinessRules;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        //is kurallari
        List<Brand> brands = brandRepository.findAll();
//        List<GetAllBrandsResponse> brandsResponse = new ArrayList<>();
//        for (Brand brand:brands) {
//            GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
//            responseItem.setId(brand.getId());
//            responseItem.setName(brand.getName());
//
//            brandsResponse.add(responseItem);
//        }

        List<GetAllBrandsResponse> brandsResponse = brands.stream()
                .map(brand -> this.modelMapperService.forResponse()
                        .map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());

        return brandsResponse;
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse getByIdBrandResponse = this.modelMapperService
                .forResponse().map(brand, GetByIdBrandResponse.class);
        return getByIdBrandResponse;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
//        Brand brand = new Brand();
//        brand.setName(createBrandRequest.getName());
        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest()
                .map(updateBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }
}
