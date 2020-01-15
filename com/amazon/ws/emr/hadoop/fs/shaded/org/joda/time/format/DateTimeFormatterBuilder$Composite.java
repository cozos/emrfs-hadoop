package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class DateTimeFormatterBuilder$Composite
  implements InternalPrinter, InternalParser
{
  private final InternalPrinter[] iPrinters;
  private final InternalParser[] iParsers;
  private final int iPrintedLengthEstimate;
  private final int iParsedLengthEstimate;
  
  DateTimeFormatterBuilder$Composite(List<Object> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    
    decompose(paramList, localArrayList1, localArrayList2);
    int i;
    int j;
    int k;
    Object localObject;
    if ((localArrayList1.contains(null)) || (localArrayList1.isEmpty()))
    {
      iPrinters = null;
      iPrintedLengthEstimate = 0;
    }
    else
    {
      i = localArrayList1.size();
      iPrinters = new InternalPrinter[i];
      j = 0;
      for (k = 0; k < i; k++)
      {
        localObject = (InternalPrinter)localArrayList1.get(k);
        j += ((InternalPrinter)localObject).estimatePrintedLength();
        iPrinters[k] = localObject;
      }
      iPrintedLengthEstimate = j;
    }
    if ((localArrayList2.contains(null)) || (localArrayList2.isEmpty()))
    {
      iParsers = null;
      iParsedLengthEstimate = 0;
    }
    else
    {
      i = localArrayList2.size();
      iParsers = new InternalParser[i];
      j = 0;
      for (k = 0; k < i; k++)
      {
        localObject = (InternalParser)localArrayList2.get(k);
        j += ((InternalParser)localObject).estimateParsedLength();
        iParsers[k] = localObject;
      }
      iParsedLengthEstimate = j;
    }
  }
  
  public int estimatePrintedLength()
  {
    return iPrintedLengthEstimate;
  }
  
  public void printTo(Appendable paramAppendable, long paramLong, Chronology paramChronology, int paramInt, DateTimeZone paramDateTimeZone, Locale paramLocale)
    throws IOException
  {
    InternalPrinter[] arrayOfInternalPrinter = iPrinters;
    if (arrayOfInternalPrinter == null) {
      throw new UnsupportedOperationException();
    }
    if (paramLocale == null) {
      paramLocale = Locale.getDefault();
    }
    int i = arrayOfInternalPrinter.length;
    for (int j = 0; j < i; j++) {
      arrayOfInternalPrinter[j].printTo(paramAppendable, paramLong, paramChronology, paramInt, paramDateTimeZone, paramLocale);
    }
  }
  
  public void printTo(Appendable paramAppendable, ReadablePartial paramReadablePartial, Locale paramLocale)
    throws IOException
  {
    InternalPrinter[] arrayOfInternalPrinter = iPrinters;
    if (arrayOfInternalPrinter == null) {
      throw new UnsupportedOperationException();
    }
    if (paramLocale == null) {
      paramLocale = Locale.getDefault();
    }
    int i = arrayOfInternalPrinter.length;
    for (int j = 0; j < i; j++) {
      arrayOfInternalPrinter[j].printTo(paramAppendable, paramReadablePartial, paramLocale);
    }
  }
  
  public int estimateParsedLength()
  {
    return iParsedLengthEstimate;
  }
  
  public int parseInto(DateTimeParserBucket paramDateTimeParserBucket, CharSequence paramCharSequence, int paramInt)
  {
    InternalParser[] arrayOfInternalParser = iParsers;
    if (arrayOfInternalParser == null) {
      throw new UnsupportedOperationException();
    }
    int i = arrayOfInternalParser.length;
    for (int j = 0; (j < i) && (paramInt >= 0); j++) {
      paramInt = arrayOfInternalParser[j].parseInto(paramDateTimeParserBucket, paramCharSequence, paramInt);
    }
    return paramInt;
  }
  
  boolean isPrinter()
  {
    return iPrinters != null;
  }
  
  boolean isParser()
  {
    return iParsers != null;
  }
  
  private void decompose(List<Object> paramList1, List<Object> paramList2, List<Object> paramList3)
  {
    int i = paramList1.size();
    for (int j = 0; j < i; j += 2)
    {
      Object localObject = paramList1.get(j);
      if ((localObject instanceof Composite)) {
        addArrayToList(paramList2, iPrinters);
      } else {
        paramList2.add(localObject);
      }
      localObject = paramList1.get(j + 1);
      if ((localObject instanceof Composite)) {
        addArrayToList(paramList3, iParsers);
      } else {
        paramList3.add(localObject);
      }
    }
  }
  
  private void addArrayToList(List<Object> paramList, Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject != null) {
      for (int i = 0; i < paramArrayOfObject.length; i++) {
        paramList.add(paramArrayOfObject[i]);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatterBuilder.Composite
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */