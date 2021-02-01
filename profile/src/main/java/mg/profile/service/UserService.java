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
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    public User findUserByUuid(UUID uuid) {
        Optional<User> user = userRepository.findById(uuid);
        return user.get();
    }

    @Transactional
    public User findUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException(username);
        }
        return user.get();
    }

    @Transactional
    public User createUser(UserDto userDto) {
        User userToSave = userMapper.mapToEntity(userDto);
        return userRepository.save(userToSave);
    }

    @Transactional
    public User updateUser(UserDto dto) {
        User userToSave = userMapper.mapToEntity(dto);
        return userRepository.save(userToSave);
    }

    @Transactional
    public void deleteUser(UUID uuid) {
        userRepository.deleteById(uuid);
    }
}
