package com.agrcom.udemy;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public record Student(int id, Book[] books) implements Runnable {
    @Override
    public void run() {
        Random random = new Random();

        while (true) {
            int bookId = random.nextInt(Constants.NUMBER_OF_BOOKS);
            try {
                books[bookId].read(this);

            } catch (InterruptedException ex) {
                log.error(ex.toString());
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Student #%s", id);
    }
}
