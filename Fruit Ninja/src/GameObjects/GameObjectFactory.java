package GameObjects;
public class GameObjectFactory {
	public GameObject makeGameObject(String type,int speed,int maxHeight,float xPos,float factor)
	{
		if(type.equalsIgnoreCase("Melon"))
			return new Melon(speed,maxHeight,xPos,factor);
		if(type.equalsIgnoreCase("Apple"))
			return new Apple(speed,maxHeight,xPos,factor);
		if(type.equalsIgnoreCase("Orange"))
			return new Orange(speed,maxHeight,xPos,factor);
		if(type.equalsIgnoreCase("FatalBomb"))
			return new FatalBomb(speed,maxHeight,xPos,factor);
		if(type.equalsIgnoreCase("DangerBomb"))
			return new DangerBomb(speed,maxHeight,xPos,factor);
		if(type.equalsIgnoreCase("SpecialFruit"))
			return new SpecialFruit(speed,maxHeight,xPos,factor);
		if(type.equalsIgnoreCase("DragonFruit"))
			return new DragonFruit(speed,maxHeight,xPos,factor);
		if(type.equalsIgnoreCase("Mango"))
			return new Mango(speed,maxHeight,xPos,factor);
		
		return null;
	}
}
