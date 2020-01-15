package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import java.util.Collection;

public class ValidationUtils
{
  public static <T> T assertNotNull(T object, String fieldName)
    throws IllegalArgumentException
  {
    if (object == null) {
      throw new IllegalArgumentException(String.format("%s cannot be null", new Object[] { fieldName }));
    }
    return object;
  }
  
  public static void assertAllAreNull(String messageIfNull, Object... objects)
    throws IllegalArgumentException
  {
    for (Object object : objects) {
      if (object != null) {
        throw new IllegalArgumentException(messageIfNull);
      }
    }
  }
  
  public static int assertIsPositive(int num, String fieldName)
  {
    if (num <= 0) {
      throw new IllegalArgumentException(String.format("%s must be positive", new Object[] { fieldName }));
    }
    return num;
  }
  
  public static <T extends Collection<?>> T assertNotEmpty(T collection, String fieldName)
    throws IllegalArgumentException
  {
    assertNotNull(collection, fieldName);
    if (collection.isEmpty()) {
      throw new IllegalArgumentException(String.format("%s cannot be empty", new Object[] { fieldName }));
    }
    return collection;
  }
  
  public static <T> T[] assertNotEmpty(T[] array, String fieldName)
    throws IllegalArgumentException
  {
    assertNotNull(array, fieldName);
    if (array.length == 0) {
      throw new IllegalArgumentException(String.format("%s cannot be empty", new Object[] { fieldName }));
    }
    return array;
  }
  
  public static String assertStringNotEmpty(String string, String fieldName)
    throws IllegalArgumentException
  {
    assertNotNull(string, fieldName);
    if (string.isEmpty()) {
      throw new IllegalArgumentException(String.format("%s cannot be empty", new Object[] { fieldName }));
    }
    return string;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */