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

    //Register GetMapping
    @GetMapping("/register")
    public String greetingForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    
    //Register PostMapping
    @PostMapping("/register")
    public String greetingSubmit(@ModelAttribute User user) {
        userService.register(user.getUserName(),user.getPassword(),user.getEmail());
        return "result";
    }
    
    //Kaptcha
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

    //Login GetMapping
    @GetMapping("/login.html")
    public String login() {
        return "login";
    }

    //Login PostMapping
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

    //Home page mvc view getmapping
    @GetMapping("/home.html")
    public String home() {
        return "home";
    }
    
    //biol2120 mvc view getmapping
    @GetMapping("/biol2120.html")
    public String bio2120() {
        return "biol2120";
    }

    //biol-2120 mvc view getmapping
    @GetMapping("/biol-2120.html")
    public String bio_2120() {
        return "biol-2120";
    }

    //calendar mvc view getmapping
    @GetMapping("/calendar.html")
    public String calendar() { return "calendar"; }

    //classes mvc view getmapping
    @GetMapping("/classes.html")
    public String classes() {
        return "classes";
    }

    //clubs mvc view getmapping
    @GetMapping("/Clubs.html")
    public String Clubs() {
        return "Clubs";
    }

    //csci-1100 mvc view getmapping
    @GetMapping("/csci-1100.html")
    public String csci_1100() { return "csci-1100"; }

    //csci-4440 mvc view getmapping
    @GetMapping("/csci-4440.html")
    public String csci_4440() { return "csci-4440"; }

    //grade mvc view getmapping
    @GetMapping("/grade.html")
    public String grade() { return "grade"; }
    
    //grade-csci-4440 mvc view getmapping
    @GetMapping("/grade-csci-4440.html")
    public String grade_csci_4440() { return "grade-csci-4440"; }

    //header mvc view getmapping
    @GetMapping("/header.html")
    public String header() { return "header"; }

    //index mvc view getmapping
    @GetMapping("/index.html")
    public String index() { return "index"; }

    //inquiry mvc view getmapping
    @GetMapping("/inquiry.html")
    public String inquiry() { return "inquiry"; }

    //nav mvc view getmapping
    @GetMapping("/nav.html")
    public String nav() { return "nav"; }

    //navEmpty mvc view getmapping
    @GetMapping("/navEmpty.html")
    public String nav_empty() { return "navEmpty"; }

    //policies mvc view getmapping
    @GetMapping("/policies.html")
    public String policies() { return "policies"; }

    //syllabus mvc view getmapping
    @GetMapping("/syllabus.html")
    public String syllabus() { return "syllabus"; }

    //rpi-tv mvc view getmapping
    @GetMapping("/rpi-tv.html")
    public String rpi_tv() { return "rpi-tv"; }

    //syllabus-csci-4440 mvc view getmapping
    @GetMapping("/syllabus-csci-4440.html")
    public String syllabus_4440() { return "syllabus-csci-4440"; }
}
