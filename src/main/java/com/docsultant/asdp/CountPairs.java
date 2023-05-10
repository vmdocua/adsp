package com.docsultant.asdp;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Slf4j
public class CountPairs
{
	public interface Task
	{
		int calc(List<String> lst) throws Exception;
	}

	public static class TaskPlain implements Task
	{
		@Override
		public int calc(List<String> lst) throws Exception
		{
			log.debug("calc(lst=...)");

			int res = 0;
			if( lst==null )
				return res;

			if( lst.size()<2 )
				return res;

			Map<Integer, Integer> map = new HashMap<>();
			for(String s:lst) {
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

	public static class TaskStream1 implements Task
	{
		@Override
		public int calc(List<String> lst) throws Exception
		{
			log.debug("calc(lst=...)");
			int res = 0;
			if( lst==null )
				return res;

			if( lst.size()<2 )
				return res;

			Map<Integer, Integer> map = new HashMap<>();
			lst.stream()
				.filter(s-> s!=null && s.length()>0 )
				.forEach(s -> {
					int hash = s.chars()
								.reduce(0, (v, ch) -> v |= 1 << ((int) ch - (int) 'a'));
					map.put(hash, map.computeIfAbsent(hash, k -> 0) + 1);
				});

			res = map.values().stream()
					.reduce(0, (n, c) -> n + c * (c-1) / 2 );

			return res;
		}
	}

	public record Tuple(String word, int hash) {}

	public static class TaskStream2 implements Task
	{
		@Override
		public int calc(List<String> lst) throws Exception
		{
			log.debug("calc(lst=...)");
			return (lst==null) ? 0 : lst.stream()
				.filter(s-> s!=null && s.length()>0 )
				.map( s -> new Tuple(s, s.chars()
						.reduce(0, (v, ch) -> v |= 1 << ((int) ch - (int) 'a'))))
				.collect(Collectors.groupingBy(Tuple::hash, Collectors.counting()))
				.values().stream().reduce(0L, (n, c) -> n + c * (c-1) / 2 ).intValue();
		}
	}

	public static void main(String[] args) throws Exception
	{
		Task t = new TaskPlain();
		int n = t.calc(Arrays.asList("aba", "aabb", "abcd", "bac", "aabc"));
		log.debug("plain, n="+n);

		t = new TaskStream1();
		n = t.calc(Arrays.asList("aba", "aabb", "abcd", "bac", "aabc"));
		log.debug("stream1, n="+n);

		t = new TaskStream2();
		n = t.calc(Arrays.asList("aba", "aabb", "abcd", "bac", "aabc"));
		log.debug("stream2, n="+n);
	}

}
