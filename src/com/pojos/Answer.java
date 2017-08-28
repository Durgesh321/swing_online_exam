/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojos;

/**
 *
 * @author durgesh
 */
public class Answer
{
    private int aId;
    private String answer;

    public Answer(int aId, String answer) {
        this.aId = aId;
        this.answer = answer;
    }

    public Answer() {
    }
    

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    
}
