package ru.mshassium.habitica_lite.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
@EnableScheduling
public class WakeUpService {

    private final Logger log = LoggerFactory.getLogger(WakeUpService.class);

    @Scheduled(fixedDelay = 180000)
    private void wakeUpNeo() {
        log.debug("DEBUUUG!");
        log.debug("Wake Up Neo");
        RestTemplate restTemplate = new RestTemplate();
        String hostAddress = InetAddress.getLoopbackAddress().getHostAddress();
        String fooResourceUrl = "https://habitica-lite-backend.herokuapp.com/actuator/health";
        log.debug("Url: "+ fooResourceUrl);
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl, String.class);
        log.debug("Status Code is: " + response.getStatusCode());
    }

}
