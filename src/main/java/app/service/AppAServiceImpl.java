package app.service;

import app.dto.DataRequest;
import app.dto.TrueObject;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class AppAServiceImpl implements AppAService {

    private final ValidateTokenService validateTokenService;
    private final RestTemplate restTemplate;
//    private final Beans beans;

    public AppAServiceImpl(ValidateTokenService validateTokenService, RestTemplate restTemplate) {
        this.validateTokenService = validateTokenService;
//        this.beans = beans;
        this.restTemplate = restTemplate;
    }


    public String getData(DataRequest dataRequest) throws Exception {
        boolean valid = validateTokenService.validateToken(dataRequest.getToken());
        if(!dataRequest.isBol()) {
            TrueObject to = new TrueObject();
            to.test("qwewqe");
        }
        if(valid){
            ResponseEntity<String> response =
                    restTemplate.exchange(
                            "http://localhost:8082/getData",
                            HttpMethod.GET,
                            null,
                            String.class);
            return response.getBody();
        }else{
            throw new Exception("Not valid token");
        }



    }

}


