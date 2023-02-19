package com.example.day3.Service;

import com.example.day3.DTO.AddressDTO;
import com.example.day3.Exception.ApiException;
import com.example.day3.Model.Address;
import com.example.day3.Model.Teacher;
import com.example.day3.Repository.AddressRepository;
import com.example.day3.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final TeacherRepository teacherRepository;
    private final AddressRepository addressRepository;
    public void addTeacherDetails(AddressDTO cd){
        Teacher teacher = teacherRepository.findTeacherById(cd.getTeacher_id());
        if (teacher == null)
            throw new ApiException("Teacher not found");
        Address address = new Address(null,cd.getArea(),cd.getStreet(),cd.getBuildingNumber(),teacher);
        addressRepository.save(address);
    }

    public void updateTeacherDetails(AddressDTO cd){
        Address address = addressRepository.findAddressById(cd.getTeacher_id());
        if (address == null)
            throw new ApiException("Teacher not found");
        address.setArea(cd.getArea());
        address.setStreet(cd.getStreet());
        address.setBuildingNumber(cd.getBuildingNumber());
        addressRepository.save(address);
    }

    public void deleteTeacherDetails(Integer id){
        Address address = addressRepository.findAddressById(id);
        if (address == null)
            throw new ApiException("address not found");

        addressRepository.delete(address);
    }


}
