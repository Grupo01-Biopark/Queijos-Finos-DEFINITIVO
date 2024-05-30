package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase; //Utilizar se quiser testar com o banco de dados real.
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.entity.User;
import com.example.demo.entity.enums.TipoUserPermission;
import com.example.demo.repository.UserRepository;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)  //Utilizar se quiser testar com o banco de dados real.
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    //Teste para verificar se o método "save" está funcionando e se quando um usuário é criado, o mesmo está sendo salvo no banco de dados.
    @Test
    public void userSaveTest(){
        //Cenário
        User newUser = new User();

        //Ação
        newUser.setNameUser("Matheus Morilha");
        newUser.setEmail("matheus.teles@gmail.com");
        newUser.setPassword("12345678");
        newUser.setTipoUserPermission(TipoUserPermission.ADMINISTRATOR);
        User saveUser = userRepository.save(newUser);

        //Verificação
        assertNotNull(saveUser);
        assertNotNull(newUser.getId());
        assertEquals("Matheus Morilha", saveUser.getNameUser());

    }

    //Teste para verificar se o método findById está buscando o usuário corretamente.
    @Test
    public void findByIdTest(){
        //Cenário
        User newUser = new User();

        //Ação
        newUser.setNameUser("Matheus Morilha");
        newUser.setEmail("matheus.teles@gmail.com");
        newUser.setPassword("12345678");
        newUser.setTipoUserPermission(TipoUserPermission.ADMINISTRATOR);
        User saveUser = userRepository.save(newUser);

        //Verificação
        Optional<User> foundUser = userRepository.findById(saveUser.getId());
        assertNotNull(foundUser);
        assertEquals("Matheus Morilha", foundUser.get().getNameUser());
    }

    //Teste para verificar se o método findByEmailAndPasswordTest está funcionando corretamente.
    @Test
    public void findByEmailAndPasswordTest(){
        //Cenário
        User newUser = new User();

        //Ação
        newUser.setNameUser("Matheus Morilha");
        newUser.setEmail("matheus.teles@gmail.com");
        newUser.setPassword("12345678");
        newUser.setTipoUserPermission(TipoUserPermission.ADMINISTRATOR);
        userRepository.save(newUser);

        //Verificação
        User foundUser = userRepository.findByEmailAndPassword("matheus.teles@gmail.com", "12345678");
        assertNotNull(foundUser);
        assertEquals("Matheus Morilha", foundUser.getNameUser());
    
    }

    //Teste para verificar se o método findByEmail está funcionando corretamente. 
    @Test
    public void findByEmailTest(){
        //Cenário
        User newUser = new User();

        //Ação
        newUser.setNameUser("Matheus Morilha");
        newUser.setEmail("matheus.teles@gmail.com");
        newUser.setPassword("12345678");
        newUser.setTipoUserPermission(TipoUserPermission.ADMINISTRATOR);
        userRepository.save(newUser);

        User foundUser = userRepository.findByEmail("matheus.teles@gmail.com");
        assertNotNull(foundUser);
        assertEquals("Matheus Morilha", foundUser.getNameUser());
    }

    //Teste para verificar se o método findAll está funcionando corretamente.
    @Test
    public void findAllTest(){
        //Cenário
        User newUser1 = new User();

        //Ação
        newUser1.setNameUser("Matheus Morilha");
        newUser1.setEmail("matheus.teles@gmail.com");
        newUser1.setPassword("12345678");
        newUser1.setTipoUserPermission(TipoUserPermission.ADMINISTRATOR);
        userRepository.save(newUser1);

        User newUser2 = new User();

        newUser2.setNameUser("Carlos Barros");
        newUser2.setEmail("carlos.barros@gmail.com");
        newUser2.setPassword("87654321");
        newUser2.setTipoUserPermission(TipoUserPermission.ADMINISTRATOR);
        userRepository.save(newUser2);

        List<User> userList = userRepository.findAll();

        assertEquals(2, userList.size());
        assertEquals("Matheus Morilha", userList.get(0).getNameUser());
        assertEquals("Carlos Barros", userList.get(1).getNameUser());
    }

    //Teste para verificar se o método deleteById está funcionando corretamente.
    @Test
    public void deleteByIdTest(){
        //Cenário
        User newUser = new User();

        //Ação
        newUser.setNameUser("Matheus Morilha");
        newUser.setEmail("matheus.teles@gmail.com");
        newUser.setPassword("12345678");
        newUser.setTipoUserPermission(TipoUserPermission.ADMINISTRATOR);
        userRepository.save(newUser);

        //Verificação
        Long userId = newUser.getId();

        Optional<User> userInDB = userRepository.findById(userId); //Verifica se o usuário está no banco de dados.
        assertTrue(userInDB.isPresent()); 

        userRepository.deleteById(userId);
        Optional<User> userNotInDB = userRepository.findById(userId); //Verifica se o usuário foi excluído no banco de dados.
        assertFalse(userNotInDB.isPresent());

    }
}
