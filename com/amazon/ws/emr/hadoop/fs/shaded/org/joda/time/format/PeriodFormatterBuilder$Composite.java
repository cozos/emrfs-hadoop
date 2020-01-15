package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadWritablePeriod;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePeriod;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class PeriodFormatterBuilder$Composite
  implements PeriodPrinter, PeriodParser
{
  private final PeriodPrinter[] iPrinters;
  private final PeriodParser[] iParsers;
  
  PeriodFormatterBuilder$Composite(List<Object> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    
    decompose(paramList, localArrayList1, localArrayList2);
    if (localArrayList1.size() <= 0) {
      iPrinters = null;
    } else {
      iPrinters = ((PeriodPrinter[])localArrayList1.toArray(new PeriodPrinter[localArrayList1.size()]));
    }
    if (localArrayList2.size() <= 0) {
      iParsers = null;
    } else {
      iParsers = ((PeriodParser[])localArrayList2.toArray(new PeriodParser[localArrayList2.size()]));
    }
  }
  
  public int countFieldsToPrint(ReadablePeriod paramReadablePeriod, int paramInt, Locale paramLocale)
  {
    int i = 0;
    PeriodPrinter[] arrayOfPeriodPrinter = iPrinters;
    for (int j = arrayOfPeriodPrinter.length; i < paramInt;)
    {
      j--;
      if (j < 0) {
        break;
      }
      i += arrayOfPeriodPrinter[j].countFieldsToPrint(paramReadablePeriod, Integer.MAX_VALUE, paramLocale);
    }
    return i;
  }
  
  public int calculatePrintedLength(ReadablePeriod paramReadablePeriod, Locale paramLocale)
  {
    int i = 0;
    PeriodPrinter[] arrayOfPeriodPrinter = iPrinters;
    int j = arrayOfPeriodPrinter.length;
    for (;;)
    {
      j--;
      if (j < 0) {
        break;
      }
      i += arrayOfPeriodPrinter[j].calculatePrintedLength(paramReadablePeriod, paramLocale);
    }
    return i;
  }
  
  public void printTo(StringBuffer paramStringBuffer, ReadablePeriod paramReadablePeriod, Locale paramLocale)
  {
    PeriodPrinter[] arrayOfPeriodPrinter = iPrinters;
    int i = arrayOfPeriodPrinter.length;
    for (int j = 0; j < i; j++) {
      arrayOfPeriodPrinter[j].printTo(paramStringBuffer, paramReadablePeriod, paramLocale);
    }
  }
  
  public void printTo(Writer paramWriter, ReadablePeriod paramReadablePeriod, Locale paramLocale)
    throws IOException
  {
    PeriodPrinter[] arrayOfPeriodPrinter = iPrinters;
    int i = arrayOfPeriodPrinter.length;
    for (int j = 0; j < i; j++) {
      arrayOfPeriodPrinter[j].printTo(paramWriter, paramReadablePeriod, paramLocale);
    }
  }
  
  public int parseInto(ReadWritablePeriod paramReadWritablePeriod, String paramString, int paramInt, Locale paramLocale)
  {
    PeriodParser[] arrayOfPeriodParser = iParsers;
    if (arrayOfPeriodParser == null) {
      throw new UnsupportedOperationException();
    }
    int i = arrayOfPeriodParser.length;
    for (int j = 0; (j < i) && (paramInt >= 0); j++) {
      paramInt = arrayOfPeriodParser[j].parseInto(paramReadWritablePeriod, paramString, paramInt, paramLocale);
    }
    return paramInt;
  }
  
  private void decompose(List<Object> paramList1, List<Object> paramList2, List<Object> paramList3)
  {
    int i = paramList1.size();
    for (int j = 0; j < i; j += 2)
    {
      Object localObject = paramList1.get(j);
      if ((localObject instanceof PeriodPrinter)) {
        if ((localObject instanceof Composite)) {
          addArrayToList(paramList2, iPrinters);
        } else {
          paramList2.add(localObject);
        }
      }
      localObject = paramList1.get(j + 1);
      if ((localObject instanceof PeriodParser)) {
        if ((localObject instanceof Composite)) {
          addArrayToList(paramList3, iParsers);
        } else {
          paramList3.add(localObject);
        }
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.PeriodFormatterBuilder.Composite
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */