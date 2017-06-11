package com.oceanisher.javascript.view;

import java.util.HashMap;
import java.util.Map;

public class Energy {

	public static Map<String, Double> energyMap = new HashMap<String, Double>();
	
	static{
		energyMap.put("write", new Double(6.2));
		energyMap.put("writeln", new Double(7));
		energyMap.put("style", new Double(9.1));
		energyMap.put("tabIndex", new Double(5));
		energyMap.put("textContent", new Double(4.6));
		energyMap.put("title", new Double(5.6));
		energyMap.put("appendChild", new Double(12));
		energyMap.put("removeChild", new Double(18));
		energyMap.put("innerHTML", new Double(10));
		energyMap.put("attribute", new Double(9.6));
		energyMap.put("back", new Double(21));
		energyMap.put("forward", new Double(22));
		energyMap.put("alert", new Double(19.5));
		energyMap.put("confirm", new Double(18.7));
		energyMap.put("prompt", new Double(20.6));
		energyMap.put("assign", new Double(9.5));
		energyMap.put("send", new Double(15));
		energyMap.put("play", new Double(21.5));
		energyMap.put("getCurrentPosition", new Double(8));
	}
	
}
