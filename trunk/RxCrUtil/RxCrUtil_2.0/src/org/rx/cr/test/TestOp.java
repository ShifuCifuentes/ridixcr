package org.rx.cr.test;

import java.util.regex.Pattern;

public class TestOp {
    public static void main(String[] args) {
        System.out.println(Pattern.compile("(?i)pavel",Pattern.CASE_INSENSITIVE).toString());
    }
}
