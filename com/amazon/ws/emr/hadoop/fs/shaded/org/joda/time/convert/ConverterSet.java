package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert;

class ConverterSet
{
  private final Converter[] iConverters;
  private Entry[] iSelectEntries;
  
  ConverterSet(Converter[] paramArrayOfConverter)
  {
    iConverters = paramArrayOfConverter;
    iSelectEntries = new Entry[16];
  }
  
  Converter select(Class<?> paramClass)
    throws IllegalStateException
  {
    Entry[] arrayOfEntry1 = iSelectEntries;
    int i = arrayOfEntry1.length;
    int j = paramClass == null ? 0 : paramClass.hashCode() & i - 1;
    while ((localEntry = arrayOfEntry1[j]) != null)
    {
      if (iType == paramClass) {
        return iConverter;
      }
      j++;
      if (j >= i) {
        j = 0;
      }
    }
    Converter localConverter = selectSlow(this, paramClass);
    Entry localEntry = new Entry(paramClass, localConverter);
    
    arrayOfEntry1 = (Entry[])arrayOfEntry1.clone();
    
    arrayOfEntry1[j] = localEntry;
    for (int k = 0; k < i; k++) {
      if (arrayOfEntry1[k] == null)
      {
        iSelectEntries = arrayOfEntry1;
        return localConverter;
      }
    }
    k = i << 1;
    Entry[] arrayOfEntry2 = new Entry[k];
    for (int m = 0; m < i; m++)
    {
      localEntry = arrayOfEntry1[m];
      paramClass = iType;
      j = paramClass == null ? 0 : paramClass.hashCode() & k - 1;
      while (arrayOfEntry2[j] != null)
      {
        j++;
        if (j >= k) {
          j = 0;
        }
      }
      arrayOfEntry2[j] = localEntry;
    }
    iSelectEntries = arrayOfEntry2;
    return localConverter;
  }
  
  int size()
  {
    return iConverters.length;
  }
  
  void copyInto(Converter[] paramArrayOfConverter)
  {
    System.arraycopy(iConverters, 0, paramArrayOfConverter, 0, iConverters.length);
  }
  
  ConverterSet add(Converter paramConverter, Converter[] paramArrayOfConverter)
  {
    Converter[] arrayOfConverter1 = iConverters;
    int i = arrayOfConverter1.length;
    for (int j = 0; j < i; j++)
    {
      Converter localConverter = arrayOfConverter1[j];
      if (paramConverter.equals(localConverter))
      {
        if (paramArrayOfConverter != null) {
          paramArrayOfConverter[0] = null;
        }
        return this;
      }
      if (paramConverter.getSupportedType() == localConverter.getSupportedType())
      {
        Converter[] arrayOfConverter3 = new Converter[i];
        for (int k = 0; k < i; k++) {
          if (k != j) {
            arrayOfConverter3[k] = arrayOfConverter1[k];
          } else {
            arrayOfConverter3[k] = paramConverter;
          }
        }
        if (paramArrayOfConverter != null) {
          paramArrayOfConverter[0] = localConverter;
        }
        return new ConverterSet(arrayOfConverter3);
      }
    }
    Converter[] arrayOfConverter2 = new Converter[i + 1];
    System.arraycopy(arrayOfConverter1, 0, arrayOfConverter2, 0, i);
    arrayOfConverter2[i] = paramConverter;
    if (paramArrayOfConverter != null) {
      paramArrayOfConverter[0] = null;
    }
    return new ConverterSet(arrayOfConverter2);
  }
  
  ConverterSet remove(Converter paramConverter, Converter[] paramArrayOfConverter)
  {
    Converter[] arrayOfConverter = iConverters;
    int i = arrayOfConverter.length;
    for (int j = 0; j < i; j++) {
      if (paramConverter.equals(arrayOfConverter[j])) {
        return remove(j, paramArrayOfConverter);
      }
    }
    if (paramArrayOfConverter != null) {
      paramArrayOfConverter[0] = null;
    }
    return this;
  }
  
  ConverterSet remove(int paramInt, Converter[] paramArrayOfConverter)
  {
    Converter[] arrayOfConverter1 = iConverters;
    int i = arrayOfConverter1.length;
    if (paramInt >= i) {
      throw new IndexOutOfBoundsException();
    }
    if (paramArrayOfConverter != null) {
      paramArrayOfConverter[0] = arrayOfConverter1[paramInt];
    }
    Converter[] arrayOfConverter2 = new Converter[i - 1];
    
    int j = 0;
    for (int k = 0; k < i; k++) {
      if (k != paramInt) {
        arrayOfConverter2[(j++)] = arrayOfConverter1[k];
      }
    }
    return new ConverterSet(arrayOfConverter2);
  }
  
  private static Converter selectSlow(ConverterSet paramConverterSet, Class<?> paramClass)
  {
    Converter[] arrayOfConverter = iConverters;
    int i = arrayOfConverter.length;
    
    int j = i;
    Converter localConverter;
    Class localClass1;
    for (;;)
    {
      j--;
      if (j < 0) {
        break;
      }
      localConverter = arrayOfConverter[j];
      localClass1 = localConverter.getSupportedType();
      if (localClass1 == paramClass) {
        return localConverter;
      }
      if ((localClass1 == null) || ((paramClass != null) && (!localClass1.isAssignableFrom(paramClass))))
      {
        paramConverterSet = paramConverterSet.remove(j, null);
        arrayOfConverter = iConverters;
        i = arrayOfConverter.length;
      }
    }
    if ((paramClass == null) || (i == 0)) {
      return null;
    }
    if (i == 1) {
      return arrayOfConverter[0];
    }
    j = i;
    for (;;)
    {
      j--;
      if (j < 0) {
        break;
      }
      localConverter = arrayOfConverter[j];
      localClass1 = localConverter.getSupportedType();
      int m = i;
      for (;;)
      {
        m--;
        if (m < 0) {
          break;
        }
        if ((m != j) && (arrayOfConverter[m].getSupportedType().isAssignableFrom(localClass1)))
        {
          paramConverterSet = paramConverterSet.remove(m, null);
          arrayOfConverter = iConverters;
          i = arrayOfConverter.length;
          j = i - 1;
        }
      }
    }
    if (i == 1) {
      return arrayOfConverter[0];
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unable to find best converter for type \"");
    localStringBuilder.append(paramClass.getName());
    localStringBuilder.append("\" from remaining set: ");
    for (int k = 0; k < i; k++)
    {
      localConverter = arrayOfConverter[k];
      Class localClass2 = localConverter.getSupportedType();
      
      localStringBuilder.append(localConverter.getClass().getName());
      localStringBuilder.append('[');
      localStringBuilder.append(localClass2 == null ? null : localClass2.getName());
      localStringBuilder.append("], ");
    }
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  static class Entry
  {
    final Class<?> iType;
    final Converter iConverter;
    
    Entry(Class<?> paramClass, Converter paramConverter)
    {
      iType = paramClass;
      iConverter = paramConverter;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert.ConverterSet
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */