package com.gg.unittesting.unittesting.data;

import com.gg.unittesting.unittesting.model.Stuff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StuffRepository extends JpaRepository<Stuff,Integer> {

}
