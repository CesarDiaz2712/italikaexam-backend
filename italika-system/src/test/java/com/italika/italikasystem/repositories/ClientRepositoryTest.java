package com.italika.italikasystem.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.italika.italikasystem.models.Client;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback
public class ClientRepositoryTest {

    @Autowired
    ClientRepository clientRepository;

    Client clientCorrect = new Client();
    Client clientToSearch= new Client();;

    @BeforeEach
    public void init(){
        clientCorrect = clientCorrect.instance( "Cesar", "Alejo", "Diaz", "2282137829", "calejo@gmail.com");
        
        clientToSearch = clientToSearch.instance( "Pablo", "Diaz", "Diaz", "2282137828", "pablodiaz@gmail.com");
        clientToSearch=clientRepository.save(clientToSearch);
    }

    @Test
    public void createNewClient(){
        Client c = clientRepository.save(clientCorrect);
        assertThat(c).isNotNull();
    }
    
    @Test
    public void findAClientById(){
        Optional<Client> c = clientRepository.findById(clientToSearch.getId());
        assertThat(c).isNotEmpty();
    }
}
