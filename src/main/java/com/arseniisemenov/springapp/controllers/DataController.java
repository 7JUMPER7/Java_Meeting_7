package com.arseniisemenov.springapp.controllers;

import com.arseniisemenov.springapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class DataController {
    @Autowired
    DBController dbController;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView getUsers() {
        List<User> users = dbController.queryAllUsers();
        return new ModelAndView("index", "users", users);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ModelAndView getUser(@PathVariable(value="id") int id) {
        User user = dbController.queryUser(id);
        return new ModelAndView("user/user", "user", user);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String getCreateView() {
        return "create/create";
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public RedirectView createUser(
        @RequestParam String name,
        @RequestParam String phone,
        @RequestParam String email,
        @RequestParam String blog,
        @RequestParam String note
    ) {
        User user = new User();
        user.setName(name);
        user.setPhone(phone);
        user.setEmail(email);
        user.setBlog(blog);
        user.setNote(note);

        dbController.addUser(user);
        return new RedirectView("/");
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView getEditView(@PathVariable(value="id") int id) {
        User user = dbController.queryUser(id);
        return new ModelAndView("edit/edit", "user", user);
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public RedirectView updateUser(
            @PathVariable(value="id") int id,
            @RequestParam String name,
            @RequestParam String phone,
            @RequestParam String email,
            @RequestParam String blog,
            @RequestParam String note
    ) {
        User user = new User();
        user.setName(name);
        user.setPhone(phone);
        user.setEmail(email);
        user.setBlog(blog);
        user.setNote(note);
        user.setId(id);

        dbController.updateUser(user);
        return new RedirectView("/");
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public RedirectView deleteUser(@PathVariable(value="id") int id) {
        dbController.deleteUser(id);
        return new RedirectView("/");
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public ModelAndView findUsers(@RequestParam("name") String name) {
        List<User> users = dbController.findUsers(name);
        return new ModelAndView("index", "users", users);
    }
}
