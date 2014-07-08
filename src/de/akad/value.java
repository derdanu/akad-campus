package de.akad;
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
public class value {

	private String moduleId;
	private String brickId;
	private String brickName;
	private String location;
	private String startTime;
	private String endTime;
	
	public String getModuleId() {
		return moduleId;
	}
	
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	
	public String getBrickId() {
		return brickId;
	}
	public void setBrickId(String brickId) {
		this.brickId = brickId;
	}
	
	public String getBrickName() {
		return brickName;
	}
	
	public void setBrickName(String brickName) {
		this.brickName = brickName;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	public String getEndTime() {
		return endTime;
	}
	
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	public String UnixToDateStringHelper(String timestamp) {
		
		java.util.Date dateTime=new java.util.Date(Long.parseLong(timestamp));
		return dateTime.toString();
		
	}
	
}
