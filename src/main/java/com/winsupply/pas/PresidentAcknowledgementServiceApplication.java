package com.winsupply.pas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PresidentAcknowledgementServiceApplication {
    protected final static Logger logger = LoggerFactory.getLogger(PresidentAcknowledgementServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PresidentAcknowledgementServiceApplication.class, args);
        logger.debug("<< Yep ..... I am running and ready for P-A-S requests ..... >>");
    }

}
