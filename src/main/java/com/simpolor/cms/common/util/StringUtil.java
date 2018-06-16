package com.simpolor.cms.common.util;

public class StringUtil {
	
	/***
	 * 입력된 Object형의 값을 int형으로 반환
	 * 올바르지 않을 경우 -1으로 반환
	 * @param obj
	 * @return int
	 */
	public static int getInt(Object obj){
		return getInt(obj, -1);
	}
	
	/***
	 * 입력된 Object형의 값을 int형으로 반환
	 * 올바르지 않을 경우 대체할 값으로 반환
	 * @param obj
	 * @param defaultValue : 대체할 값 
	 * @return int
	 */
	public static int getInt(Object obj, int replaceNum){
		int num = replaceNum;
		if(obj != null){
			try{ 
				num = Integer.parseInt(obj.toString()); 
			}catch(Exception e){ }
		}
		return num;
	}
	
	/***
	 * 입력된 Object형의 값을 long형으로 반환
	 * 올바르지 않을 경우 -1L으로 반환
	 * @param obj
	 * @return long
	 */
	public static long getLong(Object obj){
		return getLong(obj, -1L);
	}
	
	/***
	 * 입력된 Object형의 값을 long형으로 반환
	 * 올바르지 않을 경우 대체할 값으로 반환
	 * @param obj
	 * @param defaultValue : 대체할 값
	 * @return long
	 */
	public static long getLong(Object obj, long replaceNum){
		long num = replaceNum;
		if(obj != null){
			try{
				num = Long.parseLong(obj.toString());
			}catch (Exception e) { }
		}
		return num;
	}
	
	/***
	 * 입력된 Object형의 값을 float형으로 반환
	 * 올바르지 않을 경우 -1.0f으로 반환
	 * @param obj
	 * @return float
	 */
	public static float getFloat(Object obj){
		return getFloat(obj, -1.0f);
	}
	
	/***
	 * 입력된 Object형의 값을 float형으로 반환
	 * 올바르지 않을 경우 대체할 값으로 반환
	 * @param obj
	 * @param defaultValue : 대체할 값 
	 * @return long
	 */
	public static float getFloat(Object obj, float replaceNum){
		float num = replaceNum;
		if(obj != null){
			try{
				num = Float.parseFloat(obj.toString());
			}catch(Exception e){ }
		}
		return num;
	}
	
	/***
	 * 입력된 Object형의 값을 double형으로 반환
	 * 올바르지 않을 경우 -1.0d으로 반환
	 * @param obj
	 * @return double
	 */
	public static double getDouble(Object obj){
		return getDouble(obj, -1.0d);
	}
	
	/***
	 * 입력된 Object형의 값을 float형으로 반환
	 * 올바르지 않을 경우 대체할 값으로 반환
	 * @param obj
	 * @param defaultValue : 대체할 값 
	 * @return long
	 */
	public static double getDouble(Object obj, double replaceNum){
		double num = replaceNum;
		if(obj != null){
			try{
				num = Double.parseDouble(obj.toString());
			}catch(Exception e){ }
		}
		return num;
	}
	
	/***
	 * 입력된 Object형의 값을 String형으로 반환
	 * 올바르지 않을 경우 null을 반환
	 * @param obj
	 * @return String
	 */
	public static String getString(Object obj){
		return getString(obj, null);
	}
	
	/***
	 * 입력된 Object형의 값을 String형의 문자로 반환
	 * 올바르지 않을 경우 대체 문자로 반환
	 * @param obj
	 * @param defaultValue : 대체할 문자
	 * @return String
	 */
	public static String getString(Object obj, String replaceStr){
		if(obj != null){
			try{
				return obj.toString();
			}catch(Exception e){ }
		}
		return  replaceStr;
	}
	
	/***
	 * 입력된 String[]형의 문자열 배열을 String형으로 반환
	 * 기본값으로 ", "로 구분되어 리턴됩니다.
	 * @param strArr
	 * @return String
	 */
	public static String getStrArr(String[] strArr){
		return getStrArr(strArr, ", ");
	}
	
	/***
	 * 입력된 String[]형의 문자열 배열을 String형으로 반환 ( 구분자 사용가능 )
	 * 예)getString(new String[]{"일", "이", "삼"}, "|") ->반환값 : "일|이|삼"  
	 * @param strArr : 문자열 배열
	 * @param splitStr : 구분자
	 * @return String
	 */
	public static String getStrArr(String[] strArr, String splitStr){
		StringBuffer sb = new StringBuffer();
		try{
			for(int i=0 ; i<strArr.length; i++){
				if(!isEmpty(splitStr) && i > 0) sb.append(splitStr);
				sb.append(strArr[i]);
			}
			return sb.toString();
		}catch (Exception e) { 
			return null;
		}
	}
	
	/***
	 * 입력된 String형의 문자가 null 또는 공백("")인지 여부를 확인 
	 * @param str
	 * @return boolean
	 */
	public static boolean isEmpty(String str){
		if(str == null || str.trim().length() <= 0){
			return true;
		}
		
		return false;
	}
	
	/***
	 * 입력된 String형의 문자의 길이를 int형으로 반환
	 * null일 경우 0을 반환
	 * @param str
	 * @return int
	 */
	public static int getLength(String str){
		if(isEmpty(str)){
			return 0;
		}
		return str.length();
	}
	
	/**
	 * 입력된 두 String형의 문자의 값이 동일한지 여부를 확인 ( 대소문자 구분 )
	 * 하나의 값이라도 null인 경우 false를 반환
	 * @param str1
	 * @param str2
	 * @return boolean
	 */
	public static boolean isEquals(String str1, String str2){
		if(str1 != null && str2 != null){
			if(str1.equals(str2)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 입력된 두 String형의 문자의 값이 동일한지 여부를 확인 ( 대소문자 무시 )
	 * 하나의 값이라도 null인 경우 false를 반환
	 * @param str1
	 * @param str2
	 * @return boolean 
	 */
	public static boolean isIgnoreEquals(String str1, String str2){
		if(str1 != null && str2 != null){
			String lowwer1 = str1.toLowerCase();
			String lowwer2 = str2.toLowerCase();
			if(lowwer1.equals(lowwer2)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 입력된 String형의 문자의 값을 입력된 index만큼 사이의 String형의 문자로 반환
	 * @param str
	 * @param beginIndex : 시작 위치
	 * @param endIndex	 : 종료 위치
	 * @return 원하는 index사이의 문자열 
	 */
	public static String substring(String str, int beginIndex, int endIndex){
		try{
			return str.substring(beginIndex, endIndex);
		}catch (Exception e) {
			return null;
		}
		
	}
	
	/**
	 * 입력된 String형의 문자의 값을 입력된 끝에서부터 index만큼 문자열 반환
	 * @param str
	 * @param index : 반환할 위치
	 * @return 원하는 문자열 
	 */
    public static String lastSubString( String str, int index ){
    	try{
    		return str.substring(str.length()-index, str.length());
    	}catch (Exception e) {
			return null;
		}
		
    }
    
	/**
	 * 입력된 String형의 문자의 값을 입력된 끝에서부터 index만큼 문자열을 삭제
	 * ( 마지막에 "," 와 같은 문자를 삭제할 경우 사용 )
	 * @param str
	 * @param index : 삭제 위치
	 * @return 원하는 문자열 
	 */
    public static String lastRemove(String str, int index){
    	try {
    		return str.substring(0, str.length()-index);
		} catch (Exception e) {
			return null;
		}
		
    }
    
}