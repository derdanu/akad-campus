package de.akad;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * 
 * @author Daniel Falkner
 * 
 * This file is part of Akad Campus.
 * 
 * Akad Campus is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Akad Campus is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Akad Campus. If not, see <http://www.gnu.org/licenses/>.
 *
 */
@XmlRootElement
public class Termine {

	private List<eventGroups> eventGroups;
	private String moreResults;
	
	public List<eventGroups> getEventGroups() {
		return eventGroups;
	}

	public void setEventGroups(List<eventGroups> eventGroups) {
		this.eventGroups = eventGroups;
	}

	public String getMoreResults() {
		return moreResults;
	}

	public void setMoreResults(String moreResults) {
		this.moreResults = moreResults;
	}




	
}
