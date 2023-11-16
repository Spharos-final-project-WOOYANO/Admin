package shparos.admin.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import shparos.admin.dto.ClientListResponse;
import shparos.admin.global.common.CommonHttpClient;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminService implements AdminServiceImpl{

    private final CommonHttpClient commonHttpClient;


    public Page<ClientListResponse> getClientList(Pageable pageable){
        String url = "http://localhost:8000/api/v1/client/list";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(url)
                .queryParam("page", pageable.getPageNumber())
                .queryParam("size", pageable.getPageSize());

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CustomPageImpl<ClientListResponse>> exchange = restTemplate.exchange(uriBuilder.toUriString(),
                HttpMethod.GET,
                null, new ParameterizedTypeReference<CustomPageImpl<ClientListResponse>>() {
                });
        return  exchange.getBody();



    }
    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
