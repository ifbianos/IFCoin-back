package com.ifba.application.controller.register;

import com.ifba.config.modelmapper.requestaccountconvert.RequestAccountConvert;
import com.ifba.domain.dto.requestaccount.RequestAccountDtoIn;
import com.ifba.domain.dto.requestaccount.RequestAccountDtoOut;
import com.ifba.domain.usecase.requestaccount.RequestAccountUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/user/requestaccount")
public class RequestAccountController {

  //  @Autowired
   // private JavaMailSender mailSender;
    private final RequestAccountUseCase requestAccountUseCase;
    private final RequestAccountConvert requestAccountConvert;

    public RequestAccountController(RequestAccountUseCase requestAccountUseCase, RequestAccountConvert requestAccountConvert) {

        this.requestAccountUseCase = requestAccountUseCase;
        this.requestAccountConvert = requestAccountConvert;
    }

    @PostMapping
    public ResponseEntity<RequestAccountDtoOut> create(@RequestBody RequestAccountDtoIn requestAccountDtoIn) throws MessagingException, IOException {
     //   MailBody mailBody = new MailBody(requestAccountConvert.dtoInToDtoOut(requestAccountDtoIn));
       // mailSender.send(mailBody.sendEmail());
       // mailBody.sendEmail();
        requestAccountUseCase.saveRequestAccount(requestAccountConvert.dtoToEntity(requestAccountDtoIn));

        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(requestAccountDtoIn)
                .toUri()).body(requestAccountConvert.dtoInToDtoOut(requestAccountDtoIn));

    }

    @GetMapping
    public ResponseEntity<List<RequestAccountDtoOut>> getAll() {
        return ResponseEntity.ok().body(requestAccountConvert
                .entityToListOutDTO(requestAccountUseCase.findAllRequestAccount()));
    }

    @DeleteMapping
    public void deleteAll() {
        requestAccountUseCase.deleteAllRequesAccount();
    }


}
