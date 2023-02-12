package com.example.project5.Service;



import com.example.project5.DTO.LocationDTO;
import com.example.project5.Exception.ApiException;
import com.example.project5.Model.Location;
import com.example.project5.Model.Store;
import com.example.project5.Repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LocationService {
    private final LocationRepository locationRepository;
    private final StoreService storeService;



    public void addLocation(LocationDTO locationDTO){
        Store store = storeService.findById(locationDTO.getStore_id());
        Location location = new Location(locationDTO.getArea(), locationDTO.getStreet(), store);
        locationRepository.save(location);
    }

//    public Director findById(Integer id){
//        Director director =directorRepository.findDirectorById(id);
//        if(director==null){
//            throw new ApiException("Director not found",404);
//        }
//        return director;
//    }
//
//
//
    public void updateLocation(LocationDTO locationDTO){
        Location location = locationRepository.findLocationById(locationDTO.getStore_id());
        if(location ==null){
            throw new ApiException("Location not found!",404);
        }
        location.setArea(locationDTO.getArea());
        location.setStreet(locationDTO.getStreet());
        locationRepository.save(location);
    }

    public void deleteLocation(Integer id){
        Location location = locationRepository.findLocationById(id);
        if(location ==null){
            throw new ApiException("Location not found!",404);
        }
        locationRepository.delete(location);
    }
//
//
//
//    public List<Director> getDirectorsByName(String name){
//        List<Director> directors = directorRepository.findDirectorsByNameIsLike(name);
//        if(directors.isEmpty()){
//            throw new ApiException("No directors found with name provided! ",404);
//        }
//        return directors;
//    }


}
