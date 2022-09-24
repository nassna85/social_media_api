package com.socialmedia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.socialmedia.annotation.UniqueUsername;
import com.socialmedia.config.Views;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.BaseUser.class)
    private long id;

    @NotNull(message = "{socialmedia.constraints.username.NotNull.message}")
    @Size(min = 2, max = 60, message = "{socialmedia.constraints.username.Size.message}")
    @UniqueUsername
    @Column(unique=true)
    @JsonView(Views.BaseUser.class)
    private String username;

    @NotNull(message = "{socialmedia.constraints.displayName.NotNull.message}")
    @Size(min = 2, max = 60, message = "{socialmedia.constraints.displayName.Size.message}")
    @JsonView(Views.BaseUser.class)
    private String displayName;

    @NotNull(message = "{socialmedia.constraints.password.NotNull.message}")
    @Size(min = 8, max = 255, message = "{socialmedia.constraints.password.Size.message}")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "{socialmedia.constraints.password.Pattern.message}")
    private String password;

    @JsonView(Views.BaseUser.class)
    private String image;

    @Override
    @java.beans.Transient
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList("ROLE_USER");
    }

    @Override
    @java.beans.Transient
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @java.beans.Transient
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @java.beans.Transient
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @java.beans.Transient
    public boolean isEnabled() {
        return true;
    }
}
