package com.ifba.application.controller.register;


import com.ifba.domain.usecase.requestaccount.RegisterAccountUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.HashMap;

@Slf4j
@RestController
@RequestMapping("api/user/register")
public class RegisterController {

    private final RegisterAccountUseCase registerAccountUseCase;

    public RegisterController(RegisterAccountUseCase registerAccountUseCase) {
        this.registerAccountUseCase = registerAccountUseCase;
    }

    //post com um cpf
    @PostMapping
    public ResponseEntity<HashMap<String,String>> register(@RequestParam String cpf){
        registerAccountUseCase.registerAccount(cpf);

        HashMap<String,String> message = new HashMap<>();
        message.put("msg","Conta aceita com sucesso");

        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(cpf)
                .toUri()).body(message);
    }

    @DeleteMapping
    public ResponseEntity<HashMap<String,String>> delete(@RequestParam String cpf){

        registerAccountUseCase.deleteAccountByCpf(cpf);

        HashMap<String,String> message = new HashMap<>();
        message.put("msg","Conta deletada com sucesso");

        return ResponseEntity.ok().body(message);
    }


}
