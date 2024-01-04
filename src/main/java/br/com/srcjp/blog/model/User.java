package br.com.srcjp.blog.model;

import jakarta.persistence.*;
import lombok.Data;

@Table(name="user")
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
}
