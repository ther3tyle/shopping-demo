package io.dsub.shoppingdemo.user;

import io.dsub.shoppingdemo.exception.UserAlreadyExistsException;
import io.dsub.shoppingdemo.exception.UserNotFoundException;
import io.dsub.shoppingdemo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDTO signUp(UserCommand.CreateUser createUser) {

        if (userRepository.existsByEmail(createUser.getEmail())) {
            // 중복되었으므로 실패
            throw new UserAlreadyExistsException(
                    "user with email " + createUser.getEmail() + " already exist");
        }

        return userRepository.save(createUser.toUser()).toUserDto();
    }

    // 이름에 대해서 .. 누구는 modify, 누구는 update 말고 uniform 하게 정해서 작성할 것!
    public UserDTO updateUser(UserCommand.UpdateUser updateUser, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException(String.valueOf(userId)));

        user.setAddress(updateUser.getAddress());
        user.setName(updateUser.getName());

        return userRepository.save(user).toUserDto();
    }
}
