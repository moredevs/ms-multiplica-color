package com.multiplica.talent.microservicecolors.util;

import java.util.Objects;

public class ColorUtil {

    public static int pageIsNull(Integer page){
        int pages=0;
        if(Objects.nonNull(page)){
            pages = page-1;
        }
        return pages;
    }

    public static int sizeIsNull(Integer size){
        int sizes=Integer.MAX_VALUE;
        if(Objects.nonNull(size)){
            sizes =size;
        }
        return sizes;
    }

}
