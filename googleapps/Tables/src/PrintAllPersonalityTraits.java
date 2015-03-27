import static org.devoware.table.model.PcPersonalities.*;

import org.devoware.table.model.StringSource;
import org.devoware.table.model.ValueSet;


public class PrintAllPersonalityTraits {
	
	public static void main(String[] args) {
		print("Personality Traits", ALL_TRAITS);
		print("Ideals", ALL_IDEALS);
		print("Bonds", ALL_BONDS);
		print("Flaws", ALL_FLAWS);

	}

	private static void print(String type, ValueSet set) {
		System.out.println("---------------------------------------------------------------------");
		System.out.println(type);
		System.out.println("---------------------------------------------------------------------");
		for (StringSource source : set) {
			System.out.println(source.getValue());
		}
		System.out.println();
	}

}
