package monsters;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;


public class MonsterType implements Comparable<MonsterType> {
	
	private static final Pattern typePattern = Pattern.compile("^(.+)\\s+\\(([^\\)]+)\\)$");

	private final String type;
	private final Set<String> tags;
	private final String stringValue;
	
	public static Builder newMonsterType () {
		return new Builder();
	}
	
	public static MonsterType newMonsterType (String type) {
		Matcher m = typePattern.matcher(type);
		MonsterType.Builder typeBuilder = MonsterType.newMonsterType(); 
		if (m.find()) {
			typeBuilder.withType(m.group(1).trim());
			for (String tag : Splitter.on(",").trimResults().split(m.group(2))) {
				typeBuilder.withTags(tag);
			}
		} else {
			typeBuilder.withType(type.trim());
		}
		return typeBuilder.build();
		
	}
	
	private MonsterType (Builder builder) {
		this.type = builder.type;
		this.tags = ImmutableSet.copyOf(builder.tags);
		StringBuilder buf = new StringBuilder(this.type);
		if (! this.tags.isEmpty()) {
			buf.append(" (");
			boolean firstLoop = true;
			for (String tag : this.tags) {
				if (firstLoop) {
					firstLoop = false;
				} else {
					buf.append(", ");
				}
				buf.append(tag);
			}
			buf.append(")");
		}
		this.stringValue = buf.toString();
	}
	
	public String getType() {
		return type;
	}

	public Set<String> getTags() {
		return tags;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
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
		MonsterType other = (MonsterType) obj;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public int compareTo(MonsterType o) {
		checkNotNull(o);
		return this.stringValue.compareTo(o.stringValue);
	}

	@Override
	public String toString() {
		return this.stringValue;
	}

	public static class Builder {
		private String type;
		private Set<String> tags = Sets.newTreeSet();
		
		private Builder () {}
		
		public Builder withType (String type) {
			checkNotNull(type);
			checkArgument(!type.trim().isEmpty());
			this.type = type;
			return this;
		}
		
		public Builder withTags (String ... tags) {
			for (String tag : tags) {
				checkNotNull(tag);
				checkArgument(!tag.trim().isEmpty());
				this.tags.add(tag);
			}
			return this;
		}
		
		public MonsterType build () {
			checkNotNull(type);
			return new MonsterType(this);
		}
	}
	

}
