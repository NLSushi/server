package ewha.nlsushi.newsum.service;

import ewha.nlsushi.newsum.domain.Article;
import ewha.nlsushi.newsum.repository.ArticleRepository;
import ewha.nlsushi.newsum.repository.ArticleRepositorySupport;
import ewha.nlsushi.newsum.service.outputForm.ArticleOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleRepositorySupport articleRepositorySupport;

    //기사 조회
    public List<ArticleOutput> showArticles(){
        List<Article> articles =  articleRepository.findAll();
        List<ArticleOutput> result =  articles.stream().map(a ->
                new ArticleOutput(a.getId(),a.getTitle(),a.getWriter(),a.getDate(),a.getCompany(),a.getImg(),a.getArticle_origin(),a.getArticle_extractive(),a.getArticle_hashtag(),a.getCategory()))
                .collect(Collectors.toList());
        return result;
    }

    public List<ArticleOutput> showJoongangRecent() {
        List<Article> articles = articleRepositorySupport.findJoongangRecent();
        List<ArticleOutput> result =  articles.stream().map(a ->
                new ArticleOutput(a.getId(),a.getTitle(),a.getWriter(),a.getDate(),a.getCompany(),a.getImg(),a.getArticle_origin(),a.getArticle_extractive(),a.getArticle_hashtag(),a.getCategory()))
                .collect(Collectors.toList());
        return result;
    }
    public List<ArticleOutput> showKhanRecent() {
        List<Article> articles = articleRepositorySupport.findKhanRecent();
        List<ArticleOutput> result =  articles.stream().map(a ->
                new ArticleOutput(a.getId(),a.getTitle(),a.getWriter(),a.getDate(),a.getCompany(),a.getImg(),a.getArticle_origin(),a.getArticle_extractive(),a.getArticle_hashtag(),a.getCategory()))
                .collect(Collectors.toList());
        return result;
    }
    public List<ArticleOutput> showHanRecent() {
        List<Article> articles = articleRepositorySupport.findHanRecent();
        List<ArticleOutput> result =  articles.stream().map(a ->
                new ArticleOutput(a.getId(),a.getTitle(),a.getWriter(),a.getDate(),a.getCompany(),a.getImg(),a.getArticle_origin(),a.getArticle_extractive(),a.getArticle_hashtag(),a.getCategory()))
                .collect(Collectors.toList());
        return result;
    }
}
