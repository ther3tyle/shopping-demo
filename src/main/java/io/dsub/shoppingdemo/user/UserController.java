package io.dsub.shoppingdemo.user;

import io.dsub.shoppingdemo.exception.UserAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> signUp(@RequestBody @Valid UserCommand.CreateUser createUser, BindingResult bindingResult) {
        try {
            return ResponseEntity.ok(userService.signUp(createUser));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(e.getMessage());
        }
        // 개별적으로 만들 때 아직 ResponseEntity 는 사용하지 말 것
    }

    @PutMapping("/{id}")
    public UserDTO updateUser(
            @RequestBody @Valid UserCommand.UpdateUser updateUser,
            @PathVariable Long id) {
        return userService.updateUser(updateUser, id);
    }
}
