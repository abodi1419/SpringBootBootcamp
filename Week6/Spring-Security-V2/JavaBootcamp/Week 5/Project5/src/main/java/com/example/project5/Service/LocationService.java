package com.example.project5.Service;

import com.example.project5.DTO.LocationDTO;
import com.example.project5.Exception.ApiException;
import com.example.project5.Model.Location;
import com.example.project5.Model.Store;
import com.example.project5.Repository.LocationRepository;
import com.example.project5.Repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;

    private final StoreRepository storeRepository;

    public List<Location> getLocations(){
        return locationRepository.findAll();
    }

    public void addStoreLocation(LocationDTO dto){
        Store store = storeRepository.findStoreById(dto.getStore_id());
        if (store == null)
            throw new ApiException("Store not found");
        Location location = new Location(null,dto.getArea(),dto.getStreet(),store);
        locationRepository.save(location);
    }

    public void updateStoreLocation(LocationDTO dto){
        Location location = locationRepository.findLocationById(dto.getStore_id());
        if (location == null)
            throw new ApiException("Store not found");
        location.setArea(dto.getArea());
        location.setStreet(dto.getStreet());
        locationRepository.save(location);
    }

    public void deleteStoreLocation(Integer id){
        Location location = locationRepository.findLocationById(id);

        if (location == null)
            throw new ApiException("location not found");

        locationRepository.delete(location);
    }
}
