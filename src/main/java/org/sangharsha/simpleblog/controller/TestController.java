/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sangharsha.simpleblog.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Sangharsha
 */
@Controller
@RequestMapping(value = {"/"})
public class TestController {

    @RequestMapping(value = {"/"})
    public ModelAndView index() {
        return new ModelAndView("test/index");
    }

    @RequestMapping(value = {"/test"})
    public ModelAndView test() {
        return new ModelAndView("test/test");
    }
}
