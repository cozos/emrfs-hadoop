package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

abstract interface LinkedHashMultimap$ValueSetLink<K, V>
{
  public abstract ValueSetLink<K, V> getPredecessorInValueSet();
  
  public abstract ValueSetLink<K, V> getSuccessorInValueSet();
  
  public abstract void setPredecessorInValueSet(ValueSetLink<K, V> paramValueSetLink);
  
  public abstract void setSuccessorInValueSet(ValueSetLink<K, V> paramValueSetLink);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.LinkedHashMultimap.ValueSetLink
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */