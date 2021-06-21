package com.learning;

public class Hash<K,V> {
    double maxLoadFactor;
    int elementCount;
    int tableSize;
    LinkedList<HashElement<K,V>>[] harray;
    LinkedList<K> keys;

    public Hash(int tableSize){

        harray = (LinkedList<HashElement<K,V>>[]) new LinkedList [tableSize];

        for(int i =0; i < tableSize; i++){
            this.harray[i] = new LinkedList<HashElement<K,V>>();
            elementCount = 0;
            maxLoadFactor = 0.75;
        }
        this.tableSize = tableSize;
        keys = new LinkedList<>();
    }


    private double getLoadFactor(){
        if(tableSize == 0 || elementCount == 0) return 0;
        return Double.valueOf(elementCount)/ tableSize;
    }

    private int computeHash(int hashValue){
        return Math.abs(hashValue) % this.tableSize;
    }
    private int computeHash(int hashValue, int tableSize){
        return Math.abs(hashValue) % tableSize;
    }
    public void add(K key, V value){
        if(getLoadFactor() > maxLoadFactor){
            //resize Hash
            resize(this.tableSize * 2);
        }
        int hash = computeHash(key.hashCode());
        HashElement hashElement = new HashElement(key,value);
        harray[hash].addFirst(hashElement);
        keys.addFirst(key);
        elementCount++;
    }

    private void resize(int tableSize){
        LinkedList<HashElement<K,V>>[] new_harray =(LinkedList<HashElement<K,V>>[]) new LinkedList[tableSize];
        for (int i = 0; i < tableSize; i ++){
            new_harray[i] =(LinkedList<HashElement<K,V>>) new LinkedList();
        }
       for (K key : keys){
            V value = getValue(key);
            int hash = computeHash(key.hashCode(),tableSize);
            new_harray[hash].addFirst(new HashElement<>(key,value));
       }
       this.tableSize = tableSize;
       this.harray = new_harray;
    }

    public HashElement<K,V> remove(K key){
        if(elementCount == 0) return  null;
        int hash = computeHash(key.hashCode());
        elementCount--;
        keys.remove(key);
        return harray[hash].remove(new HashElement<>(key,null));
    }

    public V getValue(K key){
        if(elementCount == 0) return null;
        int hashValue = computeHash(key.hashCode());

        for( HashElement<K,V> he : harray[hashValue]){

            if(((Comparable<K>)he.getKey()).compareTo(key) == 0){
                return  he.getValue();
            }
        }
        return null;
    }



    public class HashElement<K,V> implements Comparable<HashElement<K,V>>{
        K key;
        V value;

        public HashElement(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public int compareTo(HashElement<K, V> o) {
            return ((Comparable <K>) o.getKey()).compareTo(this.key);
        }
    }

}
