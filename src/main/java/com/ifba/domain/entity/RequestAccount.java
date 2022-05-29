package com.ifba.domain.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class RequestAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


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
