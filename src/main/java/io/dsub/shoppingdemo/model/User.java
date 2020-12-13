package io.dsub.shoppingdemo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.dsub.shoppingdemo.enums.Gender;
import io.dsub.shoppingdemo.user.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
@EntityListeners(value = {AuditingEntityListener.class})
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String password;
    private String name;
    private Gender gender;
    private String address;

    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh-mm-ss")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh-mm-ss")
    private LocalDateTime modifiedAt;

    public UserDTO toUserDto() {
        return UserDTO.builder()
                .gender(gender)
                .name(name)
                .email(email)
                .address(address)
                .build();
    }
}
