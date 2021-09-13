package com.example.demo.ward;

import com.example.demo.exception.WardNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WardService {

    private WardDataAccessService wardDataAccessService;

    public WardService(WardDataAccessService wardDataAccessService) {
        this.wardDataAccessService = wardDataAccessService;
    }

    public List<Ward> getWards() {
        return wardDataAccessService.selectAllWards();
    }

    public void addNewWard(Ward ward) {
        if (wardDataAccessService.selectAllWards().contains(ward)) {
            throw new IllegalArgumentException("This ward already exists in the database");
        } else {
            wardDataAccessService.insertWard(ward);
        }
    }

    public Ward getWard(int wardId) {
        return wardDataAccessService.selectAllWards()
                .stream()
                .filter(ward -> ward.getWardId() == (wardId))
                .findFirst()
                .orElseThrow(() -> new WardNotFoundException("Ward ID " + wardId + " not found"));
    }

    public void deleteWard(int wardId) {
        boolean wardExists = false;
        for (Ward ward : wardDataAccessService.selectAllWards()) {
            if (ward.getWardId() == (wardId)) {
                wardExists = true;
                wardDataAccessService.deleteWard(ward);
            }
        }
        if (!wardExists) {
            throw new WardNotFoundException("Ward ID " + wardId + " not found");
        }
    }

    public void updateWard(Ward ward) {
        boolean wardExists = false;
        for (Ward wardInDB : wardDataAccessService.selectAllWards()) {
            if (wardInDB.getWardId() == (ward.getWardId())) {
                wardExists = true;
                wardInDB.setWardName(ward.getWardName());
            }
        }
        if (!wardExists) {
            throw new WardNotFoundException("Ward not found");
        }
    }

}
