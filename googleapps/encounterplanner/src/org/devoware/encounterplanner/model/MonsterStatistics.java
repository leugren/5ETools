package org.devoware.encounterplanner.model;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import org.devoware.encounterplanner.monstercr.ChallengeRating;

import com.google.common.collect.Range;

public class MonsterStatistics {
	private final ChallengeRating cr;
	private final int proficiencyBonus;
	private final int armorClass;
	private final int hitPoints;
	private final Range<Integer> attackBonus;
	private final int damagePerRound;
	private final Range<Integer> saveDc;
	
	public static Builder newMonsterStatistics () {
		return new Builder ();
	}
	
	private MonsterStatistics (Builder builder) {
		this.cr = builder.cr;
		this.proficiencyBonus = builder.proficiencyBonus;
		this.armorClass = builder.armorClass;
		this.hitPoints = builder.hitPoints;
		this.attackBonus = builder.attackBonus;
		this.damagePerRound = builder.damagePerRound;
		this.saveDc = builder.saveDc;
	}
	
	public String getChallengeRating () {
		return cr.toString();
	}
	
	public String getProficiencyBonus () {
		return "+" + this.proficiencyBonus;
	}
	
	public String getArmorClass () {
		return String.valueOf(this.armorClass);
	}
	
	public String getHitPoints () {
		return String.valueOf(this.hitPoints);
	}
	
	public String getAttackBonus () {
		if (this.attackBonus.lowerEndpoint().intValue() == this.attackBonus.upperEndpoint().intValue()) {
			return "+" + this.attackBonus.lowerEndpoint().intValue();
		} else {
			return "<= +" + this.attackBonus.upperEndpoint();
		}
	}
	
	public String getDamagePerRound () {
		return String.valueOf(this.damagePerRound);
	}

	public String getSaveDc () {
		if (this.saveDc.lowerEndpoint().intValue() == this.saveDc.upperEndpoint().intValue()) {
			return String.valueOf(this.saveDc.lowerEndpoint().intValue());
		} else {
			return "<= " + this.saveDc.upperEndpoint();
		}
	}
	
    public static class Builder {
    	private ChallengeRating cr;
    	private Integer proficiencyBonus;
    	private Integer armorClass;
    	private Integer hitPoints;
    	private Range<Integer> attackBonus;
    	private Integer damagePerRound;
    	private Range<Integer> saveDc;
  
    	private Builder () {}

		public Builder withChallengeRating(ChallengeRating cr) {
			checkNotNull(cr);
			this.cr = cr;
			return this;
		}

		public Builder withProficiencyBonus(int proficiencyBonus) {
			checkArgument(proficiencyBonus > 0);
			this.proficiencyBonus = proficiencyBonus;
			return this;
		}

		public Builder withArmorClass(int armorClass) {
			checkArgument(armorClass >= 0);
			this.armorClass = armorClass;
			return this;
		}

		public Builder withHitPoints(int hitPoints) {
			checkArgument(hitPoints >= 0);
			this.hitPoints = hitPoints;
			return this;
		}

		public Builder withAttackBonus(int attackBonus) {
			checkArgument(attackBonus >= 0);
			return withAttackBonus(Range.singleton(attackBonus));
		}
		
		public Builder withAttackBonus(Range<Integer> attackBonus) {
			checkNotNull(attackBonus);
			this.attackBonus = attackBonus;
			return this;
		}

		public Builder withDamagePerRound(int damagePerRound) {
			checkArgument(damagePerRound >= 0);
			this.damagePerRound = damagePerRound;
			return this;
		}

		public Builder withSaveDc(int saveDc) {
			checkArgument(saveDc >= 0);
			return withSaveDc(Range.singleton(saveDc));
		}

		public Builder withSaveDc(Range<Integer> saveDc) {
			checkNotNull(saveDc);
			this.saveDc = saveDc;
			return this;
		}
		
		public MonsterStatistics build () {
			checkNotNull(cr);
			checkNotNull(proficiencyBonus);
			checkNotNull(armorClass);
			checkNotNull(hitPoints);
			checkNotNull(attackBonus);
			checkNotNull(damagePerRound);
			checkNotNull(saveDc);
			return new MonsterStatistics(this);
			
		}
    }
}
