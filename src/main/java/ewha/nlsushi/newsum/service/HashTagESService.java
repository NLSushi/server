package ewha.nlsushi.newsum.service;

import ewha.nlsushi.newsum.domain.HashTag;
import ewha.nlsushi.newsum.repository.ElasticsearchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class HashTagESService {
    @Autowired
    ElasticsearchRepository elasticsearchRepository;

    public List<HashTag> findHashTagbyinput(String input){
        log.info("검색어 자동완성 실시간 유저 input : "+input);
        return elasticsearchRepository.findByTag(input);
    }
}
