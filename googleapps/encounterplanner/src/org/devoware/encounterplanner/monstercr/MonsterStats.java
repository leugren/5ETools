package org.devoware.encounterplanner.monstercr;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.devoware.encounterplanner.monstercr.ChallengeRating.CR0;
import static org.devoware.encounterplanner.monstercr.ChallengeRating.CR1;
import static org.devoware.encounterplanner.monstercr.ChallengeRating.CR10;
import static org.devoware.encounterplanner.monstercr.ChallengeRating.CR11;
import static org.devoware.encounterplanner.monstercr.ChallengeRating.CR12;
import static org.devoware.encounterplanner.monstercr.ChallengeRating.CR13;
import static org.devoware.encounterplanner.monstercr.ChallengeRating.CR14;
import static org.devoware.encounterplanner.monstercr.ChallengeRating.CR15;
import static org.devoware.encounterplanner.monstercr.ChallengeRating.CR16;
import static org.devoware.encounterplanner.monstercr.ChallengeRating.CR17;
import static org.devoware.encounterplanner.monstercr.ChallengeRating.CR18;
import static org.devoware.encounterplanner.monstercr.ChallengeRating.CR19;
import static org.devoware.encounterplanner.monstercr.ChallengeRating.CR1_2;
import static org.devoware.encounterplanner.monstercr.ChallengeRating.CR1_4;
import static org.devoware.encounterplanner.monstercr.ChallengeRating.CR1_8;
import static org.devoware.encounterplanner.monstercr.ChallengeRating.CR2;
import static org.devoware.encounterplanner.monstercr.ChallengeRating.CR20;
import static org.devoware.encounterplanner.monstercr.ChallengeRating.CR21;
import static org.devoware.encounterplanner.monstercr.ChallengeRating.CR22;
import static org.devoware.encounterplanner.monstercr.ChallengeRating.CR23;
import static org.devoware.encounterplanner.monstercr.ChallengeRating.CR24;
import static org.devoware.encounterplanner.monstercr.ChallengeRating.CR25;
import static org.devoware.encounterplanner.monstercr.ChallengeRating.CR26;
import static org.devoware.encounterplanner.monstercr.ChallengeRating.CR27;
import static org.devoware.encounterplanner.monstercr.ChallengeRating.CR28;
import static org.devoware.encounterplanner.monstercr.ChallengeRating.CR29;
import static org.devoware.encounterplanner.monstercr.ChallengeRating.CR3;
import static org.devoware.encounterplanner.monstercr.ChallengeRating.CR30;
import static org.devoware.encounterplanner.monstercr.ChallengeRating.CR4;
import static org.devoware.encounterplanner.monstercr.ChallengeRating.CR5;
import static org.devoware.encounterplanner.monstercr.ChallengeRating.CR6;
import static org.devoware.encounterplanner.monstercr.ChallengeRating.CR7;
import static org.devoware.encounterplanner.monstercr.ChallengeRating.CR8;
import static org.devoware.encounterplanner.monstercr.ChallengeRating.CR9;

import java.util.Map;

import com.google.appengine.labs.repackaged.com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableRangeMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;

public enum MonsterStats {
	MS_CR0(newMonsterStats()
			.withChallengeRating(CR0)
			.withProficiencyBonus(2)
			.withArmorClass(Range.closed(8, 13))
			.withHitPoints(Range.closed(1, 6))
			.withAttackBonus(Range.closed(0, 3))
			.withDamagePerRound(Range.closed(0, 1))
			.withSaveDc(Range.closed(8, 13))),
	MS_CR1_8(newMonsterStats()
			.withChallengeRating(CR1_8)
			.withProficiencyBonus(2)
			.withArmorClass(13)
			.withHitPoints(Range.closed(7, 35))
			.withAttackBonus(3)
			.withDamagePerRound(Range.closed(2, 3))
			.withSaveDc(13)),
	MS_CR1_4(newMonsterStats()
			.withChallengeRating(CR1_4)
			.withProficiencyBonus(2)
			.withArmorClass(13)
			.withHitPoints(Range.closed(36, 49))
			.withAttackBonus(3)
			.withDamagePerRound(Range.closed(4, 5))
			.withSaveDc(13)),
	MS_CR1_2(newMonsterStats()
			.withChallengeRating(CR1_2)
			.withProficiencyBonus(2)
			.withArmorClass(13)
			.withHitPoints(Range.closed(50, 70))
			.withAttackBonus(3)
			.withDamagePerRound(Range.closed(6, 8))
			.withSaveDc(13)),
	MS_CR1(newMonsterStats()
			.withChallengeRating(CR1)
			.withProficiencyBonus(2)
			.withArmorClass(13)
			.withHitPoints(Range.closed(71, 85))
			.withAttackBonus(3)
			.withDamagePerRound(Range.closed(9, 14))
			.withSaveDc(13)),
	MS_CR2(newMonsterStats()
			.withChallengeRating(CR2)
			.withProficiencyBonus(2)
			.withArmorClass(13)
			.withHitPoints(Range.closed(86, 100))
			.withAttackBonus(3)
			.withDamagePerRound(Range.closed(15, 20))
			.withSaveDc(13)),
	MS_CR3(newMonsterStats()
			.withChallengeRating(CR3)
			.withProficiencyBonus(2)
			.withArmorClass(13)
			.withHitPoints(Range.closed(101, 115))
			.withAttackBonus(4)
			.withDamagePerRound(Range.closed(21, 26))
			.withSaveDc(13)),
	MS_CR4(newMonsterStats()
			.withChallengeRating(CR4)
			.withProficiencyBonus(2)
			.withArmorClass(14)
			.withHitPoints(Range.closed(116, 130))
			.withAttackBonus(5)
			.withDamagePerRound(Range.closed(27, 32))
			.withSaveDc(14)),
	MS_CR5(newMonsterStats()
			.withChallengeRating(CR5)
			.withProficiencyBonus(3)
			.withArmorClass(15)
			.withHitPoints(Range.closed(131, 145))
			.withAttackBonus(6)
			.withDamagePerRound(Range.closed(33, 38))
			.withSaveDc(15)),
	MS_CR6(newMonsterStats()
			.withChallengeRating(CR6)
			.withProficiencyBonus(3)
			.withArmorClass(15)
			.withHitPoints(Range.closed(146, 160))
			.withAttackBonus(6)
			.withDamagePerRound(Range.closed(39, 44))
			.withSaveDc(15)),
	MS_CR7(newMonsterStats()
			.withChallengeRating(CR7)
			.withProficiencyBonus(3)
			.withArmorClass(15)
			.withHitPoints(Range.closed(161, 175))
			.withAttackBonus(6)
			.withDamagePerRound(Range.closed(45, 50))
			.withSaveDc(15)),
	MS_CR8(newMonsterStats()
			.withChallengeRating(CR8)
			.withProficiencyBonus(3)
			.withArmorClass(16)
			.withHitPoints(Range.closed(176, 190))
			.withAttackBonus(7)
			.withDamagePerRound(Range.closed(51, 56))
			.withSaveDc(16)),
	MS_CR9(newMonsterStats()
			.withChallengeRating(CR9)
			.withProficiencyBonus(4)
			.withArmorClass(16)
			.withHitPoints(Range.closed(191, 205))
			.withAttackBonus(7)
			.withDamagePerRound(Range.closed(57, 62))
			.withSaveDc(16)),
	MS_CR10(newMonsterStats()
			.withChallengeRating(CR10)
			.withProficiencyBonus(4)
			.withArmorClass(17)
			.withHitPoints(Range.closed(206, 220))
			.withAttackBonus(7)
			.withDamagePerRound(Range.closed(63, 68))
			.withSaveDc(16)),
	MS_CR11(newMonsterStats()
			.withChallengeRating(CR11)
			.withProficiencyBonus(4)
			.withArmorClass(17)
			.withHitPoints(Range.closed(221, 235))
			.withAttackBonus(8)
			.withDamagePerRound(Range.closed(69, 74))
			.withSaveDc(17)),
	MS_CR12(newMonsterStats()
			.withChallengeRating(CR12)
			.withProficiencyBonus(4)
			.withArmorClass(17)
			.withHitPoints(Range.closed(236, 250))
			.withAttackBonus(8)
			.withDamagePerRound(Range.closed(75, 80))
			.withSaveDc(17)),
	MS_CR13(newMonsterStats()
			.withChallengeRating(CR13)
			.withProficiencyBonus(5)
			.withArmorClass(18)
			.withHitPoints(Range.closed(251, 265))
			.withAttackBonus(8)
			.withDamagePerRound(Range.closed(81, 86))
			.withSaveDc(18)),
	MS_CR14(newMonsterStats()
			.withChallengeRating(CR14)
			.withProficiencyBonus(5)
			.withArmorClass(18)
			.withHitPoints(Range.closed(266, 280))
			.withAttackBonus(8)
			.withDamagePerRound(Range.closed(87, 92))
			.withSaveDc(18)),
	MS_CR15(newMonsterStats()
			.withChallengeRating(CR15)
			.withProficiencyBonus(5)
			.withArmorClass(18)
			.withHitPoints(Range.closed(281, 295))
			.withAttackBonus(8)
			.withDamagePerRound(Range.closed(93, 98))
			.withSaveDc(18)),
	MS_CR16(newMonsterStats()
			.withChallengeRating(CR16)
			.withProficiencyBonus(5)
			.withArmorClass(18)
			.withHitPoints(Range.closed(296, 310))
			.withAttackBonus(9)
			.withDamagePerRound(Range.closed(99, 104))
			.withSaveDc(18)),
	MS_CR17(newMonsterStats()
			.withChallengeRating(CR17)
			.withProficiencyBonus(6)
			.withArmorClass(19)
			.withHitPoints(Range.closed(311, 325))
			.withAttackBonus(10)
			.withDamagePerRound(Range.closed(105, 110))
			.withSaveDc(19)),
	MS_CR18(newMonsterStats()
			.withChallengeRating(CR18)
			.withProficiencyBonus(6)
			.withArmorClass(19)
			.withHitPoints(Range.closed(326, 340))
			.withAttackBonus(10)
			.withDamagePerRound(Range.closed(111, 116))
			.withSaveDc(19)),
	MS_CR19(newMonsterStats()
			.withChallengeRating(CR19)
			.withProficiencyBonus(6)
			.withArmorClass(19)
			.withHitPoints(Range.closed(341, 355))
			.withAttackBonus(10)
			.withDamagePerRound(Range.closed(117, 122))
			.withSaveDc(19)),
	MS_CR20(newMonsterStats()
			.withChallengeRating(CR20)
			.withProficiencyBonus(6)
			.withArmorClass(19)
			.withHitPoints(Range.closed(356, 400))
			.withAttackBonus(10)
			.withDamagePerRound(Range.closed(123, 140))
			.withSaveDc(19)),
	MS_CR21(newMonsterStats()
			.withChallengeRating(CR21)
			.withProficiencyBonus(7)
			.withArmorClass(19)
			.withHitPoints(Range.closed(401, 445))
			.withAttackBonus(11)
			.withDamagePerRound(Range.closed(141, 158))
			.withSaveDc(20)),
	MS_CR22(newMonsterStats()
			.withChallengeRating(CR22)
			.withProficiencyBonus(7)
			.withArmorClass(19)
			.withHitPoints(Range.closed(446, 490))
			.withAttackBonus(11)
			.withDamagePerRound(Range.closed(159, 176))
			.withSaveDc(20)),
	MS_CR23(newMonsterStats()
			.withChallengeRating(CR23)
			.withProficiencyBonus(7)
			.withArmorClass(19)
			.withHitPoints(Range.closed(491, 535))
			.withAttackBonus(11)
			.withDamagePerRound(Range.closed(177, 194))
			.withSaveDc(20)),
	MS_CR24(newMonsterStats()
			.withChallengeRating(CR24)
			.withProficiencyBonus(7)
			.withArmorClass(19)
			.withHitPoints(Range.closed(536, 580))
			.withAttackBonus(12)
			.withDamagePerRound(Range.closed(195, 212))
			.withSaveDc(21)),
	MS_CR25(newMonsterStats()
			.withChallengeRating(CR25)
			.withProficiencyBonus(8)
			.withArmorClass(19)
			.withHitPoints(Range.closed(581, 625))
			.withAttackBonus(12)
			.withDamagePerRound(Range.closed(213, 230))
			.withSaveDc(21)),
	MS_CR26(newMonsterStats()
			.withChallengeRating(CR26)
			.withProficiencyBonus(8)
			.withArmorClass(19)
			.withHitPoints(Range.closed(626, 670))
			.withAttackBonus(12)
			.withDamagePerRound(Range.closed(231, 248))
			.withSaveDc(21)),
	MS_CR27(newMonsterStats()
			.withChallengeRating(CR27)
			.withProficiencyBonus(8)
			.withArmorClass(19)
			.withHitPoints(Range.closed(671, 715))
			.withAttackBonus(13)
			.withDamagePerRound(Range.closed(249, 266))
			.withSaveDc(22)),
	MS_CR28(newMonsterStats()
			.withChallengeRating(CR28)
			.withProficiencyBonus(8)
			.withArmorClass(19)
			.withHitPoints(Range.closed(716, 760))
			.withAttackBonus(13)
			.withDamagePerRound(Range.closed(267, 284))
			.withSaveDc(22)),
	MS_CR29(newMonsterStats()
			.withChallengeRating(CR29)
			.withProficiencyBonus(9)
			.withArmorClass(19)
			.withHitPoints(Range.closed(761, 805))
			.withAttackBonus(13)
			.withDamagePerRound(Range.closed(285, 302))
			.withSaveDc(22)),
	MS_CR30(newMonsterStats()
			.withChallengeRating(CR30)
			.withProficiencyBonus(9)
			.withArmorClass(19)
			.withHitPoints(Range.closed(806, 850))
			.withAttackBonus(14)
			.withDamagePerRound(Range.closed(303, 320))
			.withSaveDc(23));
	
	private static final RangeMap<Integer, MonsterStats> STATS_BY_HP;
	private static final RangeMap<Integer, MonsterStats> STATS_BY_DPR;
	private static final Map<ChallengeRating, MonsterStats> STATS_BY_CR;
	
	
	private final ChallengeRating challengeRating;
	private final Range<Integer> proficiencyBonus;
	private final Range<Integer> armorClass;
	private final Range<Integer> hitPoints;
	private final Range<Integer> attackBonus;
	private final Range<Integer> damagePerRound;
	private final Range<Integer> saveDc;

	static {
		RangeMap<Integer, MonsterStats> statsByHp = TreeRangeMap.create();
		RangeMap<Integer, MonsterStats> statsByDpr = TreeRangeMap.create();
		Map<ChallengeRating, MonsterStats> statsByCr = Maps.newLinkedHashMap();
		for (MonsterStats stats : MonsterStats.values()) {
			statsByHp.put(stats.getHitPoints(), stats);
			statsByDpr.put(stats.getDamagePerRound(), stats);
			statsByCr.put(stats.getChallengeRating(), stats);
		}
		STATS_BY_HP = ImmutableRangeMap.copyOf(statsByHp);
		STATS_BY_DPR = ImmutableRangeMap.copyOf(statsByDpr);
		STATS_BY_CR = ImmutableMap.copyOf(statsByCr);
	}
	
	public static MonsterStats getStatsByChallengeRating (ChallengeRating cr) {
		checkNotNull(cr);
		return STATS_BY_CR.get(cr);
	}
	
	public static MonsterStats getStatsByHitPoints (int hp) {
		checkArgument(hp > 0);
		if (hp > 850) {
			hp = 850;
		}
		return STATS_BY_HP.get(hp);
	}
	
	public static MonsterStats getStatsByDamagePerRound (int dpr) {
		checkArgument(dpr >= 0);
		if (dpr > 320) {
			dpr = 320;
		}
		return STATS_BY_DPR.get(dpr);
	}
	
	public static ChallengeRating getAverageChallengeRatingByAttackBonus(int hitPoints, int armorClass, int damagePerRound, int attackBonus) {
		ChallengeRating defensiveCr = getDefensiveChallengeRating(hitPoints, armorClass);
		ChallengeRating offensiveCr = getOffensiveChallengeRatingByAttackBonus(damagePerRound, attackBonus);
		return getAverageChallengeRating(defensiveCr, offensiveCr);
	}

	public static ChallengeRating getAverageChallengeRatingBySaveDc(int hitPoints, int armorClass, int damagePerRound, int saveDc) {
		ChallengeRating defensiveCr = getDefensiveChallengeRating(hitPoints, armorClass);
		ChallengeRating offensiveCr = getOffensiveChallengeRatingBySaveDc(damagePerRound, saveDc);
		return getAverageChallengeRating(defensiveCr, offensiveCr);
	}

	public static ChallengeRating getDefensiveChallengeRating(int hitPoints, int armorClass) {
		MonsterStats stats = getStatsByHitPoints(hitPoints);
		ChallengeRating cr = stats.getChallengeRating();
		if (!stats.getArmorClass().contains(armorClass)) {
		    int offset = (armorClass - stats.getArmorClass().upperEndpoint()) / 2;
		    cr = cr.getByOrdinalOffset(offset);
		}
		return cr;
	}

	
	public static ChallengeRating getOffensiveChallengeRatingByAttackBonus(int damagePerRound, int attackBonus) {
		MonsterStats stats = getStatsByDamagePerRound(damagePerRound);
		ChallengeRating cr = stats.getChallengeRating();
		if (!stats.getAttackBonus().contains(attackBonus)) {
		    int offset = (attackBonus - stats.getAttackBonus().upperEndpoint()) / 2;
		    cr = cr.getByOrdinalOffset(offset);
		}
		return cr;
	}

	public static ChallengeRating getOffensiveChallengeRatingBySaveDc(int damagePerRound, int saveDc) {
		MonsterStats stats = getStatsByDamagePerRound(damagePerRound);
		ChallengeRating cr = stats.getChallengeRating();
		if (!stats.getSaveDc().contains(saveDc)) {
		    int offset = (saveDc - stats.getSaveDc().upperEndpoint()) / 2;
		    cr = cr.getByOrdinalOffset(offset);
		}
		return cr;
	}

	private static ChallengeRating getAverageChallengeRating(
			ChallengeRating defensiveCr, ChallengeRating offensiveCr) {
		double value = (((double) defensiveCr.getValue()) + offensiveCr.getValue()) / 2;
		ChallengeRating averageCr;
		if (value < CR1_8.getValue() / 2) {
			averageCr = CR0;
		} else if (value < (CR1_8.getValue() + CR1_4.getValue()) / 2) {
			averageCr = CR1_8;
		} else if (value < (CR1_4.getValue() + CR1_2.getValue()) / 2) {
			averageCr = CR1_4;
		} else if (value < (CR1_2.getValue() + CR1.getValue()) / 2) {
			averageCr = CR1_2;
		} else {
			value = Math.round(value);
			averageCr = ChallengeRating.get(value);
		}
		return averageCr;
	}

	private static Builder newMonsterStats () {
		return new Builder();
	}
	
	private MonsterStats (Builder builder) {
		this.challengeRating = builder.challengeRating;
		this.proficiencyBonus = builder.proficiencyBonus;
		this.armorClass = builder.armorClass;
		this.hitPoints = builder.hitPoints;
		this.attackBonus = builder.attackBonus;
		this.damagePerRound = builder.damagePerRound; 
		this.saveDc = builder.saveDc;
    	checkNotNull(challengeRating);
    	checkNotNull(proficiencyBonus);
    	checkNotNull(armorClass);
    	checkNotNull(hitPoints);
    	checkNotNull(attackBonus);
    	checkNotNull(damagePerRound);
    	checkNotNull(saveDc);
	}
	
	public ChallengeRating getChallengeRating() {
		return challengeRating;
	}

	public Range<Integer> getProficiencyBonus() {
		return proficiencyBonus;
	}

	public Range<Integer> getArmorClass() {
		return armorClass;
	}

	public Range<Integer> getHitPoints() {
		return hitPoints;
	}

	public Range<Integer> getAttackBonus() {
		return attackBonus;
	}

	public Range<Integer> getDamagePerRound() {
		return damagePerRound;
	}

	public Range<Integer> getSaveDc() {
		return saveDc;
	}

	public static class Builder {
		private ChallengeRating challengeRating;
		private Range<Integer> proficiencyBonus;
		private Range<Integer> armorClass;
		private Range<Integer> hitPoints;
		private Range<Integer> attackBonus;
		private Range<Integer> damagePerRound;
		private Range<Integer> saveDc;
		
		private Builder () {}

		public Builder withChallengeRating(ChallengeRating challengeRating) {
			checkNotNull(challengeRating);
			this.challengeRating = challengeRating;
			return this;
		}

		public Builder withProficiencyBonus(int proficiencyBonus) {
			return withProficiencyBonus(Range.singleton(proficiencyBonus));
		}

		public Builder withProficiencyBonus(Range<Integer> proficiencyBonus) {
			checkNotNull(proficiencyBonus);
			checkArgument(proficiencyBonus.lowerEndpoint() > 0);
			this.proficiencyBonus = proficiencyBonus;
			return this;
		}

		public Builder withArmorClass(int armorClass) {
			return withArmorClass(Range.singleton(armorClass));
		}

		public Builder withArmorClass(Range<Integer> armorClass) {
			checkNotNull(armorClass);
			checkArgument(armorClass.lowerEndpoint() >= 0);
			this.armorClass = armorClass;
			return this;
		}

		public Builder withHitPoints(int hitPoints) {
			return withHitPoints(Range.singleton(hitPoints));
		}

		public Builder withHitPoints(Range<Integer> hitPoints) {
			checkNotNull(hitPoints);
			checkArgument(hitPoints.lowerEndpoint() > 0);
			this.hitPoints = hitPoints;
			return this;
		}

		public Builder withAttackBonus(int attackBonus) {
			return withAttackBonus(Range.singleton(attackBonus));
		}

		public Builder withAttackBonus(Range<Integer> attackBonus) {
			checkNotNull(attackBonus);
			checkArgument(attackBonus.lowerEndpoint() >= 0);
			this.attackBonus = attackBonus;
			return this;
		}

		public Builder withDamagePerRound(int damagePerRound) {
			return withDamagePerRound(Range.singleton(damagePerRound));
		}

		public Builder withDamagePerRound(Range<Integer> damagePerRound) {
			checkNotNull(damagePerRound);
			checkArgument(damagePerRound.lowerEndpoint() >= 0);
			this.damagePerRound = damagePerRound;
			return this;
		}

		public Builder withSaveDc(int saveDc) {
			return withSaveDc(Range.singleton(saveDc));
		}

		public Builder withSaveDc(Range<Integer> saveDc) {
			checkNotNull(saveDc);
			checkArgument(saveDc.lowerEndpoint() >= 0);
			this.saveDc = saveDc;
			return this;
		}
		
	}
	
	public static void main(String[] args) {
		ChallengeRating cr = MonsterStats.getAverageChallengeRatingByAttackBonus(9, 17, 9, 7);
		System.out.println(cr);
	}
}
