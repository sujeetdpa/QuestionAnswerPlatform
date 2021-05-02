package question.answer.platform.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TempAnswer {
    @NotNull(message = "Answer text cannot be null")
    @Size(min = 50,max = 500,message = "Length Must be greater than 50 and less than 500")
    private String text;
    @NotNull(message = "Question ID is mandatory")
    private Long questionid;
    @NotNull(message = "User ID cannot be null")
    private Long userid;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Long questionid) {
        this.questionid = questionid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }
}
