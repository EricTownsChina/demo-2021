package search;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Eric 840017241@qq.com
 * @date 2021/7/13 20:37
 * <p>
 * Desc:
 */
@Slf4j
@RestController
public class EsSearchTest {

    @Resource
    private RestHighLevelClient restHighLevelClient;


    /**
     * 创建索引
     */
    @GetMapping("/create")
    public void createIndex() {
        // 索引数据
        Map<String,Object> json = new HashMap<>();
        json.put("userName","Eric");
        json.put("msg","hello ES7");
        // 请求对象 指定索引名称，和source 数据
        IndexRequest indexRequest = new IndexRequest("demo.client.test.01").source(json);
        try {
            // 执行得到 response
            IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
            System.out.println("出参："+indexResponse.toString());
            // 不要关闭
            // restHighLevelClient.close();
        } catch (Exception ignored){

        }
    }


    @GetMapping("/search")
    public String search() {
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("userName", "X6021");
        sourceBuilder.query(matchQueryBuilder);

        SearchRequest searchRequest = new SearchRequest("demo.client.test.01");
        searchRequest.source(sourceBuilder);

        SearchResponse search = null;
        try {
            search = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            // ignore
        }

        SearchHits hits = search.getHits();
//        hits.

        System.out.println(".....");
        return "success";


    }




}
