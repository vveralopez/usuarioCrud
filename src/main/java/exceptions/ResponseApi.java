package exceptions;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class ResponseApi {

	public ResponseApi() {
	}

	public ResponseApi(Date timestamp, String message, int respondeCode, String status) {
		super();
		this.timestampS = timestamp;
		this.message = message;
		this.respondeCode = respondeCode;
		this.status = status;

	}

	private Date timestampS;
	private String message;
	private int respondeCode;
	private String status;

	public Date getTimestamp() {
		return timestampS;
	}

	public void setTimestamp(Date timestampS) {
		this.timestampS = timestampS;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getRespondeCode() {
		return respondeCode;
	}

	public void setRespondeCode(int respondeCode) {
		this.respondeCode = respondeCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
