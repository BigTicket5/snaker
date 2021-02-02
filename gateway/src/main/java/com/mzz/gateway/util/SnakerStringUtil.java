package com.mzz.gateway.util;

import org.apache.commons.lang3.StringUtils;

public class SnakerStringUtil {

    public static String urlAppend(String str1,String str2){
        if(StringUtils.isEmpty(str2)){
            return str1;
        }
        return StringUtils.join(str1,"?",str2);
    }
}
