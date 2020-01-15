package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.PeriodType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadWritablePeriod;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePeriod;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PeriodFormatterBuilder
{
  private static final int PRINT_ZERO_RARELY_FIRST = 1;
  private static final int PRINT_ZERO_RARELY_LAST = 2;
  private static final int PRINT_ZERO_IF_SUPPORTED = 3;
  private static final int PRINT_ZERO_ALWAYS = 4;
  private static final int PRINT_ZERO_NEVER = 5;
  private static final int YEARS = 0;
  private static final int MONTHS = 1;
  private static final int WEEKS = 2;
  private static final int DAYS = 3;
  private static final int HOURS = 4;
  private static final int MINUTES = 5;
  private static final int SECONDS = 6;
  private static final int MILLIS = 7;
  private static final int SECONDS_MILLIS = 8;
  private static final int SECONDS_OPTIONAL_MILLIS = 9;
  private static final int MAX_FIELD = 9;
  private static final ConcurrentMap<String, Pattern> PATTERNS = new ConcurrentHashMap();
  private int iMinPrintedDigits;
  private int iPrintZeroSetting;
  private int iMaxParsedDigits;
  private boolean iRejectSignedValues;
  private PeriodFieldAffix iPrefix;
  private List<Object> iElementPairs;
  private boolean iNotPrinter;
  private boolean iNotParser;
  private FieldFormatter[] iFieldFormatters;
  
  public PeriodFormatterBuilder()
  {
    clear();
  }
  
  public PeriodFormatter toFormatter()
  {
    PeriodFormatter localPeriodFormatter = toFormatter(iElementPairs, iNotPrinter, iNotParser);
    for (FieldFormatter localFieldFormatter : iFieldFormatters) {
      if (localFieldFormatter != null) {
        localFieldFormatter.finish(iFieldFormatters);
      }
    }
    iFieldFormatters = ((FieldFormatter[])iFieldFormatters.clone());
    return localPeriodFormatter;
  }
  
  public PeriodPrinter toPrinter()
  {
    if (iNotPrinter) {
      return null;
    }
    return toFormatter().getPrinter();
  }
  
  public PeriodParser toParser()
  {
    if (iNotParser) {
      return null;
    }
    return toFormatter().getParser();
  }
  
  public void clear()
  {
    iMinPrintedDigits = 1;
    iPrintZeroSetting = 2;
    iMaxParsedDigits = 10;
    iRejectSignedValues = false;
    iPrefix = null;
    if (iElementPairs == null) {
      iElementPairs = new ArrayList();
    } else {
      iElementPairs.clear();
    }
    iNotPrinter = false;
    iNotParser = false;
    iFieldFormatters = new FieldFormatter[10];
  }
  
  public PeriodFormatterBuilder append(PeriodFormatter paramPeriodFormatter)
  {
    if (paramPeriodFormatter == null) {
      throw new IllegalArgumentException("No formatter supplied");
    }
    clearPrefix();
    append0(paramPeriodFormatter.getPrinter(), paramPeriodFormatter.getParser());
    return this;
  }
  
  public PeriodFormatterBuilder append(PeriodPrinter paramPeriodPrinter, PeriodParser paramPeriodParser)
  {
    if ((paramPeriodPrinter == null) && (paramPeriodParser == null)) {
      throw new IllegalArgumentException("No printer or parser supplied");
    }
    clearPrefix();
    append0(paramPeriodPrinter, paramPeriodParser);
    return this;
  }
  
  public PeriodFormatterBuilder appendLiteral(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Literal must not be null");
    }
    clearPrefix();
    Literal localLiteral = new Literal(paramString);
    append0(localLiteral, localLiteral);
    return this;
  }
  
  public PeriodFormatterBuilder minimumPrintedDigits(int paramInt)
  {
    iMinPrintedDigits = paramInt;
    return this;
  }
  
  public PeriodFormatterBuilder maximumParsedDigits(int paramInt)
  {
    iMaxParsedDigits = paramInt;
    return this;
  }
  
  public PeriodFormatterBuilder rejectSignedValues(boolean paramBoolean)
  {
    iRejectSignedValues = paramBoolean;
    return this;
  }
  
  public PeriodFormatterBuilder printZeroRarelyLast()
  {
    iPrintZeroSetting = 2;
    return this;
  }
  
  public PeriodFormatterBuilder printZeroRarelyFirst()
  {
    iPrintZeroSetting = 1;
    return this;
  }
  
  public PeriodFormatterBuilder printZeroIfSupported()
  {
    iPrintZeroSetting = 3;
    return this;
  }
  
  public PeriodFormatterBuilder printZeroAlways()
  {
    iPrintZeroSetting = 4;
    return this;
  }
  
  public PeriodFormatterBuilder printZeroNever()
  {
    iPrintZeroSetting = 5;
    return this;
  }
  
  public PeriodFormatterBuilder appendPrefix(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException();
    }
    return appendPrefix(new SimpleAffix(paramString));
  }
  
  public PeriodFormatterBuilder appendPrefix(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      throw new IllegalArgumentException();
    }
    return appendPrefix(new PluralAffix(paramString1, paramString2));
  }
  
  public PeriodFormatterBuilder appendPrefix(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if ((paramArrayOfString1 == null) || (paramArrayOfString2 == null) || (paramArrayOfString1.length < 1) || (paramArrayOfString1.length != paramArrayOfString2.length)) {
      throw new IllegalArgumentException();
    }
    return appendPrefix(new RegExAffix(paramArrayOfString1, paramArrayOfString2));
  }
  
  private PeriodFormatterBuilder appendPrefix(PeriodFieldAffix paramPeriodFieldAffix)
  {
    if (paramPeriodFieldAffix == null) {
      throw new IllegalArgumentException();
    }
    if (iPrefix != null) {
      paramPeriodFieldAffix = new CompositeAffix(iPrefix, paramPeriodFieldAffix);
    }
    iPrefix = paramPeriodFieldAffix;
    return this;
  }
  
  public PeriodFormatterBuilder appendYears()
  {
    appendField(0);
    return this;
  }
  
  public PeriodFormatterBuilder appendMonths()
  {
    appendField(1);
    return this;
  }
  
  public PeriodFormatterBuilder appendWeeks()
  {
    appendField(2);
    return this;
  }
  
  public PeriodFormatterBuilder appendDays()
  {
    appendField(3);
    return this;
  }
  
  public PeriodFormatterBuilder appendHours()
  {
    appendField(4);
    return this;
  }
  
  public PeriodFormatterBuilder appendMinutes()
  {
    appendField(5);
    return this;
  }
  
  public PeriodFormatterBuilder appendSeconds()
  {
    appendField(6);
    return this;
  }
  
  public PeriodFormatterBuilder appendSecondsWithMillis()
  {
    appendField(8);
    return this;
  }
  
  public PeriodFormatterBuilder appendSecondsWithOptionalMillis()
  {
    appendField(9);
    return this;
  }
  
  public PeriodFormatterBuilder appendMillis()
  {
    appendField(7);
    return this;
  }
  
  public PeriodFormatterBuilder appendMillis3Digit()
  {
    appendField(7, 3);
    return this;
  }
  
  private void appendField(int paramInt)
  {
    appendField(paramInt, iMinPrintedDigits);
  }
  
  private void appendField(int paramInt1, int paramInt2)
  {
    FieldFormatter localFieldFormatter = new FieldFormatter(paramInt2, iPrintZeroSetting, iMaxParsedDigits, iRejectSignedValues, paramInt1, iFieldFormatters, iPrefix, null);
    
    append0(localFieldFormatter, localFieldFormatter);
    iFieldFormatters[paramInt1] = localFieldFormatter;
    iPrefix = null;
  }
  
  public PeriodFormatterBuilder appendSuffix(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException();
    }
    return appendSuffix(new SimpleAffix(paramString));
  }
  
  public PeriodFormatterBuilder appendSuffix(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      throw new IllegalArgumentException();
    }
    return appendSuffix(new PluralAffix(paramString1, paramString2));
  }
  
  public PeriodFormatterBuilder appendSuffix(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if ((paramArrayOfString1 == null) || (paramArrayOfString2 == null) || (paramArrayOfString1.length < 1) || (paramArrayOfString1.length != paramArrayOfString2.length)) {
      throw new IllegalArgumentException();
    }
    return appendSuffix(new RegExAffix(paramArrayOfString1, paramArrayOfString2));
  }
  
  private PeriodFormatterBuilder appendSuffix(PeriodFieldAffix paramPeriodFieldAffix)
  {
    Object localObject1;
    Object localObject2;
    if (iElementPairs.size() > 0)
    {
      localObject1 = iElementPairs.get(iElementPairs.size() - 2);
      localObject2 = iElementPairs.get(iElementPairs.size() - 1);
    }
    else
    {
      localObject1 = null;
      localObject2 = null;
    }
    if ((localObject1 == null) || (localObject2 == null) || (localObject1 != localObject2) || (!(localObject1 instanceof FieldFormatter))) {
      throw new IllegalStateException("No field to apply suffix to");
    }
    clearPrefix();
    FieldFormatter localFieldFormatter = new FieldFormatter((FieldFormatter)localObject1, paramPeriodFieldAffix);
    iElementPairs.set(iElementPairs.size() - 2, localFieldFormatter);
    iElementPairs.set(iElementPairs.size() - 1, localFieldFormatter);
    iFieldFormatters[localFieldFormatter.getFieldType()] = localFieldFormatter;
    
    return this;
  }
  
  public PeriodFormatterBuilder appendSeparator(String paramString)
  {
    return appendSeparator(paramString, paramString, null, true, true);
  }
  
  public PeriodFormatterBuilder appendSeparatorIfFieldsAfter(String paramString)
  {
    return appendSeparator(paramString, paramString, null, false, true);
  }
  
  public PeriodFormatterBuilder appendSeparatorIfFieldsBefore(String paramString)
  {
    return appendSeparator(paramString, paramString, null, true, false);
  }
  
  public PeriodFormatterBuilder appendSeparator(String paramString1, String paramString2)
  {
    return appendSeparator(paramString1, paramString2, null, true, true);
  }
  
  public PeriodFormatterBuilder appendSeparator(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return appendSeparator(paramString1, paramString2, paramArrayOfString, true, true);
  }
  
  private PeriodFormatterBuilder appendSeparator(String paramString1, String paramString2, String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      throw new IllegalArgumentException();
    }
    clearPrefix();
    
    List localList = iElementPairs;
    if (localList.size() == 0)
    {
      if ((paramBoolean2) && (!paramBoolean1))
      {
        Separator localSeparator1 = new Separator(paramString1, paramString2, paramArrayOfString, Literal.EMPTY, Literal.EMPTY, paramBoolean1, paramBoolean2);
        
        append0(localSeparator1, localSeparator1);
      }
      return this;
    }
    Separator localSeparator2 = null;
    int i = localList.size();
    for (;;)
    {
      i--;
      if (i < 0) {
        break;
      }
      if ((localList.get(i) instanceof Separator))
      {
        localSeparator2 = (Separator)localList.get(i);
        localList = localList.subList(i + 1, localList.size());
        break;
      }
      i--;
    }
    if ((localSeparator2 != null) && (localList.size() == 0)) {
      throw new IllegalStateException("Cannot have two adjacent separators");
    }
    Object[] arrayOfObject = createComposite(localList);
    localList.clear();
    Separator localSeparator3 = new Separator(paramString1, paramString2, paramArrayOfString, (PeriodPrinter)arrayOfObject[0], (PeriodParser)arrayOfObject[1], paramBoolean1, paramBoolean2);
    
    localList.add(localSeparator3);
    localList.add(localSeparator3);
    
    return this;
  }
  
  private void clearPrefix()
    throws IllegalStateException
  {
    if (iPrefix != null) {
      throw new IllegalStateException("Prefix not followed by field");
    }
    iPrefix = null;
  }
  
  private PeriodFormatterBuilder append0(PeriodPrinter paramPeriodPrinter, PeriodParser paramPeriodParser)
  {
    iElementPairs.add(paramPeriodPrinter);
    iElementPairs.add(paramPeriodParser);
    iNotPrinter |= paramPeriodPrinter == null;
    iNotParser |= paramPeriodParser == null;
    return this;
  }
  
  private static PeriodFormatter toFormatter(List<Object> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      throw new IllegalStateException("Builder has created neither a printer nor a parser");
    }
    int i = paramList.size();
    if ((i >= 2) && ((paramList.get(0) instanceof Separator)))
    {
      localObject = (Separator)paramList.get(0);
      if ((iAfterParser == null) && (iAfterPrinter == null))
      {
        PeriodFormatter localPeriodFormatter = toFormatter(paramList.subList(2, i), paramBoolean1, paramBoolean2);
        localObject = ((Separator)localObject).finish(localPeriodFormatter.getPrinter(), localPeriodFormatter.getParser());
        return new PeriodFormatter((PeriodPrinter)localObject, (PeriodParser)localObject);
      }
    }
    Object localObject = createComposite(paramList);
    if (paramBoolean1) {
      return new PeriodFormatter(null, (PeriodParser)localObject[1]);
    }
    if (paramBoolean2) {
      return new PeriodFormatter((PeriodPrinter)localObject[0], null);
    }
    return new PeriodFormatter((PeriodPrinter)localObject[0], (PeriodParser)localObject[1]);
  }
  
  private static Object[] createComposite(List<Object> paramList)
  {
    switch (paramList.size())
    {
    case 0: 
      return new Object[] { Literal.EMPTY, Literal.EMPTY };
    case 1: 
      return new Object[] { paramList.get(0), paramList.get(1) };
    }
    Composite localComposite = new Composite(paramList);
    return new Object[] { localComposite, localComposite };
  }
  
  static abstract interface PeriodFieldAffix
  {
    public abstract int calculatePrintedLength(int paramInt);
    
    public abstract void printTo(StringBuffer paramStringBuffer, int paramInt);
    
    public abstract void printTo(Writer paramWriter, int paramInt)
      throws IOException;
    
    public abstract int parse(String paramString, int paramInt);
    
    public abstract int scan(String paramString, int paramInt);
    
    public abstract String[] getAffixes();
    
    public abstract void finish(Set<PeriodFieldAffix> paramSet);
  }
  
  static abstract class IgnorableAffix
    implements PeriodFormatterBuilder.PeriodFieldAffix
  {
    private volatile String[] iOtherAffixes;
    
    public void finish(Set<PeriodFormatterBuilder.PeriodFieldAffix> paramSet)
    {
      if (iOtherAffixes == null)
      {
        int i = Integer.MAX_VALUE;
        Object localObject1 = null;
        String[] arrayOfString;
        for (arrayOfString : getAffixes()) {
          if (arrayOfString.length() < i)
          {
            i = arrayOfString.length();
            localObject1 = arrayOfString;
          }
        }
        ??? = new HashSet();
        for (PeriodFormatterBuilder.PeriodFieldAffix localPeriodFieldAffix : paramSet) {
          if (localPeriodFieldAffix != null) {
            for (String str : localPeriodFieldAffix.getAffixes()) {
              if ((str.length() > i) || ((str.equalsIgnoreCase((String)localObject1)) && (!str.equals(localObject1)))) {
                ((Set)???).add(str);
              }
            }
          }
        }
        iOtherAffixes = ((String[])((Set)???).toArray(new String[((Set)???).size()]));
      }
    }
    
    protected boolean matchesOtherAffix(int paramInt1, String paramString, int paramInt2)
    {
      if (iOtherAffixes != null) {
        for (String str : iOtherAffixes)
        {
          int k = str.length();
          if (((paramInt1 < k) && (paramString.regionMatches(true, paramInt2, str, 0, k))) || ((paramInt1 == k) && (paramString.regionMatches(false, paramInt2, str, 0, k)))) {
            return true;
          }
        }
      }
      return false;
    }
  }
  
  static class SimpleAffix
    extends PeriodFormatterBuilder.IgnorableAffix
  {
    private final String iText;
    
    SimpleAffix(String paramString)
    {
      iText = paramString;
    }
    
    public int calculatePrintedLength(int paramInt)
    {
      return iText.length();
    }
    
    public void printTo(StringBuffer paramStringBuffer, int paramInt)
    {
      paramStringBuffer.append(iText);
    }
    
    public void printTo(Writer paramWriter, int paramInt)
      throws IOException
    {
      paramWriter.write(iText);
    }
    
    public int parse(String paramString, int paramInt)
    {
      String str = iText;
      int i = str.length();
      if ((paramString.regionMatches(true, paramInt, str, 0, i)) && 
        (!matchesOtherAffix(i, paramString, paramInt))) {
        return paramInt + i;
      }
      return paramInt ^ 0xFFFFFFFF;
    }
    
    public int scan(String paramString, int paramInt)
    {
      String str = iText;
      int i = str.length();
      int j = paramString.length();
      for (int k = paramInt; k < j; k++)
      {
        if ((paramString.regionMatches(true, k, str, 0, i)) && 
          (!matchesOtherAffix(i, paramString, k))) {
          return k;
        }
        switch (paramString.charAt(k))
        {
        case '+': 
        case ',': 
        case '-': 
        case '.': 
        case '0': 
        case '1': 
        case '2': 
        case '3': 
        case '4': 
        case '5': 
        case '6': 
        case '7': 
        case '8': 
        case '9': 
          break;
        case '/': 
        default: 
          break label148;
        }
      }
      label148:
      return paramInt ^ 0xFFFFFFFF;
    }
    
    public String[] getAffixes()
    {
      return new String[] { iText };
    }
  }
  
  static class PluralAffix
    extends PeriodFormatterBuilder.IgnorableAffix
  {
    private final String iSingularText;
    private final String iPluralText;
    
    PluralAffix(String paramString1, String paramString2)
    {
      iSingularText = paramString1;
      iPluralText = paramString2;
    }
    
    public int calculatePrintedLength(int paramInt)
    {
      return (paramInt == 1 ? iSingularText : iPluralText).length();
    }
    
    public void printTo(StringBuffer paramStringBuffer, int paramInt)
    {
      paramStringBuffer.append(paramInt == 1 ? iSingularText : iPluralText);
    }
    
    public void printTo(Writer paramWriter, int paramInt)
      throws IOException
    {
      paramWriter.write(paramInt == 1 ? iSingularText : iPluralText);
    }
    
    public int parse(String paramString, int paramInt)
    {
      Object localObject1 = iPluralText;
      Object localObject2 = iSingularText;
      if (((String)localObject1).length() < ((String)localObject2).length())
      {
        Object localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
      if ((paramString.regionMatches(true, paramInt, (String)localObject1, 0, ((String)localObject1).length())) && 
        (!matchesOtherAffix(((String)localObject1).length(), paramString, paramInt))) {
        return paramInt + ((String)localObject1).length();
      }
      if ((paramString.regionMatches(true, paramInt, (String)localObject2, 0, ((String)localObject2).length())) && 
        (!matchesOtherAffix(((String)localObject2).length(), paramString, paramInt))) {
        return paramInt + ((String)localObject2).length();
      }
      return paramInt ^ 0xFFFFFFFF;
    }
    
    public int scan(String paramString, int paramInt)
    {
      Object localObject1 = iPluralText;
      Object localObject2 = iSingularText;
      if (((String)localObject1).length() < ((String)localObject2).length())
      {
        Object localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
      int i = ((String)localObject1).length();
      int j = ((String)localObject2).length();
      
      int k = paramString.length();
      for (int m = paramInt; m < k; m++)
      {
        if ((paramString.regionMatches(true, m, (String)localObject1, 0, i)) && 
          (!matchesOtherAffix(((String)localObject1).length(), paramString, m))) {
          return m;
        }
        if ((paramString.regionMatches(true, m, (String)localObject2, 0, j)) && 
          (!matchesOtherAffix(((String)localObject2).length(), paramString, m))) {
          return m;
        }
      }
      return paramInt ^ 0xFFFFFFFF;
    }
    
    public String[] getAffixes()
    {
      return new String[] { iSingularText, iPluralText };
    }
  }
  
  static class RegExAffix
    extends PeriodFormatterBuilder.IgnorableAffix
  {
    private static final Comparator<String> LENGTH_DESC_COMPARATOR = new Comparator()
    {
      public int compare(String paramAnonymousString1, String paramAnonymousString2)
      {
        return paramAnonymousString2.length() - paramAnonymousString1.length();
      }
    };
    private final String[] iSuffixes;
    private final Pattern[] iPatterns;
    private final String[] iSuffixesSortedDescByLength;
    
    RegExAffix(String[] paramArrayOfString1, String[] paramArrayOfString2)
    {
      iSuffixes = ((String[])paramArrayOfString2.clone());
      iPatterns = new Pattern[paramArrayOfString1.length];
      for (int i = 0; i < paramArrayOfString1.length; i++)
      {
        Pattern localPattern = (Pattern)PeriodFormatterBuilder.PATTERNS.get(paramArrayOfString1[i]);
        if (localPattern == null)
        {
          localPattern = Pattern.compile(paramArrayOfString1[i]);
          PeriodFormatterBuilder.PATTERNS.putIfAbsent(paramArrayOfString1[i], localPattern);
        }
        iPatterns[i] = localPattern;
      }
      iSuffixesSortedDescByLength = ((String[])iSuffixes.clone());
      Arrays.sort(iSuffixesSortedDescByLength, LENGTH_DESC_COMPARATOR);
    }
    
    private int selectSuffixIndex(int paramInt)
    {
      String str = String.valueOf(paramInt);
      for (int i = 0; i < iPatterns.length; i++) {
        if (iPatterns[i].matcher(str).matches()) {
          return i;
        }
      }
      return iPatterns.length - 1;
    }
    
    public int calculatePrintedLength(int paramInt)
    {
      return iSuffixes[selectSuffixIndex(paramInt)].length();
    }
    
    public void printTo(StringBuffer paramStringBuffer, int paramInt)
    {
      paramStringBuffer.append(iSuffixes[selectSuffixIndex(paramInt)]);
    }
    
    public void printTo(Writer paramWriter, int paramInt)
      throws IOException
    {
      paramWriter.write(iSuffixes[selectSuffixIndex(paramInt)]);
    }
    
    public int parse(String paramString, int paramInt)
    {
      for (String str : iSuffixesSortedDescByLength) {
        if ((paramString.regionMatches(true, paramInt, str, 0, str.length())) && 
          (!matchesOtherAffix(str.length(), paramString, paramInt))) {
          return paramInt + str.length();
        }
      }
      return paramInt ^ 0xFFFFFFFF;
    }
    
    public int scan(String paramString, int paramInt)
    {
      int i = paramString.length();
      for (int j = paramInt; j < i; j++) {
        for (String str : iSuffixesSortedDescByLength) {
          if ((paramString.regionMatches(true, j, str, 0, str.length())) && 
            (!matchesOtherAffix(str.length(), paramString, j))) {
            return j;
          }
        }
      }
      return paramInt ^ 0xFFFFFFFF;
    }
    
    public String[] getAffixes()
    {
      return (String[])iSuffixes.clone();
    }
  }
  
  static class CompositeAffix
    extends PeriodFormatterBuilder.IgnorableAffix
  {
    private final PeriodFormatterBuilder.PeriodFieldAffix iLeft;
    private final PeriodFormatterBuilder.PeriodFieldAffix iRight;
    private final String[] iLeftRightCombinations;
    
    CompositeAffix(PeriodFormatterBuilder.PeriodFieldAffix paramPeriodFieldAffix1, PeriodFormatterBuilder.PeriodFieldAffix paramPeriodFieldAffix2)
    {
      iLeft = paramPeriodFieldAffix1;
      iRight = paramPeriodFieldAffix2;
      
      HashSet localHashSet = new HashSet();
      for (String str1 : iLeft.getAffixes()) {
        for (String str2 : iRight.getAffixes()) {
          localHashSet.add(str1 + str2);
        }
      }
      iLeftRightCombinations = ((String[])localHashSet.toArray(new String[localHashSet.size()]));
    }
    
    public int calculatePrintedLength(int paramInt)
    {
      return iLeft.calculatePrintedLength(paramInt) + iRight.calculatePrintedLength(paramInt);
    }
    
    public void printTo(StringBuffer paramStringBuffer, int paramInt)
    {
      iLeft.printTo(paramStringBuffer, paramInt);
      iRight.printTo(paramStringBuffer, paramInt);
    }
    
    public void printTo(Writer paramWriter, int paramInt)
      throws IOException
    {
      iLeft.printTo(paramWriter, paramInt);
      iRight.printTo(paramWriter, paramInt);
    }
    
    public int parse(String paramString, int paramInt)
    {
      int i = iLeft.parse(paramString, paramInt);
      if (i >= 0)
      {
        i = iRight.parse(paramString, i);
        if ((i >= 0) && (matchesOtherAffix(parse(paramString, i) - i, paramString, paramInt))) {
          return paramInt ^ 0xFFFFFFFF;
        }
      }
      return i;
    }
    
    public int scan(String paramString, int paramInt)
    {
      int i = iLeft.scan(paramString, paramInt);
      if (i >= 0)
      {
        int j = iRight.scan(paramString, iLeft.parse(paramString, i));
        if ((j < 0) || (!matchesOtherAffix(iRight.parse(paramString, j) - i, paramString, paramInt)))
        {
          if (i > 0) {
            return i;
          }
          return j;
        }
      }
      return paramInt ^ 0xFFFFFFFF;
    }
    
    public String[] getAffixes()
    {
      return (String[])iLeftRightCombinations.clone();
    }
  }
  
  static class FieldFormatter
    implements PeriodPrinter, PeriodParser
  {
    private final int iMinPrintedDigits;
    private final int iPrintZeroSetting;
    private final int iMaxParsedDigits;
    private final boolean iRejectSignedValues;
    private final int iFieldType;
    private final FieldFormatter[] iFieldFormatters;
    private final PeriodFormatterBuilder.PeriodFieldAffix iPrefix;
    private final PeriodFormatterBuilder.PeriodFieldAffix iSuffix;
    
    FieldFormatter(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, FieldFormatter[] paramArrayOfFieldFormatter, PeriodFormatterBuilder.PeriodFieldAffix paramPeriodFieldAffix1, PeriodFormatterBuilder.PeriodFieldAffix paramPeriodFieldAffix2)
    {
      iMinPrintedDigits = paramInt1;
      iPrintZeroSetting = paramInt2;
      iMaxParsedDigits = paramInt3;
      iRejectSignedValues = paramBoolean;
      iFieldType = paramInt4;
      iFieldFormatters = paramArrayOfFieldFormatter;
      iPrefix = paramPeriodFieldAffix1;
      iSuffix = paramPeriodFieldAffix2;
    }
    
    FieldFormatter(FieldFormatter paramFieldFormatter, PeriodFormatterBuilder.PeriodFieldAffix paramPeriodFieldAffix)
    {
      iMinPrintedDigits = iMinPrintedDigits;
      iPrintZeroSetting = iPrintZeroSetting;
      iMaxParsedDigits = iMaxParsedDigits;
      iRejectSignedValues = iRejectSignedValues;
      iFieldType = iFieldType;
      iFieldFormatters = iFieldFormatters;
      iPrefix = iPrefix;
      if (iSuffix != null) {
        paramPeriodFieldAffix = new PeriodFormatterBuilder.CompositeAffix(iSuffix, paramPeriodFieldAffix);
      }
      iSuffix = paramPeriodFieldAffix;
    }
    
    public void finish(FieldFormatter[] paramArrayOfFieldFormatter)
    {
      HashSet localHashSet1 = new HashSet();
      HashSet localHashSet2 = new HashSet();
      for (FieldFormatter localFieldFormatter : paramArrayOfFieldFormatter) {
        if ((localFieldFormatter != null) && (!equals(localFieldFormatter)))
        {
          localHashSet1.add(iPrefix);
          localHashSet2.add(iSuffix);
        }
      }
      if (iPrefix != null) {
        iPrefix.finish(localHashSet1);
      }
      if (iSuffix != null) {
        iSuffix.finish(localHashSet2);
      }
    }
    
    public int countFieldsToPrint(ReadablePeriod paramReadablePeriod, int paramInt, Locale paramLocale)
    {
      if (paramInt <= 0) {
        return 0;
      }
      if ((iPrintZeroSetting == 4) || (getFieldValue(paramReadablePeriod) != Long.MAX_VALUE)) {
        return 1;
      }
      return 0;
    }
    
    public int calculatePrintedLength(ReadablePeriod paramReadablePeriod, Locale paramLocale)
    {
      long l = getFieldValue(paramReadablePeriod);
      if (l == Long.MAX_VALUE) {
        return 0;
      }
      int i = Math.max(FormatUtils.calculateDigitCount(l), iMinPrintedDigits);
      if (iFieldType >= 8)
      {
        i = l < 0L ? Math.max(i, 5) : Math.max(i, 4);
        
        i++;
        if ((iFieldType == 9) && (Math.abs(l) % 1000L == 0L)) {
          i -= 4;
        }
        l /= 1000L;
      }
      int j = (int)l;
      if (iPrefix != null) {
        i += iPrefix.calculatePrintedLength(j);
      }
      if (iSuffix != null) {
        i += iSuffix.calculatePrintedLength(j);
      }
      return i;
    }
    
    public void printTo(StringBuffer paramStringBuffer, ReadablePeriod paramReadablePeriod, Locale paramLocale)
    {
      long l = getFieldValue(paramReadablePeriod);
      if (l == Long.MAX_VALUE) {
        return;
      }
      int i = (int)l;
      if (iFieldType >= 8) {
        i = (int)(l / 1000L);
      }
      if (iPrefix != null) {
        iPrefix.printTo(paramStringBuffer, i);
      }
      int j = paramStringBuffer.length();
      int k = iMinPrintedDigits;
      if (k <= 1) {
        FormatUtils.appendUnpaddedInteger(paramStringBuffer, i);
      } else {
        FormatUtils.appendPaddedInteger(paramStringBuffer, i, k);
      }
      if (iFieldType >= 8)
      {
        int m = (int)(Math.abs(l) % 1000L);
        if ((iFieldType == 8) || (m > 0))
        {
          if ((l < 0L) && (l > -1000L)) {
            paramStringBuffer.insert(j, '-');
          }
          paramStringBuffer.append('.');
          FormatUtils.appendPaddedInteger(paramStringBuffer, m, 3);
        }
      }
      if (iSuffix != null) {
        iSuffix.printTo(paramStringBuffer, i);
      }
    }
    
    public void printTo(Writer paramWriter, ReadablePeriod paramReadablePeriod, Locale paramLocale)
      throws IOException
    {
      long l = getFieldValue(paramReadablePeriod);
      if (l == Long.MAX_VALUE) {
        return;
      }
      int i = (int)l;
      if (iFieldType >= 8) {
        i = (int)(l / 1000L);
      }
      if (iPrefix != null) {
        iPrefix.printTo(paramWriter, i);
      }
      int j = iMinPrintedDigits;
      if (j <= 1) {
        FormatUtils.writeUnpaddedInteger(paramWriter, i);
      } else {
        FormatUtils.writePaddedInteger(paramWriter, i, j);
      }
      if (iFieldType >= 8)
      {
        int k = (int)(Math.abs(l) % 1000L);
        if ((iFieldType == 8) || (k > 0))
        {
          paramWriter.write(46);
          FormatUtils.writePaddedInteger(paramWriter, k, 3);
        }
      }
      if (iSuffix != null) {
        iSuffix.printTo(paramWriter, i);
      }
    }
    
    public int parseInto(ReadWritablePeriod paramReadWritablePeriod, String paramString, int paramInt, Locale paramLocale)
    {
      int i = iPrintZeroSetting == 4 ? 1 : 0;
      if (paramInt >= paramString.length()) {
        return i != 0 ? paramInt ^ 0xFFFFFFFF : paramInt;
      }
      if (iPrefix != null)
      {
        paramInt = iPrefix.parse(paramString, paramInt);
        if (paramInt >= 0)
        {
          i = 1;
        }
        else
        {
          if (i == 0) {
            return paramInt ^ 0xFFFFFFFF;
          }
          return paramInt;
        }
      }
      int j = -1;
      if ((iSuffix != null) && (i == 0))
      {
        j = iSuffix.scan(paramString, paramInt);
        if (j >= 0)
        {
          i = 1;
        }
        else
        {
          if (i == 0) {
            return j ^ 0xFFFFFFFF;
          }
          return j;
        }
      }
      if ((i == 0) && (!isSupported(paramReadWritablePeriod.getPeriodType(), iFieldType))) {
        return paramInt;
      }
      int k;
      if (j > 0) {
        k = Math.min(iMaxParsedDigits, j - paramInt);
      } else {
        k = Math.min(iMaxParsedDigits, paramString.length() - paramInt);
      }
      int m = 0;
      int n = -1;
      int i1 = 0;
      int i2 = 0;
      int i3;
      while (m < k)
      {
        i3 = paramString.charAt(paramInt + m);
        if ((m == 0) && ((i3 == 45) || (i3 == 43)) && (!iRejectSignedValues))
        {
          i2 = i3 == 45 ? 1 : 0;
          if ((m + 1 >= k) || ((i3 = paramString.charAt(paramInt + m + 1)) < '0') || (i3 > 57)) {
            break;
          }
          if (i2 != 0) {
            m++;
          } else {
            paramInt++;
          }
          k = Math.min(k + 1, paramString.length() - paramInt);
        }
        else
        {
          if ((i3 >= 48) && (i3 <= 57))
          {
            i1 = 1;
          }
          else
          {
            if (((i3 != 46) && (i3 != 44)) || ((iFieldType != 8) && (iFieldType != 9))) {
              break;
            }
            if (n >= 0) {
              break;
            }
            n = paramInt + m + 1;
            
            k = Math.min(k + 1, paramString.length() - paramInt);
          }
          m++;
        }
      }
      if (i1 == 0) {
        return paramInt ^ 0xFFFFFFFF;
      }
      if ((j >= 0) && (paramInt + m != j)) {
        return paramInt;
      }
      if ((iFieldType != 8) && (iFieldType != 9))
      {
        setFieldValue(paramReadWritablePeriod, iFieldType, parseInt(paramString, paramInt, m));
      }
      else if (n < 0)
      {
        setFieldValue(paramReadWritablePeriod, 6, parseInt(paramString, paramInt, m));
        setFieldValue(paramReadWritablePeriod, 7, 0);
      }
      else
      {
        i3 = parseInt(paramString, paramInt, n - paramInt - 1);
        setFieldValue(paramReadWritablePeriod, 6, i3);
        
        int i4 = paramInt + m - n;
        int i5;
        if (i4 <= 0)
        {
          i5 = 0;
        }
        else
        {
          if (i4 >= 3)
          {
            i5 = parseInt(paramString, n, 3);
          }
          else
          {
            i5 = parseInt(paramString, n, i4);
            if (i4 == 1) {
              i5 *= 100;
            } else {
              i5 *= 10;
            }
          }
          if ((i2 != 0) || (i3 < 0)) {
            i5 = -i5;
          }
        }
        setFieldValue(paramReadWritablePeriod, 7, i5);
      }
      paramInt += m;
      if ((paramInt >= 0) && (iSuffix != null)) {
        paramInt = iSuffix.parse(paramString, paramInt);
      }
      return paramInt;
    }
    
    private int parseInt(String paramString, int paramInt1, int paramInt2)
    {
      if (paramInt2 >= 10) {
        return Integer.parseInt(paramString.substring(paramInt1, paramInt1 + paramInt2));
      }
      if (paramInt2 <= 0) {
        return 0;
      }
      int i = paramString.charAt(paramInt1++);
      paramInt2--;
      int j;
      if (i == 45)
      {
        paramInt2--;
        if (paramInt2 < 0) {
          return 0;
        }
        j = 1;
        i = paramString.charAt(paramInt1++);
      }
      else
      {
        j = 0;
      }
      i -= 48;
      while (paramInt2-- > 0) {
        i = (i << 3) + (i << 1) + paramString.charAt(paramInt1++) - 48;
      }
      return j != 0 ? -i : i;
    }
    
    long getFieldValue(ReadablePeriod paramReadablePeriod)
    {
      PeriodType localPeriodType;
      if (iPrintZeroSetting == 4) {
        localPeriodType = null;
      } else {
        localPeriodType = paramReadablePeriod.getPeriodType();
      }
      if ((localPeriodType != null) && (!isSupported(localPeriodType, iFieldType))) {
        return Long.MAX_VALUE;
      }
      long l;
      int i;
      switch (iFieldType)
      {
      default: 
        return Long.MAX_VALUE;
      case 0: 
        l = paramReadablePeriod.get(DurationFieldType.years());
        break;
      case 1: 
        l = paramReadablePeriod.get(DurationFieldType.months());
        break;
      case 2: 
        l = paramReadablePeriod.get(DurationFieldType.weeks());
        break;
      case 3: 
        l = paramReadablePeriod.get(DurationFieldType.days());
        break;
      case 4: 
        l = paramReadablePeriod.get(DurationFieldType.hours());
        break;
      case 5: 
        l = paramReadablePeriod.get(DurationFieldType.minutes());
        break;
      case 6: 
        l = paramReadablePeriod.get(DurationFieldType.seconds());
        break;
      case 7: 
        l = paramReadablePeriod.get(DurationFieldType.millis());
        break;
      case 8: 
      case 9: 
        i = paramReadablePeriod.get(DurationFieldType.seconds());
        int j = paramReadablePeriod.get(DurationFieldType.millis());
        l = i * 1000L + j;
      }
      if (l == 0L) {
        switch (iPrintZeroSetting)
        {
        case 5: 
          return Long.MAX_VALUE;
        case 2: 
          if ((isZero(paramReadablePeriod)) && (iFieldFormatters[iFieldType] == this)) {
            for (i = iFieldType + 1; i <= 9; i++) {
              if ((isSupported(localPeriodType, i)) && (iFieldFormatters[i] != null)) {
                return Long.MAX_VALUE;
              }
            }
          } else {
            return Long.MAX_VALUE;
          }
          break;
        case 1: 
          if ((isZero(paramReadablePeriod)) && (iFieldFormatters[iFieldType] == this))
          {
            i = Math.min(iFieldType, 8);
            i--;
            for (; (i >= 0) && (i <= 9); i--) {
              if ((isSupported(localPeriodType, i)) && (iFieldFormatters[i] != null)) {
                return Long.MAX_VALUE;
              }
            }
          }
          else
          {
            return Long.MAX_VALUE;
          }
          break;
        }
      }
      return l;
    }
    
    boolean isZero(ReadablePeriod paramReadablePeriod)
    {
      int i = 0;
      for (int j = paramReadablePeriod.size(); i < j; i++) {
        if (paramReadablePeriod.getValue(i) != 0) {
          return false;
        }
      }
      return true;
    }
    
    boolean isSupported(PeriodType paramPeriodType, int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return false;
      case 0: 
        return paramPeriodType.isSupported(DurationFieldType.years());
      case 1: 
        return paramPeriodType.isSupported(DurationFieldType.months());
      case 2: 
        return paramPeriodType.isSupported(DurationFieldType.weeks());
      case 3: 
        return paramPeriodType.isSupported(DurationFieldType.days());
      case 4: 
        return paramPeriodType.isSupported(DurationFieldType.hours());
      case 5: 
        return paramPeriodType.isSupported(DurationFieldType.minutes());
      case 6: 
        return paramPeriodType.isSupported(DurationFieldType.seconds());
      case 7: 
        return paramPeriodType.isSupported(DurationFieldType.millis());
      }
      return (paramPeriodType.isSupported(DurationFieldType.seconds())) || (paramPeriodType.isSupported(DurationFieldType.millis()));
    }
    
    void setFieldValue(ReadWritablePeriod paramReadWritablePeriod, int paramInt1, int paramInt2)
    {
      switch (paramInt1)
      {
      default: 
        break;
      case 0: 
        paramReadWritablePeriod.setYears(paramInt2);
        break;
      case 1: 
        paramReadWritablePeriod.setMonths(paramInt2);
        break;
      case 2: 
        paramReadWritablePeriod.setWeeks(paramInt2);
        break;
      case 3: 
        paramReadWritablePeriod.setDays(paramInt2);
        break;
      case 4: 
        paramReadWritablePeriod.setHours(paramInt2);
        break;
      case 5: 
        paramReadWritablePeriod.setMinutes(paramInt2);
        break;
      case 6: 
        paramReadWritablePeriod.setSeconds(paramInt2);
        break;
      case 7: 
        paramReadWritablePeriod.setMillis(paramInt2);
      }
    }
    
    int getFieldType()
    {
      return iFieldType;
    }
  }
  
  static class Literal
    implements PeriodPrinter, PeriodParser
  {
    static final Literal EMPTY = new Literal("");
    private final String iText;
    
    Literal(String paramString)
    {
      iText = paramString;
    }
    
    public int countFieldsToPrint(ReadablePeriod paramReadablePeriod, int paramInt, Locale paramLocale)
    {
      return 0;
    }
    
    public int calculatePrintedLength(ReadablePeriod paramReadablePeriod, Locale paramLocale)
    {
      return iText.length();
    }
    
    public void printTo(StringBuffer paramStringBuffer, ReadablePeriod paramReadablePeriod, Locale paramLocale)
    {
      paramStringBuffer.append(iText);
    }
    
    public void printTo(Writer paramWriter, ReadablePeriod paramReadablePeriod, Locale paramLocale)
      throws IOException
    {
      paramWriter.write(iText);
    }
    
    public int parseInto(ReadWritablePeriod paramReadWritablePeriod, String paramString, int paramInt, Locale paramLocale)
    {
      if (paramString.regionMatches(true, paramInt, iText, 0, iText.length())) {
        return paramInt + iText.length();
      }
      return paramInt ^ 0xFFFFFFFF;
    }
  }
  
  static class Separator
    implements PeriodPrinter, PeriodParser
  {
    private final String iText;
    private final String iFinalText;
    private final String[] iParsedForms;
    private final boolean iUseBefore;
    private final boolean iUseAfter;
    private final PeriodPrinter iBeforePrinter;
    private volatile PeriodPrinter iAfterPrinter;
    private final PeriodParser iBeforeParser;
    private volatile PeriodParser iAfterParser;
    
    Separator(String paramString1, String paramString2, String[] paramArrayOfString, PeriodPrinter paramPeriodPrinter, PeriodParser paramPeriodParser, boolean paramBoolean1, boolean paramBoolean2)
    {
      iText = paramString1;
      iFinalText = paramString2;
      if (((paramString2 == null) || (paramString1.equals(paramString2))) && ((paramArrayOfString == null) || (paramArrayOfString.length == 0)))
      {
        iParsedForms = new String[] { paramString1 };
      }
      else
      {
        TreeSet localTreeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        localTreeSet.add(paramString1);
        localTreeSet.add(paramString2);
        if (paramArrayOfString != null)
        {
          int i = paramArrayOfString.length;
          for (;;)
          {
            i--;
            if (i < 0) {
              break;
            }
            localTreeSet.add(paramArrayOfString[i]);
          }
        }
        ArrayList localArrayList = new ArrayList(localTreeSet);
        Collections.reverse(localArrayList);
        iParsedForms = ((String[])localArrayList.toArray(new String[localArrayList.size()]));
      }
      iBeforePrinter = paramPeriodPrinter;
      iBeforeParser = paramPeriodParser;
      iUseBefore = paramBoolean1;
      iUseAfter = paramBoolean2;
    }
    
    public int countFieldsToPrint(ReadablePeriod paramReadablePeriod, int paramInt, Locale paramLocale)
    {
      int i = iBeforePrinter.countFieldsToPrint(paramReadablePeriod, paramInt, paramLocale);
      if (i < paramInt) {
        i += iAfterPrinter.countFieldsToPrint(paramReadablePeriod, paramInt, paramLocale);
      }
      return i;
    }
    
    public int calculatePrintedLength(ReadablePeriod paramReadablePeriod, Locale paramLocale)
    {
      PeriodPrinter localPeriodPrinter1 = iBeforePrinter;
      PeriodPrinter localPeriodPrinter2 = iAfterPrinter;
      
      int i = localPeriodPrinter1.calculatePrintedLength(paramReadablePeriod, paramLocale) + localPeriodPrinter2.calculatePrintedLength(paramReadablePeriod, paramLocale);
      if (iUseBefore)
      {
        if (localPeriodPrinter1.countFieldsToPrint(paramReadablePeriod, 1, paramLocale) > 0) {
          if (iUseAfter)
          {
            int j = localPeriodPrinter2.countFieldsToPrint(paramReadablePeriod, 2, paramLocale);
            if (j > 0) {
              i += (j > 1 ? iText : iFinalText).length();
            }
          }
          else
          {
            i += iText.length();
          }
        }
      }
      else if ((iUseAfter) && (localPeriodPrinter2.countFieldsToPrint(paramReadablePeriod, 1, paramLocale) > 0)) {
        i += iText.length();
      }
      return i;
    }
    
    public void printTo(StringBuffer paramStringBuffer, ReadablePeriod paramReadablePeriod, Locale paramLocale)
    {
      PeriodPrinter localPeriodPrinter1 = iBeforePrinter;
      PeriodPrinter localPeriodPrinter2 = iAfterPrinter;
      
      localPeriodPrinter1.printTo(paramStringBuffer, paramReadablePeriod, paramLocale);
      if (iUseBefore)
      {
        if (localPeriodPrinter1.countFieldsToPrint(paramReadablePeriod, 1, paramLocale) > 0) {
          if (iUseAfter)
          {
            int i = localPeriodPrinter2.countFieldsToPrint(paramReadablePeriod, 2, paramLocale);
            if (i > 0) {
              paramStringBuffer.append(i > 1 ? iText : iFinalText);
            }
          }
          else
          {
            paramStringBuffer.append(iText);
          }
        }
      }
      else if ((iUseAfter) && (localPeriodPrinter2.countFieldsToPrint(paramReadablePeriod, 1, paramLocale) > 0)) {
        paramStringBuffer.append(iText);
      }
      localPeriodPrinter2.printTo(paramStringBuffer, paramReadablePeriod, paramLocale);
    }
    
    public void printTo(Writer paramWriter, ReadablePeriod paramReadablePeriod, Locale paramLocale)
      throws IOException
    {
      PeriodPrinter localPeriodPrinter1 = iBeforePrinter;
      PeriodPrinter localPeriodPrinter2 = iAfterPrinter;
      
      localPeriodPrinter1.printTo(paramWriter, paramReadablePeriod, paramLocale);
      if (iUseBefore)
      {
        if (localPeriodPrinter1.countFieldsToPrint(paramReadablePeriod, 1, paramLocale) > 0) {
          if (iUseAfter)
          {
            int i = localPeriodPrinter2.countFieldsToPrint(paramReadablePeriod, 2, paramLocale);
            if (i > 0) {
              paramWriter.write(i > 1 ? iText : iFinalText);
            }
          }
          else
          {
            paramWriter.write(iText);
          }
        }
      }
      else if ((iUseAfter) && (localPeriodPrinter2.countFieldsToPrint(paramReadablePeriod, 1, paramLocale) > 0)) {
        paramWriter.write(iText);
      }
      localPeriodPrinter2.printTo(paramWriter, paramReadablePeriod, paramLocale);
    }
    
    public int parseInto(ReadWritablePeriod paramReadWritablePeriod, String paramString, int paramInt, Locale paramLocale)
    {
      int i = paramInt;
      paramInt = iBeforeParser.parseInto(paramReadWritablePeriod, paramString, paramInt, paramLocale);
      if (paramInt < 0) {
        return paramInt;
      }
      int j = 0;
      int k = -1;
      if (paramInt > i)
      {
        String[] arrayOfString = iParsedForms;
        int m = arrayOfString.length;
        for (int n = 0; n < m; n++)
        {
          String str = arrayOfString[n];
          if ((str == null) || (str.length() == 0) || (paramString.regionMatches(true, paramInt, str, 0, str.length())))
          {
            k = str == null ? 0 : str.length();
            paramInt += k;
            j = 1;
            break;
          }
        }
      }
      i = paramInt;
      paramInt = iAfterParser.parseInto(paramReadWritablePeriod, paramString, paramInt, paramLocale);
      if (paramInt < 0) {
        return paramInt;
      }
      if ((j != 0) && (paramInt == i) && (k > 0)) {
        return i ^ 0xFFFFFFFF;
      }
      if ((paramInt > i) && (j == 0) && (!iUseBefore)) {
        return i ^ 0xFFFFFFFF;
      }
      return paramInt;
    }
    
    Separator finish(PeriodPrinter paramPeriodPrinter, PeriodParser paramPeriodParser)
    {
      iAfterPrinter = paramPeriodPrinter;
      iAfterParser = paramPeriodParser;
      return this;
    }
  }
  
  static class Composite
    implements PeriodPrinter, PeriodParser
  {
    private final PeriodPrinter[] iPrinters;
    private final PeriodParser[] iParsers;
    
    Composite(List<Object> paramList)
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.PeriodFormatterBuilder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */