package ewha.nlsushi.newsum.api;

import ewha.nlsushi.newsum.domain.HashTag;
import ewha.nlsushi.newsum.service.HashTagESService;
import ewha.nlsushi.newsum.service.outputForm.HashTagDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public Result viewHashTagAutoCompleteResult(@RequestParam(name = "input")String input){
        log.info("AutoCompleteApi start: input = "+input);
        List<HashTag> hashTags = hashTagESService.findHashTagbyinput(input);
        for(HashTag each: hashTags){
            log.info(each.getTag());
        }
        List<HashTagDTO> dtos = hashTags.stream().map(h->new HashTagDTO(h.getTag()))
                .collect(Collectors.toList());
        return new Result(dtos);
    }
}
