package io.programminglife.second_brain.service.notion.block;

import io.programminglife.second_brain.model.notion.block.PageBlocks;
import io.programminglife.second_brain.service.interfaces.notion.block.BlockService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import redis.embedded.RedisServer;

import java.net.URISyntaxException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@ImportAutoConfiguration(classes = { CacheAutoConfiguration.class, RedisAutoConfiguration.class })
@EnableCaching
@ExtendWith(MockitoExtension.class)
public class TestBlockService {

    private static final String PAGE_ID = "710f10f9-c700-4f78-bacf-d6a4ebc39ba4";

    // annotated with @SpyBean to enable spying on the real implementation
    // like that I can use it in methods like "verify" which require a mock
    @SpyBean
    @Autowired
    private BlockService blockService;

    @Autowired
    private CacheManager cacheManager;


    @Test
    public void givenRedisCaching_whenFindItemById_thenItemReturnedFromCache() throws URISyntaxException {
        PageBlocks pageBlocksCacheMiss = blockService.getBlocksForPage(PAGE_ID);
        PageBlocks pageBlocksCacheHit = blockService.getBlocksForPage(PAGE_ID);

        assertThat(pageBlocksCacheMiss).isNotNull();
        assertThat(pageBlocksCacheHit).isNotNull();
        assertThat(pageBlocksCacheMiss).isEqualTo(pageBlocksCacheHit);

        verify(blockService, times(1)).getBlocksForPage(PAGE_ID);
        assertThat(pageBlockFromCache()).isEqualTo(pageBlocksCacheMiss);
    }

    private Object pageBlockFromCache() {
        return cacheManager.getCache("blocksForPageCache").get(PAGE_ID).get();
    }

    @TestConfiguration
    static class EmbeddedRedisConfiguration {

        private final RedisServer redisServer;

        public EmbeddedRedisConfiguration() {
            this.redisServer = new RedisServer();
        }

        @PostConstruct
        public void startRedis() {
            redisServer.start();
        }

        @PreDestroy
        public void stopRedis() {
            this.redisServer.stop();
        }
    }

}
