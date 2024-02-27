package com.example.hoa.Repository;

import com.example.hoa.Entity.Flowers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FlowerRepository extends JpaRepository<Flowers, Long> {
    List<Flowers> findByNameContainingIgnoreCase(String name);

}

