package com.felfire.Number4_ListInjection;

import java.util.List;
import com.felfire.Number3_nesting.Song;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CollectionBean {
    
    @Autowired @Qualifier("list")
    private List<Song> songList;

    public void printCollections() {
        songList.forEach(s -> System.out.println(s.getTitle()));
    }
}
