package com.docsultant.asdp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class CountPairsTest
{

	@Test
	public void testPlain() throws Exception {
		int res = new CountPairs.TaskPlain().calc(Arrays.asList("aba", "aabb", "abcd", "bac", "aabc"));
		assertEquals(res, 2);

		res = new CountPairs.TaskPlain().calc(Arrays.asList("aabb","ab","ba"));
		assertEquals(res, 3);

		res = new CountPairs.TaskPlain().calc(Arrays.asList("nba","cba","dba"));
		assertEquals(res, 0);
	}

	@Test
	public void testStream1() throws Exception {
		int res = new CountPairs.TaskStream1().calc(Arrays.asList("aba", "aabb", "abcd", "bac", "aabc"));
		assertEquals(res, 2);

		res = new CountPairs.TaskStream1().calc(Arrays.asList("aabb","ab","ba"));
		assertEquals(res, 3);

		res = new CountPairs.TaskStream1().calc(Arrays.asList("nba","cba","dba"));
		assertEquals(res, 0);
	}

	@Test
	public void testStream2() throws Exception {
		int res = new CountPairs.TaskStream2().calc(Arrays.asList("aba", "aabb", "abcd", "bac", "aabc"));
		assertEquals(res, 2);

		res = new CountPairs.TaskStream2().calc(Arrays.asList("aabb","ab","ba"));
		assertEquals(res, 3);

		res = new CountPairs.TaskStream2().calc(Arrays.asList("nba","cba","dba"));
		assertEquals(res, 0);
	}

	@Test
	public void testParallel() throws Exception {
		int res = new CountPairs.TaskParallel().calc(Arrays.asList("aba", "aabb", "abcd", "bac", "aabc"));
		assertEquals(res, 2);

		res = new CountPairs.TaskParallel().calc(Arrays.asList("aabb","ab","ba"));
		assertEquals(res, 3);

		res = new CountPairs.TaskParallel().calc(Arrays.asList("nba","cba","dba"));
		assertEquals(res, 0);
	}


}