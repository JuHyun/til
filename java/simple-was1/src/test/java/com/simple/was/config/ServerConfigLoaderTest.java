package com.simple.was.config;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ServerConfigLoaderTest {

    @Test
    public void shouldSuccessLoadingConfigInfos() {
        VirtualHost virtualHost1 = VirtualHost.create("a.com", "docRootA", "403b.html", "404b.html", "500b.html");
        VirtualHost virtualHost2 = VirtualHost.create("b.com", "docRootB", "403b.html", "404b.html", "500b.html");
        List<VirtualHost> virtualHosts = Arrays.asList(virtualHost1, virtualHost2);
        ServerConfig expected = ServerConfig.create(8090, virtualHosts);
        ServerConfig config = ServerConfigLoader.getConfig("serverConfig.json");

        assertEquals(expected.getPort(), config.getPort());
        assertArrayEquals(expected.getVirtualHosts().toArray(), config.getVirtualHosts().toArray());
    }

}