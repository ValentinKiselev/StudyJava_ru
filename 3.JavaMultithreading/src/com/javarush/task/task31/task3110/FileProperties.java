package com.javarush.task.task31.task3110;

public class FileProperties {
    private  String name;
    private long size;
    private long compressedSize;
    private int compressionMethod;

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public long getCompressedSize() {
        return compressedSize;
    }

    public int getCompressionMethod() {
        return compressionMethod;
    }

    public FileProperties(String name, long size, long compressedSize, int compressionMethod) {
        this.name = name;
        this.size = size;
        this.compressedSize = compressedSize;
        this.compressionMethod = compressionMethod;
    }
    public long getCompressionRatio(){
        return 100 - ((compressedSize * 100) / size);
    }

    @Override
    public String toString() {
        StringBuilder sbuilder = new StringBuilder();
        sbuilder.append(name);
        if (size > 0) {
            sbuilder.append("\t");
            sbuilder.append(size / 1024);
            sbuilder.append(" Kb (");
            sbuilder.append(compressedSize / 1024);
            sbuilder.append(" Kb) сжатие: ");
            sbuilder.append(getCompressionRatio());
            sbuilder.append("%");
        }
        return sbuilder.toString();
    }

}
