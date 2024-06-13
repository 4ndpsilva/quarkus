package br.com.quarkus.finder.service;

import br.com.quarkus.finder.dto.AddressResponseDTO;
import br.com.quarkus.finder.dto.ViaCepResponseDTO;
import br.com.quarkus.finder.exception.BusinessException;
import br.com.quarkus.finder.exception.ServerException;
import br.com.quarkus.finder.mapper.AddressMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.client.exception.ResteasyWebApplicationException;

@Slf4j
@ApplicationScoped
public class AddressService {

    @RestClient
    @Inject
    private ViaCepService viaCepService;

    @Inject
    private AddressMapper mapper;

    public AddressResponseDTO find(String zipCode){
        try{
            if(zipCode == null || zipCode.isBlank()){
                throw new BusinessException("É obrigatório informar o CEP");
            }

            if(!zipCode.matches("^[0-9]{8,}$")){
                throw new BusinessException("CEP Inválido");
            }

            ViaCepResponseDTO responseDTO = viaCepService.getAddress(zipCode);

            if(responseDTO.cep() == null || responseDTO.cep().isBlank()){
                throw new BusinessException("Endereço não encontrado para o CEP informado");
            }

            return mapper.toResponseDTO(responseDTO);
        }
        catch (ResteasyWebApplicationException ex) {
            if(ex.getMessage().contains("400")){
                throw new BusinessException("CEP Inválido");
            }

            log.error("OTHER ERROR: {}", ex.getMessage());
            throw new BusinessException("ERRO NA CHAMADA DA API");
        }
        catch (Exception ex) {
            log.error("SERVER ERROR: {}", ex.getMessage());
            throw new ServerException(ex);
        }
    }
}