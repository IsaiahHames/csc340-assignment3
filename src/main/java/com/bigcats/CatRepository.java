package com.bigcats;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Cat;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {

   @Query(value = "select * from cats c where c.breed %?1%", nativeQuery = true)
    List<Cat> getCatsbyBreed(String breed);

    @Query(value = "select * from cats c where c.breed like >= ?1% ", nativeQuery = true)
    List<Cat> getCatsByAge(int age); 
}
