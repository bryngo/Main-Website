package org.dcsc.faq.form;

import org.dcsc.faq.QuestionAnswer;

/**
 * Created by tktong on 8/7/2015.
 */
public class QuestionAnswerForm {
    private long id;
    private String question;
    private String answer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionAnswer build() {
        QuestionAnswer qa = new QuestionAnswer();

        qa.setId(id);
        qa.setQuestion(question);
        qa.setAnswer(answer);

        return qa;
    }
}
