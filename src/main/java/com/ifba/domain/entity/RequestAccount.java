package com.ifba.domain.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class RequestAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  //  @NotNull
    private String name;
   // @NotNull
    private String lastName;
   // @NotNull
    private String cpf;
  //  @NotNull
    private String role;

   // @NotNull
    @OneToOne(cascade={CascadeType.ALL})
    private UserRequest userRequest;

}
