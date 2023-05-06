package com.wolly.dungeoncrawler;

@ScriptModule
public class Debug {
	private static boolean LOG_FILTER[] = new boolean[] { true, true, true, true };
	
	public enum ThreatLevel {
		Debug(0),
		Info(1),
		Warning(2),
		Error(3);
		
		private int _level;
		
		ThreatLevel(int pLevel) {
			_level = pLevel;
		}
		
		public int GetLevel() {
			return _level;
		}
	}
	
	public static void Log(String pMessage) {
		Log(pMessage, ThreatLevel.Debug);
	}
	
	public static void Log(int pMessage) {
		Log(String.valueOf(pMessage), ThreatLevel.Debug);
	}
	
	public static void Log(float pMessage) {
		Log(String.valueOf(pMessage), ThreatLevel.Debug);
	}
	
	public static void Log(boolean pMessage) {
		Log(String.valueOf(pMessage), ThreatLevel.Debug);
	}
	
	public static void Log(double pMessage) {
		Log(String.valueOf(pMessage), ThreatLevel.Debug);
	}
	
	public static void Log(char pMessage) {
		Log(String.valueOf(pMessage), ThreatLevel.Debug);
	}
	
	public static void Log(long pMessage) {
		Log(String.valueOf(pMessage), ThreatLevel.Debug);
	}
	
	public static void LogWarning(String pMessage) {
		Log(pMessage, ThreatLevel.Warning);
	}
	
	public static void LogWarning(int pMessage) {
		Log(String.valueOf(pMessage), ThreatLevel.Warning);
	}
	
	public static void LogWarning(float pMessage) {
		Log(String.valueOf(pMessage), ThreatLevel.Warning);
	}
	
	public static void LogWarning(boolean pMessage) {
		Log(String.valueOf(pMessage), ThreatLevel.Warning);
	}
	
	public static void LogWarning(double pMessage) {
		Log(String.valueOf(pMessage), ThreatLevel.Warning);
	}
	
	public static void LogWarning(char pMessage) {
		Log(String.valueOf(pMessage), ThreatLevel.Warning);
	}
	
	public static void LogWarning(long pMessage) {
		Log(String.valueOf(pMessage), ThreatLevel.Warning);
	}
	
	public static void LogInfo(String pMessage) {
		Log(pMessage, ThreatLevel.Info);
	}
	
	public static void LogInfo(int pMessage) {
		Log(String.valueOf(pMessage), ThreatLevel.Info);
	}
	
	public static void LogInfo(float pMessage) {
		Log(String.valueOf(pMessage), ThreatLevel.Info);
	}
	
	public static void LogInfo(boolean pMessage) {
		Log(String.valueOf(pMessage), ThreatLevel.Info);
	}
	
	public static void LogInfo(double pMessage) {
		Log(String.valueOf(pMessage), ThreatLevel.Info);
	}
	
	public static void LogInfo(char pMessage) {
		Log(String.valueOf(pMessage), ThreatLevel.Info);
	}
	
	public static void LogInfo(long pMessage) {
		Log(String.valueOf(pMessage), ThreatLevel.Info);
	}
	
	public static void LogError(String pMessage) {
		Log(pMessage, ThreatLevel.Error);
	}
	
	public static void LogError(int pMessage) {
		Log(String.valueOf(pMessage), ThreatLevel.Error);
	}
	
	public static void LogError(float pMessage) {
		Log(String.valueOf(pMessage), ThreatLevel.Error);
	}
	
	public static void LogError(boolean pMessage) {
		Log(String.valueOf(pMessage), ThreatLevel.Error);
	}
	
	public static void LogError(double pMessage) {
		Log(String.valueOf(pMessage), ThreatLevel.Error);
	}
	
	public static void LogError(char pMessage) {
		Log(String.valueOf(pMessage), ThreatLevel.Error);
	}
	
	public static void LogError(long pMessage) {
		Log(String.valueOf(pMessage), ThreatLevel.Error);
	}
	
	public static void Log(String pMessage, int pThreatLevel) {
		Log(pMessage, ThreatLevel.values()[pThreatLevel]);
	}
	
	public static void Log(String pMessage, ThreatLevel pThreatLevel) {
		String s = "[" + pThreatLevel.toString() + "] " + pMessage;
		switch(pThreatLevel) {
			case Debug:
			case Info:
			case Warning:
				System.out.println(s); // uses the out output stream
				break;
			case Error:
				System.err.println(s); // uses the error output stream
				break;
			}
	}
	
}
