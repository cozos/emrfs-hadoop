package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;

class DateTimeFormatterBuilder$FixedNumber
  extends DateTimeFormatterBuilder.PaddedNumber
{
  protected DateTimeFormatterBuilder$FixedNumber(DateTimeFieldType paramDateTimeFieldType, int paramInt, boolean paramBoolean)
  {
    super(paramDateTimeFieldType, paramInt, paramBoolean, paramInt);
  }
  
  public int parseInto(DateTimeParserBucket paramDateTimeParserBucket, CharSequence paramCharSequence, int paramInt)
  {
    int i = super.parseInto(paramDateTimeParserBucket, paramCharSequence, paramInt);
    if (i < 0) {
      return i;
    }
    int j = paramInt + iMaxParsedDigits;
    if (i != j)
    {
      if (iSigned)
      {
        int k = paramCharSequence.charAt(paramInt);
        if ((k == 45) || (k == 43)) {
          j++;
        }
      }
      if (i > j) {
        return j + 1 ^ 0xFFFFFFFF;
      }
      if (i < j) {
        return i ^ 0xFFFFFFFF;
      }
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatterBuilder.FixedNumber
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */