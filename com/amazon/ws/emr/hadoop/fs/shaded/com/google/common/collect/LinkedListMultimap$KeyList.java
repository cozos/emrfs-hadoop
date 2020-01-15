package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

class LinkedListMultimap$KeyList<K, V>
{
  LinkedListMultimap.Node<K, V> head;
  LinkedListMultimap.Node<K, V> tail;
  int count;
  
  LinkedListMultimap$KeyList(LinkedListMultimap.Node<K, V> firstNode)
  {
    head = firstNode;
    tail = firstNode;
    previousSibling = null;
    nextSibling = null;
    count = 1;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.LinkedListMultimap.KeyList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */