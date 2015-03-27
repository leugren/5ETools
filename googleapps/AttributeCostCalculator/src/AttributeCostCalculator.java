import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Range;


public class AttributeCostCalculator {
	
	private static final Pattern REGEX = Pattern.compile("^\\s*\\[([^\\]]*)\\]\\s*$");
	private static final Range<Integer> ATTR_RANGE = Range.closed(8, 15);
	private static final Map<Integer, Integer> ATTR_COSTS;
	
	static {
		Map<Integer, Integer> attrCosts = Maps.newLinkedHashMap();
		attrCosts.put(8, 0);
		attrCosts.put(9, 1);
		attrCosts.put(10, 2);
		attrCosts.put(11, 3);
		attrCosts.put(12, 4);
		attrCosts.put(13, 5);
		attrCosts.put(14, 7);
		attrCosts.put(15, 9);

		ATTR_COSTS = ImmutableMap.copyOf(attrCosts);
	}

	public static void main(String[] args) throws ParseException {
		final String attributes = "[15, 14, 14, 10, 10, 8]";
		final int budget = 27;
		
		int [] attrs = parseAttributes(attributes);
		System.out.println(Arrays.toString(attrs));
		
		int cost = 0;
		for (int attr : attrs) {
			cost += ATTR_COSTS.get(attr);
		}
		System.out.printf("Total cost: %d%n", cost);
		System.out.printf("Points left: %d%n", budget - cost);
		
	}

	private static int[] parseAttributes(final String attributes) throws ParseException {
		Matcher m = REGEX.matcher(attributes);
		if (!m.find()) {
			throw new ParseException(String.format("Invalid attributes string %s: expected an open and closing square brackets", attributes), 0);
		}
		final String attributeListString = m.group(1);
		List<String> attributeList = Lists.newArrayList(Splitter.on(",").trimResults().split(attributeListString));
		if (attributeList.size() != 6) {
			throw new ParseException(String.format("Invalid attributes string %s: expected 6 attributes", attributes), 0);
		}
		int [] attrs = new int[6];
		for (int i = 0; i < 6; i++) {
			try {
			   attrs[i] = Integer.parseInt(attributeList.get(i));
               if (!ATTR_RANGE.contains(attrs[i])) {
   				   throw new ParseException(String.format("Invalid attributes string %s: all attribute values must fall within the range of 8 to 15.", attributes, attributeList.get(i)), 0);
               }
			} catch (NumberFormatException ex) {
				throw new ParseException(String.format("Invalid attributes string %s: the string contains non-integral attribute %s.", attributes, attributeList.get(i)), 0);
			}
		}
		return attrs;
	}

}
