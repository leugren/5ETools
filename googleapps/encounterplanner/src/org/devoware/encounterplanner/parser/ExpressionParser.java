package org.devoware.encounterplanner.parser;

import static com.google.appengine.labs.repackaged.com.google.common.base.Strings.isNullOrEmpty;

import java.util.List;

import org.devoware.encounterplanner.model.Encounter;
import org.devoware.encounterplanner.model.Party;
import org.devoware.encounterplanner.util.EncounterUtil;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;


public class ExpressionParser {
	
	public Party parseParty (String party) throws ParseException {
		if (party == null || isNullOrEmpty(party)) {
			throw new ParseException("Expected a value for the Party field.");
		}
		Party.Builder builder = Party.builder();
		for (String memberString : Splitter.on(',').omitEmptyStrings().trimResults().split(party)) {
			List<String> memberFields = Lists.newArrayList(Splitter.onPattern("[xX]").trimResults().split(memberString));
			Integer numMembers = null, level = null;
			if (memberFields.size() == 2) {
				numMembers = Ints.tryParse(memberFields.get(0));
				level = Ints.tryParse(memberFields.get(1));
			} else if (memberFields.size() == 1) {
				numMembers = 1;
				level = Ints.tryParse(memberFields.get(0));
			} else {
				throw new ParseException("Invalid subexpression within the Party field '%s'", memberString);
			}
			if (numMembers == null || level == null) {
				throw new ParseException("Invalid subexpression within the Party field '%s'", memberString);
			}
			if (numMembers < 1) {
				throw new ParseException("Invalid subexpression within the Party field '%s' - the number of party members cannot be less than 1", memberString);
			}
			if (!EncounterUtil.CHAR_LEVEL_RANGE.contains(level)) {
				throw new ParseException("Invalid subexpression within the Party field '%s' - the level of the party members must be between 1 and 30", memberString);
			}
			builder.withPartyMembers(numMembers, level);
		}
		return builder.build();
	}
	
	public Encounter parseEncounter (String encounter) throws ParseException {
		if (encounter == null || isNullOrEmpty(encounter)) {
			throw new ParseException("Expected a value for the Encounter field.");
		}
		Encounter.Builder builder = Encounter.builder();
		for (String monsterString : Splitter.on(',').omitEmptyStrings().trimResults().split(encounter)) {
			List<String> memberFields = Lists.newArrayList(Splitter.onPattern("[xX]").trimResults().split(monsterString));
			Integer numMonsters = null;
			Double	challengeRating = null;
			if (memberFields.size() == 2) {
				numMonsters = Ints.tryParse(memberFields.get(0));
				challengeRating = parseChallengeRating(memberFields.get(1));
			} else if (memberFields.size() == 1) {
				numMonsters = 1;
				challengeRating = parseChallengeRating(memberFields.get(0));
			} else {
				throw new ParseException("Invalid subexpression within the Encounter field: %s", monsterString);
			}
			if (numMonsters == null || challengeRating == null) {
				throw new ParseException("Invalid subexpression within the Encounter field: %s", monsterString);
			}
			if (numMonsters < 1) {
				throw new ParseException("Invalid subexpression within the Encounter field '%s' - the number of monsters cannot be less than 1", monsterString);
			}
			if (!EncounterUtil.CR_RANGE.contains(challengeRating)) {
				throw new ParseException("Invalid subexpression within the Encounter field '%s' - the specified challenge rating is invalid", monsterString);
			}
			builder.withMonsters(numMonsters, challengeRating);
		}
		return builder.build();
	}

	public Double parseChallengeRating(String challengeRatingString) {
		List<String> challengeRatingFields = Lists.newArrayList(Splitter.onPattern("/").trimResults().split(challengeRatingString));
		if (challengeRatingFields.size() == 2) {
			if (!"1".equals(challengeRatingFields.get(0))) {
				return null;
			}
			String quotientString = challengeRatingFields.get(1);
			if ("2".equals(quotientString)) {
				return 0.5;
			} else if ("4".equals(quotientString)) {
				return 0.25;
			} else if ("8".equals(quotientString)) {
				return 0.125;
			} else {
				return null;
			}
		} else if (challengeRatingFields.size() == 1) {
			return Doubles.tryParse(challengeRatingString);
		} else {
			return null;
		}
	}
	
	public static void main(String[] args) throws ParseException {
		ExpressionParser parser = new ExpressionParser();

		String partyString = "4 x 1";
		Party party = parser.parseParty(partyString);
		System.out.println(party);

		String encounterString = "1 x 1/4";
		Encounter encounter = parser.parseEncounter(encounterString);
		System.out.println(encounter);
	
	}

}
