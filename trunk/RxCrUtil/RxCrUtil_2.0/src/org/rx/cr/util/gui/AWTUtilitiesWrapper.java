package org.rx.cr.util.gui;


import java.awt.GraphicsConfiguration;
import java.awt.Shape;
import java.awt.Window;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.swing.JComponent;

public class AWTUtilitiesWrapper {

    private static Class<?> awtUtilitiesClass;
    private static Class<?> translucencyClass;
    private static Method mIsTranslucencySupported,  mIsTranslucencyCapable,  mSetWindowShape, mSetComponentShape,  mSetWindowOpacity,  mSetWindowOpaque;
    public static Object PERPIXEL_TRANSPARENT,  TRANSLUCENT,  PERPIXEL_TRANSLUCENT;

    static void init() {
        try {
            awtUtilitiesClass = Class.forName("com.sun.awt.AWTUtilities");
            translucencyClass = Class.forName("com.sun.awt.AWTUtilities$Translucency");
            if (translucencyClass.isEnum()) {
                Object[] kinds = translucencyClass.getEnumConstants();
                if (kinds != null) {
                    PERPIXEL_TRANSPARENT = kinds[0];
                    TRANSLUCENT = kinds[1];
                    PERPIXEL_TRANSLUCENT = kinds[2];
                }
            }
            mIsTranslucencySupported = awtUtilitiesClass.getMethod("isTranslucencySupported", translucencyClass);
            mIsTranslucencyCapable = awtUtilitiesClass.getMethod("isTranslucencyCapable", GraphicsConfiguration.class);
            mSetWindowShape = awtUtilitiesClass.getMethod("setWindowShape", Window.class, Shape.class);
            //mSetComponentShape = awtUtilitiesClass.getMethod("setComponentShape",JComponent.class, Shape.class);
            mSetWindowOpacity = awtUtilitiesClass.getMethod("setWindowOpacity", Window.class, float.class);
            mSetWindowOpaque = awtUtilitiesClass.getMethod("setWindowOpaque", Window.class, boolean.class);
        } catch (NoSuchMethodException | SecurityException | ClassNotFoundException ex) {
           // Logger.getLogger(AWTUtilitiesWrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static {
        init();
    }
    
    private static boolean isSupported(Method method, Object kind) {
        if (awtUtilitiesClass == null ||
                method == null)
        {
            return false;
        }
        try {
            Object ret = method.invoke(null, kind);
            if (ret instanceof Boolean) {
                return ((Boolean)ret).booleanValue();
            }
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
           // Logger.getLogger(AWTUtilitiesWrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static boolean isTranslucencySupported(Object kind) {
        if (translucencyClass == null) {
            return false;
        }
        return isSupported(mIsTranslucencySupported, kind);
    }
    
    public static boolean isTranslucencyCapable(GraphicsConfiguration gc) {
        return isSupported(mIsTranslucencyCapable, gc);
    }
    
    private static void set(Method method, Window window, Object value) {
        if (awtUtilitiesClass == null ||
            method == null){
            return;
        }
        try {
            method.invoke(null, window, value);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            //Logger.getLogger(AWTUtilitiesWrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void set(Method method,JComponent component, Object value) {
        if (awtUtilitiesClass == null ||
                method == null)
        {
            return;
        }
        try {
            method.invoke(null,component, value);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            //Logger.getLogger(AWTUtilitiesWrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void setWindowShape(Window window, Shape shape) {
        set(mSetWindowShape, window, shape);
    }
    public static void setComponentShape(JComponent component, Shape shape) {
        set(mSetWindowShape,component, shape);
    }

    public static void setWindowOpacity(Window window, float opacity) {
        set(mSetWindowOpacity, window, Float.valueOf(opacity));
    }
    
    public static void setWindowOpaque(Window window, boolean opaque) {
        set(mSetWindowOpaque, window, Boolean.valueOf(opaque));
    }
    
    //setResizable(false);
        //AWTUtilities.setWindowOpaque(this, false);
        /*
        try {
                Class clazz = Class.forName("com.sun.awt.AWTUtilities");
                Method method = clazz.getMethod("setWindowOpaque",java.awt.Window.class,Boolean.TYPE);
                method.invoke(clazz,this, false);
        } catch (Exception e) {}*/
}
