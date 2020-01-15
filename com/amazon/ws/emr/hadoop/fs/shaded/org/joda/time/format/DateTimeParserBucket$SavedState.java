package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;

class DateTimeParserBucket$SavedState
{
  final DateTimeZone iZone;
  final Integer iOffset;
  final DateTimeParserBucket.SavedField[] iSavedFields;
  final int iSavedFieldsCount;
  
  DateTimeParserBucket$SavedState(DateTimeParserBucket paramDateTimeParserBucket)
  {
    iZone = DateTimeParserBucket.access$000(paramDateTimeParserBucket);
    iOffset = DateTimeParserBucket.access$100(paramDateTimeParserBucket);
    iSavedFields = DateTimeParserBucket.access$200(paramDateTimeParserBucket);
    iSavedFieldsCount = DateTimeParserBucket.access$300(paramDateTimeParserBucket);
  }
  
  boolean restoreState(DateTimeParserBucket paramDateTimeParserBucket)
  {
    if (paramDateTimeParserBucket != this$0) {
      return false;
    }
    DateTimeParserBucket.access$002(paramDateTimeParserBucket, iZone);
    DateTimeParserBucket.access$102(paramDateTimeParserBucket, iOffset);
    DateTimeParserBucket.access$202(paramDateTimeParserBucket, iSavedFields);
    if (iSavedFieldsCount < DateTimeParserBucket.access$300(paramDateTimeParserBucket)) {
      DateTimeParserBucket.access$402(paramDateTimeParserBucket, true);
    }
    DateTimeParserBucket.access$302(paramDateTimeParserBucket, iSavedFieldsCount);
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeParserBucket.SavedState
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */