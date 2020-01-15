package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import javax.annotation.Nullable;

final class LinkedListMultimap$Node<K, V>
  extends AbstractMapEntry<K, V>
{
  final K key;
  V value;
  Node<K, V> next;
  Node<K, V> previous;
  Node<K, V> nextSibling;
  Node<K, V> previousSibling;
  
  LinkedListMultimap$Node(@Nullable K key, @Nullable V value)
  {
    this.key = key;
    this.value = value;
  }
  
  public K getKey()
  {
    return (K)key;
  }
  
  public V getValue()
  {
    return (V)value;
  }
  
  public V setValue(@Nullable V newValue)
  {
    V result = value;
    value = newValue;
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.LinkedListMultimap.Node
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */