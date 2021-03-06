package tools;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.stage.Screen;

/*
 * 
 * @author Ben Sixel
 *   Copyright 2015 Benjamin Sixel

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

public class SystemInfo {
	
	/*
	 * Some constant formats to use for getting date and time.
	 */
	public static final DateFormat dateFormat = new SimpleDateFormat("MMMMMMMMM dd, hh:mm a");
	public static final DateFormat milDateFormat = new SimpleDateFormat("MMMMMMMMM dd, HH:mm");
	public static final DateFormat expMilDateFormat = new SimpleDateFormat("MMMMMMMMM dd, YYYY HH:mm");
	
	/**
	 * Gets the current date with military time.
	 * @return The current date with military time.
	 */
	public static String getDate() {
		return milDateFormat.format(new Date());
	}
	
	/**
	 * Returns only the time in military time.
	 * @return The time in military time.
	 */
	public static String getTime() {
		return new SimpleDateFormat("HH:mm a").format(new Date());
	}

	/**
	 * Gets the full date using military time and including the year.
	 * @return The full date using military time and including the year.
	 */
	public static String getFullDate() {
		return expMilDateFormat.format(new Date());
	}
	
	/**
	 * Getter for the display screen's width.
	 * @return The width of the primary screen (monitor/projector).
	 */
	public static double getScreenWidth() {
		return Screen.getPrimary().getVisualBounds().getWidth();
	}
	
	/**
	 * Getter for the primary screen's height.
	 * @return The height of the primary monitor/projector.
	 */
	public static double getScreenHeight() {
		return Screen.getPrimary().getVisualBounds().getHeight();
	}
	
}