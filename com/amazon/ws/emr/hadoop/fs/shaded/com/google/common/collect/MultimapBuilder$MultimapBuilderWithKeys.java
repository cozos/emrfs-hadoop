package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Supplier;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

public abstract class MultimapBuilder$MultimapBuilderWithKeys<K0>
{
  private static final int DEFAULT_EXPECTED_VALUES_PER_KEY = 2;
  
  abstract <K extends K0, V> Map<K, Collection<V>> createMap();
  
  public MultimapBuilder.ListMultimapBuilder<K0, Object> arrayListValues()
  {
    return arrayListValues(2);
  }
  
  public MultimapBuilder.ListMultimapBuilder<K0, Object> arrayListValues(final int expectedValuesPerKey)
  {
    CollectPreconditions.checkNonnegative(expectedValuesPerKey, "expectedValuesPerKey");
    new MultimapBuilder.ListMultimapBuilder()
    {
      public <K extends K0, V> ListMultimap<K, V> build()
      {
        return Multimaps.newListMultimap(createMap(), new MultimapBuilder.ArrayListSupplier(expectedValuesPerKey));
      }
    };
  }
  
  public MultimapBuilder.ListMultimapBuilder<K0, Object> linkedListValues()
  {
    new MultimapBuilder.ListMultimapBuilder()
    {
      public <K extends K0, V> ListMultimap<K, V> build()
      {
        return Multimaps.newListMultimap(createMap(), MultimapBuilder.LinkedListSupplier.instance());
      }
    };
  }
  
  public MultimapBuilder.SetMultimapBuilder<K0, Object> hashSetValues()
  {
    return hashSetValues(2);
  }
  
  public MultimapBuilder.SetMultimapBuilder<K0, Object> hashSetValues(final int expectedValuesPerKey)
  {
    CollectPreconditions.checkNonnegative(expectedValuesPerKey, "expectedValuesPerKey");
    new MultimapBuilder.SetMultimapBuilder()
    {
      public <K extends K0, V> SetMultimap<K, V> build()
      {
        return Multimaps.newSetMultimap(createMap(), new MultimapBuilder.HashSetSupplier(expectedValuesPerKey));
      }
    };
  }
  
  public MultimapBuilder.SetMultimapBuilder<K0, Object> linkedHashSetValues()
  {
    return linkedHashSetValues(2);
  }
  
  public MultimapBuilder.SetMultimapBuilder<K0, Object> linkedHashSetValues(final int expectedValuesPerKey)
  {
    CollectPreconditions.checkNonnegative(expectedValuesPerKey, "expectedValuesPerKey");
    new MultimapBuilder.SetMultimapBuilder()
    {
      public <K extends K0, V> SetMultimap<K, V> build()
      {
        return Multimaps.newSetMultimap(createMap(), new MultimapBuilder.LinkedHashSetSupplier(expectedValuesPerKey));
      }
    };
  }
  
  public MultimapBuilder.SortedSetMultimapBuilder<K0, Comparable> treeSetValues()
  {
    return treeSetValues(Ordering.natural());
  }
  
  public <V0> MultimapBuilder.SortedSetMultimapBuilder<K0, V0> treeSetValues(final Comparator<V0> comparator)
  {
    Preconditions.checkNotNull(comparator, "comparator");
    new MultimapBuilder.SortedSetMultimapBuilder()
    {
      public <K extends K0, V extends V0> SortedSetMultimap<K, V> build()
      {
        return Multimaps.newSortedSetMultimap(createMap(), new MultimapBuilder.TreeSetSupplier(comparator));
      }
    };
  }
  
  public <V0 extends Enum<V0>> MultimapBuilder.SetMultimapBuilder<K0, V0> enumSetValues(final Class<V0> valueClass)
  {
    Preconditions.checkNotNull(valueClass, "valueClass");
    new MultimapBuilder.SetMultimapBuilder()
    {
      public <K extends K0, V extends V0> SetMultimap<K, V> build()
      {
        Supplier<Set<V>> factory = new MultimapBuilder.EnumSetSupplier(valueClass);
        return Multimaps.newSetMultimap(createMap(), factory);
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */