package com.xwhking.elasticsearchtest;

import cn.hutool.json.JSONUtil;
import com.xwhking.elasticsearchtest.Entity.Hotel;
import com.xwhking.elasticsearchtest.Entity.HotelDoc;
import com.xwhking.elasticsearchtest.service.HotelService;
import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.ml.PostDataRequest;
import org.elasticsearch.xcontent.XContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;

@SpringBootTest
class ElasticSearchTestApplicationTests {
    @Resource
    private HotelService hotelService;

    public RestHighLevelClient client ;
    @BeforeEach
    void init(){
        client = new RestHighLevelClient(RestClient.builder(
                HttpHost.create("http://127.0.0.1:9200")
        ));
    }
    @Test
    void contextLoads() throws IOException {
        List<Hotel> hotels = new ArrayList<>();
        ArrayList<HotelDoc> hotelDocs = new ArrayList<>();
        hotels = hotelService.list();
        for(Hotel hotel: hotels){
            HotelDoc hotelDoc = new HotelDoc();
            hotelDoc.setId(hotel.getId());
            hotelDoc.setName(hotel.getName());
            hotelDoc.setAddress (hotel.getAddress());
            hotelDoc.setPrice(hotel.getPrice());
            hotelDoc.setScore(hotel.getScore());
            hotelDoc.setBrand(hotel.getBrand());
            hotelDoc.setCity(hotel.getCity());
            hotelDoc.setStarName(hotel.getStar_name());
            hotelDoc.setBusiness(hotel.getBusiness());
            hotelDoc.setLocation( hotel.getLatitude() + "," + hotel.getLongitude() );
            hotelDoc.setPic(hotel.getPic());
            IndexRequest indexRequest = new IndexRequest("hotel");
            indexRequest.id(hotelDoc.getId().toString());
            String template = JSONUtil.toJsonStr(hotelDoc);
            indexRequest.source(template, XContentType.JSON);
            IndexResponse response =  client.index(indexRequest, RequestOptions.DEFAULT);
            System.err.println(JSONUtil.parse(response));
        }
    }
    @Test
    void testGetDoc() throws IOException {
        GetRequest getRequest = new GetRequest("xwhking","1");
        System.out.println(client.get(getRequest, RequestOptions.DEFAULT));
    }
    @AfterEach
    void destroy() throws IOException {
        client.close();
    }
}
