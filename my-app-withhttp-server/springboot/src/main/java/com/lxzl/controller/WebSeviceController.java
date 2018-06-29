package com.lxzl.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.util.ArrayUtils;

import com.lxzl.bean.Hero;

@RestController
public class WebSeviceController {

	static String[][] heroarray = {
			{"11","Mr. Nice"},
			{"12","Narco"},
			{"13","Bombasto"},
			{"14","Celeritas"},
			{"15","Magneta"},
			{"16","RubberMan"},
			{"17","Dynama"},
			{"18","Dr IQ"},
			{"19","Magma"},
			{"20","Tornado"}
			};

	/**
	 * @return
	 */
	@RequestMapping("/getHeros")
	public List<Hero> getHeros() {
		List<Hero> heros = new ArrayList<Hero>();
		
		List<String[]> heroArrayList = ArrayUtils.toUnmodifiableList(heroarray);
		
		heroArrayList.stream().forEach(e->{
			Hero hero = new Hero();

			hero.setId(Integer.parseInt(e[0]));
			hero.setName(e[1]);
			
			heros.add(hero);
		});
		
		return heros;
	}

	/**
	 * @return
	 */
	@RequestMapping("/getHero/{id}")
	public Hero getHero(@PathVariable("id") Integer id) {

		Hero hero = new Hero();
		hero.setId(id);
		hero.setName("test");
		
		return hero;
	}
}
