package app.controller;


import app.dto.DataRequest;
import app.service.AppAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AppAController {


    @Autowired
    private AppAService appAService;


    @GetMapping("/getData")
    public String getData(@RequestBody DataRequest dataRequest) throws Exception {
        return appAService.getData(dataRequest);
    }


    @GetMapping("/helloDeployment")
    public String getData() {
        return "Hello first deployment";
    }
}
