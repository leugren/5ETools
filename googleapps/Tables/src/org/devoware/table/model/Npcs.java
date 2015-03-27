package org.devoware.table.model;

import static org.devoware.table.dice.Die.D10;
import static org.devoware.table.dice.Die.D12;
import static org.devoware.table.dice.Die.D20;
import static org.devoware.table.dice.Die.D6;
import static org.devoware.table.model.ValueRangeMap.newValueRangeMap;

public class Npcs {

	public static final RandomizableStringSource APPEARANCE = newValueRangeMap(D20)
			.with(1, "Distinctive jewelry, earrings, necklace, circlet, bracelets")
			.with(2, "Piercings")
			.with(3, "Flamboyant or outlandish clothes")
			.with(4, "Formal, clean clothes")
			.with(5, "Ragged, dirty clothes")
			.with(6, "Pronounced scar")
			.with(7, "Missing teeth")
			.with(8, "Missing fingers")
			.with(9, "Unusual eye color (or two different colors)")
			.with(10, "Tattoos")
			.with(11, "Birthmark")
			.with(12, "Unusual skin color")
			.with(13, "Bald")
			.with(14, "Braided beard or hair")
			.with(15, "Unusual hair color")
			.with(16, "Nervous eye twitch")
			.with(17, "Distinctive nose")
			.with(18, "Distinctive posture (crooked or rigid)")
			.with(19, "Exceptionally beautiful")
			.with(20, "Exceptionally ugly")
			.build();

	public static final RandomizableStringSource HIGH_ABILITY = newValueRangeMap(D6)
			.with(1, "Strength--powerful, brawny, strong as an ox")
			.with(2, "Dexterity--lithe, agile, graceful")
			.with(3, "Constitution--hardy, hale, healthy")
			.with(4, "Intelligence--studious, learned, inquisitive")
			.with(5, "Wisdom--perceptive, spiritual, insightful")
			.with(6, "Charisma--persuasive, forceful, born leader")
			.build();

	public static final RandomizableStringSource LOW_ABILITY = newValueRangeMap(D6)
			.with(1, "Strength--feeble, scrawny")
			.with(2, "Dexterity--clumsy, fumbling")
			.with(3, "Constitution--sickly, pale")
			.with(4, "Intelligence--dim-witted, slow")
			.with(5, "Wisdom--oblivious, absentminded")
			.with(6, "Charisma--dull, boring")
			.build();

	public static final RandomizableStringSource TALENTS = newValueRangeMap(D20)
			.with(1, "Plays a musical instrument")
			.with(2, "Speaks several languages fluently")
			.with(3, "Unbelievably lucky")
			.with(4, "Perfect memory")
			.with(5, "Great with animals")
			.with(6, "Great with children")
			.with(7, "Great at solving puzzles")
			.with(8, "Great at one game")
			.with(9, "Great at impersonations")
			.with(10, "Draws beautifully")
			.with(11, "Paints beautifully")
			.with(12, "Sings beautifully")
			.with(13, "Drinks everyone under the table")
			.with(14, "Expert carpenter")
			.with(15, "Expert cook")
			.with(16, "Expert dart thrower and rock skipper")
			.with(17, "Expert juggler")
			.with(18, "Skilled actor and master of disguise")
			.with(19, "Skilled dancer")
			.with(20, "Knows thieves' cant")
			.build();
	
	public static final RandomizableStringSource MANNERISMS = newValueRangeMap(D20)
			.with(1, "Prone to singing, whistling, and hmming quietly")
			.with(2, "Speaks in rhyme or some other peculiar way")
			.with(3, "Particularly low or high voice")
			.with(4, "Slurs words, lisps, or stutters")
			.with(5, "Enunciates overly clearly")
			.with(6, "Speaks loudly")
			.with(7, "Whispers")
			.with(8, "Uses flowery speech or long words")
			.with(9, "Frequently uses the wrong word")
			.with(10, "Uses colorful oaths and exclamations")
			.with(11, "Makes constant jokes or puns")
			.with(12, "Prone to predictions of doom")
			.with(13, "Fidgets")
			.with(14, "Squints")
			.with(15, "Stares into the distance")
			.with(16, "Chews something")
			.with(17, "Paces")
			.with(18, "Taps fingers")
			.with(19, "Bites fingernails")
			.with(20, "Twirls hair or tugs beard")
			.build();
	
	public static final RandomizableStringSource INTERACTION_TRAITS = newValueRangeMap(D12)
			.with(1, "Argumentative")
			.with(2, "Arrogant")
			.with(3, "Blustering")
			.with(4, "Rude")
			.with(5, "Curious")
			.with(6, "Friendly")
			.with(7, "Honest")
			.with(8, "Hot tempered")
			.with(9, "Irritable")
			.with(10, "Ponderous")
			.with(11, "Quiet")
			.with(12, "Suspicious")
			.build();
	
	public static final RandomizableStringSource GOOD_IDEALS = newValueRangeMap(D6)
			.with(1, "Beauty")
			.with(2, "Charity")
			.with(3, "Greater good")
			.with(4, "Life")
			.with(5, "Respect")
			.with(6, "Self-sacrifice")
			.build();
	
	public static final RandomizableStringSource EVIL_IDEALS = newValueRangeMap(D6)
			.with(1, "Domination")
			.with(2, "Greed")
			.with(3, "Might")
			.with(4, "Pain")
			.with(5, "Retribution")
			.with(6, "Slaughter")
			.build();

	public static final RandomizableStringSource LAWFUL_IDEALS = newValueRangeMap(D6)
			.with(1, "Community")
			.with(2, "Fairness")
			.with(3, "Honor")
			.with(4, "Logic")
			.with(5, "Responsibility")
			.with(6, "Tradition")
			.build();
	
	public static final RandomizableStringSource CHAOTIC_IDEALS = newValueRangeMap(D6)
			.with(1, "Change")
			.with(2, "Creativity")
			.with(3, "Freedom")
			.with(4, "Independence")
			.with(5, "No limits")
			.with(6, "Whimsy")
			.build();
	
	public static final RandomizableStringSource NEUTRAL_IDEALS = newValueRangeMap(D6)
			.with(1, "Balance")
			.with(2, "Knowledge")
			.with(3, "Live and let live")
			.with(4, "Moderation")
			.with(5, "Neutrality")
			.with(6, "People")
			.build();

	public static final RandomizableStringSource OTHER_IDEALS = newValueRangeMap(D6)
			.with(1, "Aspiration")
			.with(2, "Discovery")
			.with(3, "Glory")
			.with(4, "Nations")
			.with(5, "Redemption")
			.with(6, "Self-knowledge")
			.build();
	
	public static final RandomizableStringSource IDEALS = newValueRangeMap(D6)
			.with(1, GOOD_IDEALS)
			.with(2, EVIL_IDEALS)
			.with(3, LAWFUL_IDEALS)
			.with(4, CHAOTIC_IDEALS)
			.with(5, NEUTRAL_IDEALS)
			.with(6, OTHER_IDEALS)
			.build();


	public static final RandomizableStringSource BONDS = newValueRangeMap(D10)
			.with(1, "Dedicated to fulfilling a personal life goal")
			.with(2, "Protective of close family members")
			.with(3, "Protective of colleagues or compatriots")
			.with(4, "Loyal to a benefactor, patron, or employer")
			.with(5, "Captivated by a romantic interest")
			.with(6, "Drawn to a special place")
			.with(7, "Protective of a sentimental keepsake")
			.with(8, "Protective of a valuable possession")
			.with(9, "Out for revenge")
			.withRollMultiple(10, 2)
			.build();

	public static final RandomizableStringSource FLAWS_AND_SECRETS = newValueRangeMap(D12)
			.with(1, "Forbidden love or susceptibility to romance")
			.with(2, "Enjoys decadent pleasures")
			.with(3, "Arrogance")
			.with(4, "Envies another creature's possessions or station")
			.with(5, "Overpowering greed")
			.with(6, "Prone to rage")
			.with(7, "Has a powerful enemy")
			.with(8, "Specific phobia")
			.with(9, "Shameful or scandalous history")
			.with(10, "Secret crime or deed")
			.with(11, "Possession of forbidden lore")
			.with(12, "Foolhardy bravery")
			.build();
}
