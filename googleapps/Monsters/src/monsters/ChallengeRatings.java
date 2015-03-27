package monsters;
import static com.google.common.base.Preconditions.checkArgument;

import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;


public class ChallengeRatings {
	public static final Set<Double> CR_RANGE;

	static {
		Set<Double> crRange = Sets.newLinkedHashSet();
		crRange.add(0.125);
		crRange.add(0.25);
		crRange.add(0.5);
		for (double i = 0; i <= 30; i++) {
			crRange.add(i);
		}
		CR_RANGE = ImmutableSet.copyOf(crRange);
	}

	public static String crToString (double cr) {
		checkArgument(CR_RANGE.contains(cr));
		if (cr == 0.125) {
			return "1/8";
		} else if (cr == 0.25) {
			return "1/4";
		} else if (cr == 0.5) {
			return "1/2";
		} 
		return String.valueOf((long) cr);
	}
	
	
	private ChallengeRatings () {}
}
