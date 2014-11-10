/** @version $Id: Calendar.java,v 1.2 2011/09/25 14:47:44 david Exp $ */
package bank;

import java.util.GregorianCalendar;

/**
 * Calendar class for keeping the current date and compute date intervals. Dates
 * are represented as the number of days from 1970/01/01.
 */
public class Calendar {

	/** Single instance of this class. */
	private static Calendar _calendar = new Calendar();

	/** Today's date. */
	private long _current;

	/** Base calendar for date computations. */
	private GregorianCalendar _cal;

	/** Milliseconds in a day. */
	private final static int DAYMILLIS = 24 * 60 * 60 * 1000;

	/**
	 * @return the single instance of this class.
	 */
	public static Calendar getCalendar() {
		return _calendar;
	}

	/**
	 * Set internal state for "today".
	 */
	private Calendar() {
		_cal = new GregorianCalendar();
		_cal.setTimeInMillis(System.currentTimeMillis());
		_current = _cal.getTimeInMillis() / DAYMILLIS;
	}

	/**
	 * @return number of days since 1979/01/01.
	 */
	public long today() {
		return _current;
	}

	/**
	 * @param before
	 *            a previous date
	 * 
	 * @return number of days from "before" to the today.
	 */
	public int daysSince(long before) {
		return (int) (today() - before);
	}

	/**
	 * @param date
	 *            number of days from 1970/01/01.
	 * 
	 * @return string representing a date with the format AAAA MM DD.
	 */
	@SuppressWarnings("nls")
	public String getDate(long date) {
		// 6 is to account for possible DST errors
		_cal.set(1970, 0, 1, 6, 0);
		_cal.add(java.util.Calendar.DATE, (int) date);

		// 1 must be added to the month, because they start at 0
		return _cal.get(java.util.Calendar.YEAR) + " " + (_cal.get(java.util.Calendar.MONTH) + 1)
				+ " " + _cal.get(java.util.Calendar.DAY_OF_MONTH);
	}

	/**
	 * Set today's date (for debug purposes only).
	 * 
	 * @param date
	 *            number of days from 1970/01/01.
	 */
	public void setDate(long date) {
		_current = date;
	}

	/**
	 * Advance today's date by a given number of days.
	 * 
	 * @param days
	 */
	public void advanceDate(int days) {
		setDate(today() + days);
	}

	/**
	 * Set today's date (for debug purposes only).
	 * 
	 * @param year
	 *            today's year.
	 * @param month
	 *            today's month (starts at 1).
	 * @param day
	 *            today's day.
	 */
	public void setDate(int year, int month, int day) {
		if (year >= 1970)
			_current = daysAfterEpoch(year, month, day);
		else
			_current = daysBeforeEpoch(year, month, day);
	}

	/**
	 * Counts the number of days between the date given as argument and
	 * 1970/01/01 (intended for later dates).
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * 
	 * @return number of days between the date given as argument and 1970/01/01.
	 */
	private long daysAfterEpoch(int year, int month, int day) {
		int t_ano = 1970;
		long days = 0;

		while (t_ano < year) {
			if (_cal.isLeapYear(t_ano++))
				days += 366;
			else
				days += 365;
		}
		_cal.set(year, month - 1, day);
		days += _cal.get(java.util.Calendar.DAY_OF_YEAR) - 1;
		return days;
	}

	/**
	 * Counts the number of days between the date given as argument and
	 * 1970/01/01 (intended for previous dates).
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * 
	 * @return number of days between the date given as argument and 1970/01/01.
	 */
	private long daysBeforeEpoch(int year, int month, int day) {
		int t_year = 1969;
		long days = 0;

		while (t_year >= year) {
			if (_cal.isLeapYear(t_year--))
				days -= 366;
			else
				days -= 365;
		}

		_cal.set(year, month - 1, day);
		days += _cal.get(java.util.Calendar.DAY_OF_YEAR) - 1;
		return days;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public final String toString() {
		return getDate(today());
	}

}

// $Log: Calendar.java,v $
// Revision 1.2 2011/09/25 14:47:44 david
// Updated version of the bank application. The core classes are as before (no
// changes).
//