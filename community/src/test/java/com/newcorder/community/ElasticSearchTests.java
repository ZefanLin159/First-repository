package com.newcorder.community;

import com.newcorder.community.dao.DiscussPostMapper;
import com.newcorder.community.dao.elasticsearch.DiscussPostRepository;
import com.newcorder.community.entity.DiscussPost;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class ElasticSearchTests {
    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Autowired
    private DiscussPostRepository discussPostRepository;
    @Autowired
    //private ElasticsearchTemplate;已废弃
    private ElasticsearchRestTemplate restTemplate;

    @Test
    public void testInsert() {
        discussPostRepository.save(discussPostMapper.selectDiscussPostById(241));
        discussPostRepository.save(discussPostMapper.selectDiscussPostById(242));
        discussPostRepository.save(discussPostMapper.selectDiscussPostById(243));
    }

    @Test
    public void testInsert1() {
        discussPostRepository.save(discussPostMapper.selectDiscussPostById(231));
    }

    @Test
    public void testInsertList() {
        discussPostRepository.saveAll(discussPostMapper.selectDiscussPosts(101, 0, 100));
        discussPostRepository.saveAll(discussPostMapper.selectDiscussPosts(102, 0, 100));
        discussPostRepository.saveAll(discussPostMapper.selectDiscussPosts(103, 0, 100));
        discussPostRepository.saveAll(discussPostMapper.selectDiscussPosts(111, 0, 100));
        discussPostRepository.saveAll(discussPostMapper.selectDiscussPosts(112, 0, 100));
        discussPostRepository.saveAll(discussPostMapper.selectDiscussPosts(131, 0, 100));
        discussPostRepository.saveAll(discussPostMapper.selectDiscussPosts(132, 0, 100));
        discussPostRepository.saveAll(discussPostMapper.selectDiscussPosts(133, 0, 100));
        discussPostRepository.saveAll(discussPostMapper.selectDiscussPosts(134, 0, 100));
    }

    @Test
    public void testUpdate() {
        DiscussPost post = discussPostMapper.selectDiscussPostById(231);
        post.setContent("我是新人，使劲灌水");
        discussPostRepository.save(post);
    }

    @Test
    public void testDelete() {
//        discussPostRepository.deleteById(231);
        discussPostRepository.deleteAll();

    }

    @Test
    public void testSearchByRepository() {
//        官方文档查找到的，和文档不一样

        Query query = new NativeSearchQueryBuilder().withQuery(QueryBuilders.multiMatchQuery("互联网寒冬", "title", "content"))
                .withSorts(SortBuilders.fieldSort("type").order(SortOrder.DESC))
                .withSorts(SortBuilders.fieldSort("score").order(SortOrder.DESC))
                .withSorts(SortBuilders.fieldSort("createTime").order(SortOrder.DESC))
                .withPageable(PageRequest.of(0, 10))
                /*.withHighlightFields(new HighlightBuilder.Field("title").preTags("<em>").postTags("</em>"),
                        new HighlightBuilder.Field("content").preTags("<em>").postTags("</em>"))*/.build();
        SearchHits<DiscussPost> page = restTemplate.search(query, DiscussPost.class);
//        System.out.println(page.getTotalHits());
//        System.out.println(page.getSearchHits());
//        System.out.println(page.getMaxScore());
        for (SearchHit<DiscussPost> discussPost : page) {
            System.out.println(discussPost);
        }
    }

}
