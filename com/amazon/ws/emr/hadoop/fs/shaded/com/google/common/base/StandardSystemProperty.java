package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible("java.lang.System#getProperty")
public enum StandardSystemProperty
{
  JAVA_VERSION("java.version"),  JAVA_VENDOR("java.vendor"),  JAVA_VENDOR_URL("java.vendor.url"),  JAVA_HOME("java.home"),  JAVA_VM_SPECIFICATION_VERSION("java.vm.specification.version"),  JAVA_VM_SPECIFICATION_VENDOR("java.vm.specification.vendor"),  JAVA_VM_SPECIFICATION_NAME("java.vm.specification.name"),  JAVA_VM_VERSION("java.vm.version"),  JAVA_VM_VENDOR("java.vm.vendor"),  JAVA_VM_NAME("java.vm.name"),  JAVA_SPECIFICATION_VERSION("java.specification.version"),  JAVA_SPECIFICATION_VENDOR("java.specification.vendor"),  JAVA_SPECIFICATION_NAME("java.specification.name"),  JAVA_CLASS_VERSION("java.class.version"),  JAVA_CLASS_PATH("java.class.path"),  JAVA_LIBRARY_PATH("java.library.path"),  JAVA_IO_TMPDIR("java.io.tmpdir"),  JAVA_COMPILER("java.compiler"),  JAVA_EXT_DIRS("java.ext.dirs"),  OS_NAME("os.name"),  OS_ARCH("os.arch"),  OS_VERSION("os.version"),  FILE_SEPARATOR("file.separator"),  PATH_SEPARATOR("path.separator"),  LINE_SEPARATOR("line.separator"),  USER_NAME("user.name"),  USER_HOME("user.home"),  USER_DIR("user.dir");
  
  private final String key;
  
  private StandardSystemProperty(String key)
  {
    this.key = key;
  }
  
  public String key()
  {
    return key;
  }
  
  @Nullable
  public String value()
  {
    return System.getProperty(key);
  }
  
  public String toString()
  {
    String str1 = String.valueOf(String.valueOf(key()));String str2 = String.valueOf(String.valueOf(value()));return 1 + str1.length() + str2.length() + str1 + "=" + str2;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.StandardSystemProperty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */