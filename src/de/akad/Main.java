package de.akad;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.apache.commons.cli.UnrecognizedOptionException;
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
public class Main {
	
	public static void main(String[] args) {
		
		Options options = new Options();
		options.addOption("u", "user", true, "Benutzername");
		options.addOption("p", "pass", true, "Passwort");
		options.addOption("version", false, "Version");
		options.addOption("h", "help", false, "Hilfe");

		CommandLineParser parser = new PosixParser();
		try {
			CommandLine cmd = parser.parse(options, args);

			if (cmd.hasOption("help")) {

				HelpFormatter formatter = new HelpFormatter();
				formatter.printHelp("java -jar akad-campus.jar", options );
				System.exit(0);
			}

			if (cmd.hasOption("version")) {

				System.out.println("Akad Campus Version: " + AkadCampus.getVERSION());
				System.exit(0);

			}

			if (cmd.hasOption("user") && cmd.hasOption("pass")) {

				try {
					
					AkadCampus ac = new AkadCampus();
					ac.setUsername(cmd.getOptionValue("user"));
					ac.setPassword(cmd.getOptionValue("pass"));
					ac.generateCSV();
					
				}  catch (RuntimeException e2) {
					System.out.println(e2.getMessage());
				}
				
				
			} else {
				
				System.out.println("--help fuer Hilfe");
				
			}
			
			

		} catch (UnrecognizedOptionException e1) {
			System.out.println(e1.getMessage());
			System.out.println("--help fuer Hilfe");
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		
	}

}
