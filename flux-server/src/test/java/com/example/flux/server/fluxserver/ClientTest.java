package com.example.flux.server.fluxserver;

import com.example.flux.server.fluxserver.client.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.Disposable;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FluxServerApplication.class)
public class ClientTest {
    @Autowired
    private Client client;

    @Test
    public void testGetAllPerson() throws InterruptedException {
        Disposable disposable = this.client.readAllPerson();
        Thread.sleep(320000L);
        disposable.dispose();
    }
}
