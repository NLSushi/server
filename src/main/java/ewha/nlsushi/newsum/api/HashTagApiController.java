package ewha.nlsushi.newsum.api;

import ewha.nlsushi.newsum.domain.HashTag;
import ewha.nlsushi.newsum.service.HashTagESService;
import ewha.nlsushi.newsum.api.response.HashTagResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HashTagApiController {

    private final HashTagESService hashTagESService;

    @GetMapping("api/autocomplete")
    @ApiOperation(value="검색어 자동완성 해시태그 조회",notes="input 파라미터로 들어온 값으로 시작하는 해시태그들을 자동완성해서 조회합니다.")
    @ApiImplicitParam(name="input",value ="자동완성을 위한 실시간 유저 검색어",required = false)
    public Result viewHashTagAutoCompleteResult(@RequestParam(name = "input")String input){
        log.info("AutoCompleteApi start: input = "+input);

        List<HashTag> hashTags = hashTagESService.findHashTagbyinput(input);
        for(HashTag each: hashTags){
            log.info("조회된 hashTag : "+ each.getTag());
        }
        List<HashTagResponse> dtos = hashTags.stream().map(h->new HashTagResponse(h.getTag()))
                .collect(Collectors.toList());
        return new Result(dtos);
    }
}
