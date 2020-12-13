package io.dsub.shoppingdemo.user;

import lombok.RequiredArgsConstructor;
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
        return ResponseEntity.ok(userService.signUp(createUser));
        // 개별적으로 만들 때 아직 ResponseEntity 는 사용하지 말 것
    }

    @PutMapping("/{id}")
    public UserDTO updateUser(
            @RequestBody @Valid UserCommand.UpdateUser updateUser,
            @PathVariable Long id) {
        return userService.updateUser(updateUser, id);
    }
}
