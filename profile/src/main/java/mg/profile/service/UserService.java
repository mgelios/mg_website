package mg.profile.service;

import lombok.AllArgsConstructor;
import mg.profile.common.Role;
import mg.profile.dto.*;
import mg.profile.entity.User;
import mg.profile.mapper.UserMapper;
import mg.profile.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
//TODO: find appropriate exception to throw instead of RuntimeException
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public User findUserByUuid(UUID uuid) {
        return userRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("uuid you provided is not valid"));
    }

    public User findUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }
        return user.get();
    }

    public User createUser(UserDto userDto) {
        User userToSave = userMapper.mapToEntity(userDto);
        return userRepository.save(userToSave);
    }

    public User createUser(UserCreationRequestDto dto) {
        userRepository.findByEmail(dto.getEmail()).ifPresent(o -> {
            throw new RuntimeException("user with this email already exists");
        });
        userRepository.findByUsername(dto.getUsername()).ifPresent(o -> {
            throw new RuntimeException("user with this username already exists");
        });
        User userToCreate = userMapper.mapToEntity(dto);
        userToCreate.setPassword(bCryptPasswordEncoder.encode(userToCreate.getPassword()));
        userToCreate.setRole(Role.USER);
        return userRepository.save(userToCreate);
    }

    public User updateUser(UserDto dto) {
        User userToSave = userMapper.mapToEntity(dto);
        return userRepository.save(userToSave);
    }

    public User updateUser(UserUpdateRequestDto dto) {
        User userToUpdate = userRepository.findById(dto.getUuid())
                .orElseThrow(() -> new RuntimeException("uuid you provided is not valid"));
        userRepository.findByEmail(dto.getEmail()).ifPresent(o -> {
            if (!o.getUuid().equals(dto.getUuid()))
                throw new RuntimeException("user with this email already exists");
        });
        userToUpdate.setFirstName(dto.getFirstName());
        userToUpdate.setLastName(dto.getLastName());
        userToUpdate.setEmail(dto.getEmail());
        return userRepository.save(userToUpdate);
    }

    public User updatePassword(UserPasswordUpdateRequestDto dto) {
        User userToUpdate = userRepository.findById(dto.getUuid())
                .orElseThrow(() -> new RuntimeException("uuid you provided is not valid"));
        userToUpdate.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        return userRepository.save(userToUpdate);
    }

    public User updateRole(UserRoleUpdateRequestDto dto) {
        User userToUpdate = userRepository.findById(dto.getUuid())
                .orElseThrow(() -> new RuntimeException("uuid you provided is not valid"));
        userToUpdate.setRole(dto.getRole());
        return userRepository.save(userToUpdate);
    }

    public void deleteUserByUuid(UUID uuid) {
        userRepository.deleteById(uuid);
    }

    public void deleteUser(String username) {
        userRepository.deleteByUsername(username);
    }
}
