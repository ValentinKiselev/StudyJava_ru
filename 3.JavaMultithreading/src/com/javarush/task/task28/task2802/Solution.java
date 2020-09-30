package com.javarush.task.task28.task2802;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/
public class Solution {

    public static class AmigoThreadFactory implements ThreadFactory{

        private static AtomicInteger factCount = new AtomicInteger(0);
        AtomicInteger factNum = new AtomicInteger(0);
        AtomicInteger threadNum = new AtomicInteger(0);
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();

        public AmigoThreadFactory()
        {
            factNum.set(factCount.incrementAndGet());
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(threadGroup,r);
            thread.setName(threadGroup.getName() + "-pool" + "-"+ factNum+"-thread-" + threadNum.incrementAndGet());
            thread.setDaemon(false);
            thread.setPriority(5);
            return thread;
        }
    }

    public static void main(String[] args) {
        class EmulatorThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulatorThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulatorThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }
}
