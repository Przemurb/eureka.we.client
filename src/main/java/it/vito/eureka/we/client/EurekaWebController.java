package it.vito.eureka.we.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Controller
public class EurekaWebController {
    private final RestTemplate restTemplate;

    public EurekaWebController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String proces (Model model) {
        String message = restTemplate.getForObject("http://eureka.microservice/process", String.class);
        model.addAttribute("mes", message);
        model.addAttribute("time", LocalDateTime.now());
        return "eureka-web-page";
    }
}
