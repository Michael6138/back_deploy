package app.service;

import app.dto.DataRequest;
import app.dto.TrueObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class AppAServiceImplTest {


    @Mock
    ValidateTokenService validateTokenService;


    @Mock
    ResponseEntity<String> response;

    @Mock
    RestTemplate restTemplate;

    @Mock
    List mockedList;

    @Captor
    ArgumentCaptor argCaptor;

    @Captor
    ArgumentCaptor<String> dataRequestCapture;

    @Mock
    TrueObject trueObject;

    @InjectMocks
    private AppAServiceImpl appAServiceImpl;


    @Test
    public void shouldReturnCorrectAnswer() throws Exception {
        DataRequest dataRequest = new DataRequest("a", false);
        verify(trueObject).test(dataRequestCapture.capture());
        when(validateTokenService.validateToken(eq(dataRequest.getToken()))).thenReturn(true);
        when(response.getBody()).thenReturn("faikdata");
        when(restTemplate.exchange("http://localhost:8082/getData",
                HttpMethod.GET,
                null,
                String.class)).thenReturn(response);
        Assertions.assertEquals("faikdata", appAServiceImpl.getData(dataRequest));
//        String value = dataRequestCapture.getValue();
//        System.out.println(value);
        verify(validateTokenService, times(1)).validateToken(dataRequest.getToken());

    }

    @Test
    public void shouldThrowException() throws Exception {
        DataRequest dataRequest = new DataRequest("b", false);
        when(validateTokenService.validateToken(eq(dataRequest.getToken()))).thenReturn(false);
        Assertions.assertThrows(
                Exception.class, () -> appAServiceImpl.getData(dataRequest)
        );

    }

    @Test
    public void whenUseCaptorAnnotation_thenTheSam() {
        mockedList.add("one");
        mockedList.add("two");
        Mockito.verify(mockedList, times(2)).add(argCaptor.capture());
        System.out.println(argCaptor.getValue());
        Assertions.assertEquals("two", argCaptor.getValue());
    }


}