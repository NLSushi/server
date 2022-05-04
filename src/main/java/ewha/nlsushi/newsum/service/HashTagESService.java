package ewha.nlsushi.newsum.service;

import ewha.nlsushi.newsum.domain.HashTag;
import ewha.nlsushi.newsum.repository.ElasticsearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HashTagESService {
    @Autowired
    ElasticsearchRepository elasticsearchRepository;

    public List<HashTag> findHashTagbyinput(String input){return elasticsearchRepository.findByTag(input);}
}
