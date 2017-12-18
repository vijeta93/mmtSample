package MMT.PageLocators;

import org.openqa.selenium.By;

public class ResultPageLocators {
	
	protected By AIR_INDIA_FLIGHTS = By.cssSelector("#aln_AI_dep>span");
	protected By FLIGHT_NUMBER=By.cssSelector("span.block.logo_name.hidden-xs.visible-stb.light_gray.flt_number_less600.ng-binding.ng-scope");
	protected By START_TIME=By.cssSelector("span.block.timeCa.RobotoRegular.ng-binding");
	protected By PRICE= By.cssSelector("span.num.ng-binding");
}
