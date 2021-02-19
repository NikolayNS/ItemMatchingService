package com.dmitrenko.database.domain.task;

public enum TaskTypeEnum {
	DEFAULT("DEFAULT");

	private final String value;

	TaskTypeEnum(String value) {
		this.value = value;
	}

	public static TaskTypeEnum fromValue(String value) {
		for (TaskTypeEnum b : TaskTypeEnum.values()) {
			if (b.value.equals(value)) {
				return b;
			}
		}
		throw new IllegalArgumentException("Unexpected value '" + value + "'");
	}

	public String getValue() {
		return value;
	}
}
