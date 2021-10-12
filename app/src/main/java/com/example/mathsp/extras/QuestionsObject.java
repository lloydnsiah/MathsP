package com.example.mathsp.extras;

public class QuestionsObject {
    private String no;
    private String question;
    private String ans1;
    private String ans2;
    private String ans3;
    private String ans4;
    private String correctans;

    public QuestionsObject(String quesNo, String question, String ans_one, String ans_two, String ans_three, String ans_four, String correct_ans) {
        this.no = quesNo;
        this.question = question;
        this.ans1 = ans_one;
        this.ans2 = ans_two;
        this.ans3 = ans_three;
        this.ans4 = ans_four;
        this.correctans = correct_ans;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAns1() {
        return ans1;
    }

    public void setAns1(String ans1) {
        this.ans1 = ans1;
    }

    public String getAns2() {
        return ans2;
    }

    public void setAns2(String ans2) {
        this.ans2 = ans2;
    }

    public String getAns3() {
        return ans3;
    }

    public void setAns3(String ans3) {
        this.ans3 = ans3;
    }

    public String getAns4() {
        return ans4;
    }

    public void setAns4(String ans4) {
        this.ans4 = ans4;
    }

    public String getCorrect_ans() {
        return correctans;
    }

    public void setCorrect_ans(String correct_ans) {
        this.correctans = correct_ans;
    }
}
