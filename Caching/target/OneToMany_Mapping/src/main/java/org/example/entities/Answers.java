package org.example.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Ans_info")
public class Answers {
    @Id
    @Column(name = "answer_id")
    private int answerId;

    private String answer;

    @ManyToOne
    private Questions ques;

    public Answers(int answerId, String answer, Questions ques) {
        super();
        this.answerId = answerId;
        this.answer = answer;
        this.ques = ques;
    }

    public Answers(){
        super();
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Questions getQuestion() {
        return ques;
    }

    public void setQuestion(Questions ques) {
        this.ques = ques;
    }
}
