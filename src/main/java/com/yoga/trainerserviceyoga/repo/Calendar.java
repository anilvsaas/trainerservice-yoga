package com.yoga.trainerserviceyoga.repo;

import com.yoga.trainerserviceyoga.model.CalendarModel;

public interface Calendar {
	public void updateCalendar(CalendarModel calendarModel);

	public CalendarModel getCalendarByProgramId(String programId);

	public void updateCalendarDependencies(CalendarModel calendarModel);

	public void saveCalendar(CalendarModel calendarModel);

	public void deleteById(String calendarId);
}
