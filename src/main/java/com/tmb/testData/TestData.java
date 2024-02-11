package com.tmb.testData;


import io.github.sskorol.data.Column;

public class TestData {

    @Column(name = "testcasename")
    private String testCase;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="expectedtitle")
    private String expectedTitle;

    public String getTestCase(){
       return testCase;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getExpectedTitle(){
        return expectedTitle;
    }
}
