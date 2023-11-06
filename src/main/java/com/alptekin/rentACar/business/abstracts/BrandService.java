package com.alptekin.rentACar.business.abstracts;

import com.alptekin.rentACar.business.requests.CreateBrandRequest;
import com.alptekin.rentACar.business.requests.UpdateBrandRequest;
import com.alptekin.rentACar.business.responses.GetAllBrandsResponse;
import com.alptekin.rentACar.business.responses.GetByIdBrandResponse;

import java.util.List;


public interface BrandService {

    List<GetAllBrandsResponse> getAll();
    GetByIdBrandResponse getById(int id);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);
}
