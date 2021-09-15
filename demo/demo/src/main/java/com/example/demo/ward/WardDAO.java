package com.example.demo.ward;

import java.util.List;

public interface WardDAO {
    List<Ward> selectAllWards();
    int insertWard(Ward ward);
    void deleteWard(Ward ward);
}
