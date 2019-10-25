package com.projectName.util;

public enum Screenshots {
	SS001 ("afterLogin"),
	SS002 ("beforeLogin"),
	SS003 ("afterMenu");

	private final String enumValue;

	Screenshots (String enumValue) {
		this.enumValue = enumValue;
	}

	@Override
	public String toString() {
		return this.enumValue;
	}

}