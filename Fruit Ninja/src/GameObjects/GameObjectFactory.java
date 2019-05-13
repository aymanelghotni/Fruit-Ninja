package GameObjects;
public class GameObjectFactory {
	public GameObject makeGameObject(String type,float speed,int maxHeight,float xPos)
	{
		if(type.equalsIgnoreCase("Melon"))
			return new Melon(speed,maxHeight,xPos);
		if(type.equalsIgnoreCase("Apple"))
			return new Apple(speed,maxHeight,xPos);
		if(type.equalsIgnoreCase("Orange"))
			return new Orange(speed,maxHeight,xPos);
		if(type.equalsIgnoreCase("FatalBomb"))
			return new FatalBomb(speed,maxHeight,xPos);
		if(type.equalsIgnoreCase("DangerBomb"))
			return new DangerBomb(speed,maxHeight,xPos);
		return null;
	}
}
