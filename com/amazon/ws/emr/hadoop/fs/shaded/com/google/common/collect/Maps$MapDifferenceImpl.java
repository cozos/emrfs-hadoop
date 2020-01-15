package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Objects;
import java.util.Map;

class Maps$MapDifferenceImpl<K, V>
  implements MapDifference<K, V>
{
  final Map<K, V> onlyOnLeft;
  final Map<K, V> onlyOnRight;
  final Map<K, V> onBoth;
  final Map<K, MapDifference.ValueDifference<V>> differences;
  
  Maps$MapDifferenceImpl(Map<K, V> onlyOnLeft, Map<K, V> onlyOnRight, Map<K, V> onBoth, Map<K, MapDifference.ValueDifference<V>> differences)
  {
    this.onlyOnLeft = Maps.access$100(onlyOnLeft);
    this.onlyOnRight = Maps.access$100(onlyOnRight);
    this.onBoth = Maps.access$100(onBoth);
    this.differences = Maps.access$100(differences);
  }
  
  public boolean areEqual()
  {
    return (onlyOnLeft.isEmpty()) && (onlyOnRight.isEmpty()) && (differences.isEmpty());
  }
  
  public Map<K, V> entriesOnlyOnLeft()
  {
    return onlyOnLeft;
  }
  
  public Map<K, V> entriesOnlyOnRight()
  {
    return onlyOnRight;
  }
  
  public Map<K, V> entriesInCommon()
  {
    return onBoth;
  }
  
  public Map<K, MapDifference.ValueDifference<V>> entriesDiffering()
  {
    return differences;
  }
  
  public boolean equals(Object object)
  {
    if (object == this) {
      return true;
    }
    if ((object instanceof MapDifference))
    {
      MapDifference<?, ?> other = (MapDifference)object;
      return (entriesOnlyOnLeft().equals(other.entriesOnlyOnLeft())) && (entriesOnlyOnRight().equals(other.entriesOnlyOnRight())) && (entriesInCommon().equals(other.entriesInCommon())) && (entriesDiffering().equals(other.entriesDiffering()));
    }
    return false;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { entriesOnlyOnLeft(), entriesOnlyOnRight(), entriesInCommon(), entriesDiffering() });
  }
  
  public String toString()
  {
    if (areEqual()) {
      return "equal";
    }
    StringBuilder result = new StringBuilder("not equal");
    if (!onlyOnLeft.isEmpty()) {
      result.append(": only on left=").append(onlyOnLeft);
    }
    if (!onlyOnRight.isEmpty()) {
      result.append(": only on right=").append(onlyOnRight);
    }
    if (!differences.isEmpty()) {
      result.append(": value differences=").append(differences);
    }
    return result.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.MapDifferenceImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */