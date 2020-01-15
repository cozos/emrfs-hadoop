package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

final class Sets$CartesianSet<E>
  extends ForwardingCollection<List<E>>
  implements Set<List<E>>
{
  private final transient ImmutableList<ImmutableSet<E>> axes;
  private final transient CartesianList<E> delegate;
  
  static <E> Set<List<E>> create(List<? extends Set<? extends E>> sets)
  {
    ImmutableList.Builder<ImmutableSet<E>> axesBuilder = new ImmutableList.Builder(sets.size());
    for (Set<? extends E> set : sets)
    {
      ImmutableSet<E> copy = ImmutableSet.copyOf(set);
      if (copy.isEmpty()) {
        return ImmutableSet.of();
      }
      axesBuilder.add(copy);
    }
    ImmutableList<ImmutableSet<E>> axes = axesBuilder.build();
    ImmutableList<List<E>> listAxes = new ImmutableList()
    {
      public int size()
      {
        return val$axes.size();
      }
      
      public List<E> get(int index)
      {
        return ((ImmutableSet)val$axes.get(index)).asList();
      }
      
      boolean isPartialView()
      {
        return true;
      }
    };
    return new CartesianSet(axes, new CartesianList(listAxes));
  }
  
  private Sets$CartesianSet(ImmutableList<ImmutableSet<E>> axes, CartesianList<E> delegate)
  {
    this.axes = axes;
    this.delegate = delegate;
  }
  
  protected Collection<List<E>> delegate()
  {
    return delegate;
  }
  
  public boolean equals(@Nullable Object object)
  {
    if ((object instanceof CartesianSet))
    {
      CartesianSet<?> that = (CartesianSet)object;
      return axes.equals(axes);
    }
    return super.equals(object);
  }
  
  public int hashCode()
  {
    int adjust = size() - 1;
    for (int i = 0; i < axes.size(); i++)
    {
      adjust *= 31;
      adjust = adjust ^ 0xFFFFFFFF ^ 0xFFFFFFFF;
    }
    int hash = 1;
    for (Set<E> axis : axes)
    {
      hash = 31 * hash + size() / axis.size() * axis.hashCode();
      
      hash = hash ^ 0xFFFFFFFF ^ 0xFFFFFFFF;
    }
    hash += adjust;
    return hash ^ 0xFFFFFFFF ^ 0xFFFFFFFF;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Sets.CartesianSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */