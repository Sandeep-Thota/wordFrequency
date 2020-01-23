package com.words.wordfrequency;

import org.junit.Test;

public class FileWordTest {

	@Test
	public void noData() {
		/*
		 * If given No Data in the path file/linked path files would "DATA_NOT_FOUND"
		 * You can test this by passing any txt file without any data in it
		 */
	}

	@Test
	public void emptyPath() {
		/*
		 * If given an empty file with no path in it ,the output would
		 * "NO_PATH_INSIDE_FILE" You can test this by passing any txt file without any
		 * path in it as we are using Scanner to input data
		 */
	}

	@Test
	public void notValiedPath() {
		/*
		 * If given a not valid path ,the exception would "FileNotFoundException" You
		 * can test this by passing any txt file with any irregular data without path in
		 * it as we are using Scanner to input data
		 */
	}

}
