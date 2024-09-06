// ============================================================================
//
// Copyright (c) 2006-2015, Talend SA
//
// Ce code source a été automatiquement généré par_Talend Open Studio for Data Integration
// / Soumis à la Licence Apache, Version 2.0 (la "Licence") ;
// votre utilisation de ce fichier doit respecter les termes de la Licence.
// Vous pouvez obtenir une copie de la Licence sur
// http://www.apache.org/licenses/LICENSE-2.0
// 
// Sauf lorsqu'explicitement prévu par la loi en vigueur ou accepté par écrit, le logiciel
// distribué sous la Licence est distribué "TEL QUEL",
// SANS GARANTIE OU CONDITION D'AUCUNE SORTE, expresse ou implicite.
// Consultez la Licence pour connaître la terminologie spécifique régissant les autorisations et
// les limites prévues par la Licence.

package airline_project.airline_oracle_db_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;

@SuppressWarnings("unused")

/**
 * Job: Airline_Oracle_DB Purpose: Airline_Oracle_DB<br>
 * Description: Airline_Oracle_DB <br>
 * 
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status
 */
public class Airline_Oracle_DB implements TalendJob {

	protected static void logIgnoredError(String message, Throwable cause) {
		System.err.println(message);
		if (cause != null) {
			cause.printStackTrace();
		}

	}

	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}

	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	private final static String utf8Charset = "UTF-8";

	// contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String, String> propertyTypes = new java.util.HashMap<>();

		public PropertiesWithType(java.util.Properties properties) {
			super(properties);
		}

		public PropertiesWithType() {
			super();
		}

		public void setContextType(String key, String type) {
			propertyTypes.put(key, type);
		}

		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}

	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();

	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties) {
			super(properties);
		}

		public ContextProperties() {
			super();
		}

		public void synchronizeContext() {

		}

		// if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if (NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

	}

	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "Airline_Oracle_DB";
	private final String projectName = "AIRLINE_PROJECT";
	public Integer errorCode = null;
	private String currentComponent = "";

	private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
	private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();

	private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
	public final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();

	private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";

	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(),
					new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	public void setDataSourceReferences(List serviceReferences) throws Exception {

		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();

		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils
				.getServices(serviceReferences, javax.sql.DataSource.class).entrySet()) {
			dataSources.put(entry.getKey(), entry.getValue());
			talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
	private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

	public String getExceptionStackTrace() {
		if ("failure".equals(this.getStatus())) {
			errorMessagePS.flush();
			return baos.toString();
		}
		return null;
	}

	private Exception exception;

	public Exception getException() {
		if ("failure".equals(this.getStatus())) {
			return this.exception;
		}
		return null;
	}

	private class TalendException extends Exception {

		private static final long serialVersionUID = 1L;

		private java.util.Map<String, Object> globalMap = null;
		private Exception e = null;
		private String currentComponent = null;
		private String virtualComponentName = null;

		public void setVirtualComponentName(String virtualComponentName) {
			this.virtualComponentName = virtualComponentName;
		}

		private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
			this.currentComponent = errorComponent;
			this.globalMap = globalMap;
			this.e = e;
		}

		public Exception getException() {
			return this.e;
		}

		public String getCurrentComponent() {
			return this.currentComponent;
		}

		public String getExceptionCauseMessage(Exception e) {
			Throwable cause = e;
			String message = null;
			int i = 10;
			while (null != cause && 0 < i--) {
				message = cause.getMessage();
				if (null == message) {
					cause = cause.getCause();
				} else {
					break;
				}
			}
			if (null == message) {
				message = e.getClass().getName();
			}
			return message;
		}

		@Override
		public void printStackTrace() {
			if (!(e instanceof TalendException || e instanceof TDieException)) {
				if (virtualComponentName != null && currentComponent.indexOf(virtualComponentName + "_") == 0) {
					globalMap.put(virtualComponentName + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				}
				globalMap.put(currentComponent + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
			}
			if (!(e instanceof TDieException)) {
				if (e instanceof TalendException) {
					e.printStackTrace();
				} else {
					e.printStackTrace();
					e.printStackTrace(errorMessagePS);
					Airline_Oracle_DB.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(Airline_Oracle_DB.this, new Object[] { e, currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
					}
				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tFileInputDelimited_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tUniqRow_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileOutputExcel_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputDelimited_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
		final static byte[] commonByteArrayLock_AIRLINE_PROJECT_Airline_Oracle_DB = new byte[0];
		static byte[] commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB = new byte[0];

		public String PassengerID;

		public String getPassengerID() {
			return this.PassengerID;
		}

		public String FirstName;

		public String getFirstName() {
			return this.FirstName;
		}

		public String LastName;

		public String getLastName() {
			return this.LastName;
		}

		public String Gender;

		public String getGender() {
			return this.Gender;
		}

		public Integer Age;

		public Integer getAge() {
			return this.Age;
		}

		public String Nationality;

		public String getNationality() {
			return this.Nationality;
		}

		public String AirportName;

		public String getAirportName() {
			return this.AirportName;
		}

		public String AirportCountryCode;

		public String getAirportCountryCode() {
			return this.AirportCountryCode;
		}

		public String CountryName;

		public String getCountryName() {
			return this.CountryName;
		}

		public String AIRPORTCONTINENT;

		public String getAIRPORTCONTINENT() {
			return this.AIRPORTCONTINENT;
		}

		public String CONTINENTS;

		public String getCONTINENTS() {
			return this.CONTINENTS;
		}

		public String DEPARTUREDATE;

		public String getDEPARTUREDATE() {
			return this.DEPARTUREDATE;
		}

		public String ARRIVALAIRPORT;

		public String getARRIVALAIRPORT() {
			return this.ARRIVALAIRPORT;
		}

		public String PILOTNAME;

		public String getPILOTNAME() {
			return this.PILOTNAME;
		}

		public String FLIGHTSTATUS;

		public String getFLIGHTSTATUS() {
			return this.FLIGHTSTATUS;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB.length) {
					if (length < 1024 && commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB.length == 0) {
						commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB = new byte[1024];
					} else {
						commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB, 0, length);
				strReturn = new String(commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB.length) {
					if (length < 1024 && commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB.length == 0) {
						commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB = new byte[1024];
					} else {
						commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB, 0, length);
				strReturn = new String(commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_AIRLINE_PROJECT_Airline_Oracle_DB) {

				try {

					int length = 0;

					this.PassengerID = readString(dis);

					this.FirstName = readString(dis);

					this.LastName = readString(dis);

					this.Gender = readString(dis);

					this.Age = readInteger(dis);

					this.Nationality = readString(dis);

					this.AirportName = readString(dis);

					this.AirportCountryCode = readString(dis);

					this.CountryName = readString(dis);

					this.AIRPORTCONTINENT = readString(dis);

					this.CONTINENTS = readString(dis);

					this.DEPARTUREDATE = readString(dis);

					this.ARRIVALAIRPORT = readString(dis);

					this.PILOTNAME = readString(dis);

					this.FLIGHTSTATUS = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_AIRLINE_PROJECT_Airline_Oracle_DB) {

				try {

					int length = 0;

					this.PassengerID = readString(dis);

					this.FirstName = readString(dis);

					this.LastName = readString(dis);

					this.Gender = readString(dis);

					this.Age = readInteger(dis);

					this.Nationality = readString(dis);

					this.AirportName = readString(dis);

					this.AirportCountryCode = readString(dis);

					this.CountryName = readString(dis);

					this.AIRPORTCONTINENT = readString(dis);

					this.CONTINENTS = readString(dis);

					this.DEPARTUREDATE = readString(dis);

					this.ARRIVALAIRPORT = readString(dis);

					this.PILOTNAME = readString(dis);

					this.FLIGHTSTATUS = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.PassengerID, dos);

				// String

				writeString(this.FirstName, dos);

				// String

				writeString(this.LastName, dos);

				// String

				writeString(this.Gender, dos);

				// Integer

				writeInteger(this.Age, dos);

				// String

				writeString(this.Nationality, dos);

				// String

				writeString(this.AirportName, dos);

				// String

				writeString(this.AirportCountryCode, dos);

				// String

				writeString(this.CountryName, dos);

				// String

				writeString(this.AIRPORTCONTINENT, dos);

				// String

				writeString(this.CONTINENTS, dos);

				// String

				writeString(this.DEPARTUREDATE, dos);

				// String

				writeString(this.ARRIVALAIRPORT, dos);

				// String

				writeString(this.PILOTNAME, dos);

				// String

				writeString(this.FLIGHTSTATUS, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.PassengerID, dos);

				// String

				writeString(this.FirstName, dos);

				// String

				writeString(this.LastName, dos);

				// String

				writeString(this.Gender, dos);

				// Integer

				writeInteger(this.Age, dos);

				// String

				writeString(this.Nationality, dos);

				// String

				writeString(this.AirportName, dos);

				// String

				writeString(this.AirportCountryCode, dos);

				// String

				writeString(this.CountryName, dos);

				// String

				writeString(this.AIRPORTCONTINENT, dos);

				// String

				writeString(this.CONTINENTS, dos);

				// String

				writeString(this.DEPARTUREDATE, dos);

				// String

				writeString(this.ARRIVALAIRPORT, dos);

				// String

				writeString(this.PILOTNAME, dos);

				// String

				writeString(this.FLIGHTSTATUS, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("PassengerID=" + PassengerID);
			sb.append(",FirstName=" + FirstName);
			sb.append(",LastName=" + LastName);
			sb.append(",Gender=" + Gender);
			sb.append(",Age=" + String.valueOf(Age));
			sb.append(",Nationality=" + Nationality);
			sb.append(",AirportName=" + AirportName);
			sb.append(",AirportCountryCode=" + AirportCountryCode);
			sb.append(",CountryName=" + CountryName);
			sb.append(",AIRPORTCONTINENT=" + AIRPORTCONTINENT);
			sb.append(",CONTINENTS=" + CONTINENTS);
			sb.append(",DEPARTUREDATE=" + DEPARTUREDATE);
			sb.append(",ARRIVALAIRPORT=" + ARRIVALAIRPORT);
			sb.append(",PILOTNAME=" + PILOTNAME);
			sb.append(",FLIGHTSTATUS=" + FLIGHTSTATUS);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row2Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class out1Struct implements routines.system.IPersistableRow<out1Struct> {
		final static byte[] commonByteArrayLock_AIRLINE_PROJECT_Airline_Oracle_DB = new byte[0];
		static byte[] commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB = new byte[0];

		public String PassengerID;

		public String getPassengerID() {
			return this.PassengerID;
		}

		public String FirstName;

		public String getFirstName() {
			return this.FirstName;
		}

		public String LastName;

		public String getLastName() {
			return this.LastName;
		}

		public String Gender;

		public String getGender() {
			return this.Gender;
		}

		public Integer Age;

		public Integer getAge() {
			return this.Age;
		}

		public String Nationality;

		public String getNationality() {
			return this.Nationality;
		}

		public String AirportName;

		public String getAirportName() {
			return this.AirportName;
		}

		public String AirportCountryCode;

		public String getAirportCountryCode() {
			return this.AirportCountryCode;
		}

		public String CountryName;

		public String getCountryName() {
			return this.CountryName;
		}

		public String AIRPORTCONTINENT;

		public String getAIRPORTCONTINENT() {
			return this.AIRPORTCONTINENT;
		}

		public String CONTINENTS;

		public String getCONTINENTS() {
			return this.CONTINENTS;
		}

		public String DEPARTUREDATE;

		public String getDEPARTUREDATE() {
			return this.DEPARTUREDATE;
		}

		public String ARRIVALAIRPORT;

		public String getARRIVALAIRPORT() {
			return this.ARRIVALAIRPORT;
		}

		public String PILOTNAME;

		public String getPILOTNAME() {
			return this.PILOTNAME;
		}

		public String FLIGHTSTATUS;

		public String getFLIGHTSTATUS() {
			return this.FLIGHTSTATUS;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB.length) {
					if (length < 1024 && commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB.length == 0) {
						commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB = new byte[1024];
					} else {
						commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB, 0, length);
				strReturn = new String(commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB.length) {
					if (length < 1024 && commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB.length == 0) {
						commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB = new byte[1024];
					} else {
						commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB, 0, length);
				strReturn = new String(commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_AIRLINE_PROJECT_Airline_Oracle_DB) {

				try {

					int length = 0;

					this.PassengerID = readString(dis);

					this.FirstName = readString(dis);

					this.LastName = readString(dis);

					this.Gender = readString(dis);

					this.Age = readInteger(dis);

					this.Nationality = readString(dis);

					this.AirportName = readString(dis);

					this.AirportCountryCode = readString(dis);

					this.CountryName = readString(dis);

					this.AIRPORTCONTINENT = readString(dis);

					this.CONTINENTS = readString(dis);

					this.DEPARTUREDATE = readString(dis);

					this.ARRIVALAIRPORT = readString(dis);

					this.PILOTNAME = readString(dis);

					this.FLIGHTSTATUS = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_AIRLINE_PROJECT_Airline_Oracle_DB) {

				try {

					int length = 0;

					this.PassengerID = readString(dis);

					this.FirstName = readString(dis);

					this.LastName = readString(dis);

					this.Gender = readString(dis);

					this.Age = readInteger(dis);

					this.Nationality = readString(dis);

					this.AirportName = readString(dis);

					this.AirportCountryCode = readString(dis);

					this.CountryName = readString(dis);

					this.AIRPORTCONTINENT = readString(dis);

					this.CONTINENTS = readString(dis);

					this.DEPARTUREDATE = readString(dis);

					this.ARRIVALAIRPORT = readString(dis);

					this.PILOTNAME = readString(dis);

					this.FLIGHTSTATUS = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.PassengerID, dos);

				// String

				writeString(this.FirstName, dos);

				// String

				writeString(this.LastName, dos);

				// String

				writeString(this.Gender, dos);

				// Integer

				writeInteger(this.Age, dos);

				// String

				writeString(this.Nationality, dos);

				// String

				writeString(this.AirportName, dos);

				// String

				writeString(this.AirportCountryCode, dos);

				// String

				writeString(this.CountryName, dos);

				// String

				writeString(this.AIRPORTCONTINENT, dos);

				// String

				writeString(this.CONTINENTS, dos);

				// String

				writeString(this.DEPARTUREDATE, dos);

				// String

				writeString(this.ARRIVALAIRPORT, dos);

				// String

				writeString(this.PILOTNAME, dos);

				// String

				writeString(this.FLIGHTSTATUS, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.PassengerID, dos);

				// String

				writeString(this.FirstName, dos);

				// String

				writeString(this.LastName, dos);

				// String

				writeString(this.Gender, dos);

				// Integer

				writeInteger(this.Age, dos);

				// String

				writeString(this.Nationality, dos);

				// String

				writeString(this.AirportName, dos);

				// String

				writeString(this.AirportCountryCode, dos);

				// String

				writeString(this.CountryName, dos);

				// String

				writeString(this.AIRPORTCONTINENT, dos);

				// String

				writeString(this.CONTINENTS, dos);

				// String

				writeString(this.DEPARTUREDATE, dos);

				// String

				writeString(this.ARRIVALAIRPORT, dos);

				// String

				writeString(this.PILOTNAME, dos);

				// String

				writeString(this.FLIGHTSTATUS, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("PassengerID=" + PassengerID);
			sb.append(",FirstName=" + FirstName);
			sb.append(",LastName=" + LastName);
			sb.append(",Gender=" + Gender);
			sb.append(",Age=" + String.valueOf(Age));
			sb.append(",Nationality=" + Nationality);
			sb.append(",AirportName=" + AirportName);
			sb.append(",AirportCountryCode=" + AirportCountryCode);
			sb.append(",CountryName=" + CountryName);
			sb.append(",AIRPORTCONTINENT=" + AIRPORTCONTINENT);
			sb.append(",CONTINENTS=" + CONTINENTS);
			sb.append(",DEPARTUREDATE=" + DEPARTUREDATE);
			sb.append(",ARRIVALAIRPORT=" + ARRIVALAIRPORT);
			sb.append(",PILOTNAME=" + PILOTNAME);
			sb.append(",FLIGHTSTATUS=" + FLIGHTSTATUS);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(out1Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
		final static byte[] commonByteArrayLock_AIRLINE_PROJECT_Airline_Oracle_DB = new byte[0];
		static byte[] commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB = new byte[0];

		public String PassengerID;

		public String getPassengerID() {
			return this.PassengerID;
		}

		public String FirstName;

		public String getFirstName() {
			return this.FirstName;
		}

		public String LastName;

		public String getLastName() {
			return this.LastName;
		}

		public String Gender;

		public String getGender() {
			return this.Gender;
		}

		public Integer Age;

		public Integer getAge() {
			return this.Age;
		}

		public String Nationality;

		public String getNationality() {
			return this.Nationality;
		}

		public String AirportName;

		public String getAirportName() {
			return this.AirportName;
		}

		public String AirportCountryCode;

		public String getAirportCountryCode() {
			return this.AirportCountryCode;
		}

		public String CountryName;

		public String getCountryName() {
			return this.CountryName;
		}

		public String AIRPORTCONTINENT;

		public String getAIRPORTCONTINENT() {
			return this.AIRPORTCONTINENT;
		}

		public String CONTINENTS;

		public String getCONTINENTS() {
			return this.CONTINENTS;
		}

		public String DEPARTUREDATE;

		public String getDEPARTUREDATE() {
			return this.DEPARTUREDATE;
		}

		public String ARRIVALAIRPORT;

		public String getARRIVALAIRPORT() {
			return this.ARRIVALAIRPORT;
		}

		public String PILOTNAME;

		public String getPILOTNAME() {
			return this.PILOTNAME;
		}

		public String FLIGHTSTATUS;

		public String getFLIGHTSTATUS() {
			return this.FLIGHTSTATUS;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB.length) {
					if (length < 1024 && commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB.length == 0) {
						commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB = new byte[1024];
					} else {
						commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB, 0, length);
				strReturn = new String(commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB.length) {
					if (length < 1024 && commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB.length == 0) {
						commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB = new byte[1024];
					} else {
						commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB, 0, length);
				strReturn = new String(commonByteArray_AIRLINE_PROJECT_Airline_Oracle_DB, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_AIRLINE_PROJECT_Airline_Oracle_DB) {

				try {

					int length = 0;

					this.PassengerID = readString(dis);

					this.FirstName = readString(dis);

					this.LastName = readString(dis);

					this.Gender = readString(dis);

					this.Age = readInteger(dis);

					this.Nationality = readString(dis);

					this.AirportName = readString(dis);

					this.AirportCountryCode = readString(dis);

					this.CountryName = readString(dis);

					this.AIRPORTCONTINENT = readString(dis);

					this.CONTINENTS = readString(dis);

					this.DEPARTUREDATE = readString(dis);

					this.ARRIVALAIRPORT = readString(dis);

					this.PILOTNAME = readString(dis);

					this.FLIGHTSTATUS = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_AIRLINE_PROJECT_Airline_Oracle_DB) {

				try {

					int length = 0;

					this.PassengerID = readString(dis);

					this.FirstName = readString(dis);

					this.LastName = readString(dis);

					this.Gender = readString(dis);

					this.Age = readInteger(dis);

					this.Nationality = readString(dis);

					this.AirportName = readString(dis);

					this.AirportCountryCode = readString(dis);

					this.CountryName = readString(dis);

					this.AIRPORTCONTINENT = readString(dis);

					this.CONTINENTS = readString(dis);

					this.DEPARTUREDATE = readString(dis);

					this.ARRIVALAIRPORT = readString(dis);

					this.PILOTNAME = readString(dis);

					this.FLIGHTSTATUS = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.PassengerID, dos);

				// String

				writeString(this.FirstName, dos);

				// String

				writeString(this.LastName, dos);

				// String

				writeString(this.Gender, dos);

				// Integer

				writeInteger(this.Age, dos);

				// String

				writeString(this.Nationality, dos);

				// String

				writeString(this.AirportName, dos);

				// String

				writeString(this.AirportCountryCode, dos);

				// String

				writeString(this.CountryName, dos);

				// String

				writeString(this.AIRPORTCONTINENT, dos);

				// String

				writeString(this.CONTINENTS, dos);

				// String

				writeString(this.DEPARTUREDATE, dos);

				// String

				writeString(this.ARRIVALAIRPORT, dos);

				// String

				writeString(this.PILOTNAME, dos);

				// String

				writeString(this.FLIGHTSTATUS, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.PassengerID, dos);

				// String

				writeString(this.FirstName, dos);

				// String

				writeString(this.LastName, dos);

				// String

				writeString(this.Gender, dos);

				// Integer

				writeInteger(this.Age, dos);

				// String

				writeString(this.Nationality, dos);

				// String

				writeString(this.AirportName, dos);

				// String

				writeString(this.AirportCountryCode, dos);

				// String

				writeString(this.CountryName, dos);

				// String

				writeString(this.AIRPORTCONTINENT, dos);

				// String

				writeString(this.CONTINENTS, dos);

				// String

				writeString(this.DEPARTUREDATE, dos);

				// String

				writeString(this.ARRIVALAIRPORT, dos);

				// String

				writeString(this.PILOTNAME, dos);

				// String

				writeString(this.FLIGHTSTATUS, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("PassengerID=" + PassengerID);
			sb.append(",FirstName=" + FirstName);
			sb.append(",LastName=" + LastName);
			sb.append(",Gender=" + Gender);
			sb.append(",Age=" + String.valueOf(Age));
			sb.append(",Nationality=" + Nationality);
			sb.append(",AirportName=" + AirportName);
			sb.append(",AirportCountryCode=" + AirportCountryCode);
			sb.append(",CountryName=" + CountryName);
			sb.append(",AIRPORTCONTINENT=" + AIRPORTCONTINENT);
			sb.append(",CONTINENTS=" + CONTINENTS);
			sb.append(",DEPARTUREDATE=" + DEPARTUREDATE);
			sb.append(",ARRIVALAIRPORT=" + ARRIVALAIRPORT);
			sb.append(",PILOTNAME=" + PILOTNAME);
			sb.append(",FLIGHTSTATUS=" + FLIGHTSTATUS);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row1Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tFileInputDelimited_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row1Struct row1 = new row1Struct();
				out1Struct out1 = new out1Struct();
				row2Struct row2 = new row2Struct();

				/**
				 * [tFileOutputExcel_1 begin ] start
				 */

				ok_Hash.put("tFileOutputExcel_1", false);
				start_Hash.put("tFileOutputExcel_1", System.currentTimeMillis());

				currentComponent = "tFileOutputExcel_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row2");
				}

				int tos_count_tFileOutputExcel_1 = 0;

				int columnIndex_tFileOutputExcel_1 = 0;
				boolean headerIsInserted_tFileOutputExcel_1 = false;

				int nb_line_tFileOutputExcel_1 = 0;

				String fileName_tFileOutputExcel_1 = "C:/Users/hamza/Desktop/data_source_talend_project_Airline/reject_value/double.xls";
				java.io.File file_tFileOutputExcel_1 = new java.io.File(fileName_tFileOutputExcel_1);
				boolean isFileGenerated_tFileOutputExcel_1 = true;
//create directory only if not exists
				java.io.File parentFile_tFileOutputExcel_1 = file_tFileOutputExcel_1.getParentFile();
				if (parentFile_tFileOutputExcel_1 != null && !parentFile_tFileOutputExcel_1.exists()) {

					parentFile_tFileOutputExcel_1.mkdirs();

				}

				jxl.write.WritableWorkbook writeableWorkbook_tFileOutputExcel_1 = null;
				jxl.write.WritableSheet writableSheet_tFileOutputExcel_1 = null;

				jxl.WorkbookSettings workbookSettings_tFileOutputExcel_1 = new jxl.WorkbookSettings();
				workbookSettings_tFileOutputExcel_1.setEncoding("ISO-8859-15");
				writeableWorkbook_tFileOutputExcel_1 = new jxl.write.biff.WritableWorkbookImpl(
						new java.io.BufferedOutputStream(new java.io.FileOutputStream(fileName_tFileOutputExcel_1)),
						true, workbookSettings_tFileOutputExcel_1);

				writableSheet_tFileOutputExcel_1 = writeableWorkbook_tFileOutputExcel_1.getSheet("Sheet1");
				if (writableSheet_tFileOutputExcel_1 == null) {
					writableSheet_tFileOutputExcel_1 = writeableWorkbook_tFileOutputExcel_1.createSheet("Sheet1",
							writeableWorkbook_tFileOutputExcel_1.getNumberOfSheets());
				}

				// modif start
				int startRowNum_tFileOutputExcel_1 = writableSheet_tFileOutputExcel_1.getRows();
				// modif end

				int[] fitWidth_tFileOutputExcel_1 = new int[15];
				for (int i_tFileOutputExcel_1 = 0; i_tFileOutputExcel_1 < 15; i_tFileOutputExcel_1++) {
					int fitCellViewSize_tFileOutputExcel_1 = writableSheet_tFileOutputExcel_1
							.getColumnView(i_tFileOutputExcel_1).getSize();
					fitWidth_tFileOutputExcel_1[i_tFileOutputExcel_1] = fitCellViewSize_tFileOutputExcel_1 / 256;
					if (fitCellViewSize_tFileOutputExcel_1 % 256 != 0) {
						fitWidth_tFileOutputExcel_1[i_tFileOutputExcel_1] += 1;
					}
				}

				if (startRowNum_tFileOutputExcel_1 == 0) {
					// modif end
					// modif start
					writableSheet_tFileOutputExcel_1
							.addCell(new jxl.write.Label(0, nb_line_tFileOutputExcel_1, "PassengerID"));
					// modif end
					fitWidth_tFileOutputExcel_1[0] = fitWidth_tFileOutputExcel_1[0] > 11
							? fitWidth_tFileOutputExcel_1[0]
							: 11;
					// modif start
					writableSheet_tFileOutputExcel_1
							.addCell(new jxl.write.Label(1, nb_line_tFileOutputExcel_1, "FirstName"));
					// modif end
					fitWidth_tFileOutputExcel_1[1] = fitWidth_tFileOutputExcel_1[1] > 9 ? fitWidth_tFileOutputExcel_1[1]
							: 9;
					// modif start
					writableSheet_tFileOutputExcel_1
							.addCell(new jxl.write.Label(2, nb_line_tFileOutputExcel_1, "LastName"));
					// modif end
					fitWidth_tFileOutputExcel_1[2] = fitWidth_tFileOutputExcel_1[2] > 8 ? fitWidth_tFileOutputExcel_1[2]
							: 8;
					// modif start
					writableSheet_tFileOutputExcel_1
							.addCell(new jxl.write.Label(3, nb_line_tFileOutputExcel_1, "Gender"));
					// modif end
					fitWidth_tFileOutputExcel_1[3] = fitWidth_tFileOutputExcel_1[3] > 6 ? fitWidth_tFileOutputExcel_1[3]
							: 6;
					// modif start
					writableSheet_tFileOutputExcel_1.addCell(new jxl.write.Label(4, nb_line_tFileOutputExcel_1, "Age"));
					// modif end
					fitWidth_tFileOutputExcel_1[4] = fitWidth_tFileOutputExcel_1[4] > 3 ? fitWidth_tFileOutputExcel_1[4]
							: 3;
					// modif start
					writableSheet_tFileOutputExcel_1
							.addCell(new jxl.write.Label(5, nb_line_tFileOutputExcel_1, "Nationality"));
					// modif end
					fitWidth_tFileOutputExcel_1[5] = fitWidth_tFileOutputExcel_1[5] > 11
							? fitWidth_tFileOutputExcel_1[5]
							: 11;
					// modif start
					writableSheet_tFileOutputExcel_1
							.addCell(new jxl.write.Label(6, nb_line_tFileOutputExcel_1, "AirportName"));
					// modif end
					fitWidth_tFileOutputExcel_1[6] = fitWidth_tFileOutputExcel_1[6] > 11
							? fitWidth_tFileOutputExcel_1[6]
							: 11;
					// modif start
					writableSheet_tFileOutputExcel_1
							.addCell(new jxl.write.Label(7, nb_line_tFileOutputExcel_1, "AirportCountryCode"));
					// modif end
					fitWidth_tFileOutputExcel_1[7] = fitWidth_tFileOutputExcel_1[7] > 18
							? fitWidth_tFileOutputExcel_1[7]
							: 18;
					// modif start
					writableSheet_tFileOutputExcel_1
							.addCell(new jxl.write.Label(8, nb_line_tFileOutputExcel_1, "CountryName"));
					// modif end
					fitWidth_tFileOutputExcel_1[8] = fitWidth_tFileOutputExcel_1[8] > 11
							? fitWidth_tFileOutputExcel_1[8]
							: 11;
					// modif start
					writableSheet_tFileOutputExcel_1
							.addCell(new jxl.write.Label(9, nb_line_tFileOutputExcel_1, "AIRPORTCONTINENT"));
					// modif end
					fitWidth_tFileOutputExcel_1[9] = fitWidth_tFileOutputExcel_1[9] > 16
							? fitWidth_tFileOutputExcel_1[9]
							: 16;
					// modif start
					writableSheet_tFileOutputExcel_1
							.addCell(new jxl.write.Label(10, nb_line_tFileOutputExcel_1, "CONTINENTS"));
					// modif end
					fitWidth_tFileOutputExcel_1[10] = fitWidth_tFileOutputExcel_1[10] > 10
							? fitWidth_tFileOutputExcel_1[10]
							: 10;
					// modif start
					writableSheet_tFileOutputExcel_1
							.addCell(new jxl.write.Label(11, nb_line_tFileOutputExcel_1, "DEPARTUREDATE"));
					// modif end
					fitWidth_tFileOutputExcel_1[11] = fitWidth_tFileOutputExcel_1[11] > 13
							? fitWidth_tFileOutputExcel_1[11]
							: 13;
					// modif start
					writableSheet_tFileOutputExcel_1
							.addCell(new jxl.write.Label(12, nb_line_tFileOutputExcel_1, "ARRIVALAIRPORT"));
					// modif end
					fitWidth_tFileOutputExcel_1[12] = fitWidth_tFileOutputExcel_1[12] > 14
							? fitWidth_tFileOutputExcel_1[12]
							: 14;
					// modif start
					writableSheet_tFileOutputExcel_1
							.addCell(new jxl.write.Label(13, nb_line_tFileOutputExcel_1, "PILOTNAME"));
					// modif end
					fitWidth_tFileOutputExcel_1[13] = fitWidth_tFileOutputExcel_1[13] > 9
							? fitWidth_tFileOutputExcel_1[13]
							: 9;
					// modif start
					writableSheet_tFileOutputExcel_1
							.addCell(new jxl.write.Label(14, nb_line_tFileOutputExcel_1, "FLIGHTSTATUS"));
					// modif end
					fitWidth_tFileOutputExcel_1[14] = fitWidth_tFileOutputExcel_1[14] > 12
							? fitWidth_tFileOutputExcel_1[14]
							: 12;
					nb_line_tFileOutputExcel_1++;
					headerIsInserted_tFileOutputExcel_1 = true;
				}

				/**
				 * [tFileOutputExcel_1 begin ] stop
				 */

				/**
				 * [tUniqRow_1 begin ] start
				 */

				ok_Hash.put("tUniqRow_1", false);
				start_Hash.put("tUniqRow_1", System.currentTimeMillis());

				currentComponent = "tUniqRow_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "out1");
				}

				int tos_count_tUniqRow_1 = 0;

				class KeyStruct_tUniqRow_1 {

					private static final int DEFAULT_HASHCODE = 1;
					private static final int PRIME = 31;
					private int hashCode = DEFAULT_HASHCODE;
					public boolean hashCodeDirty = true;

					String PassengerID;

					@Override
					public int hashCode() {
						if (this.hashCodeDirty) {
							final int prime = PRIME;
							int result = DEFAULT_HASHCODE;

							result = prime * result + ((this.PassengerID == null) ? 0 : this.PassengerID.hashCode());

							this.hashCode = result;
							this.hashCodeDirty = false;
						}
						return this.hashCode;
					}

					@Override
					public boolean equals(Object obj) {
						if (this == obj)
							return true;
						if (obj == null)
							return false;
						if (getClass() != obj.getClass())
							return false;
						final KeyStruct_tUniqRow_1 other = (KeyStruct_tUniqRow_1) obj;

						if (this.PassengerID == null) {
							if (other.PassengerID != null)
								return false;

						} else if (!this.PassengerID.equals(other.PassengerID))

							return false;

						return true;
					}

				}

				int nb_uniques_tUniqRow_1 = 0;
				int nb_duplicates_tUniqRow_1 = 0;
				KeyStruct_tUniqRow_1 finder_tUniqRow_1 = new KeyStruct_tUniqRow_1();
				java.util.Set<KeyStruct_tUniqRow_1> keystUniqRow_1 = new java.util.HashSet<KeyStruct_tUniqRow_1>();

				/**
				 * [tUniqRow_1 begin ] stop
				 */

				/**
				 * [tMap_1 begin ] start
				 */

				ok_Hash.put("tMap_1", false);
				start_Hash.put("tMap_1", System.currentTimeMillis());

				currentComponent = "tMap_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row1");
				}

				int tos_count_tMap_1 = 0;

// ###############################
// # Lookup's keys initialization
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_1__Struct {
					String var1;
				}
				Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
				out1Struct out1_tmp = new out1Struct();
// ###############################

				/**
				 * [tMap_1 begin ] stop
				 */

				/**
				 * [tFileInputDelimited_1 begin ] start
				 */

				ok_Hash.put("tFileInputDelimited_1", false);
				start_Hash.put("tFileInputDelimited_1", System.currentTimeMillis());

				currentComponent = "tFileInputDelimited_1";

				int tos_count_tFileInputDelimited_1 = 0;

				final routines.system.RowState rowstate_tFileInputDelimited_1 = new routines.system.RowState();

				int nb_line_tFileInputDelimited_1 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_1 = null;
				int limit_tFileInputDelimited_1 = -1;
				try {

					Object filename_tFileInputDelimited_1 = "C:/Users/hamza/Desktop/data_source_talend_project_Airline/archive/Airline Dataset Updated - v2.csv";
					if (filename_tFileInputDelimited_1 instanceof java.io.InputStream) {

						int footer_value_tFileInputDelimited_1 = 0, random_value_tFileInputDelimited_1 = -1;
						if (footer_value_tFileInputDelimited_1 > 0 || random_value_tFileInputDelimited_1 > 0) {
							throw new java.lang.Exception(
									"When the input source is a stream,footer and random shouldn't be bigger than 0.");
						}

					}
					try {
						fid_tFileInputDelimited_1 = new org.talend.fileprocess.FileInputDelimited(
								"C:/Users/hamza/Desktop/data_source_talend_project_Airline/archive/Airline Dataset Updated - v2.csv",
								"ISO-8859-15", ",", "\n", true, 0, 0, limit_tFileInputDelimited_1, -1, false);
					} catch (java.lang.Exception e) {
						globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE", e.getMessage());

						System.err.println(e.getMessage());

					}

					while (fid_tFileInputDelimited_1 != null && fid_tFileInputDelimited_1.nextRecord()) {
						rowstate_tFileInputDelimited_1.reset();

						row1 = null;

						boolean whetherReject_tFileInputDelimited_1 = false;
						row1 = new row1Struct();
						try {

							int columnIndexWithD_tFileInputDelimited_1 = 0;

							String temp = "";

							columnIndexWithD_tFileInputDelimited_1 = 0;

							row1.PassengerID = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 1;

							row1.FirstName = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 2;

							row1.LastName = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 3;

							row1.Gender = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 4;

							temp = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
							if (temp.length() > 0) {

								try {

									row1.Age = ParserUtils.parseTo_Integer(temp);

								} catch (java.lang.Exception ex_tFileInputDelimited_1) {
									globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE",
											ex_tFileInputDelimited_1.getMessage());
									rowstate_tFileInputDelimited_1.setException(new RuntimeException(String.format(
											"Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
											"Age", "row1", temp, ex_tFileInputDelimited_1), ex_tFileInputDelimited_1));
								}

							} else {

								row1.Age = null;

							}

							columnIndexWithD_tFileInputDelimited_1 = 5;

							row1.Nationality = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 6;

							row1.AirportName = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 7;

							row1.AirportCountryCode = fid_tFileInputDelimited_1
									.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 8;

							row1.CountryName = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 9;

							row1.AIRPORTCONTINENT = fid_tFileInputDelimited_1
									.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 10;

							row1.CONTINENTS = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 11;

							row1.DEPARTUREDATE = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 12;

							row1.ARRIVALAIRPORT = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 13;

							row1.PILOTNAME = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 14;

							row1.FLIGHTSTATUS = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);

							if (rowstate_tFileInputDelimited_1.getException() != null) {
								throw rowstate_tFileInputDelimited_1.getException();
							}

						} catch (java.lang.Exception e) {
							globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE", e.getMessage());
							whetherReject_tFileInputDelimited_1 = true;

							System.err.println(e.getMessage());
							row1 = null;

						}

						/**
						 * [tFileInputDelimited_1 begin ] stop
						 */

						/**
						 * [tFileInputDelimited_1 main ] start
						 */

						currentComponent = "tFileInputDelimited_1";

						tos_count_tFileInputDelimited_1++;

						/**
						 * [tFileInputDelimited_1 main ] stop
						 */

						/**
						 * [tFileInputDelimited_1 process_data_begin ] start
						 */

						currentComponent = "tFileInputDelimited_1";

						/**
						 * [tFileInputDelimited_1 process_data_begin ] stop
						 */
// Start of branch "row1"
						if (row1 != null) {

							/**
							 * [tMap_1 main ] start
							 */

							currentComponent = "tMap_1";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "row1"

								);
							}

							boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;

							// ###############################
							// # Input tables (lookups)
							boolean rejectedInnerJoin_tMap_1 = false;
							boolean mainRowRejected_tMap_1 = false;

							// ###############################
							{ // start of Var scope

								// ###############################
								// # Vars tables

								Var__tMap_1__Struct Var = Var__tMap_1;
								Var.var1 = row1.DEPARTUREDATE
										.matches("\\d{2}-\\d{2}-\\d{4}")
												? row1.DEPARTUREDATE
												: (row1.DEPARTUREDATE.matches("\\d{2}/\\d{2}/\\d{4}")
														? TalendDate.formatDate("dd-MM-yyyy",
																TalendDate.parseDate("dd/MM/yyyy", row1.DEPARTUREDATE))
														: "");
								;// ###############################
									// ###############################
									// # Output tables

								out1 = null;

// # Output table : 'out1'
								out1_tmp.PassengerID = row1.PassengerID;
								out1_tmp.FirstName = row1.FirstName;
								out1_tmp.LastName = row1.LastName;
								out1_tmp.Gender = row1.Gender;
								out1_tmp.Age = row1.Age;
								out1_tmp.Nationality = row1.Nationality;
								out1_tmp.AirportName = row1.AirportName;
								out1_tmp.AirportCountryCode = row1.AirportCountryCode;
								out1_tmp.CountryName = row1.CountryName;
								out1_tmp.AIRPORTCONTINENT = row1.AIRPORTCONTINENT;
								out1_tmp.CONTINENTS = row1.CONTINENTS;
								out1_tmp.DEPARTUREDATE = Var.var1;
								out1_tmp.ARRIVALAIRPORT = row1.ARRIVALAIRPORT;
								out1_tmp.PILOTNAME = row1.PILOTNAME;
								out1_tmp.FLIGHTSTATUS = row1.FLIGHTSTATUS;
								out1 = out1_tmp;
// ###############################

							} // end of Var scope

							rejectedInnerJoin_tMap_1 = false;

							tos_count_tMap_1++;

							/**
							 * [tMap_1 main ] stop
							 */

							/**
							 * [tMap_1 process_data_begin ] start
							 */

							currentComponent = "tMap_1";

							/**
							 * [tMap_1 process_data_begin ] stop
							 */
// Start of branch "out1"
							if (out1 != null) {

								/**
								 * [tUniqRow_1 main ] start
								 */

								currentComponent = "tUniqRow_1";

								if (execStat) {
									runStat.updateStatOnConnection(iterateId, 1, 1

											, "out1"

									);
								}

								row2 = null;
								if (out1.PassengerID == null) {
									finder_tUniqRow_1.PassengerID = null;
								} else {
									finder_tUniqRow_1.PassengerID = out1.PassengerID.toLowerCase();
								}
								finder_tUniqRow_1.hashCodeDirty = true;
								if (!keystUniqRow_1.contains(finder_tUniqRow_1)) {
									KeyStruct_tUniqRow_1 new_tUniqRow_1 = new KeyStruct_tUniqRow_1();

									if (out1.PassengerID == null) {
										new_tUniqRow_1.PassengerID = null;
									} else {
										new_tUniqRow_1.PassengerID = out1.PassengerID.toLowerCase();
									}

									keystUniqRow_1.add(new_tUniqRow_1);
									nb_uniques_tUniqRow_1++;
								} else {
									if (row2 == null) {

										row2 = new row2Struct();
									}
									row2.PassengerID = out1.PassengerID;
									row2.FirstName = out1.FirstName;
									row2.LastName = out1.LastName;
									row2.Gender = out1.Gender;
									row2.Age = out1.Age;
									row2.Nationality = out1.Nationality;
									row2.AirportName = out1.AirportName;
									row2.AirportCountryCode = out1.AirportCountryCode;
									row2.CountryName = out1.CountryName;
									row2.AIRPORTCONTINENT = out1.AIRPORTCONTINENT;
									row2.CONTINENTS = out1.CONTINENTS;
									row2.DEPARTUREDATE = out1.DEPARTUREDATE;
									row2.ARRIVALAIRPORT = out1.ARRIVALAIRPORT;
									row2.PILOTNAME = out1.PILOTNAME;
									row2.FLIGHTSTATUS = out1.FLIGHTSTATUS;
									nb_duplicates_tUniqRow_1++;
								}

								tos_count_tUniqRow_1++;

								/**
								 * [tUniqRow_1 main ] stop
								 */

								/**
								 * [tUniqRow_1 process_data_begin ] start
								 */

								currentComponent = "tUniqRow_1";

								/**
								 * [tUniqRow_1 process_data_begin ] stop
								 */
// Start of branch "row2"
								if (row2 != null) {

									/**
									 * [tFileOutputExcel_1 main ] start
									 */

									currentComponent = "tFileOutputExcel_1";

									if (execStat) {
										runStat.updateStatOnConnection(iterateId, 1, 1

												, "row2"

										);
									}

									if (row2.PassengerID != null) {

//modif start

										columnIndex_tFileOutputExcel_1 = 0;

										jxl.write.WritableCell cell_0_tFileOutputExcel_1 = new jxl.write.Label(
												columnIndex_tFileOutputExcel_1,
												startRowNum_tFileOutputExcel_1 + nb_line_tFileOutputExcel_1,

//modif end
												row2.PassengerID);
//modif start					
										// If we keep the cell format from the existing cell in sheet

//modif ends							
										writableSheet_tFileOutputExcel_1.addCell(cell_0_tFileOutputExcel_1);
										int currentWith_0_tFileOutputExcel_1 = cell_0_tFileOutputExcel_1.getContents()
												.trim().length();
										fitWidth_tFileOutputExcel_1[0] = fitWidth_tFileOutputExcel_1[0] > currentWith_0_tFileOutputExcel_1
												? fitWidth_tFileOutputExcel_1[0]
												: currentWith_0_tFileOutputExcel_1 + 2;
									}

									if (row2.FirstName != null) {

//modif start

										columnIndex_tFileOutputExcel_1 = 1;

										jxl.write.WritableCell cell_1_tFileOutputExcel_1 = new jxl.write.Label(
												columnIndex_tFileOutputExcel_1,
												startRowNum_tFileOutputExcel_1 + nb_line_tFileOutputExcel_1,

//modif end
												row2.FirstName);
//modif start					
										// If we keep the cell format from the existing cell in sheet

//modif ends							
										writableSheet_tFileOutputExcel_1.addCell(cell_1_tFileOutputExcel_1);
										int currentWith_1_tFileOutputExcel_1 = cell_1_tFileOutputExcel_1.getContents()
												.trim().length();
										fitWidth_tFileOutputExcel_1[1] = fitWidth_tFileOutputExcel_1[1] > currentWith_1_tFileOutputExcel_1
												? fitWidth_tFileOutputExcel_1[1]
												: currentWith_1_tFileOutputExcel_1 + 2;
									}

									if (row2.LastName != null) {

//modif start

										columnIndex_tFileOutputExcel_1 = 2;

										jxl.write.WritableCell cell_2_tFileOutputExcel_1 = new jxl.write.Label(
												columnIndex_tFileOutputExcel_1,
												startRowNum_tFileOutputExcel_1 + nb_line_tFileOutputExcel_1,

//modif end
												row2.LastName);
//modif start					
										// If we keep the cell format from the existing cell in sheet

//modif ends							
										writableSheet_tFileOutputExcel_1.addCell(cell_2_tFileOutputExcel_1);
										int currentWith_2_tFileOutputExcel_1 = cell_2_tFileOutputExcel_1.getContents()
												.trim().length();
										fitWidth_tFileOutputExcel_1[2] = fitWidth_tFileOutputExcel_1[2] > currentWith_2_tFileOutputExcel_1
												? fitWidth_tFileOutputExcel_1[2]
												: currentWith_2_tFileOutputExcel_1 + 2;
									}

									if (row2.Gender != null) {

//modif start

										columnIndex_tFileOutputExcel_1 = 3;

										jxl.write.WritableCell cell_3_tFileOutputExcel_1 = new jxl.write.Label(
												columnIndex_tFileOutputExcel_1,
												startRowNum_tFileOutputExcel_1 + nb_line_tFileOutputExcel_1,

//modif end
												row2.Gender);
//modif start					
										// If we keep the cell format from the existing cell in sheet

//modif ends							
										writableSheet_tFileOutputExcel_1.addCell(cell_3_tFileOutputExcel_1);
										int currentWith_3_tFileOutputExcel_1 = cell_3_tFileOutputExcel_1.getContents()
												.trim().length();
										fitWidth_tFileOutputExcel_1[3] = fitWidth_tFileOutputExcel_1[3] > currentWith_3_tFileOutputExcel_1
												? fitWidth_tFileOutputExcel_1[3]
												: currentWith_3_tFileOutputExcel_1 + 2;
									}

									if (row2.Age != null) {

//modif start

										columnIndex_tFileOutputExcel_1 = 4;

										jxl.write.WritableCell cell_4_tFileOutputExcel_1 = new jxl.write.Number(
												columnIndex_tFileOutputExcel_1,
												startRowNum_tFileOutputExcel_1 + nb_line_tFileOutputExcel_1,

//modif end
												row2.Age);
//modif start					
										// If we keep the cell format from the existing cell in sheet

//modif ends							
										writableSheet_tFileOutputExcel_1.addCell(cell_4_tFileOutputExcel_1);
										int currentWith_4_tFileOutputExcel_1 = String
												.valueOf(((jxl.write.Number) cell_4_tFileOutputExcel_1).getValue())
												.trim().length();
										currentWith_4_tFileOutputExcel_1 = currentWith_4_tFileOutputExcel_1 > 10 ? 10
												: currentWith_4_tFileOutputExcel_1;
										fitWidth_tFileOutputExcel_1[4] = fitWidth_tFileOutputExcel_1[4] > currentWith_4_tFileOutputExcel_1
												? fitWidth_tFileOutputExcel_1[4]
												: currentWith_4_tFileOutputExcel_1 + 2;
									}

									if (row2.Nationality != null) {

//modif start

										columnIndex_tFileOutputExcel_1 = 5;

										jxl.write.WritableCell cell_5_tFileOutputExcel_1 = new jxl.write.Label(
												columnIndex_tFileOutputExcel_1,
												startRowNum_tFileOutputExcel_1 + nb_line_tFileOutputExcel_1,

//modif end
												row2.Nationality);
//modif start					
										// If we keep the cell format from the existing cell in sheet

//modif ends							
										writableSheet_tFileOutputExcel_1.addCell(cell_5_tFileOutputExcel_1);
										int currentWith_5_tFileOutputExcel_1 = cell_5_tFileOutputExcel_1.getContents()
												.trim().length();
										fitWidth_tFileOutputExcel_1[5] = fitWidth_tFileOutputExcel_1[5] > currentWith_5_tFileOutputExcel_1
												? fitWidth_tFileOutputExcel_1[5]
												: currentWith_5_tFileOutputExcel_1 + 2;
									}

									if (row2.AirportName != null) {

//modif start

										columnIndex_tFileOutputExcel_1 = 6;

										jxl.write.WritableCell cell_6_tFileOutputExcel_1 = new jxl.write.Label(
												columnIndex_tFileOutputExcel_1,
												startRowNum_tFileOutputExcel_1 + nb_line_tFileOutputExcel_1,

//modif end
												row2.AirportName);
//modif start					
										// If we keep the cell format from the existing cell in sheet

//modif ends							
										writableSheet_tFileOutputExcel_1.addCell(cell_6_tFileOutputExcel_1);
										int currentWith_6_tFileOutputExcel_1 = cell_6_tFileOutputExcel_1.getContents()
												.trim().length();
										fitWidth_tFileOutputExcel_1[6] = fitWidth_tFileOutputExcel_1[6] > currentWith_6_tFileOutputExcel_1
												? fitWidth_tFileOutputExcel_1[6]
												: currentWith_6_tFileOutputExcel_1 + 2;
									}

									if (row2.AirportCountryCode != null) {

//modif start

										columnIndex_tFileOutputExcel_1 = 7;

										jxl.write.WritableCell cell_7_tFileOutputExcel_1 = new jxl.write.Label(
												columnIndex_tFileOutputExcel_1,
												startRowNum_tFileOutputExcel_1 + nb_line_tFileOutputExcel_1,

//modif end
												row2.AirportCountryCode);
//modif start					
										// If we keep the cell format from the existing cell in sheet

//modif ends							
										writableSheet_tFileOutputExcel_1.addCell(cell_7_tFileOutputExcel_1);
										int currentWith_7_tFileOutputExcel_1 = cell_7_tFileOutputExcel_1.getContents()
												.trim().length();
										fitWidth_tFileOutputExcel_1[7] = fitWidth_tFileOutputExcel_1[7] > currentWith_7_tFileOutputExcel_1
												? fitWidth_tFileOutputExcel_1[7]
												: currentWith_7_tFileOutputExcel_1 + 2;
									}

									if (row2.CountryName != null) {

//modif start

										columnIndex_tFileOutputExcel_1 = 8;

										jxl.write.WritableCell cell_8_tFileOutputExcel_1 = new jxl.write.Label(
												columnIndex_tFileOutputExcel_1,
												startRowNum_tFileOutputExcel_1 + nb_line_tFileOutputExcel_1,

//modif end
												row2.CountryName);
//modif start					
										// If we keep the cell format from the existing cell in sheet

//modif ends							
										writableSheet_tFileOutputExcel_1.addCell(cell_8_tFileOutputExcel_1);
										int currentWith_8_tFileOutputExcel_1 = cell_8_tFileOutputExcel_1.getContents()
												.trim().length();
										fitWidth_tFileOutputExcel_1[8] = fitWidth_tFileOutputExcel_1[8] > currentWith_8_tFileOutputExcel_1
												? fitWidth_tFileOutputExcel_1[8]
												: currentWith_8_tFileOutputExcel_1 + 2;
									}

									if (row2.AIRPORTCONTINENT != null) {

//modif start

										columnIndex_tFileOutputExcel_1 = 9;

										jxl.write.WritableCell cell_9_tFileOutputExcel_1 = new jxl.write.Label(
												columnIndex_tFileOutputExcel_1,
												startRowNum_tFileOutputExcel_1 + nb_line_tFileOutputExcel_1,

//modif end
												row2.AIRPORTCONTINENT);
//modif start					
										// If we keep the cell format from the existing cell in sheet

//modif ends							
										writableSheet_tFileOutputExcel_1.addCell(cell_9_tFileOutputExcel_1);
										int currentWith_9_tFileOutputExcel_1 = cell_9_tFileOutputExcel_1.getContents()
												.trim().length();
										fitWidth_tFileOutputExcel_1[9] = fitWidth_tFileOutputExcel_1[9] > currentWith_9_tFileOutputExcel_1
												? fitWidth_tFileOutputExcel_1[9]
												: currentWith_9_tFileOutputExcel_1 + 2;
									}

									if (row2.CONTINENTS != null) {

//modif start

										columnIndex_tFileOutputExcel_1 = 10;

										jxl.write.WritableCell cell_10_tFileOutputExcel_1 = new jxl.write.Label(
												columnIndex_tFileOutputExcel_1,
												startRowNum_tFileOutputExcel_1 + nb_line_tFileOutputExcel_1,

//modif end
												row2.CONTINENTS);
//modif start					
										// If we keep the cell format from the existing cell in sheet

//modif ends							
										writableSheet_tFileOutputExcel_1.addCell(cell_10_tFileOutputExcel_1);
										int currentWith_10_tFileOutputExcel_1 = cell_10_tFileOutputExcel_1.getContents()
												.trim().length();
										fitWidth_tFileOutputExcel_1[10] = fitWidth_tFileOutputExcel_1[10] > currentWith_10_tFileOutputExcel_1
												? fitWidth_tFileOutputExcel_1[10]
												: currentWith_10_tFileOutputExcel_1 + 2;
									}

									if (row2.DEPARTUREDATE != null) {

//modif start

										columnIndex_tFileOutputExcel_1 = 11;

										jxl.write.WritableCell cell_11_tFileOutputExcel_1 = new jxl.write.Label(
												columnIndex_tFileOutputExcel_1,
												startRowNum_tFileOutputExcel_1 + nb_line_tFileOutputExcel_1,

//modif end
												row2.DEPARTUREDATE);
//modif start					
										// If we keep the cell format from the existing cell in sheet

//modif ends							
										writableSheet_tFileOutputExcel_1.addCell(cell_11_tFileOutputExcel_1);
										int currentWith_11_tFileOutputExcel_1 = cell_11_tFileOutputExcel_1.getContents()
												.trim().length();
										fitWidth_tFileOutputExcel_1[11] = fitWidth_tFileOutputExcel_1[11] > currentWith_11_tFileOutputExcel_1
												? fitWidth_tFileOutputExcel_1[11]
												: currentWith_11_tFileOutputExcel_1 + 2;
									}

									if (row2.ARRIVALAIRPORT != null) {

//modif start

										columnIndex_tFileOutputExcel_1 = 12;

										jxl.write.WritableCell cell_12_tFileOutputExcel_1 = new jxl.write.Label(
												columnIndex_tFileOutputExcel_1,
												startRowNum_tFileOutputExcel_1 + nb_line_tFileOutputExcel_1,

//modif end
												row2.ARRIVALAIRPORT);
//modif start					
										// If we keep the cell format from the existing cell in sheet

//modif ends							
										writableSheet_tFileOutputExcel_1.addCell(cell_12_tFileOutputExcel_1);
										int currentWith_12_tFileOutputExcel_1 = cell_12_tFileOutputExcel_1.getContents()
												.trim().length();
										fitWidth_tFileOutputExcel_1[12] = fitWidth_tFileOutputExcel_1[12] > currentWith_12_tFileOutputExcel_1
												? fitWidth_tFileOutputExcel_1[12]
												: currentWith_12_tFileOutputExcel_1 + 2;
									}

									if (row2.PILOTNAME != null) {

//modif start

										columnIndex_tFileOutputExcel_1 = 13;

										jxl.write.WritableCell cell_13_tFileOutputExcel_1 = new jxl.write.Label(
												columnIndex_tFileOutputExcel_1,
												startRowNum_tFileOutputExcel_1 + nb_line_tFileOutputExcel_1,

//modif end
												row2.PILOTNAME);
//modif start					
										// If we keep the cell format from the existing cell in sheet

//modif ends							
										writableSheet_tFileOutputExcel_1.addCell(cell_13_tFileOutputExcel_1);
										int currentWith_13_tFileOutputExcel_1 = cell_13_tFileOutputExcel_1.getContents()
												.trim().length();
										fitWidth_tFileOutputExcel_1[13] = fitWidth_tFileOutputExcel_1[13] > currentWith_13_tFileOutputExcel_1
												? fitWidth_tFileOutputExcel_1[13]
												: currentWith_13_tFileOutputExcel_1 + 2;
									}

									if (row2.FLIGHTSTATUS != null) {

//modif start

										columnIndex_tFileOutputExcel_1 = 14;

										jxl.write.WritableCell cell_14_tFileOutputExcel_1 = new jxl.write.Label(
												columnIndex_tFileOutputExcel_1,
												startRowNum_tFileOutputExcel_1 + nb_line_tFileOutputExcel_1,

//modif end
												row2.FLIGHTSTATUS);
//modif start					
										// If we keep the cell format from the existing cell in sheet

//modif ends							
										writableSheet_tFileOutputExcel_1.addCell(cell_14_tFileOutputExcel_1);
										int currentWith_14_tFileOutputExcel_1 = cell_14_tFileOutputExcel_1.getContents()
												.trim().length();
										fitWidth_tFileOutputExcel_1[14] = fitWidth_tFileOutputExcel_1[14] > currentWith_14_tFileOutputExcel_1
												? fitWidth_tFileOutputExcel_1[14]
												: currentWith_14_tFileOutputExcel_1 + 2;
									}

									nb_line_tFileOutputExcel_1++;

									tos_count_tFileOutputExcel_1++;

									/**
									 * [tFileOutputExcel_1 main ] stop
									 */

									/**
									 * [tFileOutputExcel_1 process_data_begin ] start
									 */

									currentComponent = "tFileOutputExcel_1";

									/**
									 * [tFileOutputExcel_1 process_data_begin ] stop
									 */

									/**
									 * [tFileOutputExcel_1 process_data_end ] start
									 */

									currentComponent = "tFileOutputExcel_1";

									/**
									 * [tFileOutputExcel_1 process_data_end ] stop
									 */

								} // End of branch "row2"

								/**
								 * [tUniqRow_1 process_data_end ] start
								 */

								currentComponent = "tUniqRow_1";

								/**
								 * [tUniqRow_1 process_data_end ] stop
								 */

							} // End of branch "out1"

							/**
							 * [tMap_1 process_data_end ] start
							 */

							currentComponent = "tMap_1";

							/**
							 * [tMap_1 process_data_end ] stop
							 */

						} // End of branch "row1"

						/**
						 * [tFileInputDelimited_1 process_data_end ] start
						 */

						currentComponent = "tFileInputDelimited_1";

						/**
						 * [tFileInputDelimited_1 process_data_end ] stop
						 */

						/**
						 * [tFileInputDelimited_1 end ] start
						 */

						currentComponent = "tFileInputDelimited_1";

					}
				} finally {
					if (!((Object) ("C:/Users/hamza/Desktop/data_source_talend_project_Airline/archive/Airline Dataset Updated - v2.csv") instanceof java.io.InputStream)) {
						if (fid_tFileInputDelimited_1 != null) {
							fid_tFileInputDelimited_1.close();
						}
					}
					if (fid_tFileInputDelimited_1 != null) {
						globalMap.put("tFileInputDelimited_1_NB_LINE", fid_tFileInputDelimited_1.getRowNumber());

					}
				}

				ok_Hash.put("tFileInputDelimited_1", true);
				end_Hash.put("tFileInputDelimited_1", System.currentTimeMillis());

				/**
				 * [tFileInputDelimited_1 end ] stop
				 */

				/**
				 * [tMap_1 end ] start
				 */

				currentComponent = "tMap_1";

// ###############################
// # Lookup hashes releasing
// ###############################      

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row1");
				}

				ok_Hash.put("tMap_1", true);
				end_Hash.put("tMap_1", System.currentTimeMillis());

				/**
				 * [tMap_1 end ] stop
				 */

				/**
				 * [tUniqRow_1 end ] start
				 */

				currentComponent = "tUniqRow_1";

				globalMap.put("tUniqRow_1_NB_UNIQUES", nb_uniques_tUniqRow_1);
				globalMap.put("tUniqRow_1_NB_DUPLICATES", nb_duplicates_tUniqRow_1);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "out1");
				}

				ok_Hash.put("tUniqRow_1", true);
				end_Hash.put("tUniqRow_1", System.currentTimeMillis());

				/**
				 * [tUniqRow_1 end ] stop
				 */

				/**
				 * [tFileOutputExcel_1 end ] start
				 */

				currentComponent = "tFileOutputExcel_1";

				writeableWorkbook_tFileOutputExcel_1.write();
				writeableWorkbook_tFileOutputExcel_1.close();
				if (headerIsInserted_tFileOutputExcel_1 && nb_line_tFileOutputExcel_1 > 0) {
					nb_line_tFileOutputExcel_1 = nb_line_tFileOutputExcel_1 - 1;
				}
				globalMap.put("tFileOutputExcel_1_NB_LINE", nb_line_tFileOutputExcel_1);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row2");
				}

				ok_Hash.put("tFileOutputExcel_1", true);
				end_Hash.put("tFileOutputExcel_1", System.currentTimeMillis());

				/**
				 * [tFileOutputExcel_1 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tFileInputDelimited_1 finally ] start
				 */

				currentComponent = "tFileInputDelimited_1";

				/**
				 * [tFileInputDelimited_1 finally ] stop
				 */

				/**
				 * [tMap_1 finally ] start
				 */

				currentComponent = "tMap_1";

				/**
				 * [tMap_1 finally ] stop
				 */

				/**
				 * [tUniqRow_1 finally ] start
				 */

				currentComponent = "tUniqRow_1";

				/**
				 * [tUniqRow_1 finally ] stop
				 */

				/**
				 * [tFileOutputExcel_1 finally ] start
				 */

				currentComponent = "tFileOutputExcel_1";

				/**
				 * [tFileOutputExcel_1 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", 1);
	}

	public String resuming_logs_dir_path = null;
	public String resuming_checkpoint_path = null;
	public String parent_part_launcher = null;
	private String resumeEntryMethodName = null;
	private boolean globalResumeTicket = false;

	public boolean watch = false;
	// portStats is null, it means don't execute the statistics
	public Integer portStats = null;
	public int portTraces = 4334;
	public String clientHost;
	public String defaultClientHost = "localhost";
	public String contextStr = "Default";
	public boolean isDefaultContext = true;
	public String pid = "0";
	public String rootPid = null;
	public String fatherPid = null;
	public String fatherNode = null;
	public long startTime = 0;
	public boolean isChildJob = false;
	public String log4jLevel = "";

	private boolean enableLogStash;

	private boolean execStat = true;

	private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
		protected java.util.Map<String, String> initialValue() {
			java.util.Map<String, String> threadRunResultMap = new java.util.HashMap<String, String>();
			threadRunResultMap.put("errorCode", null);
			threadRunResultMap.put("status", "");
			return threadRunResultMap;
		};
	};

	protected PropertiesWithType context_param = new PropertiesWithType();
	public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

	public String status = "";

	public static void main(String[] args) {
		final Airline_Oracle_DB Airline_Oracle_DBClass = new Airline_Oracle_DB();

		int exitCode = Airline_Oracle_DBClass.runJobInTOS(args);

		System.exit(exitCode);
	}

	public String[][] runJob(String[] args) {

		int exitCode = runJobInTOS(args);
		String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

		return bufferValue;
	}

	public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;

		return hastBufferOutput;
	}

	public int runJobInTOS(String[] args) {
		// reset status
		status = "";

		String lastStr = "";
		for (String arg : args) {
			if (arg.equalsIgnoreCase("--context_param")) {
				lastStr = arg;
			} else if (lastStr.equals("")) {
				evalParam(arg);
			} else {
				evalParam(lastStr + " " + arg);
				lastStr = "";
			}
		}
		enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

		if (clientHost == null) {
			clientHost = defaultClientHost;
		}

		if (pid == null || "0".equals(pid)) {
			pid = TalendString.getAsciiRandomString(6);
		}

		if (rootPid == null) {
			rootPid = pid;
		}
		if (fatherPid == null) {
			fatherPid = pid;
		} else {
			isChildJob = true;
		}

		if (portStats != null) {
			// portStats = -1; //for testing
			if (portStats < 0 || portStats > 65535) {
				// issue:10869, the portStats is invalid, so this client socket can't open
				System.err.println("The statistics socket port " + portStats + " is invalid.");
				execStat = false;
			}
		} else {
			execStat = false;
		}
		boolean inOSGi = routines.system.BundleUtils.inOSGi();

		if (inOSGi) {
			java.util.Dictionary<String, Object> jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

			if (jobProperties != null && jobProperties.get("context") != null) {
				contextStr = (String) jobProperties.get("context");
			}
		}

		try {
			// call job/subjob with an existing context, like: --context=production. if
			// without this parameter, there will use the default context instead.
			java.io.InputStream inContext = Airline_Oracle_DB.class.getClassLoader().getResourceAsStream(
					"airline_project/airline_oracle_db_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = Airline_Oracle_DB.class.getClassLoader()
						.getResourceAsStream("config/contexts/" + contextStr + ".properties");
			}
			if (inContext != null) {
				try {
					// defaultProps is in order to keep the original context value
					if (context != null && context.isEmpty()) {
						defaultProps.load(inContext);
						context = new ContextProperties(defaultProps);
					}
				} finally {
					inContext.close();
				}
			} else if (!isDefaultContext) {
				// print info and job continue to run, for case: context_param is not empty.
				System.err.println("Could not find the context " + contextStr);
			}

			if (!context_param.isEmpty()) {
				context.putAll(context_param);
				// set types for params from parentJobs
				for (Object key : context_param.keySet()) {
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
			}
			class ContextProcessing {
				private void processContext_0() {
				}

				public void processAllContext() {
					processContext_0();
				}
			}

			new ContextProcessing().processAllContext();
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "",
				"", "", "", "", resumeUtil.convertToJsonText(context, parametersToEncrypt));

		if (execStat) {
			try {
				runStat.openSocket(!isChildJob);
				runStat.setAllPID(rootPid, fatherPid, pid, jobName);
				runStat.startThreadStat(clientHost, portStats);
				runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
			} catch (java.io.IOException ioException) {
				ioException.printStackTrace();
			}
		}

		java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
		globalMap.put("concurrentHashMap", concurrentHashMap);

		long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long endUsedMemory = 0;
		long end = 0;

		startTime = System.currentTimeMillis();

		this.globalResumeTicket = true;// to run tPreJob

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tFileInputDelimited_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tFileInputDelimited_1) {
			globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", -1);

			e_tFileInputDelimited_1.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println(
					(endUsedMemory - startUsedMemory) + " bytes memory increase when running : Airline_Oracle_DB");
		}

		if (execStat) {
			runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
			runStat.stopThreadStat();
		}
		int returnCode = 0;

		if (errorCode == null) {
			returnCode = status != null && status.equals("failure") ? 1 : 0;
		} else {
			returnCode = errorCode.intValue();
		}
		resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "",
				"" + returnCode, "", "", "");

		return returnCode;

	}

	// only for OSGi env
	public void destroy() {

	}

	private java.util.Map<String, Object> getSharedConnections4REST() {
		java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();

		return connections;
	}

	private void evalParam(String arg) {
		if (arg.startsWith("--resuming_logs_dir_path")) {
			resuming_logs_dir_path = arg.substring(25);
		} else if (arg.startsWith("--resuming_checkpoint_path")) {
			resuming_checkpoint_path = arg.substring(27);
		} else if (arg.startsWith("--parent_part_launcher")) {
			parent_part_launcher = arg.substring(23);
		} else if (arg.startsWith("--watch")) {
			watch = true;
		} else if (arg.startsWith("--stat_port=")) {
			String portStatsStr = arg.substring(12);
			if (portStatsStr != null && !portStatsStr.equals("null")) {
				portStats = Integer.parseInt(portStatsStr);
			}
		} else if (arg.startsWith("--trace_port=")) {
			portTraces = Integer.parseInt(arg.substring(13));
		} else if (arg.startsWith("--client_host=")) {
			clientHost = arg.substring(14);
		} else if (arg.startsWith("--context=")) {
			contextStr = arg.substring(10);
			isDefaultContext = false;
		} else if (arg.startsWith("--father_pid=")) {
			fatherPid = arg.substring(13);
		} else if (arg.startsWith("--root_pid=")) {
			rootPid = arg.substring(11);
		} else if (arg.startsWith("--father_node=")) {
			fatherNode = arg.substring(14);
		} else if (arg.startsWith("--pid=")) {
			pid = arg.substring(6);
		} else if (arg.startsWith("--context_type")) {
			String keyValue = arg.substring(15);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.setContextType(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1));
				}

			}

		} else if (arg.startsWith("--context_param")) {
			String keyValue = arg.substring(16);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1));
				}
			}
		} else if (arg.startsWith("--log4jLevel=")) {
			log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {// for trunjob call
			final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
	}

	private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

	private final String[][] escapeChars = { { "\\\\", "\\" }, { "\\n", "\n" }, { "\\'", "\'" }, { "\\r", "\r" },
			{ "\\f", "\f" }, { "\\b", "\b" }, { "\\t", "\t" } };

	private String replaceEscapeChars(String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0], currIndex);
				if (index >= 0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0],
							strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the
			// result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getStatus() {
		return status;
	}

	ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 * 99364 characters generated by Talend Open Studio for Data Integration on the
 * 7 mars 2024 à 15:04:38 WEST
 ************************************************************************************************/