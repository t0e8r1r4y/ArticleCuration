package com.curation.articlecuration;

import com.curation.articlecuration.crawler.service.GetNaverBlogHtml;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
class ArticlecurationApplicationTests {

	@Autowired
	private GetNaverBlogHtml getNaverBlogHtml;
	@Test
	void contextLoads() throws IOException {

		String url = "https://blog.naver.com/dongi0508/222883293822";

		String result = getNaverBlogHtml.getReplyCnt(url);

		System.out.println(result);

	}

}
