package com.project.colochub.Controllers;

import com.project.colochub.DTO.Request.HouseReq;
import com.project.colochub.DTO.Response.HouseDto;
import com.project.colochub.Services.HouseService;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/houses")
public class HouseController {
    private final HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping
    public List<HouseDto> getAllHouses(){
        return houseService.getAllHouses();
    }

    @PostMapping
    public HouseDto addHouse(@RequestBody @NotNull HouseReq houseReq){
        System.out.println("House request : ============> : "+houseReq);
        return houseService.addHouse(houseReq);
    }

    @DeleteMapping("/{house_id}")
    public boolean deleteHouse(@PathVariable Integer house_id){
        return houseService.deleteHouse(house_id);
    }
}
