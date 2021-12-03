package com.jessie.LibraryManagement;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class NoSpringTest
{
    @Test
    public void testLocalDate(){
        LocalDate localDate=LocalDate.now();
        String myString=localDate.toString();
        System.out.println(myString);
    }
}
