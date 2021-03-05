package ru.mshassium.habitica_lite.services;

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


    @Scheduled(fixedDelay = 180000)
    private void wakeUpNeo() throws UnknownHostException {
        System.out.println("Wake Up Neo");
        RestTemplate restTemplate = new RestTemplate();
        String hostAddress = InetAddress.getLocalHost().getHostName();
        String fooResourceUrl
                = hostAddress+"/actuator/health";
        System.out.println("Url: "+ fooResourceUrl);
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);
        System.out.println("Status Code is: " + response.getStatusCode());
    }

}
