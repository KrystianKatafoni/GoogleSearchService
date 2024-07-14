package com.katafoni.search;

import com.katafoni.api.Item;
import com.katafoni.api.SearchPhraseRequest;
import com.katafoni.api.SearchPhraseResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

import static com.katafoni.search.ConstantVariables.NAMESPACE_URI;

@Endpoint
public class SearchFassade {

    private final SearchClient searchClient;

    public SearchFassade(SearchClient searchClient) {
        this.searchClient = searchClient;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "searchPhraseRequest")
    @ResponsePayload
    public SearchPhraseResponse searchPhraseRequest(@RequestPayload SearchPhraseRequest request) {
        List<Item> items = searchClient.searchPhrase(request.getText());
        SearchPhraseResponse response = new SearchPhraseResponse();
        response.getItem().addAll(items);
        return response;
    }

}
