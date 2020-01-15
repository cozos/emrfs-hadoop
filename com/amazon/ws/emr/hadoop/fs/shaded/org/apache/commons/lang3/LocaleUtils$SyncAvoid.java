package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

class LocaleUtils$SyncAvoid
{
  private static final List<Locale> AVAILABLE_LOCALE_LIST;
  private static final Set<Locale> AVAILABLE_LOCALE_SET;
  
  static
  {
    List<Locale> list = new ArrayList(Arrays.asList(Locale.getAvailableLocales()));
    AVAILABLE_LOCALE_LIST = Collections.unmodifiableList(list);
    AVAILABLE_LOCALE_SET = Collections.unmodifiableSet(new HashSet(list));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.LocaleUtils.SyncAvoid
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */