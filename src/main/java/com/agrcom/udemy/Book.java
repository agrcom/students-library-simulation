package com.agrcom.udemy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public record Book(int id, Lock lock) {
    public Book {
        lock = new ReentrantLock();
    }

    public Book(int id) {
        this(id, null);
    }

    public void read(Student student) throws InterruptedException {
        lock.tryLock(10000, TimeUnit.MILLISECONDS);
//        lock.lock();
        log.info("{} starts reading {}", student, this);
        Thread.sleep(2000);
        lock.unlock();
        log.info("{} finish reading {}", student, this);
    }

    @Override
    public String toString() {
        return String.format("Book #%s", id);
    }
}
