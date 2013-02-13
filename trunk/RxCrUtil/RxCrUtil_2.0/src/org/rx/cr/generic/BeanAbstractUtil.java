package org.rx.cr.generic;

public final class BeanAbstractUtil {
    
    private Object data;
    private int size;
    private String reference;

    public BeanAbstractUtil() {        
        setData(null);
        setSize(0);
        setReference("");
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
