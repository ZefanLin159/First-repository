package com.newcorder.community.dao.elasticsearch;

import com.newcorder.community.entity.DiscussPost;
import org.springframework.data.elasticsearch.annotations.Highlight;
import org.springframework.data.elasticsearch.annotations.HighlightField;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//特殊的数据库 ，spring提供的
@Repository
public interface DiscussPostRepository extends ElasticsearchRepository<DiscussPost, Integer> {
//    @Highlight(fields = {
//            @HighlightField(name = "name"),
//            @HighlightField(name = "summary")
//    })
//    List<SearchHit<DiscussPost>> findByNameOrSummary(String name, String summary);
}
