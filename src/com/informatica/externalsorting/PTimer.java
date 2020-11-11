package com.informatica.externalsorting;

public class PTimer {
    private final String name;
    private final long start;

    public PTimer(String name) {
        this.name = name;
        this.start = System.currentTimeMillis();
    }

    public void end() {
        long end = System.currentTimeMillis();
        System.out.println(name + " took " + (end - start) + "ms");
    }
}
