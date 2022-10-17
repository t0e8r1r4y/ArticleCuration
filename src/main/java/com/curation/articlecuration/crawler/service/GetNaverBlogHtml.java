package com.curation.articlecuration.crawler.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class GetNaverBlogHtml {
    // 조회수,  공감수, 대표이미지, 태그 텍스트,  댓글
    private static final String basicUrl = "http://blog.naver.com";




    // OK - 댓글 개수
    public String getReplyCnt(String url) throws IOException {
        // #commentCount
        Document doc = getIframeHtml(url);
        return doc.select("em#commentCount").text();
    }

    // OK - 아티클 작성자 & 생성 시간
    public String getArticleGenTime( String url ) throws IOException {
        Document doc = getIframeHtml(url);
        return doc.select("div.blog2_container").eachText().toString();
    }

    // OK - 본문 글
    public String getContext( String url ) throws IOException {
        Document doc = getIframeHtml(url);
        return doc.select("div.se-main-container").eachText().toString();
    }

    private Document getIframeHtml(String url) throws IOException {

        String iFrameScr = getIframeScr(url);
        Document doc = Jsoup.connect(basicUrl + iFrameScr)
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36")
                .get();

        return doc;
    }

    private String getIframeScr(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements iframes = doc.select("iframe#mainFrame");
        return iframes.attr("src");
    }
}

