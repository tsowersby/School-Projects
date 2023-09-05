package bag;
/**
 * Subclass of bag that keeps only one instance of that item.
 * @author wil sowersby
 * 9/17/20
 */
public class Set<E> extends Bag<E> {

	@Override
	public void add(E anEntry) {
		if(!contains(anEntry)) {
			super.add(anEntry);
		}
	}

	public int getFrequencyOf (E anEntry) {
		throw new UnsupportedOperationException("msg");
	}
}
