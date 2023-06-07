
package io.johnvincent.kakuro;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Answers {
	private List<Answer> m_list = new ArrayList<Answer>();

	/**
	 * Get iterator of solutions
	 * 
	 * @return		iterator of solutions
	 */
	public Iterator<Answer> getAnswers() {return m_list.iterator();}

	/**
	 * Get number of solutions
	 * 
	 * @return		number of solutions
	 */
	public int getSize() {return m_list.size();}

	/**
	 * Add the solution to the list of solutions, ensuring no duplicates.
	 * 
	 * @param item	a perspective solution
	 */
	public void add(Answer answer) {
		if (! isExists (answer)) m_list.add(answer);
	}

	/**
	 * Determine whether the parameter wheel settings have already been added.
	 * 
	 * @param answer		wheel settings
	 * @return				true if already been added
	 */
	private boolean isExists(Answer answer) {
		Answer item;
		Iterator<Answer> iter = getAnswers();
		while (iter.hasNext()) {
			item = iter.next();
			if (item.isDuplicate (answer)) return true;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		boolean first = true;
		for (int i = 0; i < m_list.size(); i++) {
			Answer item = m_list.get(i);
			if (! first) buf.append(", ");
			first = false;
			buf.append(item.toString());
		}
		return "("+buf.toString()+")";
	}
}
