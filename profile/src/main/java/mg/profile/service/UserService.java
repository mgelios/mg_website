package mg.profile.service;

import lombok.AllArgsConstructor;
import mg.profile.dto.UserDto;
import mg.profile.entity.User;
import mg.profile.mapper.UserMapper;
import mg.profile.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public User findUserByUuid(UUID uuid) {
        Optional<User> user = userRepository.findById(uuid);
        return user.get();
    }

    public User findUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException(username);
        }
        return user.get();
    }

    public User createUser(UserDto userDto) {
        User userToSave = userMapper.mapToEntity(userDto);
        return userRepository.save(userToSave);
    }

    public User updateUser(UserDto dto) {
        User userToSave = userMapper.mapToEntity(dto);
        return userRepository.save(userToSave);
    }

    public void deleteUserByUuid(UUID uuid) {
        userRepository.deleteById(uuid);
    }

    public void deleteUser(String username) {
        userRepository.deleteByUsername(username);
    }
}
