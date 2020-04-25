

public class Cookies extends Generics{

	public static final String type = "Cookies";
	public enum KeyType {combo, toppings, dough};
	public static KeyType key = KeyType.combo;
	private String toppings;
	private String dough;
	
	public Cookies(String toppings, String dough){
		this.setType(type);
		this.toppings = toppings;
		this.dough = dough;
	}
	@Override
	public String toString() {
		String output="";
		switch(key) {
		case toppings:
			output += this.toppings;
			break;
		case dough:
			output += this.dough;
			break;
		case combo:
		default:
			output = type + ": " + this.toppings + ", " + this.dough;
		}
		return output;
	}
	public static Generics[] cookieData(){
		Generics[] cookieTypes = {
			new Cookies("Peanut Butter Chips", "Chocolate Cookie Dough"),
			new Cookies("Oatmeal Truffle", "Cookie Dough Balls"),
			new Cookies("M&M's", "Brownie Batter Dough"),
			new Cookies("Peanuts", "Trader Joe's Chunky Chocolate Chip Cookie Dough"),
			new Cookies("Sprinkles", "Gluten Free Sugar Cookie Dough"),
		};
		return cookieTypes;
	}
	public static void main(String[] args)
	{
		Generics[] cookieTypes = cookieData();
		for(int i = 0; i < cookieTypes.length; i++)
			System.out.println(cookieTypes[i]);
	}

}
