package com.qasite.service;
import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;
import java.util.*;

public class sentencedivService {
    public static List<String> divide(String sentence){
        JiebaSegmenter segmenter = new JiebaSegmenter();
        List<SegToken> list = segmenter.process(sentence, JiebaSegmenter.SegMode.SEARCH);
        List<String>  results = new ArrayList<String>();
        for(SegToken s : list){
            results.add(s.word);
        }
        return results;
    }
    public static List<String> properties(String sentence){
        JiebaSegmenter segmenter = new JiebaSegmenter();
        List<SegToken> list = segmenter.process(sentence, JiebaSegmenter.SegMode.SEARCH);
        List<String>  results = new ArrayList<String>();
        for(SegToken s : list){
            results.add(s.properties);
        }
        return results;
    }
}
