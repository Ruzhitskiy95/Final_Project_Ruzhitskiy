package by.academy.domain.hibernate;

import by.academy.domain.SystemRoles;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Data
@Entity
@Table(name = "roles")
public class HibernateRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "role_name")
    @Enumerated(EnumType.STRING)
    private SystemRoles roleName;

    @Column(name = "creation_date")
    private Timestamp creationDate;

    @Column(name = "modification_date")
    private Timestamp modificationDate;

    @ManyToMany
    @JoinTable(name = "l_role_user",
            joinColumns = @JoinColumn(name = "role_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id"))

    @JsonIgnoreProperties("roles")
    private Set<HibernateUser> users;
}
