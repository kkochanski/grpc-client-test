package test.client;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping("/greet")
    public String greet() {
        return clientService.greet();
    }

    @RequestMapping("/greet-again")
    public String greetAgain() {
        return clientService.greetAgain();
    }
}
