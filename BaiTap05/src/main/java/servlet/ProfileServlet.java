package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.User;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@WebServlet("/profile")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024,
    maxFileSize = 1024 * 1024 * 5,     // 5MB
    maxRequestSize = 1024 * 1024 * 25  // 25MB
)
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIR = "D:\\upload"; // thư mục cố định trên máy bạn

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // giả sử user đã lưu session
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            user = new User();
            req.getSession().setAttribute("user", user);
        }
        req.setAttribute("user", user);
        req.getRequestDispatcher("/views/profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        String fullname = req.getParameter("fullname");
        String phone = req.getParameter("phone");

        Part filePart = req.getPart("avatar");
        String fileName = null;
        if (filePart != null && filePart.getSize() > 0) {
            fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) uploadDir.mkdirs();
            filePart.write(UPLOAD_DIR + File.separator + fileName);
            user.setImage(fileName);
        }

        user.setFullname(fullname);
        user.setPhone(phone);

        // cập nhật lại vào session
        req.getSession().setAttribute("user", user);

        resp.sendRedirect(req.getContextPath() + "/profile");
    }
}
