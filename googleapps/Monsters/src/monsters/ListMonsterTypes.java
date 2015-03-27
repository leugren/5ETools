package monsters;
import static monsters.MonsterType.newMonsterType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import com.google.common.base.Splitter;
import com.google.common.collect.Sets;


public class ListMonsterTypes {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Set<MonsterType> typeSet = Sets.newTreeSet();
		try (BufferedReader in = new BufferedReader(new FileReader("monsters.tsv"))) {
			for (String line = in.readLine(); line != null; line = in.readLine()) {
				List<String> fields = Splitter.on("\t").trimResults().splitToList(line);
				MonsterType type = newMonsterType(fields.get(1));
				typeSet.add(type);
			}
		}
		
		for (MonsterType type : typeSet) {
			System.out.println(type);
		}
		
	}


}
