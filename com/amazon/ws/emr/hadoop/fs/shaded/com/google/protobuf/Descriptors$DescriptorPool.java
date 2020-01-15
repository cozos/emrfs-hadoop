package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

final class Descriptors$DescriptorPool
{
  private final Set<Descriptors.FileDescriptor> dependencies;
  
  static enum SearchFilter
  {
    TYPES_ONLY,  AGGREGATES_ONLY,  ALL_SYMBOLS;
    
    private SearchFilter() {}
  }
  
  Descriptors$DescriptorPool(Descriptors.FileDescriptor[] dependencies)
  {
    this.dependencies = new HashSet();
    for (int i = 0; i < dependencies.length; i++)
    {
      this.dependencies.add(dependencies[i]);
      importPublicDependencies(dependencies[i]);
    }
    for (Descriptors.FileDescriptor dependency : this.dependencies) {
      try
      {
        addPackage(dependency.getPackage(), dependency);
      }
      catch (Descriptors.DescriptorValidationException e)
      {
        if (!$assertionsDisabled) {
          throw new AssertionError();
        }
      }
    }
  }
  
  private void importPublicDependencies(Descriptors.FileDescriptor file)
  {
    for (Descriptors.FileDescriptor dependency : file.getPublicDependencies()) {
      if (dependencies.add(dependency)) {
        importPublicDependencies(dependency);
      }
    }
  }
  
  private final Map<String, Descriptors.GenericDescriptor> descriptorsByName = new HashMap();
  private final Map<DescriptorIntPair, Descriptors.FieldDescriptor> fieldsByNumber = new HashMap();
  private final Map<DescriptorIntPair, Descriptors.EnumValueDescriptor> enumValuesByNumber = new HashMap();
  
  Descriptors.GenericDescriptor findSymbol(String fullName)
  {
    return findSymbol(fullName, SearchFilter.ALL_SYMBOLS);
  }
  
  Descriptors.GenericDescriptor findSymbol(String fullName, SearchFilter filter)
  {
    Descriptors.GenericDescriptor result = (Descriptors.GenericDescriptor)descriptorsByName.get(fullName);
    if ((result != null) && (
      (filter == SearchFilter.ALL_SYMBOLS) || ((filter == SearchFilter.TYPES_ONLY) && (isType(result))) || ((filter == SearchFilter.AGGREGATES_ONLY) && (isAggregate(result))))) {
      return result;
    }
    for (Descriptors.FileDescriptor dependency : dependencies)
    {
      result = (Descriptors.GenericDescriptor)access$1200descriptorsByName.get(fullName);
      if ((result != null) && (
        (filter == SearchFilter.ALL_SYMBOLS) || ((filter == SearchFilter.TYPES_ONLY) && (isType(result))) || ((filter == SearchFilter.AGGREGATES_ONLY) && (isAggregate(result))))) {
        return result;
      }
    }
    return null;
  }
  
  boolean isType(Descriptors.GenericDescriptor descriptor)
  {
    return ((descriptor instanceof Descriptors.Descriptor)) || ((descriptor instanceof Descriptors.EnumDescriptor));
  }
  
  boolean isAggregate(Descriptors.GenericDescriptor descriptor)
  {
    return ((descriptor instanceof Descriptors.Descriptor)) || ((descriptor instanceof Descriptors.EnumDescriptor)) || ((descriptor instanceof PackageDescriptor)) || ((descriptor instanceof Descriptors.ServiceDescriptor));
  }
  
  Descriptors.GenericDescriptor lookupSymbol(String name, Descriptors.GenericDescriptor relativeTo, SearchFilter filter)
    throws Descriptors.DescriptorValidationException
  {
    Descriptors.GenericDescriptor result;
    Descriptors.GenericDescriptor result;
    if (name.startsWith("."))
    {
      result = findSymbol(name.substring(1), filter);
    }
    else
    {
      int firstPartLength = name.indexOf('.');
      String firstPart;
      String firstPart;
      if (firstPartLength == -1) {
        firstPart = name;
      } else {
        firstPart = name.substring(0, firstPartLength);
      }
      StringBuilder scopeToTry = new StringBuilder(relativeTo.getFullName());
      for (;;)
      {
        int dotpos = scopeToTry.lastIndexOf(".");
        if (dotpos == -1)
        {
          Descriptors.GenericDescriptor result = findSymbol(name, filter);
          break;
        }
        scopeToTry.setLength(dotpos + 1);
        
        scopeToTry.append(firstPart);
        result = findSymbol(scopeToTry.toString(), SearchFilter.AGGREGATES_ONLY);
        if (result != null)
        {
          if (firstPartLength == -1) {
            break;
          }
          scopeToTry.setLength(dotpos + 1);
          scopeToTry.append(name);
          result = findSymbol(scopeToTry.toString(), filter); break;
        }
        scopeToTry.setLength(dotpos);
      }
    }
    if (result == null) {
      throw new Descriptors.DescriptorValidationException(relativeTo, '"' + name + "\" is not defined.", null);
    }
    return result;
  }
  
  void addSymbol(Descriptors.GenericDescriptor descriptor)
    throws Descriptors.DescriptorValidationException
  {
    validateSymbolName(descriptor);
    
    String fullName = descriptor.getFullName();
    int dotpos = fullName.lastIndexOf('.');
    
    Descriptors.GenericDescriptor old = (Descriptors.GenericDescriptor)descriptorsByName.put(fullName, descriptor);
    if (old != null)
    {
      descriptorsByName.put(fullName, old);
      if (descriptor.getFile() == old.getFile())
      {
        if (dotpos == -1) {
          throw new Descriptors.DescriptorValidationException(descriptor, '"' + fullName + "\" is already defined.", null);
        }
        throw new Descriptors.DescriptorValidationException(descriptor, '"' + fullName.substring(dotpos + 1) + "\" is already defined in \"" + fullName.substring(0, dotpos) + "\".", null);
      }
      throw new Descriptors.DescriptorValidationException(descriptor, '"' + fullName + "\" is already defined in file \"" + old.getFile().getName() + "\".", null);
    }
  }
  
  private static final class PackageDescriptor
    implements Descriptors.GenericDescriptor
  {
    private final String name;
    private final String fullName;
    private final Descriptors.FileDescriptor file;
    
    public Message toProto()
    {
      return file.toProto();
    }
    
    public String getName()
    {
      return name;
    }
    
    public String getFullName()
    {
      return fullName;
    }
    
    public Descriptors.FileDescriptor getFile()
    {
      return file;
    }
    
    PackageDescriptor(String name, String fullName, Descriptors.FileDescriptor file)
    {
      this.file = file;
      this.fullName = fullName;
      this.name = name;
    }
  }
  
  void addPackage(String fullName, Descriptors.FileDescriptor file)
    throws Descriptors.DescriptorValidationException
  {
    int dotpos = fullName.lastIndexOf('.');
    String name;
    String name;
    if (dotpos == -1)
    {
      name = fullName;
    }
    else
    {
      addPackage(fullName.substring(0, dotpos), file);
      name = fullName.substring(dotpos + 1);
    }
    Descriptors.GenericDescriptor old = (Descriptors.GenericDescriptor)descriptorsByName.put(fullName, new PackageDescriptor(name, fullName, file));
    if (old != null)
    {
      descriptorsByName.put(fullName, old);
      if (!(old instanceof PackageDescriptor)) {
        throw new Descriptors.DescriptorValidationException(file, '"' + name + "\" is already defined (as something other than a " + "package) in file \"" + old.getFile().getName() + "\".", null);
      }
    }
  }
  
  private static final class DescriptorIntPair
  {
    private final Descriptors.GenericDescriptor descriptor;
    private final int number;
    
    DescriptorIntPair(Descriptors.GenericDescriptor descriptor, int number)
    {
      this.descriptor = descriptor;
      this.number = number;
    }
    
    public int hashCode()
    {
      return descriptor.hashCode() * 65535 + number;
    }
    
    public boolean equals(Object obj)
    {
      if (!(obj instanceof DescriptorIntPair)) {
        return false;
      }
      DescriptorIntPair other = (DescriptorIntPair)obj;
      return (descriptor == descriptor) && (number == number);
    }
  }
  
  void addFieldByNumber(Descriptors.FieldDescriptor field)
    throws Descriptors.DescriptorValidationException
  {
    DescriptorIntPair key = new DescriptorIntPair(field.getContainingType(), field.getNumber());
    
    Descriptors.FieldDescriptor old = (Descriptors.FieldDescriptor)fieldsByNumber.put(key, field);
    if (old != null)
    {
      fieldsByNumber.put(key, old);
      throw new Descriptors.DescriptorValidationException(field, "Field number " + field.getNumber() + "has already been used in \"" + field.getContainingType().getFullName() + "\" by field \"" + old.getName() + "\".", null);
    }
  }
  
  void addEnumValueByNumber(Descriptors.EnumValueDescriptor value)
  {
    DescriptorIntPair key = new DescriptorIntPair(value.getType(), value.getNumber());
    
    Descriptors.EnumValueDescriptor old = (Descriptors.EnumValueDescriptor)enumValuesByNumber.put(key, value);
    if (old != null) {
      enumValuesByNumber.put(key, old);
    }
  }
  
  static void validateSymbolName(Descriptors.GenericDescriptor descriptor)
    throws Descriptors.DescriptorValidationException
  {
    String name = descriptor.getName();
    if (name.length() == 0) {
      throw new Descriptors.DescriptorValidationException(descriptor, "Missing name.", null);
    }
    boolean valid = true;
    for (int i = 0; i < name.length(); i++)
    {
      char c = name.charAt(i);
      if (c >= '') {
        valid = false;
      }
      if ((!Character.isLetter(c)) && (c != '_') && ((!Character.isDigit(c)) || (i <= 0))) {
        valid = false;
      }
    }
    if (!valid) {
      throw new Descriptors.DescriptorValidationException(descriptor, '"' + name + "\" is not a valid identifier.", null);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.Descriptors.DescriptorPool
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */