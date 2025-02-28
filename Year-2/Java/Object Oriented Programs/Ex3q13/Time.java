/**
** Author: DH         Date: November '15
**
** Description: The definition for class Time (as described in this handout) is in Time.java on 
*   			the common drive.  There is a driver program called TimeTest.java in the same 
*   			directory. Copy both these files to your account. Run the driver program. Can 
*   			you follow what is happening? If not, ask for help. Provide another driver 
*   			program Clock.java that will create a Time object - you should pass to the Time 
*   			constructor method the current time in hours and minutes. Next, write a loop 
*   			that calls method tick() every second and then prints the stored time.  The 
*   			loop (and program) should terminate when the stored time advances to the next 
*   			minute. 
*  				Hint: to find out when a second has passed you will need to use 
*  				System.currentTimeMillis() which returns the number of milliseconds elapsed 
*  				since January 1, 1970.  There are 1000 milliseconds in 1 second.
*/
// Time class definition
public class Time 
{ // begin class Time
   private int hour;     // 0 - 23
   private int minute;   // 0 - 59
   private int second;   // 0 - 59

 
  // Time constructor initializes each instance variable
   // to zero. Ensures that Time object starts in a 
   // consistent state.
   public Time() 
   { 
		setTime( 0, 0, 0 ); 
   }

   // Time constructor: hour supplied, minute and second
   // defaulted to 0.
   public Time( int h ) 
   { 
		setTime( h, 0, 0 ); 
   }

   // Time constructor: hour and minute supplied, second
   // defaulted to 0.
   public Time( int h, int m ) 
   { 
		setTime( h, m, 0 ); 
   }

   // Time constructor: hour, minute and second supplied.
   public Time( int h, int m, int s ) 
   { 
		setTime( h, m, s ); 
   }

   // Set Methods
   // Set a new Time value using military time. Perform 
   // validity checks on the data. Set invalid values 
   // to zero.
   public void setTime( int h, int m, int s )
   {
		setHour( h );    // set the hour
		setMinute( m );  // set the minute
		setSecond( s );  // set the second
   }
  
 
 // set the hour 
   public void setHour( int h ) 
   { 	
	   hour = ( ( h >= 0 && h < 24 ) ? h : 0 ); 
	   // read the above line like this:
	   // if (h >= 0 && h < 24 ) 
	   //	hour = h;
	   // else
	   //   hour = 0;
   }


// set the minute 
   public void setMinute( int m ) 
   { 
		minute = ( ( m >= 0 && m < 60 ) ? m : 0 ); 
   }

   // set the second 
   public void setSecond( int s ) 
   { 
		second = ( ( s >= 0 && s < 60 ) ? s : 0 ); 
   }

   // Get Methods
   // get the hour
   public int getHour() { return hour; }

   // get the minute
   public int getMinute() { return minute; }

   // get the second
   public int getSecond() { return second; }

   // Convert Time to String in military-time format
   public String toMilitaryString()
   {
      return ( hour < 10 ? "0" : "" ) + hour +
             ( minute < 10 ? "0" : "" ) + minute;
   }

   // Convert Time to String in standard-time format
   public String toString()
   {
      return ( ( hour == 12 || hour == 0 ) ? 12 : hour % 12 ) +
             ":" + ( minute < 10 ? "0" : "" ) + minute +
             ":" + ( second < 10 ? "0" : "" ) + second +
             ( hour < 12 ? " AM" : " PM" );		
   }

   // Tick the time by one second
   public void tick()
   {
      setSecond( second + 1 );

      if ( second == 0 )
         incrementMinute();
   }

   // Increment the minute
   public void incrementMinute()
   {
      setMinute( minute + 1 );

      if ( minute == 0 )
         incrementHour();
   }

   // Increment the hour
   public void incrementHour()
      { setHour( hour + 1 ); }
} // end class Time

