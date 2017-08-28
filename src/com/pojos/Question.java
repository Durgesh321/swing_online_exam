/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojos;

import java.util.List;
import java.util.Set;

/**
 *
 * @author durgesh
 */
public class Question
{
    private int questionId;
    private String question;
    private Set<Options> options;
    private Answer ans;

    public Answer getAns() {
        return ans;
    }

    public void setAns(Answer ans) {
        this.ans = ans;
    }

    public Set<Options> getOptions() {
        return options;
    }

    public void setOptions(Set<Options> options) {
        this.options = options;
    }
    
   
    
    
   
    public Question() {
    }

    public Question(int questionId, String queston) {
        this.questionId = questionId;
        this.question = queston;
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

    public void setQuestion(String queston) {
        this.question = queston;
    }
    
}
