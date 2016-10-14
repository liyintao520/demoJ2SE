package com.lyt.annotation;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class AnnotationDemo {
    
    @Override
    @MethodInfo(author = "Somnus", comments = "Main method", date = "June 12 2015", revision = 1)
    public String toString() {
        return "Overriden toString method";
    }
 
    @Deprecated
    @MethodInfo(comments = "deprecated method", date = "June 12 2015")
    public static void outdatedMethod() {
        System.out.println("outdated method, don't use it.");
    }
 
    @SuppressWarnings({"unchecked"})
    @MethodInfo(author = "Somnus", comments = "Main method", date = "June 12 2015", revision = 10)
    public static void genericsTest() throws FileNotFoundException {
        List l = new ArrayList();
        l.add("abc");
        outdatedMethod();
    }
}
