package census;

import java.util.Set;


public class Census {	
	
	/**
	 * Return true if and only if all voters in set
	 * vote true. Each voter must be called exactly
	 * one time.
	 * 
	 * @param voters
	 * @return
	 */
	public boolean census(Set<Voter> voters) {
		boolean census = true;
		for (Voter voter : voters) {
			census = census && voter.vote();
		}
		
		return census;
	}
}
