package com.project.colochub.Services;

import com.project.colochub.DTO.Request.OfferReq;
import com.project.colochub.DTO.Response.OfferDto;
import com.project.colochub.Exceptions.Exception.InvalidCredentials;
import com.project.colochub.Exceptions.Exception.NotFound;
import com.project.colochub.Exceptions.Exception.OperationFailed;
import com.project.colochub.Mappers.Mapper;
import com.project.colochub.Models.Entities.Offer;
import com.project.colochub.Repositories.OfferRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {
    private final OfferRepository offerRepo;
    private final Mapper<Offer, OfferDto> offerMapper;

    public OfferService(OfferRepository offerRepo, Mapper<Offer, OfferDto> offerMapper) {
        this.offerRepo = offerRepo;
        this.offerMapper = offerMapper;
    }

    public List<OfferDto> getAllOffers(){
        return offerRepo.findAll().stream().map(offerMapper::mapTo).toList();
    }

    public OfferDto addOffer(OfferReq offerReq) throws OperationFailed{
        if (offerReq != null){
            return offerMapper.mapTo(offerRepo.save(offerReq.toModel()));
        }else {
            throw new InvalidCredentials("Invalid credentials in the request !");
        }
    }

    public boolean deleteOffer(Integer offer_id){
        if (offer_id > 0){
            if (offerRepo.findById(offer_id).isPresent()){
                offerRepo.deleteById(offer_id);
                return true;
            }else {
                throw new NotFound("Offer not found with id : "+offer_id);
            }
        }else {
            throw new InvalidCredentials("Invalid offer id!");
        }
    }
}
