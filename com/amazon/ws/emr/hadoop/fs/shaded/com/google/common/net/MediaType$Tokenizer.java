package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.net;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.CharMatcher;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;

final class MediaType$Tokenizer
{
  final String input;
  int position = 0;
  
  MediaType$Tokenizer(String input)
  {
    this.input = input;
  }
  
  String consumeTokenIfPresent(CharMatcher matcher)
  {
    Preconditions.checkState(hasMore());
    int startPosition = position;
    position = matcher.negate().indexIn(input, startPosition);
    return hasMore() ? input.substring(startPosition, position) : input.substring(startPosition);
  }
  
  String consumeToken(CharMatcher matcher)
  {
    int startPosition = position;
    String token = consumeTokenIfPresent(matcher);
    Preconditions.checkState(position != startPosition);
    return token;
  }
  
  char consumeCharacter(CharMatcher matcher)
  {
    Preconditions.checkState(hasMore());
    char c = previewChar();
    Preconditions.checkState(matcher.matches(c));
    position += 1;
    return c;
  }
  
  char consumeCharacter(char c)
  {
    Preconditions.checkState(hasMore());
    Preconditions.checkState(previewChar() == c);
    position += 1;
    return c;
  }
  
  char previewChar()
  {
    Preconditions.checkState(hasMore());
    return input.charAt(position);
  }
  
  boolean hasMore()
  {
    return (position >= 0) && (position < input.length());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.net.MediaType.Tokenizer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */