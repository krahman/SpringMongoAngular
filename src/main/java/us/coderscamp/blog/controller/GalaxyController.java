package us.coderscamp.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import us.coderscamp.blog.model.Galaxy;
import us.coderscamp.blog.service.GalaxyService;

@Controller
public class GalaxyController {
	@Autowired
	private GalaxyService galaxyService;
	
	@RequestMapping(value="/galaxy", method=RequestMethod.GET)
	public String getGalaxyList(ModelMap model){
		model.addAttribute("galaxyList", galaxyService.listGalaxy());
		return "result";
	}
	
	@RequestMapping(value="/galaxy/save", method=RequestMethod.POST)
	public View createGalaxy(@ModelAttribute Galaxy galaxy, ModelMap model){
		if(StringUtils.hasText(galaxy.getId())){
			galaxyService.updateGalaxy(galaxy);
		}else{
			galaxyService.addGalaxy(galaxy);
		}
		return new RedirectView("/SpringMongoAngular/galaxy");
	}
	
	@RequestMapping(value="/galaxy/delete", method=RequestMethod.GET)
	public View deleteGalaxy(@ModelAttribute Galaxy galaxy, ModelMap model){
		galaxyService.deleteGalaxy(galaxy);
		return new RedirectView("/SpringMongoAngular/galaxy");
	}
}
