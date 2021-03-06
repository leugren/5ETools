package org.devoware.table.model;

import static org.devoware.table.dice.Die.*;
import static org.devoware.table.model.ValueRangeMap.newValueRangeMap;


public class Villains {
	
	public static final RandomizableStringSource VILLAINS_SCHEME = newValueRangeMap(D8)
			.with(1, FormattedValue.newFormattedValue("Immortality - %s",
					newValueRangeMap(D4)
					    .with(1, "Acquire a legendary item to prolong life")
					    .with(2, "Ascend to godhood")
					    .with(3, "Become undead or obtain a younger body")
					    .with(4, "Steal a planar creature's essence")
					    .build()
					))
			.with(2, FormattedValue.newFormattedValue("Influence - %s",
					newValueRangeMap(D4)
					    .with(1, "Seize a position of power or title")
					    .with(2, "Win a contest or tournament")
					    .with(3, "Win favor with a powerful individual")
					    .with(4, "Place a pawn in a position of power")
					    .build()
					))
			.with(3, FormattedValue.newFormattedValue("Magic - %s",
					newValueRangeMap(D6)
					    .with(1, "Obtain an ancient artifact")
					    .with(2, "Build or contruct a magical device")
					    .with(3, "Carry out a deity's wishes")
					    .with(4, "Offer sacrifices to a deity")
					    .with(5, "Contact a lost deity or power")
					    .with(6, "Open a gate to another world")
					    .build()
					))
			.with(4, FormattedValue.newFormattedValue("Mayhem - %s",
					newValueRangeMap(D6)
					    .with(1, "Fulfill an apocalyptic prophesy")
					    .with(2, "Enact the vengeful will of a god or patron")
					    .with(3, "Spread a vile contagion")
					    .with(4, "Overthrow a government")
					    .with(5, "Trigger a natural disaster")
					    .with(6, "Utterly destroy a bloodline or clan")
					    .build()
					))
			.with(5, FormattedValue.newFormattedValue("Passion - %s",
					newValueRangeMap(D4)
					    .with(1, "Prolong the life of a loved one")
					    .with(2, "Prove worthy of a another person's love")
					    .with(3, "Raise or restore a dead loved one")
					    .with(4, "Destroy rivals for another person's affection")
					    .build()
					))
			.with(6, FormattedValue.newFormattedValue("Power - %s",
					newValueRangeMap(D4)
					    .with(1, "Conquer a region or incite a rebellion")
					    .with(2, "Seize control of an army")
					    .with(3, "Become the power behind the throne")
					    .with(4, "Gain the favor of a ruler")
					    .build()
					))
			.with(7, FormattedValue.newFormattedValue("Revenge - %s",
					newValueRangeMap(D4)
					    .with(1, "Avenge a past humiliation")
					    .with(2, "Avenge a past imprisonment or injury")
					    .with(3, "Avenge the death of a loved one")
					    .with(4, "Retrieve stolen property and punish the thief")
					    .build()
					))
			.with(8, FormattedValue.newFormattedValue("Wealth - %s",
					newValueRangeMap(D4)
					    .with(1, "Control natural resources or trade")
					    .with(2, "Marry into wealth")
					    .with(3, "Plunder ancient ruins")
					    .with(4, "Steal land, goods, and more")
					    .build()
					))
			.build();

	public static final RandomizableStringSource VILLAINS_METHOD = newValueRangeMap(D20)
			.with(1, FormattedValue.newFormattedValue("Agricultural devastation - %s",
					newValueRangeMap(D4)
					    .with(1, "Blight")
					    .with(2, "Crop failure")
					    .with(3, "Drought")
					    .with(4, "Famine")
					    .build()
					))
			.with(2, "Assault or beatings")		
			.with(3, "Bounty hunting or assassination")		
			.with(4, FormattedValue.newFormattedValue("Captivity or coercion - %s",
					newValueRangeMap(D10)
					    .with(1, "Bribery")
					    .with(2, "Enticement")
					    .with(3, "Eviction")
					    .with(4, "Imprisonment")
					    .with(5, "Kidnapping")
					    .with(6, "Legal intimidation")
					    .with(7, "Press gangs")
					    .with(8, "Shackling")
					    .with(9, "Slavery")
					    .with(10, "Threats or harassment")
					    .build()
					))
			.with(5, FormattedValue.newFormattedValue("Confidence scams - %s",
					newValueRangeMap(D6)
					    .with(1, "Breach of contract")
					    .with(2, "Cheating")
					    .with(3, "Fast talking")
					    .with(4, "Fine print")
					    .with(5, "Fraud or swindling")
					    .with(6, "Quackery or tricks")
					    .build()
					))
			.with(6, FormattedValue.newFormattedValue("Dafamation - %s",
					newValueRangeMap(D4)
					    .with(1, "Framing")
					    .with(2, "Gossiping or slander")
					    .with(3, "Humiliation")
					    .with(4, "Libel or insults")
					    .build()
					))
			.with(7, "Dueling")		
			.with(8, FormattedValue.newFormattedValue("Execution - %s",
					newValueRangeMap(D8)
					    .with(1, "Beheading")
					    .with(2, "Burning at the stake")
					    .with(3, "Burying alive")
					    .with(4, "Crucifixion")
					    .with(5, "Drawing and quartering")
					    .with(6, "Hanging")
					    .with(7, "Impalement")
					    .with(8, "Sacrifice (living)")
					    .build()
					))
			.with(9, "Impersonation or disguise")		
			.with(10, "Lying or perjury")		
			.with(11, FormattedValue.newFormattedValue("Magical mayhem - %s",
					newValueRangeMap(D8)
					    .with(1, "Hauntings")
					    .with(2, "Illusions")
					    .with(3, "Infernal bargains")
					    .with(4, "Mind control")
					    .with(5, "Petrification")
					    .with(6, "Raising or animating the dead")
					    .with(7, "Summoning monsters")
					    .with(8, "Weather control")
					    .build()
					))
			.with(12, FormattedValue.newFormattedValue("Murder - %s",
					newValueRangeMap(D10)
					    .with(1, "Assassination")
					    .with(2, "Cannibalism")
					    .with(3, "Dismemberment")
					    .with(4, "Drowning")
					    .with(5, "Electrocution")
					    .with(6, "Euthanasia (involuntary)")
					    .with(7, "Disease")
					    .with(8, "Poisoning")
					    .with(9, "Stabbing")
					    .with(10, "Strangulation or suffocation")
					    .build()
					))
			.with(13, "Neglect")		
			.with(14, FormattedValue.newFormattedValue("Politics - %s",
					newValueRangeMap(D6)
					    .with(1, "Betrayal or treason")
					    .with(2, "Conspiracy")
					    .with(3, "Espionage or spying")
					    .with(4, "Genocide")
					    .with(5, "Oppression")
					    .with(6, "Raising taxes")
					    .build()
					))
			.with(15, FormattedValue.newFormattedValue("Religion - %s",
					newValueRangeMap(D4)
					    .with(1, "Curses")
					    .with(2, "Desecration")
					    .with(3, "False gods")
					    .with(4, "Heresy or cults")
					    .build()
					))
			.with(16, "Stalking")		
			.with(17, FormattedValue.newFormattedValue("Theft or property crime - %s",
					newValueRangeMap(D10)
					    .with(1, "Arson")
					    .with(2, "Blackmail or extortion")
					    .with(3, "Burglary")
					    .with(4, "Counterfeiting")
					    .with(5, "Highway robbery")
					    .with(6, "Looting")
					    .with(7, "Mugging")
					    .with(8, "Poaching")
					    .with(9, "Seizing property")
					    .with(10, "Smuggling")
					    .build()
					))
			.with(18, FormattedValue.newFormattedValue("Torture - %s",
					newValueRangeMap(D6)
					    .with(1, "Acid")
					    .with(2, "Blinding")
					    .with(3, "Branding")
					    .with(4, "Racking")
					    .with(5, "Thumbscrews")
					    .with(6, "Whipping")
					    .build()
					))
			.with(19, FormattedValue.newFormattedValue("Vice - %s",
					newValueRangeMap(D4)
					    .with(1, "Adultery")
					    .with(2, "Drugs and alcohol")
					    .with(3, "Gambling")
					    .with(4, "Seduction")
					    .build()
					))
			.with(20, FormattedValue.newFormattedValue("Warfare - %s",
					newValueRangeMap(D6)
					    .with(1, "Ambush")
					    .with(2, "Invasion")
					    .with(3, "Massacre")
					    .with(4, "Mercenaries")
					    .with(5, "Rebellion")
					    .with(6, "Terrorism")
					    .build()
					))
			.build();

	public static final RandomizableStringSource VILLAINS_WEAKNESS = newValueRangeMap(D8)
			.with(1, "A hidden object holds the villain's soul.")
			.with(2, "The villain's power is broken if the death of its true love is avenged.")
			.with(3, "The villain is weakened in the presence of a particular artifact.")
			.with(4, "A special weapon deals extra damage when used against the villain.")
			.with(5, "The villain is destroyed if it speaks its true name.")
			.with(6, "An ancient prophesy reveals how the villain can be overthrown.")
			.with(7, "The villain falls when an ancient enemy forgives its past actions.")
			.with(8, "The villain loses its power if a mystic bargain it struck long ago is completed.")
			.build();

}
