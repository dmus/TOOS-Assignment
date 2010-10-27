import java.util.Set;


public class Census {	
	
	public boolean census(Set<Voter> voters) {
		boolean census = true;
		for (Voter voter : voters) {
			census &= voter.vote();
		}
		
		return census;
	}
}
