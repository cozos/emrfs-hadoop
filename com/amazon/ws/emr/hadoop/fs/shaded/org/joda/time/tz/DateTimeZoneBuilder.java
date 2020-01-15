package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Period;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.PeriodType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.ISOChronology;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

public class DateTimeZoneBuilder
{
  private final ArrayList<RuleSet> iRuleSets;
  
  public static DateTimeZone readFrom(InputStream paramInputStream, String paramString)
    throws IOException
  {
    if ((paramInputStream instanceof DataInput)) {
      return readFrom((DataInput)paramInputStream, paramString);
    }
    return readFrom(new DataInputStream(paramInputStream), paramString);
  }
  
  public static DateTimeZone readFrom(DataInput paramDataInput, String paramString)
    throws IOException
  {
    switch (paramDataInput.readUnsignedByte())
    {
    case 70: 
      Object localObject = new FixedDateTimeZone(paramString, paramDataInput.readUTF(), (int)readMillis(paramDataInput), (int)readMillis(paramDataInput));
      if (((DateTimeZone)localObject).equals(DateTimeZone.UTC)) {
        localObject = DateTimeZone.UTC;
      }
      return (DateTimeZone)localObject;
    case 67: 
      return CachedDateTimeZone.forZone(PrecalculatedZone.readFrom(paramDataInput, paramString));
    case 80: 
      return PrecalculatedZone.readFrom(paramDataInput, paramString);
    }
    throw new IOException("Invalid encoding");
  }
  
  static void writeMillis(DataOutput paramDataOutput, long paramLong)
    throws IOException
  {
    long l;
    if (paramLong % 1800000L == 0L)
    {
      l = paramLong / 1800000L;
      if (l << 58 >> 58 == l)
      {
        paramDataOutput.writeByte((int)(l & 0x3F));
        return;
      }
    }
    if (paramLong % 60000L == 0L)
    {
      l = paramLong / 60000L;
      if (l << 34 >> 34 == l)
      {
        paramDataOutput.writeInt(0x40000000 | (int)(l & 0x3FFFFFFF));
        return;
      }
    }
    if (paramLong % 1000L == 0L)
    {
      l = paramLong / 1000L;
      if (l << 26 >> 26 == l)
      {
        paramDataOutput.writeByte(0x80 | (int)(l >> 32 & 0x3F));
        paramDataOutput.writeInt((int)(l & 0xFFFFFFFFFFFFFFFF));
        return;
      }
    }
    paramDataOutput.writeByte(paramLong < 0L ? 255 : 192);
    paramDataOutput.writeLong(paramLong);
  }
  
  static long readMillis(DataInput paramDataInput)
    throws IOException
  {
    int i = paramDataInput.readUnsignedByte();
    switch (i >> 6)
    {
    case 0: 
    default: 
      i = i << 26 >> 26;
      return i * 1800000L;
    case 1: 
      i = i << 26 >> 2;
      i |= paramDataInput.readUnsignedByte() << 16;
      i |= paramDataInput.readUnsignedByte() << 8;
      i |= paramDataInput.readUnsignedByte();
      return i * 60000L;
    case 2: 
      long l = i << 58 >> 26;
      l |= paramDataInput.readUnsignedByte() << 24;
      l |= paramDataInput.readUnsignedByte() << 16;
      l |= paramDataInput.readUnsignedByte() << 8;
      l |= paramDataInput.readUnsignedByte();
      return l * 1000L;
    }
    return paramDataInput.readLong();
  }
  
  private static DateTimeZone buildFixedZone(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (("UTC".equals(paramString1)) && (paramString1.equals(paramString2)) && (paramInt1 == 0) && (paramInt2 == 0)) {
      return DateTimeZone.UTC;
    }
    return new FixedDateTimeZone(paramString1, paramString2, paramInt1, paramInt2);
  }
  
  public DateTimeZoneBuilder()
  {
    iRuleSets = new ArrayList(10);
  }
  
  public DateTimeZoneBuilder addCutover(int paramInt1, char paramChar, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5)
  {
    if (iRuleSets.size() > 0)
    {
      OfYear localOfYear = new OfYear(paramChar, paramInt2, paramInt3, paramInt4, paramBoolean, paramInt5);
      
      RuleSet localRuleSet = (RuleSet)iRuleSets.get(iRuleSets.size() - 1);
      localRuleSet.setUpperLimit(paramInt1, localOfYear);
    }
    iRuleSets.add(new RuleSet());
    return this;
  }
  
  public DateTimeZoneBuilder setStandardOffset(int paramInt)
  {
    getLastRuleSet().setStandardOffset(paramInt);
    return this;
  }
  
  public DateTimeZoneBuilder setFixedSavings(String paramString, int paramInt)
  {
    getLastRuleSet().setFixedSavings(paramString, paramInt);
    return this;
  }
  
  public DateTimeZoneBuilder addRecurringSavings(String paramString, int paramInt1, int paramInt2, int paramInt3, char paramChar, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, int paramInt7)
  {
    if (paramInt2 <= paramInt3)
    {
      OfYear localOfYear = new OfYear(paramChar, paramInt4, paramInt5, paramInt6, paramBoolean, paramInt7);
      
      Recurrence localRecurrence = new Recurrence(localOfYear, paramString, paramInt1);
      Rule localRule = new Rule(localRecurrence, paramInt2, paramInt3);
      getLastRuleSet().addRule(localRule);
    }
    return this;
  }
  
  private RuleSet getLastRuleSet()
  {
    if (iRuleSets.size() == 0) {
      addCutover(Integer.MIN_VALUE, 'w', 1, 1, 0, false, 0);
    }
    return (RuleSet)iRuleSets.get(iRuleSets.size() - 1);
  }
  
  public DateTimeZone toDateTimeZone(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      throw new IllegalArgumentException();
    }
    ArrayList localArrayList = new ArrayList();
    
    DSTZone localDSTZone = null;
    
    long l = Long.MIN_VALUE;
    int i = 0;
    
    int j = iRuleSets.size();
    for (int k = 0; k < j; k++)
    {
      RuleSet localRuleSet = (RuleSet)iRuleSets.get(k);
      Transition localTransition = localRuleSet.firstTransition(l);
      if (localTransition != null)
      {
        addTransition(localArrayList, localTransition);
        l = localTransition.getMillis();
        i = localTransition.getSaveMillis();
        
        localRuleSet = new RuleSet(localRuleSet);
        while (((localTransition = localRuleSet.nextTransition(l, i)) != null) && (
          (!addTransition(localArrayList, localTransition)) || (localDSTZone == null)))
        {
          l = localTransition.getMillis();
          i = localTransition.getSaveMillis();
          if ((localDSTZone == null) && (k == j - 1)) {
            localDSTZone = localRuleSet.buildTailZone(paramString);
          }
        }
        l = localRuleSet.getUpperLimit(i);
      }
    }
    if (localArrayList.size() == 0)
    {
      if (localDSTZone != null) {
        return localDSTZone;
      }
      return buildFixedZone(paramString, "UTC", 0, 0);
    }
    if ((localArrayList.size() == 1) && (localDSTZone == null))
    {
      localObject = (Transition)localArrayList.get(0);
      return buildFixedZone(paramString, ((Transition)localObject).getNameKey(), ((Transition)localObject).getWallOffset(), ((Transition)localObject).getStandardOffset());
    }
    Object localObject = PrecalculatedZone.create(paramString, paramBoolean, localArrayList, localDSTZone);
    if (((PrecalculatedZone)localObject).isCachable()) {
      return CachedDateTimeZone.forZone((DateTimeZone)localObject);
    }
    return (DateTimeZone)localObject;
  }
  
  private boolean addTransition(ArrayList<Transition> paramArrayList, Transition paramTransition)
  {
    int i = paramArrayList.size();
    if (i == 0)
    {
      paramArrayList.add(paramTransition);
      return true;
    }
    Transition localTransition = (Transition)paramArrayList.get(i - 1);
    if (!paramTransition.isTransitionFrom(localTransition)) {
      return false;
    }
    int j = 0;
    if (i >= 2) {
      j = ((Transition)paramArrayList.get(i - 2)).getWallOffset();
    }
    int k = localTransition.getWallOffset();
    
    long l1 = localTransition.getMillis() + j;
    long l2 = paramTransition.getMillis() + k;
    if (l2 != l1)
    {
      paramArrayList.add(paramTransition);
      return true;
    }
    paramArrayList.remove(i - 1);
    return addTransition(paramArrayList, paramTransition);
  }
  
  public void writeTo(String paramString, OutputStream paramOutputStream)
    throws IOException
  {
    if ((paramOutputStream instanceof DataOutput))
    {
      writeTo(paramString, (DataOutput)paramOutputStream);
    }
    else
    {
      DataOutputStream localDataOutputStream = new DataOutputStream(paramOutputStream);
      writeTo(paramString, localDataOutputStream);
      localDataOutputStream.flush();
    }
  }
  
  public void writeTo(String paramString, DataOutput paramDataOutput)
    throws IOException
  {
    DateTimeZone localDateTimeZone = toDateTimeZone(paramString, false);
    if ((localDateTimeZone instanceof FixedDateTimeZone))
    {
      paramDataOutput.writeByte(70);
      paramDataOutput.writeUTF(localDateTimeZone.getNameKey(0L));
      writeMillis(paramDataOutput, localDateTimeZone.getOffset(0L));
      writeMillis(paramDataOutput, localDateTimeZone.getStandardOffset(0L));
    }
    else
    {
      if ((localDateTimeZone instanceof CachedDateTimeZone))
      {
        paramDataOutput.writeByte(67);
        localDateTimeZone = ((CachedDateTimeZone)localDateTimeZone).getUncachedZone();
      }
      else
      {
        paramDataOutput.writeByte(80);
      }
      ((PrecalculatedZone)localDateTimeZone).writeTo(paramDataOutput);
    }
  }
  
  private static final class OfYear
  {
    final char iMode;
    final int iMonthOfYear;
    final int iDayOfMonth;
    final int iDayOfWeek;
    final boolean iAdvance;
    final int iMillisOfDay;
    
    static OfYear readFrom(DataInput paramDataInput)
      throws IOException
    {
      return new OfYear((char)paramDataInput.readUnsignedByte(), paramDataInput.readUnsignedByte(), paramDataInput.readByte(), paramDataInput.readUnsignedByte(), paramDataInput.readBoolean(), (int)DateTimeZoneBuilder.readMillis(paramDataInput));
    }
    
    OfYear(char paramChar, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
    {
      if ((paramChar != 'u') && (paramChar != 'w') && (paramChar != 's')) {
        throw new IllegalArgumentException("Unknown mode: " + paramChar);
      }
      iMode = paramChar;
      iMonthOfYear = paramInt1;
      iDayOfMonth = paramInt2;
      iDayOfWeek = paramInt3;
      iAdvance = paramBoolean;
      iMillisOfDay = paramInt4;
    }
    
    public long setInstant(int paramInt1, int paramInt2, int paramInt3)
    {
      int i;
      if (iMode == 'w') {
        i = paramInt2 + paramInt3;
      } else if (iMode == 's') {
        i = paramInt2;
      } else {
        i = 0;
      }
      ISOChronology localISOChronology = ISOChronology.getInstanceUTC();
      long l = localISOChronology.year().set(0L, paramInt1);
      l = localISOChronology.monthOfYear().set(l, iMonthOfYear);
      l = localISOChronology.millisOfDay().set(l, iMillisOfDay);
      l = setDayOfMonth(localISOChronology, l);
      if (iDayOfWeek != 0) {
        l = setDayOfWeek(localISOChronology, l);
      }
      return l - i;
    }
    
    public long next(long paramLong, int paramInt1, int paramInt2)
    {
      int i;
      if (iMode == 'w') {
        i = paramInt1 + paramInt2;
      } else if (iMode == 's') {
        i = paramInt1;
      } else {
        i = 0;
      }
      paramLong += i;
      
      ISOChronology localISOChronology = ISOChronology.getInstanceUTC();
      long l = localISOChronology.monthOfYear().set(paramLong, iMonthOfYear);
      
      l = localISOChronology.millisOfDay().set(l, 0);
      l = localISOChronology.millisOfDay().add(l, iMillisOfDay);
      l = setDayOfMonthNext(localISOChronology, l);
      if (iDayOfWeek == 0)
      {
        if (l <= paramLong)
        {
          l = localISOChronology.year().add(l, 1);
          l = setDayOfMonthNext(localISOChronology, l);
        }
      }
      else
      {
        l = setDayOfWeek(localISOChronology, l);
        if (l <= paramLong)
        {
          l = localISOChronology.year().add(l, 1);
          l = localISOChronology.monthOfYear().set(l, iMonthOfYear);
          l = setDayOfMonthNext(localISOChronology, l);
          l = setDayOfWeek(localISOChronology, l);
        }
      }
      return l - i;
    }
    
    public long previous(long paramLong, int paramInt1, int paramInt2)
    {
      int i;
      if (iMode == 'w') {
        i = paramInt1 + paramInt2;
      } else if (iMode == 's') {
        i = paramInt1;
      } else {
        i = 0;
      }
      paramLong += i;
      
      ISOChronology localISOChronology = ISOChronology.getInstanceUTC();
      long l = localISOChronology.monthOfYear().set(paramLong, iMonthOfYear);
      
      l = localISOChronology.millisOfDay().set(l, 0);
      l = localISOChronology.millisOfDay().add(l, iMillisOfDay);
      l = setDayOfMonthPrevious(localISOChronology, l);
      if (iDayOfWeek == 0)
      {
        if (l >= paramLong)
        {
          l = localISOChronology.year().add(l, -1);
          l = setDayOfMonthPrevious(localISOChronology, l);
        }
      }
      else
      {
        l = setDayOfWeek(localISOChronology, l);
        if (l >= paramLong)
        {
          l = localISOChronology.year().add(l, -1);
          l = localISOChronology.monthOfYear().set(l, iMonthOfYear);
          l = setDayOfMonthPrevious(localISOChronology, l);
          l = setDayOfWeek(localISOChronology, l);
        }
      }
      return l - i;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if ((paramObject instanceof OfYear))
      {
        OfYear localOfYear = (OfYear)paramObject;
        return (iMode == iMode) && (iMonthOfYear == iMonthOfYear) && (iDayOfMonth == iDayOfMonth) && (iDayOfWeek == iDayOfWeek) && (iAdvance == iAdvance) && (iMillisOfDay == iMillisOfDay);
      }
      return false;
    }
    
    public void writeTo(DataOutput paramDataOutput)
      throws IOException
    {
      paramDataOutput.writeByte(iMode);
      paramDataOutput.writeByte(iMonthOfYear);
      paramDataOutput.writeByte(iDayOfMonth);
      paramDataOutput.writeByte(iDayOfWeek);
      paramDataOutput.writeBoolean(iAdvance);
      DateTimeZoneBuilder.writeMillis(paramDataOutput, iMillisOfDay);
    }
    
    private long setDayOfMonthNext(Chronology paramChronology, long paramLong)
    {
      try
      {
        paramLong = setDayOfMonth(paramChronology, paramLong);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        if ((iMonthOfYear == 2) && (iDayOfMonth == 29))
        {
          while (!paramChronology.year().isLeap(paramLong)) {
            paramLong = paramChronology.year().add(paramLong, 1);
          }
          paramLong = setDayOfMonth(paramChronology, paramLong);
        }
        else
        {
          throw localIllegalArgumentException;
        }
      }
      return paramLong;
    }
    
    private long setDayOfMonthPrevious(Chronology paramChronology, long paramLong)
    {
      try
      {
        paramLong = setDayOfMonth(paramChronology, paramLong);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        if ((iMonthOfYear == 2) && (iDayOfMonth == 29))
        {
          while (!paramChronology.year().isLeap(paramLong)) {
            paramLong = paramChronology.year().add(paramLong, -1);
          }
          paramLong = setDayOfMonth(paramChronology, paramLong);
        }
        else
        {
          throw localIllegalArgumentException;
        }
      }
      return paramLong;
    }
    
    private long setDayOfMonth(Chronology paramChronology, long paramLong)
    {
      if (iDayOfMonth >= 0)
      {
        paramLong = paramChronology.dayOfMonth().set(paramLong, iDayOfMonth);
      }
      else
      {
        paramLong = paramChronology.dayOfMonth().set(paramLong, 1);
        paramLong = paramChronology.monthOfYear().add(paramLong, 1);
        paramLong = paramChronology.dayOfMonth().add(paramLong, iDayOfMonth);
      }
      return paramLong;
    }
    
    private long setDayOfWeek(Chronology paramChronology, long paramLong)
    {
      int i = paramChronology.dayOfWeek().get(paramLong);
      int j = iDayOfWeek - i;
      if (j != 0)
      {
        if (iAdvance)
        {
          if (j < 0) {
            j += 7;
          }
        }
        else if (j > 0) {
          j -= 7;
        }
        paramLong = paramChronology.dayOfWeek().add(paramLong, j);
      }
      return paramLong;
    }
  }
  
  private static final class Recurrence
  {
    final DateTimeZoneBuilder.OfYear iOfYear;
    final String iNameKey;
    final int iSaveMillis;
    
    static Recurrence readFrom(DataInput paramDataInput)
      throws IOException
    {
      return new Recurrence(DateTimeZoneBuilder.OfYear.readFrom(paramDataInput), paramDataInput.readUTF(), (int)DateTimeZoneBuilder.readMillis(paramDataInput));
    }
    
    Recurrence(DateTimeZoneBuilder.OfYear paramOfYear, String paramString, int paramInt)
    {
      iOfYear = paramOfYear;
      iNameKey = paramString;
      iSaveMillis = paramInt;
    }
    
    public DateTimeZoneBuilder.OfYear getOfYear()
    {
      return iOfYear;
    }
    
    public long next(long paramLong, int paramInt1, int paramInt2)
    {
      return iOfYear.next(paramLong, paramInt1, paramInt2);
    }
    
    public long previous(long paramLong, int paramInt1, int paramInt2)
    {
      return iOfYear.previous(paramLong, paramInt1, paramInt2);
    }
    
    public String getNameKey()
    {
      return iNameKey;
    }
    
    public int getSaveMillis()
    {
      return iSaveMillis;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if ((paramObject instanceof Recurrence))
      {
        Recurrence localRecurrence = (Recurrence)paramObject;
        return (iSaveMillis == iSaveMillis) && (iNameKey.equals(iNameKey)) && (iOfYear.equals(iOfYear));
      }
      return false;
    }
    
    public void writeTo(DataOutput paramDataOutput)
      throws IOException
    {
      iOfYear.writeTo(paramDataOutput);
      paramDataOutput.writeUTF(iNameKey);
      DateTimeZoneBuilder.writeMillis(paramDataOutput, iSaveMillis);
    }
    
    Recurrence rename(String paramString)
    {
      return new Recurrence(iOfYear, paramString, iSaveMillis);
    }
    
    Recurrence renameAppend(String paramString)
    {
      return rename((iNameKey + paramString).intern());
    }
  }
  
  private static final class Rule
  {
    final DateTimeZoneBuilder.Recurrence iRecurrence;
    final int iFromYear;
    final int iToYear;
    
    Rule(DateTimeZoneBuilder.Recurrence paramRecurrence, int paramInt1, int paramInt2)
    {
      iRecurrence = paramRecurrence;
      iFromYear = paramInt1;
      iToYear = paramInt2;
    }
    
    public int getFromYear()
    {
      return iFromYear;
    }
    
    public int getToYear()
    {
      return iToYear;
    }
    
    public DateTimeZoneBuilder.OfYear getOfYear()
    {
      return iRecurrence.getOfYear();
    }
    
    public String getNameKey()
    {
      return iRecurrence.getNameKey();
    }
    
    public int getSaveMillis()
    {
      return iRecurrence.getSaveMillis();
    }
    
    public long next(long paramLong, int paramInt1, int paramInt2)
    {
      ISOChronology localISOChronology = ISOChronology.getInstanceUTC();
      
      int i = paramInt1 + paramInt2;
      long l1 = paramLong;
      int j;
      if (paramLong == Long.MIN_VALUE) {
        j = Integer.MIN_VALUE;
      } else {
        j = localISOChronology.year().get(paramLong + i);
      }
      if (j < iFromYear)
      {
        l1 = localISOChronology.year().set(0L, iFromYear) - i;
        
        l1 -= 1L;
      }
      long l2 = iRecurrence.next(l1, paramInt1, paramInt2);
      if (l2 > paramLong)
      {
        j = localISOChronology.year().get(l2 + i);
        if (j > iToYear) {
          l2 = paramLong;
        }
      }
      return l2;
    }
  }
  
  private static final class Transition
  {
    private final long iMillis;
    private final String iNameKey;
    private final int iWallOffset;
    private final int iStandardOffset;
    
    Transition(long paramLong, Transition paramTransition)
    {
      iMillis = paramLong;
      iNameKey = iNameKey;
      iWallOffset = iWallOffset;
      iStandardOffset = iStandardOffset;
    }
    
    Transition(long paramLong, DateTimeZoneBuilder.Rule paramRule, int paramInt)
    {
      iMillis = paramLong;
      iNameKey = paramRule.getNameKey();
      iWallOffset = (paramInt + paramRule.getSaveMillis());
      iStandardOffset = paramInt;
    }
    
    Transition(long paramLong, String paramString, int paramInt1, int paramInt2)
    {
      iMillis = paramLong;
      iNameKey = paramString;
      iWallOffset = paramInt1;
      iStandardOffset = paramInt2;
    }
    
    public long getMillis()
    {
      return iMillis;
    }
    
    public String getNameKey()
    {
      return iNameKey;
    }
    
    public int getWallOffset()
    {
      return iWallOffset;
    }
    
    public int getStandardOffset()
    {
      return iStandardOffset;
    }
    
    public int getSaveMillis()
    {
      return iWallOffset - iStandardOffset;
    }
    
    public boolean isTransitionFrom(Transition paramTransition)
    {
      if (paramTransition == null) {
        return true;
      }
      return (iMillis > iMillis) && ((iWallOffset != iWallOffset) || (!iNameKey.equals(iNameKey)));
    }
  }
  
  private static final class RuleSet
  {
    private static final int YEAR_LIMIT;
    private int iStandardOffset;
    private ArrayList<DateTimeZoneBuilder.Rule> iRules;
    private String iInitialNameKey;
    private int iInitialSaveMillis;
    private int iUpperYear;
    private DateTimeZoneBuilder.OfYear iUpperOfYear;
    
    static
    {
      long l = DateTimeUtils.currentTimeMillis();
      YEAR_LIMIT = ISOChronology.getInstanceUTC().year().get(l) + 100;
    }
    
    RuleSet()
    {
      iRules = new ArrayList(10);
      iUpperYear = Integer.MAX_VALUE;
    }
    
    RuleSet(RuleSet paramRuleSet)
    {
      iStandardOffset = iStandardOffset;
      iRules = new ArrayList(iRules);
      iInitialNameKey = iInitialNameKey;
      iInitialSaveMillis = iInitialSaveMillis;
      iUpperYear = iUpperYear;
      iUpperOfYear = iUpperOfYear;
    }
    
    public int getStandardOffset()
    {
      return iStandardOffset;
    }
    
    public void setStandardOffset(int paramInt)
    {
      iStandardOffset = paramInt;
    }
    
    public void setFixedSavings(String paramString, int paramInt)
    {
      iInitialNameKey = paramString;
      iInitialSaveMillis = paramInt;
    }
    
    public void addRule(DateTimeZoneBuilder.Rule paramRule)
    {
      if (!iRules.contains(paramRule)) {
        iRules.add(paramRule);
      }
    }
    
    public void setUpperLimit(int paramInt, DateTimeZoneBuilder.OfYear paramOfYear)
    {
      iUpperYear = paramInt;
      iUpperOfYear = paramOfYear;
    }
    
    public DateTimeZoneBuilder.Transition firstTransition(long paramLong)
    {
      if (iInitialNameKey != null) {
        return new DateTimeZoneBuilder.Transition(paramLong, iInitialNameKey, iStandardOffset + iInitialSaveMillis, iStandardOffset);
      }
      ArrayList localArrayList = new ArrayList(iRules);
      
      long l = Long.MIN_VALUE;
      int i = 0;
      DateTimeZoneBuilder.Transition localTransition1 = null;
      DateTimeZoneBuilder.Transition localTransition2;
      while ((localTransition2 = nextTransition(l, i)) != null)
      {
        l = localTransition2.getMillis();
        if (l == paramLong)
        {
          localTransition1 = new DateTimeZoneBuilder.Transition(paramLong, localTransition2);
          break;
        }
        if (l > paramLong)
        {
          if (localTransition1 == null) {
            for (DateTimeZoneBuilder.Rule localRule : localArrayList) {
              if (localRule.getSaveMillis() == 0)
              {
                localTransition1 = new DateTimeZoneBuilder.Transition(paramLong, localRule, iStandardOffset);
                break;
              }
            }
          }
          if (localTransition1 != null) {
            break;
          }
          localTransition1 = new DateTimeZoneBuilder.Transition(paramLong, localTransition2.getNameKey(), iStandardOffset, iStandardOffset); break;
        }
        localTransition1 = new DateTimeZoneBuilder.Transition(paramLong, localTransition2);
        
        i = localTransition2.getSaveMillis();
      }
      iRules = localArrayList;
      return localTransition1;
    }
    
    public DateTimeZoneBuilder.Transition nextTransition(long paramLong, int paramInt)
    {
      ISOChronology localISOChronology = ISOChronology.getInstanceUTC();
      
      Object localObject = null;
      long l1 = Long.MAX_VALUE;
      
      Iterator localIterator = iRules.iterator();
      while (localIterator.hasNext())
      {
        DateTimeZoneBuilder.Rule localRule = (DateTimeZoneBuilder.Rule)localIterator.next();
        long l2 = localRule.next(paramLong, iStandardOffset, paramInt);
        if (l2 <= paramLong)
        {
          localIterator.remove();
        }
        else if (l2 <= l1)
        {
          localObject = localRule;
          l1 = l2;
        }
      }
      if (localObject == null) {
        return null;
      }
      if (localISOChronology.year().get(l1) >= YEAR_LIMIT) {
        return null;
      }
      if (iUpperYear < Integer.MAX_VALUE)
      {
        long l3 = iUpperOfYear.setInstant(iUpperYear, iStandardOffset, paramInt);
        if (l1 >= l3) {
          return null;
        }
      }
      return new DateTimeZoneBuilder.Transition(l1, (DateTimeZoneBuilder.Rule)localObject, iStandardOffset);
    }
    
    public long getUpperLimit(int paramInt)
    {
      if (iUpperYear == Integer.MAX_VALUE) {
        return Long.MAX_VALUE;
      }
      return iUpperOfYear.setInstant(iUpperYear, iStandardOffset, paramInt);
    }
    
    public DateTimeZoneBuilder.DSTZone buildTailZone(String paramString)
    {
      if (iRules.size() == 2)
      {
        DateTimeZoneBuilder.Rule localRule1 = (DateTimeZoneBuilder.Rule)iRules.get(0);
        DateTimeZoneBuilder.Rule localRule2 = (DateTimeZoneBuilder.Rule)iRules.get(1);
        if ((localRule1.getToYear() == Integer.MAX_VALUE) && (localRule2.getToYear() == Integer.MAX_VALUE)) {
          return new DateTimeZoneBuilder.DSTZone(paramString, iStandardOffset, iRecurrence, iRecurrence);
        }
      }
      return null;
    }
  }
  
  private static final class DSTZone
    extends DateTimeZone
  {
    private static final long serialVersionUID = 6941492635554961361L;
    final int iStandardOffset;
    final DateTimeZoneBuilder.Recurrence iStartRecurrence;
    final DateTimeZoneBuilder.Recurrence iEndRecurrence;
    
    static DSTZone readFrom(DataInput paramDataInput, String paramString)
      throws IOException
    {
      return new DSTZone(paramString, (int)DateTimeZoneBuilder.readMillis(paramDataInput), DateTimeZoneBuilder.Recurrence.readFrom(paramDataInput), DateTimeZoneBuilder.Recurrence.readFrom(paramDataInput));
    }
    
    DSTZone(String paramString, int paramInt, DateTimeZoneBuilder.Recurrence paramRecurrence1, DateTimeZoneBuilder.Recurrence paramRecurrence2)
    {
      super();
      iStandardOffset = paramInt;
      iStartRecurrence = paramRecurrence1;
      iEndRecurrence = paramRecurrence2;
    }
    
    public String getNameKey(long paramLong)
    {
      return findMatchingRecurrence(paramLong).getNameKey();
    }
    
    public int getOffset(long paramLong)
    {
      return iStandardOffset + findMatchingRecurrence(paramLong).getSaveMillis();
    }
    
    public int getStandardOffset(long paramLong)
    {
      return iStandardOffset;
    }
    
    public boolean isFixed()
    {
      return false;
    }
    
    public long nextTransition(long paramLong)
    {
      int i = iStandardOffset;
      DateTimeZoneBuilder.Recurrence localRecurrence1 = iStartRecurrence;
      DateTimeZoneBuilder.Recurrence localRecurrence2 = iEndRecurrence;
      long l1;
      try
      {
        l1 = localRecurrence1.next(paramLong, i, localRecurrence2.getSaveMillis());
        if ((paramLong > 0L) && (l1 < 0L)) {
          l1 = paramLong;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException1)
      {
        l1 = paramLong;
      }
      catch (ArithmeticException localArithmeticException1)
      {
        l1 = paramLong;
      }
      long l2;
      try
      {
        l2 = localRecurrence2.next(paramLong, i, localRecurrence1.getSaveMillis());
        if ((paramLong > 0L) && (l2 < 0L)) {
          l2 = paramLong;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException2)
      {
        l2 = paramLong;
      }
      catch (ArithmeticException localArithmeticException2)
      {
        l2 = paramLong;
      }
      return l1 > l2 ? l2 : l1;
    }
    
    public long previousTransition(long paramLong)
    {
      paramLong += 1L;
      
      int i = iStandardOffset;
      DateTimeZoneBuilder.Recurrence localRecurrence1 = iStartRecurrence;
      DateTimeZoneBuilder.Recurrence localRecurrence2 = iEndRecurrence;
      long l1;
      try
      {
        l1 = localRecurrence1.previous(paramLong, i, localRecurrence2.getSaveMillis());
        if ((paramLong < 0L) && (l1 > 0L)) {
          l1 = paramLong;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException1)
      {
        l1 = paramLong;
      }
      catch (ArithmeticException localArithmeticException1)
      {
        l1 = paramLong;
      }
      long l2;
      try
      {
        l2 = localRecurrence2.previous(paramLong, i, localRecurrence1.getSaveMillis());
        if ((paramLong < 0L) && (l2 > 0L)) {
          l2 = paramLong;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException2)
      {
        l2 = paramLong;
      }
      catch (ArithmeticException localArithmeticException2)
      {
        l2 = paramLong;
      }
      return (l1 > l2 ? l1 : l2) - 1L;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if ((paramObject instanceof DSTZone))
      {
        DSTZone localDSTZone = (DSTZone)paramObject;
        return (getID().equals(localDSTZone.getID())) && (iStandardOffset == iStandardOffset) && (iStartRecurrence.equals(iStartRecurrence)) && (iEndRecurrence.equals(iEndRecurrence));
      }
      return false;
    }
    
    public void writeTo(DataOutput paramDataOutput)
      throws IOException
    {
      DateTimeZoneBuilder.writeMillis(paramDataOutput, iStandardOffset);
      iStartRecurrence.writeTo(paramDataOutput);
      iEndRecurrence.writeTo(paramDataOutput);
    }
    
    private DateTimeZoneBuilder.Recurrence findMatchingRecurrence(long paramLong)
    {
      int i = iStandardOffset;
      DateTimeZoneBuilder.Recurrence localRecurrence1 = iStartRecurrence;
      DateTimeZoneBuilder.Recurrence localRecurrence2 = iEndRecurrence;
      long l1;
      try
      {
        l1 = localRecurrence1.next(paramLong, i, localRecurrence2.getSaveMillis());
      }
      catch (IllegalArgumentException localIllegalArgumentException1)
      {
        l1 = paramLong;
      }
      catch (ArithmeticException localArithmeticException1)
      {
        l1 = paramLong;
      }
      long l2;
      try
      {
        l2 = localRecurrence2.next(paramLong, i, localRecurrence1.getSaveMillis());
      }
      catch (IllegalArgumentException localIllegalArgumentException2)
      {
        l2 = paramLong;
      }
      catch (ArithmeticException localArithmeticException2)
      {
        l2 = paramLong;
      }
      return l1 > l2 ? localRecurrence1 : localRecurrence2;
    }
  }
  
  private static final class PrecalculatedZone
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
    
    private PrecalculatedZone(String paramString, long[] paramArrayOfLong, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String[] paramArrayOfString, DateTimeZoneBuilder.DSTZone paramDSTZone)
    {
      super();
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz.DateTimeZoneBuilder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */