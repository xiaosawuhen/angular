package com.lxzl.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lxzl.bean.Hero;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

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
	@ApiOperation(value="获取Hero列表", notes="获取Hero列表")
	@GetMapping("/getHeros")
	public List<Hero> getHeros() {
		List<Hero> heros = new ArrayList<Hero>();
		
		List<String[]> heroArrayList = Arrays.asList(heroarray);
		
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
	@ApiOperation(value="获取Hero详细信息", notes="获取Hero详细信息")
	@ApiImplicitParam(name = "id", value = "HeroID", required = true, dataType = "Integer", paramType = "path")
	@GetMapping("/getHero/{id}")
	public Hero getHero(@PathVariable("id") Integer id) {

		String name = "defaultName";
		
		List<String[]> heroArrayList = Arrays.asList(heroarray);
		
		try {
			name = heroArrayList
					.stream()
					.filter(p -> (Integer.parseInt(p[0]) == id))
					.collect(Collectors.toList()).get(0)[1];
		} catch (Exception e) {
		}
		
		Hero hero = new Hero();
		hero.setId(id);
		hero.setName(name);
		
		return hero;
	}
}
