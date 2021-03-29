package lv.javaguru.crm.core.modules.students.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lv.javaguru.crm.core.modules.ordering.Ordering;
import lv.javaguru.crm.core.modules.ordering.Paging;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class GetStudentListRequest {

    @Getter
    private Ordering ordering;
    @Getter
    private Paging paging;
    @Getter
    private String queryString;

}
