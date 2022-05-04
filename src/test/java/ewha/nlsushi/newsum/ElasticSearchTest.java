package ewha.nlsushi.newsum;

import ewha.nlsushi.newsum.domain.HashTag;
import ewha.nlsushi.newsum.repository.ElasticsearchRepository;
import ewha.nlsushi.newsum.service.HashTagESService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)
public class ElasticSearchTest {

    @Resource
    ElasticsearchRepository hashtagEsRepository;
    @Resource
    HashTagESService hashTagESService;

    @Test
    public void 해시태그조회(){
        //when
        List<HashTag> hashTag = hashTagESService.findHashTagbyinput("ㅇ");
        //then
        Assertions.assertThat(hashTag.size()).isEqualTo(3);

    }
}
