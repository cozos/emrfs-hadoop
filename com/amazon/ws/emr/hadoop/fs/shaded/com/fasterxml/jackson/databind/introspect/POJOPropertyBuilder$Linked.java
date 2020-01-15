package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyName;

public final class POJOPropertyBuilder$Linked<T>
{
  public final T value;
  public final Linked<T> next;
  public final PropertyName name;
  public final boolean isNameExplicit;
  public final boolean isVisible;
  public final boolean isMarkedIgnored;
  
  public POJOPropertyBuilder$Linked(T v, Linked<T> n, PropertyName name, boolean explName, boolean visible, boolean ignored)
  {
    value = v;
    next = n;
    
    this.name = ((name == null) || (name.isEmpty()) ? null : name);
    if (explName)
    {
      if (this.name == null) {
        throw new IllegalArgumentException("Can not pass true for 'explName' if name is null/empty");
      }
      if (!name.hasSimpleName()) {
        explName = false;
      }
    }
    isNameExplicit = explName;
    isVisible = visible;
    isMarkedIgnored = ignored;
  }
  
  public Linked<T> withoutNext()
  {
    if (next == null) {
      return this;
    }
    return new Linked(value, null, name, isNameExplicit, isVisible, isMarkedIgnored);
  }
  
  public Linked<T> withValue(T newValue)
  {
    if (newValue == value) {
      return this;
    }
    return new Linked(newValue, next, name, isNameExplicit, isVisible, isMarkedIgnored);
  }
  
  public Linked<T> withNext(Linked<T> newNext)
  {
    if (newNext == next) {
      return this;
    }
    return new Linked(value, newNext, name, isNameExplicit, isVisible, isMarkedIgnored);
  }
  
  public Linked<T> withoutIgnored()
  {
    if (isMarkedIgnored) {
      return next == null ? null : next.withoutIgnored();
    }
    if (next != null)
    {
      Linked<T> newNext = next.withoutIgnored();
      if (newNext != next) {
        return withNext(newNext);
      }
    }
    return this;
  }
  
  public Linked<T> withoutNonVisible()
  {
    Linked<T> newNext = next == null ? null : next.withoutNonVisible();
    return isVisible ? withNext(newNext) : newNext;
  }
  
  protected Linked<T> append(Linked<T> appendable)
  {
    if (next == null) {
      return withNext(appendable);
    }
    return withNext(next.append(appendable));
  }
  
  public Linked<T> trimByVisibility()
  {
    if (next == null) {
      return this;
    }
    Linked<T> newNext = next.trimByVisibility();
    if (name != null)
    {
      if (name == null) {
        return withNext(null);
      }
      return withNext(newNext);
    }
    if (name != null) {
      return newNext;
    }
    if (isVisible == isVisible) {
      return withNext(newNext);
    }
    return isVisible ? withNext(null) : newNext;
  }
  
  public String toString()
  {
    String msg = value.toString() + "[visible=" + isVisible + ",ignore=" + isMarkedIgnored + ",explicitName=" + isNameExplicit + "]";
    if (next != null) {
      msg = msg + ", " + next.toString();
    }
    return msg;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.Linked
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */