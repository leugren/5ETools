package org.devoware.table.model;

import static org.devoware.table.dice.Die.*;
import static org.devoware.table.model.IdealSet.newIdealSet;
import static org.devoware.table.model.IdealType.*;
import static org.devoware.table.model.NamedRandomizableStringSource.newNamedStringSource;
import static org.devoware.table.model.ValueRangeMap.newValueRangeMap;

public class PcPersonalities {
	
	public static final RandomizableStringSource ACOLYTE_TRAITS = newValueRangeMap(D8)
			.with(1, "I idolize a particular hero of my faith and constantly refer to that person's deeds and example.")
			.with(2, "I can find common ground between the fiercest enemies, empathizing with them and always working toward peace.")
			.with(3, "I see omens in every event and action. The gods try to speak to us, we just need to listen.")
			.with(4, "Nothing can shake my optimistic attitude.")
			.with(5, "I quote (or misquote) the sacred texts and proverbs in almost every situation.")
			.with(6, "I am tolerant (or intolerant) of other faiths and respect (or condemn) the worship of other gods.")
			.with(7, "I've enjoyed fine food, drink, and high society among my temple's elite. Rough living grates on me.")
			.with(8, "I've spent so long in the temple that I have little practical experience dealing with people in the outside world.")
			.build();

	public static final IdealSet ACOLYTE_IDEALS = newIdealSet()
			.with(LAWFUL, "Tradition. The ancient traditions of worship and sacrifice must be preserved and upheld. (Lawful)")
			.with(GOOD, "Charity. I always try to help those in need, no matter what the personal cost. (Good)")
			.with(CHAOTIC, "Change. We must help bring about the changes the gods are constantly working in the world. (Chaotic)")
			.with(LAWFUL, "Power. I hope to one day rise to the top of my faith's religious hierarchy. (Lawful)")
			.with(ANY, "Aspiration. I seek to prove my self worthy of my god's favor by matching my actions against his or her teachings. (Any)")
	        .build();

	public static final RandomizableStringSource ACOLYTE_BONDS = newValueRangeMap(D6)
			.with(1, "I would die to recover an ancient artifact of my faith that was lost long ago.")
			.with(2, "I will someday get revenge on the corrupt temple hierarchy who branded me a heretic.")
			.with(3, "I owe my life to the priest who took me in when my parents died.")
			.with(4, "Everything I do is for the common people.")
			.with(5, "I will do anything to protect the temple where I served.")
			.with(6, "I seek to preserve a sacred text that my enemies consider heretical and seek to destroy.")
			.build();

	public static final RandomizableStringSource ACOLYTE_FLAWS = newValueRangeMap(D6)
			.with(1, "I judge others harshly, and myself even more severely.")
			.with(2, "I put too much trust in those who wield power within my temple's hierarchy.")
			.with(3, "My piety sometimes leads me to blindly trust those that profess faith in my god.")
			.with(4, "I am inflexible in my thinking.")
			.with(5, "I am suspicious of strangers and suspect the worst of them.")
			.with(6, "Once I pick a goal, I become obsessed with it to the detriment of everything else in my life.")
			.build();
	
	public static final Background ACOLYTE = Background.newBackground()
			.withName("Acolyte")
			.withBonds(ACOLYTE_BONDS)
			.withFlaws(ACOLYTE_FLAWS)
			.withTraits(ACOLYTE_TRAITS)
			.withIdeals(ACOLYTE_IDEALS)
			.build();

	public static final RandomizableStringSource CHARLATAN_TRAITS = newValueRangeMap(D8)
			.with(1, "I fall in and out of love easily, and am always pursuing someone.")
			.with(2, "I have a joke for every occasion, especially occasions where humor is inappropriate.")
			.with(3, "Flattery is my preferred trick for getting what I want.")
			.with(4, "I'm a born gambler who can't resist taking a risk for a potential payoff.")
			.with(5, "I lie about almost everything, even when there's no good reason to.")
			.with(6, "Sarcasm and insults are my weapons of choice.")
			.with(7, "I keep multiple holy symbols on me and invoke whatever deity might come in useful at any given moment.")
			.with(8, "I pocket anything I see that might have some value.")
			.build();

	public static final IdealSet CHARLATAN_IDEALS = newIdealSet()
			.with(CHAOTIC, "Independence. I am a free spirit--no one tells me what to do. (Chaotic)")
			.with(LAWFUL, "Fairness. I never target people who can't afford to lose a few coins. (Lawful)")
			.with(GOOD, "Charity. I distribute money I acquire to the people who really need it. (Good)")
			.with(CHAOTIC, "Creativity. I never run the same con twice. (Chaotic)")
			.with(GOOD, "Friendship. Material goods come and go. Bonds of friendship last forever. (Good)")
			.with(ANY, "Aspiration. I'm determined to make something of myself. (Any)")
			.build();

	public static final RandomizableStringSource CHARLATAN_BONDS = newValueRangeMap(D6)
			.with(1, "I fleeced the wrong person and must work to ensure that this individual never crosses paths with me or those I care about.")
			.with(2, "I owe everything to my mentor--a horrible person who's probably rotting in jail somewhere.")
			.with(3, "Somewhere out there I have a child who doesn't know me. I'm making the world better for him or her.")
			.with(4, "I come from a noble family, and one day I'll reclaim my lands and title from those who stole them from me.")
			.with(5, "A powerful person killed someone I love. Some day soon, I'll have my revenge.")
			.with(6, "I swindled and ruined a person who didn't deserve it. I seek to atone for my misdeeds but might never be able to forgive myself.")
			.build();

	
	public static final RandomizableStringSource CHARLATAN_FLAWS = newValueRangeMap(D6)
			.with(1, "I can't resist a pretty face.")
			.with(2, "I'm always in debt. I spend my ill-gotten gains on decadent luxuries faster than I bring them in.")
			.with(3, "I'm convinced that no one could ever fool me in the way I fool others.")
			.with(4, "I'm too greedy for my own good. I can't resist taking a risk if there's money involved.")
			.with(5, "I can't resist swindling people who are more powerful than me.")
			.with(6, "I hate to admit it and will hate myself for it, but I'll run and preserve my own hide if the going gets tough.")
			.build();

	public static final Background CHARLATAN = Background.newBackground()
			.withName("Charlatan")
			.withBonds(CHARLATAN_BONDS)
			.withFlaws(CHARLATAN_FLAWS)
			.withTraits(CHARLATAN_TRAITS)
			.withIdeals(CHARLATAN_IDEALS)
			.withAdditionalTable(newNamedStringSource("Favorite Scheme", 
					newValueRangeMap(D6)
					.with(1, "I cheat at games of chance.")
					.with(2, "I shave coins or forge documents.")
					.with(3, "I insinuate myself into people's lives to prey on their weaknesses and secure their fortunes.")
					.with(4, "I put on new identities like clothes.")
					.with(5, "I run sleight-of-hand cons on street corners.")
					.with(6, "I convince people that worthless junk is worth their hard-earned money.")
					.build(),
					false))
			.build();

	public static final RandomizableStringSource CRIMINAL_TRAITS = newValueRangeMap(D8)
			.with(1, "I always have plan for what to do when things go wrong.")
			.with(2, "I am always calm, no matter what the situation. I never raise my voice or let my emotions control me.")
			.with(3, "The first thing I do in a new place is note the locations of everything valuable--or where such things could be hidden.")
			.with(4, "I would rather make a new friend than a new enemy.")
			.with(5, "I am incredibly slow to trust. Those who seem the fairest often have the most to hide.")
			.with(6, "I don't pay attention to the risks in a situation. Never tell me the odds.")
			.with(7, "The best way to get me to do something is to tell me I can't do it.")
			.with(8, "I blow up at the slightest insult.")
			.build();

	public static final IdealSet CRIMINAL_IDEALS = newIdealSet()
			.with(LAWFUL, "Honor. I don't steal from others in the trade. (Lawful)")
			.with(CHAOTIC, "Freedom. Chains are meant to be broken, as are those who would forge them. (Chaotic)")
			.with(GOOD, "Charity. I steal from the wealthy so that I can help people in need. (Good)")
			.with(EVIL, "Greed. I will do whatever it takes to become wealthy. (Evil)")
			.with(NEUTRAL, "People. I'm loyal to my friends, not to any ideals, and everyone else can take a trip down the Styx for all I care. (Neutral)")
			.with(GOOD, "Redemption. There's a spark of good in everyone. (Good)")
			.build();

	public static final RandomizableStringSource CRIMINAL_BONDS = newValueRangeMap(D6)
			.with(1, "I'm trying to pay off an old debt I owe to a generous benefactor.")
			.with(2, "My ill-gotten gains go to support my family.")
			.with(3, "Something important was taken from me, and I aim to steal it back.")
			.with(4, "I will become the greatest thief that ever lived.")
			.with(5, "I'm guilty of a terrible crime. I hope I can redeem myself for it.")
			.with(6, "Someone I loved died because of a mistake I made. That will never happen again.")
			.build();

	
	public static final RandomizableStringSource CRIMINAL_FLAWS = newValueRangeMap(D6)
			.with(1, "When I see something valuable, I can't think about anything but how to steal it.")
			.with(2, "When faced with a choice between money and my friends, I usually choose the money.")
			.with(3, "If there's a plan, I'll forget it. If I don't forget it, I'll ignore it.")
			.with(4, "I have a 'tell' that reveals when I'm lying.")
			.with(5, "I turn tail and run when things go bad.")
			.with(6, "An innocent person is in prison for a crime that I committed. I'm okay with that.")
			.build();

	public static final Background CRIMINAL = Background.newBackground()
			.withName("Criminal")
			.withBonds(CRIMINAL_BONDS)
			.withFlaws(CRIMINAL_FLAWS)
			.withTraits(CRIMINAL_TRAITS)
			.withIdeals(CRIMINAL_IDEALS)
			.withAdditionalTable(newNamedStringSource("Criminal Specialty", 
					newValueRangeMap(D8)
					.with(1, "Blackmailer")
					.with(2, "Burglar")
					.with(3, "Enforcer")
					.with(4, "Fence")
					.with(5, "Highway robber")
					.with(6, "Hired killer")
					.with(7, "Pickpocket")
					.with(8, "Smuggler")
					.build(),
					false))
			.build();

	public static final RandomizableStringSource ENTERTAINER_TRAITS = newValueRangeMap(D8)
			.with(1, "I know a story relevant to almost every situation.")
			.with(2, "Whenever I come to a new place, I collect local rumors and spread gossip.")
			.with(3, "I'm a hopeless romantic, always searching for that 'special someone'.")
			.with(4, "Nobody stays angry at me or around me for long, since I can defuse any amount of tension.")
			.with(5, "I love a good insult, even one directed at me.")
			.with(6, "I get bitter if I'm not the center of attention.")
			.with(7, "I'll settle for nothing less than perfection.")
			.with(8, "I change my mood or my mind as quickly as I change key in a song.")
			.build();

	public static final IdealSet ENTERTAINER_IDEALS = newIdealSet()
			.with(GOOD, "Beauty. When I perform, I make the world better than it was. (Good)")
			.with(LAWFUL, "Tradition. The stories, legends, and songs of the past must never be forgotten. (Lawful)")
			.with(CHAOTIC, "Creativity. The world is in need of new ideas and bold action. (Chaotic)")
			.with(EVIL, "Greed. I'm only in it for the money and fame. (Evil)")
			.with(NEUTRAL, "People. I like seeing the smiles on people's faces when I perform. That's all that matters. (Neutral)")
			.with(ANY, "Honesty. Art should reflect the soul; it should come from within and reveal who we really are. (Any)")
			.build();

	public static final RandomizableStringSource ENTERTAINER_BONDS = newValueRangeMap(D6)
			.with(1, "My instrument is my most treasured possession, and it reminds me of someone I love.")
			.with(2, "Someone stole my precious instrument, and someday I'll get it back.")
			.with(3, "I want to be famous, whatever it takes.")
			.with(4, "I idolize a hero of the old tales and measure my deeds against that person's.")
			.with(5, "I will do anything to prove myself superior to me hated rival.")
			.with(6, "I would do anything for the other members of my old troupe.")
			.build();

	
	public static final RandomizableStringSource ENTERTAINER_FLAWS = newValueRangeMap(D6)
			.with(1, "I'll do anything to win fame and renown.")
			.with(2, "I'm a sucker for a pretty face.")
			.with(3, "A scandal prevents me from ever going home again. That kind of trouble seems to follow me around.")
			.with(4, "I once satirized a noble who still wants my head. It was a mistake that I will likely repeat.")
			.with(5, "I have trouble keeping my true feelings hidden. My sharp tongue lands me in trouble.")
			.with(6, "Despite my best efforts, I am unreliable to my friends.")
			.build();

	public static final Background ENTERTAINER = Background.newBackground()
			.withName("Entertainer")
			.withBonds(ENTERTAINER_BONDS)
			.withFlaws(ENTERTAINER_FLAWS)
			.withTraits(ENTERTAINER_TRAITS)
			.withIdeals(ENTERTAINER_IDEALS)
			.withAdditionalTable(newNamedStringSource("Entertainer Routine", 
					newValueRangeMap(D10)
					.with(1, "Actor")
					.with(2, "Dancer")
					.with(3, "Fire-eater")
					.with(4, "Jester")
					.with(5, "Juggler")
					.with(6, "Instrumentalist")
					.with(7, "Poet")
					.with(8, "Singer")
					.with(9, "Storyteller")
					.with(10, "Tumbler")
					.build(),
					false))
			.build();

	public static final RandomizableStringSource FOLK_HERO_TRAITS = newValueRangeMap(D8)
			.with(1, "I judge people by their actions, not their words.")
			.with(2, "If someone is in trouble, I'm always willing to lend help.")
			.with(3, "When I set my mind to something, I follow through no matter what gets in my way.")
			.with(4, "I have a strong sense of fair play and always try to find the most equitable solution to arguments.")
			.with(5, "I'm confident in my own abilities and do what I can to instill confidence in others.")
			.with(6, "Thinking is for other people. I prefer action.")
			.with(7, "I misuse long words in an attempt to sound smarter.")
			.with(8, "I get bored easily. When am I going to get on with my destiny.")
			.build();

	public static final IdealSet FOLK_HERO_IDEALS = newIdealSet()
			.with(GOOD, "Respect. People deserve to be treated with dignity and respect. (Good)")
			.with(LAWFUL, "Fairness. No one should get preferential treatment before the law, and no one is above the law. (Lawful)")
			.with(CHAOTIC, "Freedom. Tyrants must not be allowed to oppress the people. (Chaotic)")
			.with(EVIL, "Might. If I become strong, I can take what I want--what I deserve. (Evil)")
			.with(NEUTRAL, "Sincerity. There's no good pretending to be something I'm not. (Neutral)")
			.with(ANY, "Destiny. Nothing and no one can steer me away from my higher calling. (Any)")
			.build();

	public static final RandomizableStringSource FOLK_HERO_BONDS = newValueRangeMap(D6)
			.with(1, "I have a family, but I have no idea where they are. One day, I hope to see them again.")
			.with(2, "I worked the land, I love the land, and I will protect the land.")
			.with(3, "A proud noble once gave me a horrible beating, and I will take my revenge on any bully I encounter.")
			.with(4, "My tools are symbols of my past life, and I carry them so that I will never forget my roots.")
			.with(5, "I protect those who cannot protect themselves.")
			.with(6, "I wish my childhood sweetheart had come with me to pursue my destiny.")
			.build();

	
	public static final RandomizableStringSource FOLK_HERO_FLAWS = newValueRangeMap(D6)
			.with(1, "The tyrant who rules my land will stop at nothing to see me killed.")
			.with(2, "I'm convinced of the significance of my destiny, and blind to my shortcomings and the risk of failure.")
			.with(3, "The people who knew me when I was young know my shameful secret, so I can never go home again.")
			.with(4, "I have a weakness for the vices of the city, especially hard drink.")
			.with(5, "Secretly, I believe that things would be better if I were a tyrant lording over the land.")
			.with(6, "I have trouble trusting in my allies.")
			.build();

	public static final Background FOLK_HERO = Background.newBackground()
			.withName("Folk Hero")
			.withBonds(FOLK_HERO_BONDS)
			.withFlaws(FOLK_HERO_FLAWS)
			.withTraits(FOLK_HERO_TRAITS)
			.withIdeals(FOLK_HERO_IDEALS)
			.withAdditionalTable(newNamedStringSource("Defining Event", 
					newValueRangeMap(D10)
					.with(1, "I stood up to a tyrant's agents.")
					.with(2, "I saved people during a natural disaster.")
					.with(3, "I stood alone against a terrible monster.")
					.with(4, "I stole from a corrupt merchant to help the poor.")
					.with(5, "I led a militia to fight off an invading army.")
					.with(6, "I broke into a tyrant's castle and stole weapons to arm the people.")
					.with(7, "I trained the peasantry to use farm implements as weapons against a tyrant's soldiers.")
					.with(8, "A lord rescinded an unpopular decree after I led a symbolic act of protest against it.")
					.with(9, "A celestial, fey, or similar creature gave me a blessing, or revealed my secret origin.")
					.with(10, "Recruited into a lord's army, I rose to leadership and was commended for my heroism.")
					.build(),
					false))
			.build();

	public static final RandomizableStringSource GUILD_ARTISAN_TRAITS = newValueRangeMap(D8)
			.with(1, "I believe that everything worth doing is worth doing right. I can't help it--I'm a perfectionist.")
			.with(2, "I'm a snob who looks down on those who can't appreciate fine art.")
			.with(3, "I always want to know how things work and what makes people tick.")
			.with(4, "I'm full of witty aphorisms and have a proverb for every occasion.")
			.with(5, "I'm rude to people who lack my commitment to hard work and fair play.")
			.with(6, "I like to talk at length about my profession.")
			.with(7, "I don't part with my money easily and will haggle tirelessly to get the best deal possible.")
			.with(8, "I'm well known for my work, and I want to make sure everyone appreciates it. I'm always taken aback when people haven't heard of me.")
			.build();

	public static final IdealSet GUILD_ARTISAN_IDEALS = newIdealSet()
			.with(LAWFUL, "Community. It is the duty of all civilized people to strengthen the bonds of community and the security of civilization. (Lawful)")
			.with(GOOD, "Generosity. My talents were given to me so that I could use them to benefit the world. (Good)")
			.with(CHAOTIC, "Freedom. Everyone should be free to pursue his or her livelihood. (Chaotic)")
			.with(EVIL, "I'm only in it for the money. (Evil)")
			.with(NEUTRAL, "People. I'm committed to the people I care about, not to ideals. (Neutral)")
			.with(ANY, "Aspiration. I work hard to be the best there is at my craft. (Any)")
			.build();

	public static final RandomizableStringSource GUILD_ARTISAN_BONDS = newValueRangeMap(D6)
			.with(1, "The workshop where I learned my trade is the most important place in the world to me.")
			.with(2, "I created a great work for someone, and then found them unworthy to receive it. I'm still looking for someone worthy.")
			.with(3, "I owe my guild a great debt for forging me into the person I am today.")
			.with(4, "I pursue wealth to secure someone's love.")
			.with(5, "One day I will return to my guild and prove that I am the greatest artisan of them all.")
			.with(6, "I will get revenge on the evil forces that destroyed my place of business and ruined my livelihood.")
			.build();

	
	public static final RandomizableStringSource GUILD_ARTISAN_FLAWS = newValueRangeMap(D6)
			.with(1, "I'll do anything to get my hands on something rare or priceless.")
			.with(2, "I'm quick to assume that someone is trying to cheat me.")
			.with(3, "No one must ever learn that I once stole money from guild coffers.")
			.with(4, "I'm never satisfied with what I have--I always want more.")
			.with(5, "I would kill to acquire a noble title.")
			.with(6, "I'm horribly jealous of anyone who outshines my handiwork. Everywhere I go, I'm surrounded by rivals.")
			.build();

	public static final Background GUILD_ARTISAN = Background.newBackground()
			.withName("Guild Artisan")
			.withBonds(GUILD_ARTISAN_BONDS)
			.withFlaws(GUILD_ARTISAN_FLAWS)
			.withTraits(GUILD_ARTISAN_TRAITS)
			.withIdeals(GUILD_ARTISAN_IDEALS)
			.withAdditionalTable(newNamedStringSource("Guild Business", 
					newValueRangeMap(D20)
					.with(1, "Alchemists and apothecaries")
					.with(2, "Armorers, locksmiths, and finesmiths")
					.with(3, "Brewers, distillers, and vintners")
					.with(4, "Calligraphers, scribes, and scriveners")
					.with(5, "Carpenters, roofers, and plasterers")
					.with(6, "Cartographers, surveyors, and chart-makers")
					.with(7, "Cobblers and shoemakers")
					.with(8, "Cooks and bakers")
					.with(9, "Glassblowers and glaziers")
					.with(10, "Jewelers and gemcutters")
					.with(11, "Leatherwokers, skinners, and tanners")
					.with(12, "Masons and stonecutters")
					.with(13, "Painters, limners, and sign-makers")
					.with(14, "Potters and tile-makers")
					.with(15, "Shipwrights and sailmakers")
					.with(16, "Smiths and metal-forgers")
					.with(17, "Tinkers, pewterers, and casters")
					.with(18, "Wagon-makers and wheelwrights")
					.with(19, "Weavers and dyers")
					.with(20, "Woodcarvers, coopers, and bowyers")
					.build(),
					false))
			.build();

	public static final RandomizableStringSource HERMIT_TRAITS = newValueRangeMap(D8)
			.with(1, "I've been isolated for so long that I rarely speak, preferring gestures and the occasional grunt.")
			.with(2, "I am utterly serene, even in the face of disaster.")
			.with(3, "The leader of my community has something wise to say on every topic, and I am eager to share that wisdom.")
			.with(4, "I feel tremendous empathy for all who suffer.")
			.with(5, "I'm oblivious to etiquette and social expectations.")
			.with(6, "I connect everything that happens to me to a grand cosmic plan.")
			.with(7, "I often get lost in my own thoughts and contemplations, becoming oblivious to my surroundings.")
			.with(8, "I am working on a grand philosophical theory and love sharing my ideas.")
			.build();

	public static final IdealSet HERMIT_IDEALS = newIdealSet()
			.with(GOOD, "Greater Good. My gifts are meant to be shared with all, not used for my own benefit. (Good)")
			.with(LAWFUL, "Logic. Emotions must not cloud our sense of what is right and true, or our logical thinking. (Lawful)")
			.with(CHAOTIC, "Free Thinking. Inquiry and curiosity are the pillars of progress. (Chaotic)")
			.with(EVIL, "Power. Solitude and contemplation are paths toward mystical or magical power. (Evil)")
			.with(NEUTRAL, "Live and Let Live. Meddling in the affairs of others only causes trouble. (Neutral)")
			.with(ANY, "Self-Knowledge. If you know yourself, there're nothing left to know. (Any)")
			.build();

	public static final RandomizableStringSource HERMIT_BONDS = newValueRangeMap(D6)
			.with(1, "Nothing is more important than the other members of my hermitage, order, or association.")
			.with(2, "I entered seclusion to hide from the ones who might still be hunting me. I must someday confront them.")
			.with(3, "I'm still seeking the enlightenment I pursued in my seclusion, and it still eludes me.")
			.with(4, "I entered seclusion because I loved someone I could not have.")
			.with(5, "Should my discovery come to light, it could bring ruin to the world.")
			.with(6, "My isolation gave me great insight into a great evil that only I can destroy.")
			.build();

	
	public static final RandomizableStringSource HERMIT_FLAWS = newValueRangeMap(D6)
			.with(1, "Now that I've returned to the world, I enjoy its delights a little too much.")
			.with(2, "I harbor dark bloodthirsty thoughts that my isolation failed to quell.")
			.with(3, "I am dogmatic in my thoughts and philosophy.")
			.with(4, "I let my need to win arguments overshadow friendships and harmony.")
			.with(5, "I'd risk too much to uncover a lost bit of knowledge.")
			.with(6, "I like keeping secrets and won't share them with anyone.")
			.build();

	public static final Background HERMIT = Background.newBackground()
			.withName("Hermit")
			.withBonds(HERMIT_BONDS)
			.withFlaws(HERMIT_FLAWS)
			.withTraits(HERMIT_TRAITS)
			.withIdeals(HERMIT_IDEALS)
			.withAdditionalTable(newNamedStringSource("Life of Seclusion", 
					newValueRangeMap(D8)
					.with(1, "I was searching for spiritual enlightenment.")
					.with(2, "I was partaking of communal living in accordance with the dictates of a religious order.")
					.with(3, "I was exiled for a crime I didn't commit.")
					.with(4, "I retreated from society after a life-altering event.")
					.with(5, "I needed a quiet place to work on my art, literature, music, or manifesto.")
					.with(6, "I needed to commune with nature, far from civilization.")
					.with(7, "I was the caretaker of an ancient ruin or relic.")
					.with(8, "I was a pilgrim in search of a person, place, or relic of spiritual significance.")
					.build(),
					false))
			.build();

	public static final RandomizableStringSource NOBLE_TRAITS = newValueRangeMap(D8)
			.with(1, "My eloquent flattery makes everyone I talk to feel like the most wonderful and important person in the world.")
			.with(2, "The common folk love me for my kindness and generosity.")
			.with(3, "No one could doubt by looking at my regal bearing that I am a cut above the unwashed masses.")
			.with(4, "I take great pains to always look my best and follow the latest fashions.")
			.with(5, "I don't like to get my hands dirty, and I won't be caught dead in unsuitable accommodations.")
			.with(6, "Despite my birth, I do not place myself above other folk. We all have the same blood.")
			.with(7, "My favor, once lost, is lost forever.")
			.with(8, "If you do me an injury, I will crush you, ruin your name, and salt your fields.")
			.build();

	public static final IdealSet NOBLE_IDEALS = newIdealSet()
			.with(GOOD, "Respect. Respect is due to me because of my position, but all people regardless of station deserve to be treated with dignity. (Good)")
			.with(LAWFUL, "Responsibility. It is my duty to respect the authority of those above me, just as those below me must respect mine. (Lawful)")
			.with(CHAOTIC, "Independence. I must prove that I can handle myself without the coddling of my family. (Chaotic)")
			.with(EVIL, "Power. If I can attain more power, no one will tell me what to do. (Evil)")
			.with(ANY, "Family. Blood runs thicker than water. (Any)")
			.with(GOOD, "Noble Obligation. It is my duty to protect and care for the people beneath me. (Good)")
			.build();

	public static final RandomizableStringSource NOBLE_BONDS = newValueRangeMap(D6)
			.with(1, "I will face any challenge to win the approval of my family.")
			.with(2, "My house's alliance with another noble family must be sustained at all costs.")
			.with(3, "Nothing is more important that the other members of my family.")
			.with(4, "I am in love with the heir of a family that my family despises.")
			.with(5, "My loyalty to my sovereign is unwavering.")
			.with(6, "The common folk must see me as a hero of the people.")
			.build();

	
	public static final RandomizableStringSource NOBLE_FLAWS = newValueRangeMap(D6)
			.with(1, "I secretly believe that everyone is beneath me.")
			.with(2, "I hide a truly scandalous secret that could ruin my family forever.")
			.with(3, "I too often hear veiled insults and threats in every word addressed to me, and I'm quick to anger.")
			.with(4, "I have an insatiable desire for carnal pleasures.")
			.with(5, "In fact, the world does revolve around me.")
			.with(6, "By my words and actions, I often bring shame to my family.")
			.build();

	public static final Background NOBLE = Background.newBackground()
			.withName("Noble")
			.withBonds(NOBLE_BONDS)
			.withFlaws(NOBLE_FLAWS)
			.withTraits(NOBLE_TRAITS)
			.withIdeals(NOBLE_IDEALS)
			.build();

	public static final RandomizableStringSource OUTLANDER_TRAITS = newValueRangeMap(D8)
			.with(1, "I'm driven by a wanderlust that led me away from home.")
			.with(2, "I watch over my friends as if they were a litter of newborn pups.")
			.with(3, "I once ran twenty-five miles without stopping to warn my clan of an approaching orc horde. I'd do it again if I had to.")
			.with(4, "I have a lesson for every situation, drawn from observing nature.")
			.with(5, "I place no stock in wealthy or well-mannered folk. Money and manners won't save you from a hungry owlbear.")
			.with(6, "I'm always picking things up, absently fiddling with them, and sometimes accidentally breaking them.")
			.with(7, "I feel far more comfortable around animals than people.")
			.with(8, "I was, in fact, raised by wolves.")
			.build();

	public static final IdealSet OUTLANDER_IDEALS = newIdealSet()
			.with(CHAOTIC, "Change. Life is like the seasons, in constant change, and we must change with it. (Chaotic)")
			.with(GOOD, "Greater Good. It is each person's responsibility to make the most happiness for the whole tribe. (Good)")
			.with(LAWFUL, "Honor. If I dishonor myself, I dishonor my whole clan. (Lawful)")
			.with(EVIL, "Might. The strongest are meant to rule. (Evil)")
			.with(NEUTRAL, "Nature. The natural world is more important than all the constructs of civilization. (Neutral)")
			.with(ANY, "Glory. I must earn glory in battle, for myself and my clan. (Any)")
			.build();

	public static final RandomizableStringSource OUTLANDER_BONDS = newValueRangeMap(D6)
			.with(1, "My family, clan, or tribe is the most important thing in my life, even when they are far from me.")
			.with(2, "An injury to the unspoiled wilderness of my home is an injury to me.")
			.with(3, "I will bring terrible wrath down on the evildoers who destroyed my homeland.")
			.with(4, "I am the last of my tribe, and it is up to me to ensure their names enter legend.")
			.with(5, "I suffer awful visions of a coming disaster and will do anything to prevent it.")
			.with(6, "It is my duty to provide children to sustain my tribe.")
			.build();

	
	public static final RandomizableStringSource OUTLANDER_FLAWS = newValueRangeMap(D6)
			.with(1, "I am too enamored of ale, wine, and other intoxicants.")
			.with(2, "There's no room for caution in a life lived to the fullest.")
			.with(3, "I remember every insult I've received and nurse a silent resentment toward anyone who's ever wronged me.")
			.with(4, "I am slow to trust members of other races")
			.with(5, "Violence is my answer to almost any challenge.")
			.with(6, "Don't expect me to save those who can't save themselves. It is nature's way that the strong thrive and the weak perish.")
			.build();

	public static final Background OUTLANDER = Background.newBackground()
			.withName("Outlander")
			.withBonds(OUTLANDER_BONDS)
			.withFlaws(OUTLANDER_FLAWS)
			.withTraits(OUTLANDER_TRAITS)
			.withIdeals(OUTLANDER_IDEALS)
			.withAdditionalTable(newNamedStringSource("Origin", 
					newValueRangeMap(D10)
					.with(1, "Forester")
					.with(2, "Trapper")
					.with(3, "Homesteader")
					.with(4, "Guide")
					.with(5, "Exile or outcast")
					.with(6, "Bounty hunter")
					.with(7, "Pilgrim")
					.with(8, "Tribal nomad")
					.with(9, "Hunter-gatherer")
					.with(10, "Tribal marauder")
					.build(),
					false))
			.build();

	public static final RandomizableStringSource SAGE_TRAITS = newValueRangeMap(D8)
	.with(1, "I use polysyllabic words to convey the impression of great erudition.")
	.with(2, "I've read every book in the world's greatest libraries--or like to boast that I have.")
	.with(3, "I'm used to helping out those who aren't as smart as I am, and I patiently explain anything and everything to others.")
	.with(4, "There's nothing I like more than a good mystery.")
	.with(5, "I'm willing to listen to every side of an argument before I make my own judgment.")
	.with(6, "I...speak...slowly...when talking...to idiots...which...almost...everyone...is...compared...to me.")
	.with(7, "I am horribly, horribly awkward in social situations.")
	.with(8, "I'm convinced that people are always trying to steal my secrets.")
	.build();

	public static final IdealSet SAGE_IDEALS = newIdealSet()
	.with(NEUTRAL, "Knowledge. The path to power and self-improvement is through knowledge. (Neutral)")
	.with(GOOD, "Beauty. What is beautiful points us beyond itself toward what is true. (Good)")
	.with(LAWFUL, "Logic. Emotions must not cloud our logical thinking. (Lawful)")
	.with(CHAOTIC, "No Limits. Nothing should fetter the infinite possibility inherent in all existence. (Chaotic)")
	.with(EVIL, "Power. Knowledge is the path to power and domination. (Evil)")
	.with(ANY, "Self-improvement. The goal of a life of study is the betterment of oneself.")
	.build();

	public static final RandomizableStringSource SAGE_BONDS = newValueRangeMap(D6)
	.with(1, "It is my duty to protect my students.")
	.with(2, "I have an ancient text that holds terrible secrets that must not fall into the wrong hands.")
	.with(3, "I work to preserve a library, university, scriptorium, or monastery.")
	.with(4, "My life's work is a series of tomes related to a specific field of lore.")
	.with(5, "I've been searching my whole life for the answer to a certain question.")
	.with(6, "I sold my soul for knowledge. I hope to do great deeds and win it back.")
	.build();

	public static final RandomizableStringSource SAGE_FLAWS = newValueRangeMap(D6)
	.with(1, "I am easily distracted by the promise of information.")
	.with(2, "Most people scream and run when they see a demon. I stop and take notes on its anatomy.")
	.with(3, "Unlocking an ancient mystery is worth the price of a civilization.")
	.with(4, "I overlook obvious solutions in favor of complicated ones.")
	.with(5, "I speak without really thinking through my words, invariably insulting others.")
	.with(6, "I can't keep a secret to save my life, or anyone else's.")
	.build();

	public static final Background SAGE = Background.newBackground()
			.withName("Sage")
			.withBonds(SAGE_BONDS)
			.withFlaws(SAGE_FLAWS)
			.withTraits(SAGE_TRAITS)
			.withIdeals(SAGE_IDEALS)
			.withAdditionalTable(newNamedStringSource("Specialty", 
					newValueRangeMap(D8)
					.with(1, "Alchemist")
					.with(2, "Astronomer")
					.with(3, "Discredited academic")
					.with(4, "Librarian")
					.with(5, "Professor")
					.with(6, "Researcher")
					.with(7, "Wizard's apprentice")
					.with(8, "Scribe")
					.build(),
					false))
			.build();

	public static final RandomizableStringSource SAILOR_TRAITS = newValueRangeMap(D8)
			.with(1, "My friends know they can rely on me, no matter what.")
			.with(2, "I work hard so that I can play hard when the work is done.")
			.with(3, "I enjoy sailing into new ports and making new friends over a flagon of ale.")
			.with(4, "I stretch the truth for the sake of a good story.")
			.with(5, "To me, a tavern brawl is a nice way to get to know a new city.")
			.with(6, "I never pass up a friendly wager.")
			.with(7, "My language is as foul as an otyugh nest.")
			.with(8, "I like a job well done, especially if I can convince someone else to do it.")
			.build();

	public static final IdealSet SAILOR_IDEALS = newIdealSet()
			.with(GOOD, "Respect. The thing that keeps a ship together is mutual respect between captain and crew. (Good)")
			.with(LAWFUL, "Fairness. We all do the work, so we all share in the rewards. (Lawful)")
			.with(CHAOTIC, "Freedom. The sea is freedom--the freedom to go anywhere and do anything. (Chaotic)")
			.with(EVIL, "Master. I'm a predator, and the other ships on the sea are my prey. (Evil)")
			.with(NEUTRAL, "People. I'm committed to my crewmates, not to ideals. (Neutral)")
			.with(ANY, "Aspiration. Someday I'll own my own ship and chart my own destiny. (Any)")
			.build();

	public static final RandomizableStringSource SAILOR_BONDS = newValueRangeMap(D6)
			.with(1, "I'm loyal to my captain first, everything else second.")
			.with(2, "The ship is most important--crewmates and captains come and go.")
			.with(3, "I'll always remember my first ship.")
			.with(4, "In a harbor town, I have a paramour whose eyes nearly stole me from the sea.")
			.with(5, "I was cheated of my fair share of the profits, and I want to get my due.")
			.with(6, "Ruthless pirates murdered my captain and crewmates, plundered our ship, and left me to die. Vengeance will be mine.")
			.build();

	
	public static final RandomizableStringSource SAILOR_FLAWS = newValueRangeMap(D6)
			.with(1, "I follow orders, even if I think they're wrong.")
			.with(2, "I'll say anything to avoid having to do extra work.")
			.with(3, "Once someone questions my courage, I never back down no matter how dangerous the situation.")
			.with(4, "Once I start drinking, it's hard for me to stop.")
			.with(5, "I can't help but pocket loose coins and other trinkets I come across.")
			.with(6, "My pride will probably lead to my destruction")
			.build();

	public static final Background SAILOR = Background.newBackground()
			.withName("Sailor")
			.withBonds(SAILOR_BONDS)
			.withFlaws(SAILOR_FLAWS)
			.withTraits(SAILOR_TRAITS)
			.withIdeals(SAILOR_IDEALS)
			.build();

	public static final RandomizableStringSource SOLDIER_TRAITS = newValueRangeMap(D8)
			.with(1, "I'm always polite and respectful.")
			.with(2, "I'm haunted by memories of war. I can't get the images of violence out of my mind.")
			.with(3, "I've lost too many friends, and I'm slow to make new ones.")
			.with(4, "I'm full of inspiring and cautionary tales from my military experience relevant to almost every combat situation.")
			.with(5, "I can stare down a hellhound without flinching.")
			.with(6, "I enjoy being strong and like breaking things.")
			.with(7, "I have a crude sense of humor.")
			.with(8, "I face problems head-on. A simple direct solution is the best path to success.")
			.build();

	public static final IdealSet SOLDIER_IDEALS = newIdealSet()
			.with(GOOD, "Greater Good. Our lot is to lay down our lives in defense of others. (Good)")
			.with(LAWFUL, "Responsibility. I do what I must and obey just authority. (Lawful)")
			.with(CHAOTIC, "Independence. When people follow orders blindly they embrace a kind of tyranny. (Chaotic)")
			.with(EVIL, "Might. In life as in war, the stronger force wins. (Evil)")
			.with(NEUTRAL, "Ideals aren't worth killing for or going to war for. (Neutral)")
			.with(ANY, "Nation. My city, nation, or people are all that matter. (Any)")
			.build();

	public static final RandomizableStringSource SOLDIER_BONDS = newValueRangeMap(D6)
			.with(1, "I would lay down my life for the people I served with.")
			.with(2, "Someone saved my life on the battlefield. To this day, I will never leave a friend behind.")
			.with(3, "My honor is my life.")
			.with(4, "I'll never forget the crushing defeat my company suffered or the enemies who dealt it.")
			.with(5, "Those who fight beside me are those worth dying for.")
			.with(6, "I fight for those who cannot fight for themselves.")
			.build();

	
	public static final RandomizableStringSource SOLDIER_FLAWS = newValueRangeMap(D6)
			.with(1, "The monstrous enemy we faced in battle still leaves me quivering with fear.")
			.with(2, "I have little respect for anyone who is not a proven warrior.")
			.with(3, "I made a terrible mistake in battle that cost many lives--and I would do anything to keep that mistake secret.")
			.with(4, "My hatred of my enemies is blind and unreasoning.")
			.with(5, "I obey the law, even if the law causes misery.")
			.with(6, "I'd rather eat my armor than admit when I'm wrong.")
			.build();

	public static final Background SOLDIER = Background.newBackground()
			.withName("Soldier")
			.withBonds(SOLDIER_BONDS)
			.withFlaws(SOLDIER_FLAWS)
			.withTraits(SOLDIER_TRAITS)
			.withIdeals(SOLDIER_IDEALS)
			.withAdditionalTable(newNamedStringSource("Specialty", 
					newValueRangeMap(D8)
					.with(1, "Officer")
					.with(2, "Scout")
					.with(3, "Infantry")
					.with(4, "Cavalry")
					.with(5, "Healer")
					.with(6, "Quartermaster")
					.with(7, "Standard bearer")
					.with(8, "Support staff (cook, blacksmith, or the like)")
					.build(),
					false))
			.build();

	public static final RandomizableStringSource URCHIN_TRAITS = newValueRangeMap(D8)
			.with(1, "I hide scraps of food and trinkets away in my pockets.")
			.with(2, "I ask a lot of questions.")
			.with(3, "I like to squeeze into small places where no one else can get to me.")
			.with(4, "I sleep with my back to a wall or tree, with everything I own wrapped in a bundle in my arms.")
			.with(5, "I eat like a pig and have bad manners.")
			.with(6, "I think anyone who's nice to me is hiding evil intent.")
			.with(7, "I don't like to bathe.")
			.with(8, "I bluntly say what other people are hinting or hiding.")
			.build();

	public static final IdealSet URCHIN_IDEALS = newIdealSet()
			.with(GOOD, "Respect. All people, rich or poor, deserve respect. (Good)")
			.with(LAWFUL, "Community. We have to take care of each other, because no one else is going to do it. (Lawful)")
			.with(CHAOTIC, "Change. The low are lifted up, and the high and mighty are brought down. Change is the nature of things. (Chaotic)")
			.with(EVIL, "Retribution. The rich need to be shown what life and death are like in the gutters. (Evil)")
			.with(NEUTRAL, "People. I help people who help me--that's what keeps us alive. (Neutral)")
			.with(ANY, "Aspiration. I'm going to prove that I'm worthy of a better life. (Any)")
			.build();

	public static final RandomizableStringSource URCHIN_BONDS = newValueRangeMap(D6)
			.with(1, "My town or city is my home, and I'll fight to defend it.")
			.with(2, "I sponsor an orphanage to keep others from enduring what I was forced to endure.")
			.with(3, "I owe my survival to another urchin who taught me to live on the streets.")
			.with(4, "I owe a debt I can never repay to the person who took pity on me.")
			.with(5, "I escaped my life of poverty by robbing an important person, and I'm wanted for it.")
			.with(6, "No one else is going to have to endure the hardships I've been through.")
			.build();

	
	public static final RandomizableStringSource URCHIN_FLAWS = newValueRangeMap(D6)
			.with(1, "If I'm outnumbered, I always run away from a fight.")
			.with(2, "Gold seems like a lot of money to me, and I'll do just about anything for more of it.")
			.with(3, "I will never fully trust anyone other than myself.")
			.with(4, "I'd rather kill someone in their sleep than fight fair.")
			.with(5, "It's not stealing if I need it more than someone else.")
			.with(6, "People who don't take care of themselves get what they deserve.")
			.build();

	public static final Background URCHIN = Background.newBackground()
			.withName("Urchin")
			.withBonds(URCHIN_BONDS)
			.withFlaws(URCHIN_FLAWS)
			.withTraits(URCHIN_TRAITS)
			.withIdeals(URCHIN_IDEALS)
			.build();
	
	public static final RandomizableSet<Background> BACKGROUNDS = RandomizableSet.<Background>newRandomizableSet()
			.with(ACOLYTE)
			.with(CHARLATAN)
			.with(CRIMINAL)
			.with(ENTERTAINER)
			.with(FOLK_HERO)
			.with(GUILD_ARTISAN)
			.with(HERMIT)
			.with(NOBLE)
			.with(OUTLANDER)
			.with(SAGE)
			.with(SAILOR)
			.with(SOLDIER)
			.with(URCHIN)
			.build();

}
