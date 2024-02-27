package com.example.hoa.Service;

import com.example.hoa.Entity.Flowers;

import java.util.List;
import java.util.Optional;

public interface FlowerService {
    List<Flowers> getAll(String sortDirection);
    Optional<Flowers> findById(Long id);

    List<Flowers> findByName(String name);
    Flowers createFlower(Flowers flowers);
    Flowers deleteFlower(Long id);
    Flowers updateFlower(Flowers flowers, Long id);
}
