package com.vl.test;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import com.vl.ms.Result;
import com.vl.ms.SuffixMatcher;

public class MatchTest {
	public static void main(String[] args) throws UnsupportedEncodingException {
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, "UTF-8"));
		
		SuffixMatcher matcher = new SuffixMatcher();
		matcher.addSuffix("室");
		matcher.addSuffix("舖");
		matcher.addSuffix("單位");
		matcher.addSuffix("鋪");
		matcher.addSuffix("複式單位");
		matcher.addSuffix("售物亭");
		matcher.addSuffix("Flat");
		
		Result result = matcher.match("123A單位");
		System.out.println(result.getContent());
		System.out.println(result.getSuffix());
	}
}
