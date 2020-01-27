package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever {
    Storage storage;
    LRUCache<Long, Object> lruCache;
    OriginalRetriever originalRetriever;

    public CachingProxyRetriever(Storage storage) {
        this.storage = storage;
        this.originalRetriever = new OriginalRetriever(storage);
        lruCache = new LRUCache<>(16);
    }

    @Override
    public Object retrieve(long id) {
        Object obj = lruCache.find(id);
        if(obj == null) {
            obj = originalRetriever.retrieve(id);
            this.lruCache.set(id, obj);
        }
        return obj;
    }
}
