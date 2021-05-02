package question.answer.platform.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TempComment {
    @NotNull(message = "Answer Id Cannot be null")
    private Long answerid;
    @NotNull(message = "User ID cannot be null")
    private Long userid;
    @NotNull(message = "Comment text can not be null")
    @Size(min = 50,max = 500, message = "Commment length must be greater than 50 and less than 500")
    private String text;

    public Long getAnswerid() {
        return answerid;
    }

    public void setAnswerid(Long answerid) {
        this.answerid = answerid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
