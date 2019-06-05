package com.vedeng.template.web.controller.login;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {

	/**
	 * 日志
	 */
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@GetMapping("login.html")
	public ModelAndView login() {
		ModelAndView view = new ModelAndView("login");

		view.setViewName("login/login");

		return view;
	}

	@PostMapping("doLogin.html")
	public String doLogin(@RequestParam("username") String username,
								@RequestParam("password") String password,
								Model model) {
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);

		try {
			SecurityUtils.getSubject().login(token);
		} catch (Exception e) {
			log.error("Error authenticating.", e);
			model.addAttribute("errorInvalidLogin", "The username or password was not correct.");
			return "login/login";
		}

		return "redirect:/index.html";
	}

	@GetMapping("logout.html")
	public ModelAndView logout() {
		ModelAndView view = new ModelAndView("logout");

		view.setViewName("login/logout");

		return view;
	}

}
