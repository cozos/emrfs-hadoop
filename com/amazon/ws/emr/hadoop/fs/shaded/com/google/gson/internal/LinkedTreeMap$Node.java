package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal;

import java.util.Map.Entry;

final class LinkedTreeMap$Node<K, V>
  implements Map.Entry<K, V>
{
  Node<K, V> parent;
  Node<K, V> left;
  Node<K, V> right;
  Node<K, V> next;
  Node<K, V> prev;
  final K key;
  V value;
  int height;
  
  LinkedTreeMap$Node()
  {
    key = null;
    prev = this;next = this;
  }
  
  LinkedTreeMap$Node(Node<K, V> parent, K key, Node<K, V> next, Node<K, V> prev)
  {
    this.parent = parent;
    this.key = key;
    height = 1;
    this.next = next;
    this.prev = prev;
    next = this;
    prev = this;
  }
  
  public K getKey()
  {
    return (K)key;
  }
  
  public V getValue()
  {
    return (V)value;
  }
  
  public V setValue(V value)
  {
    V oldValue = this.value;
    this.value = value;
    return oldValue;
  }
  
  public boolean equals(Object o)
  {
    if ((o instanceof Map.Entry))
    {
      Map.Entry other = (Map.Entry)o;
      return (key == null ? other.getKey() == null : key.equals(other.getKey())) && (value == null ? other.getValue() == null : value.equals(other.getValue()));
    }
    return false;
  }
  
  public int hashCode()
  {
    return (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
  }
  
  public String toString()
  {
    return key + "=" + value;
  }
  
  public Node<K, V> first()
  {
    Node<K, V> node = this;
    Node<K, V> child = left;
    while (child != null)
    {
      node = child;
      child = left;
    }
    return node;
  }
  
  public Node<K, V> last()
  {
    Node<K, V> node = this;
    Node<K, V> child = right;
    while (child != null)
    {
      node = child;
      child = right;
    }
    return node;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.LinkedTreeMap.Node
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */