package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.ExclusionStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.FieldAttributes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.Gson;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapterFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.annotations.Expose;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.annotations.Since;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.annotations.Until;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.reflect.TypeToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Excluder
  implements TypeAdapterFactory, Cloneable
{
  private static final double IGNORE_VERSIONS = -1.0D;
  public static final Excluder DEFAULT = new Excluder();
  private double version = -1.0D;
  private int modifiers = 136;
  private boolean serializeInnerClasses = true;
  private boolean requireExpose;
  private List<ExclusionStrategy> serializationStrategies = Collections.emptyList();
  private List<ExclusionStrategy> deserializationStrategies = Collections.emptyList();
  
  protected Excluder clone()
  {
    try
    {
      return (Excluder)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new AssertionError();
    }
  }
  
  public Excluder withVersion(double ignoreVersionsAfter)
  {
    Excluder result = clone();
    version = ignoreVersionsAfter;
    return result;
  }
  
  public Excluder withModifiers(int... modifiers)
  {
    Excluder result = clone();
    modifiers = 0;
    for (int modifier : modifiers) {
      modifiers |= modifier;
    }
    return result;
  }
  
  public Excluder disableInnerClassSerialization()
  {
    Excluder result = clone();
    serializeInnerClasses = false;
    return result;
  }
  
  public Excluder excludeFieldsWithoutExposeAnnotation()
  {
    Excluder result = clone();
    requireExpose = true;
    return result;
  }
  
  public Excluder withExclusionStrategy(ExclusionStrategy exclusionStrategy, boolean serialization, boolean deserialization)
  {
    Excluder result = clone();
    if (serialization)
    {
      serializationStrategies = new ArrayList(serializationStrategies);
      serializationStrategies.add(exclusionStrategy);
    }
    if (deserialization)
    {
      deserializationStrategies = new ArrayList(deserializationStrategies);
      
      deserializationStrategies.add(exclusionStrategy);
    }
    return result;
  }
  
  public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> type)
  {
    Class<?> rawType = type.getRawType();
    final boolean skipSerialize = excludeClass(rawType, true);
    final boolean skipDeserialize = excludeClass(rawType, false);
    if ((!skipSerialize) && (!skipDeserialize)) {
      return null;
    }
    new TypeAdapter()
    {
      private TypeAdapter<T> delegate;
      
      public T read(JsonReader in)
        throws IOException
      {
        if (skipDeserialize)
        {
          in.skipValue();
          return null;
        }
        return (T)delegate().read(in);
      }
      
      public void write(JsonWriter out, T value)
        throws IOException
      {
        if (skipSerialize)
        {
          out.nullValue();
          return;
        }
        delegate().write(out, value);
      }
      
      private TypeAdapter<T> delegate()
      {
        TypeAdapter<T> d = delegate;
        return d != null ? d : (delegate = gson.getDelegateAdapter(Excluder.this, type));
      }
    };
  }
  
  public boolean excludeField(Field field, boolean serialize)
  {
    if ((modifiers & field.getModifiers()) != 0) {
      return true;
    }
    if ((version != -1.0D) && (!isValidVersion((Since)field.getAnnotation(Since.class), (Until)field.getAnnotation(Until.class)))) {
      return true;
    }
    if (field.isSynthetic()) {
      return true;
    }
    if (requireExpose)
    {
      Expose annotation = (Expose)field.getAnnotation(Expose.class);
      if ((annotation == null) || (serialize ? !annotation.serialize() : !annotation.deserialize())) {
        return true;
      }
    }
    if ((!serializeInnerClasses) && (isInnerClass(field.getType()))) {
      return true;
    }
    if (isAnonymousOrLocal(field.getType())) {
      return true;
    }
    List<ExclusionStrategy> list = serialize ? serializationStrategies : deserializationStrategies;
    FieldAttributes fieldAttributes;
    if (!list.isEmpty())
    {
      fieldAttributes = new FieldAttributes(field);
      for (ExclusionStrategy exclusionStrategy : list) {
        if (exclusionStrategy.shouldSkipField(fieldAttributes)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean excludeClass(Class<?> clazz, boolean serialize)
  {
    if ((version != -1.0D) && (!isValidVersion((Since)clazz.getAnnotation(Since.class), (Until)clazz.getAnnotation(Until.class)))) {
      return true;
    }
    if ((!serializeInnerClasses) && (isInnerClass(clazz))) {
      return true;
    }
    if (isAnonymousOrLocal(clazz)) {
      return true;
    }
    List<ExclusionStrategy> list = serialize ? serializationStrategies : deserializationStrategies;
    for (ExclusionStrategy exclusionStrategy : list) {
      if (exclusionStrategy.shouldSkipClass(clazz)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean isAnonymousOrLocal(Class<?> clazz)
  {
    return (!Enum.class.isAssignableFrom(clazz)) && ((clazz.isAnonymousClass()) || (clazz.isLocalClass()));
  }
  
  private boolean isInnerClass(Class<?> clazz)
  {
    return (clazz.isMemberClass()) && (!isStatic(clazz));
  }
  
  private boolean isStatic(Class<?> clazz)
  {
    return (clazz.getModifiers() & 0x8) != 0;
  }
  
  private boolean isValidVersion(Since since, Until until)
  {
    return (isValidSince(since)) && (isValidUntil(until));
  }
  
  private boolean isValidSince(Since annotation)
  {
    if (annotation != null)
    {
      double annotationVersion = annotation.value();
      if (annotationVersion > version) {
        return false;
      }
    }
    return true;
  }
  
  private boolean isValidUntil(Until annotation)
  {
    if (annotation != null)
    {
      double annotationVersion = annotation.value();
      if (annotationVersion <= version) {
        return false;
      }
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.Excluder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */