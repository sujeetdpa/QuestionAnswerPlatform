package question.answer.platform.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class TempQuestion {
    @NotNull(message = "Question text cannot be null")
    @Size(min = 50,max = 500,message = "Length must be greater than 50 and less than 500")
    private String text;
    private Long companyid;
    @NotNull(message = "Sub Topic cannot be null")
    private Long subtopicid;
    private List<String> tags;
    @NotNull(message = "Userid cannot be null")
    private Long userid;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Long companyid) {
        this.companyid = companyid;
    }

    public Long getSubtopicid() {
        return subtopicid;
    }

    public void setSubtopicid(Long subtopicid) {
        this.subtopicid = subtopicid;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }
}
