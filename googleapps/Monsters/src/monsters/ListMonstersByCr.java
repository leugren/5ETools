package monsters;
import static com.google.common.base.Preconditions.checkNotNull;
import static monsters.MonsterType.newMonsterType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;


public class ListMonstersByCr {
	
	private static final String HR = "---------------------------------------------------------";
	private static final MonsterType MONSTROSITY = newMonsterType("Monstrosity");
	private static final MonsterType FIEND = newMonsterType("Fiend");

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Multimap<Double, Monster> monstersByType = TreeMultimap.<Double, Monster>create(
				new Comparator<Double> () {

					@Override
					public int compare(Double t1, Double t2) {
						return t1.compareTo(t2);
					}
					
				}, 
				new Comparator<Monster> () {

					@Override
					public int compare(Monster m1, Monster m2) {
						return m1.getName().compareTo(m2.getName());
					}
				});
		try (BufferedReader in = new BufferedReader(new FileReader("monsters.tsv"))) {
			for (String line = in.readLine(); line != null; line = in.readLine()) {
				List<String> fields = Splitter.on("\t").trimResults().splitToList(line);
				MonsterType type = newMonsterType(fields.get(1));
				Monster monster = Monster.newMonster()
						.withName(fields.get(0))
						.withType(type)
						.withChallengeRating(Double.parseDouble(fields.get(2).trim()))
						.build();
				monstersByType.put(monster.getChallengeRating(), monster);
			}
		}
		
	    Map<Double, Collection<Monster>> monsters = monstersByType.asMap();
		for (Double cr : monsters.keySet()) {
			System.out.println(HR);
			System.out.println(ChallengeRatings.crToString(cr) + " (" + monsters.get(cr).size() + ")");
			System.out.println(HR);
			System.out.println();
			for (Monster monster : monsters.get(cr)) {
				System.out.println(Strings.padEnd(monster.getName(), 45, ' ') + "[Type=" + monster.getType() + "]");
			}
			System.out.println();
		}
		
	}


}
