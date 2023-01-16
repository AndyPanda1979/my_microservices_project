package net.exclamation.listeners;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class SpringContextRefreshListener {

    @EventListener
    public void handleContextRefreshEvent(ContextRefreshedEvent ctxRefEvt) {
        System.out.println("Context Start Event received.");
        System.out.println(ctxRefEvt.toString());
    }
}
