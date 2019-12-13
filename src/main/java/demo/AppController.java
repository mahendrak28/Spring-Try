package demo;

import demo.DAO.AppDAOImpl;
import demo.config.AppConfig;
import demo.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AppController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView homepage() {
        ModelAndView model = new ModelAndView("index");
        List<User> users = new ArrayList<User>();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.scan("demo.DAO");
        System.out.println(context.getBean(AppDAOImpl.class));
        AppDAOImpl DAO = context.getBean(AppDAOImpl.class);

        users = DAO.listUsers();
        model.addObject("users", users);
        context.close();
        return model;
    }
}
