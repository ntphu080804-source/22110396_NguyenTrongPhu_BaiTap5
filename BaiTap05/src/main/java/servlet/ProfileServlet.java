package servlet;
import java.io.File;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.User;

import java.io.IOException;
import java.nio.file.Paths;

@WebServlet("/profile")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024,  // 1MB
    maxFileSize = 5 * 1024 * 1024,    // 5MB
    maxRequestSize = 10 * 1024 * 1024 // 10MB
)
public class ProfileServlet extends HttpServlet {
	private String uploadPath;

	 @Override
	    public void init() {
	        uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
	        File uploadDir = new File(uploadPath);
	        if (!uploadDir.exists()) {
	            uploadDir.mkdir();
	        }
	    }
	    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // ví dụ: user được lấy từ session
        User user = (User) req.getSession().getAttribute("user");
        req.setAttribute("user", user);
        req.getRequestDispatcher("/pages/profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        String fullname = req.getParameter("fullname");
        String phone = req.getParameter("phone");

        Part filePart = req.getPart("avatar");
        String fileName = null;
        if (filePart != null && filePart.getSize() > 0) {
            fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            filePart.write(uploadPath + File.separator + fileName);
            user.setAvatar(fileName);
        }

        user.setFullname(fullname);
        user.setPhone(phone);

        // Cập nhật DB ở đây nếu có
        // UserDAO.update(user);

        req.getSession().setAttribute("user", user);
        resp.sendRedirect(req.getContextPath() + "/profile");
    }
}
