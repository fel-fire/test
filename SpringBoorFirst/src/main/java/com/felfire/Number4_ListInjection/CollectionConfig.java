package com.felfire.Number4_ListInjection;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.felfire.Number3_nesting.Song;

@Configuration
public class CollectionConfig {
    
    @Bean
    List<Song> list() {
        return List.of(new Song("Song 1 in list()"), new Song("Song 2 in list"));
    }

    @Bean
    Song song3() {
        return new Song("Song 3 in bean");
    }

        @Bean
    Song song4() {
        return new Song("Song 4 in bean");
    }
}
