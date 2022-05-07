package com.newcorder.community.service;

import com.newcorder.community.dao.elasticsearch.DiscussPostRepository;
import com.newcorder.community.entity.DiscussPost;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Field;
import org.springframework.data.elasticsearch.core.query.HighlightQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.highlight.Highlight;
import org.springframework.data.elasticsearch.core.query.highlight.HighlightField;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ElasticSearchService {
    @Autowired
    private DiscussPostRepository discussPostRepository;

    @Autowired
    private ElasticsearchRestTemplate esTemplate;

    public void saveDisscussPost(DiscussPost post) {
        discussPostRepository.save(post);
    }

    public void deleteDiscussPost(int id) {
        discussPostRepository.deleteById(id);
    }

    //    这个Page是sping的类，不是自定义的实体类
    public SearchHits<DiscussPost> searchDiscussPost(String keyword, int currentPage, int limit) {
        String field1 = "title";
        String field2 = "content";
//        HighlightBuilder highlightBuilder1 = new HighlightBuilder();
//        HighlightBuilder highlightBuilder2 = new HighlightBuilder();
//        highlightBuilder1.field(field1).preTags("<font size=\"3\" color=\"red\"").postTags("</font>").requireFieldMatch(false);
//        highlightBuilder2.field(keyword).preTags("<font size=\"3\" color=\"red\"").postTags("</font>").requireFieldMatch(false);

        NativeSearchQuery query = new NativeSearchQueryBuilder().withQuery(QueryBuilders.multiMatchQuery(keyword, field1, field2))
                .withSorts(SortBuilders.fieldSort("type").order(SortOrder.DESC))
                .withSorts(SortBuilders.fieldSort("score").order(SortOrder.DESC))
                .withSorts(SortBuilders.fieldSort("createTime").order(SortOrder.DESC))
                .withPageable(PageRequest.of(currentPage, limit))
                /*.withHighlightBuilder(highlightBuilder1)*/
                /*.withHighlightBuilder(highlightBuilder2)*/
                .build();

        return  esTemplate.search(query, DiscussPost.class);
    }

}
