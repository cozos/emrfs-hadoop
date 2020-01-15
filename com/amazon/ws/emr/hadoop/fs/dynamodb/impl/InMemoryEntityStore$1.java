package com.amazon.ws.emr.hadoop.fs.dynamodb.impl;

import com.amazon.ws.emr.hadoop.fs.dynamodb.Entity;
import com.amazon.ws.emr.hadoop.fs.dynamodb.ItemKey;
import com.amazon.ws.emr.hadoop.fs.dynamodb.ItemKeyCondition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Strings;

class InMemoryEntityStore$1
  implements Predicate<Entity>
{
  InMemoryEntityStore$1(InMemoryEntityStore this$0, ItemKeyCondition paramItemKeyCondition, String paramString1, String paramString2) {}
  
  public boolean apply(Entity input)
  {
    ItemKey itemKey = input.getItemKey();
    switch (InMemoryEntityStore.2.$SwitchMap$com$amazon$ws$emr$hadoop$fs$dynamodb$Condition[val$condition.getCondition().ordinal()])
    {
    case 1: 
      if ((!Strings.isNullOrEmpty(val$conditionalRangeKey)) && (!itemKey.getRangeKey().startsWith(val$conditionalRangeKey))) {
        return false;
      }
      return itemKey.getHashKey().startsWith(val$conditionalHashKey);
    case 2: 
      if ((!Strings.isNullOrEmpty(val$conditionalRangeKey)) && (!itemKey.getRangeKey().equals(val$conditionalRangeKey))) {
        return false;
      }
      return itemKey.getHashKey().equals(val$conditionalHashKey);
    }
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.dynamodb.impl.InMemoryEntityStore.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */