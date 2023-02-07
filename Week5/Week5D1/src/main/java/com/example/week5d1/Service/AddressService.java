package com.example.week5d1.Service;

import com.example.week5d1.DTO.AddressDTO;
import com.example.week5d1.Exception.ApiException;
import com.example.week5d1.Model.Teacher;
import com.example.week5d1.Model.Address;
import com.example.week5d1.Repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherService teacherService;



    public void addAddress(AddressDTO addressDTO){
        Teacher teacher = teacherService.findById(addressDTO.getTeacher_id());
        Address address = new Address(addressDTO.getArea(), addressDTO.getStreet(), addressDTO.getBuildingNumber(), teacher);
        addressRepository.save(address);
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
    public void updateAddress(AddressDTO addressDTO){
        Address address = addressRepository.findAddressById(addressDTO.getTeacher_id());
        if(address ==null){
            throw new ApiException("Address not found!",404);
        }
        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());
        addressRepository.save(address);
    }

    public void deleteAddress(Integer id){
        Address address = addressRepository.findAddressById(id);
        if(address ==null){
            throw new ApiException("Address not found!",404);
        }
        addressRepository.delete(address);
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
