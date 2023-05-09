package com.docsultant.asdp;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class LeetCode2506
{
	public interface Task
	{
		int countPairs(List<String> lst) throws Exception;
	}

	public static class TaskPlain implements Task
	{
		@Override
		public int countPairs(List<String> lst) throws Exception
		{
			log.debug("countPairs(lst=...)");

			int res = 0;
			if( lst==null )
				return res;

			if( lst.size()<2 )
				return res;

			Map<Integer, Integer> map = new HashMap<>();
			for(String s:lst ) {
				if( s==null )
					continue;

				if( s.length()==0 )
					continue;

				int hash = 0;
				for(char ch:s.toCharArray()) {
					hash |= 1 << ((int)ch-(int)'a');
				}
				//log.debug(""+s+" = "+hash);
				int c = 1;
				if( map.containsKey(hash) )
					c += map.get(hash);

				map.put(hash, c);
			}

			for(int c : map.values()) {
				res += c * (c-1) / 2;
			}

			return res;
		}
	}

	public static void main(String[] args) throws Exception
	{
		Task t = new TaskPlain();
		t.countPairs(Arrays.asList("aba", "aabb", "abcd", "bac", "aabc"));
	}

}