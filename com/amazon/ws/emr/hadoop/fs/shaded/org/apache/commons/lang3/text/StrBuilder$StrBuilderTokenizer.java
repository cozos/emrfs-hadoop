package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.text;

import java.util.List;

class StrBuilder$StrBuilderTokenizer
  extends StrTokenizer
{
  StrBuilder$StrBuilderTokenizer(StrBuilder paramStrBuilder) {}
  
  protected List<String> tokenize(char[] chars, int offset, int count)
  {
    if (chars == null) {
      return super.tokenize(this$0.buffer, 0, this$0.size());
    }
    return super.tokenize(chars, offset, count);
  }
  
  public String getContent()
  {
    String str = super.getContent();
    if (str == null) {
      return this$0.toString();
    }
    return str;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.text.StrBuilder.StrBuilderTokenizer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */