package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {

    public static ImageReader getImageReader(ImageTypes image){
        //if(image instanceof ImageTypes == false) throw new IllegalArgumentException();
        try{
            if (image == ImageTypes.JPG) return new JpgReader();
            else if(image == ImageTypes.BMP) return new BmpReader();
            else if(image == ImageTypes.PNG) return new PngReader();
        }
        catch (IllegalArgumentException a){
            throw a;
        }
        if(image == null) throw new IllegalArgumentException();
        return null;
    }
}
