package com.github.rest.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created By jiabin on 18-5-30.
 */
@Component
public class ServerOrTaskBootInit implements ApplicationListener<ContextRefreshedEvent> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        logger.info("ServerOrTaskBootInit<<<<<<<<<<<<<<<<<<<<<<<<");
    }
}
