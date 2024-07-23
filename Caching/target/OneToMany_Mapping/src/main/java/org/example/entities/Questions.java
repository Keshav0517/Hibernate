package org.example.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Ques_info")
public class Questions {
    @Id
    @Column(name = "question_id")
    private int questionId;

    private String question;

    @OneToMany(mappedBy = "ques",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Answers> answersList;

    public Questions(int questionId, String question, List<Answers> answersList) {
        super();
        this.questionId = questionId;
        this.question = question;
        this.answersList = answersList;
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

    public List<Answers> getAnswersList() {
        return answersList;
    }

    public void setAnswersList(List<Answers> answersList) {
        this.answersList = answersList;
    }
}
