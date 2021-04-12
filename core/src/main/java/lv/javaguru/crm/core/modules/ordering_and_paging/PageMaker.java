package lv.javaguru.crm.core.modules.ordering_and_paging;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class PageMaker {

    @Getter
    @Setter
    private Integer pageNumber;
    @Getter
    @Setter
    private Integer pageSize;

    public List<Object> getPage (List<Object> list) {
        return list.stream()
                .skip((pageNumber-1) * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
    }
}
