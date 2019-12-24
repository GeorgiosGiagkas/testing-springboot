package com.gg.unittesting.unittesting.data;

import com.gg.unittesting.unittesting.model.Stuff;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@DataJpaTest
class StuffRepositoryTest {

    @Autowired
    StuffRepository stuffRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    public void insert(){
        Stuff stuff = new Stuff(1,"Test",1,1);
        stuffRepository.save(stuff);
        assertEquals(1,testEntityManager.getId(stuff));
    }

    @Test
    public void findAllTest(){
        List<Stuff> stuffs = stuffRepository.findAll();
        assertEquals(3, stuffs.size());
    }
}