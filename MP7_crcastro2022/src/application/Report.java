package application;

import java.util.Calendar;

public class Report {

		private String name;
		private String dateTime;
		private int scores;
		private String win;
		
		public Report(String name, int scores, boolean win) {
			
			this.name = name;
			Calendar c = Calendar.getInstance();
			dateTime = c.get(Calendar.YEAR) + "-" + c.get(Calendar.MONTH) + "-" + 
					c.get(Calendar.DAY_OF_MONTH) + " " + c.get(Calendar.HOUR) + ":" + 
					c.get(Calendar.MINUTE);
			this.scores = scores;
			this.win = win ? "win" : "lose";
			
		}

		public String getName() {
			
			return name;
			
		}

		public String getDateTime() {
			
			return dateTime;
			
		}

		public int getScores() {
			
			return scores;
			
		}

		public String getWin() {
			
			return win;
			
		}
		
	}
