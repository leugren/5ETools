package org.devoware.encounterplanner.model;

import static com.google.common.base.Preconditions.checkNotNull;

public class LocationBasedAdventure {
	private final String goal;
	private final String villain;
	private final String ally;
	private final String patron;
	private final String introduction;
	private final String climax;
	private final String framingEvent;
	private final String moralQuandary;
	private final String twist;
	private final String sideQuest;
	
	public static Builder newLocationBasedAdventure () {
		return new Builder();
	}
	
	private LocationBasedAdventure (Builder builder) {
		this.goal = builder.goal;
		this.villain = builder.villain;
		this.ally = builder.ally;
		this.patron = builder.patron;
		this.introduction = builder.introduction;
		this.climax = builder.climax;
		this.framingEvent = builder.framingEvent;
		this.moralQuandary = builder.moralQuandary;
		this.twist = builder.twist;
		this.sideQuest = builder.sideQuest;
	}
	
	public String getGoal() {
		return goal;
	}

	public String getVillain() {
		return villain;
	}

	public String getAlly() {
		return ally;
	}

	public String getPatron() {
		return patron;
	}

	public String getIntroduction() {
		return introduction;
	}

	public String getClimax() {
		return climax;
	}

	public String getFramingEvent() {
		return framingEvent;
	}

	public String getMoralQuandary() {
		return moralQuandary;
	}

	public String getTwist() {
		return twist;
	}

	public String getSideQuest() {
		return sideQuest;
	}

	public static class Builder {
		private String goal;
		private String villain;
		private String ally;
		private String patron;
		private String introduction;
		private String climax;
		private String framingEvent;
		private String moralQuandary;
		private String twist;
		private String sideQuest;

		private Builder () {}

 		public Builder withGoal(String goal) {
			checkNotNull(goal);
			this.goal = goal;
			return this;
		}

		public Builder withVillain(String villain) {
			checkNotNull(villain);
			this.villain = villain;
			return this;
		}

		public Builder withAlly(String ally) {
			checkNotNull(ally);
			this.ally = ally;
			return this;
		}

		public Builder withPatron(String patron) {
			checkNotNull(patron);
			this.patron = patron;
			return this;
		}

		public Builder withIntroduction(String introduction) {
			checkNotNull(introduction);
			this.introduction = introduction;
			return this;
		}

		public Builder withClimax(String climax) {
			checkNotNull(climax);
			this.climax = climax;
			return this;
		}

		public Builder withFramingEvent(String framingEvent) {
			checkNotNull(framingEvent);
			this.framingEvent = framingEvent;
			return this;
		}

		public Builder withMoralQuandary(String moralQuandary) {
			checkNotNull(moralQuandary);
			this.moralQuandary = moralQuandary;
			return this;
		}

		public Builder withTwist(String twist) {
			checkNotNull(twist);
			this.twist = twist;
			return this;
		}

		public Builder withSideQuest(String sideQuest) {
			checkNotNull(sideQuest);
			this.sideQuest = sideQuest;
			return this;
		}
		
		public LocationBasedAdventure build () {
			checkNotNull(goal);
			checkNotNull(villain);
			checkNotNull(ally);
			checkNotNull(patron);
			checkNotNull(introduction);
			checkNotNull(climax);
			checkNotNull(framingEvent);
			checkNotNull(moralQuandary);
			checkNotNull(twist);
			checkNotNull(sideQuest);

			return new LocationBasedAdventure(this);
		}
		
		
	}
}
