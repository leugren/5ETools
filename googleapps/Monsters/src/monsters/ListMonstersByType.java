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


public class ListMonstersByType {
	
	private static final String HR = "---------------------------------------------------------";
	private static final MonsterType MONSTROSITY = newMonsterType("Monstrosity");
	private static final MonsterType FIEND = newMonsterType("Fiend");

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Multimap<MonsterType, Monster> monstersByType = TreeMultimap.<MonsterType, Monster>create(
				new Comparator<MonsterType> () {

					@Override
					public int compare(MonsterType t1, MonsterType t2) {
						return t1.toString().compareTo(t2.toString());
					}
					
				}, 
				new Comparator<Monster> () {

					@Override
					public int compare(Monster m1, Monster m2) {
						checkNotNull(m1);
						checkNotNull(m2);
						double diff = m1.getChallengeRating() - m2.getChallengeRating();
						if (diff < 0) {
							return -1;
						} else if (diff > 0) {
							return 1;
						}
						int result = m1.getName().compareTo(m2.getName());
						if (result != 0) {
							return result;
						}
						return m1.getType().compareTo(m2.getType());
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
				if (type.getType().equals("Monstrosity")) {
					type = MONSTROSITY;
				} else if (type.getType().equals("Fiend")) {
					type = FIEND;
				}
				monstersByType.put(type, monster);
			}
		}
		
	    Map<MonsterType, Collection<Monster>> monsters = monstersByType.asMap();
		for (MonsterType type : monsters.keySet()) {
			System.out.println(HR);
			System.out.println(type + " (" + monsters.get(type).size() + ")");
			System.out.println(HR);
			System.out.println();
			for (Monster monster : monsters.get(type)) {
				System.out.println(Strings.padEnd(monster.getName(), 45, ' ') + "[CR=" + ChallengeRatings.crToString(monster.getChallengeRating()) + "]");
			}
			System.out.println();
		}
		
	}


}
