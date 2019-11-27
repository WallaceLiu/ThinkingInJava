package com.bdata.cap.chapter5;
// Using finalize() to detect an object that
// hasn't been properly cleaned up.
public class TerminationCondition {
    public static void main(String[] args){
        Book novel = new Book(true);
        novel.checkIn();

        new Book(true);
        System.gc();
    }

    /*output
    Error: checked out
     */
}
