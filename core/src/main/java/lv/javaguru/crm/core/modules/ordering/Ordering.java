package lv.javaguru.crm.core.modules.ordering;

public class Ordering {

    private String orderBy;
    private  DirectBy directBy;

    public Ordering(String orderBy, DirectBy directBy) {
        this.orderBy = orderBy;
        this.directBy = directBy;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public DirectBy getDirectBy() {
        return directBy;
    }

    private enum DirectBy {
    ASCENDING,
    DESCENDING
    }
}
