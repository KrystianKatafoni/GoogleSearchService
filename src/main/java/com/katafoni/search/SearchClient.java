package com.katafoni.search;

import com.katafoni.api.Item;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchClient {

    public List<Item> searchPhrase(String phrase) {
        Item item = new Item();
        item.setTitle("ResultTitle");
        item.setLink("ResultLink");
        item.setDisplayLink("ResultDisplayLink");
        item.setSnippet("ResultSnippet");
        item.setHtmlSnippet("ResultHtmlSnippet");

        return List.of(item);
    }
}
