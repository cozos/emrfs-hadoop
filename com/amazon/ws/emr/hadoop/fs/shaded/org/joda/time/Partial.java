package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base.AbstractPartial;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.AbstractPartialFieldProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.FieldUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormat;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.ISODateTimeFormat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public final class Partial
  extends AbstractPartial
  implements ReadablePartial, Serializable
{
  private static final long serialVersionUID = 12324121189002L;
  private final Chronology iChronology;
  private final DateTimeFieldType[] iTypes;
  private final int[] iValues;
  private transient DateTimeFormatter[] iFormatter;
  
  public Partial()
  {
    this((Chronology)null);
  }
  
  public Partial(Chronology paramChronology)
  {
    iChronology = DateTimeUtils.getChronology(paramChronology).withUTC();
    iTypes = new DateTimeFieldType[0];
    iValues = new int[0];
  }
  
  public Partial(DateTimeFieldType paramDateTimeFieldType, int paramInt)
  {
    this(paramDateTimeFieldType, paramInt, null);
  }
  
  public Partial(DateTimeFieldType paramDateTimeFieldType, int paramInt, Chronology paramChronology)
  {
    paramChronology = DateTimeUtils.getChronology(paramChronology).withUTC();
    iChronology = paramChronology;
    if (paramDateTimeFieldType == null) {
      throw new IllegalArgumentException("The field type must not be null");
    }
    iTypes = new DateTimeFieldType[] { paramDateTimeFieldType };
    iValues = new int[] { paramInt };
    paramChronology.validate(this, iValues);
  }
  
  public Partial(DateTimeFieldType[] paramArrayOfDateTimeFieldType, int[] paramArrayOfInt)
  {
    this(paramArrayOfDateTimeFieldType, paramArrayOfInt, null);
  }
  
  public Partial(DateTimeFieldType[] paramArrayOfDateTimeFieldType, int[] paramArrayOfInt, Chronology paramChronology)
  {
    paramChronology = DateTimeUtils.getChronology(paramChronology).withUTC();
    iChronology = paramChronology;
    if (paramArrayOfDateTimeFieldType == null) {
      throw new IllegalArgumentException("Types array must not be null");
    }
    if (paramArrayOfInt == null) {
      throw new IllegalArgumentException("Values array must not be null");
    }
    if (paramArrayOfInt.length != paramArrayOfDateTimeFieldType.length) {
      throw new IllegalArgumentException("Values array must be the same length as the types array");
    }
    if (paramArrayOfDateTimeFieldType.length == 0)
    {
      iTypes = paramArrayOfDateTimeFieldType;
      iValues = paramArrayOfInt;
      return;
    }
    for (int i = 0; i < paramArrayOfDateTimeFieldType.length; i++) {
      if (paramArrayOfDateTimeFieldType[i] == null) {
        throw new IllegalArgumentException("Types array must not contain null: index " + i);
      }
    }
    Object localObject = null;
    for (int j = 0; j < paramArrayOfDateTimeFieldType.length; j++)
    {
      DateTimeFieldType localDateTimeFieldType = paramArrayOfDateTimeFieldType[j];
      DurationField localDurationField1 = localDateTimeFieldType.getDurationType().getField(iChronology);
      if (j > 0)
      {
        if (!localDurationField1.isSupported())
        {
          if (((DurationField)localObject).isSupported()) {
            throw new IllegalArgumentException("Types array must be in order largest-smallest: " + paramArrayOfDateTimeFieldType[(j - 1)].getName() + " < " + localDateTimeFieldType.getName());
          }
          throw new IllegalArgumentException("Types array must not contain duplicate unsupported: " + paramArrayOfDateTimeFieldType[(j - 1)].getName() + " and " + localDateTimeFieldType.getName());
        }
        int k = ((DurationField)localObject).compareTo(localDurationField1);
        if (k < 0) {
          throw new IllegalArgumentException("Types array must be in order largest-smallest: " + paramArrayOfDateTimeFieldType[(j - 1)].getName() + " < " + localDateTimeFieldType.getName());
        }
        if (k == 0) {
          if (localObject.equals(localDurationField1))
          {
            DurationFieldType localDurationFieldType1 = paramArrayOfDateTimeFieldType[(j - 1)].getRangeDurationType();
            DurationFieldType localDurationFieldType2 = localDateTimeFieldType.getRangeDurationType();
            if (localDurationFieldType1 == null)
            {
              if (localDurationFieldType2 == null) {
                throw new IllegalArgumentException("Types array must not contain duplicate: " + paramArrayOfDateTimeFieldType[(j - 1)].getName() + " and " + localDateTimeFieldType.getName());
              }
            }
            else
            {
              if (localDurationFieldType2 == null) {
                throw new IllegalArgumentException("Types array must be in order largest-smallest: " + paramArrayOfDateTimeFieldType[(j - 1)].getName() + " < " + localDateTimeFieldType.getName());
              }
              DurationField localDurationField2 = localDurationFieldType1.getField(iChronology);
              DurationField localDurationField3 = localDurationFieldType2.getField(iChronology);
              if (localDurationField2.compareTo(localDurationField3) < 0) {
                throw new IllegalArgumentException("Types array must be in order largest-smallest: " + paramArrayOfDateTimeFieldType[(j - 1)].getName() + " < " + localDateTimeFieldType.getName());
              }
              if (localDurationField2.compareTo(localDurationField3) == 0) {
                throw new IllegalArgumentException("Types array must not contain duplicate: " + paramArrayOfDateTimeFieldType[(j - 1)].getName() + " and " + localDateTimeFieldType.getName());
              }
            }
          }
          else if ((((DurationField)localObject).isSupported()) && (((DurationField)localObject).getType() != DurationFieldType.YEARS_TYPE))
          {
            throw new IllegalArgumentException("Types array must be in order largest-smallest, for year-based fields, years is defined as being largest: " + paramArrayOfDateTimeFieldType[(j - 1)].getName() + " < " + localDateTimeFieldType.getName());
          }
        }
      }
      localObject = localDurationField1;
    }
    iTypes = ((DateTimeFieldType[])paramArrayOfDateTimeFieldType.clone());
    paramChronology.validate(this, paramArrayOfInt);
    iValues = ((int[])paramArrayOfInt.clone());
  }
  
  public Partial(ReadablePartial paramReadablePartial)
  {
    if (paramReadablePartial == null) {
      throw new IllegalArgumentException("The partial must not be null");
    }
    iChronology = DateTimeUtils.getChronology(paramReadablePartial.getChronology()).withUTC();
    iTypes = new DateTimeFieldType[paramReadablePartial.size()];
    iValues = new int[paramReadablePartial.size()];
    for (int i = 0; i < paramReadablePartial.size(); i++)
    {
      iTypes[i] = paramReadablePartial.getFieldType(i);
      iValues[i] = paramReadablePartial.getValue(i);
    }
  }
  
  Partial(Partial paramPartial, int[] paramArrayOfInt)
  {
    iChronology = iChronology;
    iTypes = iTypes;
    iValues = paramArrayOfInt;
  }
  
  Partial(Chronology paramChronology, DateTimeFieldType[] paramArrayOfDateTimeFieldType, int[] paramArrayOfInt)
  {
    iChronology = paramChronology;
    iTypes = paramArrayOfDateTimeFieldType;
    iValues = paramArrayOfInt;
  }
  
  public int size()
  {
    return iTypes.length;
  }
  
  public Chronology getChronology()
  {
    return iChronology;
  }
  
  protected DateTimeField getField(int paramInt, Chronology paramChronology)
  {
    return iTypes[paramInt].getField(paramChronology);
  }
  
  public DateTimeFieldType getFieldType(int paramInt)
  {
    return iTypes[paramInt];
  }
  
  public DateTimeFieldType[] getFieldTypes()
  {
    return (DateTimeFieldType[])iTypes.clone();
  }
  
  public int getValue(int paramInt)
  {
    return iValues[paramInt];
  }
  
  public int[] getValues()
  {
    return (int[])iValues.clone();
  }
  
  public Partial withChronologyRetainFields(Chronology paramChronology)
  {
    paramChronology = DateTimeUtils.getChronology(paramChronology);
    paramChronology = paramChronology.withUTC();
    if (paramChronology == getChronology()) {
      return this;
    }
    Partial localPartial = new Partial(paramChronology, iTypes, iValues);
    paramChronology.validate(localPartial, iValues);
    return localPartial;
  }
  
  public Partial with(DateTimeFieldType paramDateTimeFieldType, int paramInt)
  {
    if (paramDateTimeFieldType == null) {
      throw new IllegalArgumentException("The field type must not be null");
    }
    int i = indexOf(paramDateTimeFieldType);
    if (i == -1)
    {
      localObject1 = new DateTimeFieldType[iTypes.length + 1];
      int[] arrayOfInt = new int[localObject1.length];
      
      int j = 0;
      DurationField localDurationField1 = paramDateTimeFieldType.getDurationType().getField(iChronology);
      if (localDurationField1.isSupported()) {
        for (; j < iTypes.length; j++)
        {
          localObject2 = iTypes[j];
          DurationField localDurationField2 = ((DateTimeFieldType)localObject2).getDurationType().getField(iChronology);
          if (localDurationField2.isSupported())
          {
            int k = localDurationField1.compareTo(localDurationField2);
            if (k > 0) {
              break;
            }
            if (k == 0)
            {
              if (paramDateTimeFieldType.getRangeDurationType() == null) {
                break;
              }
              if (((DateTimeFieldType)localObject2).getRangeDurationType() != null)
              {
                DurationField localDurationField3 = paramDateTimeFieldType.getRangeDurationType().getField(iChronology);
                DurationField localDurationField4 = ((DateTimeFieldType)localObject2).getRangeDurationType().getField(iChronology);
                if (localDurationField3.compareTo(localDurationField4) > 0) {
                  break;
                }
              }
            }
          }
        }
      }
      System.arraycopy(iTypes, 0, localObject1, 0, j);
      System.arraycopy(iValues, 0, arrayOfInt, 0, j);
      localObject1[j] = paramDateTimeFieldType;
      arrayOfInt[j] = paramInt;
      System.arraycopy(iTypes, j, localObject1, j + 1, localObject1.length - j - 1);
      System.arraycopy(iValues, j, arrayOfInt, j + 1, arrayOfInt.length - j - 1);
      
      Object localObject2 = new Partial((DateTimeFieldType[])localObject1, arrayOfInt, iChronology);
      iChronology.validate((ReadablePartial)localObject2, arrayOfInt);
      return (Partial)localObject2;
    }
    if (paramInt == getValue(i)) {
      return this;
    }
    Object localObject1 = getValues();
    localObject1 = getField(i).set(this, i, (int[])localObject1, paramInt);
    return new Partial(this, (int[])localObject1);
  }
  
  public Partial without(DateTimeFieldType paramDateTimeFieldType)
  {
    int i = indexOf(paramDateTimeFieldType);
    if (i != -1)
    {
      DateTimeFieldType[] arrayOfDateTimeFieldType = new DateTimeFieldType[size() - 1];
      int[] arrayOfInt = new int[size() - 1];
      System.arraycopy(iTypes, 0, arrayOfDateTimeFieldType, 0, i);
      System.arraycopy(iTypes, i + 1, arrayOfDateTimeFieldType, i, arrayOfDateTimeFieldType.length - i);
      System.arraycopy(iValues, 0, arrayOfInt, 0, i);
      System.arraycopy(iValues, i + 1, arrayOfInt, i, arrayOfInt.length - i);
      Partial localPartial = new Partial(iChronology, arrayOfDateTimeFieldType, arrayOfInt);
      iChronology.validate(localPartial, arrayOfInt);
      return localPartial;
    }
    return this;
  }
  
  public Partial withField(DateTimeFieldType paramDateTimeFieldType, int paramInt)
  {
    int i = indexOfSupported(paramDateTimeFieldType);
    if (paramInt == getValue(i)) {
      return this;
    }
    int[] arrayOfInt = getValues();
    arrayOfInt = getField(i).set(this, i, arrayOfInt, paramInt);
    return new Partial(this, arrayOfInt);
  }
  
  public Partial withFieldAdded(DurationFieldType paramDurationFieldType, int paramInt)
  {
    int i = indexOfSupported(paramDurationFieldType);
    if (paramInt == 0) {
      return this;
    }
    int[] arrayOfInt = getValues();
    arrayOfInt = getField(i).add(this, i, arrayOfInt, paramInt);
    return new Partial(this, arrayOfInt);
  }
  
  public Partial withFieldAddWrapped(DurationFieldType paramDurationFieldType, int paramInt)
  {
    int i = indexOfSupported(paramDurationFieldType);
    if (paramInt == 0) {
      return this;
    }
    int[] arrayOfInt = getValues();
    arrayOfInt = getField(i).addWrapPartial(this, i, arrayOfInt, paramInt);
    return new Partial(this, arrayOfInt);
  }
  
  public Partial withPeriodAdded(ReadablePeriod paramReadablePeriod, int paramInt)
  {
    if ((paramReadablePeriod == null) || (paramInt == 0)) {
      return this;
    }
    int[] arrayOfInt = getValues();
    for (int i = 0; i < paramReadablePeriod.size(); i++)
    {
      DurationFieldType localDurationFieldType = paramReadablePeriod.getFieldType(i);
      int j = indexOf(localDurationFieldType);
      if (j >= 0) {
        arrayOfInt = getField(j).add(this, j, arrayOfInt, FieldUtils.safeMultiply(paramReadablePeriod.getValue(i), paramInt));
      }
    }
    return new Partial(this, arrayOfInt);
  }
  
  public Partial plus(ReadablePeriod paramReadablePeriod)
  {
    return withPeriodAdded(paramReadablePeriod, 1);
  }
  
  public Partial minus(ReadablePeriod paramReadablePeriod)
  {
    return withPeriodAdded(paramReadablePeriod, -1);
  }
  
  public Property property(DateTimeFieldType paramDateTimeFieldType)
  {
    return new Property(this, indexOfSupported(paramDateTimeFieldType));
  }
  
  public boolean isMatch(ReadableInstant paramReadableInstant)
  {
    long l = DateTimeUtils.getInstantMillis(paramReadableInstant);
    Chronology localChronology = DateTimeUtils.getInstantChronology(paramReadableInstant);
    for (int i = 0; i < iTypes.length; i++)
    {
      int j = iTypes[i].getField(localChronology).get(l);
      if (j != iValues[i]) {
        return false;
      }
    }
    return true;
  }
  
  public boolean isMatch(ReadablePartial paramReadablePartial)
  {
    if (paramReadablePartial == null) {
      throw new IllegalArgumentException("The partial must not be null");
    }
    for (int i = 0; i < iTypes.length; i++)
    {
      int j = paramReadablePartial.get(iTypes[i]);
      if (j != iValues[i]) {
        return false;
      }
    }
    return true;
  }
  
  public DateTimeFormatter getFormatter()
  {
    DateTimeFormatter[] arrayOfDateTimeFormatter = iFormatter;
    if (arrayOfDateTimeFormatter == null)
    {
      if (size() == 0) {
        return null;
      }
      arrayOfDateTimeFormatter = new DateTimeFormatter[2];
      try
      {
        ArrayList localArrayList = new ArrayList(Arrays.asList(iTypes));
        arrayOfDateTimeFormatter[0] = ISODateTimeFormat.forFields(localArrayList, true, false);
        if (localArrayList.size() == 0) {
          arrayOfDateTimeFormatter[1] = arrayOfDateTimeFormatter[0];
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException) {}
      iFormatter = arrayOfDateTimeFormatter;
    }
    return arrayOfDateTimeFormatter[0];
  }
  
  public String toString()
  {
    DateTimeFormatter[] arrayOfDateTimeFormatter = iFormatter;
    if (arrayOfDateTimeFormatter == null)
    {
      getFormatter();
      arrayOfDateTimeFormatter = iFormatter;
      if (arrayOfDateTimeFormatter == null) {
        return toStringList();
      }
    }
    DateTimeFormatter localDateTimeFormatter = arrayOfDateTimeFormatter[1];
    if (localDateTimeFormatter == null) {
      return toStringList();
    }
    return localDateTimeFormatter.print(this);
  }
  
  public String toStringList()
  {
    int i = size();
    StringBuilder localStringBuilder = new StringBuilder(20 * i);
    localStringBuilder.append('[');
    for (int j = 0; j < i; j++)
    {
      if (j > 0) {
        localStringBuilder.append(',').append(' ');
      }
      localStringBuilder.append(iTypes[j].getName());
      localStringBuilder.append('=');
      localStringBuilder.append(iValues[j]);
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public String toString(String paramString)
  {
    if (paramString == null) {
      return toString();
    }
    return DateTimeFormat.forPattern(paramString).print(this);
  }
  
  public String toString(String paramString, Locale paramLocale)
  {
    if (paramString == null) {
      return toString();
    }
    return DateTimeFormat.forPattern(paramString).withLocale(paramLocale).print(this);
  }
  
  public static class Property
    extends AbstractPartialFieldProperty
    implements Serializable
  {
    private static final long serialVersionUID = 53278362873888L;
    private final Partial iPartial;
    private final int iFieldIndex;
    
    Property(Partial paramPartial, int paramInt)
    {
      iPartial = paramPartial;
      iFieldIndex = paramInt;
    }
    
    public DateTimeField getField()
    {
      return iPartial.getField(iFieldIndex);
    }
    
    protected ReadablePartial getReadablePartial()
    {
      return iPartial;
    }
    
    public Partial getPartial()
    {
      return iPartial;
    }
    
    public int get()
    {
      return iPartial.getValue(iFieldIndex);
    }
    
    public Partial addToCopy(int paramInt)
    {
      int[] arrayOfInt = iPartial.getValues();
      arrayOfInt = getField().add(iPartial, iFieldIndex, arrayOfInt, paramInt);
      return new Partial(iPartial, arrayOfInt);
    }
    
    public Partial addWrapFieldToCopy(int paramInt)
    {
      int[] arrayOfInt = iPartial.getValues();
      arrayOfInt = getField().addWrapField(iPartial, iFieldIndex, arrayOfInt, paramInt);
      return new Partial(iPartial, arrayOfInt);
    }
    
    public Partial setCopy(int paramInt)
    {
      int[] arrayOfInt = iPartial.getValues();
      arrayOfInt = getField().set(iPartial, iFieldIndex, arrayOfInt, paramInt);
      return new Partial(iPartial, arrayOfInt);
    }
    
    public Partial setCopy(String paramString, Locale paramLocale)
    {
      int[] arrayOfInt = iPartial.getValues();
      arrayOfInt = getField().set(iPartial, iFieldIndex, arrayOfInt, paramString, paramLocale);
      return new Partial(iPartial, arrayOfInt);
    }
    
    public Partial setCopy(String paramString)
    {
      return setCopy(paramString, null);
    }
    
    public Partial withMaximumValue()
    {
      return setCopy(getMaximumValue());
    }
    
    public Partial withMinimumValue()
    {
      return setCopy(getMinimumValue());
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Partial
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */