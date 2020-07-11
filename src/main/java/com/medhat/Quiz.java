package com.medhat;
import java.util.ArrayList;
import java.util.List;

public class Quiz {

    private int CurrentQuesitionIndex;
    private int NumCorrect;
    private List<int[]> questions;


    public Quiz() {

        CurrentQuesitionIndex = 0;
        NumCorrect = 0;
        questions = new ArrayList<int[]>();
        questions.add(new int[] {1,3,1,4,1,5,9});
        questions.add(new int[] {1, 1, 2, 3, 5,8});
        questions.add(new int[] {1, 4, 9, 16, 25,36});
        questions.add(new int[] {2, 3, 5, 7, 11,13});
        questions.add(new int[] {1, 2, 4, 8, 16,32});


    }

    public int getCurrentQuestionIndex() {
        return CurrentQuesitionIndex;
    }

    public void setCurrentQuesitionIndex(int currentQuesitionIndex) {
        CurrentQuesitionIndex = currentQuesitionIndex;
    }

    public int getNumQuestions() {
        return questions.size();
    }

    public int getNumCorrect() {
        return NumCorrect;
    }

    public void setNumCorrect(int numCorrect) {
        NumCorrect = numCorrect;
    }

    public List<int[]> getQuestions() {
        return questions;
    }

    public int[] nextList() {
        return this.questions.get(CurrentQuesitionIndex);
    }

    public boolean isCorrect(int num) {

        if(this.questions.get(this.CurrentQuesitionIndex)[this.questions.get(this.CurrentQuesitionIndex).length-1]==num) {
            CurrentQuesitionIndex++;
            NumCorrect++;
            return true;
        }
        return false;
    }






}
