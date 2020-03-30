package com.nexign.springworkshop.config;

import com.nexign.springworkshop.dao.IDao;
import com.nexign.springworkshop.dao.TodoDao;
import com.nexign.springworkshop.dao.TodoDaoMongo;
import com.nexign.springworkshop.dto.TodoRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DaoConfig {

    @Bean
    @Profile("dev")
    public IDao todoDao() {
        return new TodoDao();
    }

    @Bean
    @Profile("product")
    public IDao todoDaoMongo(TodoRepositories repositories) {
        return new TodoDaoMongo(repositories);
    }
}
