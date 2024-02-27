package com.example.hoa.Controller;


import com.example.hoa.Entity.Flowers;
import com.example.hoa.Service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flower")
public class FlowerController {
    @Autowired
    private FlowerService flowerService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Flowers>> getAll(@RequestParam(required = false) String sortDirection){
     List<Flowers> flowers = flowerService.getAll(sortDirection);
     return ResponseEntity.ok().body(flowers);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Flowers> getById(@PathVariable Long id) {
        Optional<Flowers> flowers = flowerService.findById(id);
        if(flowers.isPresent()){
        return ResponseEntity.ok().body(flowers.get());
        }
        else {
        return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getName/{name}")
    public ResponseEntity<List<Flowers>> getByName(@PathVariable("name") String name){
        List<Flowers> flowers = flowerService.findByName(name);
        return ResponseEntity.ok().body(flowers);
    }

    @PostMapping("/create")
    public ResponseEntity<Flowers> createFlowers(@RequestBody Flowers flowers){
        Flowers createFlowers = flowerService.createFlower(flowers);
        return ResponseEntity.ok().body(createFlowers);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Flowers> deleteUser(@PathVariable Long id){
        Flowers deleteFlowers = flowerService.deleteFlower(id);
        if(deleteFlowers!=null){
            return ResponseEntity.ok().body(deleteFlowers);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Flowers> updateFlowers(@RequestBody Flowers flowers, @PathVariable Long id){
        Flowers updateFlower = flowerService.updateFlower(flowers, id);
        if(updateFlower!=null){
            return ResponseEntity.ok().body(updateFlower);
        }
        else {
            return ResponseEntity.notFound().build();
        }


    }



}
