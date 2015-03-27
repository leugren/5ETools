package monsters;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static monsters.ChallengeRatings.CR_RANGE;
import static monsters.ChallengeRatings.crToString;


public class Monster {
	
	private final String name;
	private final MonsterType type;
	private final double challengeRating;
	
	
    public static Builder newMonster () {
    	return new Builder();
    }
    
    private Monster (Builder builder) {
    	this.name = builder.name;
    	this.type = builder.type;
    	this.challengeRating = builder.challengeRating;
    }
    
    public String getName() {
		return name;
	}

	public MonsterType getType() {
		return type;
	}

	public double getChallengeRating() {
		return challengeRating;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(challengeRating);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Monster other = (Monster) obj;
		if (Double.doubleToLongBits(challengeRating) != Double
				.doubleToLongBits(other.challengeRating))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Monster [name=" + name + ", type=" + type
				+ ", challengeRating=" + crToString(challengeRating) + "]";
	}



	public static class Builder {
    	private String name;
    	private MonsterType type;
    	private Double challengeRating;
    	
    	private Builder () {}

		public Builder withName(String name) {
			checkNotNull(name);
			this.name = name;
			return this;
		}

		public Builder withType(MonsterType type) {
			checkNotNull(name);
			this.type = type;
			return this;
		}

		public Builder withChallengeRating(double challengeRating) {
			checkArgument(CR_RANGE.contains(challengeRating));
			this.challengeRating = challengeRating;
			return this;
		}
    	
    	public Monster build () {
			checkNotNull(name);
			checkNotNull(type);
			checkNotNull(challengeRating);
    		return new Monster(this);
    	}
    	
    }
    
}
