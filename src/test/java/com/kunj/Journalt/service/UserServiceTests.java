package com.kunj.Journalt.service;

import com.kunj.Journalt.entity.User;
import com.kunj.Journalt.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserServiceTests
{
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByUsername(){
        User user = userRepository.findByUserName("ram");
        assertTrue(!user.getJournalEntries().isEmpty());

        // @ParameterizedTest
        // @ValueSources(1,1,2)
        // @ValueSources(strings={"ram","shyam","kunj"})
//        public void test(int a , int b , int expected){
////            assertEquals(expected,a+b);
////        }

        // @BeforeEach : This will run before each test case
        // @BeforeAll : This will run before everything in the test
        // @AfterAll , @AfterEach

    }
}
