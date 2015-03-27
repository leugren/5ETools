

import java.util.Random;

public class Die  {
    public static final Die D4 = new Die(4);
    public static final Die D6 = new Die(6);
    public static final Die D8 = new Die(8);
    public static final Die D10 = new Die(10);
    public static final Die D12 = new Die(12);
    public static final Die D20 = new Die(20);
    public static final Die D100 = new Die(100);
    public static final Die D200 = new Die(200);
	
	private final int type;
	private final Random random = new Random();
	
	public static Die newDie (int type) {
		return new Die(type);
	}
	
	private Die (int type) {
		this.type = type;
	}
	
	public int getType () {
		return type;
	}
	
	public int roll () {
		return (int) (random.nextDouble() * this.type + 1);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((random == null) ? 0 : random.hashCode());
		result = prime * result + type;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Die other = (Die) obj;
		if (random == null) {
			if (other.random != null)
				return false;
		} else if (!random.equals(other.random))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
}
