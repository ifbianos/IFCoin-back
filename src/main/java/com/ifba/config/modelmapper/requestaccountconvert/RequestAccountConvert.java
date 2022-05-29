package com.ifba.config.modelmapper.requestaccountconvert;

import com.ifba.config.modelmapper.ModelMapperConfig;
import com.ifba.domain.dto.requestaccount.RequestAccountDtoIn;
import com.ifba.domain.dto.requestaccount.RequestAccountDtoOut;
import com.ifba.domain.entity.RequestAccount;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RequestAccountConvert {

    private final ModelMapperConfig modelMapperConfig;

    public RequestAccountConvert(ModelMapperConfig modelMapperConfig) {
        this.modelMapperConfig = modelMapperConfig;
    }

    public RequestAccount dtoToEntity(RequestAccountDtoIn requestAccountDTO){
        return modelMapperConfig.modelMapper().map(requestAccountDTO,RequestAccount.class);
    }

    public RequestAccountDtoOut dtoInToDtoOut(RequestAccountDtoIn requestAccountDtoIn){
        return modelMapperConfig.modelMapper().map(requestAccountDtoIn,RequestAccountDtoOut.class);
    }

    public RequestAccountDtoIn entityToDTO(RequestAccount requestAccount){
        return modelMapperConfig.modelMapper().map(requestAccount, RequestAccountDtoIn.class);
    }

    public List<RequestAccountDtoIn> entityToListDTO(List<RequestAccount> requestAccountList){
        return modelMapperConfig.modelMapper().map(requestAccountList,new TypeToken<List<RequestAccountDtoIn>>() {}.getType());
    }

    public List<RequestAccountDtoOut> entityToListOutDTO(List<RequestAccount> requestAccountList){
        return modelMapperConfig.modelMapper().map(requestAccountList,new TypeToken<List<RequestAccountDtoOut>>() {}.getType());
    }
}

