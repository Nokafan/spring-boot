package com.gmail.stepura.volodymyr.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(of = {"userId"})
@Builder
@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "user_id", unique = true)
    private String userId;

    @Column(name = "profile_name")
    private String profileName;

    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "roles")
    private Set<Role> role;

    @Column(name = "passwords")
    private String password;
}
