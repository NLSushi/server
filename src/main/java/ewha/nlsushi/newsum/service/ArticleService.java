package ewha.nlsushi.newsum.service;

import ewha.nlsushi.newsum.domain.Article;
import ewha.nlsushi.newsum.domain.Member;
import ewha.nlsushi.newsum.repository.ArticleRepository;
import ewha.nlsushi.newsum.repository.ArticleRepositorySupport;
import ewha.nlsushi.newsum.repository.MemberRepository;
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
    private final MemberRepository memberRepository;

    //기사 조회
    public List<ArticleOutput> showArticles(){
        List<Article> articles =  articleRepository.findAll();
        return articleListToDTOList(articles);
    }

    public List<ArticleOutput> showJoongangRecent() {
        List<Article> articles = articleRepositorySupport.findJoongangRecent();
        return articleListToDTOList(articles);
    }
    public List<ArticleOutput> showKhanRecent() {
        List<Article> articles = articleRepositorySupport.findKhanRecent();
        return articleListToDTOList(articles);
    }
    public List<ArticleOutput> showHanRecent() {
        List<Article> articles = articleRepositorySupport.findHanRecent();
        return articleListToDTOList(articles);
    }

    public List<ArticleOutput> showRecent() {
        List<Article> articles = articleRepository.findByRecent(true);
        return articleListToDTOList(articles);
    }



    public List<ArticleOutput> articleListToDTOList(List<Article> articleList){
        List<ArticleOutput> result = articleList.stream().map(a ->
                new ArticleOutput(a.getId(),a.getTitle(),a.getWriter(),a.getDate(),a.getCompany(),a.getImg(),a.getArticle_origin(),a.getArticle_extractive(),a.getArticle_hashtag(),a.getCategory()))
                .collect(Collectors.toList());
        return result;
    }
}
