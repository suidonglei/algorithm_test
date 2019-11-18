package learn.algorithm;

import javax.security.auth.kerberos.KerberosKey;
import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 */
public class LRUCache {
    class CacheNode {
        int data;
        int key;
        CacheNode next;
        CacheNode previous;
    }
    private Map<Integer, CacheNode> cacheNodeMap;
    private int size;
    private CacheNode head;
    private CacheNode tail;
    public LRUCache(int capacity) {
        cacheNodeMap= new HashMap<>(capacity);
        size = capacity;
        head = new CacheNode();
        tail = new CacheNode();
        head.next = tail;
        tail.previous = head;
    }

    public int get(int key) {
        CacheNode cacheNode = cacheNodeMap.get(key);
        if(null == cacheNode) {
            return -1;
        }
        cacheNode.previous.next = cacheNode.next;
        cacheNode.next.previous = cacheNode.previous;
        head.next.previous = cacheNode;
        cacheNode.next = head.next;
        head.next = cacheNode;
        cacheNode.previous = head;
        return cacheNode.data;
    }

    public void put(int key, int value) {
        int inCacheNode = get(key);
        if(inCacheNode != -1) {
            cacheNodeMap.get(key).data = value;
            return;
        }

        if(cacheNodeMap.size() >= size) {
            CacheNode remoceNode = tail.previous;
            cacheNodeMap.remove(remoceNode.key);
            tail.previous = remoceNode.previous;
            remoceNode.previous.next = tail;
            remoceNode.next = null;
            remoceNode.previous = null;
        }
        CacheNode cacheNode = new CacheNode();
        cacheNode.key = key;
        cacheNode.data = value;
        cacheNode.next = head.next;
        head.next.previous = cacheNode;
        cacheNode.previous = head;
        head.next = cacheNode;
        cacheNodeMap.put(key, cacheNode);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        System.out.println(lruCache.get(2));
        lruCache.put(2, 6);
        System.out.println(lruCache.get(1));
        lruCache.put(1, 5);
        lruCache.put(1, 2);
        System.out.println();
        System.out.println();
        System.out.println();
    }
}