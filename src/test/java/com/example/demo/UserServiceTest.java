package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.entity.User;
import com.example.demo.entity.enums.TipoUserPermission;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    //Teste para verificar se ao instanciar um novo usuario o mesmo foi cadastrado com sucesso.
    @Test
    public void TestSuccessfullyCreateUser(){
        //Cenário
        User newUser = new User();
        newUser.setNameUser("Matheus Morilha");
        newUser.setEmail("matheus.teles@gmail.com");
        newUser.setPassword("12345678");
        newUser.setTipoUserPermission(TipoUserPermission.ADMINISTRATOR);
        
        //Ação
        when(userRepository.save(newUser)).thenReturn(newUser);
        User saveUserResult = userService.createUser(newUser);

        //Verificação
        assertNotNull(saveUserResult);
        assertEquals(newUser, saveUserResult);
        verify(userRepository, times(1)).save(newUser);
        
    }

    //Teste para verificar se a função getListUser está retornando os usuários cadastrados.
    @Test
    public void TestGetListUser(){
        //Cenário
        User newUser1 = new User();
        User newUser2 = new User();
        List<User> mockUsers = Arrays.asList(newUser1, newUser2);

        //Ação
        when(userRepository.findAll()).thenReturn(mockUsers);
        List<User> result = userService.getListUser();

        //Verificação
        assertEquals(2, result.size());
        assertEquals(newUser1, result.get(0));
        assertEquals(newUser2, result.get(1));

    }

    //Teste para verificar se quando não houver nenhum usuário cadastrado, a lista retornará vazia. 
    @Test
    public void TestGetListUserNull(){
        //Cenário
        //Nenhum usuário no banco de dados.

        //Ação
        when(userRepository.findAll()).thenReturn(Collections.emptyList());
        List<User> result = userService.getListUser();

        //Verificação
        assertEquals(Collections.emptyList(), result);
    }
    
    //Teste para verificar se o usuário está sendo excluído corretamente após a chamada da função deleteUser.
    @Test
    public void TestDeleteUser(){
        //Cenário
        Long userId = 1L;

        //Ação
        userService.deleteUser(userId);

        //Verificação
        verify(userRepository, times(1)).deleteById(userId);

    }

    //Teste para verificar se a função de atualizar dados do usuário está funcionando corretamente.
    @Test
    public void TestUpdateUser(){
        //Cenário
        Long userId = 1L;
        User existingUser = new User();
        existingUser.setId(userId);
        existingUser.setNameUser("Matheus Morilha");

        User newUser = new User();
        newUser.setId(userId);
        newUser.setNameUser("Mario Vinicius");

        when(userRepository.findById(userId)).thenReturn(Optional.of(existingUser));
        when(userRepository.save(existingUser)).thenReturn(existingUser);

        //Ação
        User updateUser = userService.updateUser(newUser);

        //Verificação
        assertEquals(newUser.getId(), updateUser.getId());
        assertEquals(newUser.getNameUser(), updateUser.getNameUser());
        verify(userRepository).findById(userId);
        verify(userRepository).save(updateUser);

    }

}
