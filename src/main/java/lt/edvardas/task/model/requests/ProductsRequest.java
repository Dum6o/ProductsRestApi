package lt.edvardas.task.model.requests;

public class ProductsRequest {

    private Integer ageId;
    private Integer incomeId;
    private Boolean student;

    public ProductsRequest() {
    }

    public ProductsRequest(Integer ageId, Integer incomeId, Boolean student) {
        this.ageId = ageId;
        this.incomeId = incomeId;
        this.student = student;
    }

    public Integer getAgeId() {
        return ageId;
    }

    public void setAgeId(Integer ageId) {
        this.ageId = ageId;
    }

    public Integer getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(Integer incomeId) {
        this.incomeId = incomeId;
    }

    public Boolean getStudent() {
        return student;
    }

    public void setStudent(Boolean student) {
        this.student = student;
    }
}
