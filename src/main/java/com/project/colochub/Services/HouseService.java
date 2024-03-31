package com.project.colochub.Services;

import com.project.colochub.DTO.Request.HouseReq;
import com.project.colochub.DTO.Response.HouseDto;
import com.project.colochub.Exceptions.Exception.InvalidCredentials;
import com.project.colochub.Exceptions.Exception.NotFound;
import com.project.colochub.Mappers.Mapper;
import com.project.colochub.Models.Entities.House;
import com.project.colochub.Repositories.HouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService {
    private final HouseRepository houseRepo;
    private final Mapper<House,HouseDto> mapper;

    public HouseService(HouseRepository houseRepo, Mapper<House, HouseDto> mapper) {
        this.houseRepo = houseRepo;
        this.mapper = mapper;
    }

    public List<HouseDto> getAllHouses(){
        return houseRepo.findAll().stream().map(mapper::mapTo).toList();
    }

    public HouseDto addHouse(HouseReq houseReq){
        if (houseReq != null){
            return mapper.mapTo(houseRepo.save(houseReq.toModel()));
        }else {
            throw new InvalidCredentials("Invalid credentials or credentials missing !");
        }
    }

    public boolean deleteHouse(Integer houseId){
        if (houseId > 0){
            if (houseRepo.findById(houseId).isPresent()){
                houseRepo.deleteById(houseId);
                return true;
            }else {
                throw new NotFound("Couldn't find the house with this id : "+houseId);
            }
        }else {
            throw new InvalidCredentials("Couldn't find the house id to proceed !");
        }
    }
}
