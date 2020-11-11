package com.informatica;

import com.informatica.externalsorting.FileSplit;


public class ExternalSorting {
    public String filename = "input";

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        long heapSize = Runtime.getRuntime().totalMemory();

        // Get maximum size of heap in bytes. The heap cannot grow beyond this size.// Any attempt will result in an OutOfMemoryException.
        long heapMaxSize = Runtime.getRuntime().maxMemory();

        // Get amount of free memory within the heap in bytes. This size will increase // after garbage collection and decrease as new objects are created.
        long heapFreeSize = Runtime.getRuntime().freeMemory();

        System.out.println("heapsize" + formatSize(heapSize));
        System.out.println("heapmaxsize" + formatSize(heapMaxSize));
        System.out.println("heapFreesize" + formatSize(heapFreeSize));

        ExternalSorting externalSorting = new ExternalSorting();

        externalSorting.start(args[1]);

    }

    private void start(String arg) {
        System.out.println("sort started");
        long start = System.currentTimeMillis();

        // Split file
        FileSplit splitter = new FileSplit(arg);
        splitter.split();
        // sort each file

        // merge file

        long end = System.currentTimeMillis();
        System.out.println("Time elapsed: " + (end - start) + " ms");

    }

    public static String formatSize(long v) {
        if (v < 1024) return v + " B";
        int z = (63 - Long.numberOfLeadingZeros(v)) / 10;
        return String.format("%.1f %sB", (double) v / (1L << (z * 10)), " KMGTPE".charAt(z));
    }
}
