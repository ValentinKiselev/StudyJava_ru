package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;

public class FunctionalTest {

    public void testStorage(Shortener shortener) {
        String string1 = "string1";
        String string2 = "string2";
        String string3 = "string1";
        Long iden1 = shortener.getId(string1);
        Long iden2 = shortener.getId(string2);
        Long iden3 = shortener.getId(string3);

        Assert.assertNotEquals(iden2, iden1);
        Assert.assertNotEquals(iden2, iden3);

        Assert.assertEquals(iden1, iden3);

        String string1fromid = shortener.getString(iden1);
        String string2fromid = shortener.getString(iden2);
        String string3fromid = shortener.getString(iden3);

        Assert.assertEquals(string1fromid, string1);
        Assert.assertEquals(string2fromid, string2);
        Assert.assertEquals(string3fromid, string3);
    }

        @Test
        public void testHashMapStorageStrategy(){
            HashMapStorageStrategy hashMapStorageStrategy = new HashMapStorageStrategy();
            Shortener shortener = new Shortener(hashMapStorageStrategy);
            testStorage(shortener);
        }

        @Test
        public void testOurHashMapStorageStrategy(){
            OurHashMapStorageStrategy ourhashMapStorageStrategy = new OurHashMapStorageStrategy();
            Shortener shortener = new Shortener(ourhashMapStorageStrategy);
            testStorage(shortener);
        }

        @Test
        public void testFileStorageStrategy(){
            FileStorageStrategy fileStorageStrategy = new FileStorageStrategy();
            Shortener shortener = new Shortener(fileStorageStrategy);
            testStorage(shortener);
        }

        @Test
        public void testHashBiMapStorageStrategy(){
            HashBiMapStorageStrategy hashBiMapStorageStrategy = new HashBiMapStorageStrategy();
            Shortener shortener = new Shortener(hashBiMapStorageStrategy);
            testStorage(shortener);
        }

        @Test
        public void testDualHashBidiMapStorageStrategy(){
            DualHashBidiMapStorageStrategy dualHashBidiMapStorageStrategy = new DualHashBidiMapStorageStrategy();
            Shortener shortener = new Shortener(dualHashBidiMapStorageStrategy);
            testStorage(shortener);
        }

        @Test
        public void testOurHashBiMapStorageStrategy(){
            OurHashBiMapStorageStrategy ourHashBiMapStorageStrategy = new OurHashBiMapStorageStrategy();
            Shortener shortener = new Shortener(ourHashBiMapStorageStrategy);
            testStorage(shortener);
        }

    }

