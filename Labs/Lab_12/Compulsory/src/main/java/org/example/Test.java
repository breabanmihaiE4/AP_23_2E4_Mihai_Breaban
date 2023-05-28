package org.example;

public class Test {
    private int myNumber;
    private String myText;

    public Test(int number, String text) {
        myNumber = number;
        myText = text;
    }

    public int getMyNumber() {
        return myNumber;
    }

    public void setMyNumber(int number) {
        myNumber = number;
    }

    public String getMyText() {
        return myText;
    }

    public void setMyText(String text) {
        myText = text;
    }

    public void printInfo() {
        System.out.println("Number: " + myNumber);
        System.out.println("Text: " + myText);
    }
}
