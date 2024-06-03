package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import web.Service.CarServiceImpl;
import web.service.UserServiceImp;

@Controller
//@RequestMapping("/cars")
public class CarController {

    @GetMapping("/cars")
    public String index(@RequestParam(defaultValue="5") Integer count, ModelMap model) {
        //CarServiceImpl carServiceImpl = new CarServiceImpl();
        model.addAttribute("users", new UserServiceImp().users(count));
        return "users";
    }
}
