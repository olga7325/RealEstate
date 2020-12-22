package ua.realestate.management.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableCaching
@Configuration
//@EnableJpaRepositories(basePackages = "ua.realestate.management.repository")
public class CacheConfiguration{

    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactory(){
        EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        cacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        cacheManagerFactoryBean.setShared(true);

        return cacheManagerFactoryBean;
    }


    @Bean
    public EhCacheCacheManager ehCacheCacheManager(){
        EhCacheCacheManager cacheManager = new EhCacheCacheManager();
        cacheManager.setCacheManager(ehCacheManagerFactory().getObject());
        cacheManager.setTransactionAware(true);

        return cacheManager;
        //return new EhCacheCacheManager(ehCacheManagerFactory().getObject());
    }

}
