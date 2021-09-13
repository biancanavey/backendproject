package com.example.demo.Ward;

import com.example.demo.Exception.WardNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class WardService {

    private  WardService wardService;

    public WardService(com.example.demo.WardService wardService) {
        this.wardService = wardService;
    }
    //add the list of wards
    public List<Ward> getWard() {
        return WardDataAccessService.selectAllWard();
    }


    public void addNewWard(Ward ward) {
        if (WardDataAccessService.selectAllWard().contains(ward)) {
            throw new IllegalStateException("Ward already exists in the database");
    }   else {
            WardDataAccessService.insertWard(ward);
        }

    public void deleteWard(int wardId) {

            boolean found = false;
            for (Ward ward : WardDataAccessService.selectAllWards()) {
                if (ward.getId().equals(wardId)) {
                    found = true;
                    WardDataAccessService.deleteWard(ward);
                }
            }
            if (!found) {
                throw new WardNotFoundException("Ward ID = " + wardId + " not found");
            }
        }
        }
    }

    public void updateWard(Ward ward) {

        boolean found = false;
        for (Ward w : WardDataAccessService.selectAllWards())) {
                if(w.wardId().equals(ward.getId())) {
                found = true;
                w.setwardName (ward.getwardName());
                w.setwardId (ward.getwardId());

                }
        }
        if (!found) {
            throw new WardNotFoundException("Ward not found");
        }
    }

    public Ward getWard(int wardId) {
        return WardDataAccessService.selectAllWard()
                .stream()
                .filter(ward -> ward.getwardId().equals(wardId))
                .findFirst()
                .orElseThrow(() -> new WardNotFoundException(wardId + " not found"));
}
