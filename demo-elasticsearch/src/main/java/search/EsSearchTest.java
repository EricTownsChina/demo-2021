package search;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author Eric 840017241@qq.com
 * @date 2021/7/13 20:37
 * <p>
 * Desc:
 */
@RestController
public class EsSearchTest {

    @Resource
    private RestHigh restHighLevelClient;


    @GetMapping("/search")
    public String search() {
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("userCode", "X6021");
        sourceBuilder.query(matchQueryBuilder);


        SearchRequest searchRequest = new SearchRequest("xxgl.znwd.chat.test");
        searchRequest.source(sourceBuilder);


        SearchResponse search = null;
        try {
            search = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            // ignore
        }

        SearchHits hits = search.getHits();


        System.out.println(".....");
        return "success";


    }




}
