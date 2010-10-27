import java.util.HashSet;
import java.util.Set;

public class CensusTest {
	public void testCensus() {
		Census census = new Census();
		
		// Test case 1
		Set<Voter> voters = new HashSet<Voter>();
		voters.add(new Voter()); // need for mock objects
		voters.add(new Voter());
		System.out.println(census.census(voters)); // false
		
		// Test case 2
		voters.clear();
		voters.add(new Voter());
		voters.add(new Voter());
		voters.add(new Voter());
		voters.add(new Voter());
		System.out.println(census.census(voters)); // true
		
		// Test case 3
		voters.clear();
		voters.add(new Voter());
		voters.add(null);
		voters.add(new Voter());
		try {
			System.out.println(census.census(voters)); // exception
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		// Test case 4
		voters.clear();
		System.out.println(census.census(voters)); // true
		
		// Test case 5
		voters = null;
		try {
			System.out.println(census.census(voters)); // exception
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
