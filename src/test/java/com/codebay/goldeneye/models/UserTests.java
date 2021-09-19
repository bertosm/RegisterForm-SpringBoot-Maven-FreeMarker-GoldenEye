package com.codebay.goldeneye.models;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTests {

    User user;
    User userWithSpace;
    
    @BeforeEach
    public void setUp(){
        user = new User();
        user.setName("Paco");
        user.setSurname("Rodriguez");
        user.setOffice("Milan");
        user.setDepartment("Design");
        user.generateEmail();

        userWithSpace = new User();
        userWithSpace.setName("Paco Javier");
        userWithSpace.setSurname("Rodriguez Zamora");
        userWithSpace.setOffice("New York");
        userWithSpace.setDepartment("Research & development");
        userWithSpace.generateEmail();
    }

    @Test
    @DisplayName("User with all the properties")
    public void testEmailGenerate(){
        assertEquals(user.getEmail(), "prodriguez.design@milan.goldeneye.com");  
    }

    @Test
    @DisplayName("User with spaces on properties")
    public void testEmailGenerate_withSpaces(){
        assertEquals(userWithSpace.getEmail(), "prodriguezzamora.research&development@newyork.goldeneye.com");  
    }

}
