package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Objects;
import javax.annotation.Nullable;

@VisibleForTesting
final class LinkedHashMultimap$ValueEntry<K, V>
  extends ImmutableEntry<K, V>
  implements LinkedHashMultimap.ValueSetLink<K, V>
{
  final int smearedValueHash;
  @Nullable
  ValueEntry<K, V> nextInValueBucket;
  LinkedHashMultimap.ValueSetLink<K, V> predecessorInValueSet;
  LinkedHashMultimap.ValueSetLink<K, V> successorInValueSet;
  ValueEntry<K, V> predecessorInMultimap;
  ValueEntry<K, V> successorInMultimap;
  
  LinkedHashMultimap$ValueEntry(@Nullable K key, @Nullable V value, int smearedValueHash, @Nullable ValueEntry<K, V> nextInValueBucket)
  {
    super(key, value);
    this.smearedValueHash = smearedValueHash;
    this.nextInValueBucket = nextInValueBucket;
  }
  
  boolean matchesValue(@Nullable Object v, int smearedVHash)
  {
    return (smearedValueHash == smearedVHash) && (Objects.equal(getValue(), v));
  }
  
  public LinkedHashMultimap.ValueSetLink<K, V> getPredecessorInValueSet()
  {
    return predecessorInValueSet;
  }
  
  public LinkedHashMultimap.ValueSetLink<K, V> getSuccessorInValueSet()
  {
    return successorInValueSet;
  }
  
  public void setPredecessorInValueSet(LinkedHashMultimap.ValueSetLink<K, V> entry)
  {
    predecessorInValueSet = entry;
  }
  
  public void setSuccessorInValueSet(LinkedHashMultimap.ValueSetLink<K, V> entry)
  {
    successorInValueSet = entry;
  }
  
  public ValueEntry<K, V> getPredecessorInMultimap()
  {
    return predecessorInMultimap;
  }
  
  public ValueEntry<K, V> getSuccessorInMultimap()
  {
    return successorInMultimap;
  }
  
  public void setSuccessorInMultimap(ValueEntry<K, V> multimapSuccessor)
  {
    successorInMultimap = multimapSuccessor;
  }
  
  public void setPredecessorInMultimap(ValueEntry<K, V> multimapPredecessor)
  {
    predecessorInMultimap = multimapPredecessor;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.LinkedHashMultimap.ValueEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */