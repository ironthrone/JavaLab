package io;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;

/**
 * Created by Administrator on 2017/2/22.
 */
public class AvailibleCharset {
    public static void main(String[] args) {
        SortedMap<String,Charset> charsets = Charset.availableCharsets();
        Iterator<String> keyIterator = charsets.keySet().iterator();
        while (keyIterator.hasNext()) {
            String charset = keyIterator.next();
            Set<String> alias = charsets.get(charset).aliases();
            StringBuilder sb = new StringBuilder();
            sb.append(charset);
            sb.append(":");

            for (String alia : alias) {
                sb.append(alia);
                sb.append(",");
            }
            System.out.println(sb.toString());
        }
    }
}
