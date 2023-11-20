package com.florenceConsultingProject.config;

import java.time.Instant;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * 
 * @author Vincenzo.DI-MASO
 *
 */
@Configuration
public class CommonBeanConfig {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Bean
    TimeZone timeZone() {
        TimeZone defaultTimeZone = TimeZone.getTimeZone("GMT");
        TimeZone.setDefault(defaultTimeZone);
        log.info("Spring boot application running in {} timezone : {}", TimeZone.getDefault().getID(), Instant.now());
        return defaultTimeZone;
    }
	
	@Bean
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    Logger slf4jLogger(InjectionPoint injectionPoint) {
        Class<?> targetClass = injectionPoint.getMember().getDeclaringClass();
        Logger logger = LoggerFactory.getLogger(targetClass);
        return logger;
    }

}