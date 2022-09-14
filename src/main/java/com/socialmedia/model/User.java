package com.socialmedia.model;

import com.socialmedia.annotation.UniqueUsername;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "{socialmedia.constraints.username.NotNull.message}")
    @Size(min = 2, max = 60, message = "{socialmedia.constraints.username.Size.message}")
    @UniqueUsername
    @Column(unique=true)
    private String username;

    @NotNull(message = "{socialmedia.constraints.displayName.NotNull.message}")
    @Size(min = 2, max = 60, message = "{socialmedia.constraints.displayName.Size.message}")
    private String displayName;

    @NotNull(message = "{socialmedia.constraints.password.NotNull.message}")
    @Size(min = 8, max = 255, message = "{socialmedia.constraints.password.Size.message}")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "{socialmedia.constraints.password.Pattern.message}")
    private String password;

}
