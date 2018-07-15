package com.qasite.dao;

import com.qasite.bean.SearchResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SearchMapper {
    List<SearchResult> selectByKeywords(List<String> keys);
    List<SearchResult> selectByKeywordsAndOlds(@Param("keys") List<String> keys, @Param("oldResult") List<SearchResult> oldResult);
}
