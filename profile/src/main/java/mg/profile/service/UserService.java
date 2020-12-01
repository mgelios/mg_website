package mg.profile.service;

import lombok.AllArgsConstructor;
import mg.profile.dto.UserDto;
import mg.profile.entity.User;
import mg.profile.mapper.UserMapper;
import mg.profile.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User findUserByUuid(UUID uuid) {
        userRepository.findById(uuid);
        return null;
    }

    @Transactional
    public User createUser(UserDto userDto) {
        User userToSave = UserMapper.INSTANCE.mapToEntity(userDto);
        return userRepository.save(userToSave);
    }
//    private final UserEntityToDto userEntityToDTO;
//    private final UserDtoToEntity userDTOToEntity;
//
//    public List<LocalUserDto> getUsersList() {
//        List<LocalUserDto> users = new ArrayList<>();
//        userRepository.findAll().forEach(user -> {
//            users.add(userEntityToDTO.convert(user));
//        });
//        return users;
//    }
//
//    public LocalUserDto findUserByEmail(String email) {
//        Optional<User> dbUser = userRepository.findByEmail(email);
//        return dbUser.map(userEntityToDTO::convert).orElse(null);
//    }
//
//    public void saveUser(LocalUserDto user) {
//        User dbUser = userDTOToEntity.convert(user);
//        userRepository.save(dbUser);
//    }
//
//    public LocalUserDto mergeUpdatedUser(LocalUserDto userUpdated, LocalUserDto oldUser){
//        oldUser.setEmail(userUpdated.getEmail());
//        oldUser.setFirstName(userUpdated.getFirstName());
//        oldUser.setLastName(userUpdated.getLastName());
//        User dbUser = userDTOToEntity.convert(oldUser);
//        userRepository.save(dbUser);
//        return oldUser;
//    }
}
