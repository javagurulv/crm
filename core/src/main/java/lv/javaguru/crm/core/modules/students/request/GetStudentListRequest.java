package lv.javaguru.crm.core.modules.students.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class GetStudentListRequest {

    @Getter
    @Setter
    private String queryString;

}
