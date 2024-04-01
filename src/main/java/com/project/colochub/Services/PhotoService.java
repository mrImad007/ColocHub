package com.project.colochub.Services;

import com.project.colochub.DTO.Response.PhotoDto;
import com.project.colochub.Mappers.Mapper;
import com.project.colochub.Models.Entities.Photo;
import com.project.colochub.Repositories.PhotoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {
    private final PhotoRepository photoRepo;
    private final Mapper<Photo, PhotoDto> photoMapper;
    public PhotoService(PhotoRepository photoRepo, Mapper<Photo, PhotoDto> photoMapper) {
        this.photoRepo = photoRepo;
        this.photoMapper = photoMapper;
    }

    public List<PhotoDto> getPhotoByHouseId(Integer house_id){
        return photoRepo.findByHouseId(house_id).stream().map(photoMapper::mapTo).toList();
    }

    public PhotoDto addPhoto(PhotoDto photoDto){
        if (photoDto != null){
            return photoMapper.mapTo(photoRepo.save(photoMapper.mapFrom(photoDto)));
        }else {
            throw new RuntimeException("Invalid credentials in the request !");
        }
    }
}
