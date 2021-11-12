package ru.mephi.lab6;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import static java.time.DayOfWeek.*;
import static java.time.Month.*;
import static java.time.temporal.TemporalAdjusters.*;
import static java.time.temporal.ChronoUnit.*;
import static java.lang.System.out;

public class Time {

    public static DateTimeFormatter timeFormatter = DateTimeFormatter
            .ofPattern("K:mm a");
    public static DateTimeFormatter dateFormatter = DateTimeFormatter
            .ofLocalizedDate(FormatStyle.LONG)
            .withLocale(new Locale("en"));
    public static DateTimeFormatter fullFormatter = DateTimeFormatter
            .ofPattern("hh:mm a MMMM dd, yyyy")
            .withLocale(new Locale("en"));

    public static ZoneId boston = ZoneId.of("America/New_York");
    public static ZoneId sanFrancisco = ZoneId.of("America/Los_Angeles");
    public static ZoneId bangalore = ZoneId.of("Asia/Calcutta");

    // Abe Lincoln's Birthday: February 12, 1809, died April 15, 1855
    //   How old when he died?
    //   How many days did he live?
    public static void lincoln() {
        LocalDate birthDate = LocalDate.parse("February 12, 1809", dateFormatter);
        LocalDate deathDate = LocalDate.parse("April 15, 1855", dateFormatter);
        out.println("Lincoln was " + Period.between(birthDate, deathDate).getYears() +
                " years old and lived " + DAYS.between(birthDate, deathDate) + " days");
        out.println("\n========\n");
    }

    // Bennedict Cumberbatch, July 19, 1976
    //   Born in a leap year?
    //   How many days in the year he was born?
    //   How many decades old is he?
    //   What was the day of the week on his 21st birthday?
    public static void cumberbatch() {
        LocalDate birthDate = LocalDate.parse("July 19, 1976", dateFormatter);
        out.println("Leap year: " + birthDate.isLeapYear() +
                "\nDays in year was born: " + Year.of(1976).length() +
                "\nDecades lives: " + Period.between(birthDate, LocalDate.now()).getYears() / 10 +
                "\nDay of the week on 21st birthday: " + birthDate.plusYears(21).getDayOfWeek()
        );
        out.println("\n========\n");
    }

    // Train departs Boston at 1:45PM and arrives New York 7:25PM
    //   How many minutes long is the train ride?
    //   If the train was delayed 1 hour 19 minutes, what is the actual arrival time?
    public static void train() {
        // Бостон и Нью-Йорк находятся в одном часовом поясе
        LocalTime departureTime = LocalTime.parse("1:45 PM", timeFormatter);
        LocalTime arrivalTime = LocalTime.parse("7:25 PM", timeFormatter);
        out.println("Train ride in minutes: " + Duration.between(departureTime, arrivalTime).toMinutes() +
                "\nArrival if delayed: " + arrivalTime.plusHours(1).plusMinutes(19).format(timeFormatter)
        );
        out.println("\n========\n");
    }

    // Flight: Boston to Miami, leaves March 24th 9:15PM. Flight time is 4 hours 15 minutes
    //   When does it arrive in Miami?
    //   When does it arrive if the flight is delays 4 hours 27 minutes?
    public static void flight() {
        // Бостон и Майами находятся в одном часовом поясе
        LocalDateTime departure = LocalDate
                .of(LocalDate.now().getYear(), MARCH, 24)
                .atTime(LocalTime.parse("9:15 PM", timeFormatter));
        LocalDateTime arrival = departure.plusHours(4).plusMinutes(15);
        LocalDateTime arrivalIfDelayed = arrival.plusHours(4).plusMinutes(27);
        out.println("Arrival: " + arrival.format(timeFormatter) +
                "\nArrival if delayed: " + arrivalIfDelayed.format(timeFormatter)
        );
        out.println("\n========\n");
    }

    // School semester starts the second Tuesday of September of this year.
    //   Hint: Look at the TemporalAdjusters class
    //   What is the date?
    //   School summer vacation starts June 25th
    //   Assuming:
    //     *  Two weeks off in December
    //     *  Two other vacation weeks
    //     *  School is taught Monday - Friday
    //   How many days of school are there?
    //   Hint: keep track of the short weeks also
    public static void school() {
        LocalDate start = Year
                .of(LocalDate.now().getYear())
                .atMonth(SEPTEMBER)
                .atDay(1)
                .with(dayOfWeekInMonth(2, TUESDAY));
        LocalDate end = Year
                .of(LocalDate.now().getYear() + 1)
                .atMonth(JUNE)
                .atDay(25);
        long daysWithoutVacation = DAYS.between(start, end.minusWeeks(4));
        long weeks = daysWithoutVacation / 7;
        long remainder = daysWithoutVacation % 7;
        daysWithoutVacation -= weeks * 2 + Math.min(remainder, 2);
        out.println("Semester starts on " + start.format(dateFormatter) +
                "\nDays of school: " + daysWithoutVacation
        );
        out.println("\n========\n");
    }

    // A meeting is schedule for 1:30 PM next Tuesday. If today is Tuesday, assume it is today.
    //   What is the time of the week's meetings?
    public static void meeting() {
        LocalDateTime meeting = LocalDateTime.of(
                LocalDate.now().with(nextOrSame(TUESDAY)),
                LocalTime.parse("1:30 PM", timeFormatter)
        );
        out.println("Week's meeting at: " + meeting.format(fullFormatter));
        out.println("\n========\n");
    }

    // Flight 123, San Francisco to  Boston, leaves SFO at 10:30 PM June 13, 2014
    // The flight is 5 hours 30 minutes
    //   What is the local time in Boston when the flight takes off?
    //   What is the local time at Boston Logan airport when the flight arrives?
    //   What is the local time in San Francisco when the flight arrives?
    public static void flight1() {
        ZonedDateTime departureSF = ZonedDateTime.of(
                LocalDate.parse("June 13, 2014", dateFormatter),
                LocalTime.parse("10:30 PM", timeFormatter),
                sanFrancisco
        );
        ZonedDateTime departureBoston = departureSF
                .toOffsetDateTime()
                .atZoneSameInstant(boston);
        ZonedDateTime arrivalSF = departureSF
                .plusHours(5)
                .plusMinutes(30);
        ZonedDateTime arrivalBoston = departureBoston
                .plusHours(5)
                .plusMinutes(30);
        out.println("Takes off (Boston): " + departureBoston.format(fullFormatter) +
                "\nArrives (Boston) at: " + arrivalBoston.format(fullFormatter) +
                "\nArrives (San Francisco) at: " + arrivalSF.format(fullFormatter)
        );
        out.println("\n========\n");
    }

    // Flight 456, San Francisco to Bangalore, India, leaves SFO at Saturday, 10:30 PM June 28, 2014
    // The flight time is 22 hours
    //   Will the traveler make a meeting in Bangalore Monday at 9 AM local time?
    //   Can the traveler call her husband at a reasonable time when she arrives?
    public static void flight2() {
        ZonedDateTime departureSF = ZonedDateTime.of(
                LocalDate.parse("June 28, 2014", dateFormatter),
                LocalTime.parse("10:30 PM", timeFormatter),
                sanFrancisco
        );
        ZonedDateTime meeting = ZonedDateTime.of(
                LocalDate.parse("June 28, 2014", dateFormatter).plusDays(2),
                LocalTime.parse("9:00 PM", timeFormatter),
                bangalore
        );
        ZonedDateTime arrivalSF = departureSF.plusHours(22);
        ZonedDateTime arrivalBgl = arrivalSF
                .toOffsetDateTime()
                .atZoneSameInstant(bangalore);
        out.println("Arrives (Bangalore) at: " + arrivalBgl.format(fullFormatter) +
                "\nArrives (San Francisco) at: " + arrivalSF.format(fullFormatter) +
                "\nMake meeting: " + (arrivalBgl.isBefore(meeting) ? "yes" : "no") +
                "\nCall husband: why not? Don't understand what time you consider 'reasonable'..."
        );
        out.println("\n========\n");
    }

    // Flight 123, San Francisco to Boston, leaves SFO at 10:30 PM Saturday, November 1st, 2014
    // Flight time is 5 hours 30 minutes.
    //   What day and time does the flight arrive in Boston?
    //   What happened?
    public static void flight3() {
        ZonedDateTime departureSF = ZonedDateTime.of(
                LocalDate.parse("November 1, 2014", dateFormatter),
                LocalTime.parse("10:30 PM", timeFormatter),
                sanFrancisco
        );
        ZonedDateTime arrivalBoston = departureSF
                .plusHours(5)
                .plusMinutes(30)
                .toOffsetDateTime()
                .atZoneSameInstant(boston);
        out.println("Arrives (Boston) at: " + arrivalBoston.format(fullFormatter) +
                "\nWhat happened?  ¯\\_(ツ)_/¯");
    }

    public static void main(String[] args) {
        out.println();
        lincoln();
        cumberbatch();
        train();
        flight();
        school();
        meeting();
        flight1();
        flight2();
        flight3();
    }

}