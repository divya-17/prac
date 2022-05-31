package com.example.test;

import com.example.test.model.Tutorial;
import com.example.test.repository.TutorialRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class )
public class TutorialRepoTest {

    @Autowired
    private TutorialRepository tutorialRepository;

    @Test
    public void addTutorialTest(){
        Tutorial t = new Tutorial(123,"A","A",true);
        tutorialRepository.save(t);

        Boolean actualResult = tutorialRepository.existsById(123L);
        assertEquals(actualResult,true);
    }
}
