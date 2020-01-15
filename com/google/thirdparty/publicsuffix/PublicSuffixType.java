package com.google.thirdparty.publicsuffix;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;

@GwtCompatible
 enum PublicSuffixType
{
  PRIVATE(':', ','),  ICANN('!', '?');
  
  private final char innerNodeCode;
  private final char leafNodeCode;
  
  private PublicSuffixType(char innerNodeCode, char leafNodeCode)
  {
    this.innerNodeCode = innerNodeCode;
    this.leafNodeCode = leafNodeCode;
  }
  
  char getLeafNodeCode()
  {
    return leafNodeCode;
  }
  
  char getInnerNodeCode()
  {
    return innerNodeCode;
  }
  
  static PublicSuffixType fromCode(char code)
  {
    for (PublicSuffixType value : ) {
      if ((value.getInnerNodeCode() == code) || (value.getLeafNodeCode() == code)) {
        return value;
      }
    }
    ??? = code;throw new IllegalArgumentException(38 + "No enum corresponding to given code: " + ???);
  }
  
  static PublicSuffixType fromIsPrivate(boolean isPrivate)
  {
    return isPrivate ? PRIVATE : ICANN;
  }
}

/* Location:
 * Qualified Name:     com.google.thirdparty.publicsuffix.PublicSuffixType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */