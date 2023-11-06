package com.alptekin.rentACar.webApi;

import com.alptekin.rentACar.business.abstracts.ModelService;
import com.alptekin.rentACar.business.requests.CreateModelRequest;
import com.alptekin.rentACar.business.responses.GetAllModelsResponse;
import com.alptekin.rentACar.business.responses.GetByIdModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {

    private final ModelService modelService;

    @GetMapping("/getAll")
    public List<GetAllModelsResponse> getAll(){
        return modelService.getAll();
    }
    @GetMapping("/{id}")
    public GetByIdModelResponse getById(@PathVariable int id){
        return modelService.getById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateModelRequest createModelRequest){
        modelService.add(createModelRequest);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        modelService.delete(id);
    }
}
