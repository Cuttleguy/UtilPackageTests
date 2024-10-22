package UtilPackageTests.extensions.java.lang.Double;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import java.lang.Double;

@Extension
public class DoubleExtension {
  public static void helloWorld(@This Double thiz) {
    System.out.println("hello world!");
  }
}