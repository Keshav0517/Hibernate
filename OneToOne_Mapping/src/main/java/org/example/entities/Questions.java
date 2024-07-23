package org.example.entities;

import javax.persistence.*;

@Entity
public class Questions {
    @Id
    @Column(name = "question_id")
    private int questionId;
    private String question;

    @OneToOne
    @JoinColumn(name = "ansId")      //change the name of join column
    private Answers ans;

    public Questions(int questionId, String question, Answers ans) {
        super();
        this.questionId = questionId;
        this.question = question;
        this.ans = ans;
    }

    public Questions(){
        super();
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answers getAns() {
        return ans;
    }

    public void setAns(Answers ans) {
        this.ans = ans;
    }
}
