package de.akad;

import java.util.List;
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
public class eventGroups {

	private key key;
	private List<value> value;
	
	public key getKey() {
		return key;
	}
	
	public void setKey(key key) {
		this.key = key;
	}
	
	public List<value> getValue() {
		return value;
	}
	
	public void setValue(List<value> value) {
		this.value = value;
	}

	
}
