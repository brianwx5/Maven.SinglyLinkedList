package com.zipcodewilmington.singlylinkedlist;


import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest<T> {

    @Test
    public void addTest() {
        //Given
        String word = "Butter";
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();


        //When
        singlyLinkedList.add(word);

        //Then
        Assert.assertEquals(word,singlyLinkedList.get(0));
    }

    @Test
    public void removeTest() {
        //Given
        String word = "Butter";
        String word2 = "Biscuit";
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        //When
        singlyLinkedList.add(word);
        singlyLinkedList.add(word2);
        singlyLinkedList.remove(0);

        //Then
        Assert.assertFalse(singlyLinkedList.contains(word));
    }

    @Test
    public void sizeTest() {
        //Given
        String word = "Butter";
        String word2 = "Biscuit";
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        int expected = 2;

        //When
        singlyLinkedList.add(word);
        singlyLinkedList.add(word2);
        int actual = singlyLinkedList.size;

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void sizeTest2() {
        //Given
        String word = "Butter";
        String word2 = "Biscuit";
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        int expected = 1;

        //When
        singlyLinkedList.add(word);
        singlyLinkedList.add(word2);
        singlyLinkedList.remove(0);
        int actual = singlyLinkedList.size;

        //Then
        Assert.assertEquals(expected,actual);
    }



    @Test
    public void cotainsTest() {
        String word = "Belief is in oneself";
        String word2 = "Just do it!";
        Boolean expected = true;
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        //When
        singlyLinkedList.add(word);
        singlyLinkedList.add(word2);
        Boolean actual = singlyLinkedList.contains(word);

        //Then
        Assert.assertEquals(expected,actual);


    }

    @Test
    public void findTest() {
        //Given
        String word = "Bridge";
        String word2 = "The little giant";
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        int expected = 1;

        //When
        singlyLinkedList.add(word);
        singlyLinkedList.add(word2);
        int actual = singlyLinkedList.find(word2);

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getTest() {
        //Given
        String word = "Bridge";
        String word2 = "The little giant";
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();


        //When
        singlyLinkedList.add(word);
        singlyLinkedList.add(word2);
        String actual = (String) singlyLinkedList.get(1);

        //Then
        Assert.assertEquals(word2,actual);
    }

    @Test
    public void copyTest() {
        //Given
        String word = "Bridge";
        String word2 = "The little giant";
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();

        //When
        singlyLinkedList.add(word);
        singlyLinkedList.add(word2);
        SinglyLinkedList<String> actual = singlyLinkedList.copy();

        //Then
        for (int i = 0; i < singlyLinkedList.size ; i++) {
            Assert.assertEquals(singlyLinkedList.get(i),actual.get(i));
        }

    }

    @Test
    public void sortTest() {
        //Given
        String word = "The little giant";
        String word2 = "Bridge";
        SinglyLinkedList expected = new SinglyLinkedList();
        expected.add(word2);
        expected.add(word);
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();


        //When
        singlyLinkedList.add(word);
        singlyLinkedList.add(word2);
        singlyLinkedList.sort();

        //Then
        for (int i = 0; i < singlyLinkedList.size ; i++) {
            Assert.assertEquals(expected.get(i), singlyLinkedList.get(i));
        }



    }
}
