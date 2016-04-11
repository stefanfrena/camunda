package decorator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import decorator.beverages.DarkRoast;
import decorator.beverages.Espresso;
import decorator.beverages.HouseBlend;
import decorator.condiments.Mocha;
import decorator.condiments.Soy;
import decorator.condiments.Whip;

public class BeverageTest {

  @Test
  public void testEspresso() throws Exception {
    Beverage espresso = new Espresso();
    String expectedEspresso = "Espresso $1.99";
    assertEquals(expectedEspresso, espresso.getDescription() + " $" + espresso.cost());
  }

  @Test
  public void testDarkRoast() throws Exception {
    Beverage darkRoast = new DarkRoast();
    darkRoast = new Mocha(darkRoast);
    darkRoast = new Mocha(darkRoast);
    darkRoast = new Whip(darkRoast);
    String expectedDarkRoast = "Dark Roast, Mocha, Mocha, Whip $1.1";
    assertEquals(expectedDarkRoast, darkRoast.getDescription() + " $" + darkRoast.cost());
  }

  @Test
  public void testHouseBlend() throws Exception {
    Beverage houseBlend = new HouseBlend();
    houseBlend = new Soy(houseBlend);
    houseBlend = new Mocha(houseBlend);
    houseBlend = new Whip(houseBlend);
    String expectedHouseBlend = "House Blend Coffee, Soy, Mocha, Whip $1.49";
    assertEquals(expectedHouseBlend, houseBlend.getDescription() + " $" + houseBlend.cost());
  }



}
