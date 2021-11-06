package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@EnableScheduling
@SpringBootApplication
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
	private final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            log.info("Fetching crypt data:");

            fetchCryptData();
        };
    }




    @Scheduled(fixedRate = 3000)
    public void fetchCryptData() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.n.exchange/en/api/v1/price/BTCLTC/latest/?market_code=nex";
        Crypt[] crypt = restTemplate.getForObject(url, Crypt[].class);
        log.info("The time is now {}", dateFormat.format(new Date()));

        assert crypt != null;
        log.info(Arrays.toString(crypt));
    }
}
