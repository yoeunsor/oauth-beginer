package com.sokkheang.huo.common.response;

public class ResponseList extends Response {

	private Object data;
	private Object error;
	private Object size;
	private Object statusCode;

	public ResponseList(String message, Object data, Object error, Object size, Object statusCode) {
		super(message);
		this.data = data;
		this.error = error;
		this.size = size;
		this.statusCode = statusCode;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getError() {
		return error;
	}

	public void setError(Object error) {
		this.error = error;
	}

	public Object getSize() {
		return size;
	}

	public void setSize(Object size) {
		this.size = size;
	}

	public Object getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Object statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		return "ResponseList{" +
				"data=" + data +
				", error=" + error +
				", size=" + size +
				", statusCode=" + statusCode +
				'}';
	}
}

