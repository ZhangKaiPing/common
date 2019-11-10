package com.zkp.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class RandomUtilTest {

	@Test
	public void testRandom() {
		for (int i = 0; i < 100; i++) {
			
			System.out.println(RandomUtil.random(10, 20));
		}
	}

	@Test
	public void testSubRandom() {
	
		for (int i = 0; i < 10; i++) {
			int[] subRandom = RandomUtil.subRandom(1, 10, 3);
			for (int i1 : subRandom) {
				System.out.print(i1+" ");
			}
			System.out.println();
		}
		
	}

	@Test
	public void testRandomCharacter() {
		for (int i = 0; i < 100; i++) {
			char c=RandomUtil.randomCharacter();
			System.out.println(c);
		}
	}

	@Test
	public void testRandomString() {
		String string =RandomUtil.randomString(4);
		System.out.println(string);
	}

}
