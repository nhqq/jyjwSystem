package cdu.jyjw.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;

public class EncodingWrapper extends HttpServletRequestWrapper {
    public EncodingWrapper(HttpServletRequest request) {
        super(request);
    }
    public String getParameter(String name){
        String value = getRequest().getParameter(name);
        if (value!=null){
            try {
                byte[] bytes = value.getBytes("ISO-8859-1");
                value = new String(bytes,"utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return value;
    }
}
