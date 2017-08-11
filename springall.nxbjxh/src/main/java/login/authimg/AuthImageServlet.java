package login.authimg;

/**
 * Created by BHWL on 2017-04-11.
 */

import com.framework.utils.Props;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * <p><b>AuthImageServlet Description:</b> (验证码)</p>
 * <b>DATE:</b> 2016年6月2日 下午3:53:12
 */
public class AuthImageServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    static final long serialVersionUID = 1L;

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        Props props = new Props("properties/boot.login.properties");
        Integer width = props.getInt("authImage.width");
        Integer height = props.getInt("authImage.height");
        Integer size = props.getInt("authImage.size");
        String yawpRate = props.getStr("authImage.yawpRate");

        //生成随机字串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(size);
        //存入会话session
        HttpSession session = request.getSession(true);
        //删除以前的
        session.removeAttribute("verCode");
        session.setAttribute("verCode", verifyCode.toLowerCase());
        //生成图片
        int w = width, h = height;
        VerifyCodeUtils.outputImage(Float.parseFloat(yawpRate), w, h, response.getOutputStream(), verifyCode);

    }
}