package md.rubin.springmvc.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {
    @GetMapping("/hello-word")
    public String sayHello(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        model.addAttribute("message", "Hello, " + name + " " + surname);

        //System.out.println("Hello, " + name + " " + surname);
        return "hello_word";
    }

    @GetMapping("/bye/bye")
    public String sayBye() {
        return "good_bye";
    }

    @GetMapping("/first/calculator")
    public String calculate(HttpServletRequest request, Model model) {
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String action = request.getParameter("action");
        int c;
        if (action != null) {
            switch (action) {
                case "multiplication":
                    c = Integer.parseInt(a) * Integer.parseInt(b);
                    model.addAttribute("result", a + "*" + b + "=" + c);
                    break;
                case "add":
                    c = Integer.parseInt(a) + Integer.parseInt(b);
                    model.addAttribute("result", a + "+" + b + "=" + c);
                    break;
                case "sub":
                    c = Integer.parseInt(a) - Integer.parseInt(b);
                    model.addAttribute("result", a + "-" + b + "=" + c);
                    break;
                default:
                    model.addAttribute("result", "NonExistThis" + action);
            }
            return "first/calculator";
        } else {
            return "first/calculator";
        }
    }
}
