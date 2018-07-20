package com.qasite.service;
import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;
import java.util.*;

public class SentenceDiv {

    private static SentenceDiv sentenceDiv;
    private static JiebaSegmenter segmenter;

    public static SentenceDiv getInstance(){
        if (sentenceDiv == null)
            sentenceDiv = new SentenceDiv();
        return sentenceDiv;
    }

    public SentenceDiv(){
        if (segmenter == null)
            segmenter = new JiebaSegmenter();
    }

    /*
    * Param sentence 传入字符串
    * return result 将字符串中进行分词并返回词条列表
    * */
    public List<String> divide(String sentence){
        if (segmenter == null)
            return null;
        List<SegToken> list = segmenter.process(sentence, JiebaSegmenter.SegMode.SEARCH);
        List<String>  results = new ArrayList<String>();
        for(SegToken s : list){
            results.add(s.word);
        }
        return results;
    }
    /*
     * Param sentence 传入字符串
     * return result 将字符串中进行分词并返回词条列表对应的词性
     * */
    public List<String> properties(String sentence){
        if (segmenter == null)
            return null;
        List<SegToken> list = segmenter.process(sentence, JiebaSegmenter.SegMode.SEARCH);
        List<String>  results = new ArrayList<String>();
        for(SegToken s : list){
            results.add(s.properties);
        }
        return results;
    }
}
