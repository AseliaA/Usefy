//package com.example.usefy;
//
//import com.example.usefy.model.User;
//import com.example.usefy.repository.UserRepository;
//import com.example.usefy.service.UserService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.util.NoSuchElementException;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class UserServiceImplTest {
//    @Mock
//    private UserRepository userRepository;
//
//    @Mock
//    private PasswordEncoder passwordEncoder;
//
//    @InjectMocks
//    private UserService userService;
//
//    @Test
//    void registerUser_shouldSaveNewUser_whenUsernameIsFree() {
//        User user = new User();
//        user.setUsername("Alex");
//        user.setPassword("12345");
//
//        when(userRepository.findByUsername("Alex")).thenReturn(Optional.empty());
//        when(passwordEncoder.encode("12345")).thenReturn("encoded_12345");
//
//        User savedUser = new User();
//        savedUser.setId(1L);
//        savedUser.setUsername("Alex");
//        savedUser.setPassword("encoded_12345");
//
//        when(userRepository.save(any(User.class))).thenReturn(savedUser);
//
//        User result = userService.registerUser(user);
//
//        //Assert
//        assertNotNull(result);
//        assertEquals(1L, result.getId());
//        assertEquals("Alex", user.getUsername());
//        assertEquals("encoded_12345", user.getPassword());
//
//        verify(userRepository).findByUsername("asi");
//        verify(passwordEncoder).encode("plainPass");
//        verify(userRepository).save(any(User.class));
//        verifyNoMoreInteractions(userRepository, passwordEncoder);
//    }
//
//    @Test
//    void registerUser_shouldThrowIllegalArgumentException_whenUsernameIsTaken() {
//        User user = new User();
//        user.setUsername("Sam");
//        user.setPassword("12345");
//
//        User existingUser = new User();
//        existingUser.setId(99L);
//        existingUser.setUsername("Sam");
//
//        when(userRepository.findByUsername("Sam")).thenReturn(Optional.of(existingUser));
//
//        IllegalArgumentException exception = assertThrows(
//                IllegalArgumentException.class, () -> userService.registerUser(user));
//
//        assertTrue(exception.getMessage().contains("Username already exists"));
//
//        verify(userRepository).findByUsername("asi");
//        verify(userRepository, never()).save(any());
//        verifyNoInteractions(passwordEncoder);
//    }
//
//    @Test
//    void findByUsername_shouldReturnUser_whenUsernameExists() {
//        String username = "missing";
//
//        when(userRepository.findByUsername(username))
//                .thenReturn(Optional.empty());
//
//        NoSuchElementException ex = assertThrows(
//                NoSuchElementException.class,
//                () -> userService.findByUsername(username));
//
//        assertTrue(ex.getMessage().contains("User not found"));
//
//        verify(userRepository).findByUsername(username);
//        verifyNoMoreInteractions(userRepository);
//    }
//
//    @Test
//    void findByUsername_shouldReturnNoElementFoundException_whenUsernameDoesNotExist() {
//        String username = "missing";
//
//        when(userRepository.findByUsername(username))
//                .thenReturn(Optional.empty());
//
//        NoSuchElementException ex = assertThrows(
//                NoSuchElementException.class,
//                () -> userService.findByUsername(username));
//
//        assertTrue(ex.getMessage().contains("User not found"));
//
//        verify(userRepository).findByUsername(username);
//        verifyNoMoreInteractions(userRepository);
//    }
//}