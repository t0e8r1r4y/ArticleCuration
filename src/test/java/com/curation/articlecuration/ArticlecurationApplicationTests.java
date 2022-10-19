package com.curation.articlecuration;

import com.curation.articlecuration.crawler.service.GetNaverBlogHtml;
import com.curation.articlecuration.crawler.util.WebDriverUtil;
import com.curation.articlecuration.vision.service.VisionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
class ArticlecurationApplicationTests {

	@Autowired
	private GetNaverBlogHtml getNaverBlogHtml;

	@Autowired
	private VisionService visionService;

	@Autowired
	private WebDriverUtil webDriverUtil;

	@Test
	void test1() throws IOException {
		String url = "https://blog.naver.com/dongi0508/222883293822";
		System.out.println(getNaverBlogHtml.getPostComment(url));
	}

	@Test
	void selenium() {
		String url =  "http://blog.naver.com/PostView.naver?blogId=moneybeast&logNo=222872024109&redirect=Dlog&widgetTypeCall=true&topReferer=https%3A%2F%2Fsearch.naver.com%2Fsearch.naver%3Fwhere%3Dview%26sm%3Dtab_jum%26query%3D%25EA%25B0%2595%25EC%259D%25B8%25EA%25B5%25AC&directAccess=false";
		webDriverUtil.chrome();
		webDriverUtil.useDriver(url, "post_footer_contents");
		// 2022-10-19 16:04:39.985  INFO 27846 --- [           main] c.c.a.crawler.util.WebDriverUtil         : 수리남 실화바탕 조봉행 체포(수리남 전요환). 강인구 K씨도 실존인물이라니.. 한국 국제마약조직 검거 최초 사례 (feat. 리스펙) : 네이버 블로그-----------------------------
		//2022-10-19 16:04:40.064  INFO 27846 --- [           main] c.c.a.crawler.util.WebDriverUtil         : 공감 177
	}

	@Test
	void contextLoads() throws IOException {

		String url = "https://blog.naver.com/dongi0508/222883293822";

//		String result = getNaverBlogHtml.getFooterHashTag(url);
		List<String> imgs = getNaverBlogHtml.getImgLink(url);

		for(String img : imgs) {
			System.out.println(img);
		}

	}

	@Test
	void visionTest() {
		String path = "/Users/terryakishin/pythonTest/img_31.jpg";
		visionService.detectLabelsInImages(path);
		/**
		 * google.cloud.vision.v1.EntityAnnotation.mid : /g/1tr17zw8
		 * google.cloud.vision.v1.EntityAnnotation.description : Flash photography
		 * google.cloud.vision.v1.EntityAnnotation.score : 0.88233423
		 * google.cloud.vision.v1.EntityAnnotation.topicality : 0.88233423
		 * google.cloud.vision.v1.EntityAnnotation.mid : /m/01xygc
		 * google.cloud.vision.v1.EntityAnnotation.description : Coat
		 * google.cloud.vision.v1.EntityAnnotation.score : 0.86893886
		 * google.cloud.vision.v1.EntityAnnotation.topicality : 0.86893886
		 * google.cloud.vision.v1.EntityAnnotation.mid : /m/0244x1
		 * google.cloud.vision.v1.EntityAnnotation.description : Gesture
		 * google.cloud.vision.v1.EntityAnnotation.score : 0.85260487
		 * google.cloud.vision.v1.EntityAnnotation.topicality : 0.85260487
		 * google.cloud.vision.v1.EntityAnnotation.mid : /m/062581
		 * google.cloud.vision.v1.EntityAnnotation.description : Sleeve
		 * google.cloud.vision.v1.EntityAnnotation.score : 0.8182503
		 * google.cloud.vision.v1.EntityAnnotation.topicality : 0.8182503
		 * google.cloud.vision.v1.EntityAnnotation.mid : /m/091410
		 * google.cloud.vision.v1.EntityAnnotation.description : Collar
		 * google.cloud.vision.v1.EntityAnnotation.score : 0.8126593
		 * google.cloud.vision.v1.EntityAnnotation.topicality : 0.8126593
		 * google.cloud.vision.v1.EntityAnnotation.mid : /m/06hwcd
		 * google.cloud.vision.v1.EntityAnnotation.description : Dress shirt
		 * google.cloud.vision.v1.EntityAnnotation.score : 0.79818934
		 * google.cloud.vision.v1.EntityAnnotation.topicality : 0.79818934
		 * google.cloud.vision.v1.EntityAnnotation.mid : /m/01xyhv
		 * google.cloud.vision.v1.EntityAnnotation.description : Suit
		 * google.cloud.vision.v1.EntityAnnotation.score : 0.78783226
		 * google.cloud.vision.v1.EntityAnnotation.topicality : 0.78783226
		 * google.cloud.vision.v1.EntityAnnotation.mid : /m/04xz_5
		 * google.cloud.vision.v1.EntityAnnotation.description : Blazer
		 * google.cloud.vision.v1.EntityAnnotation.score : 0.782218
		 * google.cloud.vision.v1.EntityAnnotation.topicality : 0.782218
		 * google.cloud.vision.v1.EntityAnnotation.mid : /m/016pp7
		 * google.cloud.vision.v1.EntityAnnotation.description : Happy
		 * google.cloud.vision.v1.EntityAnnotation.score : 0.7344322
		 * google.cloud.vision.v1.EntityAnnotation.topicality : 0.7344322
		 * google.cloud.vision.v1.EntityAnnotation.mid : /m/081pkj
		 * google.cloud.vision.v1.EntityAnnotation.description : Event
		 * google.cloud.vision.v1.EntityAnnotation.score : 0.7341407
		 * google.cloud.vision.v1.EntityAnnotation.topicality : 0.7341407
		 */
	}

	@Test
	void visionTest2() throws IOException {
		String path = "/Users/terryakishin/pythonTest/img_31.jpg";
		visionService.detectLocalizedObjects(path);
		/**
		 * Object name: Tie
		 * Confidence: 0.92657715
		 * Normalized Vertices:
		 * - (0.41202554, 0.58472353)
		 * - (0.53010714, 0.58472353)
		 * - (0.53010714, 0.99465185)
		 * - (0.41202554, 0.99465185)
		 * Object name: Person
		 * Confidence: 0.8847612
		 * Normalized Vertices:
		 * - (0.2205142, 0.018958183)
		 * - (0.860334, 0.018958183)
		 * - (0.860334, 0.9973958)
		 * - (0.2205142, 0.9973958)
		 * Object name: Person
		 * Confidence: 0.64550304
		 * Normalized Vertices:
		 * - (0.7952492, 0.27231523)
		 * - (0.92598057, 0.27231523)
		 * - (0.92598057, 0.61814696)
		 * - (0.7952492, 0.61814696)
		 * Object name: Outerwear
		 * Confidence: 0.5316281
		 * Normalized Vertices:
		 * - (0.26378438, 0.43116856)
		 * - (0.8550724, 0.43116856)
		 * - (0.8550724, 0.9973958)
		 * - (0.26378438, 0.9973958)
		 */
	}

	@Test
	void visionTest3() throws IOException {
		String path = "/Users/terryakishin/pythonTest/texttest.jpeg";
		visionService.detectDocumentText(path);

		/**
		 * Symbol text: 이 (confidence: 0.133773)
		 * Word text: 이 (confidence: 0.133773)
		 *
		 * Symbol text: 닭 (confidence: 0.419081)
		 * Word text: 닭 (confidence: 0.419081)
		 *
		 * Symbol text: 갈 (confidence: 0.905078)
		 * Symbol text: 비 (confidence: 0.640496)
		 * Word text: 갈비 (confidence: 0.772787)
		 *
		 * Symbol text: 칠 (confidence: 0.169319)
		 * Symbol text: 만 (confidence: 0.202916)
		 * Word text: 칠만 (confidence: 0.186117)
		 *
		 * Symbol text: 볶 (confidence: 0.151366)
		 * Symbol text: 음 (confidence: 0.525638)
		 * Symbol text: 밥 (confidence: 0.431746)
		 * Word text: 볶음밥 (confidence: 0.369583)
		 *
		 * Symbol text: 막 (confidence: 0.279866)
		 * Symbol text: 국 (confidence: 0.861303)
		 * Symbol text: 수 (confidence: 0.786376)
		 * Word text: 막국수 (confidence: 0.642515)
		 *
		 * %nParagraph: %n 이 닭 갈비 칠만 볶음밥 막국수
		 * Paragraph Confidence: 0.458913
		 * Symbol text: M (confidence: 0.272531)
		 * Word text: M (confidence: 0.272531)
		 *
		 * %nParagraph: %n M
		 * Paragraph Confidence: 0.272531
		 * Symbol text: 1 (confidence: 0.497671)
		 * Symbol text: 1 (confidence: 0.607207)
		 * Symbol text: 1 (confidence: 0.772033)
		 * Symbol text: 1 (confidence: 0.866940)
		 * Word text: 1111 (confidence: 0.685963)
		 *
		 * %nParagraph: %n 1111
		 * Paragraph Confidence: 0.685963
		 * Symbol text: 0 (confidence: 0.265002)
		 * Symbol text: 0 (confidence: 0.299009)
		 * Symbol text: 0 (confidence: 0.370725)
		 * Symbol text: 0 (confidence: 0.462879)
		 * Word text: 0000 (confidence: 0.349404)
		 *
		 * %nParagraph: %n 0000
		 * Paragraph Confidence: 0.349404
		 * Symbol text: B (confidence: 0.429774)
		 * Symbol text: e (confidence: 0.350491)
		 * Symbol text: a (confidence: 0.376677)
		 * Symbol text: n (confidence: 0.513593)
		 * Word text: Bean (confidence: 0.417634)
		 *
		 * Symbol text: ! (confidence: 0.711213)
		 * Word text: ! (confidence: 0.711213)
		 *
		 * %nParagraph: %n Bean !
		 * Paragraph Confidence: 0.476349
		 * Symbol text: 해 (confidence: 0.272636)
		 * Symbol text: 물 (confidence: 0.220043)
		 * Word text: 해물 (confidence: 0.246339)
		 *
		 * Symbol text: 음 (confidence: 0.183619)
		 * Symbol text: 식 (confidence: 0.129428)
		 * Word text: 음식 (confidence: 0.156524)
		 *
		 * Symbol text: 칼 (confidence: 0.936596)
		 * Symbol text: 국 (confidence: 0.952617)
		 * Symbol text: 수 (confidence: 0.899873)
		 * Word text: 칼국수 (confidence: 0.929695)
		 *
		 * Symbol text: 수 (confidence: 0.395468)
		 * Word text: 수 (confidence: 0.395468)
		 *
		 * %nParagraph: %n 해물 음식 칼국수 수
		 * Paragraph Confidence: 0.498785
		 * Symbol text: M (confidence: 0.119678)
		 * Symbol text: O (confidence: 0.120389)
		 * Symbol text: N (confidence: 0.195203)
		 * Symbol text: D (confidence: 0.232731)
		 * Symbol text: O (confidence: 0.352628)
		 * Symbol text: r (confidence: 0.184805)
		 * Word text: MONDOr (confidence: 0.200906)
		 *
		 * Symbol text: + (confidence: 0.295439)
		 * Word text: + (confidence: 0.295439)
		 *
		 * %nParagraph: %n MONDOr +
		 * Paragraph Confidence: 0.214410
		 * Symbol text: 만 (confidence: 0.902035)
		 * Symbol text: 화 (confidence: 0.815200)
		 * Word text: 만화 (confidence: 0.858618)
		 *
		 * %nParagraph: %n 만화
		 * Paragraph Confidence: 0.858618
		 * Symbol text: 1 (confidence: 0.289598)
		 * Word text: 1 (confidence: 0.289598)
		 *
		 * %nParagraph: %n 1
		 * Paragraph Confidence: 0.289598
		 * Symbol text: 종 (confidence: 0.801769)
		 * Symbol text: 로 (confidence: 0.871936)
		 * Word text: 종로 (confidence: 0.836853)
		 *
		 * Symbol text: 카 (confidence: 0.611251)
		 * Symbol text: 센 (confidence: 0.778313)
		 * Symbol text: 타 (confidence: 0.716548)
		 * Word text: 카센타 (confidence: 0.702038)
		 *
		 * %nParagraph: %n 종로 카센타
		 * Paragraph Confidence: 0.755964
		 * Symbol text: 구 (confidence: 0.135196)
		 * Word text: 구 (confidence: 0.135196)
		 *
		 * Symbol text: 클 (confidence: 0.128069)
		 * Symbol text: 럽 (confidence: 0.182811)
		 * Word text: 클럽 (confidence: 0.155440)
		 *
		 * %nParagraph: %n 구 클럽
		 * Paragraph Confidence: 0.148692
		 * Symbol text: I (confidence: 0.119678)
		 * Symbol text: n (confidence: 0.127431)
		 * Word text: In (confidence: 0.123555)
		 *
		 * %nParagraph: %n In
		 * Paragraph Confidence: 0.123555
		 * Symbol text: C (confidence: 0.119678)
		 * Symbol text: o (confidence: 0.119678)
		 * Symbol text: n (confidence: 0.119678)
		 * Symbol text: t (confidence: 0.124168)
		 * Symbol text: e (confidence: 0.149585)
		 * Word text: Conte (confidence: 0.126557)
		 *
		 * %nParagraph: %n Conte
		 * Paragraph Confidence: 0.126557
		 * Symbol text: W (confidence: 0.899635)
		 * Word text: W (confidence: 0.899635)
		 *
		 * %nParagraph: %n W
		 * Paragraph Confidence: 0.899635
		 * Symbol text: U (confidence: 0.163500)
		 * Symbol text: B (confidence: 0.181886)
		 * Word text: UB (confidence: 0.172693)
		 *
		 * %nParagraph: %n UB
		 * Paragraph Confidence: 0.172693
		 * Symbol text: S (confidence: 0.354268)
		 * Symbol text: T (confidence: 0.350776)
		 * Symbol text: A (confidence: 0.550032)
		 * Symbol text: Y (confidence: 0.437993)
		 * Word text: STAY (confidence: 0.423267)
		 *
		 * %nParagraph: %n STAY
		 * Paragraph Confidence: 0.423267
		 * Symbol text: 우 (confidence: 0.544658)
		 * Word text: 우 (confidence: 0.544658)
		 *
		 * Symbol text: 당 (confidence: 0.477999)
		 * Symbol text: 구 (confidence: 0.841451)
		 * Symbol text: 장 (confidence: 0.782926)
		 * Word text: 당구장 (confidence: 0.700792)
		 *
		 * %nParagraph: %n 우 당구장
		 * Paragraph Confidence: 0.661759
		 * Symbol text: 1 (confidence: 0.927852)
		 * Symbol text: 0 (confidence: 0.907421)
		 * Symbol text: 2 (confidence: 0.455800)
		 * Symbol text: 8 (confidence: 0.754019)
		 * Word text: 1028 (confidence: 0.761273)
		 *
		 * Symbol text: 1 (confidence: 0.988498)
		 * Symbol text: 0 (confidence: 0.989222)
		 * Symbol text: 0 (confidence: 0.992744)
		 * Symbol text: 0 (confidence: 0.988948)
		 * Word text: 1000 (confidence: 0.989853)
		 *
		 * %nParagraph: %n 1028 1000
		 * Paragraph Confidence: 0.875563
		 * Symbol text: 마 (confidence: 0.787451)
		 * Symbol text: 화 (confidence: 0.740966)
		 * Word text: 마화 (confidence: 0.764209)
		 *
		 * %nParagraph: %n 마화
		 * Paragraph Confidence: 0.764209
		 * Symbol text: 3 (confidence: 0.739862)
		 * Symbol text: ₂ (confidence: 0.507853)
		 * Word text: 3₂ (confidence: 0.623858)
		 *
		 * %nParagraph: %n 3₂
		 * Paragraph Confidence: 0.623858
		 * Symbol text: t (confidence: 0.500240)
		 * Symbol text: o (confidence: 0.626799)
		 * Symbol text: l (confidence: 0.696425)
		 * Symbol text: a (confidence: 0.454731)
		 * Word text: tola (confidence: 0.569549)
		 *
		 * %nParagraph: %n tola
		 * Paragraph Confidence: 0.569549
		 * Symbol text: F (confidence: 0.377681)
		 * Symbol text: R (confidence: 0.331215)
		 * Symbol text: E (confidence: 0.322371)
		 * Symbol text: N (confidence: 0.295395)
		 * Symbol text: C (confidence: 0.335806)
		 * Symbol text: O (confidence: 0.384215)
		 * Word text: FRENCO (confidence: 0.341114)
		 *
		 * %nParagraph: %n FRENCO
		 * Paragraph Confidence: 0.341114
		 * Symbol text: S (confidence: 0.454148)
		 * Word text: S (confidence: 0.454148)
		 *
		 * %nParagraph: %n S
		 * Paragraph Confidence: 0.454148
		 * Symbol text: D (confidence: 0.483916)
		 * Symbol text: O (confidence: 0.359099)
		 * Symbol text: A (confidence: 0.151265)
		 * Symbol text: R (confidence: 0.287305)
		 * Symbol text: R (confidence: 0.320825)
		 * Symbol text: E (confidence: 0.574482)
		 * Word text: DOARRE (confidence: 0.362815)
		 *
		 * %nParagraph: %n DOARRE
		 * Paragraph Confidence: 0.362815
		 * Symbol text: O (confidence: 0.301071)
		 * Symbol text: O (confidence: 0.293622)
		 * Symbol text: D (confidence: 0.302416)
		 * Symbol text: B (confidence: 0.285897)
		 * Symbol text: E (confidence: 0.308105)
		 * Symbol text: C (confidence: 0.271523)
		 * Symbol text: O (confidence: 0.287938)
		 * Symbol text: E (confidence: 0.292125)
		 * Symbol text: E (confidence: 0.271404)
		 * Symbol text: D (confidence: 0.354262)
		 * Symbol text: E (confidence: 0.309313)
		 * Word text: OODBECOEEDE (confidence: 0.297971)
		 *
		 * %nParagraph: %n OODBECOEEDE
		 * Paragraph Confidence: 0.297971
		 * Symbol text: O (confidence: 0.289178)
		 * Symbol text: O (confidence: 0.267151)
		 * Symbol text: O (confidence: 0.298460)
		 * Symbol text: O (confidence: 0.346465)
		 * Symbol text: H (confidence: 0.300056)
		 * Word text: OOOOH (confidence: 0.300262)
		 *
		 * Symbol text: N (confidence: 0.346890)
		 * Symbol text: O (confidence: 0.385990)
		 * Symbol text: D (confidence: 0.327093)
		 * Symbol text: E (confidence: 0.527264)
		 * Symbol text: E (confidence: 0.522409)
		 * Symbol text: D (confidence: 0.588092)
		 * Word text: NODEED (confidence: 0.449623)
		 *
		 * %nParagraph: %n OOOOH NODEED
		 * Paragraph Confidence: 0.381732
		 * Symbol text: ■ (confidence: 0.170478)
		 * Word text: ■ (confidence: 0.170478)
		 *
		 * Symbol text: D (confidence: 0.206072)
		 * Symbol text: D (confidence: 0.260716)
		 * Symbol text: O (confidence: 0.322818)
		 * Symbol text: E (confidence: 0.330472)
		 * Symbol text: D (confidence: 0.340475)
		 * Symbol text: D (confidence: 0.349909)
		 * Symbol text: E (confidence: 0.300138)
		 * Word text: DDOEDDE (confidence: 0.301514)
		 *
		 * %nParagraph: %n ■ DDOEDDE
		 * Paragraph Confidence: 0.285135
		 * Symbol text: D (confidence: 0.303157)
		 * Symbol text: E (confidence: 0.373554)
		 * Symbol text: E (confidence: 0.404297)
		 * Symbol text: D (confidence: 0.429657)
		 * Word text: DEED (confidence: 0.377666)
		 *
		 * %nParagraph: %n DEED
		 * Paragraph Confidence: 0.377666
		 * Symbol text: ■ (confidence: 0.441849)
		 * Word text: ■ (confidence: 0.441849)
		 *
		 * Symbol text: 코 (confidence: 0.687567)
		 * Symbol text: 인 (confidence: 0.824032)
		 * Word text: 코인 (confidence: 0.755800)
		 *
		 * Symbol text: 노 (confidence: 0.942168)
		 * Symbol text: 래 (confidence: 0.981914)
		 * Word text: 노래 (confidence: 0.962041)
		 *
		 * %nParagraph: %n ■ 코인 노래
		 * Paragraph Confidence: 0.775506
		 * Symbol text: 원 (confidence: 0.128970)
		 * Word text: 원 (confidence: 0.128970)
		 *
		 * %nParagraph: %n 원
		 * Paragraph Confidence: 0.128970
		 * Symbol text: D (confidence: 0.895261)
		 * Symbol text: V (confidence: 0.925061)
		 * Symbol text: D (confidence: 0.944591)
		 * Word text: DVD (confidence: 0.921638)
		 *
		 * Symbol text: | (confidence: 0.391008)
		 * Word text: | (confidence: 0.391008)
		 *
		 * Symbol text: 곱 (confidence: 0.290656)
		 * Symbol text: 창 (confidence: 0.617570)
		 * Word text: 곱창 (confidence: 0.454113)
		 *
		 * %nParagraph: %n DVD | 곱창
		 * Paragraph Confidence: 0.677358
		 * Symbol text: 비 (confidence: 0.375430)
		 * Word text: 비 (confidence: 0.375430)
		 *
		 * Symbol text: 충 (confidence: 0.185748)
		 * Symbol text: 전 (confidence: 0.158584)
		 * Word text: 충전 (confidence: 0.172166)
		 *
		 * Symbol text: 노 (confidence: 0.878888)
		 * Symbol text: 래 (confidence: 0.961211)
		 * Symbol text: 방 (confidence: 0.951514)
		 * Word text: 노래방 (confidence: 0.930538)
		 *
		 * %nParagraph: %n 비 충전 노래방
		 * Paragraph Confidence: 0.585229
		 * Symbol text: D (confidence: 0.252040)
		 * Symbol text: E (confidence: 0.339394)
		 * Symbol text: L (confidence: 0.311066)
		 * Symbol text: I (confidence: 0.470127)
		 * Symbol text: V (confidence: 0.489738)
		 * Symbol text: E (confidence: 0.378765)
		 * Symbol text: S (confidence: 0.300533)
		 * Word text: DELIVES (confidence: 0.363095)
		 *
		 * Symbol text: O (confidence: 0.533486)
		 * Symbol text: F (confidence: 0.661697)
		 * Symbol text: F (confidence: 0.593136)
		 * Symbol text: E (confidence: 0.612424)
		 * Symbol text: E (confidence: 0.554633)
		 * Word text: OFFEE (confidence: 0.591075)
		 *
		 * %nParagraph: %n DELIVES OFFEE
		 * Paragraph Confidence: 0.458087
		 * Symbol text: R (confidence: 0.510000)
		 * Symbol text: I (confidence: 0.460717)
		 * Word text: RI (confidence: 0.485359)
		 *
		 * %nParagraph: %n RI
		 * Paragraph Confidence: 0.485359
		 * Symbol text: l (confidence: 0.266347)
		 * Symbol text: e (confidence: 0.407788)
		 * Symbol text: n (confidence: 0.356505)
		 * Word text: len (confidence: 0.343547)
		 *
		 * %nParagraph: %n len
		 * Paragraph Confidence: 0.343547
		 * Symbol text: 양 (confidence: 0.253718)
		 * Symbol text: 꼬 (confidence: 0.457144)
		 * Symbol text: 치 (confidence: 0.487710)
		 * Word text: 양꼬치 (confidence: 0.399524)
		 *
		 * %nParagraph: %n 양꼬치
		 * Paragraph Confidence: 0.399524
		 * Symbol text: T (confidence: 0.303791)
		 * Symbol text: e (confidence: 0.312662)
		 * Symbol text: c (confidence: 0.318680)
		 * Word text: Tec (confidence: 0.311711)
		 *
		 * %nParagraph: %n Tec
		 * Paragraph Confidence: 0.311711
		 * Symbol text: - (confidence: 0.361705)
		 * Symbol text: C (confidence: 0.312483)
		 * Symbol text: O (confidence: 0.297657)
		 * Word text: -CO (confidence: 0.323948)
		 *
		 * %nParagraph: %n -CO
		 * Paragraph Confidence: 0.323948
		 * %nComplete annotation:
		 * 이 닭갈비 칠만볶음밥 막국수
		 * M
		 * 1111
		 * 0000
		 * Bean!
		 * 해물 음식 칼국수수
		 * MONDOr+
		 * 만화
		 * 1
		 * 종로카센타
		 * 구클럽
		 * In
		 * Conte
		 * W
		 * UB
		 * STAY
		 * 우당구장
		 * 1028
		 * 1000
		 * 마화
		 * 3₂
		 * tola
		 * FRENCO
		 * S
		 * DOARRE
		 * OODBECOEEDE
		 * OOOOH NODEED
		 * ■DDOEDDE
		 * DEED
		 * ■코인노래
		 * 원
		 * DVD | 곱창
		 * 비 충전 노래방
		 * DELIVES OFFEE
		 * RI
		 * len
		 * 양꼬치
		 * Tec
		 * -CO
		 */
	}
}
