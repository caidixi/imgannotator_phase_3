package wnderful.imgannotator.filter;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;
import wnderful.imgannotator.publicData.reponseCode.GlobalRepCode;
import wnderful.imgannotator.publicData.response.GlobalResponse;
import wnderful.imgannotator.util.JwtHelper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

@Component
@WebFilter(urlPatterns = "/test/*",filterName = "LoginFilter")

public class LoginFilter implements Filter {

    private final JwtHelper jwtHelper = new JwtHelper();

    @Override
    public void init(FilterConfig arg) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        boolean loginSuccess = false;

        String token = request.getHeader("token");
        String[] names = request.getRequestURI().split("/");
        int length = names.length;
        String username = names[length-1];

        try{
            if(username.equals(jwtHelper.verifyToken(token,"secret"))){
                loginSuccess = true;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        if(loginSuccess){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            try{
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(response.getOutputStream(),"UTF-8");
                PrintWriter writer = new PrintWriter(outputStreamWriter);
                GlobalResponse globalResponse = new GlobalResponse(GlobalRepCode.TOKENERROR);
                writer.write(JSON.toJSONString(globalResponse));
                writer.flush();
                writer.close();
                outputStreamWriter.close();
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void destroy(){

    }
}
