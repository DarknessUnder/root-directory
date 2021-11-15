package com.example.sdd.controller;
import com.example.sdd.entity.User;
import com.example.sdd.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import com.wf.captcha.ArithmeticCaptcha;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/register")
    public String greetingForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String greetingSubmit(@ModelAttribute User user) {
        userService.register(user.getUserName(),user.getPassword(),user.getEmail());
        return "result";
    }

    @GetMapping("/kaptcha")
    public void Kaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/png");

        // 算术类型
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(150, 40);
        captcha.setLen(2);  // 几位数运算，默认是两位
        captcha.getArithmeticString();  // 获取运算的公式：3+2=?
        captcha.text();  // 获取运算的结果：5
        httpServletRequest.getSession().setAttribute("verifyCode", captcha.text().toLowerCase());
        captcha.out(httpServletResponse.getOutputStream());  // 输出验证码
    }


    @GetMapping("/login.html")
    public String login() {
        return "login";
    }

    @PostMapping(value = "/login")
    public String login(@RequestParam("userName") String userName,
                        @RequestParam("password") String password,
                        @RequestParam("verifyCode") String verifyCode,
                        HttpSession session) {
        if (StringUtils.isEmpty(verifyCode)) {
            session.setAttribute("errorMsg", "Kaptcha required");
            return "login";
        }
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
            session.setAttribute("errorMsg", "Username Password required");
            return "login";
        }
        String kaptchaCode = session.getAttribute("verifyCode") + "";
        if (StringUtils.isEmpty(kaptchaCode) || !verifyCode.equals(kaptchaCode)) {
            session.setAttribute("errorMsg", "Error Kaptcha");
            return "login";
        }
        User user = userService.login(userName, password);
        if (user != null) {
            session.setAttribute("loginUser", user.getUserName());
            session.setAttribute("loginUserId", user.getUserId());
            return "index";
        } else {
            session.setAttribute("errorMsg", "Wrong Login Information");
            return "login";
        }
    }

    @GetMapping("/home.html")
    public String home() {
        return "home";
    }

    @GetMapping("/biol2120.html")
    public String bio2120() {
        return "biol2120";
    }

    @GetMapping("/biol-2120.html")
    public String bio_2120() {
        return "biol-2120";
    }

    @GetMapping("/calendar.html")
    public String calendar() { return "calendar"; }

    @GetMapping("/classes.html")
    public String classes() {
        return "classes";
    }

    @GetMapping("/Clubs.html")
    public String Clubs() {
        return "Clubs";
    }

    @GetMapping("/csci-1100.html")
    public String csci_1100() { return "csci-1100"; }

    @GetMapping("/csci-4440.html")
    public String csci_4440() { return "csci-4440"; }

    @GetMapping("/grade.html")
    public String grade() { return "grade"; }

    @GetMapping("/grade-csci-4440.html")
    public String grade_csci_4440() { return "grade-csci-4440"; }

    @GetMapping("/header.html")
    public String header() { return "header"; }

    @GetMapping("/index.html")
    public String index() { return "index"; }

    @GetMapping("/inquiry.html")
    public String inquiry() { return "inquiry"; }

    @GetMapping("/nav.html")
    public String nav() { return "nav"; }

    @GetMapping("/navEmpty.html")
    public String nav_empty() { return "navEmpty"; }

    @GetMapping("/policies.html")
    public String policies() { return "policies"; }

    @GetMapping("/syllabus.html")
    public String syllabus() { return "syllabus"; }

    @GetMapping("/rpi-tv.html")
    public String rpi_tv() { return "rpi-tv"; }

    @GetMapping("/syllabus-csci-4440.html")
    public String syllabus_4440() { return "syllabus-csci-4440"; }
}
