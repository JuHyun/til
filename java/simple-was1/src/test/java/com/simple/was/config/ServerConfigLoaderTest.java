package com.simple.was.config;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ServerConfigLoaderTest {

    @Test
    public void shouldSuccessLoadingConfigInfos() {
        List<VirtualHost> virtualHosts = Arrays.asList(VirtualHost.create("a.com", "docRootA"), VirtualHost.create("b.com", "docRootB"));
        ServerConfig expected = ServerConfig.create(8090, virtualHosts);
        ServerConfig config = ServerConfigLoader.getConfig("serverConfig.json");

        assertEquals(expected.getPort(), config.getPort());
        assertArrayEquals(expected.getVirtualHosts().toArray(), config.getVirtualHosts().toArray());
    }

}