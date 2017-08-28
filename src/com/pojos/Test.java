/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojos;


import java.util.List;

/**
 *
 * @author durgesh
 */

public class Test {
   
private int testId;
private String testName;

private List<Question> questions;

    public Test(int testId, String testNme) {
        this.testId = testId;
        this.testName = testNme;
        
    }

    public Test() {
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testNme) {
        this.testName = testNme;
    }
    

}
