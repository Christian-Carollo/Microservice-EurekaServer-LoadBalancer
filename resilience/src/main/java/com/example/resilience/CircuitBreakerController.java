package com.example.resilience;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private final Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/recall")
    @Retry(name = "recall", fallbackMethod = "fallbackRecall")
    @CircuitBreaker(name = "recall", fallbackMethod = "fallbackRecall")
    @RateLimiter(name = "default")
    @Bulkhead(name = "default")
    public String recall(){
        logger.info("Enter to CircuitBreakerController/retry");
        ResponseEntity<String> response = new RestTemplate().getForEntity("http://localhost:8765/servicea", String.class);
        return response.getBody();
    }

    public String fallbackRecall(Exception ex){
        logger.info("Fallback executed due to: " + ex);
        return "Service is currently unavailable. Please try again later";
    }
}
