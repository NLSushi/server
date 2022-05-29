package ewha.nlsushi.newsum.service;

import ewha.nlsushi.newsum.domain.Article;
import ewha.nlsushi.newsum.repository.ArticleRepository;
import ewha.nlsushi.newsum.repository.MemberRepository;
import ewha.nlsushi.newsum.api.response.ArticleResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final MemberRepository memberRepository;

    //기사 조회
    public List<ArticleResponse> showArticles(){
        List<Article> articles =  articleRepository.findAll();
        log.info("전체 기사 조회");
        return ArticleResponse.articleListToDTOList(articles);
    }
    //언론사별 최신 기사 조회
    public List<ArticleResponse> showJoongangRecent() {
        List<Article> articles = articleRepository.findByCompanyAndRecent("중앙일보",true);
        log.info("중앙일보 최신 기사 조회");
        return ArticleResponse.articleListToDTOList(articles);
    }

    public List<ArticleResponse> showKhanRecent() {
        List<Article> articles = articleRepository.findByCompanyAndRecent("경향신문",true);
        log.info("경향신문 최신 기사 조회");
        return ArticleResponse.articleListToDTOList(articles);
    }

    public List<ArticleResponse> showHanRecent() {
        List<Article> articles = articleRepository.findByCompanyAndRecent("한겨레",true);
        log.info("한겨레 최신 기사 조회");
        return ArticleResponse.articleListToDTOList(articles);
    }

    public List<ArticleResponse> showRecent() {
        List<Article> articles = articleRepository.findByRecent(true);
        log.info("최신 기사 조회");
        return ArticleResponse.articleListToDTOList(articles);
    }


    public List<ArticleResponse> SearchArticlesByHashTag(String hashtag){
        List<Article> articles = articleRepository.findByHashtag(hashtag);
        log.info("해시태그 기반 기사 조회, 해시태그 : "+hashtag);
        return ArticleResponse.articleListToDTOList(articles);
    }

}
