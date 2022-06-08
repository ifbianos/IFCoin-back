package com.ifba.application.controller.recoverpassword;

import com.ifba.domain.usecase.user.RecoverPassword;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.HashMap;

@RestController
@RequestMapping("api/user/recoverpassword")
public class RecoverPasswordController {

    private final RecoverPassword recoverPassword;

    public RecoverPasswordController(RecoverPassword recoverPassword) {
        this.recoverPassword = recoverPassword;
    }

    @PostMapping
    public ResponseEntity<HashMap<String,String>> recoverPassword(@RequestParam String cpf){

        recoverPassword.recoverPassword(cpf);

        HashMap<String,String> message = new HashMap<>();
        message.put("msg","Conta aceita com sucesso");

        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(cpf)
                .toUri()).body(message);
    }
}
