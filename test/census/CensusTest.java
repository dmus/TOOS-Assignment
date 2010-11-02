package census;

import java.util.HashSet;
import java.util.Set;

import census.Census;
import census.Voter;

import junit.framework.TestCase;

import static org.mockito.Mockito.*;

public class CensusTest extends TestCase {
	
	public void testCensus() {
		// Component under test
		Census census = new Census();
		Set<Voter> voters = new HashSet<Voter>();
		Voter mockVoter;
		
		// Test case 1
		mockVoter = mock(Voter.class);
		when(mockVoter.vote()).thenReturn(true);
		voters.add(mockVoter);
		
		mockVoter = mock(Voter.class);
		when(mockVoter.vote()).thenReturn(true);
		voters.add(mockVoter);
		
		assertTrue(census.census(voters));
		
		for (Voter mock : voters) {
			verify(mock, times(1)).vote();
		}
		/*
		// Test case 2
		voters.clear();
		voters.add(new Voter());
		voters.add(new Voter());
		voters.add(new Voter());
		voters.add(new Voter());
		assertFalse(census.census(voters));

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
		*/
	}
}
