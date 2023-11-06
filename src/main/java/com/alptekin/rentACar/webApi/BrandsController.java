package com.alptekin.rentACar.webApi;

import com.alptekin.rentACar.business.abstracts.BrandService;
import com.alptekin.rentACar.business.requests.CreateBrandRequest;
import com.alptekin.rentACar.business.requests.UpdateBrandRequest;
import com.alptekin.rentACar.business.responses.GetAllBrandsResponse;
import com.alptekin.rentACar.business.responses.GetByIdBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class BrandsController {

    private final BrandService brandService;

    @GetMapping("/getAll")
    public List<GetAllBrandsResponse> getAll(){
        return brandService.getAll();
    }
    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id){
        return brandService.getById(id);
    }
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateBrandRequest createBrandRequest){
        brandService.add(createBrandRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        brandService.delete(id);
    }
}
