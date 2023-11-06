package com.alptekin.rentACar.business.abstracts;


import com.alptekin.rentACar.business.requests.CreateModelRequest;
import com.alptekin.rentACar.business.responses.GetAllModelsResponse;
import com.alptekin.rentACar.business.responses.GetByIdBrandResponse;
import com.alptekin.rentACar.business.responses.GetByIdModelResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
    void add(CreateModelRequest createModelRequest);

    GetByIdModelResponse getById(int id);

    void delete(int id);
}
