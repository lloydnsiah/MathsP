package com.example.mathsp.extras;

public class QuestionsObject {
    private String quesNo;
    private String question;
    private String ans_one;
    private String ans_two;
    private String ans_three;
    private String ans_four;
    private String correct_ans;

    public QuestionsObject(String quesNo, String question, String ans_one, String ans_two, String ans_three, String ans_four, String correct_ans) {
        this.quesNo = quesNo;
        this.question = question;
        this.ans_one = ans_one;
        this.ans_two = ans_two;
        this.ans_three = ans_three;
        this.ans_four = ans_four;
        this.correct_ans = correct_ans;
    }

    public String getQuesNo() {
        return quesNo;
    }

    public void setQuesNo(String quesNo) {
        this.quesNo = quesNo;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAns_one() {
        return ans_one;
    }

    public void setAns_one(String ans_one) {
        this.ans_one = ans_one;
    }

    public String getAns_two() {
        return ans_two;
    }

    public void setAns_two(String ans_two) {
        this.ans_two = ans_two;
    }

    public String getAns_three() {
        return ans_three;
    }

    public void setAns_three(String ans_three) {
        this.ans_three = ans_three;
    }

    public String getAns_four() {
        return ans_four;
    }

    public void setAns_four(String ans_four) {
        this.ans_four = ans_four;
    }

    public String getCorrect_ans() {
        return correct_ans;
    }

    public void setCorrect_ans(String correct_ans) {
        this.correct_ans = correct_ans;
    }
}
