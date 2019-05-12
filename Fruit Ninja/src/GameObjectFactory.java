
public class GameObjectFactory {
	GameObject makeGameObject(String type,float speed)
	{
		if(type.equalsIgnoreCase("Melon"))
			return new Melon(speed);
		if(type.equalsIgnoreCase("Apple"))
			return new Apple(speed);
		if(type.equalsIgnoreCase("Orange"))
			return new Orange(speed);
		if(type.equalsIgnoreCase("FatalBomb"))
			return new FatalBomb(speed);
		if(type.equalsIgnoreCase("DangerBomb"))
			return new DangerBomb(speed);
		return null;
	}
}
