package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Injector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.PrivateBinder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Lists;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Maps;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ToStringBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Element;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ElementVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.PrivateElements;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class PrivateElementsImpl
  implements PrivateElements
{
  private final Object source;
  private List<Element> elementsMutable = .Lists.newArrayList();
  private List<ExposureBuilder<?>> exposureBuilders = .Lists.newArrayList();
  private .ImmutableList<Element> elements;
  private .ImmutableMap<Key<?>, Object> exposedKeysToSources;
  private Injector injector;
  
  public PrivateElementsImpl(Object source)
  {
    this.source = .Preconditions.checkNotNull(source, "source");
  }
  
  public Object getSource()
  {
    return source;
  }
  
  public List<Element> getElements()
  {
    if (elements == null)
    {
      elements = .ImmutableList.copyOf(elementsMutable);
      elementsMutable = null;
    }
    return elements;
  }
  
  public Injector getInjector()
  {
    return injector;
  }
  
  public void initInjector(Injector injector)
  {
    .Preconditions.checkState(this.injector == null, "injector already initialized");
    this.injector = ((Injector).Preconditions.checkNotNull(injector, "injector"));
  }
  
  public Set<Key<?>> getExposedKeys()
  {
    if (exposedKeysToSources == null)
    {
      Map<Key<?>, Object> exposedKeysToSourcesMutable = .Maps.newLinkedHashMap();
      for (ExposureBuilder<?> exposureBuilder : exposureBuilders) {
        exposedKeysToSourcesMutable.put(exposureBuilder.getKey(), exposureBuilder.getSource());
      }
      exposedKeysToSources = .ImmutableMap.copyOf(exposedKeysToSourcesMutable);
      exposureBuilders = null;
    }
    return exposedKeysToSources.keySet();
  }
  
  public <T> T acceptVisitor(ElementVisitor<T> visitor)
  {
    return (T)visitor.visit(this);
  }
  
  public List<Element> getElementsMutable()
  {
    return elementsMutable;
  }
  
  public void addExposureBuilder(ExposureBuilder<?> exposureBuilder)
  {
    exposureBuilders.add(exposureBuilder);
  }
  
  public void applyTo(Binder binder)
  {
    PrivateBinder privateBinder = binder.withSource(source).newPrivateBinder();
    for (Element element : getElements()) {
      element.applyTo(privateBinder);
    }
    getExposedKeys();
    for (Map.Entry<Key<?>, Object> entry : exposedKeysToSources.entrySet()) {
      privateBinder.withSource(entry.getValue()).expose((Key)entry.getKey());
    }
  }
  
  public Object getExposedSource(Key<?> key)
  {
    getExposedKeys();
    Object source = exposedKeysToSources.get(key);
    .Preconditions.checkArgument(source != null, "%s not exposed by %s.", new Object[] { key, this });
    return source;
  }
  
  public String toString()
  {
    return new .ToStringBuilder(PrivateElements.class).add("exposedKeys", getExposedKeys()).add("source", getSource()).toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.PrivateElementsImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */