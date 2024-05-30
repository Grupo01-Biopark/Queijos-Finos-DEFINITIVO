package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.example.demo.entity.User;
import com.example.demo.entity.enums.TipoUserPermission;

public class UserTest {

    //Teste para verificar se está sendo criado um usuário com os dados corretos.
    @Test
    public void userEntityTest(){
        //Cenário
        User newUser = new User();

        //Ação
        newUser.setId(1L);
        newUser.setNameUser("Matheus Morilha");
        newUser.setEmail("matheus.teles@gmail.com");
        newUser.setPassword("12345678");
        newUser.setTipoUserPermission(TipoUserPermission.ADMINISTRATOR);

        //Verificação
        assertNotNull(newUser);
        assertEquals(1L, newUser.getId());
        assertEquals("Matheus Morilha", newUser.getNameUser());
        assertEquals("matheus.teles@gmail.com", newUser.getEmail());
        assertEquals("12345678", newUser.getPassword());
        assertEquals(TipoUserPermission.ADMINISTRATOR, newUser.getTipoUserPermission());
           
    }
}
