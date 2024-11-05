package YuriLenzi.Es1Set6BE.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "dipendenti")
@Setter
@Getter
@NoArgsConstructor
@JsonIgnoreProperties({"password", "authorities", "role", "enabled", "accountNonExpired", "accountNonLocked", "credentialsNonExpired"})
public class Dipendente implements UserDetails {
    @Id
    private String username;
    private String nome, cognome, email, urlImg, password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "dipendente", cascade = CascadeType.REMOVE)
    @JsonIgnore
    List<Prenotazione> prenotazioneList;

    public Dipendente(String username, String nome, String cognome, String email) {
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.role = Role.USER;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.role.name()));
    }

}
