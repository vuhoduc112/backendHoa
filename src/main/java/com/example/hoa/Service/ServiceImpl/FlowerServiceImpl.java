package com.example.hoa.Service.ServiceImpl;

import com.example.hoa.Entity.Flowers;
import com.example.hoa.Repository.FlowerRepository;
import com.example.hoa.Service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlowerServiceImpl implements FlowerService {

    @Autowired
    private FlowerRepository flowerRepository;

    @Override
    public List<Flowers> getAll(String sortDirection) {
        List<Flowers> flowers = flowerRepository.findAll();
        if ("asc".equals(sortDirection)) {
            return flowers.stream()
                    .sorted(Comparator.comparing(Flowers::getPriceNew))
                    .collect(Collectors.toList());
        } else if ("desc".equals(sortDirection)) {
            return flowers.stream()
                    .sorted(Comparator.comparing(Flowers::getPriceNew).reversed())
                    .collect(Collectors.toList());
        } else {
            return flowers;
        }
    }


    @Override
    public Optional<Flowers> findById(Long id) {
        return flowerRepository.findById(id);
    }

    @Override
    public List<Flowers> findByName(String name) {
        return flowerRepository.findByNameContainingIgnoreCase(name);
    }


    @Override
    public Flowers createFlower(Flowers flowers) {
        return flowerRepository.save(flowers);
    }

    @Override
    public Flowers deleteFlower(Long id) {
        Optional<Flowers> optionalFlowers = flowerRepository.findById(id);
        if (optionalFlowers.isPresent()) {
            flowerRepository.deleteById(id);
            return optionalFlowers.get(); //trả về sản phẩm bị xóa
        } else {
            throw new RuntimeException("not found");
        }
    }

    @Override
    public Flowers updateFlower(Flowers flowers, Long id) {
        Flowers updateFlower = flowerRepository.findById(id).orElseThrow(()-> new RuntimeException("not found"));
        if (flowers.getFlowersType() != null) {
            updateFlower.setFlowersType(flowers.getFlowersType());
        }
        if (flowers.getDesc() != null) {
            updateFlower.setDesc(flowers.getDesc());
        }
        if (flowers.getName() != null) {
            updateFlower.setName(flowers.getName());
        }
        if (flowers.getPriceOld() != null) {
            updateFlower.setPriceOld(flowers.getPriceOld());
        }
        if (flowers.getPriceNew() != null) {
            updateFlower.setPriceNew(flowers.getPriceNew());
        }
        if (flowers.getImageURL() != null) {
            updateFlower.setImageURL(flowers.getImageURL());
        }
        if (flowers.getAmount() != null) {
            updateFlower.setAmount(flowers.getAmount());
        }
        return flowerRepository.save(updateFlower);
    }

}
