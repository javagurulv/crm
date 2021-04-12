package lv.javaguru.crm.core.modules.ordering_and_paging;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Ordering {

    @Getter
    @Setter
    private String[] orderBy;
    @Getter
    @Setter
    private  DirectBy directBy;

    public List<Object> getOrdering (List<Object> list) {
        return list.stream()
                .sorted()
                // TODO ordering
                .collect(Collectors.toList());
    }

    private enum DirectBy {
    ASCENDING,
    DESCENDING
    }
}
