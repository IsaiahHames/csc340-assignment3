package com.bigcats.cat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {

    List<Cat> getCatsByBreed(String breed);

   @Query(value = "select * from cats c where c.name like %?1% ", nativeQuery = true)
    List<Cat> getCatsByName(String name);

    @Query(value = "select * from cats c where c.age >= ?1% ", nativeQuery = true)
    List<Cat> getCatsByAge(int age); 
}
