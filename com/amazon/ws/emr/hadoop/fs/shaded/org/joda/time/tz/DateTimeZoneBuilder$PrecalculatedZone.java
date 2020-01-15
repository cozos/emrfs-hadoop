package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Period;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.PeriodType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.ISOChronology;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

final class DateTimeZoneBuilder$PrecalculatedZone
  extends DateTimeZone
{
  private static final long serialVersionUID = 7811976468055766265L;
  private final long[] iTransitions;
  private final int[] iWallOffsets;
  private final int[] iStandardOffsets;
  private final String[] iNameKeys;
  private final DateTimeZoneBuilder.DSTZone iTailZone;
  
  static PrecalculatedZone readFrom(DataInput paramDataInput, String paramString)
    throws IOException
  {
    int i = paramDataInput.readUnsignedShort();
    String[] arrayOfString1 = new String[i];
    for (int j = 0; j < i; j++) {
      arrayOfString1[j] = paramDataInput.readUTF();
    }
    j = paramDataInput.readInt();
    long[] arrayOfLong = new long[j];
    int[] arrayOfInt1 = new int[j];
    int[] arrayOfInt2 = new int[j];
    String[] arrayOfString2 = new String[j];
    for (int k = 0; k < j; k++)
    {
      arrayOfLong[k] = DateTimeZoneBuilder.readMillis(paramDataInput);
      arrayOfInt1[k] = ((int)DateTimeZoneBuilder.readMillis(paramDataInput));
      arrayOfInt2[k] = ((int)DateTimeZoneBuilder.readMillis(paramDataInput));
      try
      {
        int m;
        if (i < 256) {
          m = paramDataInput.readUnsignedByte();
        } else {
          m = paramDataInput.readUnsignedShort();
        }
        arrayOfString2[k] = arrayOfString1[m];
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        throw new IOException("Invalid encoding");
      }
    }
    DateTimeZoneBuilder.DSTZone localDSTZone = null;
    if (paramDataInput.readBoolean()) {
      localDSTZone = DateTimeZoneBuilder.DSTZone.readFrom(paramDataInput, paramString);
    }
    return new PrecalculatedZone(paramString, arrayOfLong, arrayOfInt1, arrayOfInt2, arrayOfString2, localDSTZone);
  }
  
  static PrecalculatedZone create(String paramString, boolean paramBoolean, ArrayList<DateTimeZoneBuilder.Transition> paramArrayList, DateTimeZoneBuilder.DSTZone paramDSTZone)
  {
    int i = paramArrayList.size();
    if (i == 0) {
      throw new IllegalArgumentException();
    }
    long[] arrayOfLong = new long[i];
    int[] arrayOfInt1 = new int[i];
    int[] arrayOfInt2 = new int[i];
    String[] arrayOfString = new String[i];
    
    Object localObject1 = null;
    for (int j = 0; j < i; j++)
    {
      localObject3 = (DateTimeZoneBuilder.Transition)paramArrayList.get(j);
      if (!((DateTimeZoneBuilder.Transition)localObject3).isTransitionFrom((DateTimeZoneBuilder.Transition)localObject1)) {
        throw new IllegalArgumentException(paramString);
      }
      arrayOfLong[j] = ((DateTimeZoneBuilder.Transition)localObject3).getMillis();
      arrayOfInt1[j] = ((DateTimeZoneBuilder.Transition)localObject3).getWallOffset();
      arrayOfInt2[j] = ((DateTimeZoneBuilder.Transition)localObject3).getStandardOffset();
      arrayOfString[j] = ((DateTimeZoneBuilder.Transition)localObject3).getNameKey();
      
      localObject1 = localObject3;
    }
    Object localObject2 = new String[5];
    Object localObject3 = new DateFormatSymbols(Locale.ENGLISH).getZoneStrings();
    for (int k = 0; k < localObject3.length; k++)
    {
      Object localObject4 = localObject3[k];
      if ((localObject4 != null) && (localObject4.length == 5) && (paramString.equals(localObject4[0]))) {
        localObject2 = localObject4;
      }
    }
    ISOChronology localISOChronology = ISOChronology.getInstanceUTC();
    for (int m = 0; m < arrayOfString.length - 1; m++)
    {
      String str1 = arrayOfString[m];
      String str2 = arrayOfString[(m + 1)];
      long l1 = arrayOfInt1[m];
      long l2 = arrayOfInt1[(m + 1)];
      long l3 = arrayOfInt2[m];
      long l4 = arrayOfInt2[(m + 1)];
      Period localPeriod = new Period(arrayOfLong[m], arrayOfLong[(m + 1)], PeriodType.yearMonthDay(), localISOChronology);
      if ((l1 != l2) && (l3 == l4) && (str1.equals(str2)) && (localPeriod.getYears() == 0) && (localPeriod.getMonths() > 4) && (localPeriod.getMonths() < 8) && (str1.equals(localObject2[2])) && (str1.equals(localObject2[4])))
      {
        if (ZoneInfoLogger.verbose())
        {
          System.out.println("Fixing duplicate name key - " + str2);
          System.out.println("     - " + new DateTime(arrayOfLong[m], localISOChronology) + " - " + new DateTime(arrayOfLong[(m + 1)], localISOChronology));
        }
        if (l1 > l2)
        {
          arrayOfString[m] = (str1 + "-Summer").intern();
        }
        else if (l1 < l2)
        {
          arrayOfString[(m + 1)] = (str2 + "-Summer").intern();
          m++;
        }
      }
    }
    if ((paramDSTZone != null) && 
      (iStartRecurrence.getNameKey().equals(iEndRecurrence.getNameKey())))
    {
      if (ZoneInfoLogger.verbose()) {
        System.out.println("Fixing duplicate recurrent name key - " + iStartRecurrence.getNameKey());
      }
      if (iStartRecurrence.getSaveMillis() > 0) {
        paramDSTZone = new DateTimeZoneBuilder.DSTZone(paramDSTZone.getID(), iStandardOffset, iStartRecurrence.renameAppend("-Summer"), iEndRecurrence);
      } else {
        paramDSTZone = new DateTimeZoneBuilder.DSTZone(paramDSTZone.getID(), iStandardOffset, iStartRecurrence, iEndRecurrence.renameAppend("-Summer"));
      }
    }
    return new PrecalculatedZone(paramBoolean ? paramString : "", arrayOfLong, arrayOfInt1, arrayOfInt2, arrayOfString, paramDSTZone);
  }
  
  private DateTimeZoneBuilder$PrecalculatedZone(String paramString, long[] paramArrayOfLong, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String[] paramArrayOfString, DateTimeZoneBuilder.DSTZone paramDSTZone)
  {
    super(paramString);
    iTransitions = paramArrayOfLong;
    iWallOffsets = paramArrayOfInt1;
    iStandardOffsets = paramArrayOfInt2;
    iNameKeys = paramArrayOfString;
    iTailZone = paramDSTZone;
  }
  
  public String getNameKey(long paramLong)
  {
    long[] arrayOfLong = iTransitions;
    int i = Arrays.binarySearch(arrayOfLong, paramLong);
    if (i >= 0) {
      return iNameKeys[i];
    }
    i ^= 0xFFFFFFFF;
    if (i < arrayOfLong.length)
    {
      if (i > 0) {
        return iNameKeys[(i - 1)];
      }
      return "UTC";
    }
    if (iTailZone == null) {
      return iNameKeys[(i - 1)];
    }
    return iTailZone.getNameKey(paramLong);
  }
  
  public int getOffset(long paramLong)
  {
    long[] arrayOfLong = iTransitions;
    int i = Arrays.binarySearch(arrayOfLong, paramLong);
    if (i >= 0) {
      return iWallOffsets[i];
    }
    i ^= 0xFFFFFFFF;
    if (i < arrayOfLong.length)
    {
      if (i > 0) {
        return iWallOffsets[(i - 1)];
      }
      return 0;
    }
    if (iTailZone == null) {
      return iWallOffsets[(i - 1)];
    }
    return iTailZone.getOffset(paramLong);
  }
  
  public int getStandardOffset(long paramLong)
  {
    long[] arrayOfLong = iTransitions;
    int i = Arrays.binarySearch(arrayOfLong, paramLong);
    if (i >= 0) {
      return iStandardOffsets[i];
    }
    i ^= 0xFFFFFFFF;
    if (i < arrayOfLong.length)
    {
      if (i > 0) {
        return iStandardOffsets[(i - 1)];
      }
      return 0;
    }
    if (iTailZone == null) {
      return iStandardOffsets[(i - 1)];
    }
    return iTailZone.getStandardOffset(paramLong);
  }
  
  public boolean isFixed()
  {
    return false;
  }
  
  public long nextTransition(long paramLong)
  {
    long[] arrayOfLong = iTransitions;
    int i = Arrays.binarySearch(arrayOfLong, paramLong);
    i = i >= 0 ? i + 1 : i ^ 0xFFFFFFFF;
    if (i < arrayOfLong.length) {
      return arrayOfLong[i];
    }
    if (iTailZone == null) {
      return paramLong;
    }
    long l = arrayOfLong[(arrayOfLong.length - 1)];
    if (paramLong < l) {
      paramLong = l;
    }
    return iTailZone.nextTransition(paramLong);
  }
  
  public long previousTransition(long paramLong)
  {
    long[] arrayOfLong = iTransitions;
    int i = Arrays.binarySearch(arrayOfLong, paramLong);
    if (i >= 0)
    {
      if (paramLong > Long.MIN_VALUE) {
        return paramLong - 1L;
      }
      return paramLong;
    }
    i ^= 0xFFFFFFFF;
    if (i < arrayOfLong.length)
    {
      if (i > 0)
      {
        l = arrayOfLong[(i - 1)];
        if (l > Long.MIN_VALUE) {
          return l - 1L;
        }
      }
      return paramLong;
    }
    if (iTailZone != null)
    {
      l = iTailZone.previousTransition(paramLong);
      if (l < paramLong) {
        return l;
      }
    }
    long l = arrayOfLong[(i - 1)];
    if (l > Long.MIN_VALUE) {
      return l - 1L;
    }
    return paramLong;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof PrecalculatedZone))
    {
      PrecalculatedZone localPrecalculatedZone = (PrecalculatedZone)paramObject;
      return (getID().equals(localPrecalculatedZone.getID())) && (Arrays.equals(iTransitions, iTransitions)) && (Arrays.equals(iNameKeys, iNameKeys)) && (Arrays.equals(iWallOffsets, iWallOffsets)) && (Arrays.equals(iStandardOffsets, iStandardOffsets)) && (iTailZone == null ? null == iTailZone : iTailZone.equals(iTailZone));
    }
    return false;
  }
  
  public void writeTo(DataOutput paramDataOutput)
    throws IOException
  {
    int i = iTransitions.length;
    
    HashSet localHashSet = new HashSet();
    for (int j = 0; j < i; j++) {
      localHashSet.add(iNameKeys[j]);
    }
    j = localHashSet.size();
    if (j > 65535) {
      throw new UnsupportedOperationException("String pool is too large");
    }
    String[] arrayOfString = new String[j];
    Iterator localIterator = localHashSet.iterator();
    for (int k = 0; localIterator.hasNext(); k++) {
      arrayOfString[k] = ((String)localIterator.next());
    }
    paramDataOutput.writeShort(j);
    for (k = 0; k < j; k++) {
      paramDataOutput.writeUTF(arrayOfString[k]);
    }
    paramDataOutput.writeInt(i);
    for (k = 0; k < i; k++)
    {
      DateTimeZoneBuilder.writeMillis(paramDataOutput, iTransitions[k]);
      DateTimeZoneBuilder.writeMillis(paramDataOutput, iWallOffsets[k]);
      DateTimeZoneBuilder.writeMillis(paramDataOutput, iStandardOffsets[k]);
      
      String str = iNameKeys[k];
      for (int m = 0; m < j; m++) {
        if (arrayOfString[m].equals(str))
        {
          if (j < 256)
          {
            paramDataOutput.writeByte(m); break;
          }
          paramDataOutput.writeShort(m);
          
          break;
        }
      }
    }
    paramDataOutput.writeBoolean(iTailZone != null);
    if (iTailZone != null) {
      iTailZone.writeTo(paramDataOutput);
    }
  }
  
  public boolean isCachable()
  {
    if (iTailZone != null) {
      return true;
    }
    long[] arrayOfLong = iTransitions;
    if (arrayOfLong.length <= 1) {
      return false;
    }
    double d1 = 0.0D;
    int i = 0;
    for (int j = 1; j < arrayOfLong.length; j++)
    {
      long l = arrayOfLong[j] - arrayOfLong[(j - 1)];
      if (l < 63158400000L)
      {
        d1 += l;
        i++;
      }
    }
    if (i > 0)
    {
      double d2 = d1 / i;
      d2 /= 8.64E7D;
      if (d2 >= 25.0D) {
        return true;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz.DateTimeZoneBuilder.PrecalculatedZone
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */