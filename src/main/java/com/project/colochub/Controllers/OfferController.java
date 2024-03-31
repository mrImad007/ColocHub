package com.project.colochub.Controllers;

import com.project.colochub.DTO.Request.OfferReq;
import com.project.colochub.DTO.Response.OfferDto;
import com.project.colochub.Services.OfferService;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/offers")
public class OfferController {
    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping
    public List<OfferDto> getAllOffers(){
        return offerService.getAllOffers();
    }

    @PostMapping
    public OfferDto addOffer(@RequestBody @NotNull OfferReq offerReq){
        return offerService.addOffer(offerReq);
    }

    @DeleteMapping("/{offer_id}")
    public boolean deleteOffer(@PathVariable Integer offer_id){
        return offerService.deleteOffer(offer_id);
    }
}
