package census;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class CensusTest {
	
	/**
	 * Component under test
	 */
	private Census census;
	
	private Voter getMockVoter(boolean vote) {
		Voter mockVoter = mock(Voter.class);
		when(mockVoter.vote()).thenReturn(vote);
		
		return mockVoter;
	}
	
	@Before
	public void setUp() {
		census = new Census();
	}
	
	@Test
	public void testCensus() {
		Set<Voter> voters = new HashSet<Voter>();
		voters.add(getMockVoter(true));
		voters.add(getMockVoter(true));
		voters.add(getMockVoter(true));
		
		assertTrue(census.census(voters));
		
		for (Voter mock : voters) {
			verify(mock, times(1)).vote();
		}
	}
		
	@Test
	public void testNoCensusWithFalseVoters() {
		Set<Voter> voters = new HashSet<Voter>();
		voters.add(getMockVoter(true));
		voters.add(getMockVoter(true));
		voters.add(getMockVoter(true));
		voters.add(getMockVoter(false));
		voters.add(getMockVoter(true));
		
		assertFalse(census.census(voters));
		
		for (Voter mock : voters) {
			verify(mock, times(1)).vote();
		}
	}
	
	/**
	 * Test needed to test lazy evaluation
	 */
	@Test
	public void testNoCensusWithFalseVoters2() {
		Set<Voter> voters = new HashSet<Voter>();
		voters.add(getMockVoter(false));
		voters.add(getMockVoter(false));
		voters.add(getMockVoter(false));
		
		assertFalse(census.census(voters));
		
		for (Voter mock : voters) {
			verify(mock, times(1)).vote();
		}
	}
		
	@Test(expected=NullPointerException.class)
	public void testNullElementInSetRaisesException() {
		Set<Voter> voters = new HashSet<Voter>();
		voters.add(getMockVoter(true));
		voters.add(getMockVoter(false));
		voters.add(null);
		
		census.census(voters);
		
		for (Voter mock : voters) {
			verify(mock, times(1)).vote();
		}
	}
	
	@Test
	public void testEmptySetMeansCensus() {
		Set<Voter> voters = new HashSet<Voter>();
		assertTrue(census.census(voters));
	}
	
	@Test(expected=NullPointerException.class)
	public void testNullValueRaisesException() {
		census.census(null);
	}
}
