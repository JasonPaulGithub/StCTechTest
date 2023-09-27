package com.jason.services;

import com.jason.models.UserEntity;
import com.jason.repos.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class JPAEncryptionTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired

    private UserRepository repository;

    @Test
    public void databaseInsertAndRetrieveEntity() {
        String jim = "Jim";
        this.entityManager.merge(new UserEntity(1, jim, "jim@jim.com"));
        assertEquals(jim, this.entityManager.find(UserEntity.class, 1).getName());
    }
}
