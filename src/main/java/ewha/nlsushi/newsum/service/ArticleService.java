package ewha.nlsushi.newsum.service;

import ewha.nlsushi.newsum.domain.Article;
import ewha.nlsushi.newsum.repository.ArticleRepository;
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

    //기사 조회
    public List<ArticleOutput> showArticles(){
        List<Article> articles =  articleRepository.findAll();
        return articles.stream().map(a ->
                new ArticleOutput(a.getTitle(),a.getWriter(),a.getCompany(),a.getImg(),a.getArticle_origin(),a.getArticle_extractive()))
                .collect(Collectors.toList());
    }
}
