package com.jiangcl.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author jiangcl
 * @date 2019/12/16
 * @desc
 */
public class ResponseUtil {

    public static void resp(HttpServletResponse response,String message){
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/Json");
        try {
            PrintWriter out = response.getWriter();
            out.print(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
