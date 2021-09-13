package com.example.demo.service;

import com.example.demo.exceptions.WardNotFoundException;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import com.example.demo.ward.Ward;


@Service
public class WardService {

    private  WardDataAccessService wardDataAccessService;

    public WardService(WardDataAccessService wardDataAccessService) {
        this.wardDataAccessService = wardDataAccessService;
    }
    //add the list of wards
    public List<Ward> getWard() {
        return wardDataAccessService.selectAllWards();
    }


    public void addNewWard(Ward ward) {
        if (wardDataAccessService.selectAllWards().contains(ward)) {
            throw new IllegalStateException("Ward already exists in the database");
        }   else {
            wardDataAccessService.insertWard(ward);
        }
    }

        public void deleteWard(int wardId) {

            boolean found = false;
            for (Ward ward : wardDataAccessService.selectAllWards()) {
                if (ward.getwardId()==(wardId)) {
                    found = true;
                    wardDataAccessService.deleteWard(ward);
                }
            }
            if (!found) {
                throw new WardNotFoundException("Ward ID = " + wardId + " not found");
            }
        }



    public void updateWard(Ward ward) {

        boolean found = false;
        for (Ward w : wardDataAccessService.selectAllWards()){
            if(w.getwardId()==(ward.getwardId())) {
                found = true;
                w.setWardName (ward.getWardName());
                w.setwardId (ward.getwardId());

            }
        }
        if (!found) {
            throw new WardNotFoundException("Ward not found");
        }
    }

    public Ward getWard(int wardId) {
        return wardDataAccessService.selectAllWards()
                .stream()
                .filter(ward -> ward.getwardId()==(wardId))
                .findFirst()
                .orElseThrow(() -> new WardNotFoundException(wardId + " not found"));
    }
}
