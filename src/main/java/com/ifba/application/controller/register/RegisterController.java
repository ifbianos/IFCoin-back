package com.ifba.application.controller.register;


import com.ifba.domain.usecase.requestaccount.RegisterAccountUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
    public void register(@RequestParam String cpf){
        registerAccountUseCase.registerAccount(cpf);
    }

}
